package com.fleet.fleetflow.controller;


import com.fleet.fleetflow.model.VehicleSchedule;
import com.fleet.fleetflow.service.VehicleScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Vehicle Schedule" ,description = "Operations pertaining to fleet schedules")
public class VehicleScheduleController {
    private final VehicleScheduleService scheduleService;
    public VehicleScheduleController(VehicleScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<VehicleSchedule> createSchedule(@RequestBody VehicleSchedule schedule) {
        VehicleSchedule savedSchedule = scheduleService.createSchedule(schedule);
        //  schedulerService.scheduleNotification(savedSchedule);
        return ResponseEntity.ok(savedSchedule);
    }
    @GetMapping
    public ResponseEntity<List<VehicleSchedule>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleSchedule> getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<VehicleSchedule> updateSchedule(@PathVariable Long id, @RequestBody VehicleSchedule updatedSchedule) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, updatedSchedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
