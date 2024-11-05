public class Fireball extends AbstractAbility {

    public Fireball() {
        super("Fireball");
    }

    @Override
    public void execute(Hero target) {
        if (target != null && target.isAlive()) {
            int damage = 45;
            target.takeDamage(damage);
            System.out.println(target.getName() + " was hit by a fireball for " + damage + " damage.");
        }
    }
}
