package com.bionime.assignment.nursingstationManager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.bionime.assignment.nursingstationManager.dao.Dao;

public abstract class ServiceImpl<T> implements Service{

	Dao<T> dao;

	public void setDao(Dao<T> dao) {
		this.dao = dao;
	}

	public List<T> list() {
		return dao.list();
	}

	public void update(T t) {
		dao.update(t);
	}

	public T get(int id) {
		return dao.get(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

}