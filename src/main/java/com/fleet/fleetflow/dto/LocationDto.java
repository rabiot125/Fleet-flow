package com.fleet.fleetflow.dto;

import lombok.Data;

@Data
public class LocationDto {
    private double lat;
    private double lon;
    private int heading;
    private String address;
}
