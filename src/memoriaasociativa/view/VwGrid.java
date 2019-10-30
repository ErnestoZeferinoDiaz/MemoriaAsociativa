package memoriaasociativa.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import memoriaasociativa.model.MdlGrid;

public class VwGrid extends JPanel{
    private MdlGrid mgrid;
    public VwGrid(MdlGrid mgrid){
        this.setBackground(Color.WHITE);
        this.mgrid = mgrid;
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        
        for(int x=0; x<this.mgrid.getHeight(); x++){
            for(int y=0; y<this.mgrid.getWidth(); y++){
                if(this.mgrid.get(x, y)==0){
                    g2.setColor(Color.WHITE);
                }else{
                    g2.setColor(Color.BLACK);
                }
                g2.fill(new Rectangle2D.Double(y*MdlGrid.widthCell, 
                                               x*MdlGrid.heightCell, 
                                               MdlGrid.widthCell, 
                                               MdlGrid.heightCell));
            }
        }
        g2.setColor(Color.BLACK);
        for(int x=0; x<=this.mgrid.getHeight(); x++){
          g2.drawLine(0, x*MdlGrid.heightCell, this.getWidth(), x*MdlGrid.heightCell);
        }
        for(int x=0; x<=this.mgrid.getWidth(); x++){
          g2.drawLine(x*MdlGrid.widthCell, 0, x*MdlGrid.widthCell,this.getHeight());
        }
        
        
        
    }
    
    
}
