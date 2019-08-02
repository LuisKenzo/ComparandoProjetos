package agenda;

import java.util.Scanner;

public class Data {

	String data;
	private static int numeroDeVoos = 0;
	public Voo[] listaDeVoos = new Voo[4];
	private Scanner input;

	public Data(String Data) {
		this.data = Data;
	}
	
	public int getNumeroDeVoos() {
		return numeroDeVoos;
	}

	public void adicionaVoo() {

		String nome = null;
		String compania = null;
		String destino = null;
		String partida = null;
		String horarioChegada = null;
		String horarioSaida = null;
		int codigoVoo = -1;
		float precoPrimeiraClasse = 0;
		float precoClasseEconomica = 0;

		input = new Scanner(System.in);

		System.out.println("Entrada de dados");

		System.out.println("Nome do Voo");
		nome = input.nextLine();

		System.out.println("Nome da compania");
		compania = input.nextLine();

		System.out.println("Destino");
		destino = input.nextLine();

		System.out.println("Partida");
		partida = input.nextLine();

		System.out.println("Horario de chegada");
		horarioChegada = input.nextLine();

		System.out.println("Horario de saida");
		horarioSaida =  input.nextLine();

		System.out.println("Código do vôo");
		codigoVoo = input.nextInt();
		
		System.out.println("Preço Primeira Classe");
		precoPrimeiraClasse = input.nextFloat();
		
		System.out.println("Preço Classe Econômica");
		precoClasseEconomica = input.nextFloat();

		listaDeVoos[numeroDeVoos] =  new Voo(nome, compania, destino, partida, horarioChegada, horarioSaida, codigoVoo, precoPrimeiraClasse, precoClasseEconomica);
		Data.numeroDeVoos++;
	}

	public void removeVoo() {
		int i;
		String vooRemovido;
		input = new Scanner(System.in);

		System.out.println("Escolha o voo a ser cancelado");
		vooRemovido = input.nextLine();

		for (i =  0; i < 4; i++) {
			if(vooRemovido.equals(listaDeVoos[i].getNome())) {
				listaDeVoos[i] = null;
				return;
			}
		}

		if (i == 3) {
			System.out.println("Erro! Voo nï¿½o encontrado");
		}
	}

	public int buscaVoo(int codigoVoo) {
		for(int i=0; i < 4; i++) {
			if(listaDeVoos[i].getCodigoVoo() == codigoVoo) {
				return i;
			}
		}
		return -1;
	}
	
	public void imprimeVoosDoDia() {
		for(int i=0; i<4; i++) {
			Voo vooAtual = listaDeVoos[i];
			System.out.println("Voo " +vooAtual.toString());
		}
	}

}
