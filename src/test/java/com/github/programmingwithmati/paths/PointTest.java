package com.github.programmingwithmati.paths;

import com.github.programmingwithmati.paths.Point;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testDistance() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);
        var point2 = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

        var distance = point1.distance(point2);

        assertEquals(BigDecimal.ONE, distance);
    }

    @Test
    void testDistanceWhenPoint2IsNull() {
        var point1 = new Point(BigDecimal.ONE, BigDecimal.ZERO);

        var distance = point1.distance(null);

        assertEquals(BigDecimal.ONE, distance);
    }

    @Test
    void testDistanceWhenPointInitialValuesAreNull() {
        var point1 = new Point(null, null);

        assertEquals(BigDecimal.ZERO, point1.x());
        assertEquals(BigDecimal.ZERO, point1.y());
    }
}
