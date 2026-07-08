package com.example.demo.dto;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
public class ShortenRequest {
    @NotBlank(message = "URL cannot be blank")
    @URL(message = "Must be a valid, properly formatted URL (e.g., https://google.com)")
    private String originalUrl;
    public String getOriginalUrl() { return originalUrl; }
    public void setOriginalUrl(String originalUrl) { this.originalUrl = originalUrl; }
}
