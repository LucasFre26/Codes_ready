import java.util.Scanner;

public class lista {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tam=0, pri=0, ult=0, num=1, po=0, indiceIs=0;
		
		System.out.print("Digite o tamanho da sua lista: ");
		tam=sc.nextInt();
		
		int lista[] = new int [tam+1];
		
		System.out.print("\n...Inicializando o menu de opcoes...\n"
				+ "\nPara inserir um novo elemento digite 'i'"
				+ "\nPara remover digite 'r'"
				+ "\nPara checar se ha campos vazios digite 'c'"
				+ "\nPara pesquisar um elemento digite 'p'"
				+ "\nPara sair digite 'exit'");
		
		menu(tam, pri, ult, lista, num, po, indiceIs);
		
		sc.close();
	}
	public static void menu (int pos, int pri, int ult, int lista[], int num, int po, int indiceIs) {
		Scanner te = new Scanner(System.in);
		char op; int pe=1;
		
		System.out.print("\n\nEscolha a sua opcao: ");
		op = te.next().charAt(0);
		
		if(op == 'i' || op == 'I') {
			inserir(lista, pri, ult, num, pos, po, indiceIs);
		} 
        if(op == 'r' || op == 'R') {
			remover(lista, pri, ult, pos, po, num, indiceIs);
		}
        if(op == 'c' || op == 'C') {
			System.out.printf("\nE %b que existem espacos vazios na lista\n", isVazio(lista, pos, num, indiceIs));
			mostrarRec(lista, pos, pri, ult, num, po, indiceIs);
		}
        if(op == 'p' || op == 'P') {        	
        	System.out.print("\nDigite o elemento que deseja pesquisar: ");
    		pe=te.nextInt();
    		
			System.out.print("" +pesquisar(lista, pos, po, pe) +" que esta no array\n");

        	mostrarRec(lista, pos, pri, ult, num, po, indiceIs);
        }
        else {
        	System.out.print("...Fim do programa...");
        	te.close();
        }
	}
	public static void inserir (int lista[], int primeiro, int ultimo, int num, int pos, int po, int Is) {
		Scanner en = new Scanner(System.in);
		
		if(((ultimo+1) % lista.length) == primeiro) {
			System.err.print("\n...Error...\n"
					+ "Tamanho da lista excedido\n\n");
		}
		else {
			System.out.print("\nDigite o elemento a ser inserido: ");
    		num = en.nextInt();	
        	lista[ultimo] = num;
	    	ultimo = (ultimo+1) % lista.length;
	    	Is++;
		}
		mostrarRec(lista, pos, primeiro, ultimo, num, po, Is);
		
		en.close();
	}
	public static void remover (int lista[], int primeiro, int ultimo, int pos, int po, int num, int Is) {
		int rem=0;
		
		if (primeiro == ultimo) {
			System.err.printf("\n..Error...\n"
					+ "Nao exitem elementos a serem excluidos\n\n", rem);
		}
		else {
			rem = lista[primeiro];
			primeiro = (primeiro+1) % lista.length;
			Is--;
		}
		mostrarRec(lista, pos, primeiro, ultimo, num, po, Is);
	}
	public static void mostrarRec(int lista[], int pos, int primeiro, int ultimo, int num, int po, int is) {
		int m = primeiro;
		
		if(is == 0) {
			System.err.print("\n...Nenhum elemento encontrado na lista...");
		}
		else {
			System.out.print("\nLista feita:");
    		while(m!= ultimo) {
    			System.out.printf(" %d -", lista[m]);
    			m=(m+1) % lista.length;
         	}
		}
		
		menu(pos, primeiro, ultimo, lista, num, po, is);
	}
	public static boolean isVazio(int lista[], int tam, int num, int Is) {
		boolean check = true;
		
		for(int i=0; i<tam; i++) {
			if(Is == tam) {
				check = false;
			}
		}
		return check;
	}
	public static boolean pesquisar(int lista[], int tam, int po, int pe) { 
		boolean check = false;
		
		for(int i=0; i<tam; i++) {
			if(lista[i] == pe) {
				check = true;
				if(check == true) {
					System.out.printf("\nO elemento %d esta na posicao %d sendo ", pe, retornaPos(i));
				}
				else {
					System.out.printf("\nE %b que o elemento %d esta no array\n", pesquisar(lista, tam, po, pe), pe);
				}
			}
		}
		return check;
	}
	public static int retornaPos(int posicao) {return posicao;}
}