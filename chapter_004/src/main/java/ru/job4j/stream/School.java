package ru.job4j.stream;


import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().filter(predict).collect(Collectors.toList());
        return result;
    }

    public Map<String, Student> listToMap(List<Student> students) {
        Map<String, Student> result = students.stream().collect(
                Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e,
                        (e1, e2) -> e1
                ));
        return result;
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        List<Student> rsl = students.stream().
                flatMap(Stream::ofNullable).
                sorted().
                takeWhile(v -> v.getScore() > bound).
                collect(Collectors.toList());
        return rsl;
    }
}
