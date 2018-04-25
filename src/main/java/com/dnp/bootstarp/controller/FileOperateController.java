package

        com.dnp.bootstarp.controller;

import com.dnp.bootstarp.common.page.PageVo;
import com.dnp.bootstarp.model.Config;
import com.dnp.bootstarp.service.ConfigService;
import com.dnp.bootstarp.service.FileOperateService;
import com.dnp.bootstarp.service.OperateLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 文件操作
 * </p>
 *
 * @author huazai
 * @since 2017-08-09
 */
@Api(value = "FileOperateController", description = "文件操作")
@RestController
@RequestMapping(value = "")
public class FileOperateController {
    @Autowired
    private FileOperateService fileOperateService;

    @GetMapping("/file/{filename:.+}")
    @ApiOperation(value = "下载文件")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileOperateService.loadAsResource(filename);
        try {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + URLEncoder.encode(file.getFilename(), "utf-8") + "\"").body(file);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    @PostMapping("/file/uploadeFile")
    @ApiOperation(value = "上传文件")
    public String uploadeFile(@RequestParam("file") MultipartFile file) {
        fileOperateService.init();
        fileOperateService.store(file);
        return "OK";
    }

    @PostMapping("/file/batchUploadeFile")
    @ApiOperation(value = "批量上传文件")
    public String batchUploadeFile(HttpServletRequest request, @RequestParam("files") MultipartFile[] files) {
        fileOperateService.init();
        List<MultipartFile> filesList = ((MultipartHttpServletRequest) request).getFiles("file");
        for (int i = 0; i < filesList.size(); i++) {
            fileOperateService.store(filesList.get(i));
        }
        return "OK";
    }
}
