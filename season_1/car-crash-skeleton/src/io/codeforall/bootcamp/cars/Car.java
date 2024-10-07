package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

abstract public class Car {

    /** The position of the car on the grid */

    private int col;
    private int row;

    Position position = new Position();

    public Car(){
       this.col = (int) Math.random()*100;
       this.row = (int) Math.random()*100;
    }



    public Position getPos() {





        //Position position = new Position();
        //position.getRow();
        //position.getCol();




        return position;
    }

    public boolean isCrashed() {
        return false;
    }
}
