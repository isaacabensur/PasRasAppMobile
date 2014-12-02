package com.tdp.pasrasapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tdp.adapter.ActividadAdapter;
import com.tdp.bean.BeanActividad;
import com.tdp.bean.BeanPlanificacion;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainRegistrarPlanific extends Activity{
	
	
	Button btnActividad;
	RequestAsynctask request;
	
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.registrar_planificacion);
		btnActividad = (Button)findViewById(R.id.btnActividad);
		
		//cargarActividades();
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
		request = new RequestAsynctask(this);
		
		cargarVariablesPrevias();
		cargarActividades();
		
		//ListView lv_Planificacion = (ListView) findViewById(R.id.lv_Planificacion) ;
		
		
		
		
		btnActividad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				 
					
				 Intent intent = new Intent(MainRegistrarPlanific.this,MainRegistrarActividad.class);
				 Bundle bun = new Bundle();
				 //startActivity(intent);
				
				
			}
		});
		
		
	}
	
	void cargarVariablesPrevias(){
		
		TextView tv_subTituloRegistrarPlan = (TextView) findViewById(R.id.tv_subTituloRegistrarPlan);
				
		int id_actividad = 0; 
		String	id_planificacion = "";
		String descripcion_actividad = "";
		String codTipo = "";
		String idUsuario = "";
		String cad = "no data";
		
		
		Intent startingIntent = this.getIntent();
	    if (startingIntent != null)
	    {
	    	Bundle b = startingIntent.getBundleExtra("bunPlanificacion");
	         if (b != null) {
	        	 id_planificacion = b.getString("id_planificacion");
	         }
	         
	         Bundle bCola = startingIntent.getBundleExtra("beanUsuarioCola");
	         if (bCola != null) {	        	  
	        	 idUsuario = bCola.getString("idUsuario"); 
	        	 codTipo = bCola.getString("codTipo");
	         }
	    }
		
	    if( id_actividad != 0){
	    	cad = "" + id_actividad;
	    }
	    if( !id_planificacion.equalsIgnoreCase("")){
	    	cad = cad + "" + id_planificacion;
	    }
	    if( !descripcion_actividad.equalsIgnoreCase("") ){
	    	cad = cad +descripcion_actividad;
	    }
	    if( !idUsuario.equalsIgnoreCase("")){
	    	cad = cad + "" + idUsuario;
	    }
	    if( !codTipo.equalsIgnoreCase("") ){
	    	cad = cad +codTipo;
	    }
	    
	    
	    
	    
	    
	    tv_subTituloRegistrarPlan.setText(cad);
	}
	
	
	void cargarActividades(){	
            
		//http://tallerandroid.cesar-pillihuaman.com/index.php/actividad
			
            String url = Constants.API
                    + "index.php/actividad"                   
                   ; 
            System.out.println("URL : "+url);
             
            request.ListaUsuario(url);          
      
		
	}
	
	public void mostrarGrillaActividades(String jsonResult) {
		 Log.d("VALIDA",jsonResult);
        
		 //GridView gv_Planificacion = (GridView) findViewById(R.id.gv_Planificacion) ;
		 ListView lv_Planificacion = (ListView) findViewById(R.id.lv_Planificacion) ;
		 
		 
	        try {
	        	JSONArray respJSON = new JSONArray(jsonResult);
	            
	            if ( respJSON != null  ) {
	                 
            		//RECIIMOS DATOS DEL USUARIO Y GENERAMOS UN REGISTRO EN SQLITE	            	
	            	
	                //JSONObject dato = jsonData.getJSONObject(Constants.APIdata);
	                
	                
					int n = respJSON.length();
					
	                BeanActividad oActividad = null;
	                List<BeanActividad> lstActividad = new ArrayList<BeanActividad>();
	                List<BeanActividad> lstActividadFiltrada = new ArrayList<BeanActividad>();
	                
	                for (int i = 0; i < n; i++) {

						JSONObject obj = respJSON.getJSONObject(i);
						oActividad = new BeanActividad();	
						
						String descripcion_actividad = obj.getString("descripcionActividad");
						int idActividad = obj.getInt("idActividad");
						int idPlanificacion = obj.getInt("idPlanificacion");
						
						oActividad.setId_actividad( idActividad );
						oActividad.setDescripcion_actividad(descripcion_actividad );
						oActividad.setId_planificacion(idPlanificacion );
						
						if(idActividad != 0){
							lstActividad.add(oActividad);
						}
					}
	                
	                
	                List<BeanPlanificacion> olsPlanificacion = new LinkedList<BeanPlanificacion>();
	               
	                /*
                	for (BeanUsuario oUsu : olsPlanificacion){
	                	
	                	if (oAct.getId_planificacion() == 1 ) {
	                		lstActividadFiltrada.add(oAct);	                		
	                	}
	                }
	                
	                
	                
	                for (BeanActividad oAct : lstActividad){
	                	
	                	if (oAct.getId_planificacion() == 1 ) {
	                		lstActividadFiltrada.add(oAct);	                		
	                	}
	                } 
	                */
	                
	                ActividadAdapter adapActividad= new ActividadAdapter(this, R.layout.list_actividad_adapter, lstActividad);
	                lv_Planificacion.setAdapter(adapActividad);
	                
	                /*
	                lv_Planificacion.setOnItemClickListener(new OnItemClickListener() {
	                	
	        			public void onItemClick(
	        					AdapterView<?> parent, View v,
	        					int position, long id) {
	        				String strId_Actividad = "";
	        				BeanActividad oActividad = new BeanActividad();
	        				oActividad = (BeanActividad) lv_Planificacion.getItemAtPosition(position);
	        				strId_Actividad = "" + oActividad.getId_actividad();
	        				mostrarAlerta(strId_Actividad);
	        				
	        				  
	        				
	        							
	        				
	        			}
	        		});
	                 */
	                
	                 
	            }else{
	 
	                Toast.makeText(this, "Error revise sus datos", Toast.LENGTH_SHORT).show();
	            }
	             
	        } catch (JSONException e) {
	             
	            e.printStackTrace();
	        }
	}
	
	void mostrarAlerta(String strId_Actividad){
		Toast.makeText(this, strId_Actividad, Toast.LENGTH_SHORT).show();
	}
	

}
