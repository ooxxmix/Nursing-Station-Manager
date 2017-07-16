package com.bionime.assignment.nursingstationManager.service;

import java.util.List;

import com.bionime.assignment.nursingstationManager.model.Nurse;
import com.bionime.assignment.nursingstationManager.model.Station;

public interface NurseService extends Service<Nurse> {

	public List<Station> getStations(Nurse nurse);

	public void setStations(Nurse nurse, String[] stations);

}
