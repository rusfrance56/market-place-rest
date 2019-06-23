package com.maybetm.mplrest.commons;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Базовый класс для всех сущностей jpa
 *
 * @author: ZebzeevSV
 * @version: 09.06.2019 23:42
 */
@MappedSuperclass
public abstract class AEntity {

	private Long id;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
