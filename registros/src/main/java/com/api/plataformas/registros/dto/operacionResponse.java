package com.api.plataformas.registros.dto;

import lombok.Data;

@Data
public class operacionResponse {
    private String id;
    private String estatus;
    private String referencia;
    private String operacion;

    public operacionResponse(String id, String estatus, String referencia, String operacion) {
        this.id = id;
        this.estatus = estatus;
        this.referencia = referencia;
        this.operacion = operacion;
    }
}
