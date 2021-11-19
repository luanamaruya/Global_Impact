package br.com.fiap.cpdevops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cpdevops.model.Invest;

public interface InvestRepository extends JpaRepository<Invest, Long>{
	
	public Long countById(Long id);

}
