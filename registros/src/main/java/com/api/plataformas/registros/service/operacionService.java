package com.api.plataformas.registros.service;
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
}
