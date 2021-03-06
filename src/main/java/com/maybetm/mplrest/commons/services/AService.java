package com.maybetm.mplrest.commons.services;

import com.maybetm.mplrest.commons.AEntity;
import com.maybetm.mplrest.commons.repositories.ICommonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.MappedSuperclass;
import java.beans.FeatureDescriptor;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zebzeev-sv
 * @version 29.06.2019 18:51
 */
@MappedSuperclass
public abstract class AService<E extends AEntity, R extends ICommonRepository<E>> implements ICommonService<E>
{

  protected R repository;

  protected AService(R repository)
  {
    this.repository = repository;
  }

  @Override
  public Page<E> getEntityOnPage(Pageable pageable)
  {
    return repository.findAll(pageable);
  }

  @Override
  public Optional<E> save(E entity)
  {
    return Optional.of(repository.save(entity));
  }

  @Override
  public Optional<E> findById(Long id)
  {
    return repository.findById(id);
  }

  @Override
  public void deleteById(Long id)
  {
    repository.deleteById(id);
  }

  @Override
  public Optional<E> updateEntity (E fromDB, E updatable)
  {
    BeanUtils.copyProperties(updatable, fromDB, getNullPropertyNames(updatable));
    return save(fromDB);
  }

  /**
   * Получаем список полей, значение которых равняется null.
   * Используется для слияния двух сущностей и последующего сохранения
   *
   * @param source - Объект, значение полей которого надо смерджить с объектом из бд.
   * @return - массив полей равных null
   */
  private static String[] getNullPropertyNames (Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source);
    return Stream.of(src.getPropertyDescriptors())
        .map(FeatureDescriptor::getName)
        .filter(propertyName -> src.getPropertyValue(propertyName) == null)
        .toArray(String[]::new);
  }

}
