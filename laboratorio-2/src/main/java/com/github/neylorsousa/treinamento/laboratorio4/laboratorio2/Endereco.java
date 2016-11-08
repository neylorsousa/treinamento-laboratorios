package com.github.neylorsousa.treinamento.laboratorio4.laboratorio2;

import com.squareup.moshi.Moshi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Endereco {
	private static final String ENDPOINT = "https://viacep.com.br/ws/%s/json/";

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

	public void carregarEnderecoPorCep(String cep, OkHttpClient client) {
		try {
			Request request = new Request.Builder().url(String.format(ENDPOINT, cep)).build();
			Response response = client.newCall(request).execute();
			Endereco endereco = new Moshi.Builder().build().adapter(Endereco.class).fromJson(response.body().string());
			this.cep = cep;
			this.logradouro = endereco.getLogradouro();
			this.complemento = endereco.getComplemento();
			this.bairro = endereco.getBairro();
			this.localidade = endereco.getLocalidade();
			this.uf = endereco.getUf();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}
}