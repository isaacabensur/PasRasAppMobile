package com.tdp.pasrasapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tdp.adapter.ActividadAdapter;
import com.tdp.adapter.UsuarioAdapter;
import com.tdp.bean.BeanActividad;
import com.tdp.bean.BeanOrigen;
import com.tdp.bean.BeanUsuario;
import com.tdp.controlador.MainController;
import com.tdp.util.Constants;
import com.tdp.util.RequestAsynctask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
	RequestAsynctask request;
	String idUsuario = "";
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.planificacion);
	
	btnListar= (Button)findViewById(R.id.btnListar);
	TextView tv_idUsuario = (TextView) findViewById(R.id.tv_idUsuario);
	Spinner spn_colaborador = (Spinner) findViewById(R.id.spn_colaborador);
	
	
	
			
	
	
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
    
    List<BeanUsuario> lstUsuario = new ArrayList<BeanUsuario>();	
	lstUsuario = MainController.getInstance().lstUsuario;
	adapUsuario = new UsuarioAdapter(this, R.layout.list_usuario_adapter , lstUsuario );
	//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list );
	//adapUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	   
	adapUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
   
   
   spn_colaborador.setAdapter(adapUsuario);
   
    
}


@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
		request = new RequestAsynctask(this);
		
		btnListar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				 registrarPlanificacion();
				 	
				 
				
			}
		});
		
		
	}



void registrarPlanificacion(){
	TextView tv_idUsuario = (TextView) findViewById(R.id.tv_idUsuario);
	Spinner spn_colaborador = (Spinner) findViewById(R.id.spn_colaborador);
	
	String error = "";
	String id_user_coordinador =  idUsuario;
	String id_user_colaborador = "" + ( (BeanUsuario) spn_colaborador.getItemAtPosition(spn_colaborador.getSelectedItemPosition()) ).getId() ;
	
	//http://tallerandroid.cesar-pillihuaman.com/index.php/planificacion_insert?
	//id_user_colaborador=1&id_user_coordinador=3
	
	String url = Constants.API
            + "index.php/planificacion_insert?"  
            + "id_user_colaborador=" + id_user_colaborador + "&"
            + "id_user_coordinador=" + id_user_coordinador + ""
           ; 
    System.out.println("URL : "+url);
     
    request.registrarPlanificacion(url);  
	
	
	
}

public void irRegistrarActividadesPlanificacion(String jsonResult){
	
	String id_planificacion="";
	TextView tv_idUsuario = (TextView) findViewById(R.id.tv_idUsuario);
	//tv_idUsuario.setText(jsonResult);
	
	 try {
     	JSONArray respJSON = new JSONArray(jsonResult);
         
         if ( respJSON != null  ) {
          
			int n = respJSON.length();             
             for (int i = 0; i < n; i++) {

					JSONObject obj = respJSON.getJSONObject(i);
					id_planificacion = obj.getString("id");				
					
					if(!id_planificacion.equalsIgnoreCase("")){
						tv_idUsuario.setText(id_planificacion);
					}
				} 
             
              
         }else{

             Toast.makeText(this, "Id Planificacion no generado", Toast.LENGTH_SHORT).show();
         }
          
     } catch (JSONException e) {
          
         e.printStackTrace();
     }
	 
	 
	
	Intent intent = new Intent(MainPlanificacion.this,MainRegistrarPlanific.class);
	Bundle bun = new Bundle();
	bun.putString("id_planificacion", id_planificacion);
	intent.putExtra("bunPlanificacion",bun);
	
	startActivity(intent);
}









}
