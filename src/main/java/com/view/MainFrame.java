package com.view;

import com.model.Snake;

import javax.swing.*;

public class MainFrame extends JFrame {

    private GameField gameField;
    private MainMenu mainMenu;

    public MainFrame() {
        gameField = new GameField();
        add(gameField);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
    }

    public void setSnake(Snake snake) {
        gameField.setSnake(snake);
    }
}
