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
		
		em.getTransaction().begin();
		
		String nativeQueryInserir = "INSERT INTO SORVETE VALUES ( :a, :b, :c )";
		
		Query query = em.createNativeQuery(nativeQueryInserir, Sorvete.class);

		query.setParameter("a", sorvete.getNome());
		query.setParameter("b", sorvete.getFabricante());
		query.setParameter("c", sorvete.getIngredientes()).executeUpdate();
		
		em.getTransaction().commit();
		
	}
	
//	public void inserir(Sorvete sorvete) {
//		tx = em.getTransaction();
//		tx.begin();
//		em.persist(sorvete);
//		tx.commit();
//
//	}

	public void remover(String nome) {

		em.getTransaction().begin();

		String nativeQueryRemove = "delete SORVETE where NOME = ?";

		Query query = em.createNativeQuery(nativeQueryRemove, Sorvete.class);

		query.setParameter(1, nome).executeUpdate();
		
		em.getTransaction().commit();

	}

//	public void remover(String nome) {
//		tx = em.getTransaction();
//		Sorvete removerSVT = em.find(Sorvete.class, nome);
//		tx.begin();
//		em.remove(removerSVT);
//		tx.commit();
//
//	}

	@SuppressWarnings("unchecked")
	public List<Sorvete> listarTodos() {

		String nativeQuery = "select * from sorvete where FABRICANTE = 'nestle'";

		Query query = em.createNativeQuery(nativeQuery, Sorvete.class);
		List<Sorvete> sorvetes = query.getResultList();

		return sorvetes;
	}

//	@SuppressWarnings("unchecked")
//	public List<Sorvete> listarTodos() {
//		Query query = em.createQuery("from Sorvete");
//		List<Sorvete> sorvetes = query.getResultList();
//		return sorvetes;
//	}

}
