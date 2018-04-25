package com.dnp.bootstarp.common.exception;

/**
 * 自定义存储文件不存在异常
 *
 * @author 华仔
 * @date 2018/4/25 10:18
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}