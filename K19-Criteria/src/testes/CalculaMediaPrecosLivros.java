package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Livro;

public class CalculaMediaPrecosLivros {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_criteria_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Double> c = cb.createQuery(Double.class);
		Root<Livro> l = c.from(Livro.class);
		
		c.select(cb.avg(l.<Double>get("preco")));
		
		TypedQuery<Double> query = manager.createQuery(c);
		Double media = query.getSingleResult();
		
		System.out.println("Media: " + media);
		
		manager.close();factory.close();
	}

}
