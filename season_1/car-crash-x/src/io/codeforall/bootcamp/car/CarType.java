package io.codeforall.bootcamp.car;

import io.codeforall.bootcamp.grid.GridColor;

/**
 * Different types of cars
 */
public enum CarType {
    FIAT(GridColor.BLUE),
    MUSTANG(GridColor.GREEN);

    private GridColor color;

    /**
     * Constructor of Car Types
     * @param color The car type color
     */
    CarType(GridColor color) {
        this.color = color;
    }

    public GridColor getColor() {

        return this.color;

    }
}
