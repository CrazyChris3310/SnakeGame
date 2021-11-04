package com.model;

import com.view.MainFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {
    private List<SnakeElement> snake;
    private Color color;
    public Direction direction;


    public Snake(Color color) {
        snake = new ArrayList<>();
        this.color = color;
        this.direction = Direction.RIGHT;
        addElement(100, 100);
        addElement(100, 120);
        addElement(100, 140);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addElement(int x, int y) {
        SnakeElement element = new SnakeElement(x, y);
        element.setColor(color);
        snake.add(element);
    }

    public void grow() {
        int x = snake.get(snake.size() - 1).getX();
        int y = snake.get(snake.size() - 1).getY();

        switch (direction) {
            case UP: y -= 20; break;
            case DOWN: y += 20; break;
            case LEFT: x -= 20; break;
            case RIGHT: x += 20; break;
        }

        addElement(x, y);
        // FIXME: associate direction with an array of numbers to make addition easier
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
        SnakeElement head = snake.get(0);
        switch (direction) {
            case UP: head.decY(); break;
            case DOWN: head.incY(); break;
            case RIGHT: head.incX(); break;
            case LEFT: head.decX(); break;
        }

        if (head.getX() < 0)
            head.setX(MainFrame.WIDTH - SnakeElement.SIZE);
        else if (head.getX() >= MainFrame.WIDTH)
            head.setX(0);
        else if (head.getY() < 0)
            head.setY(MainFrame.HEIGHT - SnakeElement.SIZE);
        else if (head.getY() >= MainFrame.HEIGHT)
            head.setY(0);

    }

    public boolean intersects(int[] cords) {
        for (SnakeElement element : snake) {
            if (Arrays.equals(element.getCords(), cords))
                return true;
        }
        return false;
    }
 }
