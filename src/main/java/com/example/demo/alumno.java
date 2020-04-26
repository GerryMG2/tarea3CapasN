package com.example.demo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class alumno {
	private String nombres;
	private String apellidos;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	private String lugarNacimiento;
	
	private String colegio;
	@NumberFormat
	private Integer telfijo;
	@NumberFormat
	private Integer telmovil;
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	public String getColegio() {
		return colegio;
	}
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
	public Integer getTelfijo() {
		return telfijo;
	}
	public void setTelfijo(Integer telfijo) {
		this.telfijo = telfijo;
	}
	public Integer getTelmovil() {
		return telmovil;
	}
	public void setTelmovil(Integer telmovil) {
		this.telmovil = telmovil;
	}
	
	public boolean validate() {
		boolean is_validated = true;
		
		if(!(this.getApellidos().length() >= 1 && this.getApellidos().length() <= 25)) {
			is_validated = false;
		}
		if(!(this.getNombres().length() >= 1 && this.getNombres().length() <= 25)) {
			is_validated = false;
		}
		if(!(this.getFechaNacimiento().after((new Date("2003/01/01"))))) {
			is_validated = false;
		}
		if(!(this.getLugarNacimiento().length() >= 1 && this.getLugarNacimiento().length() <= 25)) {
			is_validated = false;
		}
		if(!(this.getColegio().length() >= 1 && this.getColegio().length() <= 100)) {
			is_validated = false;
		}
		if(!(this.getTelfijo().toString().length() == 8)) {
			is_validated = false;
		}
		
		if(!(this.getTelmovil().toString().length() == 8)) {
			is_validated = false;
		}
		
		
		return is_validated;
	}
	
	public String getMessageError() {
		
		
		if(!(this.getApellidos().length() >= 1 && this.getApellidos().length() <= 25)) {
			return "Los apellidos no pueden tener menos de un caracter, o mas de 25.";
		}
		if(!(this.getNombres().length() >= 1 && this.getNombres().length() <= 25)) {
			return "Los nombres no puede tener menos de un caracter, o mas de 25. ";
		}
		if(!(this.getFechaNacimiento().after((new Date("2003/01/01"))))) {
			return "La fecha tiene que ser mayor al 1 de enero de 2003";
		}
		if(!(this.getLugarNacimiento().length() >= 1 && this.getLugarNacimiento().length() <= 25)) {
			return "El lugar de nacimiento debe tener al menos un caracter, y no ser mayor a 25.";
		}
		if(!(this.getColegio().length() >= 1 && this.getColegio().length() <= 100)) {
			return "el colegio no puede tener menos de un caracter, ni mas de 100";
		}
		if(!(this.getTelfijo().toString().length() == 8)) {
			return "El numero fijo debe tener exactamente 8 caracteres";
		}
		
		if(!(this.getTelmovil().toString().length() == 8)) {
			return "El numero movil debe tener exactamente 8 numeros";
		}
		
		
		return "";
	}
	

}
