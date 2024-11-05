import javax.xml.transform.Source;
import java.util.List;
import java.util.Random;

public class TurnManager {
    private List<Hero> heroes;
    private Random random;
    private int turnCounter = 0;

    public TurnManager(List<Hero> heroes) {
        this.heroes = heroes;
        this.random = new Random();
    }

    public void takeTurn() {
        for (int i = 0; i < heroes.size(); i++) {
            Hero attacker = heroes.get(i);
            if (attacker.isAlive()) {

                Hero target = selectTarget(attacker);
                attacker.attack(target);
                if (!target.isAlive()) {
                    heroes.remove(target);
                    System.out.println(target.getName() + " hero has been defeated!");
                }
            }

        }
        turnCounter++;
       System.out.println("^^^");
       System.out.println("Turn : " + turnCounter); // linha a mais
        System.out.println("-------------------------");
    }

    private Hero selectTarget(Hero attacker) {
        Hero target;
        do {
            target = heroes.get(random.nextInt(heroes.size()));
        } while (target == attacker || !target.isAlive());
        return target;
    }
}
