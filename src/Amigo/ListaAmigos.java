package Amigo;

import java.util.ArrayList;

/**
 * Classe que representa uma lista de amigos.
 */
public class ListaAmigos {

	private ArrayList<Amigo> alAmigos;

	/**
	 * Construtor da classe ListaAmigos.
	 */
	public ListaAmigos() {
		this.alAmigos = new ArrayList<>();
	}


	/**
	 * Adiciona um novo amigo à lista.
	 * @param nome Nome do amigo.
	 * @param celular Celular do amigo.
	 * @return ID do amigo cadastrado.
	 */
	public int addAmigo(String nome, String celular) {
		int idAmigo = alAmigos.size() + 1;
		Amigo amigo = new Amigo(idAmigo, nome, celular);
		alAmigos.add(amigo);
		return idAmigo;
	}

	/**
	 * Obtém um amigo pelo ID.
	 * @param idAmigo ID do amigo a ser obtido.
	 * @return Amigo correspondente ao ID, ou null se não encontrado.
	 */
	public Amigo getAmigo(int idAmigo) {
		for (Amigo amigo : alAmigos) {
			if (amigo.getIdAmigo() == idAmigo) {
				return amigo;
			}
		}
		return null;  // Retorna null se o amigo não for encontrado
	}

	public int getListaAmigosSize() {
		return alAmigos.size();
	}

	public void listarAmigos() {
		for (Amigo amigo : alAmigos) {
			System.out.println(amigo);
		}
	}
}

