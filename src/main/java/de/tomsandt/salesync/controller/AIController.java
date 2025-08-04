package de.tomsandt.salesync.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.tomsandt.salesync.domain.ai.Coordinate;
import de.tomsandt.salesync.service.ai.CoordinatesPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins =  "*")
public class AIController {

    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/coordinates")
    public ResponseEntity<String> receiveCoordinates(@RequestBody CoordinatesPayload payload) {
        for (Coordinate c : payload.getCoordinates()) {
            System.out.printf(
                    "Coordinate: label=%s, x=%d, y=%d, width=%d, height=%d%n",
                    c.getLabel(), c.getX(), c.getY(), c.getWidth(), c.getHeight()
            );
        }
        return ResponseEntity.ok("OK");
    }

    @GetMapping
    public ResponseEntity<String> receiveViaGet(
            @RequestParam("coordinates") String encodedJson
    ) {
        try {
            // 1. URL-decode
            String json = URLDecoder.decode(encodedJson, StandardCharsets.UTF_8);
            // 2. in DTO parsen
            CoordinatesPayload payload = mapper.readValue(json, CoordinatesPayload.class);
            List<Coordinate> coords = payload.getCoordinates();
            // 3. ausgeben
            for (Coordinate c : coords) {
                System.out.printf("Coordinate: label=%s, x=%d, y=%d, width=%d, height=%d%n",
                        c.getLabel(), c.getX(), c.getY(), c.getWidth(), c.getHeight());
            }
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body("Invalid coordinates payload: " + e.getMessage());
        }
    }
}