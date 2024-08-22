package com.QuickBlood.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericResponse {
    private String message;
    private String responseCode;
    private String status;
    private Object data;

    public GenericResponse(String message,String responseCode){
        this.message=message;
        this.responseCode=responseCode;
    }

}
