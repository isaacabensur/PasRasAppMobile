package com.tdp.pasrasapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainAsignarEstimado extends Activity {
	
	
	Button btn_registrarEstimado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.asignar_estimado);
		btn_registrarEstimado = (Button)findViewById(R.id.btn_registrarEstimado);
	
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

}
