package mapa;
import java.util.ArrayList;

public class Vertice {
	String nome, nomeLowerCase;
	String nomeVizinho;
	int distanciaVizinho;
	ArrayList<Vertice> vizinhanca = new ArrayList<>();
	ArrayList<Aresta> roads = new ArrayList<>();
		
		Vertice(String nome){
			this.nome = nome;
			this.nomeLowerCase = nome.toLowerCase();
			this.distanciaVizinho = 0;
		}
		
		void setDistancia(int distancia) {
			this.distanciaVizinho = distancia;
		}
		
		void infoVizinhos() {
			System.out.println("- " + nome + ".");
			System.out.println("Vizinhos: ");
			for (int i=0; i<vizinhanca.size(); i++) {
				System.out.println(vizinhanca.get(i).nome + ". Distância: "+ vizinhanca.get(i).distanciaVizinho + "m.");
			}
		}
		
		void info() {
			System.out.println("- " + nome + ".");
			System.out.println("%%%%%%%");
		}
		
		void clearVizinhanca() {
			vizinhanca.clear();
		}
		
		int vizinhancaSize() {
			return vizinhanca.size();
		}		
	
		void ordenaVizinhos() {
			Vertice aux = null;
			int posicoes = vizinhanca.size() - 1;
			for(int i = 0; i<vizinhanca.size(); i++){
				for(int j = 0; j<posicoes; j++){
					if(vizinhanca.get(j).distanciaVizinho > vizinhanca.get(j+1).distanciaVizinho){						
						aux = vizinhanca.get(j);
						vizinhanca.set(j, vizinhanca.get(j+1));
						vizinhanca.set(j+1, aux);						
					}
				}
			posicoes--;
			}
			
		}
		
		void addVizinho(String nomeVizinho) {
			vizinhanca.add(new Vertice(nomeVizinho));
		}
		
		void addRoad(Vertice cidade1, Vertice cidade2, String nomeVia, int distanciaVia) {
			roads.add(new Aresta(cidade1, cidade2, nomeVia, distanciaVia));
		}
		
}
