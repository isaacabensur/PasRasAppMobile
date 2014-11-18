package com.tdp.pasrasapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainRegistrarPlanific extends Activity{
	
	
	Button btnActividad;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.registrar_planificacion);
		btnActividad = (Button)findViewById(R.id.btnActividad);
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		btnActividad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				 Intent intent = new Intent(MainRegistrarPlanific.this,MainRegistrarActividad.class);
				 Bundle bun = new Bundle();
				 startActivity(intent);
				
				
			}
		});
		
		
	}
	
	

}
