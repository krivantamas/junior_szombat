package streams.radio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String... args) {
        Map<Integer, Radio> radioMap = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\FunctionalProgramming\\src\\streams\\radio\\musor.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(" ", 4);
                String[] singerAndTitle = values[3].split(":");

                int radioId = Integer.parseInt(values[0]);
                int min = Integer.parseInt(values[1]);
                int sec = Integer.parseInt(values[2]);
                String singer = singerAndTitle[0];
                String title = singerAndTitle[1];

                if (!radioMap.containsKey(radioId)) {
                    radioMap.put(radioId, new Radio(radioId));
                }

                Radio radio = radioMap.get(radioId);
                radio.addSong(new Zeneszam(min, sec, singer, title));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        radioMap.entrySet().stream().forEach(radio -> {

            System.out.println(radio.getKey() + " - On air time: " + onAirTimeInMin(radio.getValue()));
            System.out.println(radio.getKey() + " - Track count: " + trackCount(radio.getValue()));
            System.out.println(radio.getKey() + " - Longest track: " + longestTrack(radio.getValue()));
            System.out.println(radio.getKey() + " - Shortest track: " + shortestTrack(radio.getValue()));
            System.out.println(radio.getKey() + " - Current track: " + currentTrack(radio.getValue(), 12, 30));
            System.out.println(radio.getKey() + " - AC/DC tracks: " + trackBySinger(radio.getValue(), "AC/DC"));
            System.out.println("===");
        });

        System.out.println();
    }


    private static int onAirTimeInMin(Radio radio) {
        return radio.getSongs().stream().mapToInt(Zeneszam::getTrackLengthInSec).sum() / 60;
    }

    private static int trackCount(Radio radio) {
        return radio.getSongs().size();
    }

    private static Zeneszam longestTrack(Radio radio) {
        return radio.getSongs()
                .stream()
                .max(Comparator.comparingInt(Zeneszam::getTrackLengthInSec))
                .orElseThrow(NoSuchElementException::new);
    }

    private static Zeneszam shortestTrack(Radio radio) {
        return radio.getSongs()
                .stream()
                .min(Comparator.comparingInt(Zeneszam::getTrackLengthInSec))
                .orElseThrow(NoSuchElementException::new);
    }

    private static Zeneszam currentTrack(Radio radio, int hour, int minute) {

        int sec = hour * 3600 + minute * 60;
        int sumMusicLength = 0;

        for (Zeneszam zeneszam : radio.getSongs()) {
            int trackLengthInSec = zeneszam.getTrackLengthInSec();
            sumMusicLength += trackLengthInSec;
            if (sumMusicLength > sec) {
                return zeneszam;
            }
        }
        return null;
    }

    private static List<Zeneszam> trackBySinger(Radio radio, String singer) {
        return radio.getSongs().stream().filter(song -> song.getSinger().equals(singer)).toList();
    }

}
