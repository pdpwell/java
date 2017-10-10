package br.com.ray;
import java.util.Scanner;

public class RendimentosPlus {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tipo;
		double investimento;
		
		System.out.println("Insira o numero de repeticoes: ");
		int n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
		System.out.println("Tipo         Descrição         Taxa de Rendimento");
		System.out.println(" 1           Poupança                 1.5%");
		System.out.println(" 2           Poupança Plus            2.0%");
		System.out.println(" 3           Fundos de renda fixa     4.0%");
		
		System.out.println("      Insira o investimento: ");
		investimento = in.nextDouble();
		System.out.println("      Insira o Tipo de Investimento: ");
		tipo = in.nextInt();
		
		double y = rendimentoMensal(tipo, investimento);
		System.out.printf("%.2f\n", y);
	}
	}
	static double rendimentoMensal(int tipo, double investimento){
		double x = 0;
		if (tipo == 1)
			x = investimento*1.015;
		else if(tipo == 2)
			x = investimento*1.02;
		else if(tipo == 3)
			x=investimento*1.04;
		else
			System.out.println("Insira 1,2 ou 3, bicho burro!");
		return x;
	}

}
