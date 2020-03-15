/**
 * 
 */
package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

/**
 * @author XT8048
 *
 */
public class TransfOtrosBancosCCEPortabilidadBE {
	
	public static String GstrID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTIE=Mdl_Variables.Gstr_Ignore;
	public static String GstrCLAVE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CAPCHA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SIGUIENTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SIGUIENTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_TRANSFERENCIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_A_OTROS_BANCOS_CCE=Mdl_Variables.Gstr_Ignore;
	public static String GstrIND_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_EMPRESA_CUENTA_ORIGEN=Mdl_Variables.Gstr_Ignore;//1
	public static String GstrCMB_CUENTA_ORIGEN=Mdl_Variables.Gstr_Ignore;//2
	public static String GstrCMB_TIPO_CUENTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUMERO_CUENTA_DESTINO=Mdl_Variables.Gstr_Ignore;//3
	public static String GstrCHK_EMPRESA_PROPIETARIA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_DOCUMENTO_IDENTIDAD=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUMERO_IDENTIDAD=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MONEDA=Mdl_Variables.Gstr_Ignore;//4
	public static String GstrTXT_MONTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DESCRIPCION_TRANSFERENCIA=Mdl_Variables.Gstr_Ignore;//5
	public static String GstrBTN_CONTINUAR=Mdl_Variables.Gstr_Ignore;//6
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_VER_DETALLE=Mdl_Variables.Gstr_Ignore;//7
	public static String GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;//8
	public static String GstrTXT_CLAVE=Mdl_Variables.Gstr_Ignore;//9
	public static String GstrTXT_CLAVE_DINAMICA=Mdl_Variables.Gstr_Ignore;//10
	public static String GstrBTN_CONFIRMAR=Mdl_Variables.Gstr_Ignore;//11
	public static String GstrNUMERO_SOLICITUD=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_EMAIL=Mdl_Variables.Gstr_Ignore;//12
	public static String GstrTXT_CORREO=Mdl_Variables.Gstr_Ignore;//13
	public static String GstrTXT_MENSAJE_CORREO=Mdl_Variables.Gstr_Ignore;//14
	public static String GstrBTN_ENVIAR_CORREO=Mdl_Variables.Gstr_Ignore;//15
	public static String GstrBTN_CERRAR_CORREO=Mdl_Variables.Gstr_Ignore;//16
	public static String GstrLNK_CERRAR_SESION=Mdl_Variables.Gstr_Ignore;//17
	public static String GstrFIRMAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE1=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE2=Mdl_Variables.Gstr_Ignore;
	public static String GstrFIRMANTE3=Mdl_Variables.Gstr_Ignore;
	public static String GstrOPERADOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONSULTA_HISTORICA= Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CONSULTA_SALDOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrRESULTADO_ESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrESTADO=Mdl_Variables.Gstr_Ignore;
	

	public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
		boolean bandera = true; 
		
