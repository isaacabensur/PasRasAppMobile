package com.tdp.pasrasapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.tdp.adapter.UsuarioAdapter;
import com.tdp.bean.BeanUsuario;
import com.tdp.controlador.MainController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainPlanificacion extends Activity{
	
	Button btnListar;
	Spinner spn_colaborador;
	UsuarioAdapter adapUsuario;
	int alimentoId;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.planificacion);
	
	btnListar= (Button)findViewById(R.id.btnListar);
	TextView tv_idUsuario = (TextView) findViewById(R.id.tv_idUsuario);
	Spinner spn_colaborador = (Spinner) findViewById(R.id.spn_colaborador);
	
	
	LinkedList<BeanUsuario> lstUsuario = new LinkedList<BeanUsuario>();
	List<BeanUsuario> arrUsuario = new ArrayList<BeanUsuario>();
	BeanUsuario oUsuario = null;
	
	lstUsuario.add(new BeanUsuario(1,"Max"));
	lstUsuario.add(new BeanUsuario(2,"Jaime"));
	lstUsuario.add(new BeanUsuario(3,"Cesar"));
	
	oUsuario = new BeanUsuario();	
	oUsuario.setNombre("Max");
	oUsuario.setIdusuario(100);
	arrUsuario.add(oUsuario);
	
	oUsuario = new BeanUsuario();	
	oUsuario.setNombre("Jaime");
	oUsuario.setIdusuario(99);
	arrUsuario.add(oUsuario);
	
	
			
	String idUsuario = "";
	
	Intent startingIntent = this.getIntent();
    if (startingIntent != null)
    {
    	Bundle b = startingIntent.getBundleExtra("beanusuario");
         if (b != null) {
        	 idUsuario = b.getString("idUsuario"); 
         }
    }
	
    if( !idUsuario.equalsIgnoreCase("")){
    	tv_idUsuario.setText(idUsuario);
    }else{
    	tv_idUsuario.setText("id desconocido");
    }
    
	adapUsuario = new UsuarioAdapter(this, R.layout.list_usuario_adapter , arrUsuario );
	//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list );
	//adapUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	   
	adapUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
   
   
   spn_colaborador.setAdapter(adapUsuario);
   
    
}


@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
		btnListar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				registrarPlanificacion();
				 Intent intent = new Intent(MainPlanificacion.this,MainRegistrarPlanific.class);
				 Bundle bun = new Bundle();
				 startActivity(intent);
				
			}
		});
		
		/*
		  spn_colaborador.setOnItemSelectedListener(new OnItemSelectedListener() {
		 	
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView,int position, long id ){
				
				//Toast.makeText(parentView.getContext(), 
				//			"has seleccionado: " + parentView.getItemAtPosition(position).toString() , Toast.LENGTH_SHORT).show();
				
			}
			
			public void onNothingSelected(AdapterView<?> parentView){
				
				
			}
			
		});
		  */
		
	}

void registrarPlanificacion(){
	TextView tv_idUsuario = (TextView) findViewById(R.id.tv_idUsuario);
	Spinner spn_colaborador = (Spinner) findViewById(R.id.spn_colaborador);
	
	int id_user_coordinador = 0;
	int id_user_colaborador = 0;
	
	
	
	
	
	
}




public class MyOnItemSelectedListener implements OnItemSelectedListener {
	public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		if (parent.getId() == R.id.spn_colaborador) {
			alimentoId = ((BeanUsuario) parent.getItemAtPosition(pos)).getId();
		}
		Toast.makeText(parent.getContext(), 
				"has seleccionado: " + alimentoId , Toast.LENGTH_SHORT).show();
	
		//Podemos hacer varios ifs o un switchs por si tenemos varios spinners.
	}
	public void onNothingSelected(AdapterView<?> parent) {
		// Do nothing.
	}
}




}
