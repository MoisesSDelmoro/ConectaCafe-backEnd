package br.com.shortcoffee.resource;

import br.com.shortcoffee.entity.SitioFazenda;
import br.com.shortcoffee.exception.SitioFazendaException;
import br.com.shortcoffee.service.SitioFazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController("API para cadastro de Sitio ou Fazenda")
@RequestMapping("/api/coffee/sitioFazenda")
public class SitioFazendaResource {

    @Autowired
    private SitioFazendaService sitioFazendaService;

    @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity criandoSitioFazenda(@RequestBody SitioFazenda sitioFazenda) throws SitioFazendaException {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sitioFazendaService.save(sitioFazenda).getSitioFazendaId()).toUri();
        return ResponseEntity.created(location).build();
//        return ResponseEntity.ok(sitioFazendaService.save(sitioFazenda));
    }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<SitioFazenda>> getSitioFazendas(){
        return ResponseEntity.ok(sitioFazendaService.getSitioFazendas());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Optional<SitioFazenda>> getSitioFazenda(@PathVariable("id") Long sitioFazendaId) {
        return ResponseEntity.ok(sitioFazendaService.getSitioFazenda(sitioFazendaId));
    }

    @GetMapping(value = "/cafeicultor/{cafeicultor_id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SitioFazenda> getSitioFazendaCafeicultor(@PathVariable("cafeicultor_id") int cafeicultor_id) {
        return ResponseEntity.ok(sitioFazendaService.getSitioFazendaCafeicultor(cafeicultor_id));
    }
}
