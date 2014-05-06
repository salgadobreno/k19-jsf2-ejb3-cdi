package testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Comentario;
import modelo.Topico;

public class AdicionaTopicoComentarios {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Topico topico = new Topico();
		topico.setTitulo("lasjlaj");
		for (int i = 0; i < 10; i++) {
			Comentario comentario = new Comentario();
			comentario.setData(Calendar.getInstance());
			topico.getComentarios().add(comentario);
		}
		
		manager.persist(topico);
		manager.getTransaction().commit();
		
		manager.close();factory.close();
		
	}

}
