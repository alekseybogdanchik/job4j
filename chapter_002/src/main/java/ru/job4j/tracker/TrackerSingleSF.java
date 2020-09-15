package ru.job4j.tracker;

public class TrackerSingleSF extends MemTracker {

    private static TrackerSingleSF instance;

    private TrackerSingleSF() {
    }

    public static TrackerSingleSF getInstance() {
        if (instance == null) {
            instance = new TrackerSingleSF();
        }
        return instance;
    }
}
