package br.com.eullerx.springbootproperties.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.eullerx.springbootproperties.entity.Propriedade;

public interface PropriedadeRepository extends PagingAndSortingRepository<Propriedade, String> {

	@Query("Select c from Propriedade c where c.nome like %:filtro% order by categoria,subcategoria,nome")
	public List<Propriedade> findByFiltro(@Param("filtro") String filtro);
}
