package br.com.ray;
import java.util.Scanner;

public class Formula1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Insira um valor: ");
		int n = in.nextInt();
		
		double e = 1;
		double fat;
		
		for (int i = 1; i <= n; i++) {
			fat = Fatorial(i);
			e=e+(1/fat);
			System.out.println(e);
			}
			
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
