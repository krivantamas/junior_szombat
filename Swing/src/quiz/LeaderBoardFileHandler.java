package quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaderBoardFileHandler {

	private static final String LEADERBOARD_CSV_HEADERS = "username,score";

	public static List<User> loadLeaderBoardCsv(File file) throws IOException {

		createLeaderBoardCSVIfNotExistOrEmpty(file);

		Scanner scanner = new Scanner(file);
		String row = scanner.nextLine();
		List<User> users = new ArrayList<>();

		while (scanner.hasNextLine()) {

			row = scanner.nextLine();
			String[] values = row.split(",");
			users.add(new User(values[0], Integer.parseInt(values[1])));
		}

		return users;
	}

	private static boolean createLeaderBoardCSVIfNotExistOrEmpty(File file) throws IOException {

		if (!file.exists()) {
			file.createNewFile();
		}
		Scanner scanner = new Scanner(file);
		if (!scanner.hasNextLine()) {
			FileWriter csvWriter = new FileWriter(file);
			csvWriter.write(LEADERBOARD_CSV_HEADERS + "\n");
			csvWriter.close();
		}

		return file.exists();

	}

	public static boolean appendLeaderBoardCsv(File file, User user) throws IOException {
		
		if(!file.exists()) {
			throw new FileNotFoundException();
		}
		
		BufferedWriter userWriter = new BufferedWriter(new FileWriter(file,true));
		userWriter.write(user.getUserName()+","+user.getScore());
		userWriter.newLine();
		userWriter.close();
		
		
		
		return true;
		
	}

}
