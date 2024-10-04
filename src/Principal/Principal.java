package Principal;

import Biblioteca.Livro;          // Importa a classe Livro do pacote Biblioteca
import Amigo.Amigo;               // Importa a classe Amigo do pacote Amigo
import Emprestimo.Emprestimo;     // Importa a classe Emprestimo do pacote Emprestimo
import Emprestimo.ListaEmprestimos;
import Amigo.ListaAmigos;
import Biblioteca.Biblioteca;
import Biblioteca.Disponibilidade;
import java.util.Scanner;

/**
 * Classe principal que gerencia a execução do sistema da biblioteca.
 * @author lucas.leite
 * @since october 2024
 */

public class Principal {

	private static Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
	private static ListaEmprestimos emprestimos = new ListaEmprestimos();
	private static ListaAmigos amigos = new ListaAmigos();

	/**
	 * Método principal que inicia o sistema da biblioteca.
	 * @param args Argumentos da linha de comando.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = -1;

		while (opcao != 0) {
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Cadastrar Amigo");
			System.out.println("3 - Emprestar Livro");
			System.out.println("4 - Devolver Livro");
			System.out.println("5 - Listar Empréstimos Atuais");
			System.out.println("6 - Listar Histórico de Empréstimos de um Livro");
			System.out.println("7 - Listar Biblioteca");
			System.out.println("8 - Alterar Estado de Livro");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine();  // Limpar o buffer

			switch (opcao) {
				case 1:
					cadastrarLivro(sc);
					break;
				case 2:
					cadastrarAmigo(sc);
					break;
				case 3:
					emprestarLivro(sc);
					break;
				case 4:
					devolverLivro(sc);
					break;
				case 5:
					listarEmprestimos();
					break;
				case 6:
					listarHistorico(sc);
					break;
				case 7:
					listarBiblioteca();
					break;
				case 8:
					alterarEstado(sc);
					break;
				case 0:
					System.out.println("Encerrando sistema.");
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}
		sc.close();
	}

	/**
	 * Método para cadastrar um novo livro.
	 *
	 * @param sc Scanner para ler a entrada do usuário.
	 */

	public static void cadastrarLivro(Scanner sc) {
		System.out.print("Digite o título do livro: ");
		String titulo = sc.nextLine();
		System.out.print("Digite o autor do livro: ");
		String autor = sc.nextLine();
		System.out.print("Digite o preço do livro: ");
		float preco = sc.nextFloat();
		int idLivro = bib.addLivro(titulo, autor, preco);
		System.out.println("Livro cadastrado com ID: " + idLivro);
	}


	/**
	 * Método para cadastrar um novo amigo.
	 *
	 * @param sc Scanner para ler a entrada do usuário.
	 */
	public static void cadastrarAmigo(Scanner sc) {
		System.out.print("Digite o nome do amigo: ");
		String nome = sc.nextLine();
		System.out.print("Digite o celular do amigo: ");
		String celular = sc.nextLine();
		int idAmigo = amigos.addAmigo(nome, celular);
		System.out.println("Amigo cadastrado com ID: " + idAmigo);
	}


	/**
	 * Método para emprestar um livro.
	 *
	 * @param sc Scanner para ler a entrada do usuário.
	 */
	public static void emprestarLivro(Scanner sc) {
		System.out.print("Digite o ID do livro para empréstimo: ");
		int idLivro = sc.nextInt();
		System.out.print("Digite o ID do amigo: ");
		int idAmigo = sc.nextInt();

		Livro livro = bib.getLivro(idLivro);  // Usando o objeto correto da classe Biblioteca.Livro
		Amigo amigo = amigos.getAmigo(idAmigo);  // Usando o objeto correto da classe Amigo.Amigo

		if (livro != null && amigo != null && livro.getDispLivro() == Disponibilidade.DISPONIVEL) {
			emprestimos.addEmprestimo(idAmigo, idLivro, livro, amigo);  // Passando parâmetros corretos
			livro.setDispLivro(Disponibilidade.EMPRESTADO);
			System.out.println("Livro emprestado com sucesso!");
		} else if (livro == null) {
			System.out.println("Livro não encontrado.");
		} else if (amigo == null) {
			System.out.println("Amigo não encontrado.");
		} else {
			System.out.println("O livro não está disponível para empréstimo.");
		}
	}

	/**
	 * Método para devolver um livro.
	 *
	 * @param sc Scanner para ler a entrada do usuário.
	 */
	public static void devolverLivro(Scanner sc) {
		System.out.print("Digite o ID do livro para devolução: ");
		int idLivro = sc.nextInt();

		Livro livro = bib.getLivro(idLivro);
		if (livro != null && livro.getDispLivro() == Disponibilidade.EMPRESTADO) {
			emprestimos.devolverLivro(idLivro);
			livro.setDispLivro(Disponibilidade.DISPONIVEL);
			System.out.println("Livro devolvido com sucesso!");
		} else if (livro == null) {
			System.out.println("Livro não encontrado.");
		} else {
			System.out.println("O livro não está emprestado.");
		}
	}

	/**
	 * Método para listar os empréstimos atuais.
	 */
	public static void listarEmprestimos() {
		emprestimos.listarEmprestimosAtuais();
	}

	/**
	 * Método para listar o histórico de empréstimos de um livro.
	 *
	 * @param sc Scanner para ler a entrada do usuário.
	 */
	public static void listarHistorico(Scanner sc) {
		System.out.print("Digite o ID do livro para ver o histórico: ");
		int idLivro = sc.nextInt();
		emprestimos.listarHistorico(idLivro);
	}

	/**
	 * Método para listar todos os livros da biblioteca.
	 */
	public static void listarBiblioteca() {
		bib.listarLivros();
	}

	/**
	 * Método para alterar o estado de um livro.
	 *@param sc Scanner para ler a entrada do usuário.
	 */
	public static void alterarEstado(Scanner sc) {
		System.out.print("Digite o ID do livro para alterar o estado: ");
		int idLivro = sc.nextInt();
		System.out.println("Escolha o novo estado: ");
		System.out.println("1 - DISPONIVEL");
		System.out.println("2 - CONSULTALOCAL");
		System.out.println("3 - DANIFICADO");
		System.out.println("4 - EXTRAVIADO");
		int opcao = sc.nextInt();
		Disponibilidade novoEstado = null;

		switch (opcao) {
			case 1:
				novoEstado = Disponibilidade.DISPONIVEL;
				break;
			case 2:
				novoEstado = Disponibilidade.CONSULTALOCAL;
				break;
			case 3:
				novoEstado = Disponibilidade.DANIFICADO;
				break;
			case 4:
				novoEstado = Disponibilidade.EXTRAVIADO;
				break;
			default:
				System.out.println("Opção inválida.");
				return;
		}

		Livro livro = bib.getLivro(idLivro);
		if (livro != null) {
			livro.setDispLivro(novoEstado);
			System.out.println("Estado do livro alterado com sucesso!");
		} else {
			System.out.println("Livro não encontrado.");
		}
	}
}