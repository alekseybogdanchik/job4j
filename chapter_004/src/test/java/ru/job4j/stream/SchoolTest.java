package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    List<Student> students = List.of(
            new Student("Ivanov", 100),
            new Student("Petrov", 25),
            new Student("Sidorov", 55),
            new Student("Antonov", 45),
            new Student("Galkin", 85),
            new Student("Nikolaev", 50),
            new Student("Pushkin", 69),
            new Student("Andreev", 70),
            new Student("Shishkin", 1)
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

    @Test
    public void toMap() {
        School school = new School();
        Student ivanov = new Student("Ivanov", 100);
        Student petrov = new Student("Petrov", 25);
        List<Student> students = List.of(ivanov, petrov);
        Map<String, Student> result = school.listToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put(ivanov.getSurname(), ivanov);
        expected.put(petrov.getSurname(), petrov);
        assertThat(expected, is(result));
    }
}
