package usuario;

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
}
