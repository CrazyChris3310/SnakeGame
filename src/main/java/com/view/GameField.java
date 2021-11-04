package com.view;

import com.model.Food;
import com.model.Snake;
import com.model.SnakeElement;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    private Snake snake;
    private Food food;

    public GameField() {
        setSize(MainFrame.WIDTH, MainFrame.HEIGHT);
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        food.paint(g);
        snake.paintSnake(g);
    }

}
