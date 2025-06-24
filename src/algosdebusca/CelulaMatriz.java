package algosdebusca;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class CelulaMatriz extends javax.swing.JPanel {
   
   private int myCoordinate[] = new int[2];
   private int verticeIndex = -1;

   public CelulaMatriz() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void validateState () {
        
        if (MainClass.peekMatrixPos(myCoordinate[0], myCoordinate[1]) == 1
                && getBackground() != Color.white) {            
            setBackground(Color.white);
            setVerticeIndex(-1);
        }
        
        if (MainClass.peekMatrixPos(myCoordinate[0], myCoordinate[1]) == 0
                && getBackground() != Color.black) {
            setBackground(Color.black);
            setVerticeIndex(-1);
        }
    }
    
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
            if (PainelMatriz.getMouse1State() && elligibleToChange()) {     
                
                if (getBackground() != Color.white && 
                        MainClass.peekMatrixPos(myCoordinate[0], myCoordinate[1]) == 0) {
                    setBackground(Color.white);
                    MainClass.updateMatrix(myCoordinate[0], myCoordinate[1]);
                }
                
            }
            if (PainelMatriz.getMouse2State() && elligibleToChange()) {       
                
                if (getBackground() != Color.black &&
                        MainClass.peekMatrixPos(myCoordinate[0], myCoordinate[1]) == 1) {
                    setBackground(Color.black);
                    setVerticeIndex(-1);
                    MainClass.updateMatrix(myCoordinate[0], myCoordinate[1]);
                }
                
            }          
    }//GEN-LAST:event_formMouseEntered

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (evt.getButton() == MouseEvent.BUTTON1 && elligibleToChange()) {

            if (getBackground() != Color.white && 
                        MainClass.peekMatrixPos(myCoordinate[0], myCoordinate[1]) == 0) {
                setBackground(Color.white);
                MainClass.updateMatrix(myCoordinate[0], myCoordinate[1]);
            }
            
            PainelMatriz.mouse1Change();
            
        } else if (evt.getButton() == MouseEvent.BUTTON1) {            
            PainelMatriz.mouse1Change();
        }
        
        if (evt.getButton() == MouseEvent.BUTTON3 && elligibleToChange()){

            if (getBackground() != Color.black &&
                        MainClass.peekMatrixPos(myCoordinate[0], myCoordinate[1]) == 1) {
                setBackground(Color.black);
                setVerticeIndex(-1);
                MainClass.updateMatrix(myCoordinate[0], myCoordinate[1]);
            }
            
            PainelMatriz.mouse2Change();
            
        } else if (evt.getButton() == MouseEvent.BUTTON3){           
            PainelMatriz.mouse2Change();
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {
            PainelMatriz.mouse1Change();
        }
        
        if (evt.getButton() == MouseEvent.BUTTON3) {
            PainelMatriz.mouse2Change();
        }
    }//GEN-LAST:event_formMouseReleased
    
    public void setCoordinate (int y, int x) {
        this.myCoordinate[0] = y;
        this.myCoordinate[1] = x;
    }
    
    public int[] getCoordinate () {
        int xy[] = {myCoordinate[0], myCoordinate[1]};
        return xy;
    }
    
    public void setVerticeIndex (int newIndex) {
        this.verticeIndex = newIndex;
    }
    
    public int getVerticeIndex () {
        return this.verticeIndex;
    }
    
    private boolean elligibleToChange () {
        if (myCoordinate[0] == 0 && myCoordinate[1] == 0) {
            return false;
        } else if (myCoordinate[0] == (MainClass.getY()-1) && myCoordinate[1] == (MainClass.getX()-1)) {
            return false;
        } else {
            return true;
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
