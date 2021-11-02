package com.controllers;

import com.exec.Main;
import com.model.Direction;
import com.model.Snake;
import com.view.MainFrame;
import sun.security.x509.CertAttrSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController {

    private Snake snake;
    private MainFrame mainFrame;

    public GameController(MainFrame mainFrame) {
        snake = new Snake(Color.MAGENTA);
        this.mainFrame = mainFrame;
        this.mainFrame.setSnake(snake);
    }

    public void start() {
        mainFrame.addKeyListener(new KeyAdapter() {
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
        Timer timer = new Timer(500, this::step);
        timer.start();
    }

    private void step(ActionEvent event) {
        snake.updateCords();
        mainFrame.repaint();
    }

}
