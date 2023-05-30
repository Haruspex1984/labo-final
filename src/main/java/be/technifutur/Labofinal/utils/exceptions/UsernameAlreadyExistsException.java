package be.technifutur.Labofinal.utils.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

import javax.security.sasl.AuthenticationException;

public class UsernameAlreadyExistsException extends DataIntegrityViolationException {
    public UsernameAlreadyExistsException(){
        super("Ce nom d'utilisateur existe déjà");
    }
}
