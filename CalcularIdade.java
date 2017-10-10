package br.com.ray;
import java.util.Scanner;


public class Teste {
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		int d,m,a,t = 0;
		
		System.out.println("Insira o dia que você nasceu: ");
		d = in.nextInt();
		System.out.println("Insira o mês que você nasceu: ");
		m = in.nextInt();
		System.out.println("Insira o ano que você nasceu: ");
		a= in.nextInt();
		
		while(a<2017){
			if (a%4 == 0) t+= 366;
			else t+= 365;
			a++;
			//j 31, f 28,m 31, a 30, m 31, j 30, j 31, a 31, s 30, o 31,n 30, d 31
			
			
		}
		while (a == 2017 && m < 7){
			if (m==1||m==3||m==5||m==7||m==8||m==10||m==12) t += 31;
			else if(m==2) t += 28;
			else if(m==4||m==6||m==9||m==11) t+= 30;
			m++;
		}
		if (d > 18){
			t-=30;
			t+=(30+(18-d));
			
		}
		while(a == 2017 && m == 7 && d < 18){
			t++;
			d++;
		}
		System.out.println(t);
		
	}
}
