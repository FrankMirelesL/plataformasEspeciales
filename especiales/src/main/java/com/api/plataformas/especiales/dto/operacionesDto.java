package com.api.plataformas.especiales.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class operacionesDto {
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Operación solo debe contener letras")
    private String operacion;

    @Pattern(regexp = "^\\d{1,9}(\\.\\d{1,2})?$", message = "Importe debe tener formato de moneda (ej. 100.00)")
    private String importe;

    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Cliente solo debe contener letras")
    @Size(min = 3, max = 50, message = "Cliente debe tener entre 3 y 50 caracteres")
    private String cliente;

    private String secreto;
}