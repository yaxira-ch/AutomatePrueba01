package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class TransferenciasExteriorBE {
	
	public static String GstrID_CASO = "";
	public static String GstrID_CASO_LOGIN = "";
	public static String GstrTXT_SUBMENU1;
	public static String GstrBTN_IR_AUTORIZAR;
	public static String GstrBTN_IR_CONSULTAR;
	public static String GstrIND_EMPRESA= "";
	public static String GstrTXT_NOMBRE_ORDENANTE= "";
	public static String GstrTXT_DIRECCION_ORDENANTE= "";
	public static String GstrTXT_TELEFONO_ORDENANTE= "";
	public static String GstrTXT_EMAIL_ORDENANTE= "";
	public static String GstrCMB_MONEDA= "";
	public static String GstrTXT_MONTO= "";
	public static String GstrCMB_CUENTA_CARGO= "";
	public static String GstrCHK_TICKET= "";
	public static String GstrIND_TIENE_TICKET= "";
	public static String GstrTXT_NUMERO_TICKET= "";
	public static String GstrTXT_FECHA_CARGO= "";
	public static String GstrCMB_TIPO_DOCUMENTO_BENEFICIARIO= "";
	public static String GstrTXT_NUMERO_DOCUMENTO_BENEFICIARIO= "";
	public static String GstrTXT_NOMBRE_BENEFICIARIO= "";
	public static String GstrTXT_DIRECCION_BENEFICIARIO= "";
	public static String GstrCMB_PAIS_BENEFICIARIO= "";
	public static String GstrBTN_CERRAR_POPUP_PAIS= "";
	public static String GstrLBL_MENSAJE_PAIS= "";
	public static String GstrTXT_CIUDAD_BENEFICIARIO= "";
	public static String GstrTXT_TELEFONO_BENEFICIARIO= "";
	public static String GstrTXT_CUENTA_ABONO= "";
	public static String GstrTXT_NOMBRE_BANCO= "";
	public static String GstrCMB_PAIS_BANCO= "";
	public static String GstrTXT_CIUDAD_BANCO= "";
	public static String GstrCMB_TIPO_CODIGO_BANCO= "";
	public static String GstrTXT_CODIGO_BANCO= "";
	public static String GstrCHK_BANCO_INTERMEDIARIO= "";
	public static String GstrTXT_NOMBRE_BANCO_INTERMEDIARIO= "";
	public static String GstrCMB_PAIS_BANCO_INTERMEDIARIO= "";
	public static String GstrTXT_CIUDAD_BANCO_INTERMEDIARIO= "";
	public static String GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO= "";
	public static String GstrTXT_CODIGO_BANCO_INTERMEDIARIO= "";
	public static String GstrCMB_MOTIVO_TRANSFERENCIA= "";
	public static String GstrCMB_GASTOS_CORRESPONSAL= "";
	public static String GstrTXT_DETALLE_PAGO= "";
	public static String GstrTXT_MENSAJE_ERROR= "";
	public static String GstrTXT_COLUMNA_ERROR= "";	
	public static String GstrBTN_GUARDAR= "";
	public static String GstrBTN_ENVIAR= "";
	public static String GstrLBL_TIPO_CAMBIO= "";
	public static String GstrRESULTADO_ESPERADO_1= "";
	public static String GstrLBL_MENSAJE1= "";
	public static String GstrLBL_MENSAJE2= "";
	public static String GstrLBL_MENSAJE3= "";
	public static String GstrLBL_MENSAJE4= "";
	public static String GstrLNK_TERMINOS_CONDICIONES= "";
	public static String GstrBTN_CERRAR_TERMINOS_CONDICIONES= "";
	public static String GstrCHK_ACEPTO_TERMINOS_CONDICIONES= "";
	public static String GstrTXT_CLAVE= "";//para validaciones de clave adicionales
	public static String GstrTXT_CLAVE_DINAMICA= "";
	public static String GstrLNK_QUIERES_SABER_COMO= "";
	public static String GstrBTN_CERRAR_QUIERES_SABER_COMO= "";
	public static String GstrBTN_CONFIRMAR= "";
	public static String GstrBTN_CANCELAR_OPERACION= "";
	public static String GstrRESULTADO_ESPERADO_2= "";	
	public static String GstrLNK_REALIZAR_OTRA_TRANSFERENCIA= "";
	public static String GstrLNK_ENVIAR_EMAIL= "";
	public static String GstrTXT_CORREO_POPUP= "";
	public static String GstrTXT_MENSAJE_POPUP= "";
	public static String GstrBTN_ENVIAR_CORREO_POPUP= "";
	public static String GstrLNK_EXPORTAR_EXCEL= "";
	public static String GstrLNK_EXPORTAR_PDF= "";
	public static String GstrLNK_IMPRIMIR= "";
	public static String GstrLBL_OPERACION= "";
	public static String GstrLBL_FECHA= "";
	public static String GstrLBL_HORA= "";
	public static String GstrLBL_NRO_REFERENCIA= "";
	public static String GstrLNK_CERRAR_SESION= "";
	public static String GstrLBN_MENSAJE_TIPO_CAMBIO="";
	public static String GstrTXT_NUMERO_INVALIDO= "";
	public static String GstrTXT_NUMERO_INCOMPLETO="";
	public static String GstrTXT_MONTO_MINIMO= "";
	public static String GstrTXT_MONTO_MAXIMO="";
	
	public static String GstrIND_SOLO_HISTORICA="";
	
	public static String GstrCONSULTA_HISTORICA="";
	public static String GstrCMB_TIPO_CONSULTA_HISTORICA="";
	public static String GstrCMB_ESTADO_HISTORICA="";
	public static String GstrTXT_FECHA_DESDE_HISTORICA="";
	public static String GstrTXT_FECHA_HASTA_HISTORICA="";
	
	public static String GstrCONSULTA_HISTORICA_ENVIO="";
	public static String GstrVER_DETALLE_HISTORICA_ENVIO="";
	
	public static String GstrLNK_ENVIAR_EMAIL_HISTORICA="";
	public static String GstrTXT_CORREO_POPUP_HISTORICA="";
	public static String GstrTXT_MENSAJE_POPUP_HISTORICA="";
	public static String GstrBTN_ENVIAR_CORREO_POPUP_HISTORICA="";
	public static String GstrLNK_EXPORTAR_EXCEL_HISTORICA="";
	public static String GstrLNK_EXPORTAR_PDF_HISTORICA="";
	public static String GstrLNK_IMPRIMIR_HISTORICA="";
	public static String GstrLNK_VER_DETALLE_HISTORICA="";
	public static String GstrLNK_ENVIAR_EMAIL_DETALLE_HISTORICA="";
	public static String GstrTXT_CORREO_POPUP_DETALLE_HISTORICA="";
	public static String GstrTXT_MENSAJE_POPUP_DETALLE_HISTORICA="";
	public static String GstrBTN_ENVIAR_CORREO_POPUP_DETALLE_HISTORICA="";
	public static String GstrLNK_EXPORTAR_EXCEL_DETALLE_HISTORICA="";
	public static String GstrLNK_EXPORTAR_PDF_DETALLE_HISTORICA="";
	public static String GstrLNK_IMPRIMIR_DETALLE_HISTORICA="";
	public static String GstrLNK_VER_SWIFT="";
	public static String GstrLNK_REGRESAR_SWIFT="";
	public static String GstrLNK_ENVIAR_EMAIL_SWIFT="";
	public static String GstrTXT_CORREO_POPUP_SWIFT="";
	public static String GstrTXT_MENSAJE_POPUP_SWIFT="";
	public static String GstrBTN_ENVIAR_CORREO_POPUP_SWIFT="";
	public static String GstrLNK_EXPORTAR_PDF_SWIFT="";
	public static String GstrLNK_IMPRIMIR_SWIFT="";
	public static String GstrLNK_VER_DEBITO="";
	public static String GstrLNK_REGRESAR_DEBITO="";
	public static String GstrLNK_ENVIAR_EMAIL_DEBITO="";
	public static String GstrTXT_CORREO_POPUP_DEBITO="";
	public static String GstrTXT_MENSAJE_POPUP_DEBITO="";
	public static String GstrBTN_ENVIAR_CORREO_POPUP_DEBITO="";
	public static String GstrLNK_EXPORTAR_PDF_DEBITO="";
	public static String GstrLNK_IMPRIMIR_DEBITO="";

	
	public static String GstrLNK_VER_OPERACIONES_FRECUENTES= "";
	public static String GstrLNK_AGREGAR_OPERACIONES_FRECUENTES= "";
	public static String GstrTXT_DESCRIPCION_OF= "";
	public static String GstrBTN_CONTINUAR_OF= "";
	public static String GstrLBL_IDENTIFICADOR_OF= "";
	public static String GstrLNK_REALIZAR_OTRA_TRANSF_OF= "";
	public static String GstrBTN_ELIMINAR_OF= "";
	public static String GstrBTN_ACEPTAR_OF= "";
	public static String GstrIND_SOLO_OF= "";
	
	public static String GstrCONSULTAR_SALDOS_MOVIMIENTOS= "";
	
	public static String GstrFIRMAR= "";
	public static String GstrFIRMANTE1= "";
	public static String GstrFIRMANTE2= "";
	public static String GstrFIRMANTE3= "";
	public static String GstrOPERADOR= "";
	public static String GstrESTADO= "";
	
	public static String strTIPO_CAMBIO= "";
	public static String strARBITRAJE= "";
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrID_CASO_LOGIN = Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1= Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_IR_AUTORIZAR= Rst_Funcionalidad.getObject("BTN_IR_AUTORIZAR") != null ? Rst_Funcionalidad.getString("BTN_IR_AUTORIZAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_IR_CONSULTAR= Rst_Funcionalidad.getObject("BTN_IR_CONSULTAR") != null ? Rst_Funcionalidad.getString("BTN_IR_CONSULTAR") : Mdl_Variables.Gstr_Ignore;
			GstrIND_EMPRESA= Rst_Funcionalidad.getObject("IND_EMPRESA") != null ? Rst_Funcionalidad.getString("IND_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_ORDENANTE= Rst_Funcionalidad.getObject("TXT_NOMBRE_ORDENANTE") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_ORDENANTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_ORDENANTE= Rst_Funcionalidad.getObject("TXT_DIRECCION_ORDENANTE") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_ORDENANTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_TELEFONO_ORDENANTE= Rst_Funcionalidad.getObject("TXT_TELEFONO_ORDENANTE") != null ? Rst_Funcionalidad.getString("TXT_TELEFONO_ORDENANTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_EMAIL_ORDENANTE= Rst_Funcionalidad.getObject("TXT_EMAIL_ORDENANTE") != null ? Rst_Funcionalidad.getString("TXT_EMAIL_ORDENANTE") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_MONEDA= Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO= Rst_Funcionalidad.getObject("TXT_MONTO") != null ? Rst_Funcionalidad.getString("TXT_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_CUENTA_CARGO= Rst_Funcionalidad.getObject("CMB_CUENTA_CARGO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_CARGO") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_TICKET= Rst_Funcionalidad.getObject("CHK_TICKET") != null ? Rst_Funcionalidad.getString("CHK_TICKET") : Mdl_Variables.Gstr_Ignore;
			GstrIND_TIENE_TICKET= Rst_Funcionalidad.getObject("IND_TIENE_TICKET") != null ? Rst_Funcionalidad.getString("IND_TIENE_TICKET") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_TICKET= Rst_Funcionalidad.getObject("TXT_NUMERO_TICKET") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_TICKET") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_CARGO= Rst_Funcionalidad.getObject("TXT_FECHA_CARGO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_CARGO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_DOCUMENTO_BENEFICIARIO= Rst_Funcionalidad.getObject("CMB_TIPO_DOCUMENTO_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_DOCUMENTO_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_NUMERO_DOCUMENTO_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_DOCUMENTO_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_NOMBRE_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_DIRECCION_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_PAIS_BENEFICIARIO= Rst_Funcionalidad.getObject("CMB_PAIS_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("CMB_PAIS_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_POPUP_PAIS= Rst_Funcionalidad.getObject("BTN_CERRAR_POPUP_PAIS") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_POPUP_PAIS") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_MENSAJE_PAIS= Rst_Funcionalidad.getObject("LBL_MENSAJE_PAIS") != null ? Rst_Funcionalidad.getString("LBL_MENSAJE_PAIS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CIUDAD_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_CIUDAD_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_CIUDAD_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_TELEFONO_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_TELEFONO_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_TELEFONO_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CUENTA_ABONO= Rst_Funcionalidad.getObject("TXT_CUENTA_ABONO") != null ? Rst_Funcionalidad.getString("TXT_CUENTA_ABONO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_BANCO= Rst_Funcionalidad.getObject("TXT_NOMBRE_BANCO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_BANCO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_PAIS_BANCO= Rst_Funcionalidad.getObject("CMB_PAIS_BANCO") != null ? Rst_Funcionalidad.getString("CMB_PAIS_BANCO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CIUDAD_BANCO= Rst_Funcionalidad.getObject("TXT_CIUDAD_BANCO") != null ? Rst_Funcionalidad.getString("TXT_CIUDAD_BANCO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_CODIGO_BANCO= Rst_Funcionalidad.getObject("CMB_TIPO_CODIGO_BANCO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CODIGO_BANCO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CODIGO_BANCO= Rst_Funcionalidad.getObject("TXT_CODIGO_BANCO") != null ? Rst_Funcionalidad.getString("TXT_CODIGO_BANCO") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_BANCO_INTERMEDIARIO= Rst_Funcionalidad.getObject("CHK_BANCO_INTERMEDIARIO") != null ? Rst_Funcionalidad.getString("CHK_BANCO_INTERMEDIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_BANCO_INTERMEDIARIO= Rst_Funcionalidad.getObject("TXT_NOMBRE_BANCO_INTERMEDIARIO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_BANCO_INTERMEDIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_PAIS_BANCO_INTERMEDIARIO= Rst_Funcionalidad.getObject("CMB_PAIS_BANCO_INTERMEDIARIO") != null ? Rst_Funcionalidad.getString("CMB_PAIS_BANCO_INTERMEDIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CIUDAD_BANCO_INTERMEDIARIO= Rst_Funcionalidad.getObject("TXT_CIUDAD_BANCO_INTERMEDIARIO") != null ? Rst_Funcionalidad.getString("TXT_CIUDAD_BANCO_INTERMEDIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO= Rst_Funcionalidad.getObject("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CODIGO_BANCO_INTERMEDIARIO= Rst_Funcionalidad.getObject("TXT_CODIGO_BANCO_INTERMEDIARIO") != null ? Rst_Funcionalidad.getString("TXT_CODIGO_BANCO_INTERMEDIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_MOTIVO_TRANSFERENCIA= Rst_Funcionalidad.getObject("CMB_MOTIVO_TRANSFERENCIA") != null ? Rst_Funcionalidad.getString("CMB_MOTIVO_TRANSFERENCIA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_GASTOS_CORRESPONSAL= Rst_Funcionalidad.getObject("CMB_GASTOS_CORRESPONSAL") != null ? Rst_Funcionalidad.getString("CMB_GASTOS_CORRESPONSAL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DETALLE_PAGO= Rst_Funcionalidad.getObject("TXT_DETALLE_PAGO") != null ? Rst_Funcionalidad.getString("TXT_DETALLE_PAGO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_OPERACIONES_FRECUENTES= Rst_Funcionalidad.getObject("LNK_VER_OPERACIONES_FRECUENTES") != null ? Rst_Funcionalidad.getString("LNK_VER_OPERACIONES_FRECUENTES") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_GUARDAR= Rst_Funcionalidad.getObject("BTN_GUARDAR") != null ? Rst_Funcionalidad.getString("BTN_GUARDAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR= Rst_Funcionalidad.getObject("BTN_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_TIPO_CAMBIO= Rst_Funcionalidad.getObject("LBL_TIPO_CAMBIO") != null ? Rst_Funcionalidad.getString("LBL_TIPO_CAMBIO") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO_1= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO_1") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO_1") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_MENSAJE1= Rst_Funcionalidad.getObject("LBL_MENSAJE1") != null ? Rst_Funcionalidad.getString("LBL_MENSAJE1") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_MENSAJE2= Rst_Funcionalidad.getObject("LBL_MENSAJE2") != null ? Rst_Funcionalidad.getString("LBL_MENSAJE2") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_MENSAJE3= Rst_Funcionalidad.getObject("LBL_MENSAJE3") != null ? Rst_Funcionalidad.getString("LBL_MENSAJE3") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_MENSAJE4= Rst_Funcionalidad.getObject("LBL_MENSAJE4") != null ? Rst_Funcionalidad.getString("LBL_MENSAJE4") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("LNK_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("LNK_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("BTN_CERRAR_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_ACEPTO_TERMINOS_CONDICIONES= Rst_Funcionalidad.getObject("CHK_ACEPTO_TERMINOS_CONDICIONES") != null ? Rst_Funcionalidad.getString("CHK_ACEPTO_TERMINOS_CONDICIONES") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE= Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA= Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_QUIERES_SABER_COMO= Rst_Funcionalidad.getObject("LNK_QUIERES_SABER_COMO") != null ? Rst_Funcionalidad.getString("LNK_QUIERES_SABER_COMO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_QUIERES_SABER_COMO= Rst_Funcionalidad.getObject("BTN_CERRAR_QUIERES_SABER_COMO") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_QUIERES_SABER_COMO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR= Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CANCELAR_OPERACION= Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO_2= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO_2") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO_2") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_AGREGAR_OPERACIONES_FRECUENTES= Rst_Funcionalidad.getObject("LNK_AGREGAR_OPERACIONES_FRECUENTES") != null ? Rst_Funcionalidad.getString("LNK_AGREGAR_OPERACIONES_FRECUENTES") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REALIZAR_OTRA_TRANSFERENCIA= Rst_Funcionalidad.getObject("LNK_REALIZAR_OTRA_TRANSFERENCIA") != null ? Rst_Funcionalidad.getString("LNK_REALIZAR_OTRA_TRANSFERENCIA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_POPUP= Rst_Funcionalidad.getObject("TXT_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_POPUP= Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_POPUP= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR= Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_OPERACION= Rst_Funcionalidad.getObject("LBL_OPERACION") != null ? Rst_Funcionalidad.getString("LBL_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_FECHA= Rst_Funcionalidad.getObject("LBL_FECHA") != null ? Rst_Funcionalidad.getString("LBL_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_HORA= Rst_Funcionalidad.getObject("LBL_HORA") != null ? Rst_Funcionalidad.getString("LBL_HORA") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_NRO_REFERENCIA= Rst_Funcionalidad.getObject("LBL_NRO_REFERENCIA") != null ? Rst_Funcionalidad.getString("LBL_NRO_REFERENCIA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_MENSAJE_TIPO_CAMBIO= Rst_Funcionalidad.getObject("LBN_MENSAJE_TIPO_CAMBIO") != null ? Rst_Funcionalidad.getString("LBN_MENSAJE_TIPO_CAMBIO") : Mdl_Variables.Gstr_Ignore;
			
			GstrTXT_NUMERO_INVALIDO= Rst_Funcionalidad.getObject("TXT_NUMERO_INVALIDO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_INVALIDO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_INCOMPLETO= Rst_Funcionalidad.getObject("TXT_NUMERO_INCOMPLETO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_INCOMPLETO") : Mdl_Variables.Gstr_Ignore;
		
			GstrTXT_MONTO_MINIMO= Rst_Funcionalidad.getObject("TXT_MONTO_MINIMO") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MINIMO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO_MAXIMO= Rst_Funcionalidad.getObject("TXT_MONTO_MAXIMO") != null ? Rst_Funcionalidad.getString("TXT_MONTO_MAXIMO") : Mdl_Variables.Gstr_Ignore;

			GstrCONSULTA_HISTORICA_ENVIO= Rst_Funcionalidad.getObject("CONSULTA_HISTORICA_ENVIO") != null ? Rst_Funcionalidad.getString("CONSULTA_HISTORICA_ENVIO") : Mdl_Variables.Gstr_Ignore;
			GstrVER_DETALLE_HISTORICA_ENVIO= Rst_Funcionalidad.getObject("VER_DETALLE_HISTORICA_ENVIO") != null ? Rst_Funcionalidad.getString("VER_DETALLE_HISTORICA_ENVIO") : Mdl_Variables.Gstr_Ignore;
			
			GstrIND_SOLO_HISTORICA= Rst_Funcionalidad.getObject("IND_SOLO_HISTORICA") != null ? Rst_Funcionalidad.getString("IND_SOLO_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrCONSULTA_HISTORICA= Rst_Funcionalidad.getObject("CONSULTA_HISTORICA") != null ? Rst_Funcionalidad.getString("CONSULTA_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_CONSULTA_HISTORICA= Rst_Funcionalidad.getObject("CMB_TIPO_CONSULTA_HISTORICA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CONSULTA_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_ESTADO_HISTORICA= Rst_Funcionalidad.getObject("CMB_ESTADO_HISTORICA") != null ? Rst_Funcionalidad.getString("CMB_ESTADO_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_DESDE_HISTORICA= Rst_Funcionalidad.getObject("TXT_FECHA_DESDE_HISTORICA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_DESDE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_HASTA_HISTORICA= Rst_Funcionalidad.getObject("TXT_FECHA_HASTA_HISTORICA") != null ? Rst_Funcionalidad.getString("TXT_FECHA_HASTA_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL_HISTORICA= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_POPUP_HISTORICA= Rst_Funcionalidad.getObject("TXT_CORREO_POPUP_HISTORICA") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_POPUP_HISTORICA= Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP_HISTORICA") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_POPUP_HISTORICA= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP_HISTORICA") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_HISTORICA= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_HISTORICA= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_HISTORICA= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("LNK_VER_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_VER_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_POPUP_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("TXT_CORREO_POPUP_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_POPUP_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_POPUP_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_DETALLE_HISTORICA= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_DETALLE_HISTORICA") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_DETALLE_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_SWIFT= Rst_Funcionalidad.getObject("LNK_VER_SWIFT") != null ? Rst_Funcionalidad.getString("LNK_VER_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR_SWIFT= Rst_Funcionalidad.getObject("LNK_REGRESAR_SWIFT") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL_SWIFT= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_SWIFT") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_POPUP_SWIFT= Rst_Funcionalidad.getObject("TXT_CORREO_POPUP_SWIFT") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_POPUP_SWIFT= Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP_SWIFT") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_POPUP_SWIFT= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP_SWIFT") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_SWIFT= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_SWIFT") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_SWIFT= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_SWIFT") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_SWIFT") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_DEBITO= Rst_Funcionalidad.getObject("LNK_VER_DEBITO") != null ? Rst_Funcionalidad.getString("LNK_VER_DEBITO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR_DEBITO= Rst_Funcionalidad.getObject("LNK_REGRESAR_DEBITO") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR_DEBITO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL_DEBITO= Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_DEBITO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_DEBITO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_POPUP_DEBITO= Rst_Funcionalidad.getObject("TXT_CORREO_POPUP_DEBITO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP_DEBITO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_POPUP_DEBITO= Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP_DEBITO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP_DEBITO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_POPUP_DEBITO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP_DEBITO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP_DEBITO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_DEBITO= Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_DEBITO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_DEBITO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_DEBITO= Rst_Funcionalidad.getObject("LNK_IMPRIMIR_DEBITO") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_DEBITO") : Mdl_Variables.Gstr_Ignore;

			GstrTXT_DESCRIPCION_OF= Rst_Funcionalidad.getObject("TXT_DESCRIPCION_OF") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION_OF") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR_OF= Rst_Funcionalidad.getObject("BTN_CONTINUAR_OF") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR_OF") : Mdl_Variables.Gstr_Ignore;
			GstrLBL_IDENTIFICADOR_OF= Rst_Funcionalidad.getObject("LBL_IDENTIFICADOR_OF") != null ? Rst_Funcionalidad.getString("LBL_IDENTIFICADOR_OF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REALIZAR_OTRA_TRANSF_OF= Rst_Funcionalidad.getObject("LNK_REALIZAR_OTRA_TRANSF_OF") != null ? Rst_Funcionalidad.getString("LNK_REALIZAR_OTRA_TRANSF_OF") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ELIMINAR_OF= Rst_Funcionalidad.getObject("BTN_ELIMINAR_OF") != null ? Rst_Funcionalidad.getString("BTN_ELIMINAR_OF") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_OF= Rst_Funcionalidad.getObject("BTN_ACEPTAR_OF") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_OF") : Mdl_Variables.Gstr_Ignore;
			GstrIND_SOLO_OF= Rst_Funcionalidad.getObject("IND_SOLO_OF") != null ? Rst_Funcionalidad.getString("IND_SOLO_OF") : Mdl_Variables.Gstr_Ignore;
			
			GstrCONSULTAR_SALDOS_MOVIMIENTOS= Rst_Funcionalidad.getObject("CONSULTAR_SALDOS_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("CONSULTAR_SALDOS_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			
			GstrFIRMAR= Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE1= Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE2= Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE3= Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
			GstrOPERADOR= Rst_Funcionalidad.getObject("OPERADOR") != null ? Rst_Funcionalidad.getString("OPERADOR") : Mdl_Variables.Gstr_Ignore;
			GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
			strTIPO_CAMBIO= "";
			strARBITRAJE= "";
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		return bandera;
	}
}
