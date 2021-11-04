package com.view;

import com.controllers.GameController;
import com.model.Food;
import com.model.Snake;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GameField gameField;
    private MainMenu mainMenu;
    private CardLayout cardLayout;
    private GameController controller;

    private static final String MENU_PANEL = "Panel with menus";
    private static final String GAME_FIELD = "Game field";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public MainFrame() {
        gameField = new GameField();
        mainMenu = new MainMenu(this);
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);
        getContentPane().add(gameField, GAME_FIELD);
        getContentPane().add(mainMenu, MENU_PANEL);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(WIDTH, HEIGHT);
        pack();
        setResizable(false);
    }

    public void init() {
        cardLayout.show(this.getContentPane(), MENU_PANEL);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void startGame() {
        cardLayout.show(this.getContentPane(), GAME_FIELD);
        requestFocus();
        controller.startGame();
    }

    public void setSnake(Snake snake) {
        gameField.setSnake(snake);
    }

    public void setFood(Food food) {
        gameField.setFood(food);
    }
}
