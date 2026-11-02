package org.example;

import org.example.Artist;
import org.example.ArtistManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Artist> artists = new ArrayList<>(Arrays.asList(
                new Artist(1, "Ivan", "Rock", 1, Arrays.asList(5, 4, 5, 3)),
                new Artist(2, "Anna", "Pop", 2, Arrays.asList(2, 2, 1)),
                new Artist(3, "Oleg", "Jazz", 1, Arrays.asList(4, 4, 5, 4)),
                new Artist(4, "Elena", "Rock", 3, Arrays.asList(3, 3, 3, 3)),
                new Artist(5, "Dmitry", "Pop", 2, Arrays.asList(5, 5, 5, 5)),
                new Artist(6, "Svetlana", "Jazz", 1, Arrays.asList(1, 2, 1))
        ));

        System.out.println("Изначальный список:");
        for (Artist a : artists) System.out.println(a);

        ArtistManager.removeLowRated(artists);
        System.out.println("\nПосле удаления артистов с рейтингом < 3:");
        for (Artist a : artists) System.out.println(a);

        ArtistManager.promoteHighRated(artists);
        System.out.println("\nПосле повышения ранга артистам с рейтингом >= 4:");
        for (Artist a : artists) System.out.println(a);

        System.out.println("\nАртисты с рангом 2:");
        ArtistManager.printArtists(artists, 2);

        System.out.println("\nОтсортированный список:");
        ArtistManager.sortAndPrint(artists);
    }
}