package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ComercioExtCartaFianzaGeneralBE {
	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrENVIO_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_AFIANZAR_TERCERO_SI=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_AFIANZAR_TERCERO_NO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_AFIANZADO_TERCERO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_DIRECCION_VIA_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_NOMBRE_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_N_MZ_LOTE_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_INTERIOR_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_UBICACION_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_DIRECCION_DISTRITO_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;	
	public static String GstrCMB_DIRECCION_VIA_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_NOMBRE_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_INTERIOR_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_UBICACION_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_DIRECCION_DISTRITO_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_INICIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_PLAZO_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_PLAZO_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_PLANTILLA_ESTANDAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_PLANTILLA_ESTANDAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CAMBIO_NOMBRE_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CAMBIO_NOMBRE_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CAMBIO_NOMBRE_BENEFICIARIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CAMBIO_NOMBRE_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CAMBIO_NOMBRE_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CAMBIO_NOMBRE_AFIANZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_IMPORTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CAMBIO_MONTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CAMBIO_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CAMBIO_IMPORTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_OBLIGACIONES_GARANTIZADAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_PLAZO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CAMBIO_PLAZO_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CAMBIO_PLAZO_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CAMBIO_PLAZO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_GUARDAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRDB_ADJUNTAR_ARCHIVO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLINK_ADJUNTAR_ARCHIVO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SELECCIONAR_ARCHIVO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_GRABAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_FIRMA_AUTOGRAFA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_PERSONA_RESPONSABLE_CARTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_CONTACTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONTINUAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_DESCRIPCION=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_ACEPTAR_TERMINOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CONTRATO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CARTILLA_INFORMACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_QUIERES_SABER_COMO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_DESCRIPCION_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_AGREGAR_OPERACIONES_FRECUENTES=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DESCRIPCION_OF=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REALIZAR_OTRA_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE2=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE3=Mdl_Variables.Gstr_Ignore;
	public static String GstrESTADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_HORA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_MONTO_TOTAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_FECHA_VENCIMIENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_RESULTADO_FINAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_PROCESADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_EMAIL_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_BLOQUEADOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_NUMERO_CARTA_FIANZA=Mdl_Variables.Gstr_Ignore;
	public static String GstrOPERADOR=Mdl_Variables.Gstr_Ignore;

	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		try {

			Gstr_ID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU = Rst_Funcionalidad.getObject("TXT_SUBMENU") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMAR = Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA = Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrRDB_AFIANZAR_TERCERO_SI= Rst_Funcionalidad.getObject("RDB_AFIANZAR_TERCERO_SI") != null ? Rst_Funcionalidad.getString("RDB_AFIANZAR_TERCERO_SI") : Mdl_Variables.Gstr_Ignore;
			GstrRDB_AFIANZAR_TERCERO_NO= Rst_Funcionalidad.getObject("RDB_AFIANZAR_TERCERO_NO") != null ? Rst_Funcionalidad.getString("RDB_AFIANZAR_TERCERO_NO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_AFIANZADO_TERCERO= Rst_Funcionalidad.getObject("TXT_NOMBRE_AFIANZADO_TERCERO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_AFIANZADO_TERCERO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_AFIANZADO= Rst_Funcionalidad.getObject("TXT_NOMBRE_AFIANZADO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_DIRECCION_VIA_AFIANZADO= Rst_Funcionalidad.getObject("CMB_DIRECCION_VIA_AFIANZADO") != null ? Rst_Funcionalidad.getString("CMB_DIRECCION_VIA_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_NOMBRE_AFIANZADO= Rst_Funcionalidad.getObject("TXT_DIRECCION_NOMBRE_AFIANZADO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_NOMBRE_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_N_MZ_LOTE_AFIANZADO= Rst_Funcionalidad.getObject("TXT_DIRECCION_N_MZ_LOTE_AFIANZADO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_N_MZ_LOTE_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_INTERIOR_AFIANZADO= Rst_Funcionalidad.getObject("TXT_DIRECCION_INTERIOR_AFIANZADO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_INTERIOR_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_UBICACION_AFIANZADO= Rst_Funcionalidad.getObject("TXT_DIRECCION_UBICACION_AFIANZADO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_UBICACION_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_DIRECCION_DISTRITO_AFIANZADO= Rst_Funcionalidad.getObject("CMB_DIRECCION_DISTRITO_AFIANZADO") != null ? Rst_Funcionalidad.getString("CMB_DIRECCION_DISTRITO_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_NOMBRE_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_DIRECCION_VIA_BENEFICIARIO= Rst_Funcionalidad.getObject("CMB_DIRECCION_VIA_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("CMB_DIRECCION_VIA_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_NOMBRE_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_DIRECCION_NOMBRE_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_NOMBRE_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_INTERIOR_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_DIRECCION_INTERIOR_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_INTERIOR_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DIRECCION_UBICACION_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_DIRECCION_UBICACION_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_UBICACION_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_DIRECCION_DISTRITO_BENEFICIARIO= Rst_Funcionalidad.getObject("CMB_DIRECCION_DISTRITO_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("CMB_DIRECCION_DISTRITO_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_FECHA_INICIO= Rst_Funcionalidad.getObject("TXT_FECHA_INICIO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_INICIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_PLAZO_DIAS= Rst_Funcionalidad.getObject("TXT_PLAZO_DIAS") != null ? Rst_Funcionalidad.getString("TXT_PLAZO_DIAS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_PLAZO_FECHA= Rst_Funcionalidad.getObject("TXT_PLAZO_FECHA") != null ? Rst_Funcionalidad.getString("TXT_PLAZO_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_MONEDA = Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO = Rst_Funcionalidad.getObject("TXT_MONTO") != null ? Rst_Funcionalidad.getString("TXT_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrRDB_PLANTILLA_ESTANDAR= Rst_Funcionalidad.getObject("RDB_PLANTILLA_ESTANDAR") != null ? Rst_Funcionalidad.getString("RDB_PLANTILLA_ESTANDAR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_PLANTILLA_ESTANDAR= Rst_Funcionalidad.getObject("LNK_PLANTILLA_ESTANDAR") != null ? Rst_Funcionalidad.getString("LNK_PLANTILLA_ESTANDAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CAMBIO_NOMBRE_BENEFICIARIO= Rst_Funcionalidad.getObject("BTN_CAMBIO_NOMBRE_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("BTN_CAMBIO_NOMBRE_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAMBIO_NOMBRE_BENEFICIARIO= Rst_Funcionalidad.getObject("TXT_CAMBIO_NOMBRE_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_CAMBIO_NOMBRE_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_CAMBIO_NOMBRE_BENEFICIARIO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CAMBIO_NOMBRE_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CAMBIO_NOMBRE_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CAMBIO_NOMBRE_AFIANZADO= Rst_Funcionalidad.getObject("BTN_CAMBIO_NOMBRE_AFIANZADO") != null ? Rst_Funcionalidad.getString("BTN_CAMBIO_NOMBRE_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAMBIO_NOMBRE_AFIANZADO= Rst_Funcionalidad.getObject("TXT_CAMBIO_NOMBRE_AFIANZADO") != null ? Rst_Funcionalidad.getString("TXT_CAMBIO_NOMBRE_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_CAMBIO_NOMBRE_AFIANZADO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CAMBIO_NOMBRE_AFIANZADO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CAMBIO_NOMBRE_AFIANZADO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_IMPORTE= Rst_Funcionalidad.getObject("BTN_IMPORTE") != null ? Rst_Funcionalidad.getString("BTN_IMPORTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAMBIO_MONTO= Rst_Funcionalidad.getObject("TXT_CAMBIO_MONTO") != null ? Rst_Funcionalidad.getString("TXT_CAMBIO_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_CAMBIO_MONEDA= Rst_Funcionalidad.getObject("CMB_CAMBIO_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_CAMBIO_MONEDA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_CAMBIO_IMPORTE= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CAMBIO_IMPORTE") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CAMBIO_IMPORTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_OBLIGACIONES_GARANTIZADAS= Rst_Funcionalidad.getObject("TXT_OBLIGACIONES_GARANTIZADAS") != null ? Rst_Funcionalidad.getString("TXT_OBLIGACIONES_GARANTIZADAS") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_PLAZO= Rst_Funcionalidad.getObject("BTN_PLAZO") != null ? Rst_Funcionalidad.getString("BTN_PLAZO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAMBIO_PLAZO_DIAS= Rst_Funcionalidad.getObject("TXT_CAMBIO_PLAZO_DIAS") != null ? Rst_Funcionalidad.getString("TXT_CAMBIO_PLAZO_DIAS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAMBIO_PLAZO_FECHA= Rst_Funcionalidad.getObject("TXT_CAMBIO_PLAZO_FECHA") != null ? Rst_Funcionalidad.getString("TXT_CAMBIO_PLAZO_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ACEPTAR_CAMBIO_PLAZO= Rst_Funcionalidad.getObject("BTN_ACEPTAR_CAMBIO_PLAZO") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_CAMBIO_PLAZO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_GUARDAR= Rst_Funcionalidad.getObject("BTN_GUARDAR") != null ? Rst_Funcionalidad.getString("BTN_GUARDAR") : Mdl_Variables.Gstr_Ignore;
			GstrRDB_ADJUNTAR_ARCHIVO= Rst_Funcionalidad.getObject("RDB_ADJUNTAR_ARCHIVO") != null ? Rst_Funcionalidad.getString("RDB_ADJUNTAR_ARCHIVO") : Mdl_Variables.Gstr_Ignore;
			GstrLINK_ADJUNTAR_ARCHIVO= Rst_Funcionalidad.getObject("LINK_ADJUNTAR_ARCHIVO") != null ? Rst_Funcionalidad.getString("LINK_ADJUNTAR_ARCHIVO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SELECCIONAR_ARCHIVO= Rst_Funcionalidad.getObject("BTN_SELECCIONAR_ARCHIVO") != null ? Rst_Funcionalidad.getString("BTN_SELECCIONAR_ARCHIVO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_GRABAR= Rst_Funcionalidad.getObject("BTN_GRABAR") != null ? Rst_Funcionalidad.getString("BTN_GRABAR") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_FIRMA_AUTOGRAFA=Rst_Funcionalidad.getObject("CHK_FIRMA_AUTOGRAFA") != null ? Rst_Funcionalidad.getString("CHK_FIRMA_AUTOGRAFA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_PERSONA_RESPONSABLE_CARTA= Rst_Funcionalidad.getObject("TXT_NOMBRE_PERSONA_RESPONSABLE_CARTA") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_PERSONA_RESPONSABLE_CARTA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA= Rst_Funcionalidad.getObject("CMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA= Rst_Funcionalidad.getObject("TXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA") != null ? Rst_Funcionalidad.getString("TXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR =Rst_Funcionalidad.getObject("BTN_CONTINUAR") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_CONTACTO=Rst_Funcionalidad.getObject("TXT_CORREO_CONTACTO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_CONTACTO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_DESCRIPCION=Rst_Funcionalidad.getObject("LNK_VER_DESCRIPCION") != null ? Rst_Funcionalidad.getString("LNK_VER_DESCRIPCION") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_ACEPTAR_TERMINOS=Rst_Funcionalidad.getObject("CHK_ACEPTAR_TERMINOS") != null ? Rst_Funcionalidad.getString("CHK_ACEPTAR_TERMINOS") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CONTRATO=Rst_Funcionalidad.getObject("LNK_CONTRATO") != null ? Rst_Funcionalidad.getString("LNK_CONTRATO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CARTILLA_INFORMACION=Rst_Funcionalidad.getObject("LNK_CARTILLA_INFORMACION") != null ? Rst_Funcionalidad.getString("LNK_CARTILLA_INFORMACION") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_QUIERES_SABER_COMO= Rst_Funcionalidad.getObject("LNK_QUIERES_SABER_COMO") != null ? Rst_Funcionalidad.getString("LNK_QUIERES_SABER_COMO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;				  
			GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO = Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_DESCRIPCION_FINAL =Rst_Funcionalidad.getObject("LNK_VER_DESCRIPCION_FINAL") != null ? Rst_Funcionalidad.getString("LNK_VER_DESCRIPCION_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_AGREGAR_OPERACIONES_FRECUENTES = Rst_Funcionalidad.getObject("LNK_AGREGAR_OPERACIONES_FRECUENTES") != null ? Rst_Funcionalidad.getString("LNK_AGREGAR_OPERACIONES_FRECUENTES") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DESCRIPCION_OF= Rst_Funcionalidad.getObject("TXT_DESCRIPCION_OF") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION_OF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REALIZAR_OTRA_OPERACION = Rst_Funcionalidad.getObject("LNK_REALIZAR_OTRA_OPERACION") != null ? Rst_Funcionalidad.getString("LNK_REALIZAR_OTRA_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO = Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO = Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE1 = Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE2 = Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE3 = Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
			GstrESTADO = Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION= Rst_Funcionalidad.getObject("LBN_OPERACION") != null ? Rst_Funcionalidad.getString("LBN_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION_FECHA= Rst_Funcionalidad.getObject("LBN_OPERACION_FECHA") != null ? Rst_Funcionalidad.getString("LBN_OPERACION_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION_HORA= Rst_Funcionalidad.getObject("LBN_OPERACION_HORA") != null ? Rst_Funcionalidad.getString("LBN_OPERACION_HORA") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_MONTO_TOTAL= Rst_Funcionalidad.getObject("LBN_MONTO_TOTAL") != null ? Rst_Funcionalidad.getString("LBN_MONTO_TOTAL") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_FECHA_VENCIMIENTO= Rst_Funcionalidad.getObject("LBN_FECHA_VENCIMIENTO") != null ? Rst_Funcionalidad.getString("LBN_FECHA_VENCIMIENTO") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_RESULTADO_FINAL= Rst_Funcionalidad.getObject("LBN_RESULTADO_FINAL") != null ? Rst_Funcionalidad.getString("LBN_RESULTADO_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_OPERACION= Rst_Funcionalidad.getObject("CMB_TIPO_OPERACION") != null ? Rst_Funcionalidad.getString("CMB_TIPO_OPERACION") : Mdl_Variables.Gstr_Ignore;
			
			GstrLNK_ENVIAR_EMAIL_PROCESADO = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_PROCESADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_PROCESADO= Rst_Funcionalidad.getObject("TXT_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("TXT_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO_PROCESADO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_PROCESADO= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_PROCESADO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_PROCESADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_PROCESADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_PROCESADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_PROCESADO = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_PROCESADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_PROCESADO = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_PROCESADO") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_PROCESADO") : Mdl_Variables.Gstr_Ignore;
			
			GstrLNK_ENVIAR_EMAIL_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_ENVIAR_EMAIL_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_EMAIL_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_BLOQUEADOS= Rst_Funcionalidad.getObject("TXT_CORREO_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("TXT_CORREO_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO_BLOQUEADOS= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_BLOQUEADOS= Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR_BLOQUEADOS = Rst_Funcionalidad.getObject("LNK_IMPRIMIR_BLOQUEADOS") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR_BLOQUEADOS") : Mdl_Variables.Gstr_Ignore;
			GstrOPERADOR= Rst_Funcionalidad.getObject("OPERADOR") != null ? Rst_Funcionalidad.getString("OPERADOR") : Mdl_Variables.Gstr_Ignore;
			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
