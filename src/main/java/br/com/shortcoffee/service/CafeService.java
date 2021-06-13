package br.com.shortcoffee.service;

import br.com.shortcoffee.entity.Cafe;
import br.com.shortcoffee.exception.CafeException;
import br.com.shortcoffee.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    public Cafe save(Cafe cafe) throws CafeException {
        validacao(cafe);
        return cafeRepository.save(cafe);
    }

    private void validacao(Cafe cafe) throws CafeException {
        Optional<Cafe> cafeOptional = cafeRepository.findById(cafe.getCafeId());
        if(cafeOptional.isPresent()){
            throw new CafeException("Id já cadastrado");
        }
    }

    public List<Cafe> getCafes() {
        return cafeRepository.findAll();
    }

    public Optional<Cafe> getCafe(Long cafeId) {
        return cafeRepository.findByCafeId(cafeId);
    }

    public Cafe editCafe(long cafe_id, Cafe cafe) throws CafeException {
        Optional<Cafe> cafeOptional = cafeRepository.findById(cafe_id);
        if(cafeOptional.isEmpty()){
            throw new CafeException("Id não encontrado!");
        }
        return cafeRepository.save(cafe);
    }

    public void deleteCafe(long cafe_id) throws CafeException {
        Optional<Cafe> cafeOptional = cafeRepository.findById(cafe_id);
        if(cafeOptional.isEmpty()){
            throw new CafeException("Id não encontrado!");
        }
        cafeRepository.deleteById(cafe_id);
    }
}
