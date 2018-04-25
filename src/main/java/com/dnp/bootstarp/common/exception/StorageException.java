package com.dnp.bootstarp.common.exception;

/**
 * 自定义文件存储异常
 *
 * @author 华仔
 * @date 2018/4/25 10:17
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}