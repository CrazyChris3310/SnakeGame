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
        if (direction == null)
            return;
        if (this.direction.isOpposite(direction))
            this.direction = direction;
    }

    public void addElement(int x, int y) {
        SnakeElement element = new SnakeElement(x, y);
        element.setColor(color);
        element.setDirection(snake.get(0).getDirection());
        snake.add(element);
    }

    public void grow() {
        // appending new element to the end considering direction
        int x = snake.get(snake.size() - 1).getX();
        int y = snake.get(snake.size() - 1).getY();

        Direction dir = snake.get(snake.size() - 1).getDirection();
        x -= dir.getHorizontalKey() * SnakeElement.SIZE;
        y -= dir.getVerticalKey() * SnakeElement.SIZE;

        addElement(x, y);
    }

    public void paintSnake(Graphics g) {
        for (SnakeElement element : snake) {
            element.paintElement(g);
        }
    }

    public void updateCords() {
        for (int i = snake.size() - 1; i > 0; --i) {
            snake.get(i).setDirection(snake.get(i-1).getDirection());
            snake.get(i).changeCords(snake.get(i - 1).getCords());
        }
        SnakeElement head = snake.get(0);
        head.setDirection(direction);
        head.move();

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
