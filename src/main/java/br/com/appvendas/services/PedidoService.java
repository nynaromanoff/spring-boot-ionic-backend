package br.com.appvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.domain.Pedido;
import br.com.appvendas.repositories.PedidoRepository;
import br.com.appvendas.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id){
		
		Pedido obj = repo.findOne(id);
		if(obj == null){
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+", Tipo: "+Pedido.class.getName());
		}
		
		return obj;
		
	}
}
