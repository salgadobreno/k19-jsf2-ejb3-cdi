package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import modelo.Conta;

public class TesteDeadLockPessismist {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager m1 = factory.createEntityManager();
		EntityManager m2 = factory.createEntityManager();

		m1.getTransaction().begin();
		m2.getTransaction().begin();
		
		m1.find(Conta.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		System.out.println("Conta 1 travada");
		m2.find(Conta.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		System.out.println("essa msg n sera impressa");
		
		m1.getTransaction().commit();
		m2.getTransaction().commit();
		
		m1.close(); m2.close(); factory.close();

	}
}
