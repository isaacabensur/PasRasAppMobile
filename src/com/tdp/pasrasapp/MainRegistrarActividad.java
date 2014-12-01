package com.tdp.pasrasapp;

import java.util.ArrayList;
import java.util.List;

import com.tdp.adapter.IprAdapter;
import com.tdp.adapter.OrigenAdapter;
import com.tdp.adapter.ProyectoAdapter;
import com.tdp.adapter.TipoActividadAdapter;
import com.tdp.adapter.UsuarioAdapter;
import com.tdp.bean.BeanIpr;
import com.tdp.bean.BeanOrigen;
import com.tdp.bean.BeanProyecto;
import com.tdp.bean.BeanTipoActividad;
import com.tdp.bean.BeanUsuario;
import com.tdp.controlador.MainController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class MainRegistrarActividad extends Activity {

	
	Button btn_registrarActividad;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_actividad);
		
		btn_registrarActividad = (Button)findViewById(R.id.btn_registrarActividad);
		
		cargarCombos();
		
		
		
		
		
	}
	
	
	void cargarCombos(){

		Spinner spn_proyecto = (Spinner) findViewById(R.id.spn_proyecto);
		Spinner spn_tipoActividad = (Spinner) findViewById(R.id.spn_tipoActividad);
		Spinner spn_ipr = (Spinner) findViewById(R.id.spn_ipr);
		Spinner spn_origen = (Spinner) findViewById(R.id.spn_origen);
		
		List<BeanProyecto> lstProyecto = new ArrayList<BeanProyecto>();
		List<BeanIpr> lstIpr = new ArrayList<BeanIpr>();
		List<BeanOrigen> lstOrigen = new ArrayList<BeanOrigen>();
		List<BeanTipoActividad> lstTipoActividad = new ArrayList<BeanTipoActividad>();
		
		lstProyecto = MainController.getInstance().lstProyecto;
		lstIpr = MainController.getInstance().lstIpr;
		lstOrigen = MainController.getInstance().lstOrigen;
		lstTipoActividad = MainController.getInstance().lstTipoActividad;
		
		
		/*
		ProyectoAdapter adapProyecto;		
		adapProyecto = new ProyectoAdapter(this, R.layout.list_proyecto_adapter , lstProyecto );
		adapProyecto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spn_proyecto.setAdapter(adapProyecto);
		
		
		IprAdapter adapIpr;		
		adapIpr = new IprAdapter(this, R.layout.list_ipr_adapter , lstIpr );
		adapIpr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spn_ipr.setAdapter(adapIpr);
		
		OrigenAdapter adapOrigen;		
		adapOrigen = new OrigenAdapter(this, R.layout.list_origen_adapter , lstOrigen );
		adapOrigen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spn_origen.setAdapter(adapOrigen);
		
		TipoActividadAdapter  adapTipoActividad;		
		adapTipoActividad = new TipoActividadAdapter(this, R.layout.list_tipo_actividad_adapter , lstTipoActividad );
		adapTipoActividad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spn_tipoActividad.setAdapter(adapTipoActividad);
		*/
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		btn_registrarActividad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(MainRegistrarActividad.this,MainAsignarEstimado.class);
				 Bundle bun = new Bundle();
				 startActivity(intent);
				
				
			}
		});
	
	}
	
	
	
	
	
}
