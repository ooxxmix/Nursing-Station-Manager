package com.bionime.assignment.nursingstationManager.dao;

import java.util.List;

import com.bionime.assignment.nursingstationManager.model.Station;

public interface StationDao {

	public List<Station> list();
	
	public void add(Station t);

	public void update(Station t);

	public Station get(int id);

	public void delete(int id);

}
