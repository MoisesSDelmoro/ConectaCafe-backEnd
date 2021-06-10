package br.com.shortcoffee.resource;

import br.com.shortcoffee.entity.Cafe;
import br.com.shortcoffee.exception.CafeException;
import br.com.shortcoffee.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController("API para cadastro do tipo de cafe")
@RequestMapping("/api/coffee/cafe")
public class CafeResource {

    @Autowired
    private CafeService cafeService;

    @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity criandoCafe(@RequestBody Cafe cafe) throws CafeException {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cafeService.save(cafe).getCafeId()).toUri();
        return ResponseEntity.created(location).build();
//        return ResponseEntity.ok(cafeService.save(cafe));
    }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Cafe>> getCafes(){
        return ResponseEntity.ok(cafeService.getCafes());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Optional<Cafe>> getCafe(@PathVariable("id") Long cafeId){
        return ResponseEntity.ok(cafeService.getCafe(cafeId));
    }

}
