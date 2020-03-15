package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class TransferenciaBE { 
	//GENERAL

	public static String Gstr_ID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String Gstr_ID_CASO_LOGIN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENU=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_SUBMENU1=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIO_TRANSFERENCIA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_OPERACION_FRECUENTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMAR;//para realizar todo el escenario completo
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_TIPO_CAMBIO_ESPECIAL=Mdl_Variables.Gstr_Ignore;
	//--
	public static String GstrCMB_EMPRESA_CUENTA_ORIGEN=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA_ORIGEN=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_TIPO_CAMBIO_ESPECIAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_TIPO_CAMBIO_ESPECIAL=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DESCRIPCION_TRANSFERENCIA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONTINUAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CANCELAR_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE2=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE3=Mdl_Variables.Gstr_Ignore;
	public static String GstrOPERADOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_POPUP=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_POPUP=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_POPUP=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_FECHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_OPERACION_HORA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_MONTO_TOTAL=Mdl_Variables.Gstr_Ignore;
	
	//GENERAL OPERACION FRECUENTE
	public static String GstrLNK_OPERACION_FRECUENTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DESCRIPCION_OPERACION_FRECUENTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONTINUAR_OPERACION_FRECUENTE=Mdl_Variables.Gstr_Ignore;
		
	//1.- ENTRE CUENTAS - 2.- A TERCEROS
	public static String GstrCMB_EMPRESA_CUENTA_DESTINO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_CUENTA_DESTINO=Mdl_Variables.Gstr_Ignore;
	
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
	
	public static String GstrNUMERO_SOLICITUD=Mdl_Variables.Gstr_Ignore;
	
	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad, int intOpcion){
		boolean bandera = true; 
		try {

			//GENERAL
			Gstr_ID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			
			Gstr_ID_CASO_LOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENU = Rst_Funcionalidad.getObject("TXT_MENU") != null ? Rst_Funcionalidad.getString("TXT_MENU") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_SUBMENU1 = Rst_Funcionalidad.getObject("TXT_SUBMENU1") != null ? Rst_Funcionalidad.getString("TXT_SUBMENU1") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_ENVIO_TRANSFERENCIA = Rst_Funcionalidad.getObject("LNK_ENVIO_TRANSFERENCIA") != null ? Rst_Funcionalidad.getString("LNK_ENVIO_TRANSFERENCIA") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMAR= Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO= Rst_Funcionalidad.getObject("RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION= Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			
			GstrFIRMANTE1= Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE2= Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE3= Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
			GstrOPERADOR= Rst_Funcionalidad.getObject("OPERADOR") != null ? Rst_Funcionalidad.getString("OPERADOR") : Mdl_Variables.Gstr_Ignore;
			
			//--
			GstrLNK_VER_OPERACION_FRECUENTE = Rst_Funcionalidad.getObject("LNK_VER_OPERACION_FRECUENTE") != null ? Rst_Funcionalidad.getString("LNK_VER_OPERACION_FRECUENTE") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_EMPRESA_CUENTA_ORIGEN= Rst_Funcionalidad.getObject("CMB_EMPRESA_CUENTA_ORIGEN") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA_CUENTA_ORIGEN") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_CUENTA_ORIGEN = Rst_Funcionalidad.getObject("CMB_CUENTA_ORIGEN") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_ORIGEN") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO =Rst_Funcionalidad.getObject("TXT_MONTO") != null ? Rst_Funcionalidad.getString("TXT_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_MONEDA =Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DESCRIPCION_TRANSFERENCIA = Rst_Funcionalidad.getObject("TXT_DESCRIPCION_TRANSFERENCIA") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION_TRANSFERENCIA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR =Rst_Funcionalidad.getObject("BTN_CONTINUAR") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE=Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CANCELAR_OPERACION = Rst_Funcionalidad.getObject("BTN_CANCELAR_OPERACION") != null ? Rst_Funcionalidad.getString("BTN_CANCELAR_OPERACION") : Mdl_Variables.Gstr_Ignore;
			
			//GENERAL OPERACION FRECUENTE
			GstrLNK_OPERACION_FRECUENTE =Rst_Funcionalidad.getObject("LNK_OPERACION_FRECUENTE") != null ? Rst_Funcionalidad.getString("LNK_OPERACION_FRECUENTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DESCRIPCION_OPERACION_FRECUENTE = Rst_Funcionalidad.getObject("TXT_DESCRIPCION_OPERACION_FRECUENTE") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION_OPERACION_FRECUENTE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR_OPERACION_FRECUENTE = Rst_Funcionalidad.getObject("BTN_CONTINUAR_OPERACION_FRECUENTE") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR_OPERACION_FRECUENTE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrESTADO= Rst_Funcionalidad.getObject("ESTADO") != null ? Rst_Funcionalidad.getString("ESTADO") : Mdl_Variables.Gstr_Ignore;
			
			GstrLNK_ENVIAR_CORREO = Rst_Funcionalidad.getObject("LNK_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("LNK_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_EXCEL  = Rst_Funcionalidad.getObject("LNK_EXPORTAR_EXCEL") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_EXCEL") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_EXPORTAR_PDF = Rst_Funcionalidad.getObject("LNK_EXPORTAR_PDF") != null ? Rst_Funcionalidad.getString("LNK_EXPORTAR_PDF") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_IMPRIMIR = Rst_Funcionalidad.getObject("LNK_IMPRIMIR") != null ? Rst_Funcionalidad.getString("LNK_IMPRIMIR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO_POPUP = Rst_Funcionalidad.getObject("TXT_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("TXT_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_POPUP = Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO_POPUP = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO_POPUP") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO_POPUP") : Mdl_Variables.Gstr_Ignore;
			
			GstrLBN_OPERACION= Rst_Funcionalidad.getObject("LBN_OPERACION") != null ? Rst_Funcionalidad.getString("LBN_OPERACION") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION_FECHA= Rst_Funcionalidad.getObject("LBN_OPERACION_FECHA") != null ? Rst_Funcionalidad.getString("LBN_OPERACION_FECHA") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_OPERACION_HORA= Rst_Funcionalidad.getObject("LBN_OPERACION_HORA") != null ? Rst_Funcionalidad.getString("LBN_OPERACION_HORA") : Mdl_Variables.Gstr_Ignore;
			GstrLBN_MONTO_TOTAL= Rst_Funcionalidad.getObject("LBN_MONTO_TOTAL") != null ? Rst_Funcionalidad.getString("LBN_MONTO_TOTAL") : Mdl_Variables.Gstr_Ignore;
			
			GstrCONSULTAR_SALDOS_MOVIMIENTOS= Rst_Funcionalidad.getObject("CONSULTAR_SALDOS_MOVIMIENTOS") != null ? Rst_Funcionalidad.getString("CONSULTAR_SALDOS_MOVIMIENTOS") : Mdl_Variables.Gstr_Ignore;
			GstrNUMERO_SOLICITUD= Rst_Funcionalidad.getObject("NUMERO_SOLICITUD") != null ? Rst_Funcionalidad.getString("NUMERO_SOLICITUD") : Mdl_Variables.Gstr_Ignore;
			GstrCHK_TIPO_CAMBIO_ESPECIAL=Rst_Funcionalidad.getObject("CHK_TIPO_CAMBIO_ESPECIAL") != null ? Rst_Funcionalidad.getString("CHK_TIPO_CAMBIO_ESPECIAL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_TIPO_CAMBIO_ESPECIAL=Rst_Funcionalidad.getObject("TXT_TIPO_CAMBIO_ESPECIAL") != null ? Rst_Funcionalidad.getString("TXT_TIPO_CAMBIO_ESPECIAL") : Mdl_Variables.Gstr_Ignore;
		
			//1.- ENTRE CUENTAS - 2.- A TERCEROS
			if(intOpcion==1 ){
				GstrCMB_EMPRESA_CUENTA_DESTINO= Rst_Funcionalidad.getObject("CMB_EMPRESA_CUENTA_DESTINO") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA_CUENTA_DESTINO") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_CUENTA_DESTINO= Rst_Funcionalidad.getObject("CMB_CUENTA_DESTINO") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_DESTINO") : Mdl_Variables.Gstr_Ignore;
				GstrLNK_TIPO_CAMBIO_ESPECIAL= Rst_Funcionalidad.getObject("LNK_TIPO_CAMBIO_ESPECIAL") != null ? Rst_Funcionalidad.getString("LNK_TIPO_CAMBIO_ESPECIAL") : Mdl_Variables.Gstr_Ignore;
				
			}
			
			//2.- A TERCEROS - 3.- OTROS BANCOS CCE
			if(intOpcion==2 || intOpcion==3){
				GstrBTN_CORREO= Rst_Funcionalidad.getObject("BTN_CORREO") != null ? Rst_Funcionalidad.getString("BTN_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CORREO= Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_MENSAJE_CORREO= Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
					}
			
			//3.- OTROS BANCOS CCE - 4.- OTROS BANCOS BCR
			if(intOpcion==2){
				GstrCMB_TIPO_CUENTA= Rst_Funcionalidad.getObject("CMB_TIPO_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CUENTA") : Mdl_Variables.Gstr_Ignore;
			}
			
			//3.- OTROS BANCOS CCE - 4.- OTROS BANCOS BCR
			if(intOpcion==3 || intOpcion==4 || intOpcion==2){
				GstrTXT_CUENTA_DESTINO= Rst_Funcionalidad.getObject("TXT_CUENTA_DESTINO") != null ? Rst_Funcionalidad.getString("TXT_CUENTA_DESTINO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CLAVE_DINAMICA= Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;
			}
			
			if(intOpcion==3 || intOpcion==4 ){
				GstrCHK_EMPRESA_PROPIETARIA= Rst_Funcionalidad.getObject("CHK_EMPRESA_PROPIETARIA") != null ? Rst_Funcionalidad.getString("CHK_EMPRESA_PROPIETARIA") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_NOMBRE_EMPRESA= Rst_Funcionalidad.getObject("TXT_NOMBRE_EMPRESA") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_TIPO_DOCUMENTO_IDENTIDAD= Rst_Funcionalidad.getObject("CMB_TIPO_DOCUMENTO_IDENTIDAD") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO_IDENTIDAD") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_NUMERO_IDENTIDAD= Rst_Funcionalidad.getObject("TXT_NUMERO_IDENTIDAD") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_IDENTIDAD") : Mdl_Variables.Gstr_Ignore;
			}
			
			//4.- OTROS BANCOS BCR
			if(intOpcion==4){
				GstrTXT_PROGRAMA_OPERACION= Rst_Funcionalidad.getObject("TXT_PROGRAMA_OPERACION") != null ? Rst_Funcionalidad.getString("TXT_PROGRAMA_OPERACION") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_ACEPTAR_POP_UP= Rst_Funcionalidad.getObject("BTN_ACEPTAR_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_SI_POP_UP= Rst_Funcionalidad.getObject("BTN_SI_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_NO_POP_UP= Rst_Funcionalidad.getObject("BTN_NO_POP_UP") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_SI_POP_UP1= Rst_Funcionalidad.getObject("BTN_SI_POP_UP1") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP1") : Mdl_Variables.Gstr_Ignore;
				GstrBTN_NO_POP_UP1= Rst_Funcionalidad.getObject("BTN_NO_POP_UP1") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP1") : Mdl_Variables.Gstr_Ignore;
				
				
			}

		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
