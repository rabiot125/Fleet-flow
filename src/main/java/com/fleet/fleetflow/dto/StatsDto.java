package com.fleet.fleetflow.dto;

import lombok.Data;

@Data
public class StatsDto {
    private String localTimeZone;
    private int odometer;
    private String lastUpdated;
    private LocationDto location;
    private int fuelLevel;
    private boolean isRunning;
    private int speed;
    private MilDto mil;
}
