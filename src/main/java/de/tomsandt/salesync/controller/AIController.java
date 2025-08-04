package de.tomsandt.salesync.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.tomsandt.salesync.domain.ai.Coordinate;
import de.tomsandt.salesync.service.ai.CoordinatesPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

    @GetMapping("/coordinates")
    public ResponseEntity<String> receiveViaGet(
            @RequestParam("coordinates") String encodedJson
    ) {
        try {
            String json = URLDecoder.decode(encodedJson, StandardCharsets.UTF_8);
            CoordinatesPayload payload = mapper.readValue(json, CoordinatesPayload.class);
            List<Coordinate> coords = payload.getCoordinates();
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