package com.github.programmingwithmati.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    void testDistanceWhenNoSegments() {
        var path = new Path(Collections.emptyList());

        assertEquals(BigDecimal.ZERO, path.distance());
    }

    @Test
    void testDistanceWhenOneSegment() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var segment = new Segment(point1, point2);

        var path = new Path(List.of(segment));

        assertEquals(BigDecimal.ONE, path.distance());
    }

    @Test
    void testDistanceWhenTwoSegment() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var segment1 = new Segment(point1, point2);

        var point3 = new Point(BigDecimal.ONE.add(BigDecimal.ONE), BigDecimal.ZERO);
        var point4 = new Point(BigDecimal.ZERO, BigDecimal.TEN);

        var segment2 = new Segment(point3, point4);

        var path = new Path(List.of(segment1, segment2));

        assertEquals(segment1.distance().add(segment2.distance()), path.distance());
    }
}
