package com.example.demo;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	public ArrayList<alumno> listaAlumno = new ArrayList<alumno>(); 
	
	@GetMapping("/ingresar")
	public String getForm(alumno alumno) {
		return "ingresar";
	}
	
	
	@GetMapping("/lista")
	public ModelAndView listaAl() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("lista");
		for (alumno alumno : listaAlumno) {
			System.out.println(alumno.getNombres());
		}
		mav.addObject("studentlist", this.listaAlumno);
		
		
		return mav;
	}
	
	@PostMapping("/ingresar")
	public ModelAndView PostForm(alumno al) {
		System.out.println(al.getFechaNacimiento().toLocaleString());
		
		ModelAndView mav = new ModelAndView();
		
		if(al.validate()) {
			
			mav.setViewName("correcto");
			this.listaAlumno.add(al);
			
		}else {
			mav.setViewName("ingresar");	
			mav.addObject("msg", al.getMessageError());
		}
		return mav;
	}
	
}
