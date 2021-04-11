package com.rickmune.dsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class HotelReviews {

    public static void main(String[] args) {
        ArrayList<String> query = new ArrayList<>(Arrays.asList("good", "shit"));
        Map<Integer, List<String>> reviews = new HashMap<>();
        reviews.put(1, new ArrayList<>(Arrays.asList("good", "great", "awesome", "good")));
        reviews.put(2, new ArrayList<>(Arrays.asList("nasty", "shit", "disgusting")));
        reviews.put(3, new ArrayList<>(Arrays.asList("moderate", "good")));

        sortListOfReviews(query, reviews);

    }

    private static void sortListOfReviews(List<String> words, Map<Integer, List<String>> reviews) {

        List<String> query = new ArrayList<>(words);
        TreeSet<Rating> charts = new TreeSet<>();

        for (Map.Entry<Integer, List<String>> e : reviews.entrySet()) {
            List<String> review = new ArrayList<>(e.getValue());

            review.retainAll(query);
            charts.add(new Rating(e.getKey(), review.size()));
        }

        System.out.println("HotelReviews.sortListOfReviews");
        for (Rating r : charts) {
            System.out.print(r.id + " ("+r.rating+") ");
        }
    }

    static class Rating implements Comparable {
        int id;
        int rating;

        Rating(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }

        @Override
        public int compareTo( Object o) {
            return 2 * Integer.compare(((Rating) o).rating, this.rating) + Integer.compare(this.id, ((Rating) o).id);
        }
    }
}
