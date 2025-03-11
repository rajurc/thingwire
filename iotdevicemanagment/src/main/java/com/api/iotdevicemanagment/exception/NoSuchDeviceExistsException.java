package com.api.iotdevicemanagment.exception;

public class NoSuchDeviceExistsException extends RuntimeException {
    private String message;

    public NoSuchDeviceExistsException() {}

    public NoSuchDeviceExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
