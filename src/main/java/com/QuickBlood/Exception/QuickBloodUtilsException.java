package com.QuickBlood.Exception;


import com.QuickBlood.Utils.ResponseCode;
import org.springframework.http.HttpStatus;

public final class QuickBloodUtilsException {

    public static void propogateBadRequestExcetpion(String message, ResponseCode responseCode)throws QuickBloodException{
        throw new QuickBloodException(message, HttpStatus.BAD_REQUEST,responseCode);
    }
}
