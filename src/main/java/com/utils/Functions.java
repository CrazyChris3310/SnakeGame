package com.utils;

import com.model.Direction;
import com.model.SnakeElement;
import com.view.MainFrame;

public class Functions {
    public static int[] randomCoordinate() {
        int x = (int)(Math.random() * (MainFrame.WIDTH));
        int y = (int)(Math.random() * (MainFrame.HEIGHT));
        x -= x % SnakeElement.SIZE;
        y -= y % SnakeElement.SIZE;
        return new int[] {x, y};
    }

    public static Direction getRandomDirection() {
        int r = (int)(Math.random() * 4);
        return Direction.values()[r];
    }

}
