package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

public class PopulaPessoa {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_hibernatesearch_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		String[] nomes = {"Breno Salgado", "Vitor Ramos", "Felipe Freitas", "Artur", "Pedro", "Kadu"};
		for (String nome : nomes) {
			Pessoa p = new Pessoa();
			p.setNome(nome);
			manager.persist(p);
		}
		
		manager.getTransaction().commit();
		manager.close();factory.close();
		
	}

}
