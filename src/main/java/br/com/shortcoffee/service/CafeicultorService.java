package br.com.shortcoffee.service;

import br.com.shortcoffee.entity.Cafeicultor;
import br.com.shortcoffee.exception.CafeicultorException;
import br.com.shortcoffee.repository.CafeicultorRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeicultorService {

    @Autowired
    private CafeicultorRepository cafeicultorRepository;

    public Cafeicultor save(Cafeicultor cafeicultor) throws CafeicultorException {
        validacao(cafeicultor);
        return cafeicultorRepository.save(cafeicultor);
    }

    private void validacao(Cafeicultor cafeicultor) throws CafeicultorException {
        Optional<Cafeicultor> cafeicultorOptional = cafeicultorRepository.findByCpf(cafeicultor.getCpf());
        if(cafeicultorOptional.isPresent()){
            throw new CafeicultorException("Cpf já cadastrado");
        }
    }

    public List<Cafeicultor> getCafeicultores() {
        return cafeicultorRepository.findAll();
    }

    public Optional<Cafeicultor> getCafeicultor(String cpf) {
        return cafeicultorRepository.findByCpf(cpf);
    }
}
