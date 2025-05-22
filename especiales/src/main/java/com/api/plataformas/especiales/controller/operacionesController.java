package  com.api.plataformas.especiales.controller;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.api.plataformas.especiales.dto.operacionResponse;
import com.api.plataformas.especiales.dto.operacionesDto;
import com.api.plataformas.especiales.utils.aesUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/operaciones")
public class operacionesController {
    
     @PostMapping("/procesar")
    public ResponseEntity<operacionResponse> procesarOperacion(@Valid @RequestBody operacionesDto operacion) {
        operacionResponse response;
        try {
            String secretoDescifrado = aesUtil.decrypt(operacion.getSecreto());
            operacion.setSecreto(secretoDescifrado);
            RestTemplate restTemplate = new RestTemplate();
             response = restTemplate.postForObject(
                "http://localhost:8081/api/operaciones",
                operacion,
                operacionResponse.class
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new operacionResponse("Error al descifrar el secreto: " + e.getMessage(),null,null,null));
        }
    }
}
