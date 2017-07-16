package com.bionime.assignment.nursingstationManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bionime.assignment.nursingstationManager.model.Station;
import com.bionime.assignment.nursingstationManager.service.Service;

@RequestMapping(value = "/station")
@Controller
public class StationController {

	@Autowired
	Service<Station> stationService;

	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("station/list");
		List<Station> list = stationService.list();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("station/form");
		Station station = stationService.get(id);
		modelAndView.addObject("stationForm", station);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("station/form");
		Station station = new Station();
		modelAndView.addObject("stationForm", station);
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("stationForm") Station station) {
		stationService.update(station);
		return new ModelAndView("redirect:/station/list");
	}
}
