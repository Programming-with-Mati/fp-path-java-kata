package com.github.programmingwithmati.paths;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public record Point(BigDecimal x, BigDecimal y) {

    public Point(BigDecimal x, BigDecimal y) {
        this.x = Objects.requireNonNullElse(x, BigDecimal.ZERO);
        this.y = Objects.requireNonNullElse(y, BigDecimal.ZERO);
    }
    public BigDecimal distance(Point other) {
        var other2 = Objects.requireNonNullElse(other, new Point(BigDecimal.ZERO, BigDecimal.ZERO));
        return this.x.subtract(other2.x).pow(2).add(this.y.subtract(other2.y).pow(2)).sqrt(MathContext.DECIMAL64);
    }
}
