package memoriaasociativa.model;

public class MdlGrid {
    public static int widthLienzo,heightLienzo;
    public static int widthCell,heightCell;
    private int width,height;
    private int x,y;
    private int matriz[][];
    private boolean checks[][];
    
    public int get(int x,int y){
        return matriz[x][y];
    }
    
    public int[][] getMatriz() {
        return matriz;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setCheck(int x,int y){
        this.checks[x][y]=false;
    }
    
    public boolean getCheck(int x,int y){
        return this.checks[x][y];
    }
    
    public void set(int val,int x,int y){
        this.matriz[x][y]=val;
        this.checks[x][y]=true;
    }
    
    public void setDimension(int width,int height){
        this.setWidth(width);
        this.setHeight(height);
        MdlGrid.heightCell = MdlGrid.heightLienzo/height;
        MdlGrid.widthCell = MdlGrid.widthLienzo/width;
        this.matriz = new int[height][width];
        this.checks = new boolean[height][width];
        for(int x=0; x<height; x++){
            for(int y=0; y<width; y++){
                this.set(0, x, y);
                this.setCheck(x, y);
            }
        }
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
}
