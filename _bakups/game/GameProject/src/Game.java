import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.graphics.Rectangle; // Importa a classe Rectangle
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


import java.util.ArrayList;
import java.util.Vector;

public class Game {

    public static void main(String[] args) {

        GraphicsWindow window = new GraphicsWindow(400,400);// 400x400 pixels
        

        int columns = 4; // Número de colunas
        int maxTries = 10; // Número máximo de tentativas

        Model model = new Model(columns, maxTries);
        new Controller(model);
    }

    public static class Controller implements MouseHandler {
        Model model;
        View view;
        MemoryButton firstButton = null; // Primeiro botão revelado
        MemoryButton secondButton = null; // Segundo botão revelado
        boolean waitingForHide = false;  // Para evitar cliques enquanto as cartas estão para serem escondidas

        public Controller(Model model) {
            this.model = model;
            this.view = new View(model);
            this.view.draw();

            // Adiciona o handler para capturar cliques do mouse
            Mouse mouse = new Mouse(this);
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        public void reset(Model model) {
            this.model = model;
            this.view.clear();
            this.view = new View(model);
            this.view.draw();
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (waitingForHide || model.getRemainingTries() <= 0) {
                // Se estiver esperando para esconder as cartas ou acabaram as tentativas, ignora o clique
                return;
            }

            int x = (int) mouseEvent.getX();
            int y = (int) mouseEvent.getY();

            // Percorre os botões e verifica se o clique foi dentro de um botão ativo
            for (MemoryButton button : model.getButtons()) {
                if (button.isInside(x, y) && button.isEnabled()) {
                    button.reveal();
                    handleButtonClick(button);
                    break;
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            // Não usado, mas necessário para implementar MouseHandler
        }

        private void handleButtonClick(MemoryButton button) {
            if (firstButton == null) {
                firstButton = button; // Primeiro botão revelado
            } else if (secondButton == null && firstButton != button) {
                secondButton = button; // Segundo botão revelado
                checkMatch(); // Verifica se os dois botões são iguais
            }
        }

        private void checkMatch() {
            if (firstButton.getReference().equals(secondButton.getReference())) {
                // São iguais, desativa os botões permanentemente
                firstButton.disable();
                secondButton.disable();
                resetSelection();
            } else {
                // São diferentes, usa um temporizador para escondê-los após 1 segundo
                waitingForHide = true;
                new Thread(() -> {
                    try {
                        Thread.sleep(1000); // Espera 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Executa o código para esconder os botões depois de 1 segundo
                    firstButton.hide();
                    secondButton.hide();
                    resetSelection();
                }).start();
            }

            // Reduz uma tentativa após verificar os botões
            model.decreaseTries();
            view.updateTries();  // Atualiza o texto de tentativas na tela
        }

        private void resetSelection() {
            // Reseta os botões revelados para permitir novos cliques
            firstButton = null;
            secondButton = null;
            waitingForHide = false;
        }
    }

    public static class Model {
        static final String[] AVAILABLE_IMAGES = new String[]{"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png"};
        final ArrayList<MemoryButton> buttons;
        final int columns;
        private int maxTries;
        private int remainingTries;

        public Model(int columns, int maxTries) {
            this.columns = columns;
            this.maxTries = maxTries;
            this.remainingTries = maxTries;  // Inicializa com o número máximo de tentativas
            this.buttons = new ArrayList<>();

            int numberOfImages = columns * columns;
            Vector<Integer> v = new Vector<>();
            for (int i = 0; i < numberOfImages / 2; i++) {
                v.add(i % (AVAILABLE_IMAGES.length));
                v.add(i % (AVAILABLE_IMAGES.length));
            }

            // Definindo o tamanho da tela manualmente
            int screenWidth = 500;
            int screenHeight = 650;

            // Tamanho dos botões
            int buttonSize = 120;

            // Calculando o ponto inicial para centralizar
            int xOffset = (screenWidth - (columns * buttonSize)) / 2;
            int yOffset = (screenHeight - (columns * buttonSize)) / 2;

            for (int i = 0; i < numberOfImages; i++) {
                int rand = (int) (Math.random() * v.size());
                String reference = AVAILABLE_IMAGES[v.elementAt(rand)];

                // Definindo as coordenadas com base no offset para centralizar
                int x = xOffset + (i % columns) * buttonSize;
                int y = yOffset + (i / columns) * buttonSize;

                this.buttons.add(new MemoryButton(reference, x, y));
                v.removeElementAt(rand);
            }
        }

        public ArrayList<MemoryButton> getButtons() {
            return buttons;
        }

        public int getRemainingTries() {
            return remainingTries;
        }

        public void decreaseTries() {
            remainingTries--;
        }
    }

    public static class View {
        final Text triesText;
        final Rectangle textBackground;  // Retângulo de fundo para o texto
        final Model model;

        public View(Model model) {
            this.model = model;

            // Criar um retângulo como fundo do texto
            textBackground = new Rectangle(0, 0, 500, 50);  // Largura e altura do retângulo
            textBackground.setColor(Color.BLUE);      // Cor do retângulo
            textBackground.fill();

            // Inicializar o texto com a posição ajustada e tamanho ajustado
            this.triesText = new Text(200, 20, "Tentativas restantes: " + model.getRemainingTries());
            this.triesText.setColor(Color.BLACK);
            this.triesText.grow(40, 15); // Aumenta o tamanho da caixa de texto
        }

        public void draw() {
            textBackground.draw();   // Desenha o retângulo de fundo
            this.triesText.draw();   // Desenha o texto sobre o retângulo
            for (MemoryButton button : model.getButtons()) {
                button.draw();
            }
        }

        public void clear() {
            textBackground.delete(); // Apaga o retângulo
            triesText.delete();      // Apaga o texto
            for (MemoryButton button : model.getButtons()) {
                button.delete();
            }
        }

        public void updateTries() {
            triesText.setText("Tentativas restantes: " + model.getRemainingTries());
        }
    }

    public static class MemoryButton {
        static final String IMAGE_PATH = ""; // Caminho para as imagens
        Picture buttonImage;
        Picture hiddenImage;
        boolean isEnabled = true;
        String reference;

        public MemoryButton(String reference, int x, int y) {
            this.reference = reference;
            this.hiddenImage = new Picture(x, y, IMAGE_PATH + reference);
            this.buttonImage = new Picture(x, y, IMAGE_PATH + "no_image.png");
        }

        public void draw() {
            buttonImage.draw();
        }

        public void reveal() {
            buttonImage.delete();
            hiddenImage.draw();
        }

        public void hide() {
            hiddenImage.delete();
            buttonImage.draw();
        }

        public boolean isEnabled() {
            return isEnabled;
        }

        public void disable() {
            isEnabled = false;
        }

        public String getReference() {
            return reference;
        }

        public void delete() {
            buttonImage.delete();
            hiddenImage.delete();
        }

        public boolean isInside(int mouseX, int mouseY) {
            return mouseX >= buttonImage.getX() && mouseX <= buttonImage.getX() + buttonImage.getWidth() &&
                    mouseY >= buttonImage.getY() && mouseY <= buttonImage.getY() + buttonImage.getHeight();
        }
    }
}
