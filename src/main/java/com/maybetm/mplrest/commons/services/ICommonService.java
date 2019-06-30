package com.maybetm.mplrest.commons.services;

import com.maybetm.mplrest.commons.AEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author: ZebzeevSV
 * @version: 29.06.2019 18:37
 */
public interface ICommonService<E extends AEntity> {

	/**
	 * Возвращает все записи с учётом пагинации
	 *
	 * @param pageable параметры пагинации.
	 * @return возвращает список найденных объектов, сокрытых в объекте списке content.
	 */
	public Page<E> findAll(Pageable pageable);

	/**
	 * В идеале должен возвщращать ту сущность, которую сохранил
	 *
	 * @param entity сохраняемоя сущность.
	 * @return возвращает E унаследованный от AEntity.
	 */
	public Optional<E> save(E entity);

	/**
	 * Возвращает детальную информацию сущности
	 *
	 * @param id уникальный идентификатор объекта в бд.
	 * @return возвращает E унаследованный от AEntity.
	 */
	public Optional<E> findById(Long id);

	/**
	 * Удаляет объект из бд
	 *
	 * @param id параметры пагинации.
	 */
	public void deleteById(Long id);
}