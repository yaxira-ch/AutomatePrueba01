package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ConsultaRecaudacionBE {
	public static String GstrID_CASO = Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1 = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_SERVICIO = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_CONSULTA = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_FILTAR_POR = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CODIGO_DEUDOR = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_DEUDOR = Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_DEUDOR = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_PAGO_DESDE = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_PAGO_HASTA = Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_NUMERO_OPERACION = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_TEXTO_DETALLE= Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_DETALLE = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO = Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO = Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_TEXTO= Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR = Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR = Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR = Mdl_Variables.Gstr_Ignore;
	 public static String GstrLNK_ENVIAR_EMAIL_TOTAL_DIAS  = Mdl_Variables.Gstr_Ignore;
	 public static String GstrTXT_CORREO_TOTAL_DIAS = Mdl_Variables.Gstr_Ignore;
	 public static String GstrTXT_MENSAJE_CORREO_TOTAL_DIAS = Mdl_Variables.Gstr_Ignore;
	 public static String GstrBTN_ENVIAR_CORREO_TOTAL_DIAS = Mdl_Variables.Gstr_Ignore;
	 public static String GstrBTN_ACEPTAR_CORREO_TOTAL_DIAS = Mdl_Variables.Gstr_Ignore;
	 public static String GstrLNK_EXPORTAR_EXCEL_TOTAL_DIAS = Mdl_Variables.Gstr_Ignore;
	 public static String GstrLNK_EXPORTAR_PDF_TOTAL_DIAS = Mdl_Variables.Gstr_Ignore;
	 public static String GstrLNK_IMPRIMIR_TOTAL_DIAS  = Mdl_Variables.Gstr_Ignore;
	 public static String GstrLNK_REGRESAR_DETALLE= Mdl_Variables.Gstr_Ignore;
	 public static String GstrRECORRER_PAGINACION= Mdl_Variables.Gstr_Ignore;

		public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad,int valor){
			boolean bandera = true; 
			
			try{
				if(valor==1){
					GstrID_CASO= Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
					GstrID_CASO_LOGIN= Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENU= Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_SUBMENU= Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_SUBMENU1= Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_SERVICIO= Rst_Funcionalidad.getObject("CMB_TIPO_SERVICIO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_SERVICIO") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_CONSULTA= Rst_Funcionalidad.getObject("CMB_TIPO_CONSULTA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CONSULTA") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_FILTAR_POR= Rst_Funcionalidad.getObject("CMB_FILTAR_POR") != null ? Rst_Funcionalidad.getString("CMB_FILTAR_POR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CODIGO_DEUDOR= Rst_Funcionalidad.getObject("TXT_CODIGO_DEUDOR") != null ? Rst_Funcionalidad.getString("TXT_CODIGO_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NOMBRE_DEUDOR= Rst_Funcionalidad.getObject("TXT_CODIGO_DEUDOR") != null ? Rst_Funcionalidad.getString("TXT_CODIGO_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_DEUDOR= Rst_Funcionalidad.getObject("CMB_DEUDOR") != null ? Rst_Funcionalidad.getString("CMB_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_FECHA_PAGO_DESDE= Rst_Funcionalidad.getObject("TXT_FECHA_PAGO_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_PAGO_DESDE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_FECHA_PAGO_HASTA= Rst_Funcionalidad.getObject("TXT_FECHA_PAGO_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_PAGO_HASTA") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_NUMERO_OPERACION= Rst_Funcionalidad.getObject("LNK_NUMERO_OPERACION") != null ? Rst_Funcionalidad.getString("LNK_NUMERO_OPERACION") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_REGRESAR= Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_EMAIL_DETALLE= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CORREO_DETALLE= Rst_Funcionalidad.getObject("TXT_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_CORREO_DETALLE= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ENVIAR_CORREO_DETALLE= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ACEPTAR_CORREO_DETALLE= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_TEXTO_DETALLE = Rst_Funcionalidad.getObject("LNK_ENVIAR_TEXTO_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_TEXTO_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_EXCEL_DETALLE= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_PDF_DETALLE= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_IMPRIMIR_DETALLE= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_EMAIL= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ACEPTAR_CORREO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_TEXTO = Rst_Funcionalidad.getObject("LNK_ENVIAR_TEXTO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_TEXTO") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_EMAIL_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ENVIAR_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ACEPTAR_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_EXCEL_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_PDF_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_IMPRIMIR_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_REGRESAR_DETALLE= Rst_Funcionalidad.getObject("LNK_REGRESAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrRECORRER_PAGINACION= Rst_Funcionalidad.getObject("RECORRER_PAGINACION") != null ? Rst_Funcionalidad.getString("RECORRER_PAGINACION") : Mdl_Variables.Gstr_Ignore;
					
					
				}else {
					GstrTXT_MENU="Consultas";
					GstrTXT_SUBMENU="Recaudación";
					GstrTXT_SUBMENU1=PagosRecibosBE.GstrTAB_CONSULTA_RECUDACION;
					GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("LST_EMPRESA") != null ? Rst_Funcionalidad.getString("LST_EMPRESA") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_SERVICIO= Rst_Funcionalidad.getObject("CMB_SERVICIO_RECAUDACION") != null ? Rst_Funcionalidad.getString("CMB_SERVICIO_RECAUDACION") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_CONSULTA= Rst_Funcionalidad.getObject("CMB_TIPO_CONSULTA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CONSULTA") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_FILTAR_POR = Rst_Funcionalidad.getObject("CMB_FILTRADO_POR") != null ? Rst_Funcionalidad.getString("CMB_FILTRADO_POR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CODIGO_DEUDOR= Rst_Funcionalidad.getObject("TXT_CODIGO_DEUDOR") != null ? Rst_Funcionalidad.getString("TXT_CODIGO_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NOMBRE_DEUDOR= Rst_Funcionalidad.getObject("TXT_NOMBRE_DEUDOR") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_DEUDOR = Rst_Funcionalidad.getObject("CMB_DEUDOR") != null ? Rst_Funcionalidad.getString("CMB_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_FECHA_PAGO_DESDE= Rst_Funcionalidad.getObject("TXT_FECHA_PAGO_DESDE") != null ? Rst_Funcionalidad.getString("TXT_FECHA_PAGO_DESDE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_FECHA_PAGO_HASTA= Rst_Funcionalidad.getObject("TXT_FECHA_PAGO_HASTA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_PAGO_HASTA") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR_CONSULTA") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR_CONSULTA") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_CON_HIS") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO_CON_HIS") != null ? Rst_Funcionalidad.getString("TXT_CORREO_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_CON_HIS") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_CON_HIS") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ACEPTAR_CORREO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_CON_HIS") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_TEXTO = Rst_Funcionalidad.getObject("LNK_ENVIAR_TEXTO_CON_HIS") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_TEXTO_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_EXCEL = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_CON_HIS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_CON_HIS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_CON_HIS") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_CON_HIS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_EMAIL_DETALLE = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_CH_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CORREO_DETALLE= Rst_Funcionalidad.getObject("TXT_CORREO_CH_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_CORREO_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_CORREO_DETALLE= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_CH_DETALLE") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ENVIAR_CORREO_DETALLE= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_CH_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ACEPTAR_CORREO_DETALLE= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_CH_DETALLE") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_EXCEL_DETALLE = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_CH_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_PDF_DETALLE = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_CH_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_IMPRIMIR_DETALLE = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_CH_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_CH_DETALLE") : Mdl_Variables.Gstr_Ignore;
					//------------------GstrLNK_NUMERO_OPERACION= Rst_Funcionalidad.getObject("BUSCAR_DEUDOR") != null ? Rst_Funcionalidad.getString("BUSCAR_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					//------------------GstrLNK_NUMERO_OPERACION= Rst_Funcionalidad.getObject("LNK_NUMERO_OPERACION") != null ? Rst_Funcionalidad.getString("LNK_NUMERO_OPERACION") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_REGRESAR= Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_REGRESAR_DETALLE= Rst_Funcionalidad.getObject("LNK_REGRESAR_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_DETALLE") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_ENVIAR_EMAIL_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("TXT_CORREO_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("TXT_CORREO_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ENVIAR_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ACEPTAR_CORREO_TOTAL_DIAS= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CORREO_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CORREO_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_EXCEL_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_EXPORTAR_PDF_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_IMPRIMIR_TOTAL_DIAS = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_TOTAL_DIAS") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_TOTAL_DIAS") : Mdl_Variables.Gstr_Ignore;
					GstrLNK_NUMERO_OPERACION=PagosRecibosDetalleBE.GstrTXT_CODIGO_DEUDOR;
				}
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());			
			}
			return bandera;
		}
	}

