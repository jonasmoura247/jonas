package adsisaep;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class,})
    public ResponseEntity<Void> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ErvaJaRegistradaException.class)
    public ResponseEntity<Void> handleConflict() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(IdsNaoEncontradosException.class)
    public ResponseEntity<Void> handleBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    
}
