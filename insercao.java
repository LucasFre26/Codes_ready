import java.util.Random;
import java.util.Scanner;

public class insercao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ale = new Random();

		int tam;
		
		System.out.print("Digite a quantidade de elementos do array: ");
		tam=sc.nextInt();
		
		sc.close();
		
		long tempoInicio = System.currentTimeMillis();
		int array[] = new int [tam];
		
		System.out.print("O array gerado:");
		for(int ge=0; ge<tam; ge++) {
			array[ge]=ale.nextInt(100);
			System.out.printf(" %d", array[ge]);
		}
		
		for (int i=1; i<tam; i++) {
			int ax=array[i];
            int j =i-1;
            while ((j >= 0) && (array[j] > ax)) {
                array[j + 1] = array[j];
                j--;
         }
            array[j + 1] = ax;
      }
		
		System.out.printf("\nO array ordenado:");
		for(int or=0; or<tam; or++) {
			System.out.printf(" %d", array[or]);
		}
		
        long tempoTotal = System.currentTimeMillis() - tempoInicio;
        System.out.print("\nO tempo em que levado para ordenar o array foi de: " +tempoTotal +"ms");
	}

}