package tarsas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProjektGyakorloFeladatok\\src\\tarsas\\osvenyek.txt"));
        Scanner sc2 = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProjektGyakorloFeladatok\\src\\tarsas\\dobasok.txt"));
        List<String> osvenyek = new ArrayList<>();
        List<String> dobasok = new ArrayList<>();

        while (sc.hasNextLine()) {

            osvenyek.add(sc.nextLine());
        }
        while (sc2.hasNext()) {

            dobasok.add(sc2.next());
        }
        System.out.println("2. feladat");
        System.out.println("A dobások száma: " + dobasok.size());
        System.out.println("Az ösvények száma: " + osvenyek.size());

        int maxRoute = findMaxRoute(osvenyek);

        System.out.println("3. feladat");
        System.out.println("Az egyik leghosszabb osveny a " + (maxRoute + 1) + ". ösvény, hossza: " + osvenyek.get(maxRoute).length());


        System.out.println("4. feladat");
        Scanner sc_ = new Scanner(System.in);
        int routeIndex = 0;
        int playerCount = 0;

        System.out.println("Adja meg egy ösvény sorszámát!");
        routeIndex = sc_.nextInt();
        System.out.println("Adja meg a játékosok számát!");
        playerCount = sc_.nextInt();


        System.out.println("5. feladat");
        String selectedRoute = osvenyek.get(routeIndex - 1);

        System.out.println("M:" + selectedRoute.chars().filter(ch -> ch == 'M').count() + " darab");
        System.out.println("V:" + selectedRoute.chars().filter(ch -> ch == 'V').count() + " darab");
        System.out.println("E:" + selectedRoute.chars().filter(ch -> ch == 'E').count() + " darab");


        Map<Character, Integer> occurences = new HashMap<>();

        occurences.put('M', 0);
        occurences.put('V', 0);
        occurences.put('E', 0);

        for (char c : selectedRoute.toCharArray()) {
            occurences.put(c, occurences.get(c) + 1);
        }

        selectedRoute.chars().forEach(c -> occurences.put((char) c, occurences.get((char) c) + 1));


        Map<Character, Long> collect = selectedRoute.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //===================

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("kulonleges.txt")));

        for (int i = 0; i < selectedRoute.length(); i++) {

            if (selectedRoute.charAt(i) != 'M') {
                writer.write((i + 1) + "\t" + selectedRoute.charAt(i) + "\n");
            }
        }

        writer.close();


        int[] players = new int[playerCount];
        int throwIndex = 0;
        int rounds = 0;
        int winnerIndex = 0;
        while (throwIndex < dobasok.size() - 1) {
            for (int i = 0; i < playerCount; i++) {

                players[i] += Integer.parseInt(dobasok.get(throwIndex));
                if (players[i] >= selectedRoute.length()) {
                    winnerIndex = i;
                    throwIndex = dobasok.size();
                }
                throwIndex++;
            }
            rounds++;
        }


        System.out.println("7. feladat");
        System.out.println("A játék a(z) " + rounds + ". körben fejeződött be. A legtávolabb jutó(k) sorszáma: " + (winnerIndex + 1));


        players = new int[playerCount];
        throwIndex = 0;
        boolean valami = true;

        while ((throwIndex < dobasok.size() - 1) && valami) {
            for (int i = 0; i < playerCount; i++) {


                int roll = Integer.parseInt(dobasok.get(throwIndex));

                if (players[i] + roll > selectedRoute.length() - 1) {
                    players[i] += roll;
                    valami = false;
                    continue;
                }

                char c = selectedRoute.charAt(players[i] + roll - 1);

                switch (c) {
                    case 'M':
                        players[i] += roll;
                        break;
                    case 'V':
                        break;
                    case 'E':
                        players[i] += (2 * roll);
                        break;
                    default:
                        break;
                }

                throwIndex++;
            }
            rounds++;
        }

        int[] finalPlayers = players;

        System.out.println("8. feladat");
        System.out.print("Nyertes(ek): ");
        IntStream.range(0, players.length).filter(p -> finalPlayers[p] >= selectedRoute.length()).forEach(p -> {
            System.out.print((p + 1) + " ");
        });
        System.out.println();
        IntStream.range(0, players.length).filter(p -> finalPlayers[p] < selectedRoute.length()).forEach(p -> {
            System.out.println((p + 1) + ". játékos, " + finalPlayers[p] + ". mező");
        });


    }

    private static int findMaxRoute(List<String> routes) {

        return IntStream.range(0, routes.size()).reduce((a, b) -> routes.get(a).length() < routes.get(b).length() ? b : a).getAsInt();


    }

    private static int findMaxRoute_2(List<String> routes) {

        int maxLength = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).length() > maxLength) {
                maxLength = routes.get(i).length();
                maxIndex = i;
            }
        }

        return maxIndex;

    }
}