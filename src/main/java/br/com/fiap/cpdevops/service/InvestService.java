package br.com.fiap.cpdevops.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.cpdevops.exception.InvestNotFoundException;
import br.com.fiap.cpdevops.model.Invest;
import br.com.fiap.cpdevops.repository.InvestRepository;

@Service
public class InvestService {
	
	@Autowired
	private InvestRepository repository;
	
	public List<Invest> listAll() {
		return repository.findAll();
	}
	
	public void save(Invest invest) {
		repository.save(invest);
	}
	
	public Invest getById(Long id) throws InvestNotFoundException {
		Optional<Invest> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new InvestNotFoundException("Could not find any users with ID" + id);
	}
	
	public void deleteById(Long id) throws InvestNotFoundException {
		Long count = repository.countById(id);
		if (count == null || count == 0) {
			throw new InvestNotFoundException("Could not find any users with ID" + id);
		}
		repository.deleteById(id);
		
	}
	
}