package br.com.ray;

import java.util.Scanner;

public class RendimentoMes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double valorInicial,rendimentoMes,valorDesejado;
		int n;
		System.out.println("Quantas vezes o programa seria executado: ");
		n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
			
		System.out.println("Diga o valor inicial: ");
		valorInicial = in.nextDouble();
		
		System.out.println("Diga o rendimento mensal: ");
		rendimentoMes=in.nextDouble();
		
		System.out.println("Diga o valor desejado: ");
		valorDesejado=in.nextDouble();
		
		int z = tempoValorDesejado(valorInicial, rendimentoMes, valorDesejado);
		System.out.println("A Ray vai enricar em " + z + " meses...");
		}
	}
	static int tempoValorDesejado(double valorInicial, double rendimentoMes, double valorDesejado){
		int x = 0;
		rendimentoMes=rendimentoMes/100;
		while(valorInicial < valorDesejado){
			valorInicial=valorInicial+valorInicial*rendimentoMes;
			x++;
		}			
		
		return x;
	}

}
