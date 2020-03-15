package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.AutorizacionesPendientesBE;
import proxim.be.ObjetosGenerales;
import proxim.be.TransferenciasExteriorBE;
import proxim.dao.Mdl_Variables;

public class TransferenciaExteriorMapeo {
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	static Map<String,String> mapValores;
	String urlMenu="//html/body/div[2]/div[2]/div/ul/li[6]/a/span";
	String urlSubMenu="//html/body/div[2]/div[2]/div/ul/li[6]/div/div/ul/li[1]/div[1]/a/span";
	String urlExitMenu="//html/body/div[2]/div[1]/div[2]/div[2]/ul/li";
	String urlCmbEmpresa="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/select";
	String urlTxtNombreOrdenante="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/span";
	String urlTxtDireccionOrdenante="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/input";
	String urlTxtTelefonoOrdenante="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/input";
	String urlTxtEmailOrdenante="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlCmbMoneda="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlTxtMonto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlCmbCuentaCargo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/select";
	String urlTxtNumeroTicket="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlTxtFechaCargo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td/table/tbody/tr/td[1]/input";
	String urlTxtNombreBeneficiario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/input";
	String urlCmbTipoDocumentoBeneficiario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlTxtNumeroDocumentoBeneficiario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlTxtDireccionBeneficiario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/input";
	String urlCmbPaisBeneficiario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlTxtCiudadBeneficiario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlTxtTelefonoBeneficiario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input";
	String urlTxtCuentaAbono="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td/input";	
	String urlTxtNombreBanco="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/input";
	String urlCmbPaisBanco="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlTxtCiudadBanco="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlCmbTipoCodigoBanco="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlTxtCodigoBanco="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlChkBancoIntermediario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td/span/input";
	String urlTxtNombreBancoIntermediario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[5]/td/div/table[1]/tbody/tr/td/table/tbody/tr[2]/td/input";
	String urlCmbPaisBancoIntermediario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[5]/td/div/table[2]/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlTxtCiudadBancoIntermediario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[5]/td/div/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlCmbTipoCodigoBancoIntermediario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[5]/td/div/table[3]/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlTxtCodigoBancoIntermediario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[2]/table/tbody/tr[5]/td/div/table[3]/tbody/tr/td[2]/table/tbody/tr[2]/td/input";
	String urlCmbMotivoTransferencia="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select";
	String urlCmbGastosCorresponsal="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/select";
	String urlTxtDetallePago="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/textarea";
	String urlBtnGuardar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/button[1]";
	String urlBtnEnviar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/button[2]";
	String urlLnkTerminosCondiciones="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[7]/div/a";
	String urlBtnCerrarTerminosCondiciones="//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a";
	String urlChkAceptoTerminosCondiciones="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[7]/div/span[1]/input";
	String urlBtnConfirmar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[10]/button[1]";


