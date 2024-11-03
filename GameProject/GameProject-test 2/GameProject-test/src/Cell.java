import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private int positionY;
    private int positionX;
    private Rectangle rectangle;
    boolean isClicked;
    MyPicture myPicture;



    public Cell(int positionX, int positionY, int cellsize) {
        this.rectangle = new Rectangle(positionX, positionY, cellsize, cellsize);
        this.positionX = positionX;
        this.positionY = positionY;
        boolean isClicked = false;
        this.myPicture = new MyPicture(positionX,positionY,isClicked);
        rectangle.draw();
        rectangle.setColor(Color.WHITE);


    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;

    }

    public void setNotClicked(boolean isClicked){
        this.isClicked = isClicked;
    }

    public boolean getIsClicked(){
        return this.isClicked;
    }

    public int getCellPositionX(){
        return this.positionX;
    }

    public int getCellPositionY(){
        return this.positionY;
    }

    public MyPicture getCellPicture(){
        return this.myPicture;
    }

    public void changeImage(int positionX,int positionY,boolean isClicked){
        this.myPicture.choseImage(positionX,positionY,isClicked);
    }

    public String setIcon(){
        return myPicture.getIconImage();
    }



}





