package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ComercioExtCartaFianzaRenovacionBE {
	public static String GstrID_CASO = "";
	public static String GstrID_CASO_LOGIN = "";
	public static String GstrID_CASO_LOTE = "";
	public static String GstrCMB_EMPRESA = "";
	public static String GstrTXT_NUMERO_CARTA_FIANZA = "";
	public static String GstrTXT_FECHA_DESDE = "";
	public static String GstrTXT_FECHA_HASTA = "";
	public static String GstrCMB_ESTADO_OPERACION = "";
	public static String GstrBTN_BUSCAR = "";
	public static String GstrRDB_CARTA_FIANZA = "";
	public static String GstrLNK_NRO_CARTA_FIANZA = "";
	public static String GstrLNK_VER = "";
	public static String GstrLNK_ENVIAR_EMAIL_DETALLE = "";
	public static String GstrTXT_CORREO_DETALLE = "";
	public static String GstrTXT_MENSAJE_CORREO_DETALLE = "";
	public static String GstrBTN_ENVIAR_CORREO_DETALLE = "";
	public static String GstrLNK_EXPORTAR_EXCEL_DETALLE = "";
	public static String GstrLNK_EXPORTAR_PDF_DETALLE = "";
	public static String GstrLNK_IMPRIMIR_DETALLE = "";
	public static String GstrLNK_REGRESAR_A_TABLA= "";
	public static String GstrBTN_CONTINUAR1 = "";
	public static String GstrTXT_NUMERO_DIAS_NUEVO = "";
	public static String GstrTXT_FECHA_HASTA_NUEVO = "";
	public static String GstrTXT_NUEVO_MONTO="";
	public static String GstrTXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO="";
	public static String GstrCMB_TIPO_DOCUMENTO_NUEVO="";
	public static String GstrTXT_NUMERO_DOCUMENTO_NUEVO="";
	public static String GstrTXT_CORREO_CONTACTO = "";
	public static String GstrBTN_CONTINUAR2 = "";
	public static String GstrIND_CLAVE = "";
	public static String GstrTXT_CLAVE_DINAMICA = "";
	public static String GstrLNK_QUIERES_SABER_COMO= "";
	public static String GstrBTN_CONFIRMAR = "";
	public static String GstrBTN_CANCELAR_OPERACION = "";
	public static String GstrLNK_REGRESAR = "";
	public static String GstrLNK_ENVIAR_EMAIL = "";
	public static String GstrTXT_CORREO = "";
	public static String GstrTXT_MENSAJE_CORREO = "";
	public static String GstrBTN_ENVIAR_CORREO = "";
	public static String GstrLNK_EXPORTAR_EXCEL = "";
	public static String GstrLNK_EXPORTAR_PDF = "";
	public static String GstrLNK_IMPRIMIR = "";
	public static String GstrLNK_CERRAR_SESION = "";
	public static String GstrESTADO= "";
	public static String GstrFIRMAR = "";
	public static String GstrFIRMANTE1 = "";
	public static String GstrFIRMANTE2 = "";
	public static String GstrFIRMANTE3 = "";
	public static String GstrCMB_TIPO_OPERACION= "";
	public static String GstrLBN_OPERACION= "";
	public static String GstrLBN_OPERACION_FECHA= "";
	public static String GstrLBN_OPERACION_HORA= "";

	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOTE= Rst_Funcionalidad.getObject("ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_CARTA_FIANZA= Rst_Funcionalidad.getObject("TXT_NUMERO_CARTA_FIANZA") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CARTA_FIANZA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_DESDE= Rst_Funcionalidad.getObject("TXT_FECHA_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_DESDE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_HASTA= Rst_Funcionalidad.getObject("TXT_FECHA_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_HASTA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_ESTADO_OPERACION= Rst_Funcionalidad.getObject("CMB_ESTADO_OPERACION") != null ? Rst_Funcionalidad.getString("CMB_ESTADO_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			GstrRDB_CARTA_FIANZA= Rst_Funcionalidad.getObject("RDB_CARTA_FIANZA") != null ? Rst_Funcionalidad.getString("RDB_CARTA_FIANZA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_NRO_CARTA_FIANZA= Rst_Funcionalidad.getObject("LNK_NRO_CARTA_FIANZA") != null ? Rst_Funcionalidad.getString("LNK_NRO_CARTA_FIANZA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER= Rst_Funcionalidad.getObject("LNK_VER") != null ? Rst_Funcionalidad.getString("LNK_VER") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL_DETALLE = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_DETALLE =Rst_Funcionalidad.getObject("TXT_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO_DETALLE = Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_DETALLE = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_DETALLE = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_DETALLE =Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_DETALLE = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR_A_TABLA= Rst_Funcionalidad.getObject("LNK_REGRESAR_A_TABLA") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_A_TABLA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR1= Rst_Funcionalidad.getObject("BTN_CONTINUAR1") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR1") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_DIAS_NUEVO= Rst_Funcionalidad.getObject("TXT_NUMERO_DIAS_NUEVO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_DIAS_NUEVO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_HASTA_NUEVO= Rst_Funcionalidad.getObject("TXT_FECHA_HASTA_NUEVO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_HASTA_NUEVO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUEVO_MONTO= Rst_Funcionalidad.getObject("TXT_NUEVO_MONTO") != null ? Rst_Funcionalidad.getString("TXT_NUEVO_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO= Rst_Funcionalidad.getObject("TXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_PERSONA_RESPONSABLE_NUEVO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_DOCUMENTO_NUEVO= Rst_Funcionalidad.getObject("CMB_TIPO_DOCUMENTO_NUEVO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO_NUEVO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_DOCUMENTO_NUEVO= Rst_Funcionalidad.getObject("TXT_NUMERO_DOCUMENTO_NUEVO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_DOCUMENTO_NUEVO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_CONTACTO= Rst_Funcionalidad.getObject("TXT_CORREO_CONTACTO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_CONTACTO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR2= Rst_Funcionalidad.getObject("BTN_CONTINUAR2") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR2") : Mdl_Variables.Gstr_Ignore;
			GstrIND_CLAVE= Rst_Funcionalidad.getObject("IND_CLAVE") != null ? Rst_Funcionalidad.getString("IND_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA= Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_QUIERES_SABER_COMO= Rst_Funcionalidad.getObject("LNK_QUIERES_SABER_COMO") != null ? Rst_Funcionalidad.getString("LNK_QUIERES_SABER_COMO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR= Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CANCELAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR= Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMAR= Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE1= Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE2= Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE3= Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_OPERACION= Rst_Funcionalidad.getObject("CMB_TIPO_OPERACION") != null ? Rst_Funcionalidad.getString("CMB_TIPO_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION= Rst_Funcionalidad.getObject("LBN_OPERACION") != null ? Rst_Funcionalidad.getString("LBN_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION_FECHA= Rst_Funcionalidad.getObject("LBN_OPERACION_FECHA") != null ? Rst_Funcionalidad.getString("LBN_OPERACION_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION_HORA= Rst_Funcionalidad.getObject("LBN_OPERACION_HORA") != null ? Rst_Funcionalidad.getString("LBN_OPERACION_HORA") : Mdl_Variables.Gstr_Ignore;
					
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		return bandera;
	}
}