package br.com.dh.meli.leilao.model;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String nome;
	private List<Lance> lances;

	public Leilao(String nome) {
		this.nome = nome;
		lances = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}

	public List<Lance> getLances() {
		return lances;
	}
	
	public void addLance(Lance lance) {
		if(this.lances == null)
			this.lances = new ArrayList<>();
		this.lances.add(lance);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return nome.equals(((Leilao) obj).nome);
	}
}
