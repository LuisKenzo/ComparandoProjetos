package usuario;

import usuario.Compras;
import agenda.Voo;
import agenda.Poltrona;

public class Cliente extends Usuario{
	Compras compra = new Compras();
	public Cliente(String usuario, String senha) {
		super(usuario, senha);
		
	}
	
	@Override
	public void adicionaCompras(Voo voo, Poltrona poltrona) {
		compra.salvarCompra(voo, poltrona);
	}
	
	@Override
	public void imprimeCompras() {
		compra.imprimeCompras();
	}
	
	@Override
	public void apagaCompra(int codigo) {
		compra.apagaCompra(codigo);
	}
	
	public Compra[] getCompra() {
		return compra.getCompra();
	}
}
