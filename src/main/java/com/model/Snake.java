package com.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeElement> snake;
    private Color color;
    public Direction direction;


    public Snake(Color color) {
        snake = new ArrayList<>();
        addElement(100, 100);
        addElement(100, 120);
        addElement(100, 140);

        this.color = color;
        this.direction = Direction.RIGHT;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addElement(int x, int y) {
        SnakeElement element = new SnakeElement(x, y);
        element.setColor(color);
        snake.add(element);
    }

    public void paintSnake(Graphics g) {
        for (SnakeElement element : snake) {
            element.paintElement(g);
        }
    }

    public void updateCords() {
        for (int i = snake.size() - 1; i > 0; --i) {
            snake.get(i).changeCords(snake.get(i - 1).getCords());
        }
        switch (direction) {
            case UP: snake.get(0).decY(); break;
            case DOWN: snake.get(0).incY(); break;
            case RIGHT: snake.get(0).incX(); break;
            case LEFT: snake.get(0).decX(); break;
        }
    }
 }
