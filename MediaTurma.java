package br.com.ray;
import java.util.Scanner;

public class MediaTurma {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		float n1,n2;
		int nAlunos;
		System.out.println("Quantos alunos há na sala: ");
		nAlunos = in.nextInt();
		
		for (int i = 0; i < nAlunos; i++) {
			
			System.out.println("Insira a nota 1: ");
			n1 = in.nextFloat();
			System.out.println("Insira a nota 2: ");
			n2 = in.nextFloat();
			alunoMedia(n1, n2);
			
		}
		
		
	}
	
	static float alunoMedia(float n1, float n2){
		float media = (2*n1 + 3*n2)/5;
		situacaoAluno(media);
		return media;
		
	}
	static float situacaoAluno(float media){
		Scanner in = new Scanner(System.in);
		if(media >= 7){
			System.out.println("Aprovado!");
			System.out.println("Media:" + media);
		}else if(media < 3){
			System.out.println("Se lascou...");
			System.out.println("Media:" + media);
		}else{
			System.out.println("Aluno na final... ");
			System.out.println("Media: " + media);
			System.out.println("Insira a nota final: ");
			float notaFinal = in.nextFloat();
			situacaoFinal(media, notaFinal);
		}
		return media;
		
		
	}
	static void  situacaoFinal(float media, float notaFinal){
		float mediaFinal = (media + notaFinal)/2;
		if(mediaFinal >= 5){
			System.out.println("Aprovado na final...");
			System.out.println("Media Final:" + mediaFinal);	
		}else{
			System.out.println("Reprovado...");
			System.out.println("Media:" + mediaFinal);
		}
	}
}
