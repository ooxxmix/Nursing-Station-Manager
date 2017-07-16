package com.bionime.assignment.nursingstationManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bionime.assignment.nursingstationManager.dao.Dao;
import com.bionime.assignment.nursingstationManager.model.Nurse;

@Service("nurseService")
@Transactional
public class NurseServiceImpl implements com.bionime.assignment.nursingstationManager.service.Service<Nurse> {

	@Autowired
	private Dao<Nurse> dao;

	public void setDao(Dao<Nurse> dao) {
		this.dao = dao;
	}

	public List<Nurse> list() {
		return dao.list();
	}

	public void update(Nurse t) {
		dao.update(t);
	}

	public Nurse get(int id) {
		return dao.get(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}
}
