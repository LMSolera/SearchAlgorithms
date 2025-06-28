package algosdebusca;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass {
    private static int x = 0;
    private static int y = 0;
    private static int[][] matrix;
    private static HashMap<ArrayKey, CelulaMatriz> celulas = new HashMap<>();
    private static JFrame tp = null;
    private static JPanel pm = null;

    public static int[][] fillMatrix (int y, int x) {
        int matrix[][] = new int[y][x];
        
        for (int row = 0; row < y; row++) {
            
            for (int col = 0; col < x; col++) {
                matrix[row][col] = 0;
            }
            
        }
        
        matrix[0][0] = 1;
        matrix[y-1][x-1] = 1;
        
        return matrix;
    }
    
    public static void resetMatrix (int y, int x) {
        matrix = fillMatrix(y,x);      
        
        for (int row = 0; row < y; row++) {
            
            for  (int col = 0; col < x; col++) {
                int coordinate[] = {row, col};
                celulas.get(new ArrayKey(coordinate)).validateState();
            }
            
        }
        
    }
    
    public static void clearCells () {
        for (int row = 0; row < y; row++) {
            
            for  (int col = 0; col < x; col++) {
                int coordinate[] = {row, col};
                celulas.get(new ArrayKey(coordinate)).validateState();
            }
            
        }
    }
    
    public static void printMatrix () {
        System.out.print("\n\n\n");
        
        for (int row = 0; row < y; row++) {
            
            for (int col = 0; col < x; col++) {
                System.out.print (matrix[row][col] + " ");
            }
            
            System.out.print ("\n");
            
        }
    }
    
    public static CelulaMatriz getMatrixCell (int y, int x) {
        int coordinate[] = {y, x};
        return celulas.get(new ArrayKey(coordinate));
    }
    
    private static void startWindow (int matrix[][]) {
        tp = new TelaPrincipal();
        pm = new PainelMatriz();

        for (int row = 0; row < y; row++) {
            
            for (int col = 0; col < x; col++) {
                CelulaMatriz p = new CelulaMatriz();
                
                p.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                p.setCoordinate(row, col);
                
                if (matrix[row][col] == 0) {
                    p.setBackground(Color.white);
                } else {
                    p.setBackground(Color.black);
                }
                
                int coordinate[] = {row, col};
                celulas.put(new ArrayKey(coordinate), p);
                pm.add(p);
            }
            
        }
        
        tp.add(pm, 0);
        tp.setSize(900, 525);
        tp.setLocationRelativeTo(null);
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
    
    public static int[][] getMatrix () {
        return matrix;
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
