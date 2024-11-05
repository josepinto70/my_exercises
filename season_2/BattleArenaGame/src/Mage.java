public class Mage extends Hero {

    private Ability fireballAbility;
    public Mage(String name) {
        super(name, 80, 100, 15, 5);
    }

    /*public void fireball(Hero target) {
        if (super.isAlive()) {
            int damage = 45;
            target.takeDamage(damage);
            System.out.println(getName() + " thrown fireball " + target.getName() + " for " + damage + " damage.");
        }
    }*/

    @Override
    public void attack(Hero target) {
        // Mage can use their fireball ability to attack
        Fireball.execute(target);
    }


}
