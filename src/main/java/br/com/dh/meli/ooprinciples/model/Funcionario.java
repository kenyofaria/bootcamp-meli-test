package br.com.dh.meli.ooprinciples.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Funcionario {

	private DadosBasicos dadosBasicos;
	private List<Reajuste> reajustes;
	
	
	public Funcionario() {
		initReajustes();
	}

	
	public Funcionario(DadosBasicos dadosBasicos) {
		super();
		this.dadosBasicos = dadosBasicos;
		initReajustes();
	}
	
	public Funcionario(DadosBasicos dadosBasicos, List<Reajuste> reajustes) {
		super();
		this.dadosBasicos = dadosBasicos;
		this.reajustes = reajustes;
	}
	
	private void initReajustes() {
		this.reajustes = new ArrayList<Reajuste>();
	}
	
	public void reajustaSalario(BigDecimal salario) {
		this.dadosBasicos.getSalario().add(salario);
	}

	public String getNome() {
		return this.dadosBasicos.getNome();
	}


	public Cargo getCargo() {
		return this.dadosBasicos.getCargo();
	}


	public BigDecimal getSalario() {
		return this.dadosBasicos.getSalario();
	}
	
	public LocalDate getDataEntrada() {
		return this.dadosBasicos.getDataEntrada();
	}
	
	public BigDecimal getValorTotalEmReajustes(){
		BigDecimal total = this.reajustes.stream().map(r -> r.getValor()).reduce(new BigDecimal(0), BigDecimal::add);
		return total;
	}

}
