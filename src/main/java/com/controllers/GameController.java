package com.controllers;

import com.model.Direction;
import com.model.Food;
import com.model.Snake;
import com.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController {

    private Snake snake;
    private MainFrame mainFrame;
    private Food food;
    private Timer timer;

    public GameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        this.mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: snake.setDirection(Direction.UP); break;
                    case KeyEvent.VK_DOWN: snake.setDirection(Direction.DOWN); break;
                    case KeyEvent.VK_RIGHT: snake.setDirection(Direction.RIGHT); break;
                    case KeyEvent.VK_LEFT: snake.setDirection(Direction.LEFT); break;
                }
            }
        });

    }

    public void startGame() {
        snake = new Snake(Color.GREEN);
        food = new Food();
        mainFrame.setSnake(snake);
        mainFrame.setFood(food);
        timer = new Timer(60, this::step);
        timer.start();
    }

    private void step(ActionEvent event) {
        if (snake.intersects(food.getCords())) {
            food.newCords();
            snake.grow();
        }
        if (snake.intersectsItself()) {
            timer.stop();
            mainFrame.showMenu();
            mainFrame.setScore(snake.getSize());
        }
        snake.updateCords();
        mainFrame.repaint();
    }

}
