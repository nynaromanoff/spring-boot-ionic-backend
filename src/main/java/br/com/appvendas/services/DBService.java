package br.com.appvendas.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.appvendas.domain.Categoria;
import br.com.appvendas.domain.Cidade;
import br.com.appvendas.domain.Cliente;
import br.com.appvendas.domain.Endereco;
import br.com.appvendas.domain.Estado;
import br.com.appvendas.domain.ItemPedido;
import br.com.appvendas.domain.Pagamento;
import br.com.appvendas.domain.PagamentoComBoleto;
import br.com.appvendas.domain.PagamentoComCartao;
import br.com.appvendas.domain.Pedido;
import br.com.appvendas.domain.Produto;
import br.com.appvendas.domain.enums.EstadoPagamento;
import br.com.appvendas.domain.enums.Perfil;
import br.com.appvendas.domain.enums.TipoCliente;
import br.com.appvendas.repositories.CategoriaRepository;
import br.com.appvendas.repositories.CidadeRepository;
import br.com.appvendas.repositories.ClienteRepository;
import br.com.appvendas.repositories.EnderecoRepository;
import br.com.appvendas.repositories.EstadoRepository;
import br.com.appvendas.repositories.ItemPedidoRepository;
import br.com.appvendas.repositories.PagamentoRepository;
import br.com.appvendas.repositories.PedidoRepository;
import br.com.appvendas.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instatiateTestDataBase() throws ParseException{

		Categoria cat1 = new Categoria (null, "Informática");
		Categoria cat2 = new Categoria (null, "Escritório");
		Categoria cat3 = new Categoria (null, "Cama, Mesa e Banho");
		Categoria cat4 = new Categoria (null, "Eletrônico");
		Categoria cat5 = new Categoria (null, "Jardinagem");
		Categoria cat6 = new Categoria (null, "Decoração");
		Categoria cat7 = new Categoria (null, "Perfumaria");

		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de Escritório", 2000.00);
		Produto p5 = new Produto(null, "Impressora", 800.00);
		Produto p6 = new Produto(null, "Toalha", 80.00);
		Produto p7 = new Produto(null, "Colcha", 2000.00);
		Produto p8 = new Produto(null, "TV true color", 800.00);
		Produto p9 = new Produto(null, "Roçadeira", 80.00);
		Produto p10 = new Produto(null, "Abajour", 2000.00);
		Produto p11 = new Produto(null, "Pendente", 800.00);
		Produto p12 = new Produto(null, "Shampoo", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Bahia");

				
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Salvador", est3);
		

		Cliente cli1 = new Cliente(null, "Jessica Santos", "nynaalmeida@icloud.com", "35690187178", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("964775880", "24245858"));
		
		Cliente cli2 = new Cliente(null, "Antonia Inacio Santos", "toto@bol.com.br", "87282877114", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("977778888", "24245858"));
		cli2.addPerfil(Perfil.ADIMIN);
		
		Endereco e1 = new Endereco(null, "Rua Odemis", "37", "Apto 41 Bloco 19", "Jardim Umuarama", "05783180", cli1, c2);
		Endereco e2 = new Endereco(null, "Avenida Margarida", "118", "casa do meio", "Cosme de Farias", "40253450", cli1, c4);
		Endereco e3 = new Endereco(null, "Avenida das Nações Unidas", "1180", null, "Pinheiros", "00000000", cli2, c2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 =  new Pedido(null, sdf.parse("24/10/2017 14:05"), cli1, e1);
		Pedido ped2 =  new Pedido(null, sdf.parse("24/10/2017 14:15"), cli1, e1);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("27/10/2017 23:59"),null);
		ped2.setPagamento(pagto2);
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11, p12));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
								
		categoriaRepository.save(Arrays.asList(cat1, cat2,cat3, cat4, cat5, cat6, cat7));
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p11, p12));
		
		estadoRepository.save(Arrays.asList(est1, est2, est3));
		cidadeRepository.save(Arrays.asList(c1,c2,c3, c4));
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
	}
}
