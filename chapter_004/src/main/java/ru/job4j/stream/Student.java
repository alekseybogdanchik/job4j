package ru.job4j.stream;

public class Student implements Comparable<Student> {
    private String surname;
    private int score;

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, score);
    }

    @Override
    public String toString() {
        return "Student{"
                + "surname= '" + surname + '\''
                + ", score=" + score + '}';
    }
}
