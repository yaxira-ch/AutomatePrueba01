package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class PagosRecibosDetalleBE {

	public static String GstrID_CASOPAGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_TODOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrIMG_EDITAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrIMG_ELIMINAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrIMG_GUARDAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrIMG_DESHACER=Mdl_Variables.Gstr_Ignore;
	public static String GstrIMG_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_EMPRESA_BUSCAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLST_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_SERVICIO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CODIGO_DEUDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_NUEVO_REGISTRO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCHK_TODOS1=Mdl_Variables.Gstr_Ignore;
	public static String GstrDATOS_DEUDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_MODO_PAGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_PAGAR_SOLES=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_PAGAR_DOLARES=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO_PAGAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MODO_PAGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_CONSULTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_FILTRADO_POR=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_DEUDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_DEUDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_PAGO_DESDE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_PAGO_HASTA=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_BUSCAR_CONSULTA=Mdl_Variables.Gstr_Ignore;
	public static String[] GstrTempMontos;

	public static String GstrLNK_ENVIAR_EMAIL_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_ENVIAR_TEXTO_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_CON_HIS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_CON_HIS=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_EMAIL_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_TOTAL_DIAS=Mdl_Variables.Gstr_Ignore;
	
	public static String GstrLNK_ENVIAR_EMAIL_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_CORREO_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_CORREO_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ENVIAR_CORREO_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ACEPTAR_CORREO_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_EXCEL_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_EXPORTAR_PDF_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_IMPRIMIR_CH_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBUSCAR_DEUDOR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_REGRESAR_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLNK_NUMERO_OPERACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_SERVICIO_RECAUDACION=Mdl_Variables.Gstr_Ignore;
		
		public boolean PagRecibosDetalle(ResultSet Rst_Funcionalidad, int num){
			boolean bandera = true; 
			try {
				GstrID_CASOPAGO=Rst_Funcionalidad.getObject("ID_CASOPAGO") != null ? Rst_Funcionalidad.getString("ID_CASOPAGO") : Mdl_Variables.Gstr_Ignore;
				GstrLST_EMPRESA = Rst_Funcionalidad.getObject("LST_EMPRESA") != null ? Rst_Funcionalidad.getString("LST_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				GstrCMB_SERVICIO= Rst_Funcionalidad.getObject("CMB_SERVICIO") != null ? Rst_Funcionalidad.getString("CMB_SERVICIO") : Mdl_Variables.Gstr_Ignore;
				GstrTXT_CODIGO_DEUDOR= Rst_Funcionalidad.getObject("TXT_CODIGO_DEUDOR") != null ? Rst_Funcionalidad.getString("TXT_CODIGO_DEUDOR") : Mdl_Variables.Gstr_Ignore;
				
				
				if (num==1){
					//GstrID_CASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
					GstrCHK_TODOS=Rst_Funcionalidad.getObject("CHK_TODOS") != null ? Rst_Funcionalidad.getString("CHK_TODOS") : Mdl_Variables.Gstr_Ignore;

					GstrIMG_EDITAR=Rst_Funcionalidad.getObject("IMG_EDITAR") != null ? Rst_Funcionalidad.getString("IMG_EDITAR") : Mdl_Variables.Gstr_Ignore;
					GstrIMG_ELIMINAR = Rst_Funcionalidad.getObject("IMG_ELIMINAR") != null ? Rst_Funcionalidad.getString("IMG_ELIMINAR") : Mdl_Variables.Gstr_Ignore;
					GstrIMG_GUARDAR = Rst_Funcionalidad.getObject("IMG_GUARDAR") != null ? Rst_Funcionalidad.getString("IMG_GUARDAR") : Mdl_Variables.Gstr_Ignore;
					GstrIMG_DESHACER = Rst_Funcionalidad.getObject("IMG_DESHACER") != null ? Rst_Funcionalidad.getString("IMG_DESHACER") : Mdl_Variables.Gstr_Ignore;
					GstrIMG_BUSCAR = Rst_Funcionalidad.getObject("IMG_BUSCAR") != null ? Rst_Funcionalidad.getString("IMG_BUSCAR") : Mdl_Variables.Gstr_Ignore;
					
					GstrTXT_EMPRESA_BUSCAR= Rst_Funcionalidad.getObject("TXT_EMPRESA_BUSCAR") != null ? Rst_Funcionalidad.getString("TXT_EMPRESA_BUSCAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_ACEPTAR = Rst_Funcionalidad.getObject("BTN_ACEPTAR") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_NUEVO_REGISTRO = Rst_Funcionalidad.getObject("BTN_NUEVO_REGISTRO") != null ? Rst_Funcionalidad.getString("BTN_NUEVO_REGISTRO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;

					
				}else{
					
					GstrTXT_EMPRESA_BUSCAR= Rst_Funcionalidad.getObject("TXT_EMPRESA_BUSCAR") != null ? Rst_Funcionalidad.getString("TXT_EMPRESA_BUSCAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_NUEVO_REGISTRO = Rst_Funcionalidad.getObject("BTN_NUEVO_REGISTRO") != null ? Rst_Funcionalidad.getString("BTN_NUEVO_REGISTRO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
					
					GstrCHK_TODOS1= Rst_Funcionalidad.getObject("CHK_TODOS1") != null ? Rst_Funcionalidad.getString("CHK_TODOS1") : Mdl_Variables.Gstr_Ignore;
					GstrDATOS_DEUDOR = Rst_Funcionalidad.getObject("DATOS_DEUDOR") != null ? Rst_Funcionalidad.getString("DATOS_DEUDOR") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_MODO_PAGO = Rst_Funcionalidad.getObject("CMB_MODO_PAGO") != null ? Rst_Funcionalidad.getString("CMB_MODO_PAGO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MONTO_PAGAR_SOLES= Rst_Funcionalidad.getObject("TXT_MONTO_PAGAR_SOLES") != null ? Rst_Funcionalidad.getString("TXT_MONTO_PAGAR_SOLES") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MONTO_PAGAR_DOLARES= Rst_Funcionalidad.getObject("TXT_MONTO_PAGAR_DOLARES") != null ? Rst_Funcionalidad.getString("TXT_MONTO_PAGAR_DOLARES") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MONTO_PAGAR= Rst_Funcionalidad.getObject("TXT_MONTO_PAGAR") != null ? Rst_Funcionalidad.getString("TXT_MONTO_PAGAR") : Mdl_Variables.Gstr_Ignore;
					
					GstrTXT_MODO_PAGO= Rst_Funcionalidad.getObject("TXT_MODO_PAGO") != null ? Rst_Funcionalidad.getString("TXT_MODO_PAGO") : Mdl_Variables.Gstr_Ignore;
				}
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
				
			}
			return bandera;
		}	
	}