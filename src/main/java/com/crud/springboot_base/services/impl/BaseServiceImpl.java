package com.crud.springboot_base.services.impl;

import com.crud.springboot_base.services.BaseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Slf4j
public abstract class BaseServiceImpl<T, DTO, ID> implements BaseService<DTO, ID> {

    protected final JpaRepository<T, ID> repository;
    protected final ModelMapper mapper;
    private final Class<T> entityClass;
    private final Class<DTO> dtoClass;

    protected BaseServiceImpl(JpaRepository<T, ID> repository,
                              ModelMapper mapper,
                              Class<T> entityClass,
                              Class<DTO> dtoClass) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public Page<DTO> findAll(Pageable pageable) {
        log.info("Fetching page of {}", entityClass.getSimpleName());
        return repository.findAll(pageable).map(e -> mapper.map(e, dtoClass));
    }

    @Override
    public Optional<DTO> findById(ID id) {
        return repository.findById(id).map(e -> mapper.map(e, dtoClass));
    }

    @Override
    public DTO save(DTO dto) {
        T entity = mapper.map(dto, entityClass);
        return mapper.map(repository.save(entity), dtoClass);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("ID not found: " + id);
        }
        T entity = mapper.map(dto, entityClass);
        return mapper.map(repository.save(entity), dtoClass);
    }

    @Override
    public void deleteById(ID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("ID not found: " + id);
        }
        repository.deleteById(id);
    }
}
