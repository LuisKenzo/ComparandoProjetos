package agenda;

import java.util.Arrays;
import usuario.*;
import agenda.*;


public class Voo {

	private String nome;
	private String compania;
	private String destino;
	private String partida;
	private String horarioChegada;
	private String horarioSaida;
	private int poltronasVazias;
	private int poltronasCheias;
	private int codigoVoo;

	Poltrona[][] Primeira = new Poltrona[4][4];
	Poltrona[][] Economica = new Poltrona[4][4];

	public Voo (String nome, String compania,String destino, String partida, String horarioChegada, String horarioSaida, int codigoVoo) {

		this.nome = nome;
		this.compania =  compania;
		this.destino =  destino;
		this.partida =  partida;
		this.horarioChegada = horarioChegada;
		this.horarioSaida = horarioSaida;
		this.poltronasVazias = 32; //Total de poltronas no avião =  32 para todos os aviões.
		this.poltronasCheias = 0;
		setCodigoVoo(codigoVoo);

		this.Primeira = null;
		this.Economica = null;
	}
	
	//Comprar poltronas;
	public void adicionaPoltrona (String Cliente, String Classe, int numeroDeCadeiras, int tipo) {
		int i, j, k = 0;

		/*
		 * tipo 1 = lado a lado.
		 * tipo 2 = não importa.
		 */

		if (tipo == 2 && Classe.equals("Primeira")) {
			for (i = 0; i < 4; i++) {
				for ( j = 0; j < 4; j++) {
					if(Primeira[i][j] == null) {
						Primeira[i][j] =  new Poltrona(Cliente);
						k++;
					}
				}
			}
		} else if (tipo == 2 && Classe.equals("Economica")) {
			for (i = 0; i < 4; i++) {
				for ( j = 0; j < 4; j++) {
					if(Economica[i][j] == null) {
						Economica[i][j] = new Poltrona(Cliente);
						k++;
					}
				}
			}
		} else if (tipo == 1 && Classe.equals("Primeira")){
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					if(Primeira[i][j] == null) {

						//percorre o resto da fileira checkando as cadeiras.
						for (k = 1; k < numeroDeCadeiras; k++) {
							if(Primeira[i][j+k] != null)
								break;
						}

						//Caso existam cadeiras lado a lado suficientes.
						if (k == numeroDeCadeiras - 1) {

							//Adiciona poltronas na fileira.
							for (k = 0; k < numeroDeCadeiras; k++) {
								Primeira[i][j+k] = new Poltrona(Cliente);
							}
						}
					}
				}
			}
		} else if (tipo == 1 && Classe.equals("Economica")){
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					if(Economica[i][j] == null) {

						//percorre o resto da fileira checkando as cadeiras.
						for (k = 1; k < numeroDeCadeiras; k++) {
							if(Economica[i][j+k] != null)
								break;
						}

						//Caso existam cadeiras lado a lado suficientes.
						if (k == numeroDeCadeiras - 1) {

							//Adiciona poltronas na fileira.
							for (k = 0; k < numeroDeCadeiras; k++) {
								Economica[i][j+k] = new Poltrona(Cliente);
							}
						}
					}
				}
			}
		} else {
			//Erro
		}

		this.poltronasVazias =  this.poltronasVazias -  numeroDeCadeiras;
		this.poltronasCheias = this.poltronasCheias + numeroDeCadeiras;
	}

	public Poltrona[][] getPoltronas(String classe) {

		if(classe.equals("Primera"))
			return this.Primeira;
		else
			return this.Economica;
	}

	@Override
	public String toString() {
		return "Voo [compania=" + compania + ", destino=" + destino + ", horarioChegada=" + horarioChegada
				+ ", horarioSaida=" + horarioSaida + ", nome=" + nome + ", partida=" + partida + ", poltronasCheias="
				+ poltronasCheias + ", poltronasVazias=" + poltronasVazias + "]";
	}

	public String getNome() {
		return nome;
	}

	public String getCompania() {
		return compania;
	}

	public String getDestino() {
		return destino;
	}

	public String getPartida() {
		return partida;
	}

	public String getHorarioChegada() {
		return horarioChegada;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public int getPoltronasVazias() {
		return poltronasVazias;
	}

	public int getPoltronasCheias() {
		return poltronasCheias;
	}
	
	public void setCodigoVoo(int codigoVoo) {
		this.codigoVoo = codigoVoo;
	}

	public int getCodigoVoo(){
		return codigoVoo;
	}
}
