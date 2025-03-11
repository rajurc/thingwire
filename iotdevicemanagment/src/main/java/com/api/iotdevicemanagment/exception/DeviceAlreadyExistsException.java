package com.api.iotdevicemanagment.exception;

public class DeviceAlreadyExistsException  extends RuntimeException {
    private String message;

    public DeviceAlreadyExistsException() {}

    public DeviceAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
