package com.offline.assesment.entity;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/** @author <a href  swati.gbpant@gmail.com</>**/

public class ErrorMessage {
    private final String message;
   // private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;




    public ErrorMessage(String message, /*Throwable throwable,*/ HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.timestamp=timestamp;
       // this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.message=message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /*public Throwable getThrowable() {
        return throwable;
    }*/
}
