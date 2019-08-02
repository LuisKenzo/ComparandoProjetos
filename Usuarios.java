package usuario;
import usuario.Usuario;
import usuario.Cliente;

import java.util.Scanner;

import agenda.Agenda;
import agenda.Data;
import agenda.Voo;

public class Usuarios {
	private Usuario[] clientes = new Usuario[1000];
	private Usuario[] atendentes = new Usuario[1000];
	private int indiceCliente;
	private int indiceAtendente;
	private static int logado = 0;
	private static int usuarioID;
	private static String tipoDeUsuario;

	public Usuarios() {
		this.indiceCliente = -1;
		this.indiceAtendente = -1;
	}

	public void setLogado(boolean logado) {
		if(logado) {
			Usuarios.logado = 1;
		} else {
			Usuarios.logado = 0;
		}
	}

	public int getLogado() {
		return logado;
	}

	public void setUsuarioID(int id) {
		Usuarios.usuarioID = id;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setTipoDeUsuario(String usuario) {
		Usuarios.tipoDeUsuario = usuario;
	}

	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void novoCliente(String usuario, String senha) {
		boolean clienteJaExiste = false;
		if(this.indiceCliente > -1) {
			for(int i=0; i<indiceCliente+1; i++) {
				if(this.clientes[i].getUsuario().equals(usuario)) {
					clienteJaExiste = true;
					//colocar uma exception
					break;
				}
			}
		}
		if(!clienteJaExiste) {
			Cliente cliente = new Cliente(usuario,senha);
			indiceCliente++;
			this.clientes[indiceCliente] = cliente;
		}
	}

	public void novoAtendente(String usuario, String senha) {
		boolean atendenteJaExiste = false;
		if(this.indiceAtendente > -1) {
			for(int i=0; i<indiceAtendente+1; i++) {
				if(this.atendentes[i].getUsuario().equals(usuario)) {
					atendenteJaExiste = true;
					//colocar uma exception
					break;
				}
			}
		}
		if(!atendenteJaExiste) {
			Atendente atendente = new Atendente(usuario,senha);
			indiceAtendente++;
			this.atendentes[indiceAtendente] = atendente;
		}
	}

	public boolean loginCliente(String usuario, String senha) {
		for(int i=0; i<clientes.length; i++) {
			if(this.clientes[i].getUsuario().equals(usuario)) {
				if(this.clientes[i].getSenha().equals(senha)) {
					setUsuarioID(i);
					setTipoDeUsuario("Cliente");
					return true;
				}
			}
		}
		return false;
	}

	public boolean loginAtendente(String usuario, String senha) {
		for(int i=0; i<atendentes.length; i++) {
			if(this.atendentes[i].getUsuario().equals(usuario)) {
				if(this.atendentes[i].getSenha().equals(senha)) {
					setUsuarioID(i);
					setTipoDeUsuario("Atendente");
					return true;
				}
			}
		}
		return false;
	}

	public void logout() {
		setLogado(false);
		setUsuarioID(-1);
		setTipoDeUsuario("Nenhum");
	}

	public void comprarVoo(Agenda agenda) {
		Scanner input = new Scanner(System.in);
		System.out.println("Insira a data da viagem: ");
		int data = input.nextInt();
		System.out.println("Possuímos as viagens a seguir para o dia " +data);
		Data dataEscolhida = agenda.datas[data-1];
		dataEscolhida.imprimeVoosDoDia();
		System.out.println("Digite o código da viagem escolhida: ");
		int codigo = input.nextInt();
		int	codigoDoVoo = dataEscolhida.buscaVoo(codigo);
		if(codigoDoVoo > 0) {
			System.out.println("Digite o número de passagens que gostaria de comprar: ");
			int passagens = input.nextInt();
			System.out.println("Algum dos passageiros é menor de idade? Se sim, digite a quantidade, se não, digite 0");
			int passageirosMenoresDeIdade = input.nextInt();
			System.out.println("Gostaria de comprar no setor de primeira classe(1) ou econômica(2)?");
			int classe = input.nextInt(); 
			System.out.println("Por favor, escolha os lugares das poltronas");
			Voo vooEscolhido = dataEscolhida.listaDeVoos[codigoDoVoo];
			vooEscolhido.imprimePoltronas(classe);
			for(int i=0; i<passagens; i++) {
				System.out.println("Escolha a cadeira: ");
				System.out.println("Digite a linha: ");
				int linha = input.nextInt();
				System.out.println("Digite a coluna: ");
				int coluna = input.nextInt();
				vooEscolhido.adicionaPoltrona(linha, coluna, classe, getUsuarioID());
				clientes[usuarioID].adicionaCompras(vooEscolhido, vooEscolhido.buscaPoltrona(linha,coluna,classe));
			}
			System.out.println("O valor total da compra é: " +vooEscolhido.calculaValorTotal(passagens, passageirosMenoresDeIdade, classe));
			System.out.println("Compra efetuada com sucesso!");
		}
	}
	
	public void imprimeCompras() {
		clientes[usuarioID].imprimeCompras();
	}
	
	public void cancelaCompra(Agenda agenda) {
		Scanner input = new Scanner(System.in);
		imprimeCompras();
		System.out.println("Digite o código da compra a ser cancelada: ");
		int codigoCompra = input.nextInt();
		System.out.println("Confirme a data: ");
		int data = input.nextInt();
		System.out.println("Confirme o código do voo: ");
		int codigoVoo = input.nextInt();
		System.out.println("Confirme a classe (1-Primeira/2-Economica)");
		int classe = input.nextInt();
		System.out.println("Confirme a linha da poltrona: ");
		int linha = input.nextInt();
		System.out.println("Confirme a coluna da poltrona: ");
		int coluna = input.nextInt();
		Usuario clienteAtual = clientes[usuarioID];
		Data dataDoVoo = agenda.datas[data];
		int vooID = dataDoVoo.buscaVoo(codigoVoo);
		dataDoVoo.listaDeVoos[vooID].removeDaPoltrona(linha, coluna, classe);
		clienteAtual.apagaCompra(codigoCompra);
	}
}
