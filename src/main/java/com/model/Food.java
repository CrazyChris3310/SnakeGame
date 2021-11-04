package com.model;

import com.utils.Functions;
import java.awt.*;

public class Food {
    private static final int BORDER = 3;
    private static final int SIZE = SnakeElement.SIZE - 2 * BORDER;
    private Color color = Color.BLACK;
    private int x;
    private int y;

    public Food() {
        newCords();
    }

    public void newCords() {
        int[] cords = Functions.randomCoordinate();
        x = cords[0];
        y = cords[1];
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x+BORDER, y+BORDER, SIZE, SIZE);
    }

    public int[] getCords() {
        return new int[] {x, y};
    }

}
