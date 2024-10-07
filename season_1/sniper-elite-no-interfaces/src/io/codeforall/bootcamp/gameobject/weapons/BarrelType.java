package io.codeforall.bootcamp.gameobject.weapons;

public class BarrelType {

    public enum TypeBarrel {

        PLASTIC,
        WOOD,
        METAL
    }

    private int maxDamage;

    public int getMaxDamage() {
        return maxDamage;
    }
}