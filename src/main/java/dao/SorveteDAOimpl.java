package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JpaUtil;
import entidade.Sorvete;

public class SorveteDAOimpl implements SorveteDAO {

	EntityManager em = JpaUtil.getEntityManager();
	EntityTransaction tx = em.getTransaction();

	public void inserir(Sorvete sorvete) {
		tx = em.getTransaction();
		tx.begin();
		em.persist(sorvete);
		tx.commit();

	}

	public void remover(String nome) {
		tx = em.getTransaction();
		Sorvete removerSVT = em.find(Sorvete.class, nome);
		tx.begin();
		em.remove(removerSVT);
		tx.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Sorvete> listarTodos() {
		Query query = em.createQuery("from Sorvete");
		List<Sorvete> sorvetes = query.getResultList();
		return sorvetes;
	}

}
