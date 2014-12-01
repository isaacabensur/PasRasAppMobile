package com.tdp.bean;

public class BeanProyecto {
	int id_proyecto;
	  int nro_proyecto;
	public int getId_proyecto() {
		return id_proyecto;
	}
	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}
	public int getNro_proyecto() {
		return nro_proyecto;
	}
	public void setNro_proyecto(int nro_proyecto) {
		this.nro_proyecto = nro_proyecto;
	}
	
	public BeanProyecto(int id_proyecto, int nro_proyecto){
		this.id_proyecto = id_proyecto;
		this.nro_proyecto = nro_proyecto;		
	}
	
	@Override
	public String toString() {
		return "" + nro_proyecto;
	}
	public int getId() {
		return id_proyecto;
	}
	
	
}
