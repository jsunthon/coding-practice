package com.james.io.graph.regioncolor;

import com.james.io.graph.model.Mark;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ColorEnclosedRegionSolutionTest {

    @Test
    public void testColorOkRegionInner() {
        List<List<Mark>> graph = new ArrayList<>();
        graph.add(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.W, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.B, Mark.W, Mark.W, Mark.B).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()));

        ColorEnclosedRegionSolution colorEnclosedRegionSolution = new ColorEnclosedRegionSolution(graph);
        colorEnclosedRegionSolution.color();

        assertEquals(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(0));
        assertEquals(Stream.of(Mark.W, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(1));
        assertEquals(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(2));
        assertEquals(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(3));
    }

    @Test
    public void testColorNoBoundary() {
        List<List<Mark>> graph = new ArrayList<>();
        graph.add(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.B, Mark.W, Mark.W, Mark.B).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()));

        ColorEnclosedRegionSolution colorEnclosedRegionSolution = new ColorEnclosedRegionSolution(graph);
        colorEnclosedRegionSolution.color();

        assertEquals(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(0));
        assertEquals(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(1));
        assertEquals(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(2));
        assertEquals(Stream.of(Mark.B, Mark.B, Mark.B, Mark.B).collect(Collectors.toList()), graph.get(3));
    }

    @Test
    public void testColorAllBoundaryNoEnclosedRegion() {
        List<List<Mark>> graph = new ArrayList<>();
        graph.add(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.W, Mark.B, Mark.B, Mark.W).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.W, Mark.B, Mark.B, Mark.W).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()));

        ColorEnclosedRegionSolution colorEnclosedRegionSolution = new ColorEnclosedRegionSolution(graph);
        colorEnclosedRegionSolution.color();

        assertEquals(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()), graph.get(0));
        assertEquals(Stream.of(Mark.W, Mark.B, Mark.B, Mark.W).collect(Collectors.toList()), graph.get(1));
        assertEquals(Stream.of(Mark.W, Mark.B, Mark.B, Mark.W).collect(Collectors.toList()), graph.get(2));
        assertEquals(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()), graph.get(3));
    }

    @Test
    public void testColorAllBoundaryNoEnclosedRegionAllWhite() {
        List<List<Mark>> graph = new ArrayList<>();
        graph.add(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()));
        graph.add(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()));

        ColorEnclosedRegionSolution colorEnclosedRegionSolution = new ColorEnclosedRegionSolution(graph);
        colorEnclosedRegionSolution.color();

        assertEquals(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()), graph.get(0));
        assertEquals(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()), graph.get(1));
        assertEquals(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()), graph.get(2));
        assertEquals(Stream.of(Mark.W, Mark.W, Mark.W, Mark.W).collect(Collectors.toList()), graph.get(3));
    }

    @Test
    public void testColorEmptyGraph() {
        List<List<Mark>> graph = new ArrayList<>();

        ColorEnclosedRegionSolution colorEnclosedRegionSolution = new ColorEnclosedRegionSolution(graph);
        colorEnclosedRegionSolution.color();
    }
}
