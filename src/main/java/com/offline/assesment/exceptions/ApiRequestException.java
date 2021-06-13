package com.offline.assesment.exceptions;

/** @author <a href  swati.gbpant@gmail.com</>**/
public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message){
        super (message);
    }

    public ApiRequestException(String message, Throwable cause){
        super(message, cause);
    }
}
