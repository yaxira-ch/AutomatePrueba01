package proxim.bl;

import java.io.IOException;


import proxim.be.ObjetosGenerales;
import proxim.be.PortabilidadAutorizacionBE;
import proxim.be.TransfATercerosPortabilidadBE;
import proxim.be.TransfOtrosBancosCCEPortabilidadBE;
import proxim.be.TransferenciaBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PortabilidadTransfOtrosBancosCCEMapeo {
	
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	

	String urlBtnTransferencias="//html/body/div[1]/div/div/div[2]/div/ul/li[2]/a";
	String urlBtnTransferenciasAOtrosBancosCCE="/html/body/div[1]/div/div/div/div/div/ul/li[3]/a";//CAMBIAR
	String urlCmbEmpresa="//*[@id='cboEmpresaOrigen']";
	String urlCmbEmpresaSaldo="//*[@id='empresaCombo']";
	//String urlCmbTipoCuenta="//*[@id='cboTipoCuentaDestino']";
	String urlTxtNumeroCuentaDestino="//*[@id='txtNumeroCuentaDestino']";
	String urlChkEmpresaPropietaria="/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/label";
	String urlTxtNombreEmpresa="txtNombreBeneficiario";
	String urlCmbTipoDocumentoIdentidad="//*[@id='cboDocumento']";
	String urlTxtDocumentoIdentidad="//*[@id='txtDocumento']";
	String urlCmbMoneda="";
	String urlTxtMonto="//*[@id='txtMonto']";
	String urlTxtDescripcionTransferencia="//*[@id='txtDescripcion']";
	String urlBtnContinuar="//*[@id='lnk_confirmar']";
	String urlBtnVerDetalle="//*[@id='lnk_mostrar_detalle']";
	String urlBtnRegresar="//*[@id='lnk_retornar_confirmar']";
	String urlTxtClaveConfirmacion="//*[@id='password']";
	String urlTxtClaveDinamica="//*[@id='clave_dinamica']";
	String urlBtnConfirmar="//*[@id='lkn_confirmar']";
	String urlBtnEnviarEmail="//html/body/div[1]/div[1]/footer/div/div/a";
	String urlTxtCorreo="//*[@id='destinatario']";
	String urlTxtMensajeCorreo="//*[@id='mensaje']";
	String urlBtnEnviar="//*[@id='enviar']";
	String urlBtnCerrarCorreo="//html/body/div[1]/div[1]/div[2]/div/a";
	
	public boolean Transferencias() {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnTransferencias);
	}

	public boolean TransferenciaAOtrosBancosCCE() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnTransferenciasAOtrosBancosCCE);
	}
	
	public boolean listarEmpresas() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='cboEmpresaOrigen-button']");

	}
	
	public boolean clickVacio() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[1]/div/div/div[1]/div/div/p");
	}

	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, urlCmbEmpresa, strEmpresa);
	}
	
	public boolean seleccionarEmpresaConsultaSaldo(String strEmpresa) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, urlCmbEmpresaSaldo, strEmpresa);
	}
	
	public boolean listarCuentas() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='cboCuentaOrigen-button']");
	}

	public boolean seleccionarCuentaOrigen(String strCuentaOrigen) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.id, "cboCuentaOrigen", strCuentaOrigen);
	}

	public boolean ingresarNumeroCuentaDestino(String strNumeroCuentaDestino) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtNumeroCuentaDestino, strNumeroCuentaDestino);
	}
	public boolean checkEmpresaPropietaria() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlChkEmpresaPropietaria);
	}
	public boolean ingresarNombreEmpresa(String strNombreEmpresa) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.id, urlTxtNombreEmpresa, strNombreEmpresa);
	}
	
	public boolean listarTipoDocumentos() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='cboDocumento-button']");
	}
	
	public boolean seleccionarTipoDocumentoIdentidad(String strTipoDocuemnto) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, urlCmbTipoDocumentoIdentidad, strTipoDocuemnto);
	}
	
	
	public boolean ingresarDocumentoIdentidad(String strDocumentoIdentidad) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtDocumentoIdentidad, strDocumentoIdentidad);
	}

	public boolean listarTipoMoneda() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='cboMoneda-button']");
	}
	
	public boolean seleccionarMoneda(String strMoneda) throws InterruptedException, IOException{
		String strMonedaValor=null;
		if(strMoneda.equals("Soles")){
			strMonedaValor="S/";
		}else{
			strMonedaValor="US$";
		}
		
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.id, "cboMoneda",strMonedaValor);
	}
	
	public boolean ingresarMonto(String strMonto) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtMonto, strMonto);
	}

	public boolean ingresarDescripcionTransferencia(String strDescripcionTransferencia) throws InterruptedException, IOException{
		TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA=TransfOtrosBancosCCEPortabilidadBE.GstrTXT_DESCRIPCION_TRANSFERENCIA;;
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtDescripcionTransferencia, strDescripcionTransferencia);
	}

	public boolean continuar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnContinuar);
	}
	
	public boolean verDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnVerDetalle);
	}
	
	public boolean regresar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnRegresar);	
	}

	public boolean ingresoClave(String strClaveConfirmacion) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtClaveConfirmacion, strClaveConfirmacion);
	}

	public boolean ingresoClaveDinamica(String strClaveDinamica) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtClaveDinamica, strClaveDinamica);
	}

	public boolean confirmar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnConfirmar);
	}

	public boolean compararMensajeError(String strMensajeError) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtMonto, strMensajeError);
	}

	public boolean enviarEmail() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnEnviarEmail);
	}

	public boolean ingresarCorreo(String strCorreo) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtCorreo, strCorreo);
	}

	public boolean ingresarMensajeCorreo(String strMensajeCorreo) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtMensajeCorreo, strMensajeCorreo);
	}

	public boolean enviar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnEnviar);
	}

	public boolean cerrarCorreo() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnCerrarCorreo);
	}
	
	public boolean guardarIdTabla() throws InterruptedException, IOException{
		Mdl_Variables.GstrNumeroSolicitud =objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p[1]/b");
		TransferenciaBE.GstrNUMERO_SOLICITUD=	Mdl_Variables.GstrNumeroSolicitud;
		boolean	valor= objConexionSqlServer.modificarNumeroSolicitud(Mdl_Variables.GstrNumeroSolicitud);
		PortabilidadTransfATercerosBL.GstrNUMERO_SOLICITUD=Mdl_Variables.GstrNumeroSolicitud;
	
		TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA=TransfOtrosBancosCCEPortabilidadBE.GstrTXT_DESCRIPCION_TRANSFERENCIA;
		PortabilidadAutorizacionBE.GstrLBL_DESCRIPCION=TransfOtrosBancosCCEPortabilidadBE.GstrTXT_DESCRIPCION_TRANSFERENCIA;
		TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN=TransfOtrosBancosCCEPortabilidadBE.GstrCMB_EMPRESA_CUENTA_ORIGEN;
		TransferenciaBE.GstrESTADO=TransfOtrosBancosCCEPortabilidadBE.GstrESTADO;
		Mdl_Variables.GstrTotalPagar=objObjetosGenerales.formatearMonto("Transferencias", objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[1]/div/ul/li/div/b[2]"));
		TransferenciaBE.GstrTOTAL_PAGAR=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[1]/div/ul/li/div/b[2]");
		return valor;									

	}


}
