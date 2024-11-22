package com.fleet.fleetflow.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "trip_events")
public class TripEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventType;
    private String imei;
    private String vin;
    private String transactionId;

    // Start fields
    private String startTimestamp;
    private String startTimeZone;
    private Long startOdometer;
    // End fields
    private String endTimestamp;
    private String endTimeZone;
    private Long endOdometer;
    private BigDecimal endFuelConsumed;

}
