package br.com.shortcoffee.repository;

import br.com.shortcoffee.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CafeRepository extends JpaRepository<Cafe, Long> {

    Optional<Cafe> findByCafeId(Long cafeId);

}
