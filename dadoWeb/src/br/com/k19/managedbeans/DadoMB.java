package br.com.k19.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class DadoMB {

	@EJB
	private LancadorDeDadoBean lancadorDeDadoBean;
	
	private int resultado;
	
	public void lancaDado(){
		this.resultado = this.lancadorDeDadoBean.lanca();
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}
