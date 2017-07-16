package com.bionime.assignment.nursingstationManager.dao;

import java.util.List;

public interface Dao<T> {

	public List<T> list();

	public void add(T t);

	public void update(T t);

	public T get(int id);

	public void delete(int id);

}
