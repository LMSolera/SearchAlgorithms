package algosdebusca;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LibBusca {

    public static void runWidthSearch () {
        HashMap<Integer, CelulaMatriz>vertices = new HashMap<Integer, CelulaMatriz>();
        int fim[] = new int[3];
        fim[0] = MainClass.getY() - 1;
        fim[1] = MainClass.getX() - 1;
        int numVertices = 0;

        for (int row = 0; row < MainClass.getY(); row++) {

            for (int col = 0; col < MainClass.getX(); col++) {

                if (MainClass.getMatrix()[row][col] == 1) {
                    MainClass.getMatrixCell(row, col).setVerticeIndex(numVertices);
                    vertices.put(numVertices, MainClass.getMatrixCell(row, col));
                    numVertices++;
                }

            }

        }
        
        fim[2] = MainClass.getMatrixCell(fim[0], fim[1]).getVerticeIndex();
        BuscaLargura bl = new BuscaLargura(numVertices);

        for (int row = 0; row < MainClass.getY(); row++) {

            for (int col = 0; col < MainClass.getX(); col++) {

                if (MainClass.getMatrix()[row][col] == 1) {

                    if (row  + 1 < MainClass.getY()) {

                        if (MainClass.getMatrixCell(row+1, col).getVerticeIndex() != -1) {
                            bl.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row+1, col).getVerticeIndex());
                        }

                    }

                    if (row - 1 > -1) {

                        if (MainClass.getMatrixCell(row-1, col).getVerticeIndex() != -1) {
                            bl.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row-1, col).getVerticeIndex());
                        }

                    }

                    if (col + 1 < MainClass.getX()) {

                        if (MainClass.getMatrixCell(row, col+1).getVerticeIndex() != -1) {
                            bl.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row, col+1).getVerticeIndex());
                        }

                    }

                    if (col - 1 > -1) {

                        if (MainClass.getMatrixCell(row, col-1).getVerticeIndex() != -1) {
                            bl.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row, col-1).getVerticeIndex());
                        }

                    }

                }

            }

        }
        
        LinkedHashSet<Integer> resultado = bl.buscaLarguraGrafo(0);
        
        if (resultado.contains(fim[2])) {
            
            for (int busca : resultado) {
                vertices.get(busca).setBackground(Color.green);
                
                if (busca == fim[2]) {
                    break;
                }
            }
            
        } else {
            
            new InvalidPath().setVisible(true);
            
        }

    }
    
    public static void runDepthSearch () {
        HashMap<Integer, CelulaMatriz>vertices = new HashMap<Integer, CelulaMatriz>();
        int numVertices = 0;
        int fim[] = new int[3];
        fim[0] = MainClass.getY() - 1;
        fim[1] = MainClass.getX() - 1;

        for (int row = 0; row < MainClass.getY(); row++) {

            for (int col = 0; col < MainClass.getX(); col++) {

                if (MainClass.getMatrix()[row][col] == 1) {
                    MainClass.getMatrixCell(row, col).setVerticeIndex(numVertices);
                    vertices.put(numVertices, MainClass.getMatrixCell(row, col));
                    numVertices++;
                }

            }

        }

        fim[2] = MainClass.getMatrixCell(fim[0], fim[1]).getVerticeIndex();
        BuscaProfundidade bf = new BuscaProfundidade(numVertices);

        for (int row = 0; row < MainClass.getY(); row++) {

            for (int col = 0; col < MainClass.getX(); col++) {

                if (MainClass.getMatrix()[row][col] == 1) {

                    if (row  + 1 < MainClass.getY()) {

                        if (MainClass.getMatrixCell(row+1, col).getVerticeIndex() != -1) {
                            bf.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row+1, col).getVerticeIndex());
                        }

                    }

                    if (row - 1 > -1) {

                        if (MainClass.getMatrixCell(row-1, col).getVerticeIndex() != -1) {
                            bf.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row-1, col).getVerticeIndex());
                        }

                    }

                    if (col + 1 < MainClass.getX()) {

                        if (MainClass.getMatrixCell(row, col+1).getVerticeIndex() != -1) {
                            bf.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row, col+1).getVerticeIndex());
                        }

                    }

                    if (col - 1 > -1) {

                        if (MainClass.getMatrixCell(row, col-1).getVerticeIndex() != -1) {
                            bf.adicionarArestas(MainClass.getMatrixCell(row, col).getVerticeIndex(), 
                                    MainClass.getMatrixCell(row, col-1).getVerticeIndex());
                        }

                    }

                }

            }

        }
        
        LinkedHashSet<Integer> resultado = bf.buscaProfundidadeGrafo(0);
        
        if (resultado.contains(fim[2])) {
            
            for (int busca : resultado) {
                vertices.get(busca).setBackground(Color.green);
                
                if (busca == fim[2]) {
                    break;
                }
                
            }
            
        } else {
            
            new InvalidPath().setVisible(true);
            
        }
    }
}

class BuscaLargura {
	private LinkedList<Integer>[] listaAdjacencia;

	public BuscaLargura(int numVertices) {
            listaAdjacencia = new LinkedList[numVertices];
            
            for (int i = 0; i < numVertices; i++) {
                    listaAdjacencia[i] = new LinkedList<>();
            }
            
	}

	public void adicionarArestas(int verticeOrigem, int verticeDestino) {
            listaAdjacencia[verticeOrigem].add(verticeDestino);
	}

	public LinkedHashSet<Integer> buscaLarguraGrafo(int verticeInicial) {
            LinkedHashSet<Integer> verticesVisitado = new LinkedHashSet<>();
            Queue<Integer> filaPercurso = new LinkedList<>();

            verticesVisitado.add(verticeInicial);
            filaPercurso.add(verticeInicial);

            while (!filaPercurso.isEmpty()) {

                    int verticeAtual = filaPercurso.poll();
                    verticesVisitado.add(verticeInicial);

                    for (int verticeAdjacente : listaAdjacencia[verticeAtual]) {
                        
                            if (!verticesVisitado.contains(verticeAdjacente)) {
                                    verticesVisitado.add(verticeAdjacente);
                                    filaPercurso.add(verticeAdjacente);
                            }
                            
                    }
            }
            
            return verticesVisitado;
	}
}

class BuscaProfundidade {

	private LinkedList<Integer>[] listaAdjacencia;

	public BuscaProfundidade(int numVertices) {
		listaAdjacencia = new LinkedList[numVertices];
		for (int i = 0; i < numVertices; i++) {
			listaAdjacencia[i] = new LinkedList<>();
		}
	}

	public void adicionarArestas(int verticeOrigem, int verticeDestino) {
	
		listaAdjacencia[verticeOrigem].add(verticeDestino);
	}

	
	public LinkedHashSet<Integer> buscaProfundidadeGrafo(int verticeInicial) {
		
		LinkedHashSet<Integer> verticesVisitado = new LinkedHashSet<>();
		Stack<Integer> pilhaPercurso = new Stack<>();

		pilhaPercurso.push(verticeInicial);
		verticesVisitado.add(verticeInicial);

		while (!pilhaPercurso.isEmpty()) {
			int verticeAtual = pilhaPercurso.pop();
			verticesVisitado.add(verticeAtual);

			for (int verticeAdjacente : listaAdjacencia[verticeAtual]) {
				if (!verticesVisitado.contains(verticeAdjacente)) {
					pilhaPercurso.push(verticeAdjacente);
					verticesVisitado.add(verticeAdjacente);
				}
			}
		}
		return verticesVisitado;
	}
}