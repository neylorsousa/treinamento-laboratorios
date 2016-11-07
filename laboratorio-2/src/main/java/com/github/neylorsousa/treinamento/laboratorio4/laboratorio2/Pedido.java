package com.github.neylorsousa.treinamento.laboratorio4.laboratorio2;

import com.github.neylorsousa.treinamento.laboratorio4.teste.laboratorio1.CarrinhoCompra;
import okhttp3.OkHttpClient;

import java.sql.*;

public class Pedido {
	private CarrinhoCompra carrinhoCompra;
	private Endereco enderecoEntrega;
	private Usuario usuario;

	public Pedido(CarrinhoCompra carrinhoCompra, String cepEnderecoEntrega, OkHttpClient cepWebService) {
		this.carrinhoCompra = carrinhoCompra;
		this.enderecoEntrega = new Endereco();
		this.enderecoEntrega.carregarEnderecoPorCep(cepEnderecoEntrega, cepWebService);
	}

	public CarrinhoCompra getCarrinhoCompra() {
		return carrinhoCompra;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void carregarUsuarioPorCpf(String cpf) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "teste", "teste");
			PreparedStatement preparedStatement = connection.prepareStatement("select login from usuario where cpf=?");
			preparedStatement.setString(1, cpf);
			ResultSet resultSet = preparedStatement.getResultSet();
			if (resultSet.next()) {
				usuario = new Usuario();
				usuario.setCpf(cpf);
				usuario.setLogin(resultSet.getString("login"));
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
