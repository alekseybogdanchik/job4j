package ru.job4j.tracker;

public class TrackerSingleHolder extends MemTracker {

    private TrackerSingleHolder() {
    }

    public static TrackerSingleHolder getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleHolder INSTANCE = new TrackerSingleHolder();
    }
}
