package com.tdp.util;

import java.util.ArrayList;



import com.tdp.bean.BeanUsuario;

import android.content.Context;

public class Constants {

	public static BeanUsuario beanusuariogeneral;
	

	

	public static String Main = "Main";

	
	
	
	public static int getImageId(Context context, String imageName) {
	    return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
	}
	

	
	//variables para el API
	public static String ruta="192.168.1.127/codigofuente/";
	public static String API="http://"+ruta;

	public static String APIsection="validarusuario.php?";
	
	/*APIS QUE TRAEN LOS METODOS QUE NECESITAMOS*/
	public static String APIlistardistritos="listadodistritos.php";

	
	
	/*APIS*/
	
	public static String apiCorreoUsuario="&correoUsuario=";
	public static String apiClaveUsuario="&claveUsuario=";
	

	public static String apiNombre="&nombre=";
	public static String apiApellidos="&apellidos=";
	public static String apiCorreo="&correo=";
	public static String apicelular="&celular=";
	public static String apiDistrito="&distrito=";
	public static String apiClave="&clave=";
	
	
	/*VARIABLES A MANDAR */
	
	public static String APIdataIDUSUARIO = "idusuario";
	public static String APIdataCORREOUSUARIO = "correo";
	public static String APIdataNOMBREUSUARIO = "nombre";
	public static String APIdataAPEUSUARIO = "apellidos";

	public static String apiVarErrorOK="OK";
	
	public static String APIresponse="response";
	public static String APIdata="data";
		
	
	// variables para sqllite
	public static String dbName = "grupoandroidl.db";
	public static int dbVersion = 1;
	
	public static String tableName = "tbluser";
	public static String colidUser = "id";
	public static String colnameUser = "name";
	public static String colapeUser = "apellidos";
	public static String colemailUser = "email";

	
	public static int inidUser = 0;
	public static int indnameUser = 1;
	public static int indapeser = 2;
	public static int indemailUser = 3;
	
	
	
	public static String createTable = "CREATE TABLE " +
			tableName + "( " + colidUser + " int PRIMARY KEY" +
			", " + colnameUser + " text " +
			", " + colapeUser + " text " +
			", " + colemailUser + " text " +
			" )";
	
	
	
	public static String dropTable = "DROP TABLE " +
											tableName ;
	
	
	
	
	// DATOS PARA PEDIDOS 
	

	public static String apiCodeUsu="&codigo=";
	
	
	//para eventos , promociones , reservas

	public static String APIlistaEventos="listadoeventos.php";
	public static String APIlistaPromociones="listadopromociones.php";
	public static String APIlistaReservas="listadoreservas.php";

	public static String APIInsertEventos_usu="registr_event_usu.php?";
	public static String APIInsertPromociones_usu="registr_prom_usu.php?";
	public static String APIInsertReservas_usu="registr_reserv_usu.php?";
	
			
	public static String APIlistaEventos_usu="listadoeventos_usu.php?";
	public static String APIlistaPromociones_usu="listadopromocion_usu.php?";
	public static String APIlistaReservas_usu="listadoreserva_usu.php?";

	
	
	
	public static String APIValidaEventos_usu="validaeventousu.php?";
	public static String APIValidaPromociones_usu="validapromousu.php?";
	public static String APIValidaReservas_usu="validareservusu.php?";
	
	public static String apiValEPRid_usu="&id_usu=";
	public static String apiValEPRid_producto="&id_producto=";
	
	
	public static String apiRegEPRid_usu="&id_usu=";
	public static String apiRegEPRid_producto="&id_producto=";
	public static String apiRegEPRcantidad="&cantidad=";
	
	
	//-------------------------------------
	
	// DATOS Para insertUsuario
	public static String APIinsertausuario="insertausuario.php?";

	public static String APIvalidamailusu="validaexisteusu.php?";
	
	public static String apiRegNomUsu="&nombre=";
			public static String apiRegApeUsu="&apellidos=";
			public static String apiRegMailUsu="&correo=";
			public static String apiRegCelUsu="&celular=";
			public static String apiReDistUsu="&distrito=";
			public static String apiReClaUsu="&clave=";
			
			
	

}
