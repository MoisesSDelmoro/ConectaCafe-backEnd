package br.com.shortcoffee.resource;

import br.com.shortcoffee.entity.Cafeicultor;
import br.com.shortcoffee.entity.Login;
import br.com.shortcoffee.exception.LoginException;
import br.com.shortcoffee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController("API para cadastro de login")
@RequestMapping("/api/coffee/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity criandoLogin(@RequestBody Login login) throws LoginException {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(loginService.save(login).getLoginId()).toUri();
        return ResponseEntity.created(location).build();
 }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Login>> getlogins(){
        return ResponseEntity.ok(loginService.getLogins());
    }


    @GetMapping(value = "email/{email}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Optional<Login>> getLoginEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(loginService.getLoginEmail(email));
    }

}

