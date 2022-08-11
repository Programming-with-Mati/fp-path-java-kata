package com.github.programmingwithmati.paths;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.function.Predicate.isEqual;

public record Path(List<Segment> segments) {

    public BigDecimal distance() {
        return segments.stream()
                .map(Segment::distance)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public boolean includes(Point... points) {
        var pointList = Set.of(points);
        var pointsCount = segments.stream()
                .flatMap(Segment::pointsStream)
                .filter(pointList::contains)
                .distinct()
                .count();
        return pointsCount == pointList.size();
    }
}
