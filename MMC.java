package br.com.ray;
import java.util.Scanner;

public class MMC {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int x,y,z;
		System.out.println("Insira o primeiro numero: ");
		x = in.nextInt();
		System.out.println("Insira o segundo numero: ");
		y = in.nextInt();
		System.out.println("Insira o terceiro numero: ");
		z = in.nextInt();
		System.out.println("O m.m.c de "+ x + ", " + y + " e " + z +" é "  + MMC(x,y,z));
	}
	
	static int MMC(int x, int y, int z ){
		int a = 1;
		boolean b = false;
		while(b == false){
			if(a%x==0 && a%y==0 && a%z==0){
				b = true;
			}else{
			a++;
			}
			
		}
		return a;
		
	}

}
