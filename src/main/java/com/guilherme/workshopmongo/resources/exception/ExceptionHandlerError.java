/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.workshopmongo.resources.exception;

import com.guilherme.workshopmongo.service.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Guilherme
 */
@ControllerAdvice
public class ExceptionHandlerError {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> throwObjectNotFoundException(ObjectNotFoundException ex, HttpServletRequest req) {
        StandartError se = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),"not found",ex.getMessage(),req.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

}
