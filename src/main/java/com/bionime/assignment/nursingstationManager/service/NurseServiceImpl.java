package com.bionime.assignment.nursingstationManager.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bionime.assignment.nursingstationManager.dao.NurseDao;
import com.bionime.assignment.nursingstationManager.dao.StationDao;
import com.bionime.assignment.nursingstationManager.model.Nurse;
import com.bionime.assignment.nursingstationManager.model.Station;

@Service("nurseService")
@Transactional
public class NurseServiceImpl implements NurseService {

	@Autowired
	private NurseDao nDao;

	@Autowired
	private StationDao sDao;

	@Override
	public List<Nurse> list() {
		return nDao.list();
	}

	@Override
	public void add(Nurse t) {
		nDao.add(t);
	}

	@Override
	public void update(Nurse t) {
		nDao.update(t);
	}

	@Override
	public Nurse get(int id) {
		return nDao.get(id);
	}

	@Override
	public void delete(int id) {
		nDao.delete(id);
	}

	@Override
	public List<Station> getStations(Nurse nurse) {
		List<Station> GroupStaion = new ArrayList<Station>();
		Iterator<Station> iterator = nurse.getStations().iterator();
		while (iterator.hasNext()) {
			GroupStaion.add(iterator.next());
		}
		return GroupStaion;
	}

	@Override
	public void setStations(Nurse nurse, String[] stations) {
		nurse.getStations().clear();
		for (String station_id_str : stations) {
			if (station_id_str != null && !"".equals(station_id_str)) {
				int station_id = Integer.parseInt(station_id_str);
				nurse.addStation(sDao.get(station_id));
			}
		}
	}
}
