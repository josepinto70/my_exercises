public class Hero {
    private String name;
    private int health;
    private int mana;
    private int attack;
    private int defense;

    public Hero(String name, int health, int mana, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Hero target) {
        int damage = Math.max(0, attack - target.defense);
        target.takeDamage(damage);
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage.");
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }
}
