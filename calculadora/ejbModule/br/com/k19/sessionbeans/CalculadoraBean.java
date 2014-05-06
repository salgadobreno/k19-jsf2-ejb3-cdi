package br.com.k19.sessionbeans;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculadoraBean
 */
@Stateless
public class CalculadoraBean implements Calculadora {

	public double soma(double a, double b) {
		return a + b;
	}

}
