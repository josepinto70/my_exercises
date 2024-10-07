package io.codeforall.bootcamp;

public class SniperRifle {

    public int bulletDamage;
    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

     public void shoot(Enemy enemy){
         enemy.hit();
    }
}
