package memoriaasociativa.view;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Celda {
    public static int width,height;
    public static Color a,b;
    
    private int x,y;
    private boolean isColor;
    
    public Celda(){
        this.isColor = false;
        this.x=0;
        this.y=0;
    }
    
    public Rectangle2D getCelda(){
        return new Rectangle2D.Double(this.getX(), this.getY(), Celda.width, Celda.height);
    }
    
    public void check(int x,int y){
        int w,h;
        w=this.getX()+Celda.width;
        h=this.getY()+Celda.height;
        if(x<w && y<h){
            this.swap();
        }
    }
    
    public Color getColor(){
        if(this.isColor){
            return Celda.a;
        }else{
            return Celda.b;
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    private void swap(){
        this.isColor = !this.isColor;
    }
    
    public boolean isColorCheck(){
        return this.isColor;
    }
}
