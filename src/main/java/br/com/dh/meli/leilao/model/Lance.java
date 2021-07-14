package br.com.dh.meli.leilao.model;

public class Lance {

	private Leilao leilao;
	private Participante participante;
	private double valor;

	public Lance(Leilao leilao, Participante participante, double valor) {
		this.leilao = leilao;
		this.participante = participante;
		this.valor = valor;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public Participante getParticipante() {
		return participante;
	}

	public double getValor() {
		return valor;
	}

	
}
