package com.fleet.fleetflow.controller;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final String clientId = "";
    private final String clientSecret = "";
    private final String redirectUri = "http://localhost:8080/auth/callback";
    private final String AUTH_URL = "https://auth.bouncie.com/dialog/authorize";
    private final String TOKEN_URL = "https://auth.bouncie.com/oauth/token";

    @PostMapping("/login")
    public ResponseEntity<Void> redirectToBouncie() {
        String url = String.format(
                "%s?client_id=%s&response_type=code&redirect_uri=%s",
                AUTH_URL, clientId, redirectUri
        );
        return ResponseEntity.status(HttpStatus.FOUND).
                header("Location", url).build();
    }

    @PostMapping("/callback")
    public ResponseEntity<String> handleCallback(@RequestParam("code") String authorizationCode) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String jsonBody = String.format(
                "{\"client_id\":\"%s\", \"client_secret\":\"%s\", \"grant_type\":\"authorization_code\", \"code\":\"%s\", \"redirect_uri\":\"%s\"}",
                clientId, clientSecret, authorizationCode, redirectUri
        );

        okhttp3.RequestBody body = okhttp3.RequestBody.create(
                jsonBody, MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(TOKEN_URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return ResponseEntity.status(response.code()).body("Failed to fetch access token");
            }
            String responseBody = response.body().string();
            return ResponseEntity.ok(responseBody);
        }
    }
}