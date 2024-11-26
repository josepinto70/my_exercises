import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Menu implements MouseHandler {
    private final Text startText;
    private final Text exitText;
    private final Rectangle startButton;
    private final Rectangle exitButton;
    private boolean startGame = false;

    public Menu() {
        // Fundo do menu
        Rectangle background = new Rectangle(0, 0, 500, 500);
        background.setColor(Color.WHITE);
        background.fill();

        // Botão "Iniciar Jogo"
        startButton = new Rectangle(150, 200, 200, 60);
        startButton.setColor(Color.GREEN);
        startButton.fill();
        startText = new Text(200, 230, "Iniciar Jogo");
        startText.grow(40, 20);
        startText.draw();

        // Botão "Sair"
        exitButton = new Rectangle(150, 300, 200, 60);
        exitButton.setColor(Color.RED);
        exitButton.fill();
        exitText = new Text(220, 330, "Sair");
        exitText.grow(30, 15);
        exitText.draw();

        // Adicionar handler do mouse
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    private boolean isInside(int mouseX, int mouseY, Rectangle button) {
        return mouseX >= button.getX() && mouseX <= button.getX() + button.getWidth() &&
                mouseY >= button.getY() && mouseY <= button.getY() + button.getHeight();
    }



    private void closeMenu() {
        startButton.delete(); // Remove o botão "Iniciar Jogo"
        exitButton.delete();  // Remove o botão "Sair"
        startText.delete();   // Remove o texto do botão "Iniciar Jogo"
        exitText.delete();    // Remove o texto do botão "Sair"
        // Você pode adicionar mais lógica aqui para limpar outros elementos, se necessário
    }



    public boolean isStartGame() {
       Game game = new Game();
       closeMenu();
       startGame = true;
        // Você pode adicionar lógica aqui para iniciar o jogo visualmente
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        // Ignora cliques se o jogo já começou
        if (startGame) {
            return;
        }

        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();

        // Verifica se o clique foi dentro do botão "Iniciar Jogo"
        if (isInside(x, y, startButton)) {
            startGame = true; // Sinaliza que o jogo deve começar
            closeMenu(); // Fecha o menu
            isStartGame(); // Inicia o jogo
        }


        // Verifica se o clique foi dentro do botão "Sair"
        if (isInside(x, y, exitButton)) {
            System.exit(0); // Sai do programa
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}



