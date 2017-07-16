package com.bionime.assignment.nursingstationManager.service;

import java.util.List;

import com.bionime.assignment.nursingstationManager.model.Nurse;
import com.bionime.assignment.nursingstationManager.model.Station;

public interface StationService extends Service<Station> {

	List<Nurse> getNurses(Station station);

}
