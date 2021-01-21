package com.app.vehicle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.vehicle.entity.VehicleRole;

@Repository
public interface VehicleRoleRepository extends CrudRepository<VehicleRole, Integer>{

}
