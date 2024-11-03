import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class EndGame implements MouseHandler {
    private final Text tryAgain;
    private final Text exit1;
    private final Rectangle tryAgainButton;
    private final Rectangle exitButton1;
    private boolean startGame = false;
    private String message;

    public EndGame() {
        Rectangle endBackground = new Rectangle(0, 0, 500, 650);
        endBackground.setColor(Color.LIGHT_GRAY);
        endBackground.fill();


        // Botão "Try Again"
        tryAgainButton = new Rectangle(150, 200, 200, 60);
        tryAgainButton.setColor(Color.GREEN);
        tryAgainButton.fill();
        tryAgain = new Text(200, 230, "Try Again");
        tryAgain.grow(40, 20);
        tryAgain.draw();

        // Botão "Sair"
        exitButton1 = new Rectangle(150, 300, 200, 60);
        exitButton1.setColor(Color.RED);
        exitButton1.fill();
        exit1 = new Text(220, 330, "Exit");
        exit1.grow(30, 15);
        exit1.draw();

        // Adicionar handler do mouse
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();

        // Verifica se o clique foi dentro do botão "Try Again"
        if (isInside1(x, y, tryAgainButton)) {
            startGame = true; // Sinaliza que o jogo deve começar
            closeEndGame(); // Fecha o menu
            isStartGame1(); // Inicia o jogo
        }

        // Verifica se o clique foi dentro do botão "Sair"
        if (isInside1(x, y, exitButton1)) {
            System.exit(0); // Sai do programa
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    private boolean isInside1(int mouseX, int mouseY, Rectangle button1) {
            return mouseX >= button1.getX() && mouseX <= button1.getX() + button1.getWidth() &&
                    mouseY >= button1.getY() && mouseY <= button1.getY() + button1.getHeight();
        }

        private void closeEndGame(){
            tryAgainButton.delete();
            exitButton1.delete();
            tryAgain.delete();
            exit1.delete();
        }

        public boolean isStartGame1() {
            int columns = 4;
            Game.Model model = new Game.Model(columns, 2);
            new Game.Controller(model);
            return false;
        }
    }


/*public void showEndMessage(boolean won) {
    String message = won ? "Parabéns! Ganhaste!" : "Que pena! Perdeste!";
    Rectangle rectangle1 = new Rectangle(0,0,500,650);
    rectangle1.setColor(Color.WHITE);
    rectangle1.draw();
    rectangle1.fill();
    endMessage = new Text(150, 300, message);
    endMessage.setColor(Color.BLACK);
    endMessage.grow(80, 40);
    endMessage.draw();
}
    }

 */