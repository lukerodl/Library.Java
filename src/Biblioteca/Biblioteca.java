package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa uma biblioteca, contendo uma lista de livros e seu investimento total.
 */

public class Biblioteca {
	private String nome;
	private ArrayList<Livro> alLivros;
	private float investimento;


	/**
	 * Construtor da classe Biblioteca.
	 * @param nome Nome da biblioteca.
	 */
	public Biblioteca(String nome) {
		this.nome = nome;
		this.alLivros = new ArrayList<Livro>();
		this.investimento = 0;
	}


	/**
	 * Adiciona um novo livro à biblioteca.
	 * @param titulo Título do livro.
	 * @param autor Autor do livro.
	 * @param preco Preço do livro.
	 * @return ID do livro cadastrado.
	 */
	public int addLivro(String titulo, String autor, float preco) {
		int idLivro = alLivros.size() + 1;
		Livro livro = new Livro(idLivro, titulo, autor, preco);
		alLivros.add(livro);
		investimento += preco;
		return idLivro;
	}

	/**
	 * Obtém um livro pelo ID.
	 * @param idLivro ID do livro a ser obtido.
	 * @return Livro correspondente ao ID, ou null se não encontrado.
	 */
	public Livro getLivro(int idLivro) {
		for (Livro livro : alLivros) {
			if (livro.getIdLivro() == idLivro) {
				return livro;
			}
		}
		return null; // Se não encontrar o livro
	}

	/**
	 * Lista todos os livros da biblioteca e exibe o investimento.
	 */
	public void listarLivros() {
		Collections.sort(alLivros);
		for (Livro livro : alLivros) {
			System.out.println(livro);
		}
		System.out.println("Total investido: R$ " + investimento);
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getInvestimento() {
		return investimento;
	}

	public void setInvestimento(float investimento) {
		this.investimento = investimento;
	}

	@Override
	public String toString() {
		return "Biblioteca [nome=" + nome + ", investimento=" + investimento + "]";
	}
}
