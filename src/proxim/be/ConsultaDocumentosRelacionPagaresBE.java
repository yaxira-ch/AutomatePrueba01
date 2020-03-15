package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ConsultaDocumentosRelacionPagaresBE {

	// principal
	public static String strID_CASO =Mdl_Variables.Gstr_Ignore;
	public static String strID_CASO_LOGIN =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_MENU =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_SUBMENU =Mdl_Variables.Gstr_Ignore;
	public static String strCMB_EMPRESA =Mdl_Variables.Gstr_Ignore;
	public static String strCMB_MONEDA =Mdl_Variables.Gstr_Ignore;
	public static String strCMB_SITUACION =Mdl_Variables.Gstr_Ignore;
	public static String strBTN_BUSCAR =Mdl_Variables.Gstr_Ignore;
	public static String strCOMPARAR_DATOS =Mdl_Variables.Gstr_Ignore;
	public static String strGUARDAR_RESULTADO =Mdl_Variables.Gstr_Ignore;
	public static String strLNK_EXPORTAR_PDF =Mdl_Variables.Gstr_Ignore;
	public static String strLNK_EXPORTAR_EXCEL =Mdl_Variables.Gstr_Ignore;
	public static String strLNK_IMPRIMIR =Mdl_Variables.Gstr_Ignore;
	public static String strLNK_ENVIAR_EMAIL =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_EMAIL =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_MENSAJE_EMAIL =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_COLUMNA_ERROR =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_MENSAJE_ERROR =Mdl_Variables.Gstr_Ignore;
	public static String strLNK_CERRAR_SESION =Mdl_Variables.Gstr_Ignore;
	public static String strDESIGN_STEPS =Mdl_Variables.Gstr_Ignore;
	public static String strDESCRIPTION =Mdl_Variables.Gstr_Ignore;
	public static String strESTADO_CASO =Mdl_Variables.Gstr_Ignore;
	public static String strUTILIZADO =Mdl_Variables.Gstr_Ignore;
	public static String strACIERTO_ERROR =Mdl_Variables.Gstr_Ignore;
	public static String strEJECUCION_AC_ERR =Mdl_Variables.Gstr_Ignore;
	public static String strHORA =Mdl_Variables.Gstr_Ignore;
	public static String strTIEMPO_EJECUCION_CASO =Mdl_Variables.Gstr_Ignore;

	//Detalle
	public static String strID_CASO_DETALLE =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_NUMERO_DOCUMENTO =Mdl_Variables.Gstr_Ignore;
	public static String strFECHA_HORA =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_DESCRIPCION =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_MONEDA =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_FECHA_INGRESO =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_FECHA_VENCIMIENTO =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_SALDO =Mdl_Variables.Gstr_Ignore;
	public static String strTXT_SITUACION =Mdl_Variables.Gstr_Ignore;
	public static String strOBSERVACION =Mdl_Variables.Gstr_Ignore;

	//Detalle nuevos registros
	public static String strNRO_REGISTRO =Mdl_Variables.Gstr_Ignore;


	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
		boolean bandera = true; 
		try {
			
			 switch (intOpcion) {
			 case 1: //Principal	 
				strID_CASO= Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				strID_CASO_LOGIN= Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				strTXT_MENU= Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				strTXT_SUBMENU= Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
				strCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				strCMB_MONEDA= Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				strCMB_SITUACION= Rst_Funcionalidad.getObject("CMB_SITUACION") != null ? Rst_Funcionalidad.getString("CMB_SITUACION") : Mdl_Variables.Gstr_Ignore;
				strBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				strCOMPARAR_DATOS= Rst_Funcionalidad.getObject("COMPARAR_DATOS") != null ? Rst_Funcionalidad.getString("COMPARAR_DATOS") : Mdl_Variables.Gstr_Ignore;
				strGUARDAR_RESULTADO= Rst_Funcionalidad.getObject("GUARDAR_RESULTADO") != null ? Rst_Funcionalidad.getString("GUARDAR_RESULTADO") : Mdl_Variables.Gstr_Ignore;
				strLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				strLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				strLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
				strLNK_ENVIAR_EMAIL= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
				strTXT_EMAIL= Rst_Funcionalidad.getObject("TXT_EMAIL") != null ? Rst_Funcionalidad.getString("TXT_EMAIL") : Mdl_Variables.Gstr_Ignore;
				strTXT_MENSAJE_EMAIL= Rst_Funcionalidad.getObject("TXT_MENSAJE_EMAIL") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_EMAIL") : Mdl_Variables.Gstr_Ignore;
				strTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				strTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				strLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
				strDESIGN_STEPS= Rst_Funcionalidad.getObject("DESIGN_STEPS") != null ? Rst_Funcionalidad.getString("DESIGN_STEPS") : Mdl_Variables.Gstr_Ignore;
				strDESCRIPTION= Rst_Funcionalidad.getObject("DESCRIPTION") != null ? Rst_Funcionalidad.getString("DESCRIPTION") : Mdl_Variables.Gstr_Ignore;
				strESTADO_CASO= Rst_Funcionalidad.getObject("ESTADO_CASO") != null ? Rst_Funcionalidad.getString("ESTADO_CASO") : Mdl_Variables.Gstr_Ignore;
				strUTILIZADO= Rst_Funcionalidad.getObject("UTILIZADO") != null ? Rst_Funcionalidad.getString("UTILIZADO") : Mdl_Variables.Gstr_Ignore;
				strACIERTO_ERROR= Rst_Funcionalidad.getObject("ACIERTO_ERROR") != null ? Rst_Funcionalidad.getString("ACIERTO_ERROR") : Mdl_Variables.Gstr_Ignore;
				strEJECUCION_AC_ERR= Rst_Funcionalidad.getObject("EJECUCION_AC_ERR") != null ? Rst_Funcionalidad.getString("EJECUCION_AC_ERR") : Mdl_Variables.Gstr_Ignore;
				strHORA= Rst_Funcionalidad.getObject("HORA") != null ? Rst_Funcionalidad.getString("HORA") : Mdl_Variables.Gstr_Ignore;
				strTIEMPO_EJECUCION_CASO= Rst_Funcionalidad.getObject("TIEMPO_EJECUCION_CASO") != null ? Rst_Funcionalidad.getString("TIEMPO_EJECUCION_CASO") : Mdl_Variables.Gstr_Ignore;
				break;
			 case 2: // DETALLE A COMPARAR
				 strID_CASO= Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				 strID_CASO_DETALLE= Rst_Funcionalidad.getObject("ID_CASO_DETALLE") != null ? Rst_Funcionalidad.getString("ID_CASO_DETALLE") : Mdl_Variables.Gstr_Ignore;
				 strTXT_NUMERO_DOCUMENTO= Rst_Funcionalidad.getObject("TXT_NUMERO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_DESCRIPCION= Rst_Funcionalidad.getObject("TXT_DESCRIPCION") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION") : Mdl_Variables.Gstr_Ignore;
				 strTXT_MONEDA= Rst_Funcionalidad.getObject("TXT_MONEDA") != null ? Rst_Funcionalidad.getString("TXT_MONEDA") : Mdl_Variables.Gstr_Ignore;
				 strTXT_FECHA_INGRESO= Rst_Funcionalidad.getObject("TXT_FECHA_INGRESO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_INGRESO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_FECHA_VENCIMIENTO= Rst_Funcionalidad.getObject("TXT_FECHA_VENCIMIENTO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_VENCIMIENTO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_SALDO= Rst_Funcionalidad.getObject("TXT_SALDO") != null ? Rst_Funcionalidad.getString("TXT_SALDO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_SITUACION= Rst_Funcionalidad.getObject("TXT_SITUACION") != null ? Rst_Funcionalidad.getString("TXT_SITUACION") : Mdl_Variables.Gstr_Ignore;
				 strOBSERVACION= Rst_Funcionalidad.getObject("OBSERVACION") != null ? Rst_Funcionalidad.getString("OBSERVACION") : Mdl_Variables.Gstr_Ignore;
				break;
			 case 3: // DETALLE GUARDADO
				 strID_CASO= Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				 strNRO_REGISTRO= Rst_Funcionalidad.getObject("NRO_REGISTRO") != null ? Rst_Funcionalidad.getString("NRO_REGISTRO") : Mdl_Variables.Gstr_Ignore;
				 strFECHA_HORA= Rst_Funcionalidad.getObject("FECHA_HORA") != null ? Rst_Funcionalidad.getString("FECHA_HORA") : Mdl_Variables.Gstr_Ignore;
				 strTXT_NUMERO_DOCUMENTO= Rst_Funcionalidad.getObject("TXT_NUMERO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_DESCRIPCION= Rst_Funcionalidad.getObject("TXT_DESCRIPCION") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION") : Mdl_Variables.Gstr_Ignore;
				 strTXT_MONEDA= Rst_Funcionalidad.getObject("TXT_MONEDA") != null ? Rst_Funcionalidad.getString("TXT_MONEDA") : Mdl_Variables.Gstr_Ignore;
				 strTXT_FECHA_INGRESO= Rst_Funcionalidad.getObject("TXT_FECHA_INGRESO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_INGRESO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_FECHA_VENCIMIENTO= Rst_Funcionalidad.getObject("TXT_FECHA_VENCIMIENTO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_VENCIMIENTO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_SALDO= Rst_Funcionalidad.getObject("TXT_SALDO") != null ? Rst_Funcionalidad.getString("TXT_SALDO") : Mdl_Variables.Gstr_Ignore;
				 strTXT_SITUACION= Rst_Funcionalidad.getObject("TXT_SITUACION") != null ? Rst_Funcionalidad.getString("TXT_SITUACION") : Mdl_Variables.Gstr_Ignore;
	
			 }	
			 
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}