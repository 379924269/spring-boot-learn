package com.dnp.bootstarp.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * <p>
 * 文件操作
 * </p>
 *
 * @author huazai
 * @since 2017-08-09
 */
public interface FileOperateService {

    void init();

    void store(MultipartFile file);

    Path load(String fileName);

    Resource loadAsResource(String fileName);

    void deleteAll();
}
