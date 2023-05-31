package mapa;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Vertice> cidades = new ArrayList<>();
		ArrayList<Aresta> conexoes = new ArrayList<>();
		Grafo g1 = new Grafo(cidades, conexoes);
		menu(g1);

	}
	
	public static void menu(Grafo g1) {
		Scanner teclado = new Scanner (System.in);
		int input;
		input = 69;
			while(input!=0) {
				teclado.reset();
				System.out.println("\nEscolha uma opção: \n 1 - Cadastrar Cidade. \n 2 - Cadastrar Conexão."
						+ "\n 3 - Listar Cidades. \n 4 - Listar Conexões. \n 5 - Procurar por cidades vizinhas."
						+ "\n 9 - Importar o Mapa da Região de Kanto. \n 0 - Encerrar atividades.");
				input = teclado.nextInt();
					if (input==1) {
						g1.adicionarCidade();
						teclado.reset();
					}
					if (input==2) {
						g1.adicionarConexao();						
					}
					if (input==3) {
						g1.ordenaCidades();
						System.out.println("Cidades cadastradas:");
						g1.infoCidades();
					}
					if (input==4) {
						g1.checkConexoes();
						System.out.println("Conexões cadastradas:");
						g1.infoConexoes();
					}
					if (input==5) {
						g1.checkVizinhos();
						g1.procurarVizinhos();
						
					}
					if(input==9) {
						g1.cadastroKanto();						
					}
			}
		
	}
}
