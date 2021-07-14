package br.com.dh.meli.ooprinciples.model;

import java.math.BigDecimal;

public interface ValidacaoAumento {

	void validar(Funcionario funcionario, BigDecimal valor);
}
