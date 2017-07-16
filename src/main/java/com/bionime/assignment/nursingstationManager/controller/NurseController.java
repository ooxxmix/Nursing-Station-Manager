package com.bionime.assignment.nursingstationManager.controller;

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

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("nurse/form");
		Nurse nurse = nurseService.get(id);
		modelAndView.addObject("nurseForm", nurse);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("nurse/form");
		Nurse nurse = new Nurse();
		modelAndView.addObject("nurseForm", nurse);
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("nurseForm") Nurse nurse) {
		nurseService.update(nurse);
		return new ModelAndView("redirect:/nurse/list");
	}
}
