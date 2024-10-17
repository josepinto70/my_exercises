import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class GridPainter extends JPanel implements KeyListener {
    private final int gridSize = 20; // Size of the grid
    private final int cellSize = 20; // Size of each cell
    private final Color[][] grid; // 2D array to represent the grid
    private int cursorX, cursorY; // Cursor position

    public GridPainter() {
        grid = new Color[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = Color.WHITE; // Initialize grid with white cells
            }
        }
        cursorX = 0;
        cursorY = 0;

        setFocusable(true);
        addKeyListener(this);
        setPreferredSize(new Dimension(gridSize * cellSize, gridSize * cellSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                g.setColor(grid[i][j]);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
        // Draw the cursor
        g.setColor(Color.RED);
        g.drawRect(cursorX * cellSize, cursorY * cellSize, cellSize, cellSize);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (cursorX > 0) cursorX--;
                break;
            case KeyEvent.VK_RIGHT:
                if (cursorX < gridSize - 1) cursorX++;
                break;
            case KeyEvent.VK_UP:
                if (cursorY > 0) cursorY--;
                break;
            case KeyEvent.VK_DOWN:
                if (cursorY < gridSize - 1) cursorY++;
                break;
            case KeyEvent.VK_SPACE:
                grid[cursorY][cursorX] = (grid[cursorY][cursorX] == Color.WHITE) ? Color.BLACK : Color.WHITE;
                break;
            case KeyEvent.VK_C:
                clearGrid();
                break;
            case KeyEvent.VK_S:
                saveGrid();
                break;
            case KeyEvent.VK_L:
                loadGrid();
                break;
        }
        repaint();
    }

    private void clearGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = Color.WHITE; // Reset to white
            }
        }
    }

    private void saveGrid() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("grid.txt"))) {
            for (Color[] row : grid) {
                for (Color cell : row) {
                    writer.write(cell == Color.BLACK ? "1" : "0");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGrid() {
        try (BufferedReader reader = new BufferedReader(new FileReader("grid.txt"))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < gridSize) {
                for (int col = 0; col < line.length() && col < gridSize; col++) {
                    grid[row][col] = line.charAt(col) == '1' ? Color.BLACK : Color.WHITE;
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void keyTyped(KeyEvent e) { }

    public void keyReleased(KeyEvent e) { }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Painter");
        GridPainter gridPainter = new GridPainter();
        frame.add(gridPainter);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gridPainter.requestFocusInWindow();
    }
}
