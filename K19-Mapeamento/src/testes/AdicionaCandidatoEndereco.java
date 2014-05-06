package testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Candidato;
import modelo.Endereco;

public class AdicionaCandidatoEndereco {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Endereco e = new Endereco();
		e.setCidade("BSB");
		e.setEstado("df");
		e.setLogradouro("balbalbal");
		e.setNumero(14);
		
		Candidato c = new Candidato();
		c.setNome("Breno");
		c.setNascimento(new GregorianCalendar());
		c.setEndereço(e);
		
		manager.persist(c);
		manager.getTransaction().commit();
		manager.close();factory.close();
		
	}

}
