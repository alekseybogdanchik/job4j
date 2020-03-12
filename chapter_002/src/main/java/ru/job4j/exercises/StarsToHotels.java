package ru.job4j.exercises;


import java.util.*;

public class StarsToHotels {
    private List<Hotel> hotels = new ArrayList<Hotel>();

    public List<Integer> addStars(List<Integer> ratingList, int n) {
        for (int index = 1; index <= ratingList.size(); index++) {
            hotels.add(new Hotel(index, ratingList.get(index - 1)));
        }
        Collections.sort(hotels, new HotelsAscByRating());
        int starsNums = n / 5;
        Hotel[][] setStars = new Hotel[5][starsNums];
        int sortedHotel = 0;
        for (int i = 0; i < setStars.length; i++) {
            for (int j = 0; j < starsNums; j++) {
                hotels.get(sortedHotel).setStars(i + 1);
                sortedHotel++;
            }
        }
        Comparator<Hotel> cmpNum = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel left, Hotel right) {
                return left.getNumber() - right.getNumber();
            }
        };
        Collections.sort(hotels, cmpNum);
        List<Integer> starsList = new ArrayList<Integer>();
        for (Hotel hotel : hotels) {
            starsList.add(hotel.getStars());
        }
    return starsList;
    }
}
