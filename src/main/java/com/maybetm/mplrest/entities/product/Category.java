package com.maybetm.mplrest.entities.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maybetm.mplrest.commons.AEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Сущность категорий продуктов
 *
 * @author: ZebzeevSV
 * @version: 19.06.2019 20:46
 */
@Entity(name = "category")
@JsonIgnoreProperties({"product"})
public class Category extends AEntity {

	private String name;

	private Set<Product> product;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	public Set<Product> getProduct() {
		return product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}