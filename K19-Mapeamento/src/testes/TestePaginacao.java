package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Comentario;

public class TestePaginacao {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();	
		
		TypedQuery<Comentario> query = manager.createQuery("select comentario from Comentario comentario", Comentario.class); 
		
		query.setFirstResult(2);
		query.setMaxResults(3);
		List<Comentario> comentarios = query.getResultList();
		manager.close();factory.close();
	}

}
