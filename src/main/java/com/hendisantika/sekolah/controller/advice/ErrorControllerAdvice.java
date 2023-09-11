package com.hendisantika.sekolah.controller.advice;

import com.hendisantika.sekolah.dto.WebResponse;
import com.hendisantika.sekolah.exception.KategoriNotFoundException;
import com.hendisantika.sekolah.exception.MyAccessDeniedHandler;
import com.hendisantika.sekolah.exception.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(KategoriNotFoundException.class)
    public ResponseEntity<WebResponse<String>> kategoriNotFoundException(KategoriNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(WebResponse
                        .<String>builder()
                        .build()
                );
    }

    @ExceptionHandler(MyAccessDeniedHandler.class)
    public ResponseEntity<WebResponse<String>> myAccessDeniedHandler(MyAccessDeniedHandler e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(WebResponse
                        .<String>builder()
                        .build()
                );
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<WebResponse<String>> usernameNotFoundException(UsernameNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(WebResponse
                        .<String>builder()
                        .build()
                );
    }
}
