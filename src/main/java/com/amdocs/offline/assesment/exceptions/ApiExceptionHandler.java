package com.amdocs.offline.assesment.exceptions;


import com.amdocs.offline.assesment.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/** @author <a href  swati.gbpant@gmail.com</>**/

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        ErrorMessage errorMessage= new ErrorMessage(e.getMessage(),/*e,*/ HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyRequestException(Exception e, WebRequest webRequest){
        String errorMsg = e.getLocalizedMessage();
        ErrorMessage errorMessage = new ErrorMessage(errorMsg,HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
    }
}
