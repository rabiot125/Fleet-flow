package com.fleet.fleetflow.service;

import com.fleet.fleetflow.model.VehicleSchedule;
import com.fleet.fleetflow.repository.VehicleScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleScheduleService {
    private final VehicleScheduleRepository repository;

    public VehicleScheduleService(VehicleScheduleRepository repository) {
        this.repository = repository;
    }

    public VehicleSchedule createSchedule(VehicleSchedule schedule) {
        return repository.save(schedule);
    }

    public List<VehicleSchedule> getAllSchedules() {
        return repository.findAll();
    }

    public Optional<VehicleSchedule> getScheduleById(Long id) {
        return repository.findById(id);
    }

    public VehicleSchedule updateSchedule(Long id, VehicleSchedule updatedSchedule) {
        return repository.findById(id).map(schedule -> {
            schedule.setVehicleId(updatedSchedule.getVehicleId());
            schedule.setClientId(updatedSchedule.getClientId());
            schedule.setStartTime(updatedSchedule.getStartTime());
            schedule.setEndTime(updatedSchedule.getEndTime());
            schedule.setStatus(updatedSchedule.getStatus());
            return repository.save(schedule);
        }).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public void deleteSchedule(Long id) {
        repository.deleteById(id);
    }
}
