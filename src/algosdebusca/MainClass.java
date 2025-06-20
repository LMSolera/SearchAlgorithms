package algosdebusca;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass {
    private static int x = 0;
    private static int y = 0;
    private static int[][] matrix;
    private static CelulaMatriz celulas[];
    private static JFrame tp = null;
    private static JPanel pm = null;

    public static int[][] fillMatrix (int y, int x) {
        int matrix[][] = new int[y][x];
        for (int col = 0; col < y; col++) {
            for (int row = 0; row < x; row++) {
                matrix[col][row] = 0;
            }
        }
        matrix[0][0] = 1;
        matrix[y-1][x-1] = 1;
        return matrix;
    }
    
    public static void resetMatrix (int y, int x) {
        matrix = fillMatrix(y,x);
        for (int i = 0; i < celulas.length; i++) {
            celulas[i].validateState();
        }
    }
    
    public static void printMatrix () {
        System.out.print("\n\n\n");
        for (int col = 0; col < y; col++) {
            for (int row = 0; row < x; row++) {
                System.out.print (matrix[col][row] + " ");
            }
            System.out.print ("\n");
        }
    }
    
    private static void startWindow (int matrix[][]) {
        tp = new TelaPrincipal();
        pm = new PainelMatriz();
        celulas = new CelulaMatriz[x*y];
        int count = 0;
        for (int col = 0; col < y; col++) {
            for (int row = 0; row < x; row++) {
                CelulaMatriz p = new CelulaMatriz(); 
                p.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                p.setCoordinate(col, row);
                if (matrix[col][row] == 0) {
                    p.setBackground(Color.black);
                } else {
                    p.setBackground(Color.white);
                }
                celulas[count] = p;
                count++;
                pm.add(p);
            }
        }
        tp.add(pm, 0);
        tp.setSize(900, 525);      
        tp.setVisible(true);
    }
    
    public static void setX (int value) {x = value;} 
    public static void setY (int value) {y = value;}
    public static int getX () {return x;} 
    public static int getY () {return y;}
    
    public static void updateMatrix (int y, int x) {
        if (matrix[y][x] == 1) {
            matrix[y][x] = 0;
        } else {
            matrix[y][x] = 1;
        }
    }
    
    public static int peekMatrixPos (int y, int x) {
        int value = matrix[y][x];
        return value;
    }       
    
    public static void start() {
        if (tp != null) {
            tp.dispose();
        }
        matrix = fillMatrix(y,x);
        startWindow(matrix);
    }    
        
    public static void main(String[] args) {
        setX(12);
        setY(7);
        start();
    } 
}
