package com.QuickBlood.Exception;

import com.QuickBlood.Utils.ResponseCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class QuickBloodException extends RuntimeException{
    private HttpStatus status;
    private ResponseCode responseCode;

    public QuickBloodException(String message,HttpStatus status,ResponseCode responseCode){
        super(message);
        this.status=status;
        this.responseCode=responseCode;
    }
}
