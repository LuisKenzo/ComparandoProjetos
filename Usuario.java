package usuario;

import agenda.Poltrona;
import agenda.Voo;

public class Usuario {
	private String usuario, senha;
	
	public Usuario(String usuario, String senha) {
		setUsuario(usuario);
		setSenha(senha);
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void adicionaCompras(Voo voo, Poltrona poltrona) {
	}

	public void imprimeCompras() {
	}

	public void apagaCompra(int codigo) {
	}
}
