package br.com.dh.meli.ooprinciples.model;

import java.util.Arrays;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {	
		List<ValidacaoAumento> validacoes = Arrays.asList(
				new ValidacaoPeriodoMinimoAumento(),
				new ValidacaoValorAumento()
		);
		new ReajusteSalarioService(validacoes);
	}
	
	
	private static int divide(int a, int b) throws MinhaExcecao{
		if(b==0)
			throw new MinhaExcecao("o param b deve ser diferente de zero");
		int result = 0;
		try {
			result = a/b;
		}catch(Exception e) {
			//gerar um log
			// enviar email para todo mundo do meli
			// enviar uma msg de WA para todos devs
			throw new MinhaExcecao(e.getMessage());
		}
		
		return result;
	}
}
