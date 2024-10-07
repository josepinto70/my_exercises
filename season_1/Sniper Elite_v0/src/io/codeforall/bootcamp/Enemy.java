package io.codeforall.bootcamp;

public abstract class Enemy extends GameObject{

    public int health;

    public boolean isDead;

    public Enemy(String type, int health, boolean isDead) {
        super(type);
        this.health = health;
        this.isDead = isDead;
    }

    public boolean isDead(){
        return;
    }

    public abstract void hit();

    @Override
    public void getMessage(String message){

        System.out.println("You shoot in me ! ");
    }




}
