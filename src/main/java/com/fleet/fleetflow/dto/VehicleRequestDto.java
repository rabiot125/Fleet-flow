package com.fleet.fleetflow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Tag(name = "Vehicle Details Dto",description = "Dto to fetch vehicle details")
public class VehicleRequestDto {
    @NotNull(message = "Imei is mandatory")
    private String imei;
    private Long limit;
    private Long skip;
    @NotNull(message = "Vin is mandatory")
    private String vin;
}
