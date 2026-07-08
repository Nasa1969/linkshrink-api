package com.example.demo.controller;
import com.example.demo.dto.ShortenRequest;
import com.example.demo.model.Link;
import com.example.demo.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Map;
import java.util.Optional;
@RestController
public class LinkController {
    private final LinkService linkService;
    public LinkController(LinkService linkService) { this.linkService = linkService; }
    @PostMapping("/api/shorten")
    public ResponseEntity<?> shortenUrl(@Valid @RequestBody ShortenRequest request) {
        String shortCode = linkService.shortenUrl(request.getOriginalUrl());
        String shortenedUrl = "http://localhost:8081/" + shortCode; 
        return ResponseEntity.ok(Map.of("shortenedUrl", shortenedUrl));
    }
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        Optional<Link> linkOptional = linkService.getOriginalUrl(shortCode);
        if (linkOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(linkOptional.get().getOriginalUrl())).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
