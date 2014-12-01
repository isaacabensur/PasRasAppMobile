

package com.tdp.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

	
public class BeanUsuario  implements Parcelable{
	
	public String nombre;
	public String apellidos;
	public String correo;
	public int cod_tip;
	public int idusuario;


	public int getCod_tip() {
		return cod_tip;
	}



	public void setCod_tip(int cod_tip) {
		this.cod_tip = cod_tip;
	}



	public int getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String clave;
	


	
	   public  BeanUsuario() {
		// TODO Auto-generated constructor stub
	}
	   
	   
	      
	    private BeanUsuario(Parcel in){
	    	

	 
	              this.apellidos= in.readString();
	              this.nombre = in.readString();
	              this.idusuario= in.readInt();
	              this.correo= in.readString();
	            
	              this.clave= in.readString();
	        }
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}








	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

				 dest.writeString(this.apellidos);
	        dest.writeString(this.nombre);
		        dest.writeInt(this.idusuario);
		        dest.writeString(this.correo);
		      
		        dest.writeInt(this.cod_tip);
			  
				 dest.writeString(this.clave);
				
		        
		        
	}
	
	  public static final BeanUsuario.Creator<BeanUsuario> CREATOR = new BeanUsuario.Creator<BeanUsuario>() {
	        public BeanUsuario createFromParcel(Parcel in) {
	            return new BeanUsuario(in);
	        }
	        
	        public BeanUsuario[] newArray(int size) {
	            return new BeanUsuario[size];
	        }
	
	  };
	  

}