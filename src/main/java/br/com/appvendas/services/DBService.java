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
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public void instatiateTestDataBase() throws ParseException{

		Categoria cat1 = new Categoria (null, "Periféricos");
		Categoria cat2 = new Categoria (null, "Hardware");
		Categoria cat3 = new Categoria (null, "Cadeiras Gamer");
		Categoria cat4 = new Categoria (null, "Smartphones");
		Categoria cat5 = new Categoria (null, "Armazenamento");
		Categoria cat6 = new Categoria (null, "Eletrônicos");

		
		Produto p1 = new Produto(null, "Mouse sem Fio", 20.00);
		Produto p2 = new Produto(null, "Mouse Gamer (Sem Fio)", 129.90);
		Produto p3 = new Produto(null, "Mouse Gamer (Com Fio)", 49.90);
		Produto p4 = new Produto(null, "Teclado Multilaser", 30.00);
		Produto p5 = new Produto(null, "Teclado Gamer Multilaser", 250.00);
		
		Produto p6 = new Produto(null, "Memória 4GB DDR3 Notbook", 210.00);
		Produto p7 = new Produto(null, "Fonte One Power 500W", 115.00);
		Produto p8 = new Produto(null, "Processador AMD FX 6300, Black Edition, Cache 14MB, 3.5GHz (4.1GHz Max Turbo)", 280.00);
		
		Produto p9 = new Produto(null, "Cadeira Gamer PCYes Racer STI Starter", 400.00);
		Produto p10 = new Produto(null, "Cadeira Gamer THUNDERX3 TGC12", 850.00);
		Produto p11 = new Produto(null, "Cadeira Gamer Alpha Kappa Blue", 520.00);
		Produto p12 = new Produto(null, "Cadeira Gamer Vega Black", 770.00);
		
		Produto p13 = new Produto(null, "Apple iPhone 7 32GB Black", 2100.00);
		Produto p14 = new Produto(null, "Apple iPhone 7 Plus 32GB Rose", 2600.00);
		Produto p15 = new Produto(null, "Apple iPhone 8 Plus 64GB Black", 3000.00);
		Produto p16 = new Produto(null, "Apple iPhone 8 128GB Silver", 3200.00);
		Produto p17 = new Produto(null, "Apple iPhone SE 32GB", 1300.00);
		
		Produto p18 = new Produto(null, "HD Externo 1TB Seagate USB 3.0", 280.00);
		Produto p19 = new Produto(null, "HD Externo 2TB Seagate USB 3.0", 378.00);
		Produto p20 = new Produto(null, "Pen Drive Datatraveler Se9 16Gb", 30.00);

		Produto p21 = new Produto(null, "Controle Xbox360 Sem Fio(Paralelo)", 80.00);
		Produto p22 = new Produto(null, "Controle Xbox360 com Fio", 50.00);
		Produto p23 = new Produto(null, "Caixa De Som Bluetooth Jbl Charge 3", 210.00);
		Produto p24 = new Produto(null, "Caixa Bluetooth jbl go", 60.00);
		Produto p25 = new Produto(null, "Caixa De Som Bluetooth JBL Xtreme", 880.00);
		
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat1);
		p3.getCategorias().add(cat1);
		p4.getCategorias().add(cat1);
		p5.getCategorias().add(cat1);
		p6.getCategorias().add(cat2);
		p7.getCategorias().add(cat2);
		p8.getCategorias().add(cat2);
		p9.getCategorias().add(cat3);
		p10.getCategorias().add(cat3);
		p11.getCategorias().add(cat3);
		p12.getCategorias().add(cat3);
		p13.getCategorias().add(cat4);
		p14.getCategorias().add(cat4);
		p15.getCategorias().add(cat4);
		p16.getCategorias().add(cat4);
		p17.getCategorias().add(cat4);
		p18.getCategorias().add(cat5);
		p19.getCategorias().add(cat5);
		p20.getCategorias().add(cat5);
		p21.getCategorias().add(cat6);
		p22.getCategorias().add(cat6);
		p23.getCategorias().add(cat6);
		p24.getCategorias().add(cat6);
		p25.getCategorias().add(cat6);
		
		
		Estado est1 = new Estado(null, "Bahia");
		Cidade c1 = new Cidade(null, "Feira de Santana", est1);
		Cidade c2 = new Cidade(null, "Castro Alves", est1);
		Cidade c3 = new Cidade(null, "Salvador", est1);
		
		
		Estado est2 = new Estado(null, "São Paulo");
		Cidade c4 = new Cidade(null, "São Paulo", est2);
		Cidade c5 = new Cidade(null, "Taboão da Serra", est2);
		Cidade c6 = new Cidade(null, "Osasco", est2);
				
		

		Cliente cli1 = new Cliente(null, "Jessica Santos", "nynaalmeida@icloud.com", "35690187178", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("964775880", "24245858"));
		
		
		Cliente cli2 = new Cliente(null, "Antonia Inacio Santos", "toto@bol.com.br", "87282877114", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("977778888", "24245858"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Rua Odemis", "37", "Apto 41 Bloco 19", "Jardim Umuarama", "05783180", cli1, c4);
		Endereco e2 = new Endereco(null, "Avenida Margarida", "118", "casa do meio", "Cosme de Farias", "40253450", cli1, c3);
		Endereco e3 = new Endereco(null, "Avenida das Nações Unidas", "1180", null, "Pinheiros", "00000000", cli2, c4);
		
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
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5));
		cat2.getProdutos().addAll(Arrays.asList(p6, p7, p8));
		cat3.getProdutos().addAll(Arrays.asList(p9, p10, p11, p12));
		cat4.getProdutos().addAll(Arrays.asList(p13, p14, p15, p16));
		cat5.getProdutos().addAll(Arrays.asList(p18, p19, p20));
		cat6.getProdutos().addAll(Arrays.asList(p21, p22, p23, p24, p25));
	
		
		est1.getCidades().addAll(Arrays.asList(c1, c2, c3));
		est2.getCidades().addAll(Arrays.asList(c4, c5, c6));
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		
								
		categoriaRepository.save(Arrays.asList(cat1, cat2,cat3, cat4, cat5, cat6));
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25));
		
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3, c4, c5, c6));
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto2));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
	}
}
