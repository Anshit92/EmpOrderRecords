package com.mindtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@RequestMapping("/tables")
	public ModelAndView navigateToView()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("insert");
		return model;
	}
	@RequestMapping("/querythem")
	public ModelAndView navigateToView2()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("retrieve");
		return model;
	}
}
