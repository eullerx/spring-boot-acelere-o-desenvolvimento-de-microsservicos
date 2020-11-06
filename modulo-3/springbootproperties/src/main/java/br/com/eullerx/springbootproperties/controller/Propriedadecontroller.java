package br.com.eullerx.springbootproperties.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eullerx.springbootproperties.entity.Propriedade;
import br.com.eullerx.springbootproperties.repository.PropriedadeRepository;

@RestController
@RequestMapping("/api")
public class Propriedadecontroller {
	
	@Autowired
	private PropriedadeRepository propriedadeRepository;
	
	@RequestMapping(value="/find/{filtro}",method = RequestMethod.GET)
	List<Propriedade> findByfiltro(@PathVariable("filtro") String filtro){
		return propriedadeRepository.findByFiltro(filtro);
	}
	

}
