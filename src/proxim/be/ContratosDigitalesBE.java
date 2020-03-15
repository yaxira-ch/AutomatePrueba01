package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ContratosDigitalesBE {

	public static String GstrID_CASO =Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOGIN =Mdl_Variables.Gstr_Ignore;
	public static String strComisionSoles=Mdl_Variables.Gstr_Ignore;
	public static String strBtnPagos=Mdl_Variables.Gstr_Ignore;
	public static String strLinkConoceMas=Mdl_Variables.Gstr_Ignore;
	public static String strBtnSolicitarModificar=Mdl_Variables.Gstr_Ignore;
	public static String GstrIND_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_NOMBRE_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_LIMITE_MONTO_POR_TRANSACCION_SI=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_MONTO_MAXIMO_SOLES_POR_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_MONTO_MAXIMO_DOLARES_POR_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE=Mdl_Variables.Gstr_Ignore;//
	public static String GstrRBT_MONTO_MAXIMO_SOLES_POR_PAGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_PAGO=Mdl_Variables.Gstr_Ignore;//
	public static String GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO=Mdl_Variables.Gstr_Ignore;//
	public static String GstrRBT_MONTO_MAXIMO_DOLARES_POR_PAGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_PAGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_LIMITE_MONTO_POR_TRANSACCION_NO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CONFIGURAR_PERMISOS_USUARIOS=Mdl_Variables.Gstr_Ignore;
	public static String strRbtConsolidarFactura=Mdl_Variables.Gstr_Ignore;
	public static String strRbtEnvioAutomatico=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_COMISION_PROVEEDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR_ACCESOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_CONFIGURACION_PERMISOS_USUARIOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA_CARGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AGREGAR_CUENTA_OTRA_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA_OTRA_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_QUITAR_CUENTA_OTRA_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_CONTACTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_TELEFONO_CONTACTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ABRIR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES="";//(FLUJO PENDIENTE)
	public static String GstrBTN_CERRAR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES="";// (FLUJO PENDIENTE)
	public static String GstrBTN_ABRIR_POPUP_SIN_FIRMAS_CONJUNTAS="";// (FLUJO PENDIENTE)
	public static String GstrBTN_CERRAR_POPUP_SIN_FIRMAS_CONJUNTAS="";// (FLUJO PENDIENTE)
	public static String GstrRBT_PODERES_LEGALES=Mdl_Variables.Gstr_Ignore;
	public static String GstrRBT_SIN_FIRMAS_CONJUNTAS=Mdl_Variables.Gstr_Ignore;
//	public static String GstrRBT_SIN_FIRMAS_CONJUNTAS_NO=Mdl_Variables.Gstr_Ignore;
//	public static String GstrRBT_PODERES_LEGALES_NO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_FIRMAR_GUARDAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_FIRMAR_ENVIAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_GUARDAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO_1=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_USUARIOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_VER_USUARIOS=Mdl_Variables.Gstr_Ignore;
	public static String strTxtComisionDolares=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_TERMINOS_CONDICIONES=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_TERMINOS_CONDICIONES=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_ACEPTO_TERMINOS_CONDICIONES=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_QUIERES_SABER_COMO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR_QUIERES_SABER_COMO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String strTxtColumnaError=Mdl_Variables.Gstr_Ignore;
	public static String strTxtMensajeError=Mdl_Variables.Gstr_Ignore;
	public static String strResultadoEsperado2=Mdl_Variables.Gstr_Ignore;
	public static String strLnkVerUsuarios2=Mdl_Variables.Gstr_Ignore;
	public static String strBtnCerrarVerUsuario2=Mdl_Variables.Gstr_Ignore;
	public static String strConsultaHistorica=Mdl_Variables.Gstr_Ignore;
	public static String strTxtNumMaxDiasCobro=Mdl_Variables.Gstr_Ignore;
	public static String strFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String strFIRMANTE1=Mdl_Variables.Gstr_Ignore;
	public static String strFIRMANTE2=Mdl_Variables.Gstr_Ignore;
	public static String strFIRMANTE3=Mdl_Variables.Gstr_Ignore;
	
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
	boolean bandera = true; 
	
	try{
	GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
	GstrID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
	strComisionSoles= Rst_Funcionalidad.getObject("TXT_COMISION_SOLES") != null ? Rst_Funcionalidad.getString("TXT_COMISION_SOLES") : Mdl_Variables.Gstr_Ignore;
	strBtnPagos= Rst_Funcionalidad.getObject("BTN_PAGOS") != null ? Rst_Funcionalidad.getString("BTN_PAGOS") : Mdl_Variables.Gstr_Ignore;
	strLinkConoceMas= Rst_Funcionalidad.getObject("LNK_CONOCE_MAS") != null ? Rst_Funcionalidad.getString("LNK_CONOCE_MAS") : Mdl_Variables.Gstr_Ignore;
	strBtnSolicitarModificar= Rst_Funcionalidad.getObject("BTN_SOLICITAR_MODIFICAR") != null ? Rst_Funcionalidad.getString("BTN_SOLICITAR_MODIFICAR") : Mdl_Variables.Gstr_Ignore;
	GstrIND_EMPRESA= Rst_Funcionalidad.getObject("IND_EMPRESA") != null ? Rst_Funcionalidad.getString("IND_EMPRESA") : Mdl_Variables.Gstr_Ignore;
	GstrCMB_NOMBRE_EMPRESA= Rst_Funcionalidad.getObject("CMB_NOMBRE_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_NOMBRE_EMPRESA") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_LIMITE_MONTO_POR_TRANSACCION_SI= Rst_Funcionalidad.getObject("RBT_LIMITE_MONTO_POR_TRANSACCION_SI") != null ? Rst_Funcionalidad.getString("RBT_LIMITE_MONTO_POR_TRANSACCION_SI") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_MAXIMO_SOLES_POR_LOTE= Rst_Funcionalidad.getObject("RBT_MONTO_MAXIMO_SOLES_POR_LOTE") != null ? Rst_Funcionalidad.getString("RBT_MONTO_MAXIMO_SOLES_POR_LOTE") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_LOTE= Rst_Funcionalidad.getObject("RBT_MONTO_SIN_LIMITE_SOLES_POR_LOTE") != null ? Rst_Funcionalidad.getString("RBT_MONTO_SIN_LIMITE_SOLES_POR_LOTE") : Mdl_Variables.Gstr_Ignore;
	//---
	GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE= Rst_Funcionalidad.getObject("TXT_MONTO_MAXIMO_SOLES_POR_LOTE") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MAXIMO_SOLES_POR_LOTE") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_MAXIMO_DOLARES_POR_LOTE= Rst_Funcionalidad.getObject("RBT_MONTO_MAXIMO_DOLARES_POR_LOTE") != null ? Rst_Funcionalidad.getString("RBT_MONTO_MAXIMO_DOLARES_POR_LOTE") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_LOTE= Rst_Funcionalidad.getObject("RBT_MONTO_SIN_LIMITE_DOLARES_POR_LOTE") != null ? Rst_Funcionalidad.getString("RBT_MONTO_SIN_LIMITE_DOLARES_POR_LOTE") : Mdl_Variables.Gstr_Ignore;
	//----
	GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE=Rst_Funcionalidad.getObject("TXT_MONTO_MAXIMO_DOLARES_POR_LOTE") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MAXIMO_DOLARES_POR_LOTE") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_MAXIMO_SOLES_POR_PAGO= Rst_Funcionalidad.getObject("RBT_MONTO_MAXIMO_SOLES_POR_PAGO") != null ? Rst_Funcionalidad.getString("RBT_MONTO_MAXIMO_SOLES_POR_PAGO") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_SIN_LIMITE_SOLES_POR_PAGO=Rst_Funcionalidad.getObject("RBT_MONTO_SIN_LIMITE_SOLES_POR_PAGO") != null ? Rst_Funcionalidad.getString("RBT_MONTO_SIN_LIMITE_SOLES_POR_PAGO") : Mdl_Variables.Gstr_Ignore;
	//----
	GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO=Rst_Funcionalidad.getObject("TXT_MONTO_MAXIMO_SOLES_POR_PAGO") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MAXIMO_SOLES_POR_PAGO") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_MAXIMO_DOLARES_POR_PAGO= Rst_Funcionalidad.getObject("RBT_MONTO_MAXIMO_DOLARES_POR_PAGO") != null ? Rst_Funcionalidad.getString("RBT_MONTO_MAXIMO_DOLARES_POR_PAGO") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_MONTO_SIN_LIMITE_DOLARES_POR_PAGO= Rst_Funcionalidad.getObject("RBT_MONTO_SIN_LIMITE_DOLARES_POR_PAGO") != null ? Rst_Funcionalidad.getString("RBT_MONTO_SIN_LIMITE_DOLARES_POR_PAGO") : Mdl_Variables.Gstr_Ignore;
	//---
	GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO= Rst_Funcionalidad.getObject("TXT_MONTO_MAXIMO_DOLARES_POR_PAGO") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MAXIMO_DOLARES_POR_PAGO") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_LIMITE_MONTO_POR_TRANSACCION_NO= Rst_Funcionalidad.getObject("RBT_LIMITE_MONTO_POR_TRANSACCION_NO") != null ? Rst_Funcionalidad.getString("RBT_LIMITE_MONTO_POR_TRANSACCION_NO") : Mdl_Variables.Gstr_Ignore;
	GstrLNK_CONFIGURAR_PERMISOS_USUARIOS= Rst_Funcionalidad.getObject("LNK_CONFIGURAR_PERMISOS_USUARIOS") != null ? Rst_Funcionalidad.getString("LNK_CONFIGURAR_PERMISOS_USUARIOS") : Mdl_Variables.Gstr_Ignore;
	strRbtConsolidarFactura= Rst_Funcionalidad.getObject("RBT_CONSOLIDAR_FACTURA") != null ? Rst_Funcionalidad.getString("RBT_CONSOLIDAR_FACTURA") : Mdl_Variables.Gstr_Ignore;
	strRbtEnvioAutomatico= Rst_Funcionalidad.getObject("RBT_ENVIO_AUTOMATICO") != null ? Rst_Funcionalidad.getString("RBT_ENVIO_AUTOMATICO") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_COMISION_PROVEEDOR= Rst_Funcionalidad.getObject("RBT_COMISION_PROVEEDOR") != null ? Rst_Funcionalidad.getString("RBT_COMISION_PROVEEDOR") : Mdl_Variables.Gstr_Ignore;	
	GstrBTN_CONFIRMAR_ACCESOS= Rst_Funcionalidad.getObject("BTN_CONFIRMAR_ACCESOS") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR_ACCESOS") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_CERRAR_CONFIGURACION_PERMISOS_USUARIOS= Rst_Funcionalidad.getObject("BTN_CERRAR_CONFIGURACION_PERMISOS_USUARIOS") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_CONFIGURACION_PERMISOS_USUARIOS") : Mdl_Variables.Gstr_Ignore;
	GstrCMB_CUENTA_CARGO= Rst_Funcionalidad.getObject("CMB_CUENTA_CARGO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_CARGO") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_AGREGAR_CUENTA_OTRA_MONEDA= Rst_Funcionalidad.getObject("BTN_AGREGAR_CUENTA_OTRA_MONEDA") != null ? Rst_Funcionalidad.getString("BTN_AGREGAR_CUENTA_OTRA_MONEDA") : Mdl_Variables.Gstr_Ignore;
	GstrCMB_CUENTA_OTRA_MONEDA= Rst_Funcionalidad.getObject("CMB_CUENTA_OTRA_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_OTRA_MONEDA") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_QUITAR_CUENTA_OTRA_MONEDA= Rst_Funcionalidad.getObject("BTN_QUITAR_CUENTA_OTRA_MONEDA") != null ? Rst_Funcionalidad.getString("BTN_QUITAR_CUENTA_OTRA_MONEDA") : Mdl_Variables.Gstr_Ignore;
	GstrTXT_CORREO_CONTACTO= Rst_Funcionalidad.getObject("TXT_CORREO_CONTACTO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_CONTACTO") : Mdl_Variables.Gstr_Ignore;
	GstrTXT_TELEFONO_CONTACTO= Rst_Funcionalidad.getObject("TXT_TELEFONO_CONTACTO") != null ? Rst_Funcionalidad.getString("TXT_TELEFONO_CONTACTO") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_ABRIR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES=Rst_Funcionalidad.getObject("BTN_ABRIR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES") != null ? Rst_Funcionalidad.getString("BTN_ABRIR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_CERRAR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES=Rst_Funcionalidad.getObject("BTN_CERRAR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_POPUP_REPRESENTANTE_LEGAL_CON_PODERES") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_ABRIR_POPUP_SIN_FIRMAS_CONJUNTAS=Rst_Funcionalidad.getObject("BTN_ABRIR_POPUP_SIN_FIRMAS_CONJUNTAS") != null ? Rst_Funcionalidad.getString("BTN_ABRIR_POPUP_SIN_FIRMAS_CONJUNTAS") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_CERRAR_POPUP_SIN_FIRMAS_CONJUNTAS=Rst_Funcionalidad.getObject("BTN_CERRAR_POPUP_SIN_FIRMAS_CONJUNTAS") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_POPUP_SIN_FIRMAS_CONJUNTAS") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_PODERES_LEGALES= Rst_Funcionalidad.getObject("RBT_PODERES_LEGALES") != null ? Rst_Funcionalidad.getString("RBT_PODERES_LEGALES") : Mdl_Variables.Gstr_Ignore;
	GstrRBT_SIN_FIRMAS_CONJUNTAS= Rst_Funcionalidad.getObject("RBT_SIN_FIRMAS_CONJUNTAS") != null ? Rst_Funcionalidad.getString("RBT_SIN_FIRMAS_CONJUNTAS") : Mdl_Variables.Gstr_Ignore;
//	GstrRBT_SIN_FIRMAS_CONJUNTAS_NO= Rst_Funcionalidad.getObject("RBT_SIN_FIRMAS_CONJUNTAS_NO") != null ? Rst_Funcionalidad.getString("RBT_SIN_FIRMAS_CONJUNTAS_NO") : Mdl_Variables.Gstr_Ignore;
//	GstrRBT_PODERES_LEGALES_NO= Rst_Funcionalidad.getObject("RBT_PODERES_LEGALES_NO") != null ? Rst_Funcionalidad.getString("RBT_PODERES_LEGALES_NO") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_FIRMAR_GUARDAR= Rst_Funcionalidad.getObject("BTN_FIRMAR_GUARDAR") != null ? Rst_Funcionalidad.getString("BTN_FIRMAR_GUARDAR") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_FIRMAR_ENVIAR= Rst_Funcionalidad.getObject("BTN_FIRMAR_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_FIRMAR_ENVIAR") : Mdl_Variables.Gstr_Ignore;	
	GstrBTN_GUARDAR= Rst_Funcionalidad.getObject("BTN_GUARDAR") != null ? Rst_Funcionalidad.getString("BTN_GUARDAR") : Mdl_Variables.Gstr_Ignore;
	GstrRESULTADO_ESPERADO_1= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO_1") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO_1") : Mdl_Variables.Gstr_Ignore;	
	GstrLNK_VER_USUARIOS= Rst_Funcionalidad.getObject("LNK_VER_USUARIOS") != null ? Rst_Funcionalidad.getString("LNK_VER_USUARIOS") : Mdl_Variables.Gstr_Ignore;	
	GstrBTN_CERRAR_VER_USUARIOS= Rst_Funcionalidad.getObject("BTN_CERRAR_VER_USUARIOS") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_VER_USUARIOS") : Mdl_Variables.Gstr_Ignore;	
	strTxtComisionDolares= Rst_Funcionalidad.getObject("TXT_COMISION_DOLARES") != null ? Rst_Funcionalidad.getString("TXT_COMISION_DOLARES") : Mdl_Variables.Gstr_Ignore;
	GstrLNK_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("LNK_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("LNK_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_CERRAR_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("BTN_CERRAR_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
	GstrCHK_ACEPTO_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("CHK_ACEPTO_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("CHK_ACEPTO_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
	GstrTXT_CLAVE= Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
	GstrTXT_CLAVE_DINAMICA= Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_CONFIRMAR= Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
	GstrBTN_CANCELAR_OPERACION=Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
	strFIRMAR=Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
	strFIRMANTE1=Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
	strFIRMANTE2=Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
	strFIRMANTE3=Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
	strTxtNumMaxDiasCobro=Rst_Funcionalidad.getObject("TXT_NUM_MAX_DIAS") != null ? Rst_Funcionalidad.getString("TXT_NUM_MAX_DIAS") : Mdl_Variables.Gstr_Ignore;
	strResultadoEsperado2=Rst_Funcionalidad.getObject("RESULTADO_ESPERADO_2") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO_2") : Mdl_Variables.Gstr_Ignore;
	strLnkVerUsuarios2=Rst_Funcionalidad.getObject("LNK_VER_USUARIOS2") != null ? Rst_Funcionalidad.getString("LNK_VER_USUARIOS2") : Mdl_Variables.Gstr_Ignore;
	strBtnCerrarVerUsuario2=Rst_Funcionalidad.getObject("BTN_CERRAR_VER_USUARIOS2") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_VER_USUARIOS2") : Mdl_Variables.Gstr_Ignore;

	
	} catch (Exception e) {
	bandera = false; 
	e.printStackTrace();
	System.out.println("Error:"  + e.getMessage());	
	}
	return bandera;
	}
	
	

}
