package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Conta;

public class TesteContaConcorrente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");

		EntityManager manager = factory.createEntityManager();
		EntityManager manager2 = factory.createEntityManager();

		manager.getTransaction().begin();	
		manager2.getTransaction().begin();	
		
		Conta c1 = manager.find(Conta.class, 1L);
		c1.setSaldo(c1.getSaldo() + 500);
		
		Conta c2 = manager2.find(Conta.class, 1L);
		c2.setSaldo(c2.getSaldo() - 500);
		
		manager.getTransaction().commit();
		manager2.getTransaction().commit();
		
		manager.close();
		manager2.close(); factory.close();
	}

}
