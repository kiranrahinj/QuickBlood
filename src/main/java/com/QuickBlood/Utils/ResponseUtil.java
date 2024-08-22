package com.QuickBlood.Utils;

import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static GenericResponse getSuccessAPiResponse(String message,String responseCode,String status,Object data){
        return GenericResponse.builder().message(message).responseCode(responseCode).status(status).data(data).build();
    }

    public static GenericResponse getErrorGenericApiResponse(String message,String responseCode){
        return GenericResponse.builder().message(message).responseCode(responseCode).status("error").build();
    }
}
