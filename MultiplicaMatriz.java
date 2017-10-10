package br.com.ray;

import java.util.Scanner;

public class MultiplicaMatriz {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Quantas linhas tem a primeira matriz: ");
		int a = in.nextInt();
		System.out.println("Quantas colunas tem a primeira matriz: ");
		int b = in.nextInt();
		System.out.println("Quantas linhas tem a segunda matriz: ");
		int c = in.nextInt();
		System.out.println("Quantas colunas tem a segunda matriz: ");
		int d = in.nextInt();
		
		
		int[][] matriz = new int[a][b];
		int[][] matrix = new int[c][d];
		int[][] dezbarradez = new int[a][d];
		povoarMatriz(matriz);
		povoarMatriz(matrix);
		
		imprimirMatriz(matriz);
		System.out.println();
		imprimirMatriz(matrix);
		System.out.println();
		
		dezbarradez = multiplicaMatriz(matriz, a, b, matrix, c, d);
		imprimirMatriz(dezbarradez);
		
	}
	
	static int[][] multiplicaMatriz(int [][] matriz1,int l1,int c1,int[][] matriz2,int l2,int c2){
			int [][] matriz3 = new int[l1][c2];
			int aux = 0;
			int a = 0;
			int linha = 0;
			int coluna = 0;
			if (c1!=l2)
			System.out.println("Não são multiplicaveis...");
			else{
				for (int i = 0; i < l1; i++) {
					for (int j = 0; j <l1 ; j++) {
						for (int k = 0; k <  c2; k++) {
							aux += matriz1[j][i]*matriz2[i][k];
						}
						matriz3[i][j] = aux;
						aux = 0;
					}
				}
				
			}
			
			
		
		return matriz3;
	}
	
	static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
	}
	
	static int[][] povoarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random()*10);
			}
		}
		return matriz;
	}

}

