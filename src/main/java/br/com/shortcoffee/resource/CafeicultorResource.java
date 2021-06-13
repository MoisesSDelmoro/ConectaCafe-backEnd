package br.com.shortcoffee.resource;

import br.com.shortcoffee.entity.Cafeicultor;
import br.com.shortcoffee.exception.CafeicultorException;
import br.com.shortcoffee.service.CafeicultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController("API para cadastro de cafeicultor")
@RequestMapping("/api/coffee/cafeicultor")
public class CafeicultorResource {

    @Autowired
    private CafeicultorService cafeicultorService;

    @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity criandoCafeicultor(@RequestBody Cafeicultor cafeicultor) throws CafeicultorException {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cafeicultorService.save(cafeicultor).getCafeicultorId()).toUri();
        return ResponseEntity.created(location).build();
//        return ResponseEntity.ok(cafeicultorService.save(cafeicultor));
    }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Cafeicultor>> getCafeicultores(){
        return ResponseEntity.ok(cafeicultorService.getCafeicultores());
    }

    @GetMapping(value = "/cpf/{cpf}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Optional<Cafeicultor>> getCafeicultor(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok(cafeicultorService.getCafeicultor(cpf));
    }

    @GetMapping(value = "email/{email}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Optional<Cafeicultor>> getCafeicultorEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(cafeicultorService.getCafeicultorEmail(email));
    }

}
