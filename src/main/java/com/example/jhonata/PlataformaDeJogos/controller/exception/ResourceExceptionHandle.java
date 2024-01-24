package com.example.jhonata.PlataformaDeJogos.controller.exception;

import com.example.jhonata.PlataformaDeJogos.service.exception.JogoDuplicadoException;
import com.example.jhonata.PlataformaDeJogos.service.exception.NegocioExeption;
import com.example.jhonata.PlataformaDeJogos.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static com.example.jhonata.PlataformaDeJogos.service.Util.DateUtils.getCurrentTime;

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation errors", getCurrentTime());
        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), getCurrentTime());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NegocioExeption.class)
    public ResponseEntity<StandardError> negocioExcepition(NegocioExeption e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage(), getCurrentTime());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }

    @ExceptionHandler(JogoDuplicadoException.class)
    public ResponseEntity<StandardError> jogoDuplicadoExcepition(JogoDuplicadoException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(), getCurrentTime());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
