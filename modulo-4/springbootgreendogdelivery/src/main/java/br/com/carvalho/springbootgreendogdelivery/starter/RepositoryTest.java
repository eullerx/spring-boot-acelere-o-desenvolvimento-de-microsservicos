package br.com.carvalho.springbootgreendogdelivery.starter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.carvalho.springbootgreendogdelivery.domain.Cliente;
import br.com.carvalho.springbootgreendogdelivery.domain.Item;
import br.com.carvalho.springbootgreendogdelivery.domain.Pedido;
import br.com.carvalho.springbootgreendogdelivery.repository.ClienteRepository;

//ApplicationRunner - interface do spring boot para execução de classes
@Component
public class RepositoryTest implements ApplicationRunner {

	private static final long ID_CLIENTE1 = 11l;
	private static final long ID_CLIENTE2 = 22l;

	private static final long ID_ITEM1 = 100l;
	private static final long ID_ITEM2 = 101l;
	private static final long ID_ITEM3 = 102l;

	private static final long ID_PEDIDO1 = 1000l;
	private static final long ID_PEDIDO2 = 1001l;
	private static final long ID_PEDIDO3 = 1002l;

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		System.out.println(">>>	Iniciando carga de dados...");
		Cliente cliente1 = new Cliente(ID_CLIENTE1, "Cliente 1", "SP");
		Cliente cliente2 = new Cliente(ID_CLIENTE2, "Cliente 2", "RJ");

		Item dog1 = new Item(ID_ITEM1, "Green Dog tradicional", 25d);
		Item dog2 = new Item(ID_ITEM2, "Green Dog tradicional picante", 27d);
		Item dog3 = new Item(ID_ITEM3, "Green Dog max salada", 30d);

		List<Item> listaPedidoCliente11 = new ArrayList<Item>();
		listaPedidoCliente11.add(dog1);
		
		List<Item> listaPedidoCliente21 = new ArrayList<Item>();
		listaPedidoCliente21.add(dog2);
		listaPedidoCliente21.add(dog3);

		Pedido pedidoDoCliente1 = new Pedido(ID_PEDIDO1, cliente1, listaPedidoCliente11, dog1.getPreco());
		cliente1.addPedido(pedidoDoCliente1);

		Pedido pedidoDoCliente2 = new Pedido(ID_PEDIDO2, cliente2, listaPedidoCliente21,
				dog2.getPreco() + dog3.getPreco());
		cliente2.addPedido(pedidoDoCliente2);

		System.out.println(">>> Pedido 1 - Cliente 1: " + pedidoDoCliente1);
		System.out.println(">>> Pedido 2 - Cliente 2: " + pedidoDoCliente2);

		clienteRepository.saveAndFlush(cliente2);
		System.out.println(">>> Gravado cliente 2: " + cliente2);

		List<Item> listaPedidoCliente22 = new ArrayList<Item>();
		listaPedidoCliente22.add(dog2);
		
		Pedido pedido2DoCliente2 = new Pedido(ID_PEDIDO3, cliente1, listaPedidoCliente22, dog2.getPreco());
		cliente1.addPedido(pedido2DoCliente2);
		
		clienteRepository.saveAndFlush(cliente1);
		
		System.out.println(">>> Pedido 2-Fernando: " + pedido2DoCliente2);
		System.out.println(">>> Gravado cliente	1: " + cliente1);
		System.out.println(">>> Fim da carga de dados...");
	}

}
