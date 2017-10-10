package br.com.ray;
import java.util.Scanner;

public class InverteMatriz {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insira o numero de linhas: ");
		int a = in.nextInt();
		System.out.println("Insira o numero de colunas: ");
		int b = in.nextInt();
		
		int [][] matriz = new int [a][b];
		
		povoarMatriz(matriz);
		imprimirMatriz(matriz);
		inverteLinhas(matriz,a,b-1);
		imprimirMatriz(matriz);
	}
		
		
	
	static int[][] povoarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() *10);
			}
		}
		return matriz;
	}
	
	static int [][] inverteLinhas(int[][] matriz, int lin, int col){
		int aux = 0;
		for (int i = 0; i < lin; i++) {
			for (int j = 0; j <= col/2; j++) {
				aux = matriz[i][col-j];
				matriz[i][col-j] = matriz[i][j];
				matriz[i][j] = aux;
			}
			
		}
		
		
		return matriz;
	}
	
	static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println("\n");
		}

	}
}
