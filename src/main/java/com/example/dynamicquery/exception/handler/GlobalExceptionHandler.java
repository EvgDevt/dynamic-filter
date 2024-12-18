package com.example.dynamicquery.exception.handler;

import com.example.dynamicquery.exception.ExchangeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExchangeNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleExchangeNotFoundException(ExchangeNotFoundException e) {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setDetail(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pb);
    }
}
