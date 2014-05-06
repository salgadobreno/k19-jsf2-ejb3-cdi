package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import modelo.Livro;

public class ConsultaNomePrecoDosLivros {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_criteria_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c = cb.createQuery(Tuple.class); 
		Root<Livro> l = c.from(Livro.class); 
		c.multiselect(l.<String>get("nome").alias("nome"), l.<Double>get("preco").alias("preco"));
		
		TypedQuery<Tuple> query = manager.createQuery(c);
		List<Tuple> resultado = query.getResultList();
		
		for (Tuple registro : resultado) {
			System.out.println("Livro: " + registro.get("nome"));
			System.out.println("Preço: " + registro.get("preco"));
		}
		
		manager.close();factory.close();
	}
	

}
