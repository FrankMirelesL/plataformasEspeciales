package com.api.plataformas.registros.controller;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.plataformas.registros.dto.operacionResponse;
import com.api.plataformas.registros.dto.operacionesDto;
import com.api.plataformas.registros.service.operacionService;

@RestController
@RequestMapping("/api/operaciones")
public class operacionController {

    @Autowired
    private operacionService operacionService;

    @PostMapping
    public operacionResponse recibirOperacion(@RequestBody operacionesDto operacion) {
        operacionesDto guardada = operacionService.procesarOperacion(operacion);
        return new operacionResponse(
            guardada.getId().toString(),
            guardada.getEstatus(),
            guardada.getReferencia(),
            guardada.getOperacion()
        );
    }

    @PatchMapping("/estatus")
    public ResponseEntity<operacionesDto> actualizarEstatus( @RequestBody operacionesDto body) {
        operacionesDto optional = operacionService.patchOperacion(body);
        return ResponseEntity.ok(optional);
    }
}
