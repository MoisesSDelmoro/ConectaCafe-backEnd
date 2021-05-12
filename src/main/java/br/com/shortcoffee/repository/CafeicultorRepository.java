package br.com.shortcoffee.repository;

import br.com.shortcoffee.entity.Cafeicultor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CafeicultorRepository extends JpaRepository<Cafeicultor, Long> {

    Optional<Cafeicultor> findByCpf(String cpf);

}
