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
import com.bionime.assignment.nursingstationManager.service.Service;

@RequestMapping(value = "/nurse")
@Controller
public class NurseController {

	@Autowired
	Service<Nurse> nurseService;

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
		modelAndView.addObject("nurse", nurse);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("nurse/form");
		Nurse nurse = nurseService.get(id);
		modelAndView.addObject("nurse", nurse);
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("nurse") Nurse nurse) {
		if (nurse.getId() == 0) {
			nurse.setCreateDate(new Timestamp((new Date()).getTime()));
			nurseService.add(nurse);
		} else
			nurseService.update(nurse);
		return new ModelAndView("redirect:/nurse/list");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		nurseService.delete(id);
		return new ModelAndView("redirect:/nurse/list");
	}
}
