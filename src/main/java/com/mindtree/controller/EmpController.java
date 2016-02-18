package com.mindtree.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class EmpController {
	@RequestMapping(value="/tables",method = RequestMethod.GET) 

	public ModelAndView navigateToView()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("insert");
		return model;
	}
	@RequestMapping(value="/querythem",method = RequestMethod.GET)
	public ModelAndView navigateToView2()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("retrieve");
		return model;
	}
}
