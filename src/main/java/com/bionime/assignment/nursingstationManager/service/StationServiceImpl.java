package com.bionime.assignment.nursingstationManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bionime.assignment.nursingstationManager.dao.StationDao;
import com.bionime.assignment.nursingstationManager.model.Station;

@Service("stationService")
@Transactional
public class StationServiceImpl implements com.bionime.assignment.nursingstationManager.service.Service<Station> {

	@Autowired
	private StationDao dao;

	public void setDao(StationDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Station> list() {
		return dao.list();
	}
	
	@Override
	public void add(Station t) {
		dao.add(t);
	}

	@Override
	public void update(Station t) {
		dao.update(t);
	}

	@Override
	public Station get(int id) {
		return dao.get(id);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}
}
