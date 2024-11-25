package com.fleet.fleetflow.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
public class TwilioConfiguration {
    @Value("${twilio.account_sid}")
    private  String accountSID;
    @Value("${twilio.auth_token}")
    private  String authToken;
    @Value("${twilio.phone_number}")
    private String phoneNumber;

}
