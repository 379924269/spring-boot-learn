package com.dnp.bootstarp.service.impl;

import com.dnp.bootstarp.common.exception.StorageException;
import com.dnp.bootstarp.common.exception.StorageFileNotFoundException;
import com.dnp.bootstarp.service.FileOperateService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * <p>
 * 文件操作实现
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-09
 */
@Service
public class FileOperateServiceImpl implements FileOperateService {
    private final Path rootLocation = Paths.get("upload-dir");

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (file.isEmpty()) {
            throw new StorageException("faile to store empty file" + fileName);
        }

        if (fileName.contains("..")) {
            throw new StorageException("Cannot store file with relative path outside current directory " + fileName);
        }
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new StorageException("faile to store  file" + fileName, e);
        }
    }

    @Override
    public Path load(String fileName) {
        return rootLocation.resolve(fileName);
    }

    @Override
    public Resource loadAsResource(String fileName) {
        Path file = load(fileName);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("could not read file : " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("could not read file : " + fileName, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
