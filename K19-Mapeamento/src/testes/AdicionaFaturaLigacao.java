package testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Fatura;
import modelo.Ligacao;

public class AdicionaFaturaLigacao {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();

		Ligacao l1 = new Ligacao();
		Ligacao l2 = new Ligacao();
		l1.setDuracao(3);
		l2.setDuracao(5);
		
		Fatura f = new Fatura();
		f.setVencimento(new GregorianCalendar());
		
		f.getLigacoes().add(l1);
		f.getLigacoes().add(l2);

		l1.setFatura(f);
		l2.setFatura(f);
		
		manager.persist(f);
		manager.persist(l1);
		manager.persist(l2);
		
		manager.getTransaction().commit();
		manager.close(); factory.close();

		
	}
}
