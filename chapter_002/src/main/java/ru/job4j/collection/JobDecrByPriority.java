package ru.job4j.sort;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobDecrByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}