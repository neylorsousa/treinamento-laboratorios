package com.github.neylorsousa.treinamento.laboratorio4.domain;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class LanceViewDTO {
	public final String leilao;
	public final String nomePessoa;
	public final Double valorLance;

	public LanceViewDTO(String leilao, String nomePessoa, Double valorLance) {
		this.leilao = leilao;
		this.nomePessoa = nomePessoa;
		this.valorLance = valorLance;
	}

	public static List<LanceViewDTO> leilaoToListDto(Leilao leilao) {
		if (leilao.getLances() == null) return emptyList();
		return leilao.getLances().stream()
				.map(lance -> new LanceViewDTO(leilao.getNome(), lance.getNomePessoa(), lance.getValor()))
				.collect(toList());
	}
}
