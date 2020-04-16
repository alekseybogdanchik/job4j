package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits().stream()
                        .map(unit -> new Holder(unit, student.getName()))
                ).collect(
                        Collectors.groupingBy(holder -> holder.key,
                                Collectors.mapping(holder -> holder.value,
                                        Collectors.toSet()))
                );
    }

    static class Holder {
    String key;
    String value;

    Holder(String key, String value) {
        this.key = key;
        this.value = value;
        }
    }
}
