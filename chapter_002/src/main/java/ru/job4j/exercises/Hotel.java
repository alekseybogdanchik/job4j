package ru.job4j.exercises;


public class Hotel {
    private int number;
    private int rating;
    private int stars;

    public Hotel(int number, int rating) {
        this.number = number;
        this.rating = rating;
    }

    public int getNumber() {
        return number;
    }

    public int getRating() {
        return rating;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
