package com.james.io.graph.deadlockdetection.model;

import java.util.List;

public class GraphVertex {
    public enum Color {
        GRAY, WHITE, BLACK;
    }

    public Color color;
    public List<GraphVertex> edges;

    public GraphVertex(List<GraphVertex> edges) {
        this(Color.WHITE, edges);
    }

    public GraphVertex(Color color, List<GraphVertex> edges) {
        this.color = color;
        this.edges = edges;
    }

}
