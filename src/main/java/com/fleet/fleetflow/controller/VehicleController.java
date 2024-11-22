package com.fleet.fleetflow.controller;

import com.fleet.fleetflow.dto.VehicleDto;
import com.fleet.fleetflow.dto.VehicleRequestDto;
import com.fleet.fleetflow.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/fleet")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleDto>>getVehicleDetails(@RequestBody @Valid VehicleRequestDto vehicleRequestDto) throws IOException {
        return  ResponseEntity.ok(vehicleService.getVehicleDetails(vehicleRequestDto));
    }
}
