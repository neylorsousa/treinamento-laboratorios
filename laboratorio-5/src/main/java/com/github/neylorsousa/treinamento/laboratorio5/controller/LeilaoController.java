package com.github.neylorsousa.treinamento.laboratorio5.controller;

import com.github.neylorsousa.treinamento.laboratorio5.entity.Leilao;
import com.github.neylorsousa.treinamento.laboratorio5.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController("/leiloes")
public class LeilaoController {

	@Autowired
	private LeilaoService leilaoService;

	@RequestMapping(method = POST)
	public Leilao salvarLeilao(@RequestBody Leilao leilao) {
		leilaoService.persistir(leilao);
		return leilao;
	}

	@RequestMapping(method = PUT)
	public void atualizarLeilao(@RequestBody Leilao leilao) {
		leilaoService.persistir(leilao);
	}

	@RequestMapping(method = GET, value = "/leiloes/{id}")
	public Leilao buscarPorId(@PathVariable Integer id) {
		return leilaoService.pesquisarPorId(id);
	}

	@RequestMapping(method = DELETE, value = "/leiloes/{id}")
	public void removerPorId(@PathVariable Integer id) {
		leilaoService.deletar(id);
	}

}
