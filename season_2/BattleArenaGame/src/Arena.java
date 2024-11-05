import java.util.ArrayList;
import java.util.List;

public class Arena {
    private List<Hero> heroes;

    public Arena() {
        heroes = new ArrayList<>();
        heroes.add(new Mage("Gustavo Mage"));
        heroes.add(new Cleric("Diogo Cleric"));
        heroes.add(new Warrior("Jorge Warrior"));
        heroes.add(new Rogue("Mafalda Rogue"));
    }

    public void startBattle() {
        TurnManager turnManager = new TurnManager(heroes);
        while (heroes.size() > 1) {
            turnManager.takeTurn();
        }
        System.out.println("The hero " + heroes.get(0).getName() + " wins the battle!");
    }
}
