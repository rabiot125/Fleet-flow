package com.fleet.fleetflow.dto;

import lombok.Data;

import java.util.List;

@Data
public class QualifiedDtcDto {
    private String code;
    private List<String> name;
}
