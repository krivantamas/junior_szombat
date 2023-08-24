package company_email_generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		try {
			List<Person> people = readPeople(new File("C:\\_Projects\\School\\Java_Zsolttal\\junior_szombat\\KnowledgeCheck\\src\\company_email_generator\\names.txt"));
			String[] emails = new String[people.size()];
			for (int i = 0; i < emails.length; i++) {
				String generatedEmail = generateEmail(people.get(i));
				if(Arrays.stream(emails).anyMatch(generatedEmail::equals)) {
					String[] email = generatedEmail.split("@");
					generatedEmail = email[0] + "_2@" + email[1];
				}
				emails[i] = generatedEmail;
			}
			for(String email : emails) {
				System.out.println(email);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static List<Person> readPeople(File file) throws FileNotFoundException{
		List<Person> people = new LinkedList<>();
		Scanner sc = new Scanner(file);		
		while(sc.hasNextLine()) {
			String[] row = sc.nextLine().split(" ");
			people.add(new Person(row[0], row[1]));
		}
		sc.close();
		return people;
	}
	
	public static String generateEmail(Person person) {		
		String emailAddress = "";
		emailAddress += person.getFirstName().substring(0,3).toUpperCase();
		emailAddress += "_";
		emailAddress += person.getLastName().substring(0,2).toLowerCase();
		emailAddress += "@webler.hu";		
		return emailAddress;
	}

}
