package com.fleet.fleetflow.dto.webhook;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripStartRequest {
    @NotBlank(message = "Event type is required")
    private String eventType;
    @NotBlank(message = "IMEI is required")
    private String imei;
    @NotBlank(message = "VIN is required")
    private String vin;
    @NotBlank(message = "Transaction ID is required")
    private String transactionId;
    @NotNull(message = "Start event data is required")
    private StartEvent start;
    public static class StartEvent {
        @NotNull(message = "Timestamp is required")
        private ZonedDateTime timestamp;
        @NotBlank(message = "Time zone is required")
        private String timeZone;
        @NotNull(message = "Odometer reading is required")
        private Double odometer;
    }
}
