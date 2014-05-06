package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Topico;

public class TesteOrphanRemoval {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();

		Topico topico = manager.find(Topico.class, 1L);
		topico.getComentarios().clear();
		manager.getTransaction().commit();
		manager.close();factory.close();
	}
}
