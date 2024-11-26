import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;


public class Main {
    public static void main(String[] args) {
        int columns = 4;
        int tries = 0;
        Game.Model model = new Game.Model(columns, 10);

        new Game.Controller(model);
    }int tries;
}