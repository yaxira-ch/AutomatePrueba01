package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PagosMasivosBE {

	public static String Gstr_ID_CASO_LOGIN;
	public static String Gstr_FIRMANTE;
	public static String Gstr_ID_CASO_LOTE;
	public static String GstrTXT_MENU;
	public static String GstrTXT_SUBMENU;
	public static String GstrTXT_SUBMENU1;
	public static String GstrBTN_ENVIAR;
	public static String GstrCMD_PRODUCTO;
	public static String GstrCMB_EMPRESA;
	public static String GstrCMD_SERVICIO;
	public static String GstrTXT_FECHA_INICIO;
	public static String GstrTXT_FECHA_FIN;
	public static String GstrBTN_BUSCAR;
	public static String GstrCHK_TODOS;
	public static String GstrBTN_AUTORIZAR;  
	public static String GstrBTN_BLOQUEAR;
	public static String GstrTXT_CLAVE_DINAMICA;
	public static String GstrBTN_CONFIRMAR; 
	public static String GstrBTN_CANCELAR_OPERACION;
	public static String GstrTXT_COLUMNA_ERROR;
	public static String GstrTXT_MENSAJE_ERROR;
	public static String GstrCMB_SITUACION;
	public static String GstrLNK_VER_DETALLE;
	public static String GstrTXT_NOMBRE_SOLICITUD;
	public static String GstrLNK_CERRAR_SESION;
	public static String GstrRESULTADO_ESPERADO;
	public static String GstrTXT_CLAVE;
	//public static String GstrESTADO;
	//public static String GstrLNK_VER_EXPIRADOS;
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
		boolean bandera = true; 
	
		try {
			
			Gstr_ID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			Gstr_ID_CASO_LOTE = Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1= Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			
			GstrCMD_PRODUCTO= Rst_Funcionalidad.getObject("CMD_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMD_PRODUCTO") : Mdl_Variables.Gstr_Ignore;

			GstrCMD_SERVICIO = Rst_Funcionalidad.getObject("CMD_SERVICIO") != null ? Rst_Funcionalidad.getString("CMD_SERVICIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_INICIO= Rst_Funcionalidad.getObject("TXT_FECHA_INICIO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_INICIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_FIN= Rst_Funcionalidad.getObject("TXT_FECHA_FIN") != null ? Rst_Funcionalidad.getString("TXT_FECHA_FIN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			
			
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			
			
			 switch (intOpcion) {
			 
			  case 1: //ENVIO
				  GstrBTN_ENVIAR = Rst_Funcionalidad.getObject("BTN_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR") : Mdl_Variables.Gstr_Ignore;
				  //GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
				  //GstrLNK_VER_EXPIRADOS= Rst_Funcionalidad.getObject("LNK_VER_EXPIRADOS") != null ? Rst_Funcionalidad.getString("LNK_VER_EXPIRADOS") : Mdl_Variables.Gstr_Ignore;
				  break;
			  
			  case 2: //AUTORIZAR
				  	Gstr_FIRMANTE= Rst_Funcionalidad.getObject("FIRMANTE") != null ? Rst_Funcionalidad.getString("FIRMANTE") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_AUTORIZAR= Rst_Funcionalidad.getObject("BTN_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_BLOQUEAR= Rst_Funcionalidad.getObject("BTN_BLOQUEAR") != null ? Rst_Funcionalidad.getString("BTN_BLOQUEAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_CANCELAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
					GstrCHK_TODOS= Rst_Funcionalidad.getObject("CHK_TODOS") != null ? Rst_Funcionalidad.getString("CHK_TODOS") : Mdl_Variables.Gstr_Ignore;

					break;
			  case 4: //BLOQUEADOS
				  	GstrCMB_SITUACION= Rst_Funcionalidad.getObject("CMB_SITUACION") != null ? Rst_Funcionalidad.getString("CMB_SITUACION") : Mdl_Variables.Gstr_Ignore;
					break;

			 }
			 
			 if(intOpcion==3 ||intOpcion==4){//BLOQUEADOS O PROCESADOS
				 GstrLNK_VER_DETALLE= Rst_Funcionalidad.getObject("LNK_VER_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_VER_DETALLE") : Mdl_Variables.Gstr_Ignore;
				 GstrTXT_NOMBRE_SOLICITUD= Rst_Funcionalidad.getObject("TXT_NOMBRE_SOLICITUD") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_SOLICITUD") : Mdl_Variables.Gstr_Ignore;
			 }
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
