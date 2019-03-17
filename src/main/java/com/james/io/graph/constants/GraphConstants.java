package com.james.io.graph.constants;


import com.james.io.graph.model.Coordinate;
import com.james.io.graph.model.Direction;

public final class GraphConstants {
    public static final Coordinate[] SHIFTS = new Coordinate[]{Direction.LEFT.getShift(),
            Direction.RIGHT.getShift(),
            Direction.UP.getShift(),
            Direction.DOWN.getShift()};

    private GraphConstants() {
    }
}
