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
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p13, p14, p15, p16, p17, p18, p19, p20,
		p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
		p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1);
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1);
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1);
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1);
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1);
		
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
		cli2.addPerfil(Perfil.ADMIN);
		
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
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p11));
		produtoRepository.save(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		estadoRepository.save(Arrays.asList(est1, est2, est3));
		cidadeRepository.save(Arrays.asList(c1,c2,c3, c4));
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
	}
}
