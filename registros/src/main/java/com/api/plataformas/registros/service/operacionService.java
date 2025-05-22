package com.api.plataformas.registros.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.plataformas.registros.dto.operacionesDto;
import com.api.plataformas.registros.repository.operacionRepository;

@Service
public class operacionService {

    @Autowired
    private operacionRepository operacionRepository;
    private Random random = new Random();

    public operacionesDto procesarOperacion(operacionesDto operacion) {
        String referencia = String.format("%06d", random.nextInt(999999));
        operacion.setReferencia(referencia);
        operacion.setEstatus("Aprobada");
        return operacionRepository.save(operacion);
    }

     public operacionesDto  patchOperacion( operacionesDto body) {
        Optional<operacionesDto> optionalOperacion = operacionRepository.findById(body.getId());

        if (optionalOperacion.isEmpty()) {
            throw new RuntimeException("Operación no encontrada con ID: " + body.getId());
        }

        operacionesDto operacion = optionalOperacion.get();
        String nuevoEstatus = body.getEstatus();
        operacion.setEstatus(nuevoEstatus);

        return operacionRepository.save(operacion);
    }
}
