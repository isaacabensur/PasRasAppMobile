package com.tdp.pasrasapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainAsignarEstimado extends Activity {
	
	
	Button btn_registrarEstimado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.asignar_estimado);
		btn_registrarEstimado = (Button)findViewById(R.id.btn_registrarEstimado);
		
		cargarParametrosPantallAnterior();
		
	}
	
	void cargarParametrosPantallAnterior(){
	
	EditText ed_descripcionActividadEstimada = (EditText) findViewById(R.id.ed_descripcionActividadEstimada);
		
		
		
	int id_actividad = 0; 
	int	id_planificacion = 0;
	String descripcion_actividad = "";
	String cad = "no data";
	
	Intent startingIntent = this.getIntent();
    if (startingIntent != null)
    {
    	Bundle b = startingIntent.getBundleExtra("bunRegistrarActividad");
         if (b != null) {
        	 id_actividad = b.getInt("id_actividad"); 
        	 id_planificacion = b.getInt("id_planificacion"); 
        	 descripcion_actividad = b.getString("descripcion_actividad"); 
        	 
         }
    }
	
    if( id_actividad != 0){
    	cad = "" + id_actividad;
    }
    if( id_planificacion != 0){
    	cad = cad + "" + id_planificacion;
    }
    if( !descripcion_actividad.equalsIgnoreCase("") ){
    	cad = cad +descripcion_actividad;
    }
    
    ed_descripcionActividadEstimada .setText(cad);
    
	}
    
    
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		btn_registrarEstimado.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(MainAsignarEstimado.this,MainPlanificacion.class);
				 Bundle bun = new Bundle();
				 startActivity(intent);
				
			}
		});
		
	}
	
	
	void registraEstimacion(){
		int id_actividad = 0; 
		int	id_planificacion = 0;
		String descripcion_actividad = "";
		int horaEstimada = 0;
		
		EditText ed_descripcionActividadEstimada = (EditText) findViewById(R.id.ed_descripcionActividadEstimada);
		EditText ed_horaEstimada = (EditText) findViewById(R.id.ed_horaEstimada);
		
		descripcion_actividad = ed_descripcionActividadEstimada.getText().toString();
		horaEstimada = Integer.parseInt(ed_descripcionActividadEstimada.getText().toString() ) ;
		
		
	}

}
