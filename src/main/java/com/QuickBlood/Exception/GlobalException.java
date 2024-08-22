package com.QuickBlood.Exception;

import com.QuickBlood.Utils.GenericResponse;
import com.QuickBlood.Utils.ResponseCode;
import com.QuickBlood.Utils.ResponseUtil;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(QuickBloodException.class)
    public final ResponseEntity<?> customException(QuickBloodException exception) {
        return new ResponseEntity<>(ResponseUtil.getErrorGenericApiResponse(exception.getMessage(), exception.getResponseCode().name()), exception.getStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<?> handleException(MethodArgumentNotValidException exception) {
        String message = Objects.nonNull(exception) && Objects.nonNull(exception.getBindingResult().getFieldError())
                ? exception.getBindingResult().getFieldError().getDefaultMessage() :
                "Bad_Request";
        return new ResponseEntity<>(ResponseUtil.getErrorGenericApiResponse(message, ResponseCode.BAD_REQUEST.name()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidFormatException.class, HttpMessageNotReadableException.class, MissingServletRequestParameterException.class})
    public final ResponseEntity<?> handleException(Exception ex) {
        String message = Objects.nonNull(ex) && Objects.nonNull(ex.getMessage()) ? ex.getMessage() : "Bad_Request";
        return new ResponseEntity<>(ResponseUtil.getErrorGenericApiResponse(message, ResponseCode.BAD_REQUEST.name()), HttpStatus.BAD_REQUEST);
    }
}
