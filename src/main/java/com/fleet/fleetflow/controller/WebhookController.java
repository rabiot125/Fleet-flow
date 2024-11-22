package com.fleet.fleetflow.controller;

import com.fleet.fleetflow.dto.webhook.TripEventRequest;

import com.fleet.fleetflow.service.WebhookEventsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/webhook")
@Tag(name = "Bouncie Events Webhook")
public class WebhookController {
    private final WebhookEventsService eventsService;
    public WebhookController(WebhookEventsService eventsService) {
        this.eventsService = eventsService;
    }

    @Operation(summary = "Events endpoint")
    @PostMapping("/bouncie")
    public ResponseEntity<String> handleBouncieWebhook(@RequestBody TripEventRequest tripEvent,
                                                       @RequestHeader(value = "Authorization", required = false) String authorization) {
        // Validate the Authorization header
        if (authorization == null || !authorization.equals("")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Authorization Key");
        }

        log.info("Received Webhook Event : {}" , tripEvent);
        // Process the webhook payload

        eventsService.processTripEvent(tripEvent);

        return ResponseEntity.ok("Webhook received successfully");
    }

}
