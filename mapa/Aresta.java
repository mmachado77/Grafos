package mapa;

public class Aresta {
	String nome;
	Vertice cidade1;
	Vertice cidade2;
	int distancia;
	
		Aresta(Vertice cidade1, Vertice cidade2, String nome, int distancia){
			this.nome = nome;
			this.cidade1 = cidade1;
			this.cidade2 = cidade2;
			this.distancia = distancia;
		}
		
		void info() {
			System.out.println("A Rota " + nome + " tem " + distancia + "m e liga " + cidade1.nome + " a " + cidade2.nome + ".");
		}
}
