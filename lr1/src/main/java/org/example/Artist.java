package org.example;

import java.util.List;

public class Artist {
    private int id;
    private String name;
    private String genre;
    private int rank;
    private List<Integer> fanRatings;

    public Artist(int id, String name, String genre, int rank, List<Integer> fanRatings) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.rank = rank;
        this.fanRatings = fanRatings;
    }

    public double getAverageRating() {
        if (fanRatings == null || fanRatings.isEmpty()) return 0.0;
        int sum = 0;
        for (int r : fanRatings) {
            sum += r;
        }
        return (double) sum / fanRatings.size();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }
    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }
    public List<Integer> getFanRatings() { return fanRatings; }

    @Override
    public String toString() {
        return "Artist{id=" + id + ", name='" + name + "', genre='" + genre + "', rank=" + rank + "}";
    }
}