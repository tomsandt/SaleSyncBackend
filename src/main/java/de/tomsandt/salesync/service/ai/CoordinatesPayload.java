package de.tomsandt.salesync.service.ai;

import de.tomsandt.salesync.domain.ai.Coordinate;

import java.util.List;

public class CoordinatesPayload {
    private List<Coordinate> coordinates;

    public List<Coordinate> getCoordinates() { return coordinates; }
    public void setCoordinates(List<Coordinate> coords) { this.coordinates = coords; }
}
