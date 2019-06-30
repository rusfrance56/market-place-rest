package com.maybetm.mplrest.commons.services;

import com.maybetm.mplrest.commons.AEntity;
import com.maybetm.mplrest.commons.repositories.ICommonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * @author: ZebzeevSV
 * @version: 29.06.2019   18:51
 */
public abstract class AService<E extends AEntity, R extends ICommonRepository<E>> implements ICommonService<E> {

	private final R repository;

	public AService(R repository) {
		this.repository = repository;
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<E> save(E entity) {
		return Optional.of(repository.saveAndFlush(entity));
	}

	@Override
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}