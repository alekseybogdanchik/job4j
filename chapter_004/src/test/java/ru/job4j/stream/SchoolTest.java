package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    List<Student> students = List.of(
            new Student(100),
            new Student(25),
            new Student(55),
            new Student(45),
            new Student(85),
            new Student(50),
            new Student(69),
            new Student(70),
            new Student(1)
    );

    @Test
    public void studentsForA() {
        School school = new School();
        List<Student> toAClass = school.collect(students, student -> student.getScore() >= 70);
        List<Integer> expected = Arrays.asList(100, 85, 70);
        List<Integer> result = new ArrayList<>();
        for (Student s : toAClass) {
             result.add(s.getScore());
        }
        assertThat(expected, is(result));
    }

    @Test
    public void studentsForB() {
        School school = new School();
        List<Student> toBClass = school.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Integer> expected = Arrays.asList(55, 50, 69);
        List<Integer> result = new ArrayList<>();
        for (Student s : toBClass) {
             result.add(s.getScore());
        }
        assertThat(expected, is(result));
    }

    @Test
    public void studentsForC() {
        School school = new School();
        List<Student> toCClass = school.collect(students, student -> student.getScore() < 50);
        List<Integer> expected = Arrays.asList(25, 45, 1);
        List<Integer> result = new ArrayList<>();
        for (Student s : toCClass) {
             result.add(s.getScore());
        }
        assertThat(expected, is(result));
    }
}