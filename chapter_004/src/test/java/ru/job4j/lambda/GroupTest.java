package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GroupTest {
    @Test
    public void studentGroup() {
        List<Student> students = List.of(
                new Student("Ivanov", Set.of("music", "football")),
                new Student("Petrov", Set.of("chess", "football")),
                new Student("Sidorov", Set.of("chess", "music"))
        );
        Map<String, Set<String>> result = Group.sections(students);
        System.out.println(result);
        Set<String> expected = Set.of("Ivanov", "Sidorov");
        assertThat(result.get("music"), is(expected));
    }
}