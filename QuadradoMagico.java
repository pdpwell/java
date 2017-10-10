package br.com.ray;
import java.util.Scanner;

public class QuadradoMagico {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insira o tamanho");
		int x = in.nextInt();
		int [][] matriz = new int [x][x]; 
		int colunas[] = new int[x];
		int linhas[] = new int[x];
		int diagonais[] = new int [2];

		matriz = povoarMatriz(matriz);
		linhas = somaLinhas(matriz, x);
		colunas = somaColunas(matriz, x);
		diagonais[0] = somaDiagonalPrincipal(matriz);
		diagonais[1] = somaDiagonalSecundaria(matriz);
		
		imprimirMatriz(matriz);
		
		for (int i = 0; i < linhas.length; i++) {
			System.out.println("Soma da linha " + i + " = " + linhas[i]);
		}
		
		System.out.println("");
		
		for (int i = 0; i < colunas.length; i++) {
			System.out.println("Soma da coluna " + i + " = " + colunas[i]);
		}
		
		System.out.println("Soma diagonal principal = " + diagonais[0]);
		System.out.println("Soma diagonal secundaria = " + diagonais[1]);
		
		if(EresCuadradoMagico(linhas, colunas, diagonais))
			System.out.println("É quadrado mágico...");
		else
			System.out.println("Foi tapeado...");
		
		}
	
	
	static int[][] povoarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() *10);
			}
		}
		return matriz;
	}
	
	static int somaDiagonalPrincipal(int[][] matriz) {
		int somaDiagonal = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i == j) {
					somaDiagonal += matriz[i][j];
				}
			}
		}
		return somaDiagonal;
	}

	static int somaDiagonalSecundaria(int[][] matriz) {
		int somaDiagonal = 0;
		for (int i = 0; i < matriz.length; i++) {
			somaDiagonal += matriz[i][(matriz.length - 1) - i];
		}
		return somaDiagonal;
	}
	
	static int [] somaLinhas(int[][] matriz,int a){
		int [] vetor = new int [a];
		int x = 0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				x += matriz[i][j];
			}
			vetor[i] = x;
			x = 0;
		}
		
		
		return vetor;
	}
	
	static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
	}
	
	static int [] somaColunas(int[][] matriz,int a){
		int [] vetor = new int [a];
		int x = 0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				x += matriz[j][i];
			}
			vetor[i] = x;
			x = 0;
		}
		
		
		return vetor;
	}
	
	static boolean EresCuadradoMagico(int[] linhas, int [] colunas, int [] diagonais){
		boolean batata = false;
		int a = linhas[0];
		for (int i = 0; i < linhas.length; i++) {
			if(linhas[i] == a)
				batata = true;
				
			else return false;
				
		}
		
		for (int i = 0; i < colunas.length; i++) {
			if(colunas[i] == a)
				batata = true;
				
			else return false;
		}
		
		if(diagonais[0] == a && diagonais[1] == a)
			batata = true;
		else 
			return false;

		return batata;
	}

}
