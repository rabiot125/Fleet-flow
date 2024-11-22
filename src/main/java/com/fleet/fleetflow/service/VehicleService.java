package com.fleet.fleetflow.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleet.fleetflow.dto.VehicleDto;
import com.fleet.fleetflow.dto.VehicleRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper;

    public List<VehicleDto> getVehicleDetails(VehicleRequestDto vehicleRequestDto) throws IOException {

       // OkHttpClient client = new OkHttpClient();

        // Encode query parameters
        String imei = URLEncoder.encode(vehicleRequestDto.getImei(), StandardCharsets.UTF_8);
        String vin = URLEncoder.encode(vehicleRequestDto.getVin(), StandardCharsets.UTF_8);

        // Start building the URL
        StringBuilder urlBuilder = new StringBuilder("https://api.bouncie.dev/v1/vehicles?");
        urlBuilder.append("imei=").append(imei).append("&vin=").append(vin);

        // Append optional parameters only if they are non-null
        if (vehicleRequestDto.getLimit() != null) {
            urlBuilder.append("&limit=").append(vehicleRequestDto.getLimit());
        }
        if (vehicleRequestDto.getSkip() != null) {
            urlBuilder.append("&skip=").append(vehicleRequestDto.getSkip());
        }

        String url = urlBuilder.toString();

      log.info("Generated Url : {}",url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Authorization", "")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                return objectMapper.readValue(responseBody, new TypeReference<List<VehicleDto>>() {});

            } else {
                throw new RuntimeException("Failed to get Vehicle details: " + response.message());
            }

        }

    }
}
