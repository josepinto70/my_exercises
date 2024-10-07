package io.codeforall.bootcamp.gameobject;

import io.codeforall.bootcamp.gameobject.enemy.ArmouredEnemy;
import io.codeforall.bootcamp.gameobject.enemy.Enemy;
import io.codeforall.bootcamp.gameobject.enemy.SoldierEnemy;
import io.codeforall.bootcamp.gameobject.weapons.Barrel;
import io.codeforall.bootcamp.gameobject.weapons.BarrelType;

import static io.codeforall.bootcamp.gameobject.weapons.BarrelType.TypeBarrel.METAL;
import static io.codeforall.bootcamp.gameobject.weapons.BarrelType.TypeBarrel.WOOD;

public class GameObjectFactory {

    public static int ENEMY_HEALTH = 3;
    public static int ARMOUR =

    public static Enemy createEnemy() {

        //return Math.random() > 0.5 ? new SoldierEnemy(ENEMY_HEALTH) : new ArmouredEnemy(ENEMY_HEALTH, ARMOUR);

        return Math.random() > 0.5 ? new SoldierEnemy(ENEMY_HEALTH) : new Barrel(TypeBarrel.WOOD,2, true);


        }

    }

