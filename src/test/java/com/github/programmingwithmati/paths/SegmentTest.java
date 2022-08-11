package com.github.programmingwithmati.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

    @Test
    void testDistance() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var segment = new Segment(point1, point2);

        var distance = segment.distance();

        assertEquals(BigDecimal.ONE, distance);
    }

    @Test
    void testConstructorWhenPointsAreNull() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);

        assertThrows(NullPointerException.class, () -> new Segment(point1, null));
        assertThrows(NullPointerException.class, () -> new Segment(null, point1));
    }

}
