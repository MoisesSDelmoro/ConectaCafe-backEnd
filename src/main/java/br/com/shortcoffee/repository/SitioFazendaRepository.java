package br.com.shortcoffee.repository;

import br.com.shortcoffee.entity.SitioFazenda;
import java.util.Optional;

public interface SitioFazendaRepository {

    Optional<SitioFazenda> findById(String id);

}
