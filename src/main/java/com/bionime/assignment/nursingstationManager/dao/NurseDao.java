package com.bionime.assignment.nursingstationManager.dao;

import java.util.List;

import com.bionime.assignment.nursingstationManager.model.Nurse;

public interface NurseDao {

	public List<Nurse> list();
	
	public void add(Nurse t);

	public void update(Nurse t);

	public Nurse get(int id);

	public void delete(int id);

}
