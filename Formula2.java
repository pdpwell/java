package br.com.ray;
import java.util.Scanner;

public class Formula2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sinal = -1;
		int incremento = 1;
		
		System.out.println("Insira a quantidade de termos: ");
		int z = in.nextInt();
		
		System.out.println("Insira um numero: ");
		int n = in.nextInt();
		
		double x = 0;
		int fat;
		int a = 1;
		for (int i = 1; i <= z; i++) {
			fat = Fatorial(a);
			x = x + sinal*Math.pow(n, i+1)/fat;
			sinal = sinal*(-1);
			a = a + incremento;
			if(a==4)
				incremento = -1;
			else if(a==1)
				incremento=1;
				
		}
		System.out.println(x);
	}
	
	static int Fatorial(int n){
		int x = 1;
		while (n > 1){
			x = n*x;
			n--;
		}
		 return x;
	}
}
