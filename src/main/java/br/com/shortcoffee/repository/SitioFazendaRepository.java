package br.com.shortcoffee.repository;

import br.com.shortcoffee.entity.Cafeicultor;
import br.com.shortcoffee.entity.SitioFazenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SitioFazendaRepository extends JpaRepository<SitioFazenda, Long>{

    Optional<SitioFazenda> findBySitioFazendaId(Long sitioFazendaId);

}
