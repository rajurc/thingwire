package com.api.iotdevicemanagment.kafka.service;

import com.api.iotdevicemanagment.service.IotDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.UUID;

//@Service
public class KafkaConsumerService {

    @Autowired
    private IotDeviceService iotDeviceService;

    @KafkaListener(topics = "thingwire.devices.responses", groupId = "my-group")
    public void listen(UUID deviceId, String deviceStatus) {

        iotDeviceService.updateDeviceStatus(deviceId,deviceStatus);
        //Todo: Print the below lines to an application log file with logging configuration which can be provided in the application.properties file
        System.out.println("Received Message: " + deviceId + " - " + deviceStatus);
        System.out.println("Message Received and device status updated");
    }
}
