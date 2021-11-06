package com.model;

import java.awt.*;
import java.util.Objects;

public class SnakeElement {

    public static final int SIZE = 20;
    private Color color;
    private int x;
    private int y;
    private Direction direction;

    public SnakeElement(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.RED;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void paintElement(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE);
    }

    public void changeCords(int[] cords) {
        this.x = cords[0];
        this.y = cords[1];
    }

    public int[] getCords() {
        return new int[] {this.x , this.y};
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move() {
        x += direction.getHorizontalKey() * SIZE;
        y += direction.getVerticalKey() * SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnakeElement element = (SnakeElement) o;
        return x == element.x && y == element.y && Objects.equals(color, element.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, x, y);
    }
}
