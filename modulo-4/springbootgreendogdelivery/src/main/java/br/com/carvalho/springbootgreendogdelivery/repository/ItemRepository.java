package br.com.carvalho.springbootgreendogdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carvalho.springbootgreendogdelivery.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
