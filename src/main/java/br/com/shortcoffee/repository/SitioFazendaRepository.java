package br.com.shortcoffee.repository;

import br.com.shortcoffee.entity.Cafeicultor;
import br.com.shortcoffee.entity.SitioFazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SitioFazendaRepository extends JpaRepository<SitioFazenda, Long>{

    Optional<SitioFazenda> findBySitioFazendaId(Long sitioFazendaId);
    @Query(value = "SELECT * FROM SITIO_FAZENDA WHERE cafeicutor_id = :cafeicultorId", nativeQuery = true)
    SitioFazenda findByCafeicultorId(@Param("cafeicultorId") int id);

}
