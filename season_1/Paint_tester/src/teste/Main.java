package teste;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GridExample extends JPanel {

    private int rows;
    private int cols;
    private int cellSize;

    public GridExample(int rows, int cols, int cellSize) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.RED); // Set the color for the grid lines

        for (int i = 0; i <= rows; i++) {
            int y = i * cellSize;
            g.drawLine(0, y, cols * cellSize, y); // Horizontal lines
        }

        for (int j = 0; j <= cols; j++) {
            int x = j * cellSize;
            g.drawLine(x, 0, x, rows * cellSize); // Vertical lines
        }
    }

    public static void main(String[] args) {
        int rows = 10; // Number of rows
        int cols = 10; // Number of columns
        int cellSize = 50; // Size of each cell in pixels

        JFrame frame = new JFrame("Grid Example");
        GridExample gridPanel = new GridExample(rows, cols, cellSize);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gridPanel);
        frame.setSize(cols * cellSize + 50, rows * cellSize + 50);
        frame.setVisible(true);
    }
}