package com.CRUDJava.CrudJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUDJava.CrudJava.model.Produto;
import com.CRUDJava.CrudJava.model.dto.ProdutoDTO;
import com.CRUDJava.CrudJava.repository.ProdutoRepository;
import com.CRUDJava.CrudJava.utils.ProdutoException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repositorio;
	
	@Override
	public List<Produto> listarProdutos() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Produto> buscarProdutoPorId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Produto adicionarProduto(ProdutoDTO produto) throws ProdutoException {
		Produto produtoSalvar = new Produto();
		produtoSalvar.setNome(produto.getNome());
		produtoSalvar.setPreco(produto.getPreco());
		
		return repositorio.save(produtoSalvar);
	}

	@Override
	public void atualizarProduto(ProdutoDTO produto, Long id) throws ProdutoException {
		if (repositorio.findById(id).isEmpty()) {
			throw new ProdutoException("Não existe um produto associado a este id.");
		}
		
		Produto produtoExistente = repositorio.findById(id).get();
		if (produtoExistente.getNome() != null && !produtoExistente.getNome().equals(produto.getNome())) {
			produtoExistente.setNome(produto.getNome());
		}
		
		if (produtoExistente.getPreco() != null && !produtoExistente.getPreco().equals(produto.getPreco())) {
			produtoExistente.setPreco(produto.getPreco());
		}
		
		repositorio.save(produtoExistente);
	}

	@Override
	public void removerProduto(Long id) throws ProdutoException {
		if (repositorio.findById(id).isEmpty()) {
			throw new ProdutoException("Não existe um produto associado a este id.");
		}
		
		repositorio.deleteById(id);
	}

}
