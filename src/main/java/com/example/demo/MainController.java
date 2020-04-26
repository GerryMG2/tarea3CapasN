package com.example.demo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@GetMapping("/ingresar")
	public String getForm(alumno alumno) {
		return "ingresar";
	}
	
	@PostMapping("/ingresar")
	public ModelAndView PostForm(alumno al) {
		System.out.println(al.getFechaNacimiento().toLocaleString());
		
		ModelAndView mav = new ModelAndView();
		
		if(al.validate()) {
			mav.setViewName("correcto");	
		}else {
			mav.setViewName("ingresar");	
			mav.addObject("msg", al.getMessageError());
		}
		return mav;
	}
	
}
