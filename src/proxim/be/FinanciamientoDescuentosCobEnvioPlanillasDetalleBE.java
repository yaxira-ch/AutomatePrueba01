package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobEnvioPlanillasDetalleBE {
	
	public static String GstrID_CASO=Mdl_Variables.Gstr_Ignore;
	public static String GstrNUM=Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_LOTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_PROVEDOR_AFILIADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUMERO_DOCUMENTOS=Mdl_Variables.Gstr_Ignore;
	public static String GstrID_CASO_DETALLE=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_TIPO_DOCUMENTO_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NRO_DOCUMENTO_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NOMBRE_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_APEPAT_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_APEMAT_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_DIRECCION_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrCMB_UBIGEO_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_AGREGAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NRO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MONTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_VENCIMIENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_OBSERVACION=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_ELIMINAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CREAR_PLANILLA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_COLUMNA_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_MENSAJE_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrDESIGN_STEPS=Mdl_Variables.Gstr_Ignore;
	public static String GstrDESCRIPTION=Mdl_Variables.Gstr_Ignore;
	public static String GstrESTADO_CASO=Mdl_Variables.Gstr_Ignore;
	public static String GstrUTILIZADO=Mdl_Variables.Gstr_Ignore;
	public static String GstrACIERTO_ERROR=Mdl_Variables.Gstr_Ignore;
	public static String GstrEJECUCION_AC_ERR=Mdl_Variables.Gstr_Ignore;
	public static String GstrHORA=Mdl_Variables.Gstr_Ignore;
	public static String GstrTIEMPO_EJECUCION_CASO=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_SI_ELIMINAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_NO_ELIMINAR=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_EMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_NOMBRE_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBN_DOCUMENTO_ACEPTANTE=Mdl_Variables.Gstr_Ignore;
	public static String GstrLBL_TIPO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_NUMERO_DOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_CARGO=Mdl_Variables.Gstr_Ignore;
	public static String GstrTXT_FECHA_ADELANTO=Mdl_Variables.Gstr_Ignore;
	public static String GstrLINK_VER=Mdl_Variables.Gstr_Ignore;
	public static String GstrBTN_CERRAR=Mdl_Variables.Gstr_Ignore;
	
	
	public boolean FinanDescuentosCobEnvioPlanillasDetalle(ResultSet Rst_Funcionalidad, int intOpcion){
		boolean bandera = true; 
		try {
			
			GstrID_CASO_LOTE= Rst_Funcionalidad.getObject( "ID_CASO_LOTE") != null ? Rst_Funcionalidad.getString("ID_CASO_LOTE") : Mdl_Variables.Gstr_Ignore;
			
			switch (intOpcion)
			{
				case 1: //Datos de aceptante
					GstrTXT_NUMERO_DOCUMENTOS= Rst_Funcionalidad.getObject("TXT_NUMERO_DOCUMENTOS") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_DOCUMENTOS") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_AGREGAR= Rst_Funcionalidad.getObject( "BTN_AGREGAR") != null ? Rst_Funcionalidad.getString("BTN_AGREGAR") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_DOCUMENTO_ACEPTANTE= Rst_Funcionalidad.getObject( "CMB_TIPO_DOCUMENTO_ACEPTANTE") != null ? Rst_Funcionalidad.getString("CMB_TIPO_DOCUMENTO_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NRO_DOCUMENTO_ACEPTANTE= Rst_Funcionalidad.getObject( "TXT_NRO_DOCUMENTO_ACEPTANTE") != null ? Rst_Funcionalidad.getString("TXT_NRO_DOCUMENTO_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NOMBRE_ACEPTANTE= Rst_Funcionalidad.getObject( "TXT_NOMBRE_ACEPTANTE") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_APEPAT_ACEPTANTE= Rst_Funcionalidad.getObject( "TXT_APEPAT_ACEPTANTE") != null ? Rst_Funcionalidad.getString("TXT_APEPAT_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_APEMAT_ACEPTANTE= Rst_Funcionalidad.getObject( "TXT_APEMAT_ACEPTANTE") != null ? Rst_Funcionalidad.getString("TXT_APEMAT_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_DIRECCION_ACEPTANTE= Rst_Funcionalidad.getObject( "TXT_DIRECCION_ACEPTANTE") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_UBIGEO_ACEPTANTE= Rst_Funcionalidad.getObject( "CMB_UBIGEO_ACEPTANTE") != null ? Rst_Funcionalidad.getString("CMB_UBIGEO_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrLINK_VER= Rst_Funcionalidad.getObject( "LINK_VER") != null ? Rst_Funcionalidad.getString("LINK_VER") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_CERRAR= Rst_Funcionalidad.getObject( "BTN_CERRAR") != null ? Rst_Funcionalidad.getString("BTN_CERRAR") : Mdl_Variables.Gstr_Ignore;
					
//					GstrTXT_COLUMNA_ERROR= Rst_Funcionalidad.getObject( "TXT_COLUMNA_ERROR_AGREGAR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR_AGREGAR") : Mdl_Variables.Gstr_Ignore;
//					GstrTXT_MENSAJE_ERROR= Rst_Funcionalidad.getObject( "TXT_MENSAJE_ERROR_AGREGAR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR_AGREGAR") : Mdl_Variables.Gstr_Ignore;
					break;
					
				case 2: //Datos con detalle
					
					GstrID_CASO= Rst_Funcionalidad.getObject( "ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
					GstrNUM= Rst_Funcionalidad.getObject( "NUM") != null ? Rst_Funcionalidad.getString("NUM") : Mdl_Variables.Gstr_Ignore;
					
					GstrBTN_ELIMINAR= Rst_Funcionalidad.getObject( "BTN_ELIMINAR") != null ? Rst_Funcionalidad.getString("BTN_ELIMINAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_SI_ELIMINAR= Rst_Funcionalidad.getObject( "BTN_SI_ELIMINAR") != null ? Rst_Funcionalidad.getString("BTN_SI_ELIMINAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_NO_ELIMINAR= Rst_Funcionalidad.getObject( "BTN_NO_ELIMINAR") != null ? Rst_Funcionalidad.getString("BTN_NO_ELIMINAR") : Mdl_Variables.Gstr_Ignore;
					GstrLBN_EMPRESA= Rst_Funcionalidad.getObject( "LBN_EMPRESA") != null ? Rst_Funcionalidad.getString("LBN_EMPRESA") : Mdl_Variables.Gstr_Ignore;
					GstrLBN_NOMBRE_ACEPTANTE= Rst_Funcionalidad.getObject( "LBN_NOMBRE_ACEPTANTE") != null ? Rst_Funcionalidad.getString("LBN_NOMBRE_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					GstrLBN_DOCUMENTO_ACEPTANTE= Rst_Funcionalidad.getObject( "LBN_DOCUMENTO_ACEPTANTE") != null ? Rst_Funcionalidad.getString("LBN_DOCUMENTO_ACEPTANTE") : Mdl_Variables.Gstr_Ignore;
					//GstrLBL_TIPO_DOCUMENTO= Rst_Funcionalidad.getObject( "LBL_TIPO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("LBL_TIPO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NUMERO_DOCUMENTO= Rst_Funcionalidad.getObject( "TXT_NRO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("TXT_NRO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MONTO= Rst_Funcionalidad.getObject( "TXT_MONTO") != null ? Rst_Funcionalidad.getString("TXT_MONTO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_FECHA_VENCIMIENTO= Rst_Funcionalidad.getObject( "TXT_FECHA_VENCIMIENTO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_VENCIMIENTO") : Mdl_Variables.Gstr_Ignore;
					//GstrTXT_FECHA_CARGO= Rst_Funcionalidad.getObject( "TXT_FECHA_CARGO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_CARGO") : Mdl_Variables.Gstr_Ignore;
					//GstrTXT_FECHA_ADELANTO= Rst_Funcionalidad.getObject( "TXT_FECHA_ADELANTO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_ADELANTO") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_OBSERVACION= Rst_Funcionalidad.getObject( "TXT_OBSERVACION") != null ? Rst_Funcionalidad.getString("TXT_OBSERVACION") : Mdl_Variables.Gstr_Ignore;
					
					
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
