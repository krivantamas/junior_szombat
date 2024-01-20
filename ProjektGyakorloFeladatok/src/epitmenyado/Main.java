package epitmenyado;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class RealEstate {
        int taxNumber;
        String street;
        String houseNumber;
        String category;
        int area;

        public RealEstate(int taxNumber, String street, String houseNumber, String category, int area) {
            this.taxNumber = taxNumber;
            this.street = street;
            this.houseNumber = houseNumber;
            this.category = category;
            this.area = area;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProjektGyakorloFeladatok\\src\\epitmenyado\\utca.txt"));
        List<RealEstate> realEstates = new ArrayList<>();

        int ATax = 0;
        int BTax = 0;
        int CTax = 0;

        String[] taxes = sc.nextLine().split(" ");

        ATax = Integer.parseInt(taxes[0]);
        BTax = Integer.parseInt(taxes[1]);
        CTax = Integer.parseInt(taxes[2]);

        while (sc.hasNextLine()) {

            String[] realEstateInfo = sc.nextLine().split(" ");
            realEstates.add(new RealEstate(
                    Integer.parseInt(realEstateInfo[0]),
                    realEstateInfo[1],
                    realEstateInfo[2],
                    realEstateInfo[3],
                    Integer.parseInt(realEstateInfo[4])
            ));
        }

        System.out.println("2. feladat. A mintában " + realEstates.size() + " telek szerepel.\n");

        Scanner sc_ = new Scanner(System.in);
        System.out.println("3. feladat. Egy tulajdonos adószáma: ");

        int number = sc_.nextInt();

        List<RealEstate> estates = realEstates.stream().filter(realEstate -> realEstate.taxNumber == number).toList();

        if (estates.isEmpty()) {
            System.err.println("Nem szerepel az adatállományban.");
        } else {
            for (RealEstate estate : estates) {
                System.out.println(estate.street + " utca " + estate.houseNumber);
            }
        }

        Map<String, List<RealEstate>> collect = realEstates.stream().collect(Collectors.groupingBy(realEstate -> realEstate.category, Collectors.toList()));


        int finalATax = ATax;
        System.out.println("A sávba " + collect.get("A").size() + " telek esik, az adó " + collect.get("A").stream().mapToInt(r -> r.area * finalATax >= 10000 ? r.area * finalATax : 0).sum() + " Ft.");
        int finalBTax = BTax;
        System.out.println("B sávba " + collect.get("B").size() + " telek esik, az adó " + collect.get("B").stream().mapToInt(r -> r.area * finalBTax >= 10000 ? r.area * finalBTax : 0).sum() + " Ft.");
        int finalCTax = CTax;
        System.out.println("C sávba " + collect.get("C").size() + " telek esik, az adó " + collect.get("C").stream().mapToInt(r -> r.area * finalCTax >= 10000 ? r.area * finalCTax : 0).sum() + " Ft.");

        Map<String, List<RealEstate>> collect1 = realEstates.stream().collect(Collectors.groupingBy(realEstate -> realEstate.street, Collectors.toList()));

        System.out.println("6. feladat. A több sávba sorolt utcák:");
        collect1.entrySet().stream().filter(entry -> {
            List<String> categories = entry.getValue().stream().map(v -> v.category).distinct().toList();

            return categories.size() > 1;
        }).map(entry -> entry.getKey()).toList().stream().forEach(System.out::println);

        System.out.println();

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("fizetendo.txt")));


        realEstates.stream().collect(Collectors.groupingBy(realEstate -> realEstate.taxNumber, Collectors.summingInt(r -> {
            int tax = 0;
            switch (r.category) {
                case "A":
                    tax = finalATax;
                    break;
                case "B":
                    tax = finalBTax;
                    break;
                case "C":
                    tax = finalCTax;
                    break;
            }

            return r.area * tax >= 10000 ? r.area * tax : 0;
        }))).entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).forEach(e -> {
            try {
                writer.write(e.getKey() + " - "+ e.getValue()+"\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        writer.close();

        System.out.println();

    }
}