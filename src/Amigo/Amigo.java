package Amigo;

/**
 * Classe que representa um amigo que pode pegar livros emprestados.
 */
public class Amigo {
	private int idAmigo;
	private String nome;
	private String celular;


	/**
	 * Construtor da classe Amigo.
	 * @param idAmigo ID do amigo.
	 * @param nome Nome do amigo.
	 * @param celular Celular do amigo.
	 */
	public Amigo(int idAmigo, String nome, String celular) {
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}

	/**
	 * Obtém o ID do amigo.
	 * @return ID do amigo.
	 */
	public int getIdAmigo() {
		return idAmigo;
	}

	/**
	 * Obtém o nome do amigo.
	 * @return Nome do amigo.
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém o celular do amigo.
	 * @return Celular do amigo.
	 */
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


	/**
	 * Método toString que retorna uma representação textual do amigo.
	 *
	 * @return String representando o amigo.
	 */
	@Override
	public String toString() {
		return "Amigo [idAmigo=" + idAmigo + ", nome=" + nome + ", celular=" + celular + "]";
	}
}
