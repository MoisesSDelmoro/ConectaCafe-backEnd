package br.com.shortcoffee.service;

import br.com.shortcoffee.entity.Login;
import br.com.shortcoffee.exception.LoginException;
import br.com.shortcoffee.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login save(Login login) throws LoginException {
        validacaoEmail(login);
        return loginRepository.save(login);
    }

    private void validacaoEmail(Login login) throws LoginException {
        Optional<Login> loginOptional =loginRepository.findByEmail(login.getEmail());
        if(loginOptional.isPresent()){
            throw new LoginException("Email já cadastrado");
        }
    }

    public List<Login> getLogins() {
        return loginRepository.findAll();
    }

    public Optional<Login> getLoginEmail(String email) {
        return loginRepository.findByEmail(email);
    }
}
