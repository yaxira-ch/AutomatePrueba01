package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ObjetosGenerales;
import proxim.be.TransfATercerosPortabilidadBE;
import proxim.be.TransferenciaBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PortabilidadTransfATercerosMapeo extends TransfATercerosPortabilidadBE{
	
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	
	String urlBtnTransferencias="//html/body/div[1]/div/div/div[2]/div/ul/li[2]/a";
	String urlBtnTransferenciaATerceros="//html/body/div[1]/div/div/div/div/div/ul/li[2]/a";
	String urlCmbEmpresa="//*[@id='cboEmpresaOrigen']";
	String urlCmbTipoCuenta="//*[@id='cboTipoCuentaDestino']";
	String urlTxtNumeroCuentaDestino="//*[@id='txtNumeroCuentaDestino']";
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

	public boolean TransferenciaATerceros() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnTransferenciaATerceros);
	}

	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, urlCmbEmpresa, strEmpresa);
	}

	public boolean seleccionarCuentaOrigen(String strCuentaOrigen) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.id, "cboCuentaOrigen", strCuentaOrigen);
	}

	public boolean seleccionarTipoCuenta(String strTipoCuenta) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, urlCmbTipoCuenta, strTipoCuenta);
	}

	public boolean ingresarNumeroCuentaDestino(String strNumeroCuentaDestino) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtNumeroCuentaDestino, strNumeroCuentaDestino);
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
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtDescripcionTransferencia, strDescripcionTransferencia);
	}

	public boolean continuar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnContinuar);
	}
	
	public void validarConfirmacionTransferencia() throws SQLException, IOException, InterruptedException{/*
		String campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[1]/div/div/p");
		String NuevoValor="";
		int j=2;
		String valoresDiferentes="";
		String strNuevoValor1="";
		String strDetalle="";
		while(campo.equals("Confirma tu operación")){
			strDetalle=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div["+j+"]/span");
			
			switch(strDetalle){
				case "Cuenta de Origen":
					NuevoValor="Cuenta de Origen\n"+GstrCMB_CUENTA_ORIGEN+"\nde "+ GstrCMB_EMPRESA;
					strNuevoValor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div[2]");
					if(!NuevoValor.equals(strNuevoValor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNuevoValor1+"\n";
					break;
					
				case "Cuenta de Destino":	
					NuevoValor="Cuenta de Destino\n"+GstrCMB_TIPO_CUENTA+"\n "+GstrTXT_NUMERO_CUENTA_DESTINO;
					strNuevoValor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div[3]");
					campo=strDetalle;
					if(!NuevoValor.equals(strNuevoValor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNuevoValor1+"\n";
					break;
			}
			j++;	
		}
		
		if(!valoresDiferentes.equals(""))
			System.out.println("Caso: "+PortabilidadAutorizacionBL.Gstr_ID_CASO+" - Valores diferentes en Pantalla de Confirmación: \n"  + valoresDiferentes);
	*/}
	

	public boolean verDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnVerDetalle);
	}

	public void validarDetalleTransferencia() throws InterruptedException, IOException{/*
		String campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[1]/div/div/p");
		String NuevoValor="";
		int j=1;
		String valoresDiferentes="";
		String strNuevoValor1="";
		String strDetalle="";
		while(campo.equals("Detalle de operación")){
			if( ((TransfATercerosPortabilidadBE.GstrCMB_TIPO_CUENTA.contains("Soles") && 
					TransfATercerosPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Soles")&&  
					TransfATercerosPortabilidadBE.GstrCMB_MONEDA.contains("Soles"))||
					(TransfATercerosPortabilidadBE.GstrCMB_TIPO_CUENTA.contains("Dólares") && 
					TransfATercerosPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Dólares")&&  
					TransfATercerosPortabilidadBE.GstrCMB_MONEDA.contains("Dólares")))&&j==3){
					break;
				}else{
					strDetalle=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p["+j+"]/span");
				}
			
			switch(strDetalle){
				case "Cuenta de Origen":
					NuevoValor=GstrCMB_CUENTA_ORIGEN+"\nde "+GstrCMB_EMPRESA;
					strNuevoValor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[1]/b");
					if(!NuevoValor.equals(strNuevoValor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNuevoValor1+"\n";
					break;
					
				case "Cuenta de Destino":	
					NuevoValor=GstrCMB_TIPO_CUENTA+"\n "+GstrTXT_NUMERO_CUENTA_DESTINO;
					strNuevoValor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[2]/b");
					if(!NuevoValor.equals(strNuevoValor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNuevoValor1+"\n";
					break;

				case "Tipo de Cambio":
					NuevoValor=Mdl_Variables.GstrTipoCambio;  
					strNuevoValor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[3]/b");
					if(!NuevoValor.equals(strNuevoValor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNuevoValor1+"\n";
					break;
					
				case "Monto Convertido":	
					NuevoValor=Mdl_Variables.GstrMontoConvertido;
					strNuevoValor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[4]/b");
					campo=strDetalle;
					if(!NuevoValor.equals(strNuevoValor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNuevoValor1+"\n";
					break;
			}
			j++;	
		}
		
		if(!valoresDiferentes.equals(""))
			System.out.println("Caso: "+PortabilidadAutorizacionBL.GstrID_CASO_LOTE+" - Valores diferentes en Detalle de la Trasferencia: \n"  + valoresDiferentes);
	*/}

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
	
		TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA=TransfATercerosPortabilidadBE.GstrTXT_DESCRIPCION_TRANSFERENCIA;
		
		Mdl_Variables.GstrTotalPagar=objObjetosGenerales.formatearMonto("Transferencias", objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[1]/div/ul/li/div/b[2]"));
		
		return valor;	
	


												

	}
	

	

	



}
