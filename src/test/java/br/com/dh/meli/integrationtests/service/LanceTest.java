package br.com.dh.meli.integrationtests.service;


import org.junit.jupiter.api.Test;

import br.com.dh.meli.leilao.model.Lance;
import br.com.dh.meli.leilao.model.Leilao;
import br.com.dh.meli.leilao.model.LeilaoService;
import br.com.dh.meli.leilao.model.Participante;
import br.com.dh.meli.leilao.repository.LeilaoRepository;

import static org.junit.jupiter.api.Assertions.*;


public class LanceTest {

	@Test
	public void deve_EfetuarUmLance() {
		Leilao leilao = new Leilao("ps5");
		LeilaoRepository repository = new LeilaoRepository();
		repository.salva(leilao);
		Leilao leilaoExistente = repository.get(leilao);
		Participante participante = new Participante("kenyo");
		Lance lance = new Lance(leilaoExistente, participante, 500.00);
		
		LeilaoService service = new LeilaoService(repository);
		service.efetuaLance(lance);
		
		boolean contains = leilao.getLances().contains(lance);
		
		assertTrue(contains);
		
	}
}
