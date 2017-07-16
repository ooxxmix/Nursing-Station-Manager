package com.bionime.assignment.nursingstationManager.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bionime.assignment.nursingstationManager.dao.StationDao;
import com.bionime.assignment.nursingstationManager.model.Nurse;
import com.bionime.assignment.nursingstationManager.model.Station;

@Service("stationService")
@Transactional
public class StationServiceImpl implements StationService {

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

	@Override
	public List<Nurse> getNurses(Station station) {
		List<Nurse> GroupNurse = new ArrayList<Nurse>();
		Iterator<Nurse> iterator = station.getNurses().iterator();
		while (iterator.hasNext()) {
			GroupNurse.add(iterator.next());
		}
		return GroupNurse;
	}

}
