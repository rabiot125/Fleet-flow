package com.fleet.fleetflow.dto;

import lombok.Data;

@Data
public class VehicleDto {
    private ModelDto model;
    private String nickName;
    private String standardEngine;
    private String vin;
    private String imei;
    private StatsDto stats;
}
