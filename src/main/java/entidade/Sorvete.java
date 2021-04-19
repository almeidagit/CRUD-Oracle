package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SORVETE")
public class Sorvete {

	@Id
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "FABRICANTE", nullable = false)
	private String fabricante;
	
	@Column(name = "INGREDIENTES", nullable = false)
	private String ingredientes;

	public Sorvete() {
		super();
	}

	public Sorvete(String nome, String fabricante, String ingredientes) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

}
