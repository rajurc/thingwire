package com.api.iotdevicemanagment.exception;

import com.api.iotdevicemanagment.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchDeviceExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody com.api.iotdevicemanagment.model.ErrorResponse handleException(NoSuchDeviceExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = DeviceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody com.api.iotdevicemanagment.model.ErrorResponse handleException(DeviceAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
}
