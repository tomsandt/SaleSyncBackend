package de.tomsandt.salesync.controller;

import de.tomsandt.salesync.service.ai.CoordinatesPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins =  "*")
public class AIController {

    @PostMapping("/coordinates")
    public ResponseEntity<String> receive(@RequestBody CoordinatesPayload payload) {
        System.out.println("Received: " + payload.getCoordinates());
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/coordinates")
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "Coordinates API is up"));
    }
}