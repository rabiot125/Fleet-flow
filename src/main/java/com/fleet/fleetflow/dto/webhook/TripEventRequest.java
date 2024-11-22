package com.fleet.fleetflow.dto.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Tag(name = "Trip Event DTO",description = "Webhook Events Dto")
public class TripEventRequest {
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("imei")
    private String imei;
    @JsonProperty("vin")
    private String vin;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("connect")
    private ConnectData connect;
    @JsonProperty("start")
    private Start start;
    @JsonProperty("end")
    private End end;
    @Data
    public static class ConnectData {
        @JsonProperty("timestamp")
        private String timestamp;
        @JsonProperty("timeZone")
        private String timeZone;
        @JsonProperty("latitude")
        private double latitude;
        @JsonProperty("longitude")
        private double longitude;
    }
    @Data
    public static class Start {
        @JsonProperty("timestamp")
        private String timestamp;
        @JsonProperty("timeZone")
        private String timeZone;
        @JsonProperty("odometer")
        private Long odometer;
    }
    @Data
    public static class End {
        @JsonProperty("timestamp")
        private String timestamp;
        @JsonProperty("timeZone")
        private String timeZone;
        private Long odometer;
        private BigDecimal fuelConsumed;
    }
}
