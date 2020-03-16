package ru.job4j.collection;

import ru.job4j.sort.JobDecrByPriority;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {

        List<Job> jobsToCombineSort = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobsToCombineSort, new JobDecrByName().thenComparing(new JobDecrByPriority()));
        System.out.println(jobsToCombineSort);

        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparingInt(Job::getPriority);
        Comparator<Job> combine = compareName.thenComparing(comparePriority);

        jobsToCombineSort.sort(combine);
    }
}
