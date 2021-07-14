package br.com.dh.meli.integrationtests.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import br.com.dh.meli.leilao.model.Leilao;
import br.com.dh.meli.leilao.model.LeilaoService;
import br.com.dh.meli.leilao.repository.LeilaoRepository;

public class LeilaoTest {

	private LeilaoRepository repository;
	private LeilaoService service;

	@BeforeEach
	public void init() {
		repository = Mockito.mock(LeilaoRepository.class);
		service = new LeilaoService(repository);
	}
	
	@AfterEach
	public void after() {
		System.out.println("executando");
	}

	@Test
	public void deve_AdicionarUmLeilao() {
		// setup
		Leilao ps5 = new Leilao("PS5");

		// execucao
		service.salva(ps5);

		Mockito.when(repository.list()).thenReturn(Arrays.asList(ps5));

		// check
		Mockito.verify(repository).salva(ps5);
		List<Leilao> leiloes = repository.list();
		assertTrue(leiloes.contains(ps5));
	}

	@Test
	public void naoDeve_AdicionarUmLeilao_SemNome() {
		// setup
		Leilao ps5 = new Leilao("");

		// execucao
		Exception exception = assertThrows(RuntimeException.class, () -> {
			service.salva(ps5);
		});

		// check
		Mockito.verify(repository, Mockito.never()).salva(ps5);
		String expectedMessage = "o nome do leilao eh obrigatorio".toLowerCase();
		String actualMessage = exception.getMessage().toLowerCase();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void naoDeve_AdicionarUmLeilao_ComNomesIguais() {
		// setup
		Leilao ps5 = new Leilao("ps5");

		// execucao
		Mockito.when(repository.list()).thenReturn(Arrays.asList(ps5));

//		expectedEx.expect(RuntimeException.class);
//		expectedEx.expectMessage("leilao ja cadastrado");

		Mockito.doThrow(new RuntimeException()).when(repository).salva(ps5);

		Exception e = assertThrows(RuntimeException.class, () -> {
			service.salva(ps5);
		});

		String expectedMessage = "leilao ja cadastrado".toLowerCase();
		String actualMessage = e.getMessage().toLowerCase();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
