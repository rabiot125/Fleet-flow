package com.fleet.fleetflow.dto;

import lombok.Data;

import java.util.List;

@Data
public class MilDto {
    private boolean milOn;
    private String lastUpdated;
    private List<QualifiedDtcDto> qualifiedDtcList;
    private BatteryDto battery;
}
