package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Estado;
import modelo.Governador;

public class AdicionaEstadoGovernador {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Governador g = new Governador();
		
		g.setNome("Breno");
		Estado e = new Estado();
		e.setNome("DF");
		e.setGovernador(g);
		
		manager.persist(g);
		manager.persist(e);
		
		manager.getTransaction().commit();
		manager.close(); factory.close();
	}

}
