

package com.tdp.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;


public class BeanUsuario  implements Parcelable{
	
	public String nombre;
	public String apellidos;
	public String correo;
	public String celular;
	public String distrito;
	public String regsitro;

	public String clave;
	
	public Integer id;

	
	   public  BeanUsuario() {
		// TODO Auto-generated constructor stub
	}
	   
	   
	      
	    private BeanUsuario(Parcel in){
	    	

	 
	              this.apellidos= in.readString();
	              this.nombre = in.readString();
	              this.id= in.readInt();
	              this.correo= in.readString();
	              this.celular= in.readString();
	              this.regsitro= in.readString();
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getRegsitro() {
		return regsitro;
	}

	public void setRegsitro(String regsitro) {
		this.regsitro = regsitro;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		        dest.writeInt(this.id);
		        dest.writeString(this.correo);
				 dest.writeString(this.celular);     
				 dest.writeString(this.clave);
				 dest.writeString(this.regsitro);  
		        
		        
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