package com.api.iotdevicemanagment.repository;

import com.api.iotdevicemanagment.model.IotDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface  IotDeviceRepository extends JpaRepository<IotDevices, UUID> {

}
