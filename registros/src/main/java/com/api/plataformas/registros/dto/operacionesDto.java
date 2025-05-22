package  com.api.plataformas.registros.dto;
import jakarta.persistence.*;

import java.util.UUID;

import lombok.Data;

@Entity
@Data
public class operacionesDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operacion;
    private String importe;
    private String cliente;
    private String referencia;
    private String estatus;
    private String secreto;

}
