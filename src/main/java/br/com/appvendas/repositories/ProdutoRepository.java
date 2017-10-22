package br.com.appvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.appvendas.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
