package com.fleet.fleetflow.repository;

import com.fleet.fleetflow.model.VehicleSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleScheduleRepository extends JpaRepository<VehicleSchedule,Long> {
}
