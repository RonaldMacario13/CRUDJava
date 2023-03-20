package com.CRUDJava.CrudJava.service;

import java.util.List;
import java.util.Optional;

import com.CRUDJava.CrudJava.model.Produto;
import com.CRUDJava.CrudJava.model.dto.ProdutoDTO;
import com.CRUDJava.CrudJava.utils.ProdutoException;

public interface ProdutoService {
	
	List<Produto> listarProdutos();
	
	Optional<Produto> buscarProdutoPorId(Long id);
	
	Produto adicionarProduto(ProdutoDTO produto) throws ProdutoException;
	
	void atualizarProduto(ProdutoDTO produto, Long id) throws ProdutoException;
	
	void removerProduto(Long id) throws ProdutoException;
}
