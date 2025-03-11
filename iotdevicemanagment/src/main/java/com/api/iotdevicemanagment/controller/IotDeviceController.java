package com.api.iotdevicemanagment.controller;

import com.api.iotdevicemanagment.kafka.service.KafkaProducerService;
import com.api.iotdevicemanagment.model.IotDevices;
import com.api.iotdevicemanagment.service.IotDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/iot-device")

public class IotDeviceController {


    @Autowired
    private IotDeviceService iotDeviceService;

    //@Autowired
    //private KafkaProducerService kafkaProducerService;

    @Value("${kafka.event.topic.name}")
    private  String eventTopic;

    @Value("${kafka.command.topic.name}")
    private  String commandTopic;



    @PostMapping("/devices")
    public ResponseEntity<IotDevices> saveEmployee(@RequestBody IotDevices iotDevices){
        //kafkaProducerService.sendMessage(eventTopic,  "device_registered");
        return new ResponseEntity<IotDevices>(iotDeviceService.registerDevice(iotDevices), HttpStatus.CREATED);

    }

    @PostMapping("/devices/{id}/send-command")
    public String sendDeviceCommand(){
        //kafkaProducerService.sendMessage(commandTopic,  "device_command");
        return "Device Command published successfully";

    }


    //Get by Id Rest Api
    @GetMapping("/devices/{id}")
    public ResponseEntity<IotDevices> getDeviceById(@PathVariable("id") UUID iotDeviceID){
        return new ResponseEntity<IotDevices>(iotDeviceService.getDeviceById(iotDeviceID), HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping(path = "/devices/{id}")
    public ResponseEntity<IotDevices> updateDevice(@RequestBody IotDevices iotDevices, @PathVariable("id") UUID iotDeviceID){
        return new ResponseEntity<IotDevices>(iotDeviceService.updateDevice(iotDevices, iotDeviceID), HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping(path = "/devices/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") UUID iotDeviceID){
        iotDeviceService.deleteDevice(iotDeviceID);
        return new ResponseEntity<String>("Device Deleted Successfully", HttpStatus.OK);
    }

}
