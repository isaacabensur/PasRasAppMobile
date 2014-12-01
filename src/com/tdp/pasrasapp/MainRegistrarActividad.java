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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainRegistrarActividad extends Activity {

	
	Button btn_registrarActividad;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_actividad);
		
		btn_registrarActividad = (Button)findViewById(R.id.btn_registrarActividad);
		
		cargarCombos();
		//Actualizado
		
		
		
		
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
		
		
		/**/
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
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		btn_registrarActividad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 mostrar();
				 EditText ed_registrarActividad = (EditText) findViewById(R.id.ed_registrarActividad);
					
				 
				 Intent intent = new Intent(MainRegistrarActividad.this,MainAsignarEstimado.class);
				 Bundle bun = new Bundle();
				 bun.putInt("id_actividad",1);
				 bun.putInt("id_planificacion",1);
				 bun.putString("descripcion_actividad",ed_registrarActividad.getText().toString());
				 
				 intent.putExtra("bunRegistrarActividad", bun);
				 
				 startActivity(intent);
				
				 
				
			}
		});
	
	}
	
	void registrar(){
		
		Spinner spn_proyecto = (Spinner) findViewById(R.id.spn_proyecto);
		Spinner spn_tipoActividad = (Spinner) findViewById(R.id.spn_tipoActividad);
		Spinner spn_ipr = (Spinner) findViewById(R.id.spn_ipr);
		Spinner spn_origen = (Spinner) findViewById(R.id.spn_origen);
		EditText ed_registrarActividad = (EditText) findViewById(R.id.ed_registrarActividad);
		
		String descripcionActividad ="";
		int Id_tipo_actividad = 0;
		int Id_ipr = 0;
		int Id_proyecto = 0;
		int Id_origen = 0;
		
		descripcionActividad = ed_registrarActividad.getText().toString();
		
		 Id_tipo_actividad =( (BeanTipoActividad) spn_tipoActividad.getItemAtPosition(spn_tipoActividad.getSelectedItemPosition()) ).getId() ;
		 Id_ipr = ( (BeanIpr) spn_ipr.getItemAtPosition(spn_ipr.getSelectedItemPosition()) ).getId() ;
		 Id_proyecto = ( (BeanProyecto) spn_proyecto.getItemAtPosition(spn_proyecto.getSelectedItemPosition()) ).getId(); 
		 Id_origen = ( (BeanOrigen) spn_origen.getItemAtPosition(spn_origen.getSelectedItemPosition()) ).getId() ;
		  
		 
	}
	
	void mostrar(){
		Spinner spn_proyecto = (Spinner) findViewById(R.id.spn_proyecto);
		Spinner spn_tipoActividad = (Spinner) findViewById(R.id.spn_tipoActividad);
		Spinner spn_ipr = (Spinner) findViewById(R.id.spn_ipr);
		Spinner spn_origen = (Spinner) findViewById(R.id.spn_origen);
		EditText ed_registrarActividad = (EditText) findViewById(R.id.ed_registrarActividad);
		
		Toast.makeText(this, 
				"Descripcion : " 
				+ ed_registrarActividad.getText().toString()
				+ "Valor TA : " 
				+ ( (BeanTipoActividad) spn_tipoActividad.getItemAtPosition(spn_proyecto.getSelectedItemPosition()) ).getId() 
				+ "Valor I : " 
				+ ( (BeanIpr) spn_ipr.getItemAtPosition(spn_ipr.getSelectedItemPosition()) ).getId() 
				+ "Valor P : " 
				+ ( (BeanProyecto) spn_proyecto.getItemAtPosition(spn_proyecto.getSelectedItemPosition()) ).getId() 
				+ "Valor O : " 
				+ ( (BeanOrigen) spn_origen.getItemAtPosition(spn_origen.getSelectedItemPosition()) ).getId() 
				, 
				Toast.LENGTH_LONG).show();
		
	}
	
	
	
	
	
}
