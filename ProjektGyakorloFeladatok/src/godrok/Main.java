package godrok;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProjektGyakorloFeladatok\\src\\godrok\\melyseg.txt"));
        List<Integer> depths = new ArrayList<>();

        while (scanner.hasNextLine()) {
            depths.add(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println();
        System.out.println("1. feladat\n" +
                "A fájl adatainak száma: " + depths.size());

        Scanner scanner_ = new Scanner(System.in);
        System.out.print("2. feladat\nAdjon meg egy távolságértéket! ");
        int index = scanner_.nextInt();
        System.out.println("Ezen a helyen a felszín " + depths.get(index - 1) + " méter mélyen van.");


        long digCount = depths.stream().filter(d -> d > 0).count();
        System.out.printf("3. feladat\n" +
                "Az érintetlen terület aránya %.2f. %\n", 100 - ((digCount * 1.0) / depths.size() * 100));


        List<List<Integer>> holes = new ArrayList<>();
        List<Integer> hole = null;

        int[] holeIndexMap = new int[depths.size()];

        for (int i = 0; i < depths.size(); ) {

            if (depths.get(i) != 0) {

                hole = new ArrayList<>();

                while (depths.get(i) != 0) {
                    hole.add(depths.get(i));
                    holeIndexMap[i] = holes.size();
                    i++;
                }

                holes.add(hole);
            }
            holeIndexMap[i] = -1;
            i++;

        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("godrok.txt")));


        for (List<Integer> hole_ : holes) {

            StringJoiner joiner = new StringJoiner(" ");
            for (int d : hole_) {

                joiner.add(d + "");
            }
            writer.write(joiner.toString() + "\n");
        }

        writer.close();

        System.out.println("5. feladat\n" +
                "A gödrök száma: " + holes.size());


        System.out.println("6. feladat");

        if (holeIndexMap[index] == -1) {
            System.out.println("Az adott helyen nincs gödör.");
            return;
        }


        List<Integer> selectedHole = holes.get(holeIndexMap[index]);


        int holeStart = 0;
        for (int i = index; ; i--) {

            if (depths.get(i) == 0) {
                holeStart = i + 2;
                break;
            }

        }

        System.out.println("a)\n\tA gödör kezdete: " + holeStart + " méter, a gödör vége: " + (holeStart + selectedHole.size() - 1) + " méter.");


        int[] left = new int[selectedHole.size() - 1];
        for (int i = 0; i < selectedHole.size() - 1; i++) {
            left[i] = selectedHole.get(i) - selectedHole.get(i + 1);
        }


        boolean findElevation = false;
        boolean isMonoton = true;

        for (int i = 0; i < left.length; i++) {

            if (left[i] > 0) {
                findElevation = true;
            }
            if (left[i] < 0 && findElevation) {
                isMonoton = false;
                break;
            }

        }

        if(isMonoton){
            System.out.println("b)\n\tFolyamatosan mélyül.");
        }else{
            System.out.println("b)\n\tNem mélyül folyamatosan.");
        }

        System.out.println("c)\n\tA legnagyobb mélysége " + selectedHole.stream().max(Integer::compareTo).get() + " méter.");

        System.out.println("d)\n\tA térfogata " + (selectedHole.stream().mapToInt(Integer::intValue).sum() * 10) + " m^3.");
        System.out.println("e)\n\tA vízmennyiség " + (selectedHole.stream().mapToInt(value -> value - 1).sum() * 10) + " m^3.");

    }
}