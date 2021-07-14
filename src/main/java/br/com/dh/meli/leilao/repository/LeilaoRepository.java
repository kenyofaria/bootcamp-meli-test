package br.com.dh.meli.leilao.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.dh.meli.leilao.model.Leilao;

public class LeilaoRepository {

	private List<Leilao> leiloes = new ArrayList<>();

	public void salva(Leilao leilao) {
		leiloes.add(leilao);
	}

	public List<Leilao> list() {
		return leiloes;
	}

	public Leilao get(Leilao leilao) {
		return leiloes.stream().filter(l -> l.getNome().equalsIgnoreCase(leilao.getNome())).findAny()
				.orElse(null);
	}



}
