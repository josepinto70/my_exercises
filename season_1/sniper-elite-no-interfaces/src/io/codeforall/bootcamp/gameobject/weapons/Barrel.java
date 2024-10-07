package io.codeforall.bootcamp.gameobject.weapons;

public class Barrel implements Destroyable{


    public BarrelType barrelType;

    public int currentDamage;

    public boolean destroyed;

    public Barrel(BarrelType barrelType, int currentDamage, boolean destroyed) {
        this.barrelType = barrelType;
        this.currentDamage = currentDamage;
        this.destroyed = destroyed;
    }


    public String getMessage(){

        return null;
    }

    @Override
    public void hit() {

    }

    @Override
    public boolean isDestroyed() {
        return false;
    }
}
