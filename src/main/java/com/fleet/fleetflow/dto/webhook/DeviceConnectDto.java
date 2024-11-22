package com.fleet.fleetflow.dto.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeviceConnectDto {
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("imei")
    private String imei;
    @JsonProperty("vin")
    private String vin;
    @JsonProperty("connect")
    private ConnectData connect;
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
}
