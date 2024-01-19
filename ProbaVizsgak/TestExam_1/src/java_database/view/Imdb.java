package java_database.view;

import java_database.controller.ImdbController;
import java_database.model.MovieDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Imdb extends JFrame {

    private JPanel contentPane;
    private final ImdbController controller;

    public Imdb(ImdbController controller) {
        this.controller = controller;
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JButton listMovies = new JButton("List Movies");
        listMovies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.listMovies();
            }
        });
        contentPane.add(listMovies);

        JButton listCategories = new JButton("List Categories");
        listCategories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.listCategories();
            }
        });
        contentPane.add(listCategories);

        JButton movieAddButton = new JButton("Add new movie");
        movieAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException();
            }
        });
        contentPane.add(movieAddButton);
    }

    protected void addMovie(MovieDao movieDao) {
        controller.addMovie(movieDao);

    }

}

