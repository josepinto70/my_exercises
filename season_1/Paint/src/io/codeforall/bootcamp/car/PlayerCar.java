package io.codeforall.bootcamp.car;

import io.codeforall.bootcamp.grid.GridDirection;
import io.codeforall.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Keyboard Controlled Car
 */
public class PlayerCar extends Car implements KeyboardHandler {

    private final int MAX_SPEED = 3;
    private Keyboard keyboard;
    private int speed = 0;

    /**
     * Constructs a new car
     *
     * @param pos     the initial car position
     * @param carType the car type
     */
    public PlayerCar(GridPosition pos, CarType carType) {
        super(pos, carType);
        keyboard = new Keyboard(this);
        init();
    }

    /**
     * Initialize keyboard handlers
     */
    public void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent faster = new KeyboardEvent();
        faster.setKey(KeyboardEvent.KEY_SPACE);
        faster.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent slower = new KeyboardEvent();
        slower.setKey(KeyboardEvent.KEY_SPACE);
        slower.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(faster);
        keyboard.addEventListener(slower);
    }

    /**
     * @see Car#move()
     */
    @Override
    public void move() {
        accelerate(currentDirection, speed);
    }

    /**
     * @see Car#accelerate(GridDirection, int)
     */
    @Override
    public void accelerate(GridDirection direction, int speed) {

        // Crashed cars can not accelerate
        if (isCrashed()) {
            return;
        }

        // Accelerate in the choosen direction
        this.currentDirection = direction;
        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(direction, 1);
            if (collisionDetector.isUnSafe(getPos())) {
                crash();
                break;
            }
        }

    }

    /**
     * Handles key press events
     *
     * @param keyboardEvent the keyboard event
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            speed = MAX_SPEED;
            return;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                currentDirection = GridDirection.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                currentDirection = GridDirection.RIGHT;
                break;
            case KeyboardEvent.KEY_UP:
                currentDirection = GridDirection.UP;
                break;
            case KeyboardEvent.KEY_DOWN:
                currentDirection = GridDirection.DOWN;
                break;
        }

        if (speed == 0) {
            accelerate(currentDirection, 1);
        }

    }

    /**
     * Handles key release events
     *
     * @param keyboardEvent the keyboard event
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            speed = 0;
        }

    }
}
