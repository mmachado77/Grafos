package mapa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grafo {
	ArrayList<Vertice> cidades = new ArrayList<>();
	ArrayList<Aresta> conexoes = new ArrayList<>();
		
		Grafo(ArrayList<Vertice> cidades, ArrayList<Aresta> conexoes){
			this.cidades = cidades;
			this.conexoes = conexoes;
		}
		
		void ordenaCidades() {
			ArrayList<String> cidadesNome = new ArrayList<>();
			ArrayList<Vertice> cidadesTemp = new ArrayList<>();
				for (int i=0; i<cidades.size(); i++) {
					String nomecidade;
					nomecidade = cidades.get(i).nome;
					cidadesNome.add(nomecidade);
				}	
			Collections.sort(cidadesNome);
				for (int i=0; i<cidadesNome.size(); i++) {
					for (int j=0; j<cidades.size(); j++) {
						if(cidadesNome.get(i)==cidades.get(j).nome) {
							cidadesTemp.add(cidades.get(j));
						}
					}
				}
			cidades = cidadesTemp;
		}
		
		void infoCidades() {
			for (int i=0; i<cidades.size(); i++) {
				cidades.get(i).info();
			}			
		}
				
		void checkVizinhos() {
			int z = 0;
			for (int i=0; i<(cidades.size()); i++) {
				cidades.get(i).clearVizinhanca();
			}
			for (int i=0; i<(cidades.size()); i++) {
				for (int j=0; j<(conexoes.size()); j++) {
					if(cidades.get(i).nome.equals(conexoes.get(j).cidade1.nome)) {
						z = cidades.get(i).vizinhancaSize();
						cidades.get(i).addVizinho(conexoes.get(j).cidade2.nome);
						cidades.get(i).vizinhanca.get(z).distanciaVizinho = conexoes.get(j).distancia;
						
					}
					if(cidades.get(i).nome.equals(conexoes.get(j).cidade2.nome)) {
						z = cidades.get(i).vizinhancaSize();
						cidades.get(i).addVizinho(conexoes.get(j).cidade1.nome);
						cidades.get(i).vizinhanca.get(z).distanciaVizinho = conexoes.get(j).distancia;
					}
				}
			}
			for (int i=0; i<(cidades.size()); i++) {
				cidades.get(i).ordenaVizinhos();
			}
		}
	
		
		void checkConexoes() {			
			for (int i=0; i<(cidades.size()); i++) {
				for (int j=0; j<(conexoes.size()); j++) {
					if(cidades.get(i).nome.equals(conexoes.get(j).cidade1.nome)) {
						cidades.get(i).addRoad(cidades.get(i), conexoes.get(j).cidade2, conexoes.get(j).nome, conexoes.get(j).distancia );
					}
					if(cidades.get(i).nome.equals(conexoes.get(j).cidade2.nome)) {
						cidades.get(i).addRoad(cidades.get(i), conexoes.get(j).cidade1, conexoes.get(j).nome, conexoes.get(j).distancia );
					}
				}
			}
		}
		
		void infoConexoes() {
			for (int i=0; i<conexoes.size(); i++) {
				conexoes.get(i).info();
			}
			
		}
		
		void adicionarCidade() {
			Scanner tCidade = new Scanner(System.in);
			String nome;
			tCidade.reset();
			System.out.println("Digite o nome da Cidade:");
			nome = tCidade.nextLine();
			cidades.add(new Vertice(nome));
		}
		
		void adicionarConexao() {
			Scanner tConexao = new Scanner(System.in);
			Scanner tDistancia = new Scanner(System.in);
			Vertice cidade1, cidade2;
			cidade1 = new Vertice("");
			cidade2 = new Vertice("");
			String cidadeBusca, nomeVia;
			int distancia;
			System.out.println("Escolha a primeira cidade: ");
			cidadeBusca = tConexao.nextLine();
			cidadeBusca = cidadeBusca.toLowerCase();
				for (int i=0; i<cidades.size(); i++) {
					if(cidades.get(i).nomeLowerCase.equals(cidadeBusca)) {
						cidade1 = cidades.get(i);
					}
				}
			tConexao.reset();
			System.out.println("Escolha a segunda cidade: ");
			cidadeBusca = tConexao.nextLine();
			cidadeBusca = cidadeBusca.toLowerCase();
				for (int i=0; i<cidades.size(); i++) {
					if(cidades.get(i).nomeLowerCase.equals(cidadeBusca)) {
						cidade2 = cidades.get(i);
					}
				}
			tConexao.reset();
			System.out.println("Digite o nome da Via: ");
			nomeVia = tConexao.nextLine();
			System.out.println("Digite a distância entre as cidades: ");
			distancia = tDistancia.nextInt();
			conexoes.add(new Aresta(cidade1, cidade2, nomeVia, distancia));
		}
		
		void procurarVizinhos() {
			Scanner tConexao = new Scanner(System.in);
			Vertice cidade1, cidade2;
			cidade1 = new Vertice("");
			cidade2 = new Vertice("");
			String cidadeBusca;
			System.out.println("Digite o nome da cidade: ");
			cidadeBusca = tConexao.nextLine();
			cidadeBusca = cidadeBusca.toLowerCase();
				for (int i=0; i<cidades.size(); i++) {
					if(cidades.get(i).nomeLowerCase.equals(cidadeBusca)) {
						cidades.get(i).infoVizinhos();
					}
				}
			
		}
		
		void cadastroKanto() {
			Vertice pallet = new Vertice("Pallet Town");
			cidades.add(pallet);
			Vertice veridian = new Vertice("Viridian City");
			cidades.add(veridian);
			Vertice pewter = new Vertice("Pewter City");
			cidades.add(pewter);
			Vertice cerulean = new Vertice("Cerulean City");
			cidades.add(cerulean);
			Vertice celadon = new Vertice("Celadon City");
			cidades.add(celadon);
			Vertice saffron = new Vertice("Saffron City");
			cidades.add(saffron);
			Vertice lavender = new Vertice("Lavender Town");
			cidades.add(lavender);
			Vertice vermillion = new Vertice("Vermillion City");
			cidades.add(vermillion);
			Vertice cinnabar = new Vertice("Cinnabar Island");
			cidades.add(cinnabar);
			Vertice fuschia = new Vertice("Fuschia City");
			cidades.add(fuschia);
			
			Aresta route1 = new Aresta(pallet, veridian, "Route 1", 1000);
			conexoes.add(route1);
			Aresta viridanFor = new Aresta(veridian, pewter, "Viridian Forest", 2000);
			conexoes.add(viridanFor);
			Aresta route3 = new Aresta(pewter, cerulean, "Route 3", 5000);
			conexoes.add(route3);
			Aresta rockTunnel = new Aresta(cerulean, lavender, "Rock Tunnel", 3500);
			conexoes.add(rockTunnel);
			Aresta route5 = new Aresta(cerulean, saffron, "Route 5", 1000);
			conexoes.add(route5);
			Aresta route8 = new Aresta(saffron, lavender, "Route 8", 1400);
			conexoes.add(route8);
			Aresta route6 = new Aresta(saffron, vermillion, "Route 6", 1500);
			conexoes.add(route6);
			Aresta route7 = new Aresta(saffron, celadon, "Route 7", 900);
			conexoes.add(route7);
			Aresta route17 = new Aresta(celadon, fuschia, "Route 17", 8000);
			conexoes.add(route17);
			Aresta route13 = new Aresta(lavender, fuschia, "Route 13", 8000);
			conexoes.add(route13);
			Aresta route14 = new Aresta(vermillion, fuschia, "Route 14", 8500);
			conexoes.add(route14);
			Aresta seafoam = new Aresta(fuschia, cinnabar, "Seafoam Islands", 4000);
			conexoes.add(seafoam);
			Aresta route21 = new Aresta(cinnabar, pallet, "Route 21", 1500);
			conexoes.add(route21);
		}
}
