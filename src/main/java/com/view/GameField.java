package com.view;

import com.model.Snake;
import com.model.SnakeElement;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    private Snake snake;

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.paintSnake(g);
    }




}
