package com.tdp.pasrasapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainPlanificacion extends Activity{
	
	Button btnListar;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.planificacion);
	
	btnListar= (Button)findViewById(R.id.btnListar);
}


@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		btnListar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				 Intent intent = new Intent(MainPlanificacion.this,MainRegistrarPlanific.class);
				 Bundle bun = new Bundle();
				 startActivity(intent);
				
			}
		});
	}

}
