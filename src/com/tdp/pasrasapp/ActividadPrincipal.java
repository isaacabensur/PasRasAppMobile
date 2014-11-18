package com.tdp.pasrasapp;

import org.json.JSONException;
import org.json.JSONObject;

import com.tdp.bean.BeanUsuario;
import com.tdp.util.Constants;
import com.tdp.util.RequestAsynctask;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class ActividadPrincipal extends Activity {

	
	 Button btningresar;
     EditText txtusu;
     EditText txtcla;
	
     TextView txtnuevousu;
     final BeanUsuario be = new BeanUsuario();
     RequestAsynctask request;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prlogueo);
		
		 btningresar = (Button)findViewById(R.id.btningreso);
	        txtusu = (EditText)findViewById(R.id.correoUsuario);
	        txtcla = (EditText)findViewById(R.id.claveUsuario);
	         
	        txtnuevousu = (TextView)findViewById(R.id.txtnuevo);
	}


	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		 request = new RequestAsynctask(this);
		btningresar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				
				if (!txtusu.getText().toString().equals("") 
                        && !txtcla.equals("") ){
                     
                    String url = Constants.API
                            + Constants.APIsection
                            + Constants.apiCorreoUsuario
                            + txtusu.getText().toString()
                            + Constants.apiClaveUsuario
                            + txtcla.getText().toString();
                             
                             
                 
                    System.out.println("URL : "+url);
                     
                    request.validaUsuario(url);
                   
                     
                    //Toast.makeText(getApplicationContext(), "Ingreso Correctamente", Toast.LENGTH_SHORT).show();
                     
                }else{
                     
                    Toast.makeText(getApplicationContext(), "Ingrese los datos correctamente", Toast.LENGTH_SHORT).show();
                }
				
			}
		});
		
		
		
		
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

    public void mostrarMenuPrincipal (){
        
        Intent intent = new Intent(ActividadPrincipal.this,MainPlanificacion.class);
 
 
 
 
Bundle bun = new Bundle();
 
 
 
// asignamos al intent los parametros a enviar
intent.putExtra("beanusuario", be);
// cambiamos de activity
 
 
startActivity(intent);
 
 
 
 
    }

	public void validacionTerminada(String jsonResult) {
		 Log.d("VALIDA",jsonResult);
         
	        try {
	             
	        	
	        	
	        	
	            JSONObject jsonData = new JSONObject (jsonResult);
	     
	 
	         
	            if (jsonData.getString(Constants.APIresponse).equals(Constants.apiVarErrorOK)) {
	                 
	//RECIIMOS DATOS DEL USUARIO Y GENERAMOS UN REGISTRO EN SQLITE
	                 
	                JSONObject dato = jsonData.getJSONObject(Constants.APIdata);
	                 
	                 
	                 
	                be.setApellidos(dato.getString(Constants.APIdataAPEUSUARIO));
	                be.setCorreo(dato.getString(Constants.APIdataCORREOUSUARIO));
	                be.setNombre(dato.getString(Constants.APIdataNOMBREUSUARIO));
	                be.setIdusuario(Integer.parseInt(dato.getString(Constants.APIdataIDUSUARIO)));
	                 
	                System.out.println("APELIIDOSSSS: +++"+be.getApellidos());
	                 
	            /*  Log.d("JSON", "" + dato.getString(Constants.APIdataIDUSUARIO));
	                Log.d("JSON", "" + dato.getString(Constants.APIdataCORREOUSUARIO));
	                Log.d("JSON", "" + dato.getString(Constants.APIdataNOMBREUSUARIO));*/
	                 
	                 
	 
	                System.out.println("LLLEHPPPPP 2");
	                 
	                String sql = "INSERT INTO " + Constants.tableName +
	                        " (" + Constants.colidUser + ", "+
	                        Constants.colnameUser + ", "+
	                        Constants.colapeUser + ", "+
	                        Constants.colemailUser + " )" +
	                        "VALUES(" +Integer.parseInt(dato.getString(Constants.APIdataIDUSUARIO)) + "," +
	                        "'"+dato.getString(Constants.APIdataNOMBREUSUARIO) + "'," +
	                        "'"+dato.getString(Constants.APIdataAPEUSUARIO) + "'," +
	                    "'"+dato.getString(Constants.APIdataCORREOUSUARIO) +"')" ;
	                 
	                System.out.println(sql);
	                 
	                //dbProcesos.execSQL(sql);
	                 
	                 
	 
	                System.out.println("LLLEHPPPPP 3");
	                 
	                //verificaUsuario("");
	                
	                mostrarMenuPrincipal();  
	                 
	            }else{
	 
	                Toast.makeText(this, "Error revise sus datos", Toast.LENGTH_SHORT).show();
	            }
	             
	        } catch (JSONException e) {
	             
	            e.printStackTrace();
	        }
	}
}
