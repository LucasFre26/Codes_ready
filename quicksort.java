import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
		
		int tam = 1000;
		int ovos [] = new int[tam];
		
		System.out.print("O array gerado: ");
		for(int i=0; i<tam; i++) {
			ovos[i]=rand.nextInt(100);
			System.out.print(ovos[i] +" - ");
		}

		long tempoInicial1 = System.currentTimeMillis();
		
		quickSort(ovos, 0, tam-1);

		long tempoFinal1 = System.currentTimeMillis() - tempoInicial1;	
		
		System.out.print("\n\nExecução do quickSort:"
				+ "\nO array ordenado: ");
		for(int re=0; re<tam; re++) {
			System.out.print(ovos[re] +" - ");
		}
		System.out.print("\nO tempo de execuçao do QuickSort foi de: " +tempoFinal1 +"ms\n");
		
		long tempoInicial2 = System.currentTimeMillis();
		
		bubblesort(ovos, tam);
		
		long tempoFinal2 = System.currentTimeMillis() - tempoInicial2;	

		System.out.print("\nExecução do bubbleSort:"
				+ "\nO array ordenado: ");
		for(int re=0; re<tam; re++) {
			System.out.print(ovos[re] +" - ");
		}
		System.out.print("\nO tempo de execuçao do bublleSort foi de: " +tempoFinal2 +"ms");
		
		sc.close();
		
	}
	public static void quickSort(int ovos[], int esquerda, int direita) {
		int i = esquerda;
		int j = direita;
		int pivo = ovos[(i + j)/2];

		while (i <= j) {
			while (ovos[i] < pivo) {
				i++;
			}
			while (ovos[j] > pivo) {
				j--;
			}
			if (i <= j) {
				swap(ovos, i, j);
				i++;
				j--;
			}
		}
		if (j > esquerda) {
			quickSort(ovos, esquerda, j);
		}
		
		if (i < direita) {
			quickSort(ovos, i, direita);
		}
		
	}	
	public static void swap(int ovos[], int i, int j) {
		int vax;
		
		vax = ovos[i];
		ovos[i] = ovos[j];
		ovos[j] = vax;
	}
	public static void bubblesort(int ovos[], int tam) {
		
		for (int i = tam-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (ovos[j] > ovos[j+1]) {                  
					swap(ovos, i, j);
				}
			}
		}
	}

}
