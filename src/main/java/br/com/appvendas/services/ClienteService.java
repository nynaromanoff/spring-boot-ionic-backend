package br.com.appvendas.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.appvendas.domain.Cidade;
import br.com.appvendas.domain.Cliente;
import br.com.appvendas.domain.Endereco;
import br.com.appvendas.domain.enums.Perfil;
import br.com.appvendas.domain.enums.TipoCliente;
import br.com.appvendas.dto.ClienteDTO;
import br.com.appvendas.dto.ClienteNewDTO;
import br.com.appvendas.repositories.CidadeRepository;
import br.com.appvendas.repositories.ClienteRepository;
import br.com.appvendas.repositories.EnderecoRepository;
import br.com.appvendas.security.UserSS;
import br.com.appvendas.services.exceptions.AuthorizationException;
import br.com.appvendas.services.exceptions.DataIntegrityException;
import br.com.appvendas.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private S3Service s3Service;
	
	public Cliente find(Integer id){
		
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado!");
		}
		
		Cliente obj = repo.findOne(id);
		if(obj == null){
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+", Tipo: "+Cliente.class.getName());
		}
		return obj;
		
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.save(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id){
		find(id);
		
		try{
			repo.delete(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados.");
		}
	}
	 
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto){
	 return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto){
		
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()), pe.encode(objDto.getSenha()));
		Cidade cid =  cidadeRepository.findOne(objDto.getCidadeId());
		Endereco end = new Endereco(null, objDto.getLongradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2()!= null){
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3()!= null){
			cli.getTelefones().add(objDto.getTelefone3());
		}
		
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}
	
	public URI uploadProfilePicture(MultipartFile multipartfile) {
		return s3Service.uploadFile(multipartfile);
	}
}
