import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class AdicionaUsuario {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();

		Usuario usuario = new Usuario();
		
		usuario.setEmail("x@example.com");
		usuario.setDataDeCadastro(Calendar.getInstance());
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
