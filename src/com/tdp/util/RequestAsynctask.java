package com.tdp.util;

import com.tdp.pasrasapp.ActividadPrincipal;
import com.tdp.pasrasapp.MainPlanificacion;
import com.tdp.pasrasapp.MainRegistrarPlanific;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class RequestAsynctask {

	
	Context contexto;
	  public RequestAsynctask(Context contexto) {
	        super();
	        this.contexto = contexto;
	    }
	  
	   public void validaUsuario(String url) {
		   
		   System.out.println("LLEGAMOS A validaUsuario");
		   
	        ValidaUsuario obj = new ValidaUsuario();
	        
	 	   System.out.println("LLEGAMOS A validaUsuario 2");
	        obj.execute(url);
	    }
	   
	   public void ListaUsuario(String url){
		   ListaUsuario oListausuario = new ListaUsuario();
		   oListausuario.execute(url);
	   }
	    
	   public void registrarPlanificacion(String url){
		   RegistrarPlanificacipon oplanificacion = new RegistrarPlanificacipon();
		   oplanificacion.execute(url);
	   }
	   
	   
	   public class ValidaUsuario extends AsyncTask<String, Void, String> {
		   
	        ProgressDialog mensaje;
	 
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	 
	            mensaje = new ProgressDialog(contexto);
	            mensaje.setCancelable(false);
	            mensaje.setMessage("Validando usuario");
	            mensaje.show();
	 
	        }
	 
	        @Override
	        protected String doInBackground(String... params) {
	 
	            String response = "";
	            for (String url : params) {
	                try {
	                    response = RESTClient.connectAndReturnResponse(url);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            return response;
	        }
	 
	        @Override
	        protected void onPostExecute(String result) {
	 
	            super.onPostExecute(result);
	 
	            mensaje.dismiss();
	 
	            ((ActividadPrincipal) contexto).validacionTerminada(result);
	 
	        }
	    }
	   
	   
	   public class ListaUsuario extends AsyncTask<String, Void, String> {
		   
	        ProgressDialog mensaje;
	 
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	 
	            mensaje = new ProgressDialog(contexto);
	            mensaje.setCancelable(false);
	            mensaje.setMessage("Listando Actividades");
	            mensaje.show();
	 
	        }
	 
	        @Override
	        protected String doInBackground(String... params) {
	 
	            String response = "";
	            for (String url : params) {
	                try {
	                    response = RESTClient.connectAndReturnResponse(url);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            return response;
	        }
	 
	        @Override
	        protected void onPostExecute(String result) {
	 
	            super.onPostExecute(result);
	 
	            mensaje.dismiss();
	 
	            ((MainRegistrarPlanific) contexto).mostrarGrillaActividades(result);
	 
	        }
	    }
	   
	   public class RegistrarPlanificacipon extends AsyncTask<String, Void, String> {
		   
	        ProgressDialog mensaje;
	 
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	 
	            mensaje = new ProgressDialog(contexto);
	            mensaje.setCancelable(false);
	            mensaje.setMessage("Registrando Planificacion");
	            mensaje.show();
	 
	        }
	 
	        @Override
	        protected String doInBackground(String... params) {
	 
	            String response = "";
	            for (String url : params) {
	                try {
	                    response = RESTClient.connectAndReturnResponse(url);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            return response;
	        }
	 
	        @Override
	        protected void onPostExecute(String result) {
	 
	            super.onPostExecute(result);
	 
	            mensaje.dismiss();
	 
	            ((MainPlanificacion) contexto).irRegistrarActividadesPlanificacion(result);
	 
	        }
	    }
	   
	   
	   
	 
}
