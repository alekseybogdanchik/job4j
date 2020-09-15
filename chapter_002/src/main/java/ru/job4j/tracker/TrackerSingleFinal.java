package ru.job4j.tracker;

public class TrackerSingleFinal extends MemTracker {

    private static final TrackerSingleFinal INSTANCE = new TrackerSingleFinal();

    private TrackerSingleFinal() {
    }

    public static TrackerSingleFinal getInstance() {
        return INSTANCE;
    }
}
