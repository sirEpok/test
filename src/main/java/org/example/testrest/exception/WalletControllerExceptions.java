package org.example.testrest.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class WalletControllerExceptions extends ResponseEntityExceptionHandler {
    @ExceptionHandler({TrueRuntimeException.class})
    public ResponseEntity<Object> handleInternal(final TrueRuntimeException ex, final WebRequest request) {
        log.error("handle exception", ex);
        var bodyOfResponse = ErrorDescription.builder()
                .head("Не найдено значение")
                .text("Что то пошло не так: " + ex.getMessage())
                .build();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.NOT_FOUND);
    }
}
