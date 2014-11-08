package com.tdp.util;

import com.tdp.pasrasapp.ActividadPrincipal;

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
	        ValidaUsuario obj = new ValidaUsuario();
	        obj.execute(url);
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
	 
}
