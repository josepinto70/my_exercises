package io.codeforall.bootcamp;

import io.codeforall.bootcamp.car.CarFactory;
import io.codeforall.bootcamp.car.CarType;
import io.codeforall.bootcamp.car.PlayerCar;
import io.codeforall.bootcamp.car.Car;
import io.codeforall.bootcamp.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.bootcamp.grid.Grid;
import io.codeforall.bootcamp.grid.GridColor;
import io.codeforall.bootcamp.grid.GridFactory;
import io.codeforall.bootcamp.grid.GridType;

/**
 * The game logic
 */
public class Game {


    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of cars to manufacture
     */
    private int manufacturedCars = 20;


    /**
     * Constructs a new game
     * @param gridType which grid type to use
     * @param cols number of columns in the grid
     * @param rows number of rows in the grid
     * @param delay animation delay
     */
    public Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        boolean keyboardSupport = grid instanceof SimpleGfxGrid;

        grid.init();

        if (keyboardSupport) {
            cars = new Car[manufacturedCars + 1];
        } else {
            cars = new Car[manufacturedCars];
        }

        collisionDetector = new CollisionDetector(cars);

        if (keyboardSupport) {
            Car playerCar = new PlayerCar(grid.makeGridPosition(), CarType.MUSTANG);
            playerCar.getPos().setColor(GridColor.MAGENTA);
            playerCar.setCollisionDetector(collisionDetector);
            cars[cars.length - 1] = playerCar;
        }

        for (int i = 0; i < manufacturedCars; i++) {

            cars[i] = CarFactory.getNewCar(grid);
            cars[i].setCollisionDetector(collisionDetector);
            cars[i].setGrid(grid);

        }

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();

        }

    }

    /**
     * Moves all cars
     */
    public void moveAllCars() {

        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
        }

    }

}
