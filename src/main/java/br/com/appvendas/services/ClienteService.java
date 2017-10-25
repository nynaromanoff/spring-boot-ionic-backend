package br.com.appvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.domain.Cliente;
import br.com.appvendas.repositories.ClienteRepository;
import br.com.appvendas.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id){
		
		Cliente obj = repo.findOne(id);
		if(obj == null){
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+", Tipo: "+Cliente.class.getName());
		}
		return obj;
		
	}
}
