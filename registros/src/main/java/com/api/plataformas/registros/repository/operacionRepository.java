package com.api.plataformas.registros.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.plataformas.registros.dto.operacionesDto;

public interface operacionRepository extends JpaRepository<operacionesDto, Long> {
}
