public class Cleric extends Hero {
    public Cleric(String name) {
        super(name, 70, 80, 10, 8);
    }

    public void heal(Hero target) {
        if (super.isAlive()) {
            int damage = 20;
            target.takeDamage(damage);
            System.out.println(getName() + " thrown heal " + target.getName() + " for " + damage + " damage.");
        }
    }


}
