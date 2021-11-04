package com.model;

import com.utils.Functions;
import com.view.MainFrame;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Snake {
    private List<SnakeElement> snake;
    private Color color;
    public Direction direction;


    public Snake(Color color) {
        snake = new ArrayList<>();
        this.color = color;
        this.direction = Functions.getRandomDirection();
        createHead();
        grow();
        grow();
    }

    public void createHead() {
        int[] cords = Functions.randomCoordinate();
        SnakeElement head = new SnakeElement(cords[0], cords[1]);
        head.setColor(color);
        head.setDirection(direction);
        snake.add(head);
    }

    public int getSize() {
        return snake.size();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addElement(int x, int y) {
        SnakeElement element = new SnakeElement(x, y);
        element.setColor(color);
        element.setDirection(snake.get(0).getDirection());
        snake.add(element);
    }

    public void grow() {
        int x = snake.get(snake.size() - 1).getX();
        int y = snake.get(snake.size() - 1).getY();

        switch (direction) {
            case UP: y += 20; break;
            case DOWN: y -= 20; break;
            case LEFT: x += 20; break;
            case RIGHT: x -= 20; break;
        }

        // FIXME: new element is appended in the direction of head but must in the direction of previous element

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
            snake.get(i).setDirection(snake.get(i-1).getDirection());
        }
        SnakeElement head = snake.get(0);
        head.setDirection(direction);
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

    public boolean intersectsItself() {
        for (int i = 1; i < snake.size(); ++i) {
            if (snake.get(i).equals(snake.get(0))) {
                return true;
            }
        }
        return false;

    }
 }
