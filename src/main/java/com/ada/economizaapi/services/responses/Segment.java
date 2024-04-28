package com.ada.economizaapi.services.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class Segment {
    private Double distance;

    @JsonCreator
    public Segment(Double distance) {
        this.distance = distance;
    }

    public Double getDistance() {
        return distance;
    }
}