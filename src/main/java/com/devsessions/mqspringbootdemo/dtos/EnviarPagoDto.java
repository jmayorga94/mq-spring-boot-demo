package com.devsessions.mqspringbootdemo.dtos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Value
public class EnviarPagoDto {

    private String tipoTransaccion;
    private String numeroCuenta;
    private Long   valor;
    private String identificador;

    public String toString(){
        String serialized ="";
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            serialized = objectMapper.writeValueAsString(this);
        }catch(JsonProcessingException jpe){
            jpe.printStackTrace();
        }
        return serialized;
    }
}
