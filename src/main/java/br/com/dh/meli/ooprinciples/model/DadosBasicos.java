package br.com.dh.meli.ooprinciples.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DadosBasicos {

	
	private String nome;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataEntrada;
	
	
	public DadosBasicos(String nome, Cargo cargo, BigDecimal salario, LocalDate dataEntrada) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.dataEntrada = dataEntrada;
	}
	public String getNome() {
		return nome;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	
	
}
