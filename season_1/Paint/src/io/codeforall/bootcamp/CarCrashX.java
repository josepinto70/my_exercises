package io.codeforall.bootcamp;

import io.codeforall.bootcamp.grid.GridType;

public class CarCrashX {

    public static void main(String[] args) throws InterruptedException {

        //Game g = new Game(GridType.LANTERNA, 80, 25, 200);


        // tem delay, mas e preciso
      //  Game g = new Game(GridType.SIMPLE_GFX, 10, 10, 200);

        //sem delay
        Game g = new Game(GridType.SIMPLE_GFX, 10, 10);

        g.init();
        g.start();

    }

}
