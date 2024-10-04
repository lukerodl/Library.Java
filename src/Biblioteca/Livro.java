package Biblioteca;

/**
 * Classe que representa um livro, incluindo seu estado de disponibilidade.
 */
public class Livro implements Comparable<Livro> {
	private int idLivro;
	private String titulo;
	private String autor;
	private float preco;
	private Disponibilidade dispLivro;


	/**
	 * Construtor da classe Livro.
	 * @param idLivro ID do livro.
	 * @param titulo Título do livro.
	 * @param autor Autor do livro.
	 * @param preco Preço do livro.
	 */
	public Livro(int idLivro, String titulo, String autor, float preco) {
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.dispLivro = Disponibilidade.DISPONIVEL;
	}

	/**
	 * Obtém o ID do livro.
	 * @return ID do livro.
	 */
	public int getIdLivro() {
		return idLivro;
	}

	/**
	 * Obtém o título do livro.
	 * @return Título do livro.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Obtém o autor do livro.
	 * @return Autor do livro.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Obtém o preço do livro.
	 * @return Preço do livro.
	 */
	public float getPreco() {
		return preco;
	}

	/**
	 * Obtém a disponibilidade do livro.
	 * @return Disponibilidade do livro.
	 */
	public Disponibilidade getDispLivro() {
		return dispLivro;
	}

	/**
	 * Altera a disponibilidade do livro.
	 * @param dispLivro Novo estado de disponibilidade.
	 */
	public void setDispLivro(Disponibilidade dispLivro) {
		this.dispLivro = dispLivro;
	}


	/**
	 * Método toString que retorna uma representação textual do livro.
	 *
	 * @return String representando o livro.
	 */
	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", autor=" + autor + ", preco=" + preco
				+ ", dispLivro=" + dispLivro + "]";
	}


	/**
	 * Método de comparação para ordenar os livros pelo título.
	 *
	 * @param outro Livro a ser comparado.
	 * @return Resultado da comparação.
	 */
	@Override
	public int compareTo(Livro outro) {
		return this.titulo.compareTo(outro.getTitulo());
	}
}
