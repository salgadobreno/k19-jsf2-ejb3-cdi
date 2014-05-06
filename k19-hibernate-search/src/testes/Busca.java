package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Pessoa;

import org.hibernate.search.SearchFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

public class Busca {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_hibernatesearch_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		FullTextEntityManager fullTextManager = Search.getFullTextEntityManager(manager);
		SearchFactory searchFactory = fullTextManager.getSearchFactory();
		QueryBuilder pessoaQueryBuilder = searchFactory.buildQueryBuilder().forEntity(Pessoa.class).get();
		
		org.apache.lucene.search.Query luceneQuery = pessoaQueryBuilder.keyword().onField("nome").matching("salgado").createQuery();
		Query jpaQuery = fullTextManager.createFullTextQuery(luceneQuery, Pessoa.class);
		
		List<Pessoa> pessoas = jpaQuery.getResultList();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome());
		}
		
		
		manager.close();factory.close();
	}

}
