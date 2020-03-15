package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PagosMasivosAdministracionAfiliadosBE {
	public static String strIdCaso;
	public static String strIdCasoLogin;
	public static String strNumAfiliados;
	public static String strTxtMenu;
	public static String strTxtSubMenu;
	public static String strTxtSubMenu1;
	public static String strCmbProducto;
	public static String strCmbServicio;
	public static String strTxtDescripcion;
	public static String strCmbEmpresa;
	public static String GstrCMB_TIPO_CARGA;
	public static String GstrBTN_RUTA_ARCHIVO;
	public static String GstrBTN_CONTINUAR_REG;
	public static String GstrBTN_CONTINUAR;
	public static String GstrBTN_AGREGAR;
	public static String GstrBTN_ACEPTAR;
	public static String GstrBTN_CANCELAR;
	public static String GstrBTN_AGREGAR_NUEVA;
	public static String GstrBTN_GUARDARFINAL;
	public static String GstrBTN_CERRAR_LOTE;
	public static String GstrENVIO_AFILIADOS;
	public static String GstrTXT_CLAVE ;

	//Administración de Pagos
	public static String GstrCMB_CUENTA_CARGO;
	public static String GstrCMB_TIPO_PROCESO;
	public static String GstrTXT_FECHA_DIFERIDO;
	public static String GstrTXT_LIMPIAR_CAMPO;
	public static String GstrENVIO_LOTE;
	public static String GstrBTN_ENVIAR;
	public static String strSoloFirma;
	public static String GstrCONSULTAR_SALDOS_MOVIMIENTOS;
	public static String GstrTXT_CLAVE_DINAMICA;
	public static String GstrBTN_CONFIRMAR;
	public static String GstrBTN_CANCELAR_OPERACION;
	public static String GstrFIRMAR;
	public static String GstrLNK_CERRAR_SESION;
	public static String GstrBTN_SI_POP_UP;
	public static String GstrBTN_NO_POP_UP;
	public static String GstrBTN_ACEPTAR_POP_UP;
	public static String GstrRESULTADO_ESPERADO;
	public static String GstrTXT_COLUMNA_ERROR;
	public static String GstrTXT_MENSAJE_ERROR;
	public static String GstrFIRMANTE1;
	public static String GstrFIRMANTE2;
	public static String GstrFIRMANTE3;
	public static String GstrESTADO;

	public static String GstrCONSULTAR;
	public static String GstrACCION;
	public static String GstrBTN_BUSCAR;
	public static String GstrBTN_OPCION_AVANZADA;
	public static String GstrLNK_ENVIAR_CORREO;
	public static String GstrLNK_EXPORTAR_EXCEL;
	public static String GstrLNK_EXPORTAR_PDF;
	public static String GstrLNK_IMPRIMIR;
	public static String GstrTXT_CORREO;
	public static String GstrTXT_MENSAJE;
	public static String GstrBTN_ENVIAR_CORREO;
	public static String GstrOPERADOR;
	
	public static String GstrCMB_CANAL_ENVIO;
	public static String GstrLNK_VER_EXPIRADOS;
	public static String GstrLBL_MONTO_DOLARES;
	public static String GstrLBL_MONTO_SOLES;
	public static String GstrMONTO_DOLARES_PAGAR;
	public static String GstrMONTO_SOLES_PAGAR;
	public static String GstrCONSULTA_PAGOS_REALIZADOS;
	public static String GstrLBL_FECHA_OPERACION;
	public static String GstrLBL_HORA_OPERACION;
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
		boolean bandera = true; 
		try {
			strIdCaso=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			strIdCasoLogin=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			strNumAfiliados=Rst_Funcionalidad.getObject("NUM_AFILIADOS") != null ? Rst_Funcionalidad.getString("NUM_AFILIADOS") : Mdl_Variables.Gstr_Ignore;
			strTxtMenu = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			strTxtSubMenu = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			strTxtSubMenu1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			strCmbEmpresa = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			strCmbProducto = Rst_Funcionalidad.getObject("CMB_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMB_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
			strCmbServicio = Rst_Funcionalidad.getObject("CMB_SERVICIO") != null ? Rst_Funcionalidad.getString("CMB_SERVICIO") : Mdl_Variables.Gstr_Ignore;
			strTxtDescripcion = Rst_Funcionalidad.getObject("TXT_DESCRIPCION") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_CARGA =Rst_Funcionalidad.getObject("CMB_TIPO_CARGA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CARGA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_RUTA_ARCHIVO =Rst_Funcionalidad.getObject("BTN_RUTA_ARCHIVO") != null ? Rst_Funcionalidad.getString("BTN_RUTA_ARCHIVO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AGREGAR = Rst_Funcionalidad.getObject("BTN_AGREGAR") != null ? Rst_Funcionalidad.getString("BTN_AGREGAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR_REG =Rst_Funcionalidad.getObject("BTN_CONTINUAR_REG") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR_REG") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AGREGAR_NUEVA = Rst_Funcionalidad.getObject("BTN_AGREGAR_NUEVA") != null ? Rst_Funcionalidad.getString("BTN_AGREGAR_NUEVA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_GUARDARFINAL = Rst_Funcionalidad.getObject("BTN_GUARDAR_FINAL") != null ? Rst_Funcionalidad.getString("BTN_GUARDAR_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR = Rst_Funcionalidad.getObject("BTN_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;				  
			GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO = Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR = Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR = Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE1 = Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE2 = Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE3 = Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
			 
			 switch (intOpcion) {

			 case 1: //Administración de Afiliados
				 GstrENVIO_AFILIADOS= Rst_Funcionalidad.getObject("ENVIO_AFILIADOS") != null ? Rst_Funcionalidad.getString("ENVIO_AFILIADOS") : Mdl_Variables.Gstr_Ignore;
				 GstrBTN_SI_POP_UP= Rst_Funcionalidad.getObject("BTN_SI_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP") : Mdl_Variables.Gstr_Ignore;
				 GstrBTN_NO_POP_UP= Rst_Funcionalidad.getObject("BTN_NO_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP") : Mdl_Variables.Gstr_Ignore;
				 GstrBTN_ACEPTAR_POP_UP= Rst_Funcionalidad.getObject("BTN_ACEPTAR_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_POP_UP") : Mdl_Variables.Gstr_Ignore;
				 GstrCONSULTAR= Rst_Funcionalidad.getObject("CONSULTAR") != null ? Rst_Funcionalidad.getString("CONSULTAR") : Mdl_Variables.Gstr_Ignore;
				 GstrACCION= Rst_Funcionalidad.getObject("ACCION") != null ? Rst_Funcionalidad.getString("ACCION") : Mdl_Variables.Gstr_Ignore;
				 GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				 GstrBTN_OPCION_AVANZADA= Rst_Funcionalidad.getObject("BTN_OPCION_AVANZADA") != null ? Rst_Funcionalidad.getString("BTN_OPCION_AVANZADA") : Mdl_Variables.Gstr_Ignore;
				
				GstrLNK_ENVIAR_CORREO= Rst_Funcionalidad.getObject("LNK_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE= Rst_Funcionalidad.getObject("TXT_MENSAJE") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				
				 
				 break;
			
			  case 2: //Administración de Pagos 
				  GstrBTN_CONTINUAR =Rst_Funcionalidad.getObject("BTN_CONTINUAR") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_LIMPIAR_CAMPO =Rst_Funcionalidad.getObject("TXT_LIMPIAR_CAMPO") != null ? Rst_Funcionalidad.getString("TXT_LIMPIAR_CAMPO") : Mdl_Variables.Gstr_Ignore;
				  strSoloFirma= Rst_Funcionalidad.getObject("SOLO_FIRMA") != null ? Rst_Funcionalidad.getString("SOLO_FIRMA") : Mdl_Variables.Gstr_Ignore;
				  GstrCONSULTAR_SALDOS_MOVIMIENTOS= Rst_Funcionalidad.getObject("CONSULTAR_SALDOS_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("CONSULTAR_SALDOS_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
				  GstrBTN_ACEPTAR= Rst_Funcionalidad.getObject("BTN_ACEPTAR") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR") : Mdl_Variables.Gstr_Ignore;
				  GstrBTN_CANCELAR= Rst_Funcionalidad.getObject("BTN_CANCELAR") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_CUENTA_CARGO = Rst_Funcionalidad.getObject("CMB_CUENTA_CARGO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_CARGO") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_TIPO_PROCESO = Rst_Funcionalidad.getObject("CMB_TIPO_PROCESO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_PROCESO") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_FECHA_DIFERIDO = Rst_Funcionalidad.getObject("TXT_FECHA_DIFERIDO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_DIFERIDO") : Mdl_Variables.Gstr_Ignore;
				  GstrENVIO_LOTE = Rst_Funcionalidad.getObject("ENVIO_LOTE") != null ? Rst_Funcionalidad.getString("ENVIO_LOTE") : Mdl_Variables.Gstr_Ignore;
				  GstrFIRMAR = Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
				  GstrBTN_CERRAR_LOTE = Rst_Funcionalidad.getObject("BTN_CERRAR_LOTE") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_LOTE") : Mdl_Variables.Gstr_Ignore;
				  GstrESTADO = Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
				  GstrOPERADOR= Rst_Funcionalidad.getObject("OPERADOR") != null ? Rst_Funcionalidad.getString("OPERADOR") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_CANAL_ENVIO = Rst_Funcionalidad.getObject("CMB_CANAL_ENVIO") != null ? Rst_Funcionalidad.getString("CMB_CANAL_ENVIO") : Mdl_Variables.Gstr_Ignore;
				  
				  GstrLNK_ENVIAR_CORREO= Rst_Funcionalidad.getObject("LNK_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				  GstrLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
				  GstrLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
				  GstrLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_MENSAJE= Rst_Funcionalidad.getObject("TXT_MENSAJE") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE") : Mdl_Variables.Gstr_Ignore;
				  GstrBTN_ENVIAR_CORREO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
				  GstrLNK_VER_EXPIRADOS= Rst_Funcionalidad.getObject("LNK_VER_EXPIRADOS") != null ? Rst_Funcionalidad.getString("LNK_VER_EXPIRADOS") : Mdl_Variables.Gstr_Ignore;
				  GstrCONSULTA_PAGOS_REALIZADOS= Rst_Funcionalidad.getObject("CONSULTA_PAGOS_REALIZADOS") != null ? Rst_Funcionalidad.getString("CONSULTA_PAGOS_REALIZADOS") : Mdl_Variables.Gstr_Ignore;
				  Mdl_Variables.GstrTotalPagar= Rst_Funcionalidad.getObject("LBN_MONTO_TOTAL") != null ? Rst_Funcionalidad.getString("LBN_MONTO_TOTAL") : Mdl_Variables.Gstr_Ignore;
				  GstrMONTO_DOLARES_PAGAR= Rst_Funcionalidad.getObject("LBL_MONTO_DOLARES") != null ? Rst_Funcionalidad.getString("LBL_MONTO_DOLARES") : Mdl_Variables.Gstr_Ignore;
				  GstrMONTO_SOLES_PAGAR= Rst_Funcionalidad.getObject("LBL_MONTO_SOLES") != null ? Rst_Funcionalidad.getString("LBL_MONTO_SOLES") : Mdl_Variables.Gstr_Ignore;
				  break;
			 }	
			 
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}

