package com.fleet.fleetflow.controller;

import com.fleet.fleetflow.dto.webhook.DeviceConnectDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
    @PostMapping("/bouncie")
    public ResponseEntity<String> handleBouncieWebhook(@RequestBody DeviceConnectDto deviceConnectDto
                                                       /*@RequestHeader(value = "Authorization", required = false) String authorization*/) {
        // Process the webhook payload
        System.out.println("Received Webhook Event: " + deviceConnectDto);


        return ResponseEntity.ok("Webhook received successfully");
    }

}
