package io.codeforall.bootcamp;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.w3c.dom.css.Rect;

public class Grid {

    // Instance variables
    public int v;
    public int v1;
    public int v2;
    public int v3;

    //constructor
    public Grid(int v, int v1, int v2, int v3) {
        this.v = v;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Grid()
    { };


//public class tr(int v, int v1,int v2, int v3 ) {

  //  Rectangle rect = new Rectangle(v, v1, v2, v3);


     //cria a grid
    public Rectangle getRect(int v,int v1,int v2,int v3) {
        Rectangle rect = new Rectangle(v,v1,v2,v3);
        rect.setColor(Color.GREEN);
        rect.fill();
        return rect;

}

public Rectangle getColor(String color){
    Rectangle nColor = new Rectangle();
    nColor.setColor(Color.BLUE);
    return  nColor;
}


}