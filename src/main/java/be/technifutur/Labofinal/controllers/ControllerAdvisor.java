package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.utils.exceptions.InvalidCredentialsException;
import be.technifutur.Labofinal.utils.exceptions.InvalidUsernameException;
import be.technifutur.Labofinal.utils.exceptions.UsernameAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({InvalidUsernameException.class})
    public ResponseEntity<?> handleInvalidUsername(InvalidUsernameException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler({InvalidCredentialsException.class})
    public ResponseEntity<?> handleInvalidCredentials(InvalidCredentialsException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }

    @ExceptionHandler({UsernameAlreadyExistsException.class})
    public ResponseEntity<?> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }



}
