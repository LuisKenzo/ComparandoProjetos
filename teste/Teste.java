package teste;
import java.util.Scanner;
import agenda.*;
import usuario.Usuarios;

public class Teste {

	public static void main(String[] args) {
		Usuarios usuarios = new Usuarios();
		Scanner input = new Scanner(System.in);
		
		Agenda janeiro = new Agenda("Janeiro");
		Agenda fevereiro = new Agenda("Fevereiro");
		Agenda mar�o = new Agenda("Mar�o");
		Agenda abril = new Agenda("Abril");
		Agenda maio = new Agenda("Maio");
		Agenda junho = new Agenda("Junho");
		Agenda julho = new Agenda("Julho");
		Agenda agosto = new Agenda("Agosto");
		Agenda setembro = new Agenda("Setembro");
		Agenda outubro = new Agenda("Outubro");
		Agenda novembro = new Agenda("Novembro");
		Agenda dezembro = new Agenda("Dezembro");
		
		int decisao;
		int tipoDeUsuario;
		String mesSelecionado;
		int diaSelecionado; 
				
		System.out.println("Bem-vindo");
		
		System.out.println("O que gostaria de fazer? (1-Cadastrar/2-Login)");
		decisao = input.nextInt();
		
		System.out.println("Voc� � um cliente ou um atendente? (1/2)");
		tipoDeUsuario = input.nextInt();
		
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
			
			//do { <----------------------
			
			System.out.println("O que gostaria de fazer?");
			if(usuarios.getTipoDeUsuario().equals("Atendente")) {
				System.out.println("1- Verificar v�os dispon�veis");
				System.out.println("2- Criar um novo voo");
				System.out.println("3- Deletar um voo");
				System.out.println("4- Logout");
				decisao = input.nextInt();
				
				switch(decisao) {
				
					//dado m�s, imprime os voos do m�s.
					case 1:
						System.out.println("Deseja imprimir os voos de qual m�s?");
						mesSelecionado = input.nextLine();
						
						switch(mesSelecionado) {
							case "Janeiro":
								janeiro.imprimeVoos();
								break;
							case "Fevereiro":
								fevereiro.imprimeVoos();
								break;
							case "Mar�o":
								mar�o.imprimeVoos();
								break;
							case "Abril":
								abril.imprimeVoos();
								break;
							case "Maio":
								maio.imprimeVoos();
								break;
							case "Junho":
								junho.imprimeVoos();
								break;
							case "Julho":
								julho.imprimeVoos();
								break;
							case "Agosto":
								agosto.imprimeVoos();
								break;
							case "Setembro":
								setembro.imprimeVoos();
								break;
							case "Outubro":
								outubro.imprimeVoos();
								break;
							case "Novembro":
								novembro.imprimeVoos();
								break;
							case "Dezembro":
								dezembro.imprimeVoos();
								break;
							default:
								break;
						}
						break;	
					
					//Dado m�s e dia, checa se a data j� foi iniciada, cria a data se necess�rio e adiciona um voo na data.
					case 2:
						System.out.println("Em qual m�s voc� deseja criar um voo?");
						mesSelecionado = input.nextLine();
						System.out.println("Em qual dia?");
						diaSelecionado =  input.nextInt();
						diaSelecionado--;
						
						switch(mesSelecionado) {
							case "Janeiro":
								if (janeiro.datas[diaSelecionado].getStatus()) {
									janeiro.datas[diaSelecionado].adicionaVoo();
								} else {
									janeiro.datas[diaSelecionado] =  new Data(diaSelecionado);
									janeiro.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Fevereiro":
								if (fevereiro.datas[diaSelecionado].getStatus()) {
									fevereiro.datas[diaSelecionado].adicionaVoo();
								} else {
									fevereiro.datas[diaSelecionado] =  new Data(diaSelecionado);
									fevereiro.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Mar�o":
								if (mar�o.datas[diaSelecionado].getStatus()) {
									mar�o.datas[diaSelecionado].adicionaVoo();
								} else {
									mar�o.datas[diaSelecionado] =  new Data(diaSelecionado);
									mar�o.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Abril":
								if (abril.datas[diaSelecionado].getStatus()) {
									abril.datas[diaSelecionado].adicionaVoo();
								} else {
									abril.datas[diaSelecionado] =  new Data(diaSelecionado);
									abril.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Maio":
								if (maio.datas[diaSelecionado].getStatus()) {
									maio.datas[diaSelecionado].adicionaVoo();
								} else {
									maio.datas[diaSelecionado] =  new Data(diaSelecionado);
									maio.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Junho":
								if (junho.datas[diaSelecionado].getStatus()) {
									junho.datas[diaSelecionado].adicionaVoo();
								} else {
									junho.datas[diaSelecionado] =  new Data(diaSelecionado);
									junho.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Julho":
								if (julho.datas[diaSelecionado].getStatus()) {
									julho.datas[diaSelecionado].adicionaVoo();
								} else {
									julho.datas[diaSelecionado] =  new Data(diaSelecionado);
									julho.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Agosto":
								if (agosto.datas[diaSelecionado].getStatus()) {
									agosto.datas[diaSelecionado].adicionaVoo();
								} else {
									agosto.datas[diaSelecionado] =  new Data(diaSelecionado);
									agosto.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Setembro":
								if (setembro.datas[diaSelecionado].getStatus()) {
									setembro.datas[diaSelecionado].adicionaVoo();
								} else {
									setembro.datas[diaSelecionado] =  new Data(diaSelecionado);
									setembro.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Outubro":
								if (outubro.datas[diaSelecionado].getStatus()) {
									outubro.datas[diaSelecionado].adicionaVoo();
								} else {
									outubro.datas[diaSelecionado] =  new Data(diaSelecionado);
									outubro.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Novembro":
								if (novembro.datas[diaSelecionado].getStatus()) {
									novembro.datas[diaSelecionado].adicionaVoo();
								} else {
									novembro.datas[diaSelecionado] =  new Data(diaSelecionado);
									novembro.datas[diaSelecionado].adicionaVoo();
								}
								break;
							case "Dezembro":
								if (dezembro.datas[diaSelecionado].getStatus()) {
									dezembro.datas[diaSelecionado].adicionaVoo();
								} else {
									dezembro.datas[diaSelecionado] =  new Data(diaSelecionado);
									dezembro.datas[diaSelecionado].adicionaVoo();
								}
								break;
							default:
								//exception "m�s n�o existe"
								break;
						}
						break;	
					
					//Dado m�s e dia, checa se a data j� foi iniciada, e remove um voo da data
					case 3:
						System.out.println("Em qual m�s voc� deseja remover um voo?");
						mesSelecionado = input.nextLine();
						System.out.println("Em qual dia?");
						diaSelecionado =  input.nextInt();
						diaSelecionado--;

						switch(mesSelecionado) {
						case "Janeiro":
							if (janeiro.datas[diaSelecionado].getStatus()) {
								janeiro.datas[diaSelecionado].removeVoo();
							} else {
								//exception "data n�o existe".
							}
							break;
						case "Fevereiro":
							if (fevereiro.datas[diaSelecionado].getStatus()) {
								fevereiro.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Mar�o":
							if (mar�o.datas[diaSelecionado].getStatus()) {
								mar�o.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Abril":
							if (abril.datas[diaSelecionado].getStatus()) {
								abril.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Maio":
							if (maio.datas[diaSelecionado].getStatus()) {
								maio.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Junho":
							if (junho.datas[diaSelecionado].getStatus()) {
								junho.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Julho":
							if (julho.datas[diaSelecionado].getStatus()) {
								julho.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Agosto":
							if (julho.datas[diaSelecionado].getStatus()) {
								julho.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Setembro":
							if (setembro.datas[diaSelecionado].getStatus()) {
								setembro.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Outubro":
							if (outubro.datas[diaSelecionado].getStatus()) {
								outubro.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Novembro":
							if (novembro.datas[diaSelecionado].getStatus()) {
								novembro.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						case "Dezembro":
							if (dezembro.datas[diaSelecionado].getStatus()) {
								dezembro.datas[diaSelecionado].removeVoo();
							} else {
								//exception
							}
							break;
						default:
							//exception "m�s n�o existe"
							break;
						}
						break;	
					
					//user logout;
					case 4:
						System.out.println("Logout");
						usuarios.logout();
						break;
					default:
						//exception
				}
			} else if(usuarios.getTipoDeUsuario().equals("Cliente")) {
				System.out.println("1- Verificar voos dispon�veis");
				System.out.println("2- Comprar voos");
				System.out.println("3- Verificar passagens adiquiridas");
				System.out.println("4- Logout");
				decisao = input.nextInt();
				switch(decisao) {
					case 1:
						System.out.println("Deseja imprimir os voos de qual m�s?");
						mesSelecionado = input.nextLine();
						
						switch(mesSelecionado) {
							case "Janeiro":
								janeiro.imprimeVoos();
								break;
							case "Fevereiro":
								fevereiro.imprimeVoos();
								break;
							case "Mar�o":
								mar�o.imprimeVoos();
								break;
							case "Abril":
								abril.imprimeVoos();
								break;
							case "Maio":
								maio.imprimeVoos();
								break;
							case "Junho":
								junho.imprimeVoos();
								break;
							case "Julho":
								julho.imprimeVoos();
								break;
							case "Agosto":
								agosto.imprimeVoos();
								break;
							case "Setembro":
								setembro.imprimeVoos();
								break;
							case "Outubro":
								outubro.imprimeVoos();
								break;
							case "Novembro":
								novembro.imprimeVoos();
								break;
							case "Dezembro":
								dezembro.imprimeVoos();
								break;
							default:
								break;
						}
						break;	
						
					//Dado m�s, chama m�todo "comprarVoo" dos usu�rios.	
					case 2:
						System.out.println("Voc� deseja comprar um voo em qual m�s?");
						mesSelecionado = input.nextLine();
						System.out.println("Em qual dia?");
						diaSelecionado =  input.nextInt();
						diaSelecionado--;

						switch(mesSelecionado) {
						case "Janeiro":
							usuarios.comprarVoo(janeiro);
							break;
						case "Fevereiro":
							usuarios.comprarVoo(fevereiro);
							break;
						case "Mar�o":
							usuarios.comprarVoo(mar�o);
							break;
						case "Abril":
							usuarios.comprarVoo(abril);
							break;
						case "Maio":
							usuarios.comprarVoo(maio);
							break;
						case "Junho":
							usuarios.comprarVoo(junho);
							break;
						case "Julho":
							usuarios.comprarVoo(julho);
							break;
						case "Agosto":
							usuarios.comprarVoo(agosto);
							break;
						case "Setembro":
							usuarios.comprarVoo(setembro);
							break;
						case "Outubro":
							usuarios.comprarVoo(outubro);
							break;
						case "Novembro":
							usuarios.comprarVoo(novembro);
							break;
						case "Dezembro":
							usuarios.comprarVoo(dezembro);
							break;
						default:
							//exception "m�s n�o existe"
							break;
						}
						break;	
						
					//
					case 3:
						System.out.println("");
						break;
					case 4:
						System.out.println("Logout");
						usuarios.logout();
						break;
					default:
						//exception
				}
			}
		//} while (true); <----------------------
			
		} 	
	}
}
