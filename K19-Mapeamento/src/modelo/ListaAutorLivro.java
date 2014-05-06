package modelo;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaAutorLivro {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("select a from Autor a left join fetch a.livros", Autor.class);
		List<Autor> autores = query.getResultList();
		System.out.println();
		
		for (Autor autor : autores) {
			System.out.println("Autor: " + autor.getNome());
			Collection<Livro> livros = autor.getLivros();
			System.out.println("Qtd de livros: " + livros.size());
			
			for (Livro livro : livros) {
				System.out.println("Livro: " + livro.getNome());
			}
			System.out.println();
		}
		
		manager.close(); factory.close();
		
	}

}
