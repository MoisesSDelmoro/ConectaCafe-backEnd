package br.com.shortcoffee.service;

import br.com.shortcoffee.entity.Cafe;
import br.com.shortcoffee.entity.SitioFazenda;
import br.com.shortcoffee.exception.CafeException;
import br.com.shortcoffee.exception.SitioFazendaException;
import br.com.shortcoffee.repository.CafeicultorRepository;
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
        Optional<SitioFazenda> sitioFazendaOptional = sitioFazendaRepository.findById(sitioFazenda.getSitioFazendaId());
        if(sitioFazendaOptional.isPresent()){
            throw new SitioFazendaException("Sitio/Fazenda já cadastrada");
        }
    }

    public List<SitioFazenda> getSitioFazendas() {
        return sitioFazendaRepository.findAll();
    }


    public Optional<SitioFazenda> getSitioFazenda(Long sitioFazendaId) {
        return sitioFazendaRepository.findBySitioFazendaId(sitioFazendaId);
    }

    public SitioFazenda getSitioFazendaCafeicultor(int cafeicultor_id) {
        return sitioFazendaRepository.findByCafeicultorId(cafeicultor_id);
    }

    public SitioFazenda editSitioFazenda(long sitioFazendaId, SitioFazenda sitioFazenda) throws SitioFazendaException {
        Optional<SitioFazenda> sitioFazendaOptional = sitioFazendaRepository.findById(sitioFazendaId);
        if(sitioFazendaOptional.isEmpty()){
            throw new SitioFazendaException("Id não encontrado!");
        }
        return sitioFazendaRepository.save(sitioFazenda);
    }

}
