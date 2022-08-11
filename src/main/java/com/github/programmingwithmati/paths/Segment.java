package com.github.programmingwithmati.paths;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Stream;

public record Segment(Point point1, Point point2) {

    public Segment(Point point1, Point point2) {
        this.point1 = Objects.requireNonNull(point1);
        this.point2 = Objects.requireNonNull(point2);
    }
    public BigDecimal distance() {
        return point1.distance(point2);
    }

    public Stream<Point> pointsStream() {
        return Stream.of(point1(), point2());
    }
}
