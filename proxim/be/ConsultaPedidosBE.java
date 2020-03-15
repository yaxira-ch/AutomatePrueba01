package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class ConsultaPedidosBE {

	public static String strIdCASO=Mdl_Variables.Gstr_Ignore;
	public static String strIdCasoLOGIN=Mdl_Variables.Gstr_Ignore;
	public static String strCmbEMPRESA=Mdl_Variables.Gstr_Ignore;
	public static String strCmbPRODUCTO=Mdl_Variables.Gstr_Ignore;
	public static String strCmbTIPO=Mdl_Variables.Gstr_Ignore;
	public static String strLnkAQUI=Mdl_Variables.Gstr_Ignore;
	public static String strCmbCargoABONO=Mdl_Variables.Gstr_Ignore;
	public static String strCmbDeCUANDO=Mdl_Variables.Gstr_Ignore;
	public static String strCmbCUENTA=Mdl_Variables.Gstr_Ignore;
	public static String strTxtCOMENTARIO=Mdl_Variables.Gstr_Ignore;
	public static String strLnkADJUNTAR=Mdl_Variables.Gstr_Ignore;
	public static String strTxtCORREO=Mdl_Variables.Gstr_Ignore;
	public static String strTxtTELEFONO=Mdl_Variables.Gstr_Ignore;
	public static String strTxtTituloPOPUP=Mdl_Variables.Gstr_Ignore;
	public static String strTxtMensajePOPUP=Mdl_Variables.Gstr_Ignore;
	public static String strBtnCerrarPOPUP=Mdl_Variables.Gstr_Ignore;
	public static String strLnkAquiPOPUP=Mdl_Variables.Gstr_Ignore;
	public static String strRutaARCHIVO=Mdl_Variables.Gstr_Ignore;
	public static String strTxtTituloREDIRECCION=Mdl_Variables.Gstr_Ignore;
	public static String strBtnENVIAR=Mdl_Variables.Gstr_Ignore;
	public static String strTxtResultadoESPERADO=Mdl_Variables.Gstr_Ignore;
	public static String strBtnNuevaCONSULTA=Mdl_Variables.Gstr_Ignore;
	public static String strTxtColumnaERROR=Mdl_Variables.Gstr_Ignore;
	public static String strTxtMensajeERROR=Mdl_Variables.Gstr_Ignore;		
	public static String strCmbDOCUMENTO=Mdl_Variables.Gstr_Ignore;
	public static String strLbnCAMPO=Mdl_Variables.Gstr_Ignore;
	public static String strLbnMensajeCAMPO=Mdl_Variables.Gstr_Ignore;
	public static String strTxtNuneroCHEQUE=Mdl_Variables.Gstr_Ignore;
	public static String strTxtImporte=Mdl_Variables.Gstr_Ignore;
	public static String strCmbMoneda=Mdl_Variables.Gstr_Ignore;
	public static String strCmbCOMBO=Mdl_Variables.Gstr_Ignore;
	public static String strCmbModuloWEB=Mdl_Variables.Gstr_Ignore;//sp22
	public static String strTxtTieAFECTADA=Mdl_Variables.Gstr_Ignore;//sp22
	public static String strTxtFecha=Mdl_Variables.Gstr_Ignore;//sp22

		public boolean obtenerCamposBD(ResultSet Rst_Funcionalidad){
			boolean bandera = true; 
			try {
				strIdCASO=Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
				strIdCasoLOGIN=Rst_Funcionalidad.getObject("ID_CASO_LOGIN") != null ? Rst_Funcionalidad.getString("ID_CASO_LOGIN") : Mdl_Variables.Gstr_Ignore;
				strCmbEMPRESA=Rst_Funcionalidad.getObject("CMB_EMPRESA") != null ? Rst_Funcionalidad.getString("CMB_EMPRESA") : Mdl_Variables.Gstr_Ignore;
				strCmbPRODUCTO=Rst_Funcionalidad.getObject("CMB_PRODUCTO") != null ? Rst_Funcionalidad.getString("CMB_PRODUCTO") : Mdl_Variables.Gstr_Ignore;
				strCmbTIPO=Rst_Funcionalidad.getObject("CMB_TIPO") != null ? Rst_Funcionalidad.getString("CMB_TIPO") : Mdl_Variables.Gstr_Ignore;
				strLnkAQUI=Rst_Funcionalidad.getObject("LNK_AQUI") != null ? Rst_Funcionalidad.getString("LNK_AQUI") : Mdl_Variables.Gstr_Ignore;
				strCmbCargoABONO=Rst_Funcionalidad.getObject("CMB_CARGO_ABONO") != null ? Rst_Funcionalidad.getString("CMB_CARGO_ABONO") : Mdl_Variables.Gstr_Ignore;
				strCmbDeCUANDO=Rst_Funcionalidad.getObject("CMB_DE_CUANDO") != null ? Rst_Funcionalidad.getString("CMB_DE_CUANDO") : Mdl_Variables.Gstr_Ignore;
				strCmbCUENTA=Rst_Funcionalidad.getObject("CMB_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_CUENTA") : Mdl_Variables.Gstr_Ignore;
				strTxtCOMENTARIO=Rst_Funcionalidad.getObject("TXT_COMENTARIO") != null ? Rst_Funcionalidad.getString("TXT_COMENTARIO") : Mdl_Variables.Gstr_Ignore;
				strLnkADJUNTAR=Rst_Funcionalidad.getObject("LNK_ADJUNTAR") != null ? Rst_Funcionalidad.getString("LNK_ADJUNTAR") : Mdl_Variables.Gstr_Ignore;
				strTxtCORREO=Rst_Funcionalidad.getObject("TXT_CORREO") != null ? Rst_Funcionalidad.getString("TXT_CORREO") : Mdl_Variables.Gstr_Ignore;
				strTxtTELEFONO=Rst_Funcionalidad.getObject("TXT_TELEFONO") != null ? Rst_Funcionalidad.getString("TXT_TELEFONO") : Mdl_Variables.Gstr_Ignore;
				strTxtTituloPOPUP=Rst_Funcionalidad.getObject("TXT_TITULO_POPUP") != null ? Rst_Funcionalidad.getString("TXT_TITULO_POPUP") : Mdl_Variables.Gstr_Ignore;
				strTxtMensajePOPUP=Rst_Funcionalidad.getObject("TXT_MENSAJE_POPUP") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_POPUP") : Mdl_Variables.Gstr_Ignore;
				strBtnCerrarPOPUP=Rst_Funcionalidad.getObject("BTN_CERRAR_POPUP") != null ? Rst_Funcionalidad.getString("BTN_CERRAR_POPUP") : Mdl_Variables.Gstr_Ignore;
				strLnkAquiPOPUP=Rst_Funcionalidad.getObject("LNK_AQUI_POPUP") != null ? Rst_Funcionalidad.getString("LNK_AQUI_POPUP") : Mdl_Variables.Gstr_Ignore;
				strRutaARCHIVO=Rst_Funcionalidad.getObject("RUTA_ARCHIVO") != null ? Rst_Funcionalidad.getString("RUTA_ARCHIVO") : Mdl_Variables.Gstr_Ignore;
				strTxtTituloREDIRECCION=Rst_Funcionalidad.getObject("TXT_TITULO_REDIRECCION") != null ? Rst_Funcionalidad.getString("TXT_TITULO_REDIRECCION") : Mdl_Variables.Gstr_Ignore;
				strBtnENVIAR=Rst_Funcionalidad.getObject("BTN_ENVIAR") != null ? Rst_Funcionalidad.getString("BTN_ENVIAR") : Mdl_Variables.Gstr_Ignore;
				strTxtResultadoESPERADO=Rst_Funcionalidad.getObject("TXT_RESULTADO_ESPERADO") != null ? Rst_Funcionalidad.getString("TXT_RESULTADO_ESPERADO") : Mdl_Variables.Gstr_Ignore;
				strBtnNuevaCONSULTA=Rst_Funcionalidad.getObject("BTN_NUEVA_CONSULTA") != null ? Rst_Funcionalidad.getString("BTN_NUEVA_CONSULTA") : Mdl_Variables.Gstr_Ignore;
				strTxtColumnaERROR=Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
				strTxtMensajeERROR=Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
				strCmbDOCUMENTO=Rst_Funcionalidad.getObject("CMB_DOCUMENTO") != null ? Rst_Funcionalidad.getString("CMB_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				strLbnCAMPO=Rst_Funcionalidad.getObject("LBN_CAMPO") != null ? Rst_Funcionalidad.getString("LBN_CAMPO") : Mdl_Variables.Gstr_Ignore;
				strLbnMensajeCAMPO=Rst_Funcionalidad.getObject("LBN_MENSAJE_CAMPO") != null ? Rst_Funcionalidad.getString("LBN_MENSAJE_CAMPO") : Mdl_Variables.Gstr_Ignore;
				strTxtNuneroCHEQUE=Rst_Funcionalidad.getObject("TXT_NUMERO_CHEQUE") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CHEQUE") : Mdl_Variables.Gstr_Ignore;
				strCmbCOMBO=Rst_Funcionalidad.getObject("CMB_COMBO") != null ? Rst_Funcionalidad.getString("CMB_COMBO") : Mdl_Variables.Gstr_Ignore;
				strCmbModuloWEB=Rst_Funcionalidad.getObject("CMB_MODULO_WEB") != null ? Rst_Funcionalidad.getString("CMB_MODULO_WEB") : Mdl_Variables.Gstr_Ignore;
				strTxtTieAFECTADA=Rst_Funcionalidad.getObject("TXT_TIE_AFECTADA") != null ? Rst_Funcionalidad.getString("TXT_TIE_AFECTADA") : Mdl_Variables.Gstr_Ignore;
				strTxtImporte=Rst_Funcionalidad.getObject("TXT_IMPORTE") != null ? Rst_Funcionalidad.getString("TXT_IMPORTE") : Mdl_Variables.Gstr_Ignore;
				strCmbMoneda=Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				strTxtFecha=Rst_Funcionalidad.getObject("TXT_FECHA") != null ? Rst_Funcionalidad.getString("TXT_FECHA") : Mdl_Variables.Gstr_Ignore;
				
			} catch (Exception e) {
				bandera = false; 
				e.printStackTrace();
				System.out.println("Error:"  + e.getMessage());
				
			}
			return bandera;
		}
	}

