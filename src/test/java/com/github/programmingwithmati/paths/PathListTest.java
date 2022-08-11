package com.github.programmingwithmati.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PathListTest {

    @Test
    void testShortestPathWhenNoPaths() {
        var pathList = new PathList(Collections.emptyList());
        assertTrue(pathList.shortestPath().isEmpty());
    }

    @Test
    void testShortestPathOnePath() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var segment = new Segment(point1, point2);

        var path = new Path(List.of(segment));

        var pathList = new PathList(List.of(path));

        var actualPath = pathList.shortestPath();
        assertTrue(actualPath.isPresent());
        assertEquals(segment.distance(), actualPath.get().distance());
    }

    @Test
    void testShortestPathTwoPaths() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var segment1 = new Segment(point1, point2);

        var path1 = new Path(List.of(segment1));

        var point3 = new Point(BigDecimal.TEN, BigDecimal.ZERO);
        var point4 = new Point(BigDecimal.ZERO, BigDecimal.TEN);

        var segment2 = new Segment(point3, point4);

        var path2 = new Path(List.of(segment2));

        var pathList = new PathList(List.of(path2, path1));

        var actualPath = pathList.shortestPath();
        assertTrue(actualPath.isPresent());
        assertEquals(path1.distance(), actualPath.get().distance());
    }

    @Test
    void testShortestPathOnePathWhenPointIsNotPresent() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);
        var point3 = new Point(BigDecimal.TEN, BigDecimal.ZERO);

        var segment = new Segment(point1, point2);

        var path = new Path(List.of(segment));

        var pathList = new PathList(List.of(path));

        var actualPath = pathList.shortestPath(point3);
        assertTrue(actualPath.isEmpty());
    }

    @Test
    void testShortestPathOnePathWhenPointIsPresent() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var segment = new Segment(point1, point2);

        var path = new Path(List.of(segment));

        var pathList = new PathList(List.of(path));

        var actualPath = pathList.shortestPath(point2);
        assertTrue(actualPath.isPresent());
    }

    @Test
    void testShortestPathOnePathWhenTwoPointsArePresent() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var segment = new Segment(point1, point2);

        var path = new Path(List.of(segment));

        var pathList = new PathList(List.of(path));

        var actualPath = pathList.shortestPath(point2, point1);
        assertTrue(actualPath.isPresent());
    }

    @Test
    void testShortestPathOnePathWhenTwoPointsAndPointsAreRepeated() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);
        var point3 = new Point(BigDecimal.TEN, BigDecimal.ZERO);

        var segment1 = new Segment(point1, point2);
        var segment2 = new Segment(point2, point3);

        var path = new Path(List.of(segment1, segment2));

        var pathList = new PathList(List.of(path));

        var actualPath = pathList.shortestPath(point2, point1);
        assertTrue(actualPath.isPresent());
    }


}
