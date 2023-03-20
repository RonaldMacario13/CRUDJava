package com.CRUDJava.CrudJava.model.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
	
	private String nome;
	
	private Double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
