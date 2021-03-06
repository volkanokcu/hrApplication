package com.hr.service;

import java.util.List;

import com.hr.entity.GenericEntity;


public interface GenericService <E extends GenericEntity>{
	
	public abstract void save(E entity);

	public abstract void update(E entity);

	public abstract void delete(E entity);

	public abstract List<E> findAll();
	
	public abstract List<E> findAll(List<Integer> ids);

	public abstract E findById(Integer id);

}
