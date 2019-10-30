package memoriaasociativa.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import memoriaasociativa.model.MdlGrid;
import memoriaasociativa.view.VwGrid;

public class CtrlGrid implements MouseMotionListener,MouseListener{
    private MdlGrid mgrid;
    private VwGrid vgrid;
    
    public CtrlGrid(MdlGrid mgrid,VwGrid vgrid){
        this.mgrid = mgrid;
        this.vgrid = vgrid;
        
        this.vgrid.addMouseListener(this);
        this.vgrid.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x,y;
        
        y=e.getX()/(this.vgrid.getWidth()/this.mgrid.getWidth());
        x=e.getY()/(this.vgrid.getHeight()/this.mgrid.getHeight());;
        
        if(x<this.mgrid.getHeight() && y<this.mgrid.getWidth()){
            if(!this.mgrid.getCheck(x, y)){
                if(this.mgrid.get(x, y)==1){
                    this.mgrid.set(0, x, y);
                }else{
                    this.mgrid.set(1, x, y);
                }
            }
        }
        
        this.vgrid.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x,y;
        
        y=e.getX()/(this.vgrid.getWidth()/this.mgrid.getWidth());
        x=e.getY()/(this.vgrid.getHeight()/this.mgrid.getHeight());;
        
        if(x<this.mgrid.getHeight() && y<this.mgrid.getWidth()){
            if(this.mgrid.get(x, y)==1){
                this.mgrid.set(0, x, y);
            }else{
                this.mgrid.set(1, x, y);
            }
        }
        
        this.vgrid.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        for(int x=0; x<this.mgrid.getHeight(); x++){
            for(int y=0; y<this.mgrid.getWidth(); y++){
                this.mgrid.setCheck(x, y);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {}
}
