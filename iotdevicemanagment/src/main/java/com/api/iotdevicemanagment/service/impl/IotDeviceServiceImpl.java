package com.api.iotdevicemanagment.service.impl;

import com.api.iotdevicemanagment.exception.DeviceAlreadyExistsException;
import com.api.iotdevicemanagment.exception.NoSuchDeviceExistsException;
import com.api.iotdevicemanagment.model.DeviceStatus;
import com.api.iotdevicemanagment.model.IotDevices;
import com.api.iotdevicemanagment.repository.IotDeviceRepository;
import com.api.iotdevicemanagment.service.IotDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class IotDeviceServiceImpl implements IotDeviceService {

    @Autowired
    private IotDeviceRepository iotDeviceRepository;


    @Override
    public IotDevices registerDevice(IotDevices iotDevices) {

       // IotDevices existingDevice = iotDeviceRepository.findById(iotDevices.getId()).orElse(null);

        //if(existingDevice!=null ){
        //    throw new DeviceAlreadyExistsException("DEVICE ALREADY EXISTS WITH ID = " + iotDevices.getId());
        //}else{
            return iotDeviceRepository.save(iotDevices);
        //}
    }

    @Override
    public IotDevices getDeviceById(UUID id){
        Optional<IotDevices> iotDevicesOptional =  iotDeviceRepository.findById(id);
        if(iotDevicesOptional.isPresent()) {
            return iotDevicesOptional.get();
        }else {
            throw new NoSuchDeviceExistsException("NO DEVICE PRESENT WITH ID = " + id);
        }
    }

    @Override
    public IotDevices updateDevice(IotDevices iotDevices, UUID id){
        IotDevices existingDevice = iotDeviceRepository.findById(id).orElseThrow(
                NoSuchDeviceExistsException::new
        );

        existingDevice.setDeviceName(iotDevices.getDeviceName());
        existingDevice.setStatus(iotDevices.getStatus());
        existingDevice.setMetadata(iotDevices.getMetadata());
        existingDevice.setLastSeen(iotDevices.getLastSeen());

        // save
        iotDeviceRepository.save(existingDevice);
        return existingDevice;
    }

    @Override
    public void deleteDevice(UUID id){
        //check
        iotDeviceRepository.findById(id).orElseThrow(NoSuchDeviceExistsException::new);
        //delete
        iotDeviceRepository.deleteById(id);
    }

    @Override
    public void updateDeviceStatus(UUID id, String status){
        IotDevices existingDevice = iotDeviceRepository.findById(id).orElseThrow(
                NoSuchDeviceExistsException::new
        );
        //update
        existingDevice.setStatus(DeviceStatus.valueOf(status));
        // save
        iotDeviceRepository.save(existingDevice);

    }
}
