package com.fleet.fleetflow.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleet.fleetflow.dto.UserDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class UserService {
    private final ObjectMapper objectMapper;

    public UserService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public UserDto getUserDetails() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.bouncie.dev/v1/user")
                .get()
                .addHeader("Authorization", "")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, UserDto.class);

            } else {
                throw new RuntimeException("Failed to get user details: " + response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to get user details", e);
        }

    }


}
