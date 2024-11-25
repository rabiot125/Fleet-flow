package com.fleet.fleetflow.service;

import com.fleet.fleetflow.config.TwilioConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsService {
    private final TwilioConfiguration twilioConfiguration;
    public static final String ACCOUNT_SID = "";
    //            System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = "";
    //        System.getenv("TWILIO_AUTH_TOKEN");
    public SmsService(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new com.twilio.type.PhoneNumber("phone"),
                        new com.twilio.type.PhoneNumber("phone"),
                        "Where's Wallace?")
                .create();

        System.out.println(message.getBody());
    }
}

