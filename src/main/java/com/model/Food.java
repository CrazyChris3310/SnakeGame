package com.model;

import com.view.MainFrame;

import java.awt.*;

public class Food {
    private static final int BORDER = 3;
    private static final int SIZE = SnakeElement.SIZE - 2 * BORDER;
    private Color color = Color.BLACK;
    private int x;
    private int y;

    public Food() {
        x = (int)(Math.random() * (MainFrame.WIDTH));
        y = (int)(Math.random() * (MainFrame.HEIGHT));
        x -= x % SnakeElement.SIZE;
        y -= y % SnakeElement.SIZE;
        System.out.println(x);
        System.out.println(y);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x+BORDER, y+BORDER, SIZE, SIZE);
    }

    public int[] getCords() {
        return new int[] {x, y};
    }

}
