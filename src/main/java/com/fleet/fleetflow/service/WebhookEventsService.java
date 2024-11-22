package com.fleet.fleetflow.service;

import com.fleet.fleetflow.dto.webhook.TripEventRequest;
import com.fleet.fleetflow.model.TripEvent;
import com.fleet.fleetflow.repository.TripEventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebhookEventsService {
    private final TripEventRepository tripEventRepository;
    public WebhookEventsService(TripEventRepository tripEventRepository) {
        this.tripEventRepository = tripEventRepository;
    }

    public void processTripEvent(TripEventRequest tripEventRequest) {
        // Check if a trip event with the same transactionId already exists
        Optional<TripEvent> existingEvent = tripEventRepository.findByTransactionId(tripEventRequest.getTransactionId());

        if (existingEvent.isPresent()) {
            System.out.println("Duplicate event detected. Skipping save for transactionId: " + tripEventRequest.getTransactionId());
            return;
        }

        // Save new trip event to the database
        TripEvent entity = mapToEntity(tripEventRequest);
        tripEventRepository.save(entity);
        System.out.println("Trip event saved successfully: " + tripEventRequest.getTransactionId());
    }
    private TripEvent mapToEntity(TripEventRequest tripEventRequest) {
        TripEvent entity = new TripEvent();
        entity.setEventType(tripEventRequest.getEventType());
        entity.setImei(tripEventRequest.getImei());
        entity.setVin(tripEventRequest.getVin());
        entity.setTransactionId(tripEventRequest.getTransactionId());

        if (tripEventRequest.getStart() != null) {
            entity.setStartTimestamp(tripEventRequest.getStart().getTimestamp());
            entity.setStartTimeZone(tripEventRequest.getStart().getTimeZone());
            entity.setStartOdometer(tripEventRequest.getStart().getOdometer());
        }
        if (tripEventRequest.getEnd() != null) {
            entity.setEndTimestamp(tripEventRequest.getEnd().getTimestamp());
            entity.setEndTimeZone(tripEventRequest.getEnd().getTimeZone());
            entity.setEndOdometer(tripEventRequest.getEnd().getOdometer());
            entity.setEndFuelConsumed(tripEventRequest.getEnd().getFuelConsumed());
        }
        return entity;
    }
}
