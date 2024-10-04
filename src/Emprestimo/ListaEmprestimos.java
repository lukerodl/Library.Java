package Emprestimo;

import Biblioteca.Livro;  // Importando a classe Livro do pacote Biblioteca
import Amigo.Amigo;       // Importando a classe Amigo do pacote Amigo
import java.util.ArrayList;

/**
 * Classe que representa uma lista de empréstimos de livros.
 */
public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;

	/**
	 * Construtor da classe ListaEmprestimos.
	 */
	public ListaEmprestimos() {
		this.alEmprestimos = new ArrayList<>();
	}

	/**
	 * Adiciona um novo empréstimo à lista.
	 *
	 * @param idAmigo ID do amigo que está pegando o livro emprestado.
	 * @param idLivro ID do livro que está sendo emprestado.
	 * @param livro Livro que está sendo emprestado.
	 * @param amigo Amigo que está pegando o livro emprestado.
	 */
	public void addEmprestimo(int idAmigo, int idLivro, Livro livro, Amigo amigo) {
		Emprestimo emprestimo = new Emprestimo(idAmigo, idLivro, livro, amigo);
		alEmprestimos.add(emprestimo);
	}

	/**
	 * Devolve um livro, removendo-o da lista de empréstimos.
	 * @param idLivro ID do livro que está sendo devolvido.
	 */
	public void devolverLivro(int idLivro) {
		for (Emprestimo emprestimo : alEmprestimos) {
			if (emprestimo.getIdLivro() == idLivro && emprestimo.getDataDevolucao() == null) {
				emprestimo.devolver();
				break;
			}
		}
	}

	/**
	 * Lista os empréstimos atuais.
	 */
	public void listarEmprestimosAtuais() {
		for (Emprestimo emprestimo : alEmprestimos) {
			if (emprestimo.getDataDevolucao() == null) {
				System.out.println(emprestimo);
			}
		}
	}

	// Listar o histórico de um livro
	public void listarHistorico(int idLivro) {
		for (Emprestimo emprestimo : alEmprestimos) {
			if (emprestimo.getIdLivro() == idLivro) {
				System.out.println(emprestimo);
			}
		}
	}
}



