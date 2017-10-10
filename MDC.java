package br.com.ray;
import java.util.Scanner;
public class MDC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x, y, z, n;
		System.out.println("Quantas vezes o programa será executado?");
		n = in.nextInt();
		
		
		
		for (int i = 0; i < n; i++) {
			System.out.println("Insira o primeiro numero: ");
			x = in.nextInt();
			System.out.println("Insira o segundo numero: ");
			y = in.nextInt();
			System.out.println("Insira o terceiro numero: ");
			z = in.nextInt();
			
			System.out.println("O M.D.C de "+ x + ", " + y + " e " + z +" é "  + MDC(x,y,z));
			
		}
		
		
		
		
	}
	static int MDC(int x, int y, int z){
		int a = x+y+z;
		boolean b = false;
		while(b == false){
			if(x%a==0 && y%a==0 && z%a==0)
				b = true;
			else
				a--;
		}
		
		
		return a;
	}

}
