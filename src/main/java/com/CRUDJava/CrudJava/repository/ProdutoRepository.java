package com.CRUDJava.CrudJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUDJava.CrudJava.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
