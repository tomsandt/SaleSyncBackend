package de.tomsandt.salesync.controller;

import de.tomsandt.salesync.service.ai.CoordinatesPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins =  "*")
public class AIController {

    @PostMapping("/coordinates")
    public ResponseEntity<String> receive(@RequestBody CoordinatesPayload payload) {
        System.out.println("Received: " + payload.getCoordinates());
        return ResponseEntity.ok("OK");
    }
}