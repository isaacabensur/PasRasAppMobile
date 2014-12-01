package com.tdp.bean;

public class BeanIpr {
	int id_ipr;
	public int getId_ipr() {
		return id_ipr;
	}
	public void setId_ipr(int id_ipr) {
		this.id_ipr = id_ipr;
	}
	public int getNro_ipr() {
		return nro_ipr;
	}
	public void setNro_ipr(int nro_ipr) {
		this.nro_ipr = nro_ipr;
	}
	int nro_ipr;

	
	public BeanIpr(int id_ipr, int nro_ipr){
		this.id_ipr = id_ipr;
		this.nro_ipr = nro_ipr;
		
	}
	
	@Override
	public String toString() {
		return "" + nro_ipr;
	}
	public int getId() {
		return id_ipr;
	}
	
	
	
}