		try{
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrTIE = Rst_Funcionalidad.getObject("TIE") != null ? Rst_Funcionalidad.getString("TIE") : Mdl_Variables.Gstr_Ignore;
			GstrCLAVE = Rst_Funcionalidad.getObject("CLAVE") != null ? Rst_Funcionalidad.getString("CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CAPCHA = Rst_Funcionalidad.getObject("TXT_CAPCHA") != null ? Rst_Funcionalidad.getString("TXT_CAPCHA") : Mdl_Variables.Gstr_Ignore;		
			GstrBTN_SIGUIENTE = Rst_Funcionalidad.getObject("BTN_SIGUIENTE") != null ? Rst_Funcionalidad.getString("BTN_SIGUIENTE") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_SIGUIENTE1 = Rst_Funcionalidad.getObject("BTN_SIGUIENTE1") != null ? Rst_Funcionalidad.getString("BTN_SIGUIENTE1") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_TRANSFERENCIAS = Rst_Funcionalidad.getObject("BTN_TRANSFERENCIAS") != null ? Rst_Funcionalidad.getString("BTN_TRANSFERENCIAS") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_A_OTROS_BANCOS_CCE = Rst_Funcionalidad.getObject("LNK_A_OTROS_BANCOS_CCE") != null ? Rst_Funcionalidad.getString("LNK_A_OTROS_BANCOS_CCE") : Mdl_Variables.Gstr_Ignore;			
			GstrIND_EMPRESA = Rst_Funcionalidad.getObject("IND_EMPRESA") != null ? Rst_Funcionalidad.getString("IND_EMPRESA") : Mdl_Variables.Gstr_Ignore;			
			GstrCMB_EMPRESA_CUENTA_ORIGEN = Rst_Funcionalidad.getObject("CMB_EMPRESA_CUENTA_ORIGEN") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA_CUENTA_ORIGEN") : Mdl_Variables.Gstr_Ignore;			
			GstrCMB_CUENTA_ORIGEN = Rst_Funcionalidad.getObject("CMB_CUENTA_ORIGEN") != null ? Rst_Funcionalidad.getString("CMB_CUENTA_ORIGEN") : Mdl_Variables.Gstr_Ignore;			
			GstrTXT_NUMERO_CUENTA_DESTINO = Rst_Funcionalidad.getObject("TXT_NUMERO_CUENTA_DESTINO") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CUENTA_DESTINO") : Mdl_Variables.Gstr_Ignore; 
			GstrCHK_EMPRESA_PROPIETARIA =Rst_Funcionalidad.getObject("CHK_EMPRESA_PROPIETARIA") != null ? Rst_Funcionalidad.getString("CHK_EMPRESA_PROPIETARIA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_EMPRESA = Rst_Funcionalidad.getObject("TXT_NOMBRE_EMPRESA") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_EMPRESA") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_DOCUMENTO_IDENTIDAD = Rst_Funcionalidad.getObject("CMB_TIPO_DOCUMENTO_IDENTIDAD") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO_IDENTIDAD") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NUMERO_IDENTIDAD = Rst_Funcionalidad.getObject("TXT_NUMERO_IDENTIDAD") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_IDENTIDAD") : Mdl_Variables.Gstr_Ignore;		
			GstrCMB_MONEDA = Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MONTO = Rst_Funcionalidad.getObject("TXT_MONTO") != null ? Rst_Funcionalidad.getString("TXT_MONTO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DESCRIPCION_TRANSFERENCIA = Rst_Funcionalidad.getObject("TXT_DESCRIPCION_TRANSFERENCIA") != null ? Rst_Funcionalidad.getString("TXT_DESCRIPCION_TRANSFERENCIA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUAR = Rst_Funcionalidad.getObject("BTN_CONTINUAR") != null ? Rst_Funcionalidad.getString("BTN_CONTINUAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_VER_DETALLE = Rst_Funcionalidad.getObject("LNK_VER_DETALLE") != null ? Rst_Funcionalidad.getString("LNK_VER_DETALLE") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_REGRESAR = Rst_Funcionalidad.getObject("LNK_REGRESAR") != null ? Rst_Funcionalidad.getString("LNK_REGRESAR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE = Rst_Funcionalidad.getObject("TXT_CLAVE") != null ? Rst_Funcionalidad.getString("TXT_CLAVE") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CLAVE_DINAMICA = Rst_Funcionalidad.getObject("TXT_CLAVE_DINAMICA") != null ? Rst_Funcionalidad.getString("TXT_CLAVE_DINAMICA") : Mdl_Variables.Gstr_Ignore;			
			GstrBTN_CONFIRMAR = Rst_Funcionalidad.getObject("BTN_CONFIRMAR") != null ? Rst_Funcionalidad.getString("BTN_CONFIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrNUMERO_SOLICITUD = Rst_Funcionalidad.getObject("NUMERO_SOLICITUD") != null ? Rst_Funcionalidad.getString("NUMERO_SOLICITUD") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_EMAIL = Rst_Funcionalidad.getObject("BTN_ENVIAR_EMAIL") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_EMAIL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CORREO = Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_CORREO = Rst_Funcionalidad.getObject("TXT_MENSAJE_CORREO") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_ENVIAR_CORREO = Rst_Funcionalidad.getObject("BTN_ENVIAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CERRAR_CORREO = Rst_Funcionalidad.getObject("BTN_CERRAR_CORREO") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_CORREO") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMAR = Rst_Funcionalidad.getObject("FIRMAR") != null ? Rst_Funcionalidad.getString("FIRMAR") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE1 = Rst_Funcionalidad.getObject("FIRMANTE1") != null ? Rst_Funcionalidad.getString("FIRMANTE1") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE2 = Rst_Funcionalidad.getObject("FIRMANTE2") != null ? Rst_Funcionalidad.getString("FIRMANTE2") : Mdl_Variables.Gstr_Ignore;
			GstrFIRMANTE3 = Rst_Funcionalidad.getObject("FIRMANTE3") != null ? Rst_Funcionalidad.getString("FIRMANTE3") : Mdl_Variables.Gstr_Ignore;
			GstrOPERADOR = Rst_Funcionalidad.getObject("OPERADOR") != null ? Rst_Funcionalidad.getString("OPERADOR") : Mdl_Variables.Gstr_Ignore;
			GstrLNK_CERRAR_SESION = Rst_Funcionalidad.getObject("LNK_CERRAR_SESION") != null ? Rst_Funcionalidad.getString("LNK_CERRAR_SESION") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONSULTA_HISTORICA = Rst_Funcionalidad.getObject("BTN_CONSULTA_HISTORICA") != null ? Rst_Funcionalidad.getString("BTN_CONSULTA_HISTORICA") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONSULTA_SALDOS=Rst_Funcionalidad.getObject("BTN_CONSULTA_SALDOS")!=null?Rst_Funcionalidad.getString("BTN_CONSULTA_SALDOS"):Mdl_Variables.Gstr_Ignore;
			GstrRESULTADO_ESPERADO=Rst_Funcionalidad.getObject("RESULTADO_ESPERADO")!=null?Rst_Funcionalidad.getString("RESULTADO_ESPERADO"):Mdl_Variables.Gstr_Ignore;
			GstrESTADO=Rst_Funcionalidad.getObject("ESTADO")!=null?Rst_Funcionalidad.getString("ESTADO"):Mdl_Variables.Gstr_Ignore;
			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());			
		}
		return bandera;
	}
	

}