	public boolean verificarCamObligatoriosNuevaSolicitud(){  
		boolean blnResultado=false;
		try {
			blnResultado = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]");
		} catch (Exception e) {}
		return blnResultado;
	}
	
	public boolean verificarPopUpSolAutorizarAviso(){  
		boolean blnResultado=false;
		try {
			blnResultado = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]");			
		} catch (Exception e) {}
		return blnResultado;
	}
	
	public String verificarMensajePopUpSolAutorizar(){  
		String strResultadoMensaje="";
		try {
			String strMensaje="Desde ahora, autoriza tus Transferencias al Exterior desde Autorizaciones Pendientes y revisa el estado de la operación en la Consulta Histórica.";
			String strMensajePopUp=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]");
			if(!strMensajePopUp.equals(strMensaje)){
				strResultadoMensaje="Mensajes diferentes, mensaje de debería de mostrar: '"+strMensaje+"'; mensaje mostrado: '"+strMensajePopUp+"'.";
			}
		} catch (Exception e) {}
		return strResultadoMensaje;
	}
	
	public boolean verificarAutorizacionesPendientes(){  
		boolean blnResultado=false;
		try {
			blnResultado = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/span");
		} catch (Exception e) {}
		return blnResultado;
	}
	
	public boolean verificarCamObligatoriosConHistorica(){  
		boolean blnResultado=false;
		try {
			blnResultado = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		} catch (Exception e) {}
		return blnResultado;
	}
	
	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
		boolean var=false;
		for(int i=1;i<=3;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a")).getText();
			if(LstrProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a");
				break;
			}
		}
		return var;			
	}
	
	public boolean irAutorizar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/button[1]");
	}
	
	public boolean irConsultar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/button[2]");
	}
	
	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbEmpresa,strEmpresa);
	}

	public String obtenerNombreOrdenante() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath,urlTxtNombreOrdenante);
	}

	public boolean ingresarDireccionOrdenante(String strDireccionOrdenante) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtDireccionOrdenante , strDireccionOrdenante);
	}
	
	public boolean ingresarTelefonoOrdenante(String strTelefonoOrdenante) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtTelefonoOrdenante , strTelefonoOrdenante);
	}
	
	public boolean ingresarEmailOrdenante(String strEmailOrdenante) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtEmailOrdenante , strEmailOrdenante);
	}
	
	public boolean seleccionarMoneda(String strMoneda) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbMoneda,strMoneda);
	}
	
	public boolean buscarMoneda() throws InterruptedException, IOException{
		boolean blnresultado= true;
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlCmbMoneda);
		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(urlCmbMoneda));
		List<WebElement> num=tabla.findElements(By.xpath(".//option"));
		String strtexto;
		for (int j = 2;j<=num.size();j++)
		{
			strtexto=objObjetosGenerales.getText(ObjetosGenerales.xpath,urlCmbMoneda+"/option["+j+"]");
			if(strtexto.equals("Reales")){
				blnresultado=false;
				break;
			}
		}
		return blnresultado;
	}
	
	public boolean ingresarMonto(String strMonto) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtMonto , strMonto);
	}
	
	public boolean seleccionarCuentaCargo(String strCuentaCargo) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbCuentaCargo,strCuentaCargo);
	}
	
	public boolean ingresarNumeroTicketInvalidoIncompleto(String strMensajeMostrar,int intNumeroRegistro) throws InterruptedException, IOException{
		String strMensajeError="";
		if(intNumeroRegistro==2){
			strMensajeError=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[1]/tbody/tr/td[1]/div/span[2]");
		}else {															

			strMensajeError=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[1]/div/div/div/div[2]/span");
		}
		
		boolean blnResultado=false;
		if(strMensajeError.equals(strMensajeMostrar)){
			blnResultado=true;
		}
		return blnResultado;
	}
	
	public boolean ingresarNumeroTicket(String strNumeroTicket) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtNumeroTicket , strNumeroTicket);
	}
	
	public boolean ingresarFechaCargo(String strFechaCargo) throws InterruptedException, IOException{
		FuncionesGenerales.removeReadOnly(urlTxtFechaCargo);
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtFechaCargo , strFechaCargo);
	}
	
	public boolean ingresarNombreBeneficiario(String strNombreBeneficiario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtNombreBeneficiario , strNombreBeneficiario);
	}
	
	public boolean ingresarDireccionBeneficiario(String strDireccionBeneficiario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtDireccionBeneficiario , strDireccionBeneficiario);
	}
	
	public boolean seleccionarPaisBeneficiario(String strPaisBeneficiario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbPaisBeneficiario,strPaisBeneficiario);
	}
	
	public boolean ingresarCiudadBeneficiario(String strCiudadBeneficiario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtCiudadBeneficiario , strCiudadBeneficiario);
	}
	public boolean ingresarTelefonoBeneficiario(String strTelefonoBeneficiario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtTelefonoBeneficiario , strTelefonoBeneficiario);
	}
	public boolean ingresarCuentaAbono(String strCuentaAbono) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtCuentaAbono , strCuentaAbono);
	}
	public boolean ingresarNombreBanco(String strNombreBanco) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtNombreBanco , strNombreBanco);
	}
	public boolean seleccionarPaisBanco(String strPaisBanco) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbPaisBanco,strPaisBanco);
	}
	public boolean ingresarCiudadBanco(String strCiudadBanco) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtCiudadBanco , strCiudadBanco);
	}
	public boolean seleccionarTipoCodigoBanco(String strTipoCodigoBanco) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbTipoCodigoBanco,strTipoCodigoBanco);
	}
	public boolean ingresarCodigoBanco(String strCodigoBanco) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtCodigoBanco , strCodigoBanco);
	}
	public boolean seleccionarBancoIntermediario() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlChkBancoIntermediario);
	}
	public boolean ingresarNombreBancoIntermediario(String strNombreBancoIntermediario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtNombreBancoIntermediario , strNombreBancoIntermediario);
	}
	public boolean seleccionarPaisBancoIntermediario(String strPaisBancoIntermediario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbPaisBancoIntermediario,strPaisBancoIntermediario);
	}
	public boolean ingresarCiudadBancoIntermediario(String strCiudadBancoIntermediario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtCiudadBancoIntermediario , strCiudadBancoIntermediario);
	}
	public boolean seleccionarTipoCodigoBancoIntermediario(String strTipoCodigoBancoIntermediario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbTipoCodigoBancoIntermediario,strTipoCodigoBancoIntermediario);
	}
	public boolean ingresarCodigoBancoIntermediario(String strCodigoBancoIntermediario) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtCodigoBancoIntermediario , strCodigoBancoIntermediario);
	}
	public boolean seleccionarMotivoTransferencia(String strMotivoTransferencia) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbMotivoTransferencia,strMotivoTransferencia);
	}
	public boolean seleccionarGastosCorresponsal(String strGastosCorresponsal) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbGastosCorresponsal,strGastosCorresponsal);
	}
	public boolean ingresarDetallePago(String strDetallePago) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtDetallePago , strDetallePago);
	}
	public boolean enviar() throws InterruptedException, IOException	{ 
	    return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnEnviar);
    }
	
	public String  resultadoMoneda(String strMonedaCuenta,String strMonedaConversion) throws InterruptedException, IOException	{ 
		String strResultadoMoneda="";
		if(strMonedaCuenta.equals("Dólares")){
			 switch (strMonedaConversion)   
				{
					case "Euros": 
						strResultadoMoneda="USD/EUR";
			    		break;
					case "Francos Suizos": 
						strResultadoMoneda="USD/CHF";
			    		break;
					case "Libras Esterlinas": 
						strResultadoMoneda="USD/GBP";
						break;
					case "Reales": 
						strResultadoMoneda="USD/BRL";
						break;
					case "Yenes": 
						strResultadoMoneda="USD/JPY";
						break;
					case "Dólares Canadienses": 
						strResultadoMoneda="USD/CAD";
						break;	
						
				}
		}else{
			switch (strMonedaConversion)   
			{
				case "Euros": 
					strResultadoMoneda="SOL/EUR";
		    		break;
				case "Francos Suizos": 
					strResultadoMoneda="SOL/CHF";
		    		break;
				case "Libras Esterlinas": 
					strResultadoMoneda="SOL/GBP";
					break;
				case "Reales": 
					strResultadoMoneda="SOL/BRL";
					break;
				case "Yenes": 
					strResultadoMoneda="SOL/JPY";
					break;
				case "Dólares Canadienses": 
					strResultadoMoneda="SOL/CAD";
					break;	
				case "Dólares Americanos": 
					strResultadoMoneda="SOL/USD";
					break;	
			}
			
		}
	  return strResultadoMoneda;
    }
	
	public String validarArbitraje(String strValorConversion,String strNombreCampo,String strValorMensaje,String strMonedasCombinacion,String strArbitraje,String strMensajeTexto,String strTCK) throws InterruptedException, IOException	{ 
		String resultado="";
		
		String strNombreEmpresaA=strValorConversion.substring(strValorConversion.length()-7,strValorConversion.length());
  		if(!objFuncionesGenerales.compararTexto(strNombreCampo,strArbitraje)){
  			resultado="El nom. campo diferente, valor esperado:"+strArbitraje+". ";
  		}
  		
  		if(!objFuncionesGenerales.compararTexto(strMonedasCombinacion,strNombreEmpresaA)){
  			resultado=resultado +"Valor esperado:"+strMonedasCombinacion+".";
	  	}
  		
  		if(strTCK.equals("SI")){
  			if(!objFuncionesGenerales.compararTexto(strValorMensaje,"")){
  	  			resultado=resultado + "No se debería de mostrar el mensaje: '"+strValorMensaje+"'. ";
  			}
  		}else{
  			if(!objFuncionesGenerales.compararTexto(strValorMensaje,strMensajeTexto)){
  	  			resultado=resultado + "Mensaje esperado: '"+strMensajeTexto+"'. ";
  			}
  			
  		}
  		return resultado;
    }
	
	
	
	public static Map<String,String> obtenerCamposTipoCambioArbitraje(String strArbitraje,String strPantalla,String strTCK) {
		Map<String,String> map= new HashMap<String,String>();
		String strNombreCampo="";
		String strValorMensaje="";
		String strValorConversion="";
		boolean blnResultado=false;

	
			
			if(strArbitraje.equals("Arbitraje:")){
				if (strPantalla.equals("Confirmacion")){
					strNombreCampo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[21]");
					strValorConversion=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[22]");
					TransferenciasExteriorBE.strARBITRAJE=strValorConversion;
				}else{
					strNombreCampo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[11]/span[1]");
					strValorConversion=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[11]/span[2]");
				}
				 
				 
			}else{
				if (strPantalla.equals("Confirmacion")){
					strNombreCampo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[19]");
					strValorConversion=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[20]");
					TransferenciasExteriorBE.strTIPO_CAMBIO=strValorConversion;
				}else{
					strNombreCampo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[10]/span");
					strValorConversion=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[10]/table/tbody/tr/td/span");
				}
				 
			}
			
			if (strPantalla.equals("Confirmacion")){
					if(strTCK.equals("SI")){
						blnResultado=objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[24]");
					}else{
						strValorMensaje=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[24]");
					}
			}else if (strPantalla.equals("ResultadoFinal")){
				if(strTCK.equals("SI")){
					blnResultado=objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[4]/div/div[12]/table/tbody/tr/td/spann");
				}else{
					strValorMensaje=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[12]/table/tbody/tr/td/span");
				}
			}
			
			if(blnResultado){
				strValorMensaje="No se debería mostrar el mensaje.";
			}
			
			map.put("strNombreCampo",strNombreCampo);
			map.put("strValorMensaje",strValorMensaje);
			map.put("strValorConversion",strValorConversion);
		return map;	
	}
	
	public String  validarTCK(String strTCK, String strMoneda, String strCuentaCargo,String strPantalla) throws InterruptedException, IOException	{ 
		String resultado="";
		//Map<String,String> map;
		Map<String,String> mapValoresValidar;
		String strArbitraje="Arbitraje:";
		String strTipoCambio="Tipo de Cambio:";
		String strMensajeTexto="Tipo de cambio y/o arbitraje referenciales, sujetos a variación hasta que se efectúe el cargo.";
		try {
			mapValores= objFuncionesGenerales.obtenerDatosEmpresaVariante(strCuentaCargo);
			String strMonedaCuenta=mapValores.get("strTipoMoneda");
			String strMonedasCombinacion="";
			
			
			
			if(strMonedaCuenta.equals("Dólares")){
				strMonedasCombinacion=  resultadoMoneda(strMonedaCuenta,strMoneda);
				mapValoresValidar=obtenerCamposTipoCambioArbitraje(strArbitraje,strPantalla,strTCK);
				resultado=validarArbitraje(mapValoresValidar.get("strValorConversion"),mapValoresValidar.get("strNombreCampo"),mapValoresValidar.get("strValorMensaje"),strMonedasCombinacion,strArbitraje,strMensajeTexto,strTCK);
		  	
			}else if(strMonedaCuenta.equals("Soles")){
				if (strMoneda.equals("Dólares Americanos")){
					strMonedasCombinacion=  resultadoMoneda(strMonedaCuenta,strMoneda);
					mapValoresValidar=obtenerCamposTipoCambioArbitraje(strTipoCambio,strPantalla,strTCK);
					resultado=validarArbitraje(mapValoresValidar.get("strValorConversion"),mapValoresValidar.get("strNombreCampo"),mapValoresValidar.get("strValorMensaje"),strMonedasCombinacion,strTipoCambio,strMensajeTexto,strTCK);
			  	}else{
			  	//Tipo de cambio
			  		strMonedasCombinacion=  resultadoMoneda(strMonedaCuenta,"Dólares Americanos");
			  		mapValoresValidar=obtenerCamposTipoCambioArbitraje(strTipoCambio,strPantalla,strTCK);
			  		resultado=resultado+ validarArbitraje(mapValoresValidar.get("strValorConversion"),mapValoresValidar.get("strNombreCampo"),mapValoresValidar.get("strValorMensaje"),strMonedasCombinacion,strTipoCambio,strMensajeTexto,strTCK);
			
			  		
			  		//Arbitraje
			  		strMonedasCombinacion=  resultadoMoneda("Dólares",strMoneda);		
			  		mapValoresValidar=obtenerCamposTipoCambioArbitraje(strArbitraje,strPantalla,strTCK);
			  		resultado=validarArbitraje(mapValoresValidar.get("strValorConversion"),mapValoresValidar.get("strNombreCampo"),mapValoresValidar.get("strValorMensaje"),strMonedasCombinacion,strArbitraje,strMensajeTexto,strTCK);
			  		
			  			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return resultado;
    }
	
	
	public String obtenerMensajeError(String seccion) throws InterruptedException, IOException{
		String urlMensajeOrdenante = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[1]/div/span[2]";
		String urlMensajeBeneficiario = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[2]/tbody/tr/td[1]/div/span[2]";
		String urlMensajeBancoBeneficiario = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[3]/tbody/tr/td[1]/div/span[2]";
		String urlMensajeInstruccionesAdicionales = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[4]/tbody/tr/td[1]/div/span[2]";
		String strMensaje = "";
		switch (seccion)
		{
			case "CMB_EMPRESA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_NOMBRE_ORDENANTE":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_DIRECCION_ORDENANTE":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_TELEFONO_ORDENANTE":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_EMAIL_ORDENANTE":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "CMB_MONEDA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_MONTO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "CMB_CUENTA_CARGO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_NUMERO_TICKET":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_FECHA_CARGO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeOrdenante);
				break;
			case "TXT_NOMBRE_BENEFICIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBeneficiario);
				break;
			case "TXT_DIRECCION_BENEFICIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBeneficiario);
				break;
			case "CMB_PAIS_BENEFICIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBeneficiario);
				break;
			case "TXT_CIUDAD_BENEFICIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBeneficiario);
				break;
			case "TXT_TELEFONO_BENEFICIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBeneficiario);
				break;
			case "TXT_CUENTA_ABONO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBeneficiario);
				break;
			case "TXT_NOMBRE_BANCO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "CMB_PAIS_BANCO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "TXT_CIUDAD_BANCO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "CMB_TIPO_CODIGO_BANCO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "TXT_CODIGO_BANCO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "CHK_BANCO_INTERMEDIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "TXT_NOMBRE_BANCO_INTERMEDIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "CMB_PAIS_BANCO_INTERMEDIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "TXT_CIUDAD_BANCO_INTERMEDIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "TXT_CODIGO_BANCO_INTERMEDIARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeBancoBeneficiario);
				break;
			case "CMB_MOTIVO_TRANSFERENCIA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeInstruccionesAdicionales);
				break;
			case "CMB_GASTOS_CORRESPONSAL":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeInstruccionesAdicionales);
				break;
			case "TXT_DETALLE_PAGO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, urlMensajeInstruccionesAdicionales);
				break;
			case "CHK_ACEPTO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[7]/span");
				break;
			case "TXT_CLAVE":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[8]/div/span");
				break;
			case "TXT_CLAVE_DINAMICA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[9]/div[2]/span");
				break;
				
		}
		return strMensaje;
	}

	public String verificarPantallaConfirmacion() throws InterruptedException, IOException{
		String valor;
		
		String TXT_NOMBRE_ORDENANTE=Mdl_Variables.map.get("TXT_NOMBRE_ORDENANTE");
		String TXT_DIRECCION_ORDENANTE=Mdl_Variables.map.get("TXT_DIRECCION_ORDENANTE");
		String TXT_TELEFONO_ORDENANTE=Mdl_Variables.map.get("TXT_TELEFONO_ORDENANTE");
		String TXT_EMAIL_ORDENANTE=Mdl_Variables.map.get("TXT_EMAIL_ORDENANTE");
		String CMB_MONEDA=Mdl_Variables.map.get("CMB_MONEDA");
		String TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO");
		String CMB_CUENTA_CARGO=Mdl_Variables.map.get("CMB_CUENTA_CARGO");
		String TXT_FECHA_CARGO=Mdl_Variables.map.get("TXT_FECHA_CARGO");
		String LBL_TIPO_CAMBIO=Mdl_Variables.map.get("LBL_TIPO_CAMBIO");
		String TXT_NUMERO_TICKET=Mdl_Variables.map.get("TXT_NUMERO_TICKET");	
//		String CMB_TIPO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("CMB_TIPO_DOCUMENTO_BENEFICIARIO");	
//		String TXT_NUMERO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("TXT_NUMERO_DOCUMENTO_BENEFICIARIO");	
		String TXT_NOMBRE_BENEFICIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BENEFICIARIO");
		String TXT_DIRECCION_BENEFICIARIO=Mdl_Variables.map.get("TXT_DIRECCION_BENEFICIARIO");
		String CMB_PAIS_BENEFICIARIO=Mdl_Variables.map.get("CMB_PAIS_BENEFICIARIO");
		String TXT_CIUDAD_BENEFICIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BENEFICIARIO");
		String TXT_TELEFONO_BENEFICIARIO=Mdl_Variables.map.get("TXT_TELEFONO_BENEFICIARIO");
		String TXT_CUENTA_ABONO=Mdl_Variables.map.get("TXT_CUENTA_ABONO");
		String TXT_NOMBRE_BANCO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO");
		String CMB_PAIS_BANCO=Mdl_Variables.map.get("CMB_PAIS_BANCO");
		String TXT_CIUDAD_BANCO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO");
		String CMB_TIPO_CODIGO_BANCO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO");
		String TXT_CODIGO_BANCO=Mdl_Variables.map.get("TXT_CODIGO_BANCO");
		String TXT_NOMBRE_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO_INTERMEDIARIO");
		String CMB_PAIS_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_PAIS_BANCO_INTERMEDIARIO");
		String TXT_CIUDAD_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO_INTERMEDIARIO");
		String CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO");
		String TXT_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CODIGO_BANCO_INTERMEDIARIO");
		String CMB_MOTIVO_TRANSFERENCIA=Mdl_Variables.map.get("CMB_MOTIVO_TRANSFERENCIA");
		String CMB_GASTOS_CORRESPONSAL=Mdl_Variables.map.get("CMB_GASTOS_CORRESPONSAL");
		String TXT_DETALLE_PAGO=Mdl_Variables.map.get("TXT_DETALLE_PAGO");
		boolean indAhorro=false;
		
		String valoresDiferentes="";

		if(TXT_NOMBRE_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[4]");
			if(!TXT_NOMBRE_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[6]");
			if(!TXT_DIRECCION_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_ORDENANTE esperado: "+TXT_DIRECCION_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[8]");
			if(!TXT_TELEFONO_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_ORDENANTE esperado: "+TXT_TELEFONO_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_EMAIL_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[10]");
			if(!TXT_EMAIL_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_EMAIL_ORDENANTE esperado: "+TXT_EMAIL_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MONEDA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[12]");
			if(!CMB_MONEDA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MONEDA esperado: "+CMB_MONEDA+" ,obtenido: "+valor+"\n";
		}
		if(TXT_MONTO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[14]");
			if(!TXT_MONTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TXT_MONTO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_CUENTA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[16]");
			if(valor.contains("Ahorro"))
				indAhorro=true;
			if(!CMB_CUENTA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+CMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_FECHA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[18]");
			if(!TXT_FECHA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_FECHA_CARGO esperado: "+TXT_FECHA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(LBL_TIPO_CAMBIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/span[20]");
			if(!LBL_TIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- LBL_TIPO_CAMBIO esperado: "+LBL_TIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_TICKET!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[1]/div/span[26]");
			if(!TXT_NUMERO_TICKET.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_TICKET esperado: "+TXT_NUMERO_TICKET+" ,obtenido: "+valor+"\n";
		}
		/*if(CMB_TIPO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[6]");
			if(!CMB_TIPO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_DOCUMENTO_BENEFICIARIO esperado: "+CMB_TIPO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[8]");
			if(!TXT_NUMERO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_DOCUMENTO_BENEFICIARIO esperado: "+TXT_NUMERO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}*/
		if(TXT_NOMBRE_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[4]");
			if(!TXT_NOMBRE_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TXT_NOMBRE_BENEFICIARIO+" Obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[10]");
			if(!TXT_DIRECCION_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_BENEFICIARIO esperado: "+TXT_DIRECCION_BENEFICIARIO+" Obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[12]");
			if(!TXT_TELEFONO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_BENEFICIARIO esperado: "+TXT_TELEFONO_BENEFICIARIO+" Obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[14]");
			if(!CMB_PAIS_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BENEFICIARIO esperado: "+CMB_PAIS_BENEFICIARIO+" Obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[16]");
			if(!TXT_CIUDAD_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BENEFICIARIO esperado: "+TXT_CIUDAD_BENEFICIARIO+" Obtenido: "+valor+"\n";
		}		
		if(TXT_CUENTA_ABONO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[2]/div/span[18]");
			if(!TXT_CUENTA_ABONO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TXT_CUENTA_ABONO+" Obtenido: "+valor+"\n";
		}
		
		CapturarPantalla.pageDown("200");
		
		if(TXT_NOMBRE_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[3]/div/span[4]");
			if(!TXT_NOMBRE_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TXT_NOMBRE_BANCO+" Obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[3]/div/span[6]");
			if(!CMB_PAIS_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO esperado: "+CMB_PAIS_BANCO+" Obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[3]/div/span[8]");
			if(!TXT_CIUDAD_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO esperado: "+TXT_CIUDAD_BANCO+" Obtenido: "+valor+"\n";
		}
		if(CMB_TIPO_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[3]/div/span[10]");
			if(!CMB_TIPO_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO esperado: "+CMB_TIPO_CODIGO_BANCO+" Obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[3]/div/span[12]");
			if(!TXT_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO esperado: "+TXT_CODIGO_BANCO+" Obtenido: "+valor+"\n";
		}
		if(TXT_NOMBRE_BANCO_INTERMEDIARIO!=null){
			
			CapturarPantalla.pageDown("200");
			
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div/div/span[4]");
																		
			                                                            
			if(!TXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TXT_NOMBRE_BANCO_INTERMEDIARIO+" Obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div/div/span[6]");
			if(!CMB_PAIS_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO_INTERMEDIARIO esperado: "+CMB_PAIS_BANCO_INTERMEDIARIO+" Obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div/div/span[8]");
			if(!TXT_CIUDAD_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO_INTERMEDIARIO esperado: "+TXT_CIUDAD_BANCO_INTERMEDIARIO+" Obtenido: "+valor+"\n";
		}
		if(CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div/div/span[10]");
			if(!CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO esperado: "+CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" Obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[4]/div/div/span[12]");
			if(!TXT_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO_INTERMEDIARIO esperado: "+TXT_CODIGO_BANCO_INTERMEDIARIO+" Obtenido: "+valor+"\n";
		}
		
		CapturarPantalla.pageDown("200");
		
		if(CMB_MOTIVO_TRANSFERENCIA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[5]/div/span[4]");
			if(!CMB_MOTIVO_TRANSFERENCIA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+CMB_MOTIVO_TRANSFERENCIA+" Obtenido: "+valor+"\n";
		}
		if(CMB_GASTOS_CORRESPONSAL!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[5]/div/span[6]");
			if(!CMB_GASTOS_CORRESPONSAL.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+CMB_GASTOS_CORRESPONSAL+" Obtenido: "+valor+"\n";
		}
		if(TXT_DETALLE_PAGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[5]/div/pre/span");
																	    
			if(!TXT_DETALLE_PAGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TXT_DETALLE_PAGO+" Obtenido: "+valor+"\n";
		}
		
		String mensajeHorarioProceso=getMensajeEnvioHorarioProceso();
		String mensajeHorarioProcesoBD="- "+Mdl_Variables.Gstr_Parametros[6];
		if (!mensajeHorarioProceso.equals(mensajeHorarioProcesoBD)){
			valoresDiferentes=valoresDiferentes+"- MensajeHorarioProcesoBD esperado: "+mensajeHorarioProcesoBD+" Obtenido: "+mensajeHorarioProceso+"\n";
		}
		if(!indAhorro){
			String mensajeSaldoCtaCorrienteBD="- "+Mdl_Variables.Gstr_Parametros[7];
			String mensajeSaldoCtaCorriente=getMensajeEnvioSaldoCtaCorriente();
			
			if (!mensajeSaldoCtaCorriente.equals(mensajeSaldoCtaCorrienteBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeSaldoCtaCorriente esperado: "+mensajeSaldoCtaCorrienteBD+" Obtenido: "+mensajeSaldoCtaCorriente+"\n";
			}
		}else{
			String mensajeSaldoCtaAhorrosBD="- "+Mdl_Variables.Gstr_Parametros[8];
			String mensajeSaldoCtaAhorros=getMensajeEnvioSaldoCtaAhorros();
			if (!mensajeSaldoCtaAhorros.equals(mensajeSaldoCtaAhorrosBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeSaldoCtaAhorros esperado: "+mensajeSaldoCtaAhorrosBD+" Obtenido: "+mensajeSaldoCtaAhorros+"\n";
			}
		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}
	
	public boolean verTerminosCondiciones() throws InterruptedException, IOException	{ 
	    return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlLnkTerminosCondiciones);
    }

	public boolean cerrarTerminosCondiciones() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnCerrarTerminosCondiciones);
	}

	public boolean aceptarTerminosCondiciones() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlChkAceptoTerminosCondiciones);
	}
	
	public boolean ingresarClave(String Lstr_Clave) throws InterruptedException, IOException
	{	
		   String  strValorBoton = "";
		   String  strClave = Lstr_Clave;
		   String  strLetraValor = "";

		   for (int i = 1;i<=strClave.length();i++)
	       {
			   strLetraValor = strClave.split("")[i - 1];
	        
			   for (int j = 1; j <= 10; j++)
			   {
				   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).getText();
	        
				   if (strValorBoton.equals(strLetraValor))
				   {
					   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).click();
					   break;
				   }
			   }
	       }
		   return true;
	
	}
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[9]/div[2]/input", Descripcion);
	}
	
	public boolean confirmar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnConfirmar);
	}

	public String obtenerResultadoEsperado2() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div/div[1]/span");
	}

	public String verificarPantallaResultado(boolean indFinal) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String valor;
		
		String TXT_NOMBRE_ORDENANTE=Mdl_Variables.map.get("TXT_NOMBRE_ORDENANTE");
		String TXT_DIRECCION_ORDENANTE=Mdl_Variables.map.get("TXT_DIRECCION_ORDENANTE");
		String TXT_TELEFONO_ORDENANTE=Mdl_Variables.map.get("TXT_TELEFONO_ORDENANTE");
		String TXT_EMAIL_ORDENANTE=Mdl_Variables.map.get("TXT_EMAIL_ORDENANTE");
		String CMB_MONEDA=Mdl_Variables.map.get("CMB_MONEDA");
		String TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO");
		String CMB_CUENTA_CARGO=Mdl_Variables.map.get("CMB_CUENTA_CARGO");
		String TXT_NUMERO_TICKET=Mdl_Variables.map.get("TXT_NUMERO_TICKET");
		String LBL_TIPO_CAMBIO=Mdl_Variables.map.get("LBL_TIPO_CAMBIO");
		String TXT_FECHA_CARGO=Mdl_Variables.map.get("TXT_FECHA_CARGO");
//		String CMB_TIPO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("CMB_TIPO_DOCUMENTO_BENEFICIARIO");	
//		String TXT_NUMERO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("TXT_NUMERO_DOCUMENTO_BENEFICIARIO");	
		String TXT_NOMBRE_BENEFICIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BENEFICIARIO");
		String TXT_DIRECCION_BENEFICIARIO=Mdl_Variables.map.get("TXT_DIRECCION_BENEFICIARIO");
		String CMB_PAIS_BENEFICIARIO=Mdl_Variables.map.get("CMB_PAIS_BENEFICIARIO");
		String TXT_CIUDAD_BENEFICIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BENEFICIARIO");
		String TXT_TELEFONO_BENEFICIARIO=Mdl_Variables.map.get("TXT_TELEFONO_BENEFICIARIO");
		String TXT_CUENTA_ABONO=Mdl_Variables.map.get("TXT_CUENTA_ABONO");
		String TXT_NOMBRE_BANCO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO");
		String CMB_PAIS_BANCO=Mdl_Variables.map.get("CMB_PAIS_BANCO");
		String TXT_CIUDAD_BANCO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO");
		String CMB_TIPO_CODIGO_BANCO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO");
		String TXT_CODIGO_BANCO=Mdl_Variables.map.get("TXT_CODIGO_BANCO");
		String TXT_NOMBRE_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO_INTERMEDIARIO");
		String CMB_PAIS_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_PAIS_BANCO_INTERMEDIARIO");
		String TXT_CIUDAD_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO_INTERMEDIARIO");
		String CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO");
		String TXT_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CODIGO_BANCO_INTERMEDIARIO");
		String CMB_MOTIVO_TRANSFERENCIA=Mdl_Variables.map.get("CMB_MOTIVO_TRANSFERENCIA");
		String CMB_GASTOS_CORRESPONSAL=Mdl_Variables.map.get("CMB_GASTOS_CORRESPONSAL");
		String TXT_DETALLE_PAGO=Mdl_Variables.map.get("TXT_DETALLE_PAGO");
		boolean indAhorro=false;
		
		String valoresDiferentes="";

		if(TXT_NOMBRE_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[3]/span[2]");
			if(!TXT_DIRECCION_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_ORDENANTE esperado: "+TXT_DIRECCION_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[4]/span[2]");
			if(!TXT_TELEFONO_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_ORDENANTE esperado: "+TXT_TELEFONO_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_EMAIL_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[5]/span[2]");
			if(!TXT_EMAIL_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_EMAIL_ORDENANTE esperado: "+TXT_EMAIL_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MONEDA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[6]/span[2]");
			if(!CMB_MONEDA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MONEDA esperado: "+CMB_MONEDA+" ,obtenido: "+valor+"\n";
		}
		if(TXT_MONTO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[7]/span[2]");
			if(!TXT_MONTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TXT_MONTO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_CUENTA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[8]/span[2]");
			if(valor.contains("Ahorro"))
				indAhorro=true;
			if(!CMB_CUENTA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+CMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_FECHA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[9]/span[2]");
			if(!TXT_FECHA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_FECHA_CARGO esperado: "+TXT_FECHA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(LBL_TIPO_CAMBIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[10]/table/tbody/tr/td/span");
			if(!LBL_TIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- LBL_TIPO_CAMBIO esperado: "+LBL_TIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_TICKET!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/div/div[13]/span[2]");
			if(!TXT_NUMERO_TICKET.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_TICKET esperado: "+TXT_NUMERO_TICKET+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NOMBRE_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TXT_NOMBRE_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		/*if(CMB_TIPO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[3]/span[2]");
			if(!CMB_TIPO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_DOCUMENTO_BENEFICIARIO esperado: "+CMB_TIPO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[4]/span[2]");
			if(!TXT_NUMERO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_DOCUMENTO_BENEFICIARIO esperado: "+TXT_NUMERO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}*/
		if(TXT_DIRECCION_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[4]/span[2]");
			
			if(!TXT_DIRECCION_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_BENEFICIARIO esperado: "+TXT_DIRECCION_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[5]/span[2]");
			if(!TXT_TELEFONO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_BENEFICIARIO esperado: "+TXT_TELEFONO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[6]/span[2]");
			if(!CMB_PAIS_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BENEFICIARIO esperado: "+CMB_PAIS_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[7]/span[2]");
			if(!TXT_CIUDAD_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BENEFICIARIO esperado: "+TXT_CIUDAD_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(TXT_CUENTA_ABONO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[8]/span[2]");			                                                            
			if(!TXT_CUENTA_ABONO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TXT_CUENTA_ABONO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[5]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TXT_NOMBRE_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[5]/div/div[4]/span[2]");
			if(!TXT_CIUDAD_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO esperado: "+TXT_CIUDAD_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[5]/div/div[3]/span[2]");
			if(!CMB_PAIS_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO esperado: "+CMB_PAIS_BANCO+" ,obtenido: "+valor+"\n";
		}		
		if(CMB_TIPO_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[5]/div/div[5]/span[2]");
			if(!CMB_TIPO_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO esperado: "+CMB_TIPO_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[5]/div/div[6]/span[2]");
			if(!TXT_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO esperado: "+TXT_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[6]/div/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TXT_NOMBRE_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[6]/div/div/div[4]/span[2]");
			if(!TXT_CIUDAD_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO_INTERMEDIARIO esperado: "+TXT_CIUDAD_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[6]/div/div/div[3]/span[2]");
			if(!CMB_PAIS_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO_INTERMEDIARIO esperado: "+CMB_PAIS_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[6]/div/div/div[5]/span[2]");
			if(!CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO esperado: "+CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[6]/div/div/div[6]/span[2]");
			if(!TXT_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO_INTERMEDIARIO esperado: "+TXT_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MOTIVO_TRANSFERENCIA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[7]/div/div[2]/span[2]");
			if(!CMB_MOTIVO_TRANSFERENCIA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+CMB_MOTIVO_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
		}
		if(CMB_GASTOS_CORRESPONSAL!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[7]/div/div[3]/span[2]");
			if(!CMB_GASTOS_CORRESPONSAL.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+CMB_GASTOS_CORRESPONSAL+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DETALLE_PAGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[7]/div/div[4]/pre/span");
			if(!TXT_DETALLE_PAGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TXT_DETALLE_PAGO+" ,obtenido: "+valor+"\n";
		}
		
		String mensajeHorarioProceso=getMensajeConfirHorarioProceso();
		String mensajeHorarioProcesoBD="- "+Mdl_Variables.Gstr_Parametros[6];
		if (!mensajeHorarioProceso.equals(mensajeHorarioProcesoBD)){
			valoresDiferentes=valoresDiferentes+"- MensajeHorarioProcesoBD esperado: "+mensajeHorarioProcesoBD+" ,obtenido: "+mensajeHorarioProceso+"\n";
		}
		if(!indAhorro){
			String mensajeSaldoCtaCorriente=getMensajeConfirSaldoCtaCorriente();
			String mensajeSaldoCtaCorrienteBD="- "+Mdl_Variables.Gstr_Parametros[7];
			if (!mensajeSaldoCtaCorriente.equals(mensajeSaldoCtaCorrienteBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeSaldoCtaCorriente esperado: "+mensajeSaldoCtaCorrienteBD+" ,obtenido: "+mensajeSaldoCtaCorriente+"\n";
			}
		}else{
			String mensajeSaldoCtaAhorros=getMensajeConfirSaldoCtaAhorros();
			String mensajeSaldoCtaAhorrosBD="- "+Mdl_Variables.Gstr_Parametros[8];
			if (!mensajeSaldoCtaAhorros.equals(mensajeSaldoCtaAhorrosBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeSaldoCtaAhorros esperado: "+mensajeSaldoCtaAhorrosBD+" ,obtenido: "+mensajeSaldoCtaAhorros+"\n";
			}
		}
		
		if(indFinal){
			String mensajeConfirRevisarHistorica=getMensajeConfirRevisarHistorica();
			String mensajeConfirRevisarHistoricaBD="- "+Mdl_Variables.Gstr_Parametros[2];
			if (!mensajeConfirRevisarHistorica.equals(mensajeConfirRevisarHistoricaBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeConfirRevisarHistoricaBD esperado: "+mensajeConfirRevisarHistoricaBD+" ,obtenido: "+mensajeConfirRevisarHistorica+"\n";
			}
		}else{		
			
			String mensajeConfir72horas=getMensajeConfir72horas();
			String mensajeConfir72horasBD="- ";
			if(TXT_NUMERO_TICKET!=null){
				mensajeConfir72horasBD=mensajeConfir72horasBD+Mdl_Variables.Gstr_Parametros[18];
			}
			else{
				mensajeConfir72horasBD=mensajeConfir72horasBD+Mdl_Variables.Gstr_Parametros[1];
			}
			if (!mensajeConfir72horas.equals(mensajeConfir72horasBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeConfir72horasBD esperado: "+mensajeConfir72horasBD+" ,obtenido: "+mensajeConfir72horas+"\n";
			}
			String mensajeConfirMensajeSwift=getMensajeConfirMensajeSwift();
			String mensajeConfirMensajeSwiftBD="- "+Mdl_Variables.Gstr_Parametros[5];
			if (!mensajeConfirMensajeSwift.equals(mensajeConfirMensajeSwiftBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeConfirMensajeSwiftBD esperado: "+mensajeConfirMensajeSwiftBD+" ,obtenido: "+mensajeConfirMensajeSwift+"\n";
			}
		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}
	
	public boolean ingresarEnvioCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[9]/div/div[1]/div/div[1]/a");		
	}
	public boolean ingresarTituloCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
	public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}	
	public boolean enviarCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");		
	} 
	public boolean exportarExcel() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[9]/div/div[1]/div/div[4]/a");	
	}
	public boolean exportarPdf() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[9]/div/div[1]/div/div[5]/a");			
	}
	public boolean imprimir() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[9]/div/div[1]/div/div[6]/a");		  		
	}

	public boolean activarTicket() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		//return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[6]/td/table/tbody/tr/td[1]/span/input");	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td[1]/span/input");	
	}
	
	public String obtenerMensajeErrorTicket() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table[1]/tbody/tr/td[1]/div/span[2]");
	}

	public boolean verQuieresSaberComo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[9]/div[1]/a");
	}

	public boolean cerrarPopupQuieresSaberComo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[3]/a");//botón aceptar
	}

	public boolean cancelarOperacion()  throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[10]/a[2]");
	}

	public boolean realizarOtraTransferencia() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[9]/div/div[2]/a");
	}	

	public boolean cerrarPopupPais() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
	}


	public String obtenerMensajePopup() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div");
	}


	public void aceptarEnvio() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");
	}


	public String obtenerOperacion() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div/div[3]/span[2]");
	}


	public String obtenerFecha() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div/div[3]/span[4]");
	}


	public String obtenerHora() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div/div[3]/span[6]");
	}
	
	public String obtenerNroReferencia() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div/div[5]/span[2]");
	}


	public boolean guardar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,urlBtnGuardar);
	}
	
	public String obtenerMensaje() throws InterruptedException, IOException{
    	return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/span");
	}
	
	public String verificarCamposLlenados(int indGuardar) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String valor;
		
		String TXT_NOMBRE_ORDENANTE=Mdl_Variables.map.get("TXT_NOMBRE_ORDENANTE");
		String TXT_DIRECCION_ORDENANTE=Mdl_Variables.map.get("TXT_DIRECCION_ORDENANTE");
		String TXT_TELEFONO_ORDENANTE=Mdl_Variables.map.get("TXT_TELEFONO_ORDENANTE");
		String TXT_EMAIL_ORDENANTE=Mdl_Variables.map.get("TXT_EMAIL_ORDENANTE");
		String CMB_MONEDA=Mdl_Variables.map.get("CMB_MONEDA");
		String TXT_MONTO;
		String CMB_CUENTA_CARGO=Mdl_Variables.map.get("CMB_CUENTA_CARGO");
		//String TXT_FECHA_CARGO=Mdl_Variables.map.get("TXT_FECHA_CARGO");
		//String CMB_TIPO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("CMB_TIPO_DOCUMENTO_BENEFICIARIO");
		//String TXT_NUMERO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("TXT_NUMERO_DOCUMENTO_BENEFICIARIO");
		String TXT_NOMBRE_BENEFICIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BENEFICIARIO");
		String TXT_DIRECCION_BENEFICIARIO=Mdl_Variables.map.get("TXT_DIRECCION_BENEFICIARIO");
		String CMB_PAIS_BENEFICIARIO=Mdl_Variables.map.get("CMB_PAIS_BENEFICIARIO");
		String TXT_CIUDAD_BENEFICIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BENEFICIARIO");
		String TXT_TELEFONO_BENEFICIARIO=Mdl_Variables.map.get("TXT_TELEFONO_BENEFICIARIO");
		String TXT_CUENTA_ABONO=Mdl_Variables.map.get("TXT_CUENTA_ABONO");
		String TXT_NOMBRE_BANCO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO");
		String CMB_PAIS_BANCO=Mdl_Variables.map.get("CMB_PAIS_BANCO");
		String TXT_CIUDAD_BANCO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO");
		String CMB_TIPO_CODIGO_BANCO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO");
		String TXT_CODIGO_BANCO=Mdl_Variables.map.get("TXT_CODIGO_BANCO");
		String TXT_NOMBRE_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO_INTERMEDIARIO");
		String CMB_PAIS_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_PAIS_BANCO_INTERMEDIARIO");
		String TXT_CIUDAD_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO_INTERMEDIARIO");
		String CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO");
		String TXT_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CODIGO_BANCO_INTERMEDIARIO");
		String CMB_MOTIVO_TRANSFERENCIA=Mdl_Variables.map.get("CMB_MOTIVO_TRANSFERENCIA");
		String CMB_GASTOS_CORRESPONSAL=Mdl_Variables.map.get("CMB_GASTOS_CORRESPONSAL");
		String TXT_DETALLE_PAGO=Mdl_Variables.map.get("TXT_DETALLE_PAGO");
		
		
		String valoresDiferentes="";
		
		if(indGuardar==1)
			TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO_INICIAL");
		else if(indGuardar==0)
			TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO");
		else
			TXT_MONTO=ObjetosGenerales.remplaceText(Mdl_Variables.map.get("TXT_MONTO"));
			if(CMB_MONEDA.equals("Yenes")){
				TXT_MONTO=	TXT_MONTO.substring(0, TXT_MONTO.indexOf( '.' ));     
			}
			
			
		if(TXT_NOMBRE_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbEmpresa);
			if(!TXT_NOMBRE_ORDENANTE.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtDireccionOrdenante);
			if(!TXT_DIRECCION_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_ORDENANTE esperado: "+TXT_DIRECCION_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtTelefonoOrdenante);
			if(!TXT_TELEFONO_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_ORDENANTE esperado: "+TXT_TELEFONO_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_EMAIL_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtEmailOrdenante);
			if(!TXT_EMAIL_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_EMAIL_ORDENANTE esperado: "+TXT_EMAIL_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MONEDA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbMoneda);
			if(!CMB_MONEDA.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_MONEDA esperado: "+CMB_MONEDA+" ,obtenido: "+valor+"\n";
		}
		if(TXT_MONTO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtMonto);
			if(!TXT_MONTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TXT_MONTO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_CUENTA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbCuentaCargo);
			valor=valor.substring(0, valor.length()-11)+"-"+valor.substring(valor.length()-10, valor.length());
			CMB_CUENTA_CARGO=CMB_CUENTA_CARGO.substring(0, CMB_CUENTA_CARGO.length()-11)+"-"+CMB_CUENTA_CARGO.substring(CMB_CUENTA_CARGO.length()-10, CMB_CUENTA_CARGO.length());
			if(!CMB_CUENTA_CARGO.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+CMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
		}
		/*if(TXT_FECHA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtFechaCargo);
			if(!TXT_FECHA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_FECHA_CARGO esperado: "+TXT_FECHA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(indGuardar==1){
			if(CMB_TIPO_DOCUMENTO_BENEFICIARIO!=null){
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbTipoDocumentoBeneficiario);
				if(!CMB_TIPO_DOCUMENTO_BENEFICIARIO.equals(valor))
					valoresDiferentes=valoresDiferentes+"- CMB_TIPO_DOCUMENTO_BENEFICIARIO esperado: "+CMB_TIPO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
			}
			if(TXT_NUMERO_DOCUMENTO_BENEFICIARIO!=null){
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtNumeroDocumentoBeneficiario);
				if(!TXT_NUMERO_DOCUMENTO_BENEFICIARIO.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_DOCUMENTO_BENEFICIARIO esperado: "+TXT_NUMERO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
			}
		}*/
		if(TXT_NOMBRE_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtNombreBeneficiario);
			if(!TXT_NOMBRE_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TXT_NOMBRE_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtDireccionBeneficiario);
			if(!TXT_DIRECCION_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_BENEFICIARIO esperado: "+TXT_DIRECCION_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtTelefonoBeneficiario);
			if(!TXT_TELEFONO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_BENEFICIARIO esperado: "+TXT_TELEFONO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbPaisBeneficiario);
			if(!CMB_PAIS_BENEFICIARIO.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BENEFICIARIO esperado: "+CMB_PAIS_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtCiudadBeneficiario);
			if(!TXT_CIUDAD_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BENEFICIARIO esperado: "+TXT_CIUDAD_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(TXT_CUENTA_ABONO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtCuentaAbono);
			if(!TXT_CUENTA_ABONO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TXT_CUENTA_ABONO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NOMBRE_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtNombreBanco);
			if(!TXT_NOMBRE_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TXT_NOMBRE_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbPaisBanco);
			if(!CMB_PAIS_BANCO.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO esperado: "+CMB_PAIS_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtCiudadBanco);
			if(!TXT_CIUDAD_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO esperado: "+TXT_CIUDAD_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_TIPO_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbTipoCodigoBanco);
			if(!CMB_TIPO_CODIGO_BANCO.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO esperado: "+CMB_TIPO_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtCodigoBanco);
			if(!TXT_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO esperado: "+TXT_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NOMBRE_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtNombreBancoIntermediario);
			if(!TXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TXT_NOMBRE_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbPaisBancoIntermediario);
			if(!CMB_PAIS_BANCO_INTERMEDIARIO.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO_INTERMEDIARIO esperado: "+CMB_PAIS_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3,urlTxtCiudadBancoIntermediario);
			if(!TXT_CIUDAD_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO_INTERMEDIARIO esperado: "+TXT_CIUDAD_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbTipoCodigoBancoIntermediario);
			if(!CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO esperado: "+CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtCodigoBancoIntermediario);
			if(!TXT_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO_INTERMEDIARIO esperado: "+TXT_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MOTIVO_TRANSFERENCIA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4, urlCmbMotivoTransferencia);
			if(!CMB_MOTIVO_TRANSFERENCIA.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+CMB_MOTIVO_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
		}
		if(CMB_GASTOS_CORRESPONSAL!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath4,urlCmbGastosCorresponsal);
			if(!CMB_GASTOS_CORRESPONSAL.equals(valor.trim()))
				valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+CMB_GASTOS_CORRESPONSAL+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DETALLE_PAGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath3, urlTxtDetallePago);
			if(!TXT_DETALLE_PAGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TXT_DETALLE_PAGO+" ,obtenido: "+valor+"\n";
		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}


	public boolean agregarOperacionFrecuente()throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[2]/div/div[2]/a");
	}


	public boolean ingresarDescripcionOF(String strDescripcionOF) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[3]/div/div/div/div[2]/input", strDescripcionOF);
	}


	public String verificarDatosOF() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String valor;
		
		String TXT_NOMBRE_ORDENANTE=Mdl_Variables.map.get("TXT_NOMBRE_ORDENANTE");
		String TXT_DIRECCION_ORDENANTE=Mdl_Variables.map.get("TXT_DIRECCION_ORDENANTE");
		String TXT_TELEFONO_ORDENANTE=Mdl_Variables.map.get("TXT_TELEFONO_ORDENANTE");
		String TXT_EMAIL_ORDENANTE=Mdl_Variables.map.get("TXT_EMAIL_ORDENANTE");
		String CMB_MONEDA=Mdl_Variables.map.get("CMB_MONEDA");
		String TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO");
		String CMB_CUENTA_CARGO=Mdl_Variables.map.get("CMB_CUENTA_CARGO");
		//String TXT_NUMERO_TICKET=Mdl_Variables.map.get("TXT_NUMERO_TICKET");
		//String LBL_TIPO_CAMBIO=Mdl_Variables.map.get("LBL_TIPO_CAMBIO");
		//String TXT_FECHA_CARGO=Mdl_Variables.map.get("TXT_FECHA_CARGO");
		String TXT_NOMBRE_BENEFICIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BENEFICIARIO");
		String TXT_DIRECCION_BENEFICIARIO=Mdl_Variables.map.get("TXT_DIRECCION_BENEFICIARIO");
		String CMB_PAIS_BENEFICIARIO=Mdl_Variables.map.get("CMB_PAIS_BENEFICIARIO");
		String TXT_CIUDAD_BENEFICIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BENEFICIARIO");
		String TXT_TELEFONO_BENEFICIARIO=Mdl_Variables.map.get("TXT_TELEFONO_BENEFICIARIO");
		String TXT_CUENTA_ABONO=Mdl_Variables.map.get("TXT_CUENTA_ABONO");
		String TXT_NOMBRE_BANCO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO");
		String CMB_PAIS_BANCO=Mdl_Variables.map.get("CMB_PAIS_BANCO");
		String TXT_CIUDAD_BANCO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO");
		String CMB_TIPO_CODIGO_BANCO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO");
		String TXT_CODIGO_BANCO=Mdl_Variables.map.get("TXT_CODIGO_BANCO");
		String TXT_NOMBRE_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO_INTERMEDIARIO");
		String CMB_PAIS_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_PAIS_BANCO_INTERMEDIARIO");
		String TXT_CIUDAD_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO_INTERMEDIARIO");
		String CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO");
		String TXT_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CODIGO_BANCO_INTERMEDIARIO");
		String CMB_MOTIVO_TRANSFERENCIA=Mdl_Variables.map.get("CMB_MOTIVO_TRANSFERENCIA");
		String CMB_GASTOS_CORRESPONSAL=Mdl_Variables.map.get("CMB_GASTOS_CORRESPONSAL");
		String TXT_DETALLE_PAGO=Mdl_Variables.map.get("TXT_DETALLE_PAGO");
		
		String valoresDiferentes="";

		if(TXT_NOMBRE_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[3]/span[2]");
			if(!TXT_DIRECCION_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_ORDENANTE esperado: "+TXT_DIRECCION_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[4]/span[2]");
			if(!TXT_TELEFONO_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_ORDENANTE esperado: "+TXT_TELEFONO_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_EMAIL_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[5]/span[2]");
			if(!TXT_EMAIL_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_EMAIL_ORDENANTE esperado: "+TXT_EMAIL_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MONEDA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[6]/span[2]");
			if(!CMB_MONEDA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MONEDA esperado: "+CMB_MONEDA+" ,obtenido: "+valor+"\n";
		}
		if(TXT_MONTO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[7]/span[2]");
			if(!TXT_MONTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TXT_MONTO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_CUENTA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[8]/span[2]");
			if(!CMB_CUENTA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+CMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
		}
		/*if(TXT_FECHA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[9]/span[2]");
			if(!TXT_FECHA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_FECHA_CARGO esperado: "+TXT_FECHA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(LBL_TIPO_CAMBIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[10]/table/tbody/tr/td/span");
			if(!LBL_TIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- LBL_TIPO_CAMBIO esperado: "+LBL_TIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_TICKET!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[5]/div/div[13]/span[2]");
			if(!TXT_NUMERO_TICKET.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_TICKET esperado: "+TXT_NUMERO_TICKET+" ,obtenido: "+valor+"\n";
		}*/
				
		if(TXT_NOMBRE_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[6]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TXT_NOMBRE_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[6]/div/div[3]/span[2]");
			if(!TXT_DIRECCION_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_BENEFICIARIO esperado: "+TXT_DIRECCION_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[6]/div/div[4]/span[2]");
			if(!TXT_TELEFONO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_BENEFICIARIO esperado: "+TXT_TELEFONO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[6]/div/div[5]/span[2]");
			if(!CMB_PAIS_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BENEFICIARIO esperado: "+CMB_PAIS_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[6]/div/div[6]/span[2]");
			if(!TXT_CIUDAD_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BENEFICIARIO esperado: "+TXT_CIUDAD_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(TXT_CUENTA_ABONO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[6]/div/div[7]/span[2]");
			if(!TXT_CUENTA_ABONO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TXT_CUENTA_ABONO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[7]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TXT_NOMBRE_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[7]/div/div[4]/span[2]");
			if(!TXT_CIUDAD_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO esperado: "+TXT_CIUDAD_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[7]/div/div[3]/span[2]");
			if(!CMB_PAIS_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO esperado: "+CMB_PAIS_BANCO+" ,obtenido: "+valor+"\n";
		}		
		if(CMB_TIPO_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[7]/div/div[5]/span[2]");
			if(!CMB_TIPO_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO esperado: "+CMB_TIPO_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[7]/div/div[6]/span[2]");
			if(!TXT_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO esperado: "+TXT_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[8]/div/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TXT_NOMBRE_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[8]/div/div/div[4]/span[2]");
			if(!TXT_CIUDAD_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO_INTERMEDIARIO esperado: "+TXT_CIUDAD_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[8]/div/div/div[3]/span[2]");
			if(!CMB_PAIS_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO_INTERMEDIARIO esperado: "+CMB_PAIS_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[8]/div/div/div[5]/span[2]");
			if(!CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO esperado: "+CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[8]/div/div/div[6]/span[2]");
			if(!TXT_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO_INTERMEDIARIO esperado: "+TXT_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MOTIVO_TRANSFERENCIA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[9]/div/div[2]/span[2]");
			if(!CMB_MOTIVO_TRANSFERENCIA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+CMB_MOTIVO_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
		}
		if(CMB_GASTOS_CORRESPONSAL!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[9]/div/div[3]/span[2]");
			if(!CMB_GASTOS_CORRESPONSAL.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+CMB_GASTOS_CORRESPONSAL+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DETALLE_PAGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[9]/div/div[4]/span[2]");
			if(!TXT_DETALLE_PAGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TXT_DETALLE_PAGO+" ,obtenido: "+valor+"\n";
		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}


	public boolean continuarOF() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[1]/div[9]/div/div[5]/div/button");
	}


	public String verificarDatosOFResultado(String strDescripcionOF) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String valor;
		
		String TXT_NOMBRE_ORDENANTE=Mdl_Variables.map.get("TXT_NOMBRE_ORDENANTE");
		String TXT_DIRECCION_ORDENANTE=Mdl_Variables.map.get("TXT_DIRECCION_ORDENANTE");
		String TXT_TELEFONO_ORDENANTE=Mdl_Variables.map.get("TXT_TELEFONO_ORDENANTE");
		String TXT_EMAIL_ORDENANTE=Mdl_Variables.map.get("TXT_EMAIL_ORDENANTE");
		String CMB_MONEDA=Mdl_Variables.map.get("CMB_MONEDA");
		String TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO");
		String CMB_CUENTA_CARGO=Mdl_Variables.map.get("CMB_CUENTA_CARGO");
		//String TXT_NUMERO_TICKET=Mdl_Variables.map.get("TXT_NUMERO_TICKET");
		//String LBL_TIPO_CAMBIO=Mdl_Variables.map.get("LBL_TIPO_CAMBIO");
		//String TXT_FECHA_CARGO=Mdl_Variables.map.get("TXT_FECHA_CARGO");
		String TXT_NOMBRE_BENEFICIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BENEFICIARIO");
		String TXT_DIRECCION_BENEFICIARIO=Mdl_Variables.map.get("TXT_DIRECCION_BENEFICIARIO");
		String CMB_PAIS_BENEFICIARIO=Mdl_Variables.map.get("CMB_PAIS_BENEFICIARIO");
		String TXT_CIUDAD_BENEFICIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BENEFICIARIO");
		String TXT_TELEFONO_BENEFICIARIO=Mdl_Variables.map.get("TXT_TELEFONO_BENEFICIARIO");
		String TXT_CUENTA_ABONO=Mdl_Variables.map.get("TXT_CUENTA_ABONO");
		String TXT_NOMBRE_BANCO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO");
		String CMB_PAIS_BANCO=Mdl_Variables.map.get("CMB_PAIS_BANCO");
		String TXT_CIUDAD_BANCO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO");
		String CMB_TIPO_CODIGO_BANCO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO");
		String TXT_CODIGO_BANCO=Mdl_Variables.map.get("TXT_CODIGO_BANCO");
		String TXT_NOMBRE_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO_INTERMEDIARIO");
		String CMB_PAIS_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_PAIS_BANCO_INTERMEDIARIO");
		String TXT_CIUDAD_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO_INTERMEDIARIO");
		String CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO");
		String TXT_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CODIGO_BANCO_INTERMEDIARIO");
		String CMB_MOTIVO_TRANSFERENCIA=Mdl_Variables.map.get("CMB_MOTIVO_TRANSFERENCIA");
		String CMB_GASTOS_CORRESPONSAL=Mdl_Variables.map.get("CMB_GASTOS_CORRESPONSAL");
		String TXT_DETALLE_PAGO=Mdl_Variables.map.get("TXT_DETALLE_PAGO");
		
		String valoresDiferentes="";
		
		if(strDescripcionOF!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[3]/div/div[3]/span[2]");
			if(!strDescripcionOF.equals(valor))
				valoresDiferentes=valoresDiferentes+"- DESCRIPCION OF esperado: "+strDescripcionOF+" ,obtenido: "+valor+"\n";
		}

		if(TXT_NOMBRE_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[3]/span[2]");
			if(!TXT_DIRECCION_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_ORDENANTE esperado: "+TXT_DIRECCION_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[4]/span[2]");
			if(!TXT_TELEFONO_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_ORDENANTE esperado: "+TXT_TELEFONO_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_EMAIL_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[5]/span[2]");
			if(!TXT_EMAIL_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_EMAIL_ORDENANTE esperado: "+TXT_EMAIL_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MONEDA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[6]/span[2]");
			if(!CMB_MONEDA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MONEDA esperado: "+CMB_MONEDA+" ,obtenido: "+valor+"\n";
		}
		if(TXT_MONTO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[7]/span[2]");
			if(!TXT_MONTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TXT_MONTO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_CUENTA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[8]/span[2]");
			if(!CMB_CUENTA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+CMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
		}
		/*if(TXT_FECHA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[9]/span[2]");
			if(!TXT_FECHA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_FECHA_CARGO esperado: "+TXT_FECHA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(LBL_TIPO_CAMBIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[10]/table/tbody/tr/td/span");
			if(!LBL_TIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- LBL_TIPO_CAMBIO esperado: "+LBL_TIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_TICKET!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[4]/div/div[13]/span[2]");
			if(!TXT_NUMERO_TICKET.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_TICKET esperado: "+TXT_NUMERO_TICKET+" ,obtenido: "+valor+"\n";
		}*/
				
		if(TXT_NOMBRE_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[5]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TXT_NOMBRE_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[5]/div/div[3]/span[2]");
			if(!TXT_DIRECCION_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_BENEFICIARIO esperado: "+TXT_DIRECCION_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[5]/div/div[4]/span[2]");
			if(!TXT_TELEFONO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_BENEFICIARIO esperado: "+TXT_TELEFONO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[5]/div/div[5]/span[2]");
			if(!CMB_PAIS_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BENEFICIARIO esperado: "+CMB_PAIS_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[5]/div/div[6]/span[2]");
			if(!TXT_CIUDAD_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BENEFICIARIO esperado: "+TXT_CIUDAD_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(TXT_CUENTA_ABONO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[5]/div/div[7]/span[2]");
			if(!TXT_CUENTA_ABONO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TXT_CUENTA_ABONO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[6]/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TXT_NOMBRE_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[6]/div/div[4]/span[2]");
			if(!TXT_CIUDAD_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO esperado: "+TXT_CIUDAD_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[6]/div/div[3]/span[2]");
			if(!CMB_PAIS_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO esperado: "+CMB_PAIS_BANCO+" ,obtenido: "+valor+"\n";
		}		
		if(CMB_TIPO_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[6]/div/div[5]/span[2]");
			if(!CMB_TIPO_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO esperado: "+CMB_TIPO_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[6]/div/div[6]/span[2]");
			if(!TXT_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO esperado: "+TXT_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[7]/div/div/div[2]/span[2]");
			if(!TXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TXT_NOMBRE_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[7]/div/div/div[4]/span[2]");
			if(!TXT_CIUDAD_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO_INTERMEDIARIO esperado: "+TXT_CIUDAD_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[7]/div/div/div[3]/span[2]");
			if(!CMB_PAIS_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO_INTERMEDIARIO esperado: "+CMB_PAIS_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[7]/div/div/div[5]/span[2]");
			if(!CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO esperado: "+CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[7]/div/div/div[6]/span[2]");
			if(!TXT_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO_INTERMEDIARIO esperado: "+TXT_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MOTIVO_TRANSFERENCIA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[8]/div/div[2]/span[2]");
			if(!CMB_MOTIVO_TRANSFERENCIA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+CMB_MOTIVO_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
		}
		if(CMB_GASTOS_CORRESPONSAL!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[8]/div/div[3]/span[2]");
			if(!CMB_GASTOS_CORRESPONSAL.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+CMB_GASTOS_CORRESPONSAL+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DETALLE_PAGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[8]/div/div[4]/span[2]");
			if(!TXT_DETALLE_PAGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TXT_DETALLE_PAGO+" ,obtenido: "+valor+"\n";
		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}


	public String obtenerIdOF() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[3]/div/div[3]/span[4]");
	}


	public boolean realizarOtraTransferenciaOF() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[3]/div[2]/div/div[8]/div/div[5]/a");
	}


	public boolean verOperacionesFrecuentes() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/a");
		//return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "div.linkOperacionesFrecuentes > a.gwt-Anchor");
	}


	public boolean seleccionarOF(String strIDOF) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			//String IdOF=colss.get(2).getText();
			String IdOF=colss.get(3).getText();
			if(strIDOF.equals(IdOF)){
				colss.get(0).click();
				return true;
			}
		}
		return false;
	}


	public boolean aceptarOF() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[3]/button");
	}
	
	public boolean verificarDetalleAutorizarComex() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		CapturarPantalla.pageDown("-1000");
		CapturarPantalla.scrollCapturaPantalla();
		CapturarPantalla.pageDown("400");
		CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		CapturarPantalla.pageDown("600");
		CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		
		String valor;
		
		String TXT_NOMBRE_ORDENANTE=Mdl_Variables.map.get("TXT_NOMBRE_ORDENANTE");
		String TXT_DIRECCION_ORDENANTE=Mdl_Variables.map.get("TXT_DIRECCION_ORDENANTE");
		String TXT_TELEFONO_ORDENANTE=Mdl_Variables.map.get("TXT_TELEFONO_ORDENANTE");
		String TXT_EMAIL_ORDENANTE=Mdl_Variables.map.get("TXT_EMAIL_ORDENANTE");
		String CMB_MONEDA=Mdl_Variables.map.get("CMB_MONEDA");
		String TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO");
		String CMB_CUENTA_CARGO=Mdl_Variables.map.get("CMB_CUENTA_CARGO");
		String TXT_NUMERO_TICKET=Mdl_Variables.map.get("TXT_NUMERO_TICKET");
		String LBL_TIPO_CAMBIO=Mdl_Variables.map.get("LBL_TIPO_CAMBIO");
		String TXT_FECHA_CARGO=Mdl_Variables.map.get("TXT_FECHA_CARGO");
//		String CMB_TIPO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("CMB_TIPO_DOCUMENTO_BENEFICIARIO");	
//		String TXT_NUMERO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("TXT_NUMERO_DOCUMENTO_BENEFICIARIO");	
		String TXT_NOMBRE_BENEFICIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BENEFICIARIO");
		String TXT_DIRECCION_BENEFICIARIO=Mdl_Variables.map.get("TXT_DIRECCION_BENEFICIARIO");
		String CMB_PAIS_BENEFICIARIO=Mdl_Variables.map.get("CMB_PAIS_BENEFICIARIO");
		String TXT_CIUDAD_BENEFICIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BENEFICIARIO");
		String TXT_TELEFONO_BENEFICIARIO=Mdl_Variables.map.get("TXT_TELEFONO_BENEFICIARIO");
		String TXT_CUENTA_ABONO=Mdl_Variables.map.get("TXT_CUENTA_ABONO");
		String TXT_NOMBRE_BANCO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO");
		String CMB_PAIS_BANCO=Mdl_Variables.map.get("CMB_PAIS_BANCO");
		String TXT_CIUDAD_BANCO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO");
		String CMB_TIPO_CODIGO_BANCO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO");
		String TXT_CODIGO_BANCO=Mdl_Variables.map.get("TXT_CODIGO_BANCO");
		String TXT_NOMBRE_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO_INTERMEDIARIO");
		String CMB_PAIS_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_PAIS_BANCO_INTERMEDIARIO");
		String TXT_CIUDAD_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO_INTERMEDIARIO");
		String CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO");
		String TXT_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CODIGO_BANCO_INTERMEDIARIO");
		String CMB_MOTIVO_TRANSFERENCIA=Mdl_Variables.map.get("CMB_MOTIVO_TRANSFERENCIA");
		String CMB_GASTOS_CORRESPONSAL=Mdl_Variables.map.get("CMB_GASTOS_CORRESPONSAL");
		String TXT_DETALLE_PAGO=Mdl_Variables.map.get("TXT_DETALLE_PAGO");
		boolean indAhorro=false;
		
		String valoresDiferentes="";

		if(TXT_NOMBRE_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/span[4]");
			if(!TXT_NOMBRE_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/span[6]");
			if(!TXT_DIRECCION_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_ORDENANTE esperado: "+TXT_DIRECCION_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/span[8]");
			if(!TXT_TELEFONO_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_ORDENANTE esperado: "+TXT_TELEFONO_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_EMAIL_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/span[10]");
			if(!TXT_EMAIL_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_EMAIL_ORDENANTE esperado: "+TXT_EMAIL_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MONEDA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/span[12]");
			if(!CMB_MONEDA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MONEDA esperado: "+CMB_MONEDA+" ,obtenido: "+valor+"\n";
		}
		if(TXT_MONTO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/span[14]");
			if(!TXT_MONTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TXT_MONTO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_CUENTA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/span[16]");
			valor=valor.substring(0, valor.length()-11)+"-"+valor.substring(valor.length()-10, valor.length());
			CMB_CUENTA_CARGO=CMB_CUENTA_CARGO.substring(0, CMB_CUENTA_CARGO.length()-11)+"-"+CMB_CUENTA_CARGO.substring(CMB_CUENTA_CARGO.length()-10, CMB_CUENTA_CARGO.length());
			if(valor.contains("Ahorro"))
				indAhorro=true;
			if(!CMB_CUENTA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+CMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_FECHA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/div[1]/span[2]");
			if(!TXT_FECHA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_FECHA_CARGO esperado: "+TXT_FECHA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(LBL_TIPO_CAMBIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/div[2]/span[2]");
			if(!LBL_TIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- LBL_TIPO_CAMBIO esperado: "+LBL_TIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_TICKET!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/div[5]/span[2]");
			if(!TXT_NUMERO_TICKET.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_TICKET esperado: "+TXT_NUMERO_TICKET+" ,obtenido: "+valor+"\n";
		}
		if(!TransferenciasExteriorBE.strTIPO_CAMBIO.equals("")){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/div[2]/span[2]");			
			if(!TransferenciasExteriorBE.strTIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TIPO_CAMBIO esperado: "+TransferenciasExteriorBE.strTIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		
		if(!TransferenciasExteriorBE.strARBITRAJE.equals("")){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[2]/div/div[3]/span[2]");			
			if(!TransferenciasExteriorBE.strARBITRAJE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- ARBITRAJE esperado: "+TransferenciasExteriorBE.strARBITRAJE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NOMBRE_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[3]/div/span[4]");
			if(!TXT_NOMBRE_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TXT_NOMBRE_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		/*if(CMB_TIPO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[3]/span[2]");
			if(!CMB_TIPO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_DOCUMENTO_BENEFICIARIO esperado: "+CMB_TIPO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[4]/div/div[4]/span[2]");
			if(!TXT_NUMERO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_DOCUMENTO_BENEFICIARIO esperado: "+TXT_NUMERO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}*/
		if(TXT_DIRECCION_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[3]/div/span[6]");
			
			if(!TXT_DIRECCION_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_BENEFICIARIO esperado: "+TXT_DIRECCION_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[3]/div/div/span[2]");
			if(!TXT_TELEFONO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_BENEFICIARIO esperado: "+TXT_TELEFONO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[3]/div/span[8]");
			if(!CMB_PAIS_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BENEFICIARIO esperado: "+CMB_PAIS_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[3]/div/span[10]");
			if(!TXT_CIUDAD_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BENEFICIARIO esperado: "+TXT_CIUDAD_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(TXT_CUENTA_ABONO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[3]/div/span[12]");			                                                            
			if(!TXT_CUENTA_ABONO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TXT_CUENTA_ABONO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[4]/div/span[4]");
			if(!TXT_NOMBRE_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TXT_NOMBRE_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[4]/div/span[6]");
			if(!CMB_PAIS_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO esperado: "+CMB_PAIS_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[4]/div/span[8]");
			if(!TXT_CIUDAD_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO esperado: "+TXT_CIUDAD_BANCO+" ,obtenido: "+valor+"\n";
		}
				
		if(CMB_TIPO_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[4]/div/span[10]");
			if(!CMB_TIPO_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO esperado: "+CMB_TIPO_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[4]/div/span[12]");
			if(!TXT_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO esperado: "+TXT_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		
		if(TXT_NOMBRE_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[5]/div/div/span[4]");
			if(!TXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TXT_NOMBRE_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[5]/div/div/span[6]");
			if(!CMB_PAIS_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO_INTERMEDIARIO esperado: "+CMB_PAIS_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}	
		if(TXT_CIUDAD_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[5]/div/div/span[8]");
			if(!TXT_CIUDAD_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO_INTERMEDIARIO esperado: "+TXT_CIUDAD_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}			
		if(CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[5]/div/div/span[10]");
			if(!CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO esperado: "+CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[5]/div/div/span[12]");
			if(!TXT_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO_INTERMEDIARIO esperado: "+TXT_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MOTIVO_TRANSFERENCIA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[6]/div/span[4]");
			if(!CMB_MOTIVO_TRANSFERENCIA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+CMB_MOTIVO_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
		}
		if(CMB_GASTOS_CORRESPONSAL!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[6]/div/span[6]");
			if(!CMB_GASTOS_CORRESPONSAL.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+CMB_GASTOS_CORRESPONSAL+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DETALLE_PAGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[6]/div/div/pre/span");
			if(!TXT_DETALLE_PAGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TXT_DETALLE_PAGO+" ,obtenido: "+valor+"\n";
		}
		
		String mensajeHorarioProceso=getMensajeDetalleAutoHorarioProceso();
		String mensajeHorarioProcesoBD="- "+Mdl_Variables.Gstr_Parametros[6];
		if (!mensajeHorarioProceso.equals(mensajeHorarioProcesoBD)){
			valoresDiferentes=valoresDiferentes+"- MensajeHorarioProcesoBD esperado: "+mensajeHorarioProcesoBD+" ,obtenido: "+mensajeHorarioProceso+"\n";
		}
		if(!indAhorro){
			String mensajeSaldoCtaCorriente=getMensajeDetalleAutoSaldoCtaCorriente();
			String mensajeSaldoCtaCorrienteBD="- "+Mdl_Variables.Gstr_Parametros[7];
			if (!mensajeSaldoCtaCorriente.equals(mensajeSaldoCtaCorrienteBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeSaldoCtaCorriente esperado: "+mensajeSaldoCtaCorrienteBD+" ,obtenido: "+mensajeSaldoCtaCorriente+"\n";
			}
		}else{
			String mensajeSaldoCtaAhorros=getMensajeDetalleAutoSaldoCtaAhorros();
			String mensajeSaldoCtaAhorrosBD="- "+Mdl_Variables.Gstr_Parametros[8];
			if (!mensajeSaldoCtaAhorros.equals(mensajeSaldoCtaAhorrosBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeSaldoCtaAhorros esperado: "+mensajeSaldoCtaAhorrosBD+" ,obtenido: "+mensajeSaldoCtaAhorros+"\n";
			}
		}		

		String mensajeConfir72horas=getMensajeDetalleAuto72horas();
		String mensajeConfir72horasBD="- ";
		/*if(TXT_NUMERO_TICKET!=null){
			mensajeConfir72horasBD=mensajeConfir72horasBD+Mdl_Variables.Gstr_Parametros[18];
		}
		else{*/
			mensajeConfir72horasBD=mensajeConfir72horasBD+Mdl_Variables.Gstr_Parametros[1];
		//}
		if (!mensajeConfir72horas.equals(mensajeConfir72horasBD)){
			valoresDiferentes=valoresDiferentes+"- MensajeConfir72horasBD esperado: "+mensajeConfir72horasBD+" ,obtenido: "+mensajeConfir72horas+"\n";
		}
		
		if(!valoresDiferentes.equals("")){
			System.out.println("Caso: "+TransferenciasExteriorBE.GstrID_CASO+" - Valores diferentes en Detalle de Autorización consolidado: \n"  + valoresDiferentes);
			return false;
		}else{
			CapturarPantalla.pageDown("-2000");
			if(objFuncionesGenerales.verificarIgnore(AutorizacionesPendientesBE.GstrLNK_ENVIAR_EMAIL_FINAL)){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[9]/div/div[1]/a");//enviar correo
				objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input",AutorizacionesPendientesBE.GstrTXT_CORREO_FINAL );
				objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", AutorizacionesPendientesBE.GstrTXT_MENSAJE_CORREO_FINAL);
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");
			}
			if(objFuncionesGenerales.verificarIgnore(AutorizacionesPendientesBE.GstrLNK_EXPORTAR_EXCEL_FINAL)){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[9]/div/div[4]/a");//excel
			}
			if(objFuncionesGenerales.verificarIgnore(AutorizacionesPendientesBE.GstrLNK_EXPORTAR_PDF_FINAL)){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[9]/div/div[5]/a");//pdf
			}
			return true;
		}
			
		
	}
	
	private static String getMensajeDetalleAuto72horas() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[8]/div/span[1]");
	}


	private static String getMensajeDetalleAutoSaldoCtaAhorros() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[8]/div/span[4]");
	}


	private static String getMensajeDetalleAutoSaldoCtaCorriente() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[8]/div/span[3]");
	}


	private static String getMensajeDetalleAutoHorarioProceso() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/div[2]/div[8]/div/span[2]");
	}


	public String getMensajeEnvioHorarioProceso() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[6]/div/span[1]");
	}
	public String getMensajeEnvioSaldoCtaCorriente() throws InterruptedException, IOException{
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[6]/div/span[2]");
	}
	public String getMensajeEnvioSaldoCtaAhorros() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div[6]/div/span[3]");
	}
	
	public String getMensajeConfirHorarioProceso() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[8]/div/span[4]");
	}
	public String getMensajeConfirSaldoCtaCorriente() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[8]/div/span[5]");
	}
	public String getMensajeConfirSaldoCtaAhorros() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[8]/div/span[6]");
	}
	public String getMensajeConfir72horas() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[8]/div/span[2]");
	}
	public String getMensajeConfirMensajeSwift() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[8]/div/span[3]");
	}
	public String getMensajeConfirRevisarHistorica() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[8]/div/span[1]");
	}	

	public static String verificarMensajeConfirmacion(boolean consultar) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String valoresDiferentes="";
		String mensajeHorarioProceso=getMensajeConfirAutoHorarioProceso();
		String mensajeHorarioProcesoBD="(****) "+Mdl_Variables.Gstr_Parametros[14];
		if (!mensajeHorarioProceso.equals(mensajeHorarioProcesoBD)){
			valoresDiferentes=valoresDiferentes+"- MensajeHorarioProcesoBD esperado: "+mensajeHorarioProcesoBD+" ,obtenido: "+mensajeHorarioProceso+"\n";
		}		
		
		if(!consultar){
					
			String mensajeConfir72horas=getMensajeConfirAuto72horas();
			String mensajeConfir72horasBD="(*) "+Mdl_Variables.Gstr_Parametros[15];
			if (!mensajeConfir72horas.equals(mensajeConfir72horasBD)){
				valoresDiferentes=valoresDiferentes+"- MensajeConfir72horasBD esperado: "+mensajeConfir72horasBD+" ,obtenido: "+mensajeConfir72horas+"\n";
			}
		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}

	private static String getMensajeConfirAuto72horas() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[2]/span[5]");
	}

	private static String getMensajeConfirAutoHorarioProceso() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/div[2]/div[2]/div[2]/span[9]");
	}


	
	
}