package br.com.dh.meli.ooprinciples.model;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteSalarioService {


	private List<ValidacaoAumento> validacoes;
	
	public ReajusteSalarioService(List<ValidacaoAumento> validacoes) {
		this.validacoes = validacoes;
	}
	
	public void reajustaSalario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));
		funcionario.reajustaSalario(aumento);
	}
}
