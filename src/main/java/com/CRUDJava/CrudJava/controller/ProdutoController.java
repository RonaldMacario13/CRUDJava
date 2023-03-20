package com.CRUDJava.CrudJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUDJava.CrudJava.model.Produto;
import com.CRUDJava.CrudJava.model.dto.ProdutoDTO;
import com.CRUDJava.CrudJava.service.ProdutoService;
import com.CRUDJava.CrudJava.utils.ProdutoException;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> ListarProdutos() {
		return ResponseEntity.ok(servico.listarProdutos());
	}
	
	//buscarProdutoPorId
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProdutoPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(servico.buscarProdutoPorId(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> adicionarProduto(@RequestBody ProdutoDTO produtoDTO) {
		try {
			Produto resultado = servico.adicionarProduto(produtoDTO);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
			
		} catch (ProdutoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarProduto(@RequestBody ProdutoDTO produtoDTO, @PathVariable Long id) {
		try {
			servico.atualizarProduto(produtoDTO, id);
			
		} catch (ProdutoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//removerProdutoPorId
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerProduto(@PathVariable Long id) {
		try {
			servico.removerProduto(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
