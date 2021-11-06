package com.model;

public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    LEFT(-1, 0),
    DOWN(0, 1);

    private final int verticalKey;
    private final int horizontalKey;


    Direction(int hor, int vert) {
        verticalKey = vert;
        horizontalKey = hor;
    }

    public int getHorizontalKey() {
        return horizontalKey;
    }

    public int getVerticalKey() {
        return verticalKey;
    }

    public boolean isOpposite(Direction direction) {
        return !(direction.horizontalKey + horizontalKey == 0 || direction.verticalKey + verticalKey == 0);
    }
}
