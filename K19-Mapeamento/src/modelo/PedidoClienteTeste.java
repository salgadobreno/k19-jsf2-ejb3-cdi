package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PedidoClienteTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Pedido p = new Pedido();
		Cliente c = new Cliente();
		
		p.setCliente(c);
	}

}
