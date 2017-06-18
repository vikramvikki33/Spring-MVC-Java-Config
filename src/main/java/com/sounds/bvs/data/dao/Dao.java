package com.sounds.bvs.data.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Vikram
 *
 * @param <T>
 * @param <ID>
 */
public interface Dao<T, ID> extends Serializable {

	public List<T> findAll();

	public T findById(ID id);

	public T save(T entity);

	public T update(T entity);

	public T saveOrUpdate(T entity);

	public void delete(ID id);

	public void flush();

	public void clear();
}
