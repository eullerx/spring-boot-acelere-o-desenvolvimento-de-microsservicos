package br.com.carvalho.springbootgreendogdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.carvalho.springbootgreendogdelivery.domain.Cliente;
import br.com.carvalho.springbootgreendogdelivery.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Cliente> clientes = this.clienteRepository.findAll();
		return new ModelAndView("clientes/list", "clientes", clientes);
	}
	
	public ModelAndView view(@PathVariable("id")	Cliente	cliente) {
		return new ModelAndView("clientes/view","cliente",cliente);
	}

}
