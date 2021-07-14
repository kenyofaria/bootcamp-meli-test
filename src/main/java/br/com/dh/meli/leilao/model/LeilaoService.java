package br.com.dh.meli.leilao.model;

import java.util.List;

import br.com.dh.meli.leilao.repository.LeilaoRepository;

public class LeilaoService {
	
	
	private LeilaoRepository repository;

	public LeilaoService(LeilaoRepository repository) {
		this.repository = repository;
	}
	
	public void salva(Leilao leilao) {

		if (leilao.getNome().trim().isEmpty())
			throw new RuntimeException("o nome do leilao eh obrigatorio");

		if (leilaoJaCadastrado(leilao))
			throw new RuntimeException("leilao ja cadastrado");

		this.repository.salva(leilao);
	}

	public List<Leilao> list() {
		return this.repository.list();
	}

	private boolean leilaoJaCadastrado(Leilao leilao) {
		return this.repository.list().contains(leilao);
	}

	public Leilao get(Leilao leilao) {
		return this.repository.list().stream().filter(l -> l.getNome().equalsIgnoreCase(leilao.getNome())).findAny()
				.orElse(null);
	}

	public void efetuaLance(Lance lance) {
		Leilao leilao = get(lance.getLeilao());
		leilao.addLance(lance);
	}
}
