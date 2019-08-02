package usuario;

import usuario.Compra;
import agenda.Voo;
import agenda.Poltrona;

public class Compras {
	Compra[] compra = new Compra[1000];
	private int indice;
	public Compras() {
		indice = -1;
	}
	
	public void salvarCompra(Voo voo, Poltrona poltrona) {
		indice++;
		compra[indice] = new Compra(voo, poltrona);
	}
	
	public Compra[] getCompra() {
		return compra;
	}
	
	public void imprimeCompras() {
		for(int i=0; i<indice; i++) {
			System.out.println("Código da compra: " +i);
			System.out.println(compra[i].getVoo().toString());
			System.out.println("Poltrona -> linha:" +compra[i].getPoltrona().getLinha()+ "coluna: " +compra[i].getPoltrona().getColuna());
		}
	}
	
	public void apagaCompra(int codigo) {
		compra[codigo] = null;
		for(int i=codigo; i<indice-1; i++) {
			compra[i] = compra[i+1];
		}
		indice--;
	}
}
