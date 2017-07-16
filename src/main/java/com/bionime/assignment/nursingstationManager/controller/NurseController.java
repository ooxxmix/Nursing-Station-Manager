package com.bionime.assignment.nursingstationManager.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bionime.assignment.nursingstationManager.model.Nurse;
import com.bionime.assignment.nursingstationManager.model.Station;
import com.bionime.assignment.nursingstationManager.service.NurseService;
import com.bionime.assignment.nursingstationManager.service.StationService;

@RequestMapping(value = "/nurse")
@Controller
public class NurseController {

	@Autowired
	NurseService nurseService;

	@Autowired
	StationService stationService;

	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("nurse/list");
		List<Nurse> list = nurseService.list();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("nurse/form");
		Nurse nurse = new Nurse();
		modelAndView.addObject("list_not_active", stationService.list());
		modelAndView.addObject("nurse", nurse);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("nurse/form");
		Nurse nurse = nurseService.get(id);

		List<Station> all_station_list = stationService.list();
		List<Station> group_station_list = nurseService.getStations(nurse);

		for (Iterator<Station> all_station_iterator = all_station_list.iterator(); all_station_iterator.hasNext();) {
			Station all_station = all_station_iterator.next();
			for (Iterator<Station> group_station_iterator = group_station_list.iterator(); group_station_iterator
					.hasNext();) {
				Station group_station = group_station_iterator.next();
				if (all_station.getId() == group_station.getId()) {
					all_station_iterator.remove();
				}
			}
		}

		modelAndView.addObject("list_not_active", all_station_list);
		modelAndView.addObject("list_active", group_station_list);
		modelAndView.addObject("nurse", nurse);

		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Nurse nurse, HttpServletRequest request) {
		if (!"".equals(nurse.getName())) {
			Timestamp time = new Timestamp((new Date()).getTime());
			String set_station = request.getParameter("set_station");
			String[] stations = set_station.split(",");
			if (nurse.getId() == 0) {
				nurse.setCreateDate(time);
				nurseService.add(nurse);
			} else {
				nurseService.update(nurse);
			}
			if (nurse.getId() != 0) {
				System.out.println("nurse.getId() != 0");
				System.out.println(nurse.getId());
				nurseService.setStations(nurse, stations);
			}
		}
		return new ModelAndView("redirect:/nurse/list");
	}

	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	// public ModelAndView save(@ModelAttribute Nurse nurse, HttpServletRequest
	// request) {
	// String set_station = request.getParameter("set_station");
	// String[] stationStr = set_station.split(",");
	//
	// if (nurse.getId() == 0) {
	// nurse.setCreateDate(new Timestamp((new Date()).getTime()));
	// nurseService.add(nurse);
	// } else
	// nurseService.update(nurse);
	// return new ModelAndView("redirect:/nurse/list");
	// }

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		nurseService.delete(id);
		return new ModelAndView("redirect:/nurse/list");
	}
}
