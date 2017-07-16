package com.bionime.assignment.nursingstationManager.service;

import java.util.List;

public interface Service<T> {

	public List<T> list();

	public void add(T t);
	
	public void update(T t);

	public T get(int id);
	
	public void delete(int id);

}
