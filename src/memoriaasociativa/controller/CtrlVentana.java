package memoriaasociativa.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import memoriaasociativa.model.MdlGrid;
import memoriaasociativa.view.VwGrid;
import memoriaasociativa.view.VwVentana;

public class CtrlVentana implements ChangeListener{
    private VwVentana vventana;
    private MdlGrid mgrid;
    private VwGrid vgrid;
    private CtrlGrid cgrid;
    public CtrlVentana(){
        this.vventana = new VwVentana();
        this.vventana.sldr_height.addChangeListener(this);
        this.vventana.sldr_width.addChangeListener(this);
        
        this.mgrid = new MdlGrid();
        this.vventana.lbl_noHeight.setText("Height: "+this.vventana.sldr_height.getValue());
        this.mgrid.setDimension(this.vventana.sldr_width.getValue(), this.vventana.sldr_height.getValue());
        this.vventana.lbl_noWidth.setText("Width: "+this.vventana.sldr_width.getValue());
        this.mgrid.setDimension(this.vventana.sldr_width.getValue(), this.vventana.sldr_height.getValue());
        this.vgrid = new VwGrid(this.mgrid);
        this.vgrid.setBounds(this.vventana.pnl_dat.getWidth(), 0, this.vventana.getWidth()-this.vventana.pnl_dat.getWidth(), this.vventana.getHeight());
        MdlGrid.widthLienzo = this.vgrid.getWidth();
        MdlGrid.heightLienzo = this.vgrid.getHeight();
        
        this.vventana.add(vgrid);
        this.cgrid = new CtrlGrid(mgrid,vgrid);
        
        
        this.vventana.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource().equals(this.vventana.sldr_height)){
            this.vventana.lbl_noHeight.setText("Height: "+this.vventana.sldr_height.getValue());
            this.mgrid.setDimension(this.vventana.sldr_width.getValue(), this.vventana.sldr_height.getValue());
            this.vgrid.repaint();
        }else if(e.getSource().equals(this.vventana.sldr_width)){
            this.vventana.lbl_noWidth.setText("Width: "+this.vventana.sldr_width.getValue());
            this.mgrid.setDimension(this.vventana.sldr_width.getValue(), this.vventana.sldr_height.getValue());
            this.vgrid.repaint();
        }
    }
    
}
