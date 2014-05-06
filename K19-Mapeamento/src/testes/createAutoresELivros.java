package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Autor;
import modelo.Livro;

public class createAutoresELivros {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		for (int i = 0; i < 10; i++) {
			Autor a = new Autor();
			a.setNome("Autor " + i);
			
			for (int j = 0; j < 4; j++) {
				Livro l = new Livro();
				l.setNome("Livro " + j);
				a.getLivros().add(l);
				manager.persist(l);
			}
			manager.persist(a);
		}
		manager.getTransaction().commit();
		manager.close();factory.close();
	}

}
