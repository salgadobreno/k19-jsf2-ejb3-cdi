package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Livro;

public class ListaNomeLivros {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_criteria_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<String> c = cb.createQuery(String.class);
		Root<Livro> livro = c.from(Livro.class);
		c.select(livro.<String>get("nome"));
		
		TypedQuery<String> query = manager.createQuery(c);
		List<String> nomes = query.getResultList();
		
		for (String nome : nomes) {
			System.out.println("Livro: " + nome);
		}
		
		manager.close();factory.close();
	}

}
