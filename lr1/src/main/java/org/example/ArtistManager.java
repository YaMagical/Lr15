package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArtistManager {
    public static void removeLowRated(List<Artist> artists) {
        Iterator<Artist> iterator = artists.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAverageRating() < 3.0) {
                iterator.remove();
            }
        }
    }

    public static void promoteHighRated(List<Artist> artists) {
        for (Artist artist : artists) {
            if (artist.getAverageRating() >= 4.0) {
                artist.setRank(artist.getRank() + 1);
            }
        }
    }

    public static void printArtists(List<Artist> artists, int rank) {
        for (Artist artist : artists) {
            if (artist.getRank() == rank) {
                System.out.println(artist);
            }
        }
    }

    public static void sortAndPrint(List<Artist> artists) {
        List<Artist> sorted = new ArrayList<>(artists);
        sorted.sort(Comparator.comparingDouble(Artist::getAverageRating).reversed()
                .thenComparing(Artist::getName));

        for (Artist artist : sorted) {
            System.out.printf("ID: %d | Name: %s | Avg Rating: %.2f%n",
                    artist.getId(), artist.getName(), artist.getAverageRating());
        }
    }
}