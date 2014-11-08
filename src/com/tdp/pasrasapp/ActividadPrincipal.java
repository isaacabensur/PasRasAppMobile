package com.tdp.pasrasapp;

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
}
