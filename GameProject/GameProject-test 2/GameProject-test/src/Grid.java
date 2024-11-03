import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.awt.event.MouseListener;
import java.util.Objects;


public class Grid implements MouseHandler, MouseListener {

    int cols = 4;
    int rows = 4;
    int cellSize = 120;
    int PADDING = 10;
    int tries;
    public Cell[][] cellsarray;
    String firstCellPicture;
    String secondCellPicture;

    Cell firstCell;
    Cell secondCell;

    boolean cell1created = false;
    boolean cell2created = false;

    private boolean isInside(int mouseX, int mouseY, Rectangle button) {
        return mouseX >= button.getX() && mouseX <= button.getX() + button.getWidth() &&
                mouseY >= button.getY() && mouseY <= button.getY() + button.getHeight();
    }

    public Grid() {
        drawGrid();
        initMouse();
    }


    private void initMouse() {
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);


    }

    private void drawGrid() {
        cellsarray = new Cell[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                Cell cell = new Cell(j * cellSize + PADDING, i * cellSize + PADDING, cellSize);
                cellsarray[i][j] = cell;
            }
        }

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int clickedX = (int) mouseEvent.getX();
        int clickedY = (int) mouseEvent.getY();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Cell cell = cellsarray[i][j];


                if (clickedX >= cell.getCellPositionX() && clickedX <= cell.getCellPositionX() + cellSize &&
                        clickedY >= cell.getCellPositionY() && clickedY <= cell.getCellPositionY() + cellSize) {

                    //  Vê célula se está clicada
                    if (!cell.getIsClicked()) {

                        if (!cell1created) {
                            this.firstCellPicture = cell.getCellPicture().toString();
                            turnImageToPerson(cell, clickedX, clickedY);
                            firstCell = cell;
                            System.out.println("criei a primeira cell");
                            cell1created = true;
                            System.out.println(firstCellPicture);
                        }
                        if (clickedX >= cell.getCellPositionX() && clickedX <= cell.getCellPositionX() + cellSize &&
                                clickedY >= cell.getCellPositionY() && clickedY <= cell.getCellPositionY() + cellSize) {
                            if (!cell.getIsClicked()) {
                                this.secondCellPicture = cell.getCellPicture().toString();
                                turnImageToPerson(cell, clickedX, clickedY);
                                secondCell = cell;
                                System.out.println("criei a segunda cell");
                                cell2created = true;
                                System.out.println(secondCellPicture);
                            }


                        }


                        if (cell1created && cell2created) {
                            if (!compareCellsPicture(firstCellPicture, secondCellPicture)) {
                                System.out.println("entrei no compare");
                                setImageToIcon(firstCell);
                                setImageToIcon(secondCell);
                                //turnImageToIcon(firstCell, firstCell.getCellPositionX(), firstCell.getCellPositionY());
                                //turnImageToIcon(secondCell, secondCell.getCellPositionX(), secondCell.getCellPositionY());
                                cell1created = false;
                                cell1created = false;
                            } else {
                                System.out.println("entrei no compare mas no else");
                                cell1created = false;
                                cell2created = false;

                            }

                        }
                    }


                }
            }
        }
    }


    private boolean compareCellsPicture(String firstCellPicture, String secondCellPicture) {
        if (firstCellPicture.equals(secondCellPicture)) {
            return true;
        }
        return false;
    }

    public void turnImageToPerson(Cell cell, int clickedX, int clickedY) {
        cell.setIsClicked(true);
        cell.changeImage(cell.getCellPositionX(), cell.getCellPositionY(), cell.getIsClicked());
    }

    public void setImageToIcon(Cell cell) {
        cell.changeImage(cell.getCellPositionX(),cell.getCellPositionY(), cell.isClicked);
    }

    public void turnImageToIcon(Cell cell, int clickedX, int clickedY) {
        cell.setNotClicked(false);
        cell.changeImage(cell.getCellPositionX(), cell.getCellPositionY(), cell.getIsClicked());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

}



