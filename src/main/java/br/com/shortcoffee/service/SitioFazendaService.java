package br.com.shortcoffee.service;

import br.com.shortcoffee.entity.SitioFazenda;
import br.com.shortcoffee.exception.SitioFazendaException;
import br.com.shortcoffee.repository.SitioFazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SitioFazendaService {

    @Autowired
    private SitioFazendaRepository sitioFazendaRepository;

    public SitioFazenda save(SitioFazenda sitioFazenda) throws SitioFazendaException {
        validacao(sitioFazenda);
        return sitioFazendaRepository.save(sitioFazenda);
    }

    private void validacao(SitioFazenda sitioFazenda) throws SitioFazendaException {
        Optional<SitioFazenda> sitioFazendaOptional = sitioFazendaRepository.findById(sitioFazenda.getId());
        if(sitioFazendaOptional.isPresent()){
            throw new SitioFazendaException("Sitio/Fazenda já cadastrada");
        }
    }

    public List<SitioFazenda> getSitioFazendas() {
        return sitioFazendaRepository.findAll();
    }


    public Optional<SitioFazenda> getSitioFazenda(String id) {
        return sitioFazendaRepository.findById(id);
    }

}
