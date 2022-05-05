import java.util.Random;

public class trabalhopascoal{

	public static void main(String[] args) {
        Random rand = new Random();
		
		int tam = 1000, esq=0, dir=tam;
		int ovos [] = new int[tam];
		
		System.out.print("O array gerado: ");
		for(int i=0; i<tam; i++) {
			ovos[i]=rand.nextInt(100);
			System.out.print(ovos[i] +" - ");
		}
		
		quick(ovos, tam, esq, dir);
		
		System.out.print("\nO array ordenado:");
		for(int re=0; re<tam; re++) {
			System.out.printf(" %d-", ovos[re]);
		}
	}
	public static void quick(int ovos[], int tam, int esq, int dir) {
		int i=esq, j=dir, pivo = ovos[(esq+dir)/2];
		
		while(i<=j) {
			while(ovos[i]<pivo) {
				i++;
			}
			while(ovos[i]>pivo) {
				j--;
			}
			if(i<=j) {
				swap(i, j);
				i++;
				j--;
			}
			if (esq < j) {
				quick(ovos, tam, esq, j);
				if (i < dir) 
     				quick(ovos, tam, i, dir);
				}
		}
	}
	public static void swap(int i, int j) {
		int vax=0;
		
		vax = i;
		i = j;
		j = vax;
	}

}