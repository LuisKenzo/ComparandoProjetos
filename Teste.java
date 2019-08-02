package teste;
import java.util.Scanner;
import agenda.Agenda;

import usuario.Usuarios;

public class Teste {

	public static void main(String[] args) {
		Usuarios usuarios = new Usuarios();
		Agenda janeiro = new Agenda("Janeiro");
		Scanner input = new Scanner(System.in);
		System.out.println("Bem-vindo");
		System.out.println("O que gostaria de fazer? (1-Cadastrar/2-Login)");
		int decisao = input.nextInt();
		System.out.println("Voc� � um cliente ou um atendente? (1/2)");
		int tipoDeUsuario = input.nextInt();
		System.out.println("Digite o nome de usu�rio: ");
		String usuario = input.next();
		System.out.println("Digite a sua senha: ");
		String senha = input.next();
		if(decisao == 1) {
			if(tipoDeUsuario == 1) {
				usuarios.novoCliente(usuario, senha);
			} else if(tipoDeUsuario == 2) {
				usuarios.novoAtendente(usuario, senha);
			} else {
				//fazer uma exception
			}
		} else if(decisao == 2) {
			if(tipoDeUsuario == 1) {
				usuarios.loginCliente(usuario, senha);
			} else if(tipoDeUsuario == 2) {
				usuarios.loginAtendente(usuario, senha);
			} else {
				//fazer uma exception
			}
		} else {
			//fazer uma exception
		}
		if(usuarios.getLogado() == 1) {
			System.out.println("Voc� est� logado!");
			System.out.println("O que gostaria de fazer?");
			if(usuarios.getTipoDeUsuario().equals("Atendente")) {
				System.out.println("1- Verificar v�os dispon�veis");
				System.out.println("2- Criar um novo v�o");
				System.out.println("3- Deletar um v�o");
				System.out.println("4- Logout");
				decisao = input.nextInt();
				switch(decisao) {
					case 1:
						janeiro.imprimeVoos();
						break;
					case 2:

						break;
					case 3:

						break;
					case 4:
						usuarios.logout();
						break;
					default:
						//exception
				}
			} else if(usuarios.getTipoDeUsuario().equals("Cliente")) {
				System.out.println("1- Verificar v�os dispon�veis");
				System.out.println("2- Comprar v�os");
				System.out.println("3- Verificar passagens adiquiridas");
				System.out.println("4- Logout");
				decisao = input.nextInt();
				switch(decisao) {
					case 1:
						janeiro.imprimeVoos();
						break;
					case 2:
						usuarios.comprarVoo(janeiro);
						break;
					case 3:
						usuarios.imprimeCompras();
						break;
					case 4:
						usuarios.logout();
						break;
					default:
						//exception
				}
			}

		} else {
			//mesmo codigo que acima, criar uma classe com ela e chamar
		}

	}

}
