package de.tomsandt.salesync.controller;

import de.tomsandt.salesync.domain.ai.Coordinate;
import de.tomsandt.salesync.service.ai.CoordinatesPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins =  "*")
public class AIController {

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
}