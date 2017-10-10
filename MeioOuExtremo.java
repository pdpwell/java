package br.com.ray;
import java.util.Scanner;

public class Ray2 {
	public static void main(String[] args) {
		int x;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insira um valor: ");
		x = in.nextInt();
		
		while(x <= 200){
			if (x>50 && x<150) System.out.println(x +" meio");
			else System.out.println(x + " extremo");
			x++;
		}
		
	}

}
