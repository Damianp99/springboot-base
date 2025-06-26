package com.crud.springboot_base.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BaseService<DTO, ID> {
    Page<DTO> findAll(Pageable pageable);
    Optional<DTO> findById(ID id);
    DTO save(DTO dto);
    DTO update(ID id, DTO dto);
    void deleteById(ID id);
}
