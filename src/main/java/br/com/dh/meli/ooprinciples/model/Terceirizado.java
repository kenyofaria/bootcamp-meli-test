package br.com.dh.meli.ooprinciples.model;

public class Terceirizado{

	
	private String empresa;
	private DadosBasicos dadosBasicos;
	
	public Terceirizado(String empresa, DadosBasicos dadosBasicos) {
		this.empresa = empresa;
		this.dadosBasicos = dadosBasicos;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	public DadosBasicos getDadosBasicos() {
		return dadosBasicos;
	}
}
