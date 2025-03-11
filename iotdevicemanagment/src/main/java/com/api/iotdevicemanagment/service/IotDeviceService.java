package com.api.iotdevicemanagment.service;

import com.api.iotdevicemanagment.model.IotDevices;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface IotDeviceService {

    IotDevices registerDevice(IotDevices iotDevices);

    IotDevices getDeviceById(UUID id);

    IotDevices updateDevice(IotDevices iotDevices, UUID id);

    void deleteDevice(UUID id);

    void updateDeviceStatus(UUID id, String status);
}
