package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ConsultaLeasingBE {
	//GENERAL

		public static String Gstr_ID_CASO;
		public static String Gstr_ID_CASO_LOGIN;
		public static String GstrTXT_MENU;
		public static String GstrTXT_SUBMENU1;
		public static String GstrCMB_EMPRESA;
		public static String GstrCMB_MONEDA;
		public static String GstrCMB_SITUACION_CREDITO;
		public static String GstrBTN_CONSULTAR;
		public static String GstrTXT_NRO_CONTRATO;
		public static String GstrLNK_ENVIAR_CORREO;
		public static String GstrLNK_EXPORTAR_EXCEL;
		public static String GstrLNK_EXPORTAR_PDF;
		public static String GstrLNK_IMPRIMIR;
		public static String GstrFIRMAR;//para realizar todo el escenario completo
		public static String GstrTXT_MENSAJE_ERROR;
		public static String GstrRESULTADO_ESPERADO;
		public static String GstrLNK_CERRAR_SESION;
		public static String GstrTXT_CLAVE;
		public static String GstrBTN_CONFIRMAR;
		public static String GstrBTN_CANCELAR_OPERACION;
		public static String GstrTXT_COLUMNA_ERROR;
		public static String GstrTXT_CORREO_POPUP;
		public static String GstrTXT_MENSAJE_POPUP;
		public static String GstrBTN_ENVIAR_CORREO_POPUP;
		
		//2.- A TERCEROS - 3.- OTROS BANCOS CCE
		public static String GstrBTN_CORREO=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
		
		//3.- OTROS BANCOS CCE - 4.- OTROS BANCOS BCR
		public static String GstrBTN_ACEPTAR=Mdl_Variables.Gstr_Ignore;
		public static String GstrCMB_TIPO_CUENTA=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_CUENTA_DESTINO=Mdl_Variables.Gstr_Ignore;
		public static String GstrCHK_EMPRESA_PROPIETARIA=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_NOMBRE_EMPRESA=Mdl_Variables.Gstr_Ignore;
		public static String GstrCMB_TIPO_DOCUMENTO_IDENTIDAD=Mdl_Variables.Gstr_Ignore;
		public static String GstrTXT_NUMERO_IDENTIDAD=Mdl_Variables.Gstr_Ignore;
		public static String GstrESTADO=Mdl_Variables.Gstr_Ignore;
		
		//4.- OTROS BANCOS BCR
		public static String GstrTXT_PROGRAMA_OPERACION=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_ACEPTAR_POP_UP=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_SI_POP_UP=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_NO_POP_UP=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_SI_POP_UP1=Mdl_Variables.Gstr_Ignore;
		public static String GstrBTN_NO_POP_UP1=Mdl_Variables.Gstr_Ignore;
		public static String GstrTOTAL_PAGAR=Mdl_Variables.Gstr_Ignore;
		public static String GstrCONSULTAR_SALDOS_MOVIMIENTOS=Mdl_Variables.Gstr_Ignore;
		
		public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
			boolean bandera = true; 
			try {
				//GENERAL
				Gstr_ID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_EMPRESA= Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_MONEDA =Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_SITUACION_CREDITO = Rst_Funcionalidad.getObject("CMB_SITUACION_CREDITO") != null ? Rst_Funcionalidad.getString("CMB_SITUACION_CREDITO") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CONSULTAR =Rst_Funcionalidad.getObject("BTN_CONSULTAR") != null ? Rst_Funcionalidad.getString("BTN_CONSULTAR") : Mdl_Variables.Gstr_Ignore;
				GstrFIRMAR= Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;				
				//--
				GstrTXT_NRO_CONTRATO =Rst_Funcionalidad.getObject("TXT_NRO_CONTRATO") != null ? Rst_Funcionalidad.getString("TXT_NRO_CONTRATO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CLAVE=Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
				
				//GENERAL OPERACION FRECUENTE
				GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_ENVIAR_CORREO = Rst_Funcionalidad.getObject("LNK_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL  = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO_POPUP = Rst_Funcionalidad.getObject("TXT_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_POPUP = Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO_POPUP = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
				GstrCONSULTAR_SALDOS_MOVIMIENTOS= Rst_Funcionalidad.getObject("CONSULTAR_SALDOS_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("CONSULTAR_SALDOS_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
			}
			return bandera;
		}
}
