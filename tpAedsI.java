/* Objetivo: Otimiza��o das vendas de mascaras para auxilia-lo no registro de vendas, o registro do estoque e gerar 
 * o lucro obtido durante 1 dia de vendas.
 * Nome: Lucas Jose de Freitas 
 * Data da escrita: 09/12/2021
 * �ltima atualiza��o: 16/12/2021 �s 10:54
 * */ 

import java.util.Scanner;

public class tpAedsI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char flag = 's';
		double producao [] = new double [4];
    	double prevenda [] = new double [4];
    	int dia=1;

/*Os vetores 'producao e prevenda' registram respectivamente o valor de produ��o e o valor de venda 
 * dos tipos de m�scaras e as tornam constantes para realizar os pr�ximos c�culos
 * */
		System.out.print("--Para o registro das vendas, assuma--"
	    			+ "\nProduto 1 = Mascara para Crian�a lisa"
		    		+ "\nProduto 2 = Mascara para Crian�a Estampada"
	    			+ "\nProduto 3 = Mascara para Adulto Lisa"
	    			+ "\nProduto 4 = Mascara para Adulto Estampada\n\n");
		
   		for(int pr=0; pr<4; pr++) {
   			System.out.printf("Digite o valor de produ��o do Produto %d: ", pr+1);
        	producao[pr]=sc.nextDouble();
   		}
    		
		System.out.println();
   		for(int pe=0; pe<4; pe++) {
   			System.out.printf("Digite o valor de venda do Produto %d: ", pe+1);
            prevenda[pe]=sc.nextDouble();
   		}
   		
/*Os vetores 'estoque e registra', guardam os valores respectivamente do Estoque antes das vendas e a
 * quantidade vendidas dos respectivos produtos, sendo que o vetor 'regista' apenas permite a venda 
 * de produtos em estoque
 * */    		
		while(flag == 's') {
		    double estoque  [] = new double [4];
    		double registra [] = new double [4];	
    		
    		
    		System.out.println();
    	  	for(int es=0; es<4; es++) {
	    		System.out.printf("Digite a quantidade em estoque do Produto %d: ", es+1);
		        estoque[es]=sc.nextDouble();
    		}
		
    		System.out.println();
    		for(int re=0; re<4; re++) {
    			if(estoque[re] == 0) {
     				System.err.printf("...Venda do produto %d n�o est� dispon�vel...\n", re+1);
    				registra[re]=0;
    			}
     			else {
    				System.out.printf("Digite a quantidade vendida do Produto %d: ", re+1);
    			    registra[re]=sc.nextDouble();
    			}
    			if(registra[re]-estoque[re]>0) {
     				System.err.printf("\n    ...A venda do produto %d superou o estoque dispon�vel..."
     						+ "\n__Considera-se a quantidade do produto %d registrada em estoque__"
     						+ "\n           -Para melhor apura��o reenicie o programa-\n\n", re+1, re+1);
    				registra[re]=estoque[re];
      			}
    		}
		
     		analisacalculos(prevenda, registra, estoque, producao, dia);
			
    		System.out.print("\nDeseja registrar um novo dia? (Sim = s/N�o = n): ");
    		flag=sc.next().charAt(0);
		
    		System.out.println();
    		
    		dia++;
		}
		sc.close();
	}
	
/**O pr�ximo procedimento, 'analisacalculos', recebe os valores dos vetores 'estoque, producao, prevenda
 * e registra', declarados no main e um vetor 'atualestoque' registra o valor atualizado das mascaras em 
 * estoque depois das vendas do dia. Como o vetor 'lucro' registra o valor total da venda menos o custo
 * de produ��o da mascara, baseados na subtra��o do produto do pre�o de venda e a quantiadde vendida
 * e o produto do pre�o de produ��o e quantidade vendida.
 * */
	
	public static void analisacalculos(double preco[], double quantidade[], double estoque[], double producao[], int dia) {
		double atualestoque [] = new double [4];
		double lucro [] = new double [4];
		
		for(int i=0; i<4; i++) {
			atualestoque[i]=estoque[i]-quantidade[i];
		}
		
		for(int lu=0; lu<4; lu++) {
			if(quantidade[lu] == 0) {
				lucro[lu]=0;
			}
			else {
				lucro[lu]=(preco[lu]*quantidade[lu])-(producao[lu]*quantidade[lu]);
			}
		}
		resultadomatriz(preco, quantidade, estoque, atualestoque, lucro, producao, dia);
	} 
	
/**O pr�ximos procedimento recebe os vetores 'preco, quantidade, estoque, atualestoque, lucro, producao'
 * registra na matri 'matriz' colocando os valores de cada vetor organizado por linha.
 * Devolvendo a impriss�o formatada da matriz na tela.
 */
	
	public static void resultadomatriz(double prevenda [], double quantidade [], double estoque [], double aestoque [], double lucro [], double producao[], int dia) {
		double matriz [][] = new double [4][7];
		
		for(int i=0; i<4; i++) {
			matriz[i][0]=i+1;
			matriz[i][1]=prevenda[i];
			matriz[i][2]=producao[i];
			matriz[i][3]=quantidade[i];
			matriz[i][4]=estoque[i];
			matriz[i][5]=aestoque[i];
			matriz[i][6]=lucro[i];
		}
		
		System.out.print("\nLegenda:"
				+ "\nPrec - Pre�o de venda  ||  Prod - Pre�o de produ��o"
				+ "\nVend - Quantidade por pe�a vendida  ||  Esto - Estoque antes das vendas"
				+ "\nQved - Estoque restante ap�s as vendas do dia  ||  Lucr - Lucro total obtido por pe�a vendida no dia");
		
		System.out.printf("\nMatriz gerada com os Relatorios finais:"
				+ "\nCada linha da matriz se refere a um dos produtos\n"
				+ "\n     Dia %d"
				+ "\n                Prec     Prod     Vend     Esto     Qved     Lucr\n", dia);
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<7; j++) {
				if(j == 0) {
					System.out.printf("Produto %.0f -", matriz[i][j]);
				}
				else {
					System.out.printf("     %.2f", matriz[i][j]);
				}
			}
			System.out.println();
		}
	}
}