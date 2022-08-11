package com.github.programmingwithmati.paths;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public record PathList(List<Path> paths) {

    public Optional<Path> shortestPath() {
        return paths.stream()
                .min(Comparator.comparing(Path::distance));
    }

    public Optional<Path> shortestPath(Point... points) {
        return paths.stream()
                .filter(path -> path.includes(points))
                .min(Comparator.comparing(Path::distance));
    }
}
