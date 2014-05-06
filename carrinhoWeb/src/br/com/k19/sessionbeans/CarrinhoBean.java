package br.com.k19.sessionbeans;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoBean implements Carrinho {
	
	private Set<String> produtos = new HashSet<String>();
	private static int contadorTotal;
	private static int contadorAtivos;
	private int id;
	
	public Set<String> getProdutos() {
		return produtos;
	}

	public void adiciona(String produto) {
		this.produtos.add(produto);
	}
	
	public void remove(String produto) {
		this.produtos.remove(produto);
	}

	@Remove
	public void finalizaCompra() {
	}
	
	@PostConstruct
	public void postConstruct() {
		synchronized (CarrinhoBean.class) {
			CarrinhoBean.contadorTotal++;
			CarrinhoBean.contadorAtivos++;
			this.id = CarrinhoBean.contadorTotal;
			
			System.out.println("PostConstruct");
			printDados();
		}
	}
	
	@PrePassivate
	public void prePassivate(){
		CarrinhoBean.contadorAtivos--;
		System.out.println("PrePassivate");
		printDados();
	}
	
	@PostActivate
	public void postActivate(){
		CarrinhoBean.contadorAtivos++;
		System.out.println("postActivate");
		printDados();
	}
	
	@PreDestroy
	public void preDestroy(){
		CarrinhoBean.contadorAtivos--;
		System.out.println("preDestroy");
		synchronized (CarrinhoBean.class) {
			CarrinhoBean.contadorAtivos--;
			System.out.println("preDestory");
			printDados();
		}
	}

	private void printDados() {
		System.out.println("ID:" + this.id);
		System.out.println("Contador Total:" + CarrinhoBean.contadorTotal);
		System.out.println("Contador Ativos" + CarrinhoBean.contadorAtivos);
	}
	

}
