package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[] args) throws IOException {

		setLookAndFeel();

		// loadQuestions();

		QuizMainController controller = new QuizMainController(new QuizMainView(), new File("src/leaderboard_2.csv"));

		// System.out.println(LeaderBoardFileHandler.loadLeaderBoardCsv(new
		// File("src/leaderboard.csv")));
		
		//LeaderBoardFileHandler.appendLeaderBoardCsv(new File("src/leaderboard_2.csv"), new User("Zsolt",2));

	}

	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}

}
