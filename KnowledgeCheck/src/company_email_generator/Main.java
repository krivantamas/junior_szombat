package company_email_generator;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/company_email_generator/nevek.txt"));

        List<String> names = new ArrayList<>();

        while (scanner.hasNextLine()) {
            names.add(scanner.nextLine());
        }

        List<String> emails = generateEmail(names);

        writeEmails(emails);

    }

    public static List<String> generateEmail(List<String> names) {

        Set<String> emails = new HashSet<>();

        for (String name : names) {

            String[] firstNameAndLastName = name.split(" ");

            String firstNamePart = firstNameAndLastName[0].substring(0, 3).toUpperCase();
            String lastNamePart = firstNameAndLastName[1].substring(0, 2).toLowerCase();

            String emailAddress = firstNamePart + "_" + lastNamePart + "@webler.hu";
            int id = 2;

            while (!emails.add(emailAddress)) {
                emailAddress = firstNamePart + "_" + lastNamePart + "_" + id + "@webler.hu";
                id++;
            }

        }

        return new ArrayList<>(emails);
    }

    public static void writeEmails(List<String> emails) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/company_email_generator/emails.txt")));

        for (String email : emails) {
            writer.write(email+"\n");
        }

        writer.close();

    }
}
