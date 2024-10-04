package Emprestimo;

import java.time.LocalDate;
import Amigo.Amigo;
import Biblioteca.Livro;

/**
 * Classe que representa um empréstimo de livro.
 */
public class Emprestimo {
	private int idAmigo;
	private int idLivro;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private Livro livro;
	private Amigo amigo;

	/**
	 * Construtor da classe Emprestimo.
	 *
	 * @param amigo Amigo que está pegando o livro emprestado.
	 * @param livro Livro que está sendo emprestado.
	 */
	public Emprestimo(int idAmigo, int idLivro, Livro livro, Amigo amigo) {
		this.idAmigo = idAmigo;
		this.idLivro = idLivro;
		this.dataEmprestimo = LocalDate.now();
		this.livro = livro;
		this.amigo = amigo;
	}

	// Método para devolver o livro
	public void devolver() {
		this.dataDevolucao = LocalDate.now();
	}

	// Getters e Setters
	public int getIdAmigo() {
		return idAmigo;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	/**
	 * Obtém o livro que foi emprestado.S
	 * @return Livro que foi emprestado.
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * Obtém o amigo que pegou o livro emprestado.
	 * @return Amigo que pegou o livro.
	 */
	public Amigo getAmigo() {
		return amigo;
	}

	/**
	 * Método toString que retorna uma representação textual do empréstimo.
	 * @return String representando o empréstimo.
	 */
	@Override
	public String toString() {
		return "Emprestimo [idAmigo=" + idAmigo + ", idLivro=" + idLivro + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolucao=" + dataDevolucao + "]";
	}
}

