package com.model;

import java.awt.*;

public class SnakeElement {

    public static final int SIZE = 20;
    private Color color;
    private int x;
    private int y;

    public SnakeElement(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.RED;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public void incY() {
        y += SIZE;
    }

    public void incX() {
        x += SIZE;
    }

    public void decY() {
        y -= SIZE;
    }

    public void decX() {
        x -= SIZE;
    }


}
