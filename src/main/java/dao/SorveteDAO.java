package dao;

import java.util.List;
import entidade.Sorvete;

public interface SorveteDAO {

	void inserir(Sorvete sorvete);

	void remover(String nome);

	List<Sorvete> listarTodos();

}
