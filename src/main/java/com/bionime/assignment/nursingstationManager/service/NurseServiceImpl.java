package com.bionime.assignment.nursingstationManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bionime.assignment.nursingstationManager.dao.NurseDao;
import com.bionime.assignment.nursingstationManager.model.Nurse;

@Service("nurseService")
@Transactional
public class NurseServiceImpl implements com.bionime.assignment.nursingstationManager.service.Service<Nurse> {

	@Autowired
	private NurseDao dao;

	public void setDao(NurseDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Nurse> list() {
		return dao.list();
	}

	@Override
	public void add(Nurse t) {
		dao.add(t);
	}
	
	@Override
	public void update(Nurse t) {
		dao.update(t);
	}

	@Override
	public Nurse get(int id) {
		return dao.get(id);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}
}
