package com.bionime.assignment.nursingstationManager.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bionime.assignment.nursingstationManager.model.Nurse;
import com.bionime.assignment.nursingstationManager.model.Station;
import com.bionime.assignment.nursingstationManager.service.StationService;

@RequestMapping(value = "/station")
@Controller
public class StationController {

	@Autowired
	StationService stationService;

	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("station/list");
		List<Station> list = stationService.list();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("station/form");
		Station station = new Station();
		modelAndView.addObject("station", station);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("station/form");
		Station station = stationService.get(id);

		List<Nurse> listNurse = stationService.getNurses(station);

		modelAndView.addObject("nurses", listNurse);
		modelAndView.addObject("station", station);
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("station") Station station) {
		if (station.getId() == 0) {
			station.setCreateDate(new Timestamp((new Date()).getTime()));
			stationService.add(station);
		} else
			stationService.update(station);
		return new ModelAndView("redirect:/station/list");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		stationService.delete(id);
		return new ModelAndView("redirect:/station/list");
	}
}
