package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Conta;

public class AdicionaConta {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();	
		
		Conta c = new Conta();
		c.setSaldo(2000);
		manager.persist(c);
		manager.getTransaction().commit();
		
		manager.close();factory.close();

	}

}
