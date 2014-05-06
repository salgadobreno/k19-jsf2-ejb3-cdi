package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GovernadorEstado {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Governador gov = new Governador();
		gov.setNome("breno");
		
		Estado estado = new Estado();
		estado.setNome("bsb");
		
		gov.setEstado(estado);
		
		manager.persist(gov);
		manager.getTransaction().commit();
		manager.close();factory.close();
		
	}

}