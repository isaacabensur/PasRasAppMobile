package com.tdp.controlador;

import java.util.ArrayList;

import com.tdp.bean.BeanIpr;
import com.tdp.bean.BeanOrigen;
import com.tdp.bean.BeanProyecto;
import com.tdp.bean.BeanTipoActividad;
//import com.google.gson.Gson;
//import com.example.bean.DateTimeBean;
import com.tdp.bean.BeanUsuario;





public class MainController {

	public static MainController instance = null;
	//public DateTimeBean currDateTimeBean = null;
	public ArrayList<BeanUsuario> lstUsuario;
	public ArrayList<BeanProyecto> lstProyecto;
	public ArrayList<BeanOrigen> lstOrigen;
	public ArrayList<BeanIpr> lstIpr;
	public ArrayList<BeanTipoActividad> lstTipoActividad;
	
	public static MainController getInstance() {
		if (instance == null) {
			instance = new MainController();
		}
		return instance;
	}

	
	public MainController() {
		lstUsuario = new ArrayList<BeanUsuario>();
		lstProyecto = new ArrayList<BeanProyecto>();
		lstOrigen = new ArrayList<BeanOrigen>();
		lstIpr = new ArrayList<BeanIpr>();
		lstTipoActividad = new ArrayList<BeanTipoActividad>();

		BeanUsuario bean;
		BeanProyecto oProyecto;
		 BeanOrigen oOrigen;
		BeanIpr oIpr;
		BeanTipoActividad oTipoActividad;
		
		
		String imagen = "http://www.hum.unrc.edu.ar/imgs/digesto.png";
		String imagen2 = "http://www.jblog.fr/images/modules/annuaire_.png";
		
		bean = new BeanUsuario(1,"ISAAC");
		lstUsuario.add(bean);
		bean = new BeanUsuario(2,"JAIME");
		lstUsuario.add(bean);
		bean = new BeanUsuario(3,"MAX");
		lstUsuario.add(bean);
		bean = new BeanUsuario(4,"JUAN");
		lstUsuario.add(bean);

		oProyecto = new BeanProyecto(1, 45);
		lstProyecto.add(oProyecto);
		oProyecto = new BeanProyecto(2, 46);
		lstProyecto.add(oProyecto);
		
		oOrigen = new BeanOrigen(1, "Origen 01");
		lstOrigen.add(oOrigen);
		oOrigen = new BeanOrigen(2, "origen 02");
		lstOrigen.add(oOrigen);
		
		oIpr = new BeanIpr(1, 999);
		lstIpr.add(oIpr);
		oIpr = new BeanIpr(2, 998);
		lstIpr.add(oIpr);
		
		oTipoActividad = new BeanTipoActividad(1, "Proyecto");
		lstTipoActividad.add(oTipoActividad);
		oTipoActividad = new BeanTipoActividad(2, "Incidencia");
		lstTipoActividad.add(oTipoActividad);
	
	}
	/*
	public String obtenerDatos(){
		currDateTimeBean = null;
		
		Gson gs = new Gson();
		//String json = gs.toJson(bean);
		String json = "";
		
		String response = HTTPControl.getJson("http://date.jsontest.com", json);
		DateTimeBean responseBean = gs.fromJson(response, DateTimeBean.class);
		
		if (responseBean ==null){
			return "Error de conexion";
		}else{
			currDateTimeBean = responseBean;
		}
		return "";
	}
	*/	
}
