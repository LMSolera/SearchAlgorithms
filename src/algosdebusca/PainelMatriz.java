package algosdebusca;

import javax.swing.JPanel;

public class PainelMatriz extends javax.swing.JPanel {
    
    private static boolean mouseDown1;
    private static boolean mouseDown2;
    
    public PainelMatriz() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(MainClass.getY(), MainClass.getX()));
    }// </editor-fold>//GEN-END:initComponents
    
    public static boolean getMouse1State () {
        return mouseDown1;
    }
    
    public static boolean getMouse2State () {
        return mouseDown2;
    }
    
    public static void mouse1Change () {
        if (!mouseDown1) {
            mouseDown1 = true;
        } else {
            mouseDown1 = false;
        }
    }
    
    public static void mouse2Change () {
        if (!mouseDown2) {
            mouseDown2 = true;
        } else {
            mouseDown2 = false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
