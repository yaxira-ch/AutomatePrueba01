package proxim.bl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ContratosDigitalesBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class ContratosDigitalesMapeo {
	
	/*PESTAÑA DE SOLICITUD*/
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean blnResultadoEsperado=false;

	String urlMenu="//html/body/div[2]/div[2]/div/ul/li[8]/a/span"; 
	String urlSubMenu="//html/body/div[2]/div[2]/div/ul/li[8]/div/div/ul/li[2]/div/a/span"; 
	String urlExitMenu="//html/body/div[2]/div[1]/div[2]/div[2]/ul/li";	
	String urlCmbEmpresa   ="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[1]/div[2]/select";
	String urlCmbEmpresaCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[1]/div[2]/select";					   
	String urlRbtSinlimiteTransaccion="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/ul/li/span[3]/input";//"//*[@id='listacuadro']/li/span[1]/input"; 
	String urlRbtSinlimiteTransaccionCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/ul/li/span[3]/input";//"//*[@id='listacuadro']/li/span[1]/input"; 
	String urlRbtConlimiteTransaccion="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/ul/li/span[1]/input";//"//*[@id='listacuadro']/li/span[3]/input";
	String urlRbtConlimiteTransaccionCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/ul/li/span[1]/input";//"//*[@id='listacuadro']/li/span[3]/input";
	String urlRbtMontoMaximoSolesPorLoteCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]/span/input";//*[@id="gwt-uid-849"]
	String urlRbtMontoMaximoSolesPorLote="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]/span/input";//*[@id="gwt-uid-849"]
	String urlRbtMontoSinLimiteSolesPorLoteCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[4]/span/input";
	String urlRbtMontoSinLimiteSolesPorLote="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[4]/span/input";
	String urlTxtMontoMaximoSolesPorLoteCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[3]/input";
	String urlTxtMontoMaximoSolesPorLote="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[2]/td/table/tbody/tr/td[3]/input";
	String urlRbtMontoMaximoDolaresPorLoteCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[5]/td/table/tbody/tr/td[2]/span/input";
	String urlRbtMontoMaximoDolaresPorLote="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[5]/td/table/tbody/tr/td[2]/span/input";
	String urlRbtMontoSinLimiteDolaresPorLoteCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[5]/td/table/tbody/tr/td[4]/span/input";
	String urlRbtMontoSinLimiteDolaresPorLote="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[4]/span/input";
	String urlTxtMontoMaximoDolaresPorLoteCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[5]/td/table/tbody/tr/td[3]/input";
	String urlTxtMontoMaximoDolaresPorLote="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[1]/tbody/tr[5]/td/table/tbody/tr/td[3]/input";
	
	String urlRbtMontoMaximoSolesPorPagoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[2]/span/input";
	String urlRbtMontoMaximoSolesPorPago="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]/span/input";
	String urlRbtMontoSinLimiteSolesPorPagoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[4]/span/input";												
	String urlRbtMontoSinLimiteSolesPorPago="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[4]/span/input";												
	String urlTxtMontoMaximoSolesPorPagoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[3]/td/table/tbody/tr/td[3]/input";
	String urlTxtMontoMaximoSolesPorPago="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[2]/td/table/tbody/tr/td[3]/input";
	String urlRbtMontoMaximoDolaresPorPagoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[5]/td/table/tbody/tr/td[2]/span/input";
	String urlRbtMontoMaximoDolaresPorPago="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[5]/td/table/tbody/tr/td[2]/span/input";
	String urlRbtMontoSinLimiteDolaresPorPagoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[5]/td/table/tbody/tr/td[4]/span/input";
	String urlRbtMontoSinLimiteDolaresPorPago="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[5]/td/table/tbody/tr/td[4]/span/input";
	String urlTxtMontoMaximoDolaresPorPagoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[5]/td/table/tbody/tr/td[3]/input";																					
	String urlTxtMontoMaximoDolaresPorPago="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/div/table[2]/tbody/tr[5]/td/table/tbody/tr/td[3]/input";																					
	
	String urlCmbCuentaCargo="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[4]/div[2]/select";
	String urlCmbCuentaCargoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[4]/div[2]/select";
	String urlBtnAgregarCuentaOtraMoneda="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[4]/div[4]/a";
	String urlBtnAgregarCuentaOtraMonedaCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[4]/div[4]/a";
	String urlCmbCuentaOtraMoneda="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[4]/div[3]/table/tbody/tr/td[1]/select";
	String urlCmbCuentaOtraMonedaCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[4]/div[3]/table/tbody/tr/td[1]/select";
	String urlBtnQuitarCuentaOtraMoneda="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[5]/div[3]/table/tbody/tr/td[2]/a/img";
	String urlBtnQuitarCuentaOtraMonedaCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[4]/div[3]/table/tbody/tr/td[2]/a/img";
	String urlLnkConfirgurarPermisos="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[6]/div[2]/a";
	String urlLnkConfirgurarPermisosCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[3]/div[2]/a";
	String urlBtnConfirmarAccesos="/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/button";
	String urlTxtCorreoElectronicoContacto="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[6]/div[2]/input";
	String urlTxtCorreoElectronicoContactoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[5]/div[2]/input";
	String urlTxtTelefonoContacto="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[6]/div[4]/input";
	String urlTxtTelefonoContactoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[5]/div[4]/input";
	String urlRbtFirmarSinFirmasConjuntasNo="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[8]/div[2]/div[1]/ul/li/span[3]/input";
	String urlBtnFirmaryGuardar="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[8]/div/button[2]";
	String urlBtnFirmaryGuardarCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[7]/div/button[2]";
	String urlBtnFirmaryEnviar="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[8]/div/button[3]";
	String urlBtnFirmaryEnviarCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[7]/div/button[3]";
	String urlBtnGuardar="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[8]/div/button[1]";
	String urlBtnGuardarCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[7]/div/button[1]";
	String urlLnkVerUsuariosCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/a";
	String urlLnkVerUsuarios="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/a";
	String urlLnkVerUsuariosAutorizar="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/a";
	String urlLnkVerTerminosCondiciones="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[3]/div/a";
	String urlChkAceptoTerminosCondiciones=   "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[3]/div/span[1]/input";
	String urlChkAceptoTerminosCondicionesCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[3]/div/span[1]/input";
	String urlLnkVerQuieresSaberComo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[5]/div[1]/a";
	String urlTxtIngresarClaveDinamica="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[5]/div[2]/input";
	String urlTxtIngresarClaveDinamicaCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[5]/div[2]/input";
	String urlBtnConfirmar="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[6]/div/button[1]";
	String urlBtnConfirmarCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[6]/div/button[1]";
	String urlBtnCancelarOperacion="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[6]/div/button[2]";
	String urlBtnCancelarOperacionCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[6]/div/button[2]";
	String strTituloResultadoEsperado="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/h1";
	String strTituloResultadoEsperadoCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[1]/div/span";
	String strTituloResultadoEsperadoFinalCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[1]/div/span";
	String strTituloResultadoEsperadoFinal="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/h1";
	String urlLnkVerUsuarios2CTS="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/a";
	String urlLnkVerUsuarios2="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/a";
	String urlBtnCerrarUsuarios2CTS="//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a";
	String urlBtnCerrarUsuarios2="/html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a";
	//String urlLnkVerUsuariosNew="/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[11]/a";
	String urlLnkVerUsuariosNew="Ver usuarios »";
	/*PESTAÑA DE PENDIENTES Y ENVIADAS*/
	String urlCmbEmpresa2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/select";
	String urlLnkUsuariosConAcceso="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[6]/a";
	String urlLnkRegresar="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div[2]/a";
	String urlRbtFirmaSolicitudSi="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div/ul/li/span[1]/input";
	String urlRbtSolicitudTieneFirmasNecesariasSi="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/ul/li/span[1]/input";
	String urlRbtSolicitudTieneFirmasNecesariasNo="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/ul/li/span[3]/input";
	String urlRbtFirmaSolicitudNo="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div/ul/li/span[3]/input";
	String urlBtnFirmarEnviarSolicitud="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[6]/div/button";
	String urlBtnFirmarGuardarSolicitud="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[7]/div/button";
	String urlBtnEnviarSolicitud="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[5]/div/button";
	String urlLnkTerminosCondiciones2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[3]/div/a";
	String urlBtnCerrar="//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a";
	String urlBtnCerrarPopUpNew="/html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a";
	String urlBtnCerrarNew="/html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a";
	
	String urlChkAceptoTerminosCondiciones2="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[3]/div/span";
	String urlChkAceptoTerminosCondiciones2CTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[3]/div/span[1]/input";
	String urlTxtIngresarClaveDinamica2="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[5]/div[2]/input";
	String urlTxtIngresarClaveDinamica2CTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[5]/div[2]/input";
	String urlBtnConfirmar2="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[6]/div/button[1]";
	String urlBtnConfirmar2CTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[6]/div/button[1]";
	String urlBtnCancelarOperacion2="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[6]/div/button[2]";
	String strObtenido=" ,obtenido: ";
	String strLimiteites="n límites";
	String strLimite="n límite";
	String strSinLimites="Sin límites";
	
	String strCuentaCargoSolesConfirmacion="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[45]";
	String strCuentaCargoDolaresConfirmacion="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[47]";
	
	String strCuentaCargoSolesConfirmacionCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[25]";
	String strCuentaCargoDolaresConfirmacionCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[27]";
	
	String strCuentaCargoSolesResultadoFinal="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[47]";
	String strCuentaCargoSolesResultadoFinalCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[31]";
	String strCuentaCargoDolaresesResultadoFinalCTS="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[33]";
	
	String strCuentaCargoDolaresResultadoFinal="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[49]";
	String strTelefonoContactoResultadoFinal="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[60]";
	String strCorreoContactoResultadoFinal="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[58]";
	
	public boolean seleccionarSubMenu1(String strProducto)  {	
	boolean var=false;
		for(int i=1;i<=3;i++){ 
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/div/li["+i+"]/a")).getText();
			if(strProducto.equals(valor)){	
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/div/li["+i+"]/a");
				break;
			}
		}
		return var;	
	}
	
	public boolean seleccionarOpcionPago(String strOpcionPago)  {	
		boolean blnResultadoEsperado=false;
		for(int i=1;i<=3;i++){ 
			String strPago="//*[@id='panelAcordion']/table["+i+"]/tbody/tr[1]/td/a/table/tbody/tr/td/div/div/div";
			String strPagoDescripcion= objObjetosGenerales.getText(ObjetosGenerales.xpath,strPago );
			if(strOpcionPago.equals(strPagoDescripcion)){	
				blnResultadoEsperado= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strPago);
				break;
			}
		}
		return blnResultadoEsperado;	
	}
	
	public String ValidarTextoProducto(String strOpcionPago)  {	
		String strValorActual1,strValorActual2;
		String strValorPantalla1,strValorPantalla2;
		String strResultado="";
		switch (strOpcionPago){
			case "Remuneraciones y CTS": 
				strValorActual1="Pago de Remuneraciones\nRealiza el pago a tus colaboradores de forma masiva, ágil y sencilla a través de: abonos en cuenta Interbank o transferencias interbancarias. Conocer más »";
				strValorActual2="Pago de CTS\nPaga la CTS de tus colaboradores directo en sus cuentas. Podrás realizar los abonos a cuentas Interbank o a través de transferencias interbancarias. Conocer más »";
				
				strValorPantalla1=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//*[@id=\'listacuadro\']/li[1]" );
				strValorPantalla2=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//*[@id=\'listacuadro\']/li[2]" );
				break;
			case "Proveedores": 
				strValorActual1="Pago a Proveedores\nRealiza pagos masivos a tus proveedores persona jurídica o persona natural con RUC a través de: abonos en cuenta Interbank, transferencias interbancarias o cheques de gerencia. Conocer más »\n*Los usuarios que pueden usar este producto son todos los de nivel B o C , según lo configurado en tu contrato de la Banca por Internet para Empresas.";
				strValorActual2="";
				
				strValorPantalla1=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//*[@id='panelAcordion']/table[2]/tbody/tr[2]/td/div/div/div[1]" );
				strValorPantalla2="";
				break;
			default:
				strValorActual1="Pagos Varios\nRealiza pagos masivos a personas naturales con DNI a través de: abonos en cuenta Interbank, cheques de gerencia u órdenes de pago (recojo en efectivo en tiendas). Conocer más »\n*Los usuarios que pueden usar este producto son todos los de nivel B o C , según lo configurado en tu contrato de la Banca por Internet para Empresas.";
				strValorActual2="";
				
				strValorPantalla1=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//*[@id='panelAcordion']/table[3]/tbody/tr[2]/td/div/div/div[1]" );
				strValorPantalla2="";
				break;
		}
			
		if(!strValorActual1.equals(strValorPantalla1)){
			strResultado=strResultado+"Valores Diferentes: Valor esperado-"+strValorActual1+"; Valor Optenido-"+strValorPantalla1+".";
		}
		
		if(!strValorActual2.equals(strValorPantalla2)){
			strResultado=strResultado+"Valores Diferentes: Valor esperado-"+strValorActual2+"; Valor Optenido-"+strValorPantalla2+".";
		}
		
		
		return strResultado;
	}
	
	public boolean solicitarProducto(String strBoton, String strPago){ 
		String strCadenaBoton="";
		String strNumero="";
		
		switch (strPago){
			case "Remuneraciones y CTS": 
				strNumero="1";
	    		break;
			case "Proveedores": 
				strNumero="2";
	    		break;
			default:
				strNumero="3";
	    		break;
		}
			
		if(strBoton.equals("Solicitar")){
			strCadenaBoton="1";
		}else{
			strCadenaBoton="2";
		}
		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='panelAcordion']/table["+strNumero+"]/tbody/tr[2]/td/div/div/div[2]/button["+strCadenaBoton+"]");
	}
	
	public boolean seleccionarEmpresa(String strEmpresa,String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlCmbEmpresaCTS;
		}else{
			strNewValor=urlCmbEmpresa;
		}	
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,strNewValor ,strEmpresa);
	}
	
	public boolean seleccionarsinlimite(String strBtnPagos)  {	
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtSinlimiteTransaccionCTS;
		}else{
			strNewValor=urlRbtSinlimiteTransaccion;
		}		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor );
	}	
	
	public boolean seleccionarConlimite(String strBtnPagos)  {	
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtConlimiteTransaccionCTS;
		}else{
			strNewValor=urlRbtConlimiteTransaccion;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public boolean seleccionarMontoMaximoSolesPorLote(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoMaximoSolesPorLoteCTS;
		}else{
			strNewValor=urlRbtMontoMaximoSolesPorLote;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}

	public boolean seleccionarMontoSinLimiteSolesPorLote(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoSinLimiteSolesPorLoteCTS;
		}else{
			strNewValor=urlRbtMontoSinLimiteSolesPorLote;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}

	public boolean ingresarMontoMaximoSolesPorLote(String strMontoMaximoSolesPorLote,String strBtnPagos)  throws InterruptedException {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtMontoMaximoSolesPorLoteCTS;
		}else{
			strNewValor=urlTxtMontoMaximoSolesPorLote;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,strNewValor , strMontoMaximoSolesPorLote);
	}

	public boolean seleccionarMontoMaximoDolaresPorLote(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoMaximoDolaresPorLoteCTS;
		}else{
			strNewValor=urlRbtMontoMaximoDolaresPorLote;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}
	
	public boolean seleccionarMontoSinLimiteDolaresPorLote(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoSinLimiteDolaresPorLoteCTS;
		}else{
			strNewValor=urlRbtMontoSinLimiteDolaresPorLote;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}

	public boolean ingresarMontoMaximoDolaresPorLote(String strMontoMaximoDolaresPorLote,String strBtnPagos)throws InterruptedException  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtMontoMaximoDolaresPorLoteCTS;
		}else{
			strNewValor=urlTxtMontoMaximoDolaresPorLote;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,strNewValor , strMontoMaximoDolaresPorLote);
	}
	
	public boolean seleccionarMontoMaximoSolesPorPago(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoMaximoSolesPorPagoCTS;
		}else{
			strNewValor=urlRbtMontoMaximoSolesPorPago;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}

	public boolean seleccionarMontoSinLimiteSolesPorPago(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoSinLimiteSolesPorPagoCTS;
		}else{
			strNewValor=urlRbtMontoSinLimiteSolesPorPago;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}

	public boolean ingresarMontoMaximoSolesPorPago(String strMontoMaximoSolesPorPago,String strBtnPagos)throws InterruptedException {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtMontoMaximoSolesPorPagoCTS;
		}else{
			strNewValor=urlTxtMontoMaximoSolesPorPago;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,strNewValor , strMontoMaximoSolesPorPago);
	}

	public boolean seleccionarMontoMaximoDolaresPorPago(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoMaximoDolaresPorPagoCTS;
		}else{
			strNewValor=urlRbtMontoMaximoDolaresPorPago;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}
	
	public boolean seleccionarMontoSinLimiteDolaresPorPago(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlRbtMontoSinLimiteDolaresPorPagoCTS;
		}else{
			strNewValor=urlRbtMontoSinLimiteDolaresPorPago;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}

	public boolean ingresarMontoMaximoDolaresPorPago(String strMontoMaximoDolaresPorPago,String strBtnPagos) throws InterruptedException {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtMontoMaximoDolaresPorPagoCTS;
		}else{
			strNewValor=urlTxtMontoMaximoDolaresPorPago;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,strNewValor , strMontoMaximoDolaresPorPago);
	}
	
	public boolean configurarPermisos(String strBtnPagos) {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlLnkConfirgurarPermisosCTS;
		}else{
			strNewValor=urlLnkConfirgurarPermisos;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor);
	}
	
	public boolean consolidarFacturas(String strConsolidarFacturas) {
		String strNumero="";
		if(strConsolidarFacturas.equals("Sí")){
			strNumero="1";
		}else{
			strNumero="3";
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/ul[2]/li/span/span["+strNumero+"]/input");
	}
	
	public boolean envioAutomatico(String strConsolidarFacturas) {
		String strNumero="";
		if(strConsolidarFacturas.equals("Sí")){
			strNumero="1";
		}else{
			strNumero="3";
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[2]/div[2]/ul[3]/li/span/span["+strNumero+"]/input");
	}
	
	public boolean comisionProveedor(String strConsolidarFacturas) {
		String strNumero="";
		if(strConsolidarFacturas.equals("Sí")){
			strNumero="1";
		}else{
			strNumero="3";
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[3]/div[2]/ul[2]/li/span["+strNumero+"]/input");
	}																
	
	public boolean confirmarAccesos()  	{ 
		   return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnConfirmarAccesos);
	}
	
	public boolean seleccionarCuentaCargo(String strCuentaCargo,String strBtnPagos )   {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlCmbCuentaCargoCTS;
		}else{
			strNewValor=urlCmbCuentaCargo;
		}
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,strNewValor ,strCuentaCargo);
	}

	public boolean agregarCuentaOtraMoneda(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnAgregarCuentaOtraMonedaCTS;
		}else{
			strNewValor=urlBtnAgregarCuentaOtraMoneda;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}
	
	public boolean seleccionarCuentaOtraMoneda(String strCuentaOtraMoneda,String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlCmbCuentaOtraMonedaCTS;
		}else{
			strNewValor=urlCmbCuentaOtraMoneda;
		}
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, strNewValor,strCuentaOtraMoneda);
	}

	public boolean quitarCuentaOtraMoneda(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnQuitarCuentaOtraMonedaCTS;
		}else{
			strNewValor=urlBtnQuitarCuentaOtraMoneda;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor );
	}

	public boolean ingresarCorreoElectronicoContacto(String strCorreoElectronicoContacto,String strBtnPagos) throws InterruptedException  { 
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtCorreoElectronicoContactoCTS;
		}else{
			strNewValor=urlTxtCorreoElectronicoContacto;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,strNewValor , strCorreoElectronicoContacto);
	}
	
	public boolean ingresarTelefonoContacto(String strTelefonoContacto,String strBtnPagos) throws InterruptedException  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtTelefonoContactoCTS;
		}else{
			strNewValor=urlTxtTelefonoContacto;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, strNewValor, strTelefonoContacto);
	}
	
	public boolean ingresarNumeroMaximoDiasCobro(String strTxtNumMaxDiasCobro) throws InterruptedException  { 
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[3]/div[2]/ul[1]/li/input" , strTxtNumMaxDiasCobro);
	}															   

	public boolean ingresarComisionSoles(String strTxtComisionSoles) throws InterruptedException  { 
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[3]/div[3]/div/ul/li[1]/div/input[1]", strTxtComisionSoles);
	}															  
	
	public boolean ingresarComisionDolares(String strTxtComisionDolares) throws InterruptedException  { 
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[3]/div[3]/div/ul/li[1]/div/input[2]" , strTxtComisionDolares);
	}
	
	public boolean seleccionarRepresentantePoderLegal(String strPoderLegal,String strBtnPagos)  {
		String strNewValor="";
		String strNumero="";
		if(strPoderLegal.equals("Sí")){
			strNumero="1";
		}else{
			strNumero="3";
		}
		
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[6]/div[2]/ul/li/span["+strNumero+"]/input";
		}else{
			strNewValor="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[7]/div[2]/ul/li/span["+strNumero+"]/input";
		}				
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public boolean seleccionarFirmarSinFirmasConjuntas(String strFirmasConjuntas,String strBtnPagos)  {
		String strNewValor="";
		String strNumero="";
		if(strFirmasConjuntas.equals("Sí")){
			strNumero="1";
		}else{
			strNumero="3";
		}
		
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[2]/div[6]/div[2]/div[1]/ul/li/span["+strNumero+"]/input";
		}else{
			strNewValor="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div[2]/div[7]/div[2]/div[1]/ul/li/span["+strNumero+"]/input";
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

//	public boolean seleccionarFirmarSinFirmasConjuntasNo()  {
//	 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlRbtFirmarSinFirmasConjuntasNo);
//	}
//	
//	public boolean seleccionarRepresentantePoderLegalNo()  {
//		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlRbtRepresentantePoderLegalNo);
//	}

	public boolean firmaryGuardar(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnFirmaryGuardarCTS;
		}else{
			strNewValor=urlBtnFirmaryGuardar;
		}	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public boolean firmaryEnviar(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnFirmaryEnviarCTS;
		}else{
			strNewValor=urlBtnFirmaryEnviar;
		}	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public boolean verUsuariosAutorizar(String strBtnPagos)  	{ 
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlLnkVerUsuariosCTS;
		}else{
			strNewValor=urlLnkVerUsuariosAutorizar;
		}	
	    return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
    }
	
	public boolean guardar(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnGuardarCTS;
		}else{
			strNewValor=urlBtnGuardar;
		}	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor );
	}

	public String verificarPantallaConfirmacion(String strPago)   {
	    String valor="";
	    String valoresDiferentes="";
	    
	    if(ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA!=Mdl_Variables.Gstr_Ignore){//Empresa
  			if(strPago.equals("Remuneraciones y CTS")) {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[2]");
  	  		}else {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[2]");
  	  		}
	    	if(!ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_EMPRESA esperado: "+ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA+strObtenido+valor+"\n";
  		} 
		
  		if(ContratosDigitalesBE.strBtnPagos!=Mdl_Variables.Gstr_Ignore){//Producto
  			String strValor;
  			switch (ContratosDigitalesBE.strBtnPagos){
				case "Remuneraciones y CTS": 
					strValor="Pago de Remuneraciones/CTS";
		    		break;
				case "Proveedores": 
					strValor="Pago a Proveedores";
		    		break;
				default:
					strValor="Pagos Varios";
		    		break;
  			}
  			if(strPago.equals("Remuneraciones y CTS")) {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[4]");
  	  		}else {
  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[4]");
  			}
  			if(!strValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_PRODUCTO esperado: "+strValor+strObtenido+valor+"\n";
  		}
  		String strNewValor= Mdl_Variables.Gstr_Ignore;
  		int intNewNumero=0;
  		
  		if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE!=Mdl_Variables.Gstr_Ignore){
  			strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE;
  			intNewNumero=1;
  		}else{
  			strNewValor=strSinLimites;
  		}
  		
  		if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa 
  			if(strPago.equals("Remuneraciones y CTS")) {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[10]");
  	  		}else {
  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[10]");
  			}
  			
  			if(intNewNumero==1){
  				valor=objObjetosGenerales.strNuevaMoneda(valor);
  	  		}
  			
  			if(!strNewValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_LOTE_SOLES esperado: "+strNewValor+strObtenido+valor+"\n";
  		}
  		
  		strNewValor= Mdl_Variables.Gstr_Ignore; 
  		intNewNumero=0;
  		
  		if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE!=Mdl_Variables.Gstr_Ignore){
  			strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE;
  			intNewNumero=1;
  		}else{
  			strNewValor=strSinLimites;
  		}
  		
  		if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa    
  			if(strPago.equals("Remuneraciones y CTS")) {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[12]");
  	  		}else {
  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[12]");
  			}
  			
  			if(intNewNumero==1){
  				valor=objObjetosGenerales.strNuevaMoneda(valor);
  	  		}

  			if(!strNewValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_LOTE_DOLARES esperado: "+strNewValor+strObtenido+valor+"\n";
  		}
  		
  		strNewValor= Mdl_Variables.Gstr_Ignore; 
  		intNewNumero=0;
  		
  		if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO!=Mdl_Variables.Gstr_Ignore){
  			strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO;
  			intNewNumero=1;
  		}else{
  			strNewValor=strSinLimites;
  		}

  		if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa  
  			if(strPago.equals("Remuneraciones y CTS")) {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[14]");
  	  		}else {
  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[14]");
  			}
  			
  			if(intNewNumero==1){
  				valor=objObjetosGenerales.strNuevaMoneda(valor);
  	  		}

  			if(!strNewValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_PAGOS_SOLES esperado: "+strNewValor+strObtenido+valor+"\n";
  		}
  		
  		strNewValor= Mdl_Variables.Gstr_Ignore; 
  		intNewNumero=0;
  		
  		if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO!=Mdl_Variables.Gstr_Ignore){
  			strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO;
  			intNewNumero=1;
  		}else{
  			strNewValor=strSinLimites;
  		}
  		
  		if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa    
  			if(strPago.equals("Remuneraciones y CTS")) {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div/span[16]");
  	  		}else {
  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[16]");
  			}
  			
  			if(intNewNumero==1){
  				valor=objObjetosGenerales.strNuevaMoneda(valor);
  	  		}

  			if(!strNewValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_PAGOS_DOLARES esperado: "+strNewValor+strObtenido+valor+"\n";
  		}
  		 
		if(ContratosDigitalesBE.strRbtConsolidarFactura!=Mdl_Variables.Gstr_Ignore){//Consolidar documentos de pago de un mismo 
  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[19]");
  			if(!ContratosDigitalesBE.strRbtConsolidarFactura.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- Consolidar_documento_pago esperado: "+ContratosDigitalesBE.strRbtConsolidarFactura+strObtenido+valor+"\n";
  		} 
		
		if(ContratosDigitalesBE.strRbtEnvioAutomatico!=Mdl_Variables.Gstr_Ignore){//Enviar mensaje automático al beneficiario
  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[23]");
  			if(!ContratosDigitalesBE.strRbtEnvioAutomatico.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- Enviar_mensaje_automatico esperado: "+ContratosDigitalesBE.strRbtEnvioAutomatico+strObtenido+valor+"\n";
  		} 
		
		if(ContratosDigitalesBE.strTxtNumMaxDiasCobro!=Mdl_Variables.Gstr_Ignore){//PLAZO DE COBRO DE ÓRDENES DE PAGO/CHEQUES
			String strValor=ContratosDigitalesBE.strTxtNumMaxDiasCobro+" día(s)";
  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[27]");
  			if(!strValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_MAXIMO_DIAS_COBRO esperado: "+strValor+strObtenido+valor+"\n";
  		}
		
		if(ContratosDigitalesBE.strComisionSoles!=Mdl_Variables.Gstr_Ignore){//COMISION PROVEEDOR SOLES
			String strValor=ContratosDigitalesBE.strComisionSoles+" %";
  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[35]");
  			if(!strValor.equals(valor)){							  
  				valoresDiferentes=valoresDiferentes+"- TXT_COMISION_SOLES_EMPRESA esperado: "+strValor+strObtenido+valor+"\n";
  			}
  			
  			strValor=(100-Integer.parseInt(ContratosDigitalesBE.strComisionSoles))+" %";
  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[33]");
  			if(!strValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_COMISION_SOLES_PROVEEDOR esperado: "+strValor+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.strTxtComisionDolares!=Mdl_Variables.Gstr_Ignore){//COMISION PROVEEDOR DOLARES
			String strValor=ContratosDigitalesBE.strTxtComisionDolares+" %";
  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[39]");
  			if(!strValor.equals(valor)){
  				valoresDiferentes=valoresDiferentes+"- TXT_COMISION_DOLARES_EMPRESA esperado: "+strValor+strObtenido+valor+"\n";
  			}
  			
  			strValor=(100-Integer.parseInt(ContratosDigitalesBE.strTxtComisionDolares))+" %";
  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/span[37]");
  			if(!strValor.equals(valor))
  				valoresDiferentes=valoresDiferentes+"- TXT_COMISION_DOLARES_PROVEEDOR esperado: "+strValor+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO!=Mdl_Variables.Gstr_Ignore){//Ambas cuentas
			if(strPago.equals("Remuneraciones y CTS")){
				if(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath,strCuentaCargoSolesConfirmacionCTS );
				}else{															
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath,strCuentaCargoDolaresConfirmacionCTS );
				}
			}else{
				if(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoSolesConfirmacion);
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath,strCuentaCargoDolaresConfirmacion );
				}
			}
				if(!objObjetosGenerales.nuevoCuenta(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO).equals(objObjetosGenerales.nuevoCuenta(valor)))
					valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+ContratosDigitalesBE.GstrCMB_CUENTA_CARGO+strObtenido+valor+"\n";
		} 
		
		if( ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA!=Mdl_Variables.Gstr_Ignore ){//una sola cuenta
			if(strPago.equals("Remuneraciones y CTS")){
				if(ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoSolesConfirmacionCTS);
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoDolaresConfirmacionCTS);
				}
			}else{
	  			if(ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoSolesConfirmacion);
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath,strCuentaCargoDolaresConfirmacion );
				}
			}
			if(!objObjetosGenerales.nuevoCuenta(ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA).equals(objObjetosGenerales.nuevoCuenta(valor)))
  				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_OTRA_MONEDA esperado: "+ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA+strObtenido+valor+"\n";
  		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}
		
	
	
	public boolean verUsuarios(String strBtnPagos)  	{ 
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlLnkVerUsuariosCTS;
		}else{
			strNewValor=urlLnkVerUsuarios;
		}		
	    return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
    }

	public boolean aceptarTerminosCondiciones(String strBtnPagos)   {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlChkAceptoTerminosCondicionesCTS;
		}else{
			strNewValor=urlChkAceptoTerminosCondiciones;
		}	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strNewValor );
	}

	public boolean verQuieresSaberComo()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlLnkVerQuieresSaberComo);
	}

	public boolean ingresarClave(String strClaveNew)  {	
		   String  strValorBoton = "";
		   String  strClave = strClaveNew;
		   String  strLetraValor = "";

		   for (int i = 1;i<=strClave.length();i++)  {
			   strLetraValor = strClave.split("")[i - 1];
	        
			   for (int j = 1; j <= 10; j++) {
				   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).getText();
	        
				   if (strValorBoton.equals(strLetraValor)){
					   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).click();
					   break;
				   }
			   }
	       }
		   return true;
	
	}

	public boolean ingresarClaveDinamica(String strDescripcion,String strBtnPagos) throws InterruptedException  {	
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtIngresarClaveDinamicaCTS;
		}else{
			strNewValor=urlTxtIngresarClaveDinamica;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,strNewValor , strDescripcion);
	}
	
	public boolean 	verificarPantallaResultadoEsperado(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=strTituloResultadoEsperadoFinalCTS;
		}else{
			strNewValor=strTituloResultadoEsperadoFinal;
		}
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath,strNewValor );
	}
	
	public boolean 	verificarCargaPantallaConfirmacion(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=strTituloResultadoEsperadoCTS;
		}else{
			strNewValor=strTituloResultadoEsperado;
		}	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strNewValor);
	}
	
	public boolean confirmar(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnConfirmarCTS;
		}else{
			strNewValor=urlBtnConfirmar;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public boolean cancelarOperacion(String strBtnPagos)   {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnCancelarOperacionCTS;
		}else{
			strNewValor=urlBtnCancelarOperacion;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public String obtenerMensajeError(String strTxtColumnaError) {
		return null;
	}
	
	public String verificarPantallaResultado(String strBtnPagos){
		String valor;
	    String valoresDiferentes="";
	    
	    if(ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA!=Mdl_Variables.Gstr_Ignore){//Empresa
	    	if(strBtnPagos.equals("Remuneraciones y CTS")) {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[4]");
  	  		}else {
  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[4]");
  	  		}
				if(!ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_EMPRESA esperado: "+ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA+strObtenido+valor+"\n";
			} 
		
			if(ContratosDigitalesBE.strBtnPagos!=Mdl_Variables.Gstr_Ignore){//Producto
				String strValor;
				switch (ContratosDigitalesBE.strBtnPagos){
				case "Remuneraciones y CTS": 
					strValor="Pago de Remuneraciones/CTS";
		    		break;
				case "Proveedores": 
					strValor="Pago a Proveedores";
		    		break;
				default:
					strValor="Pagos Varios";
		    		break;
  			}
				if(strBtnPagos.equals("Remuneraciones y CTS")) {
	  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[6]");
	  	  		}else {
	  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[6]");
	  			}
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_PRODUCTO esperado: "+strValor+strObtenido+valor+"\n";
			}
			String strNewValor= Mdl_Variables.Gstr_Ignore;
			int intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
			
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa 
				if(strBtnPagos.equals("Remuneraciones y CTS")) {
	  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[14]");
	  	  		}else {
	  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[12]");
	  			}
	  			
	  			if(intNewNumero==1){
	  				valor=objObjetosGenerales.strNuevaMoneda(valor);
	  	  		}
				
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_LOTE_SOLES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			
			strNewValor= Mdl_Variables.Gstr_Ignore; 
			intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
			
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa  
				if(strBtnPagos.equals("Remuneraciones y CTS")) {
	  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[16]");
	  	  		}else {
	  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[14]");
	  			}
				
				if(intNewNumero==1){
	  				valor=objObjetosGenerales.strNuevaMoneda(valor);
	  	  		}
				
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_LOTE_DOLARES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			
			strNewValor= Mdl_Variables.Gstr_Ignore; 
			intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
	
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa   
				if(strBtnPagos.equals("Remuneraciones y CTS")) {
	  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[18]");
	  	  		}else {
	  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[16]");
	  			}
				
				if(intNewNumero==1){
	  				valor=objObjetosGenerales.strNuevaMoneda(valor);
	  	  		}
				
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_PAGOS_SOLES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			
			strNewValor= Mdl_Variables.Gstr_Ignore; 
			intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
			
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa  
				
				if(strBtnPagos.equals("Remuneraciones y CTS")) {
	  				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[20]");
	  	  		}else {
	  	  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[18]");
	  			}

				if(intNewNumero==1){
	  				valor=objObjetosGenerales.strNuevaMoneda(valor);
	  	  		}
				
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_PAGOS_DOLARES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			 
		if(ContratosDigitalesBE.strRbtConsolidarFactura!=Mdl_Variables.Gstr_Ignore){//Consolidar documentos de pago de un mismo 
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[21]");
				if(!ContratosDigitalesBE.strRbtConsolidarFactura.equals(valor))
					valoresDiferentes=valoresDiferentes+"- Consolidar_documento_pago esperado: "+ContratosDigitalesBE.strRbtConsolidarFactura+strObtenido+valor+"\n";
			} 
		
		if(ContratosDigitalesBE.strRbtEnvioAutomatico!=Mdl_Variables.Gstr_Ignore){//Enviar mensaje automático al beneficiario
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[25]");
				if(!ContratosDigitalesBE.strRbtEnvioAutomatico.equals(valor))
					valoresDiferentes=valoresDiferentes+"- Enviar_mensaje_automatico esperado: "+ContratosDigitalesBE.strRbtEnvioAutomatico+strObtenido+valor+"\n";
			} 
		
		if(ContratosDigitalesBE.strTxtNumMaxDiasCobro!=Mdl_Variables.Gstr_Ignore){//NUMERO MAXIMO DIAS COBRO
			String strValor=ContratosDigitalesBE.strTxtNumMaxDiasCobro+" día(s)";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[29]");
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_MAXIMO_DIAS_COBRO esperado: "+strValor+strObtenido+valor+"\n";
			}
		
		if(ContratosDigitalesBE.strComisionSoles!=Mdl_Variables.Gstr_Ignore){//COMISION PROVEEDORES SOLES
			String strValor=ContratosDigitalesBE.strComisionSoles+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[37]");
				if(!strValor.equals(valor)){
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_SOLES_EMPRESA esperado: "+strValor+strObtenido+valor+"\n";
				}
				
				strValor=(100-Integer.parseInt(ContratosDigitalesBE.strComisionSoles))+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[35]");
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_SOLES_PROVEEDOR esperado: "+strValor+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.strTxtComisionDolares!=Mdl_Variables.Gstr_Ignore){//COMISION PROVEEDORES DOLARES
			String strValor=ContratosDigitalesBE.strTxtComisionDolares+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[41]");
				if(!strValor.equals(valor)){
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_DOLARES_EMPRESA esperado: "+strValor+strObtenido+valor+"\n";
				}
				
				strValor=(100-Integer.parseInt(ContratosDigitalesBE.strTxtComisionDolares))+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[39]");
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_DOLARES_PROVEEDOR esperado: "+strValor+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO!=Mdl_Variables.Gstr_Ignore){//Cuenta de Cargo (US$):
			if(strBtnPagos.equals("Remuneraciones y CTS")){//ACTUALIZAR XPATH DE SOLES
				if(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoSolesResultadoFinalCTS);
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoDolaresesResultadoFinalCTS);
				}
			}else{
				if(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoSolesResultadoFinal);
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoDolaresResultadoFinal);
				}
			}
				if(!objObjetosGenerales.nuevoCuenta(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO).equals(objObjetosGenerales.nuevoCuenta(valor)))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+ContratosDigitalesBE.GstrCMB_CUENTA_CARGO+strObtenido+valor+"\n";
		} 
		//ACTUALIZAR XPATH
		if(ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA!=Mdl_Variables.Gstr_Ignore){//Cuenta de Cargo (US$):
			if(strBtnPagos.equals("Remuneraciones y CTS")){
				if(ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoSolesResultadoFinalCTS);
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoDolaresesResultadoFinalCTS);
				}
			}else{
				if(ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA.contains("Soles")){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoSolesResultadoFinal);
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCuentaCargoDolaresResultadoFinal );
				}
			}
				if(!objObjetosGenerales.nuevoCuenta(ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA).equals(objObjetosGenerales.nuevoCuenta(valor)))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_OTRA_MONEDA esperado: "+ContratosDigitalesBE.GstrCMB_CUENTA_OTRA_MONEDA+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.GstrTXT_CORREO_CONTACTO!=Mdl_Variables.Gstr_Ignore){//Correo Electrónico:
			if(strBtnPagos.equals("Remuneraciones y CTS")){
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[41]");
			}else{
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strCorreoContactoResultadoFinal);
			}
			if(!ContratosDigitalesBE.GstrTXT_CORREO_CONTACTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CORREO_CONTACTO esperado: "+ContratosDigitalesBE.GstrTXT_CORREO_CONTACTO+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.GstrTXT_TELEFONO_CONTACTO!=Mdl_Variables.Gstr_Ignore){//Teléfono:
			if(strBtnPagos.equals("Remuneraciones y CTS")){
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[43]");
			}else{
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, strTelefonoContactoResultadoFinal);
			}
			if(!ContratosDigitalesBE.GstrTXT_TELEFONO_CONTACTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_CONTACTO esperado: "+ContratosDigitalesBE.GstrTXT_TELEFONO_CONTACTO+strObtenido+valor+"\n";
		}
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}
	
	public String verificarPopUpSolicitud(){
		 String valor;
	    String valoresDiferentes="";
	    
	    if(ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA!=Mdl_Variables.Gstr_Ignore){//Empresa
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[2]/span[2]");
				if(!ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_EMPRESA esperado: "+ContratosDigitalesBE.GstrCMB_NOMBRE_EMPRESA+strObtenido+valor+"\n";
			} 
		
			if(ContratosDigitalesBE.strBtnPagos!=Mdl_Variables.Gstr_Ignore){//Producto
				String strValor;
				switch (ContratosDigitalesBE.strBtnPagos){
				case "Remuneraciones y CTS": 
					strValor="Pago de Remuneraciones/CTS";
		    		break;
				case "Proveedores": 
					strValor="Pago a Proveedores";
		    		break;
				default:
					strValor="Pagos Varios";
		    		break;
 			}
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[3]/span[2]");
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_PRODUCTO esperado: "+strValor+strObtenido+valor+"\n";
			}
			String strNewValor= Mdl_Variables.Gstr_Ignore;
			int intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_LOTE;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
			
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa 
				if(intNewNumero==1){
					valor=objObjetosGenerales.strNuevaMoneda(objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[2]/span[2]"));
		  		}else{
		  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[2]/span[2]");
				}
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_LOTE_SOLES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			
			strNewValor= Mdl_Variables.Gstr_Ignore; 
			intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_LOTE;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
			
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa    
				if(intNewNumero==1){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[3]/span[2]");
		  		}else{
		  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[3]/span[2]");
				}
				
				if(intNewNumero==1){
	  				valor=objObjetosGenerales.strNuevaMoneda(valor);
	  	  		}
				
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_LOTE_DOLARES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			
			strNewValor= Mdl_Variables.Gstr_Ignore; 
			intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_SOLES_POR_PAGO;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
	
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa        
				if(intNewNumero==1){
					valor=objObjetosGenerales.strNuevaMoneda(objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[4]/span[2]"));
		  		}else{
		  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[4]/span[2]");
				}
				
				if(intNewNumero==1){
	  				valor=objObjetosGenerales.strNuevaMoneda(valor);
	  	  		}
				
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_PAGOS_SOLES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			
			strNewValor= Mdl_Variables.Gstr_Ignore; 
			intNewNumero=0;
			
			if(ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO!=Mdl_Variables.Gstr_Ignore){
				strNewValor=ContratosDigitalesBE.GstrTXT_MONTO_MAXIMO_DOLARES_POR_PAGO;
				intNewNumero=1;
			}else{
				strNewValor=strSinLimites;
			}
			
			if(strNewValor!=Mdl_Variables.Gstr_Ignore){//Empresa         
				if(intNewNumero==1){
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[5]/span[2]");
		  		}else{
		  			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[5]/span[2]");
		  		}

				if(intNewNumero==1){
	  				valor=objObjetosGenerales.strNuevaMoneda(valor);
	  	  		}
				
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_MONTO_MAXIMO_PAGOS_DOLARES esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			 
		if(ContratosDigitalesBE.strRbtConsolidarFactura!=Mdl_Variables.Gstr_Ignore){//Consolidar documentos de pago de un mismo 
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[6]/div[1]/span[3]");
				if(!ContratosDigitalesBE.strRbtConsolidarFactura.equals(valor))
					valoresDiferentes=valoresDiferentes+"- Consolidar_documento_pago esperado: "+ContratosDigitalesBE.strRbtConsolidarFactura+strObtenido+valor+"\n";
			} 
		
		if(ContratosDigitalesBE.strRbtEnvioAutomatico!=Mdl_Variables.Gstr_Ignore){//Enviar mensaje automático al beneficiario
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[6]/div[2]/span[2]");
				if(!ContratosDigitalesBE.strRbtEnvioAutomatico.equals(valor))
					valoresDiferentes=valoresDiferentes+"- Enviar_mensaje_automatico esperado: "+ContratosDigitalesBE.strRbtEnvioAutomatico+strObtenido+valor+"\n";
			} 
		
		if(ContratosDigitalesBE.strTxtNumMaxDiasCobro!=Mdl_Variables.Gstr_Ignore){//PLAZO DE COBRO DE ÓRDENES DE PAGO/CHEQUES
			String strValor=ContratosDigitalesBE.strTxtNumMaxDiasCobro+" día(s)";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[7]/div[1]/span[2]");
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_MAXIMO_DIAS_COBRO esperado: "+strValor+strObtenido+valor+"\n";
			}
		
		if(ContratosDigitalesBE.strComisionSoles!=Mdl_Variables.Gstr_Ignore){//COMISION EMPRESA SOLES
			String strValor=ContratosDigitalesBE.strComisionSoles+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[7]/div[3]/span[2]");
				if(!strValor.equals(valor)){
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_SOLES_EMPRESA esperado: "+strValor+strObtenido+valor+"\n";
				}
				
				strValor=(100-Integer.parseInt(ContratosDigitalesBE.strComisionSoles))+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[7]/div[4]/span[2]");
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_SOLES_PROVEEDOR esperado: "+strValor+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.strTxtComisionDolares!=Mdl_Variables.Gstr_Ignore){//COMISION EMPRESA DOLARES
			String strValor=ContratosDigitalesBE.strTxtComisionDolares+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[7]/div[5]/span[2]");
				if(!strValor.equals(valor)){
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_DOLARES_EMPRESA esperado: "+strValor+strObtenido+valor+"\n";
				}
				
				strValor=(100-Integer.parseInt(ContratosDigitalesBE.strTxtComisionDolares))+" %";
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[7]/div[6]/span[2]");
				if(!strValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- TXT_COMISION_DOLARES_PROVEEDOR esperado: "+strValor+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO!=Mdl_Variables.Gstr_Ignore){//Cuenta de Cargo (US$):
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[10]/div/div/span");
			if(!objObjetosGenerales.nuevoCuenta(ContratosDigitalesBE.GstrCMB_CUENTA_CARGO).equals(objObjetosGenerales.nuevoCuenta(valor)))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+ContratosDigitalesBE.GstrCMB_CUENTA_CARGO+strObtenido+valor+"\n";
		} 
		
		if(ContratosDigitalesBE.GstrTXT_CORREO_CONTACTO!=Mdl_Variables.Gstr_Ignore){//Correo Electrónico:
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[13]/div/span");
			if(!ContratosDigitalesBE.GstrTXT_CORREO_CONTACTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CORREO_CONTACTO esperado: "+ContratosDigitalesBE.GstrTXT_CORREO_CONTACTO+strObtenido+valor+"\n";
		}
		
		if(ContratosDigitalesBE.GstrTXT_TELEFONO_CONTACTO!=Mdl_Variables.Gstr_Ignore){//Teléfono:
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div/div[4]/div[14]/span[2]");
			if(!ContratosDigitalesBE.GstrTXT_TELEFONO_CONTACTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_CONTACTO esperado: "+ContratosDigitalesBE.GstrTXT_TELEFONO_CONTACTO+strObtenido+valor+"\n";
		}
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}
	public boolean verUsuarios2(String strBtnPagos)  	{ 		
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlLnkVerUsuarios2CTS;
		}else{
			strNewValor=urlLnkVerUsuarios2;
		}		
	    return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
    }	
	public boolean CerrarUsuarios2(String strBtnPagos)  	{ 
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnCerrarUsuarios2CTS;
		}else{
			strNewValor=urlBtnCerrarUsuarios2;
		}		
	    return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
    }
	public boolean verUsuariosNew()  	{ 
	    return objObjetosGenerales.clickBoton(ObjetosGenerales.linkText, urlLnkVerUsuariosNew);
    }
	
	/*=================================================PESTAÑA DE PENDIENTES=============================================================*/

	public void verificarPestania()   {
		objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/div/li[1]/a");
	}
	
	public void verificarUsuariosPopUp()   {
		objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div[1]/div");
	}
	
	public boolean seleccionarSubMenu2(String strProducto) {
		boolean var=false;
		for(int i=1;i<=2;i++){ 
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/div/li["+i+"]/a")).getText();
																			
			if(strProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/div/li["+i+"]/a");
				break;
			}
		}
		return var;	
	}

	public boolean seleccionarEmpresa2(String strEmpresa)  {
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, urlCmbEmpresa2,strEmpresa);
	}

	public boolean seleccionarSolicitud(String codigoSolicitud)  {
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if(colss.get(1).getText().equals(codigoSolicitud)){
				colss.get(0).click();
				blnResultadoEsperado=true;
				break;
			}	
		}
		return blnResultadoEsperado;
	}
	
	public boolean seleccionarVerDetalle(String codigoSolicitud)  {
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if(colss.get(1).getText().equals(codigoSolicitud)){
				colss.get(1).click();
				blnResultadoEsperado=true;
				break;
			}	
		}
		return blnResultadoEsperado;
	}

	public void verificarPopUpAutorizacion()   {
		objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/table/tbody/tr/td/span");
	}
	
	public boolean verUsuariosConAcceso()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlLnkUsuariosConAcceso);
	}
	public boolean regresar()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlLnkRegresar);
	}
	
	public boolean agregarFirmaSolicitudSi()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlRbtFirmaSolicitudSi);
	}

	public boolean seleccionarSolicitudTieneFirmasNecesariasSi()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlRbtSolicitudTieneFirmasNecesariasSi);
	}

	public boolean seleccionarSolicitudTieneFirmasNecesariasNo()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlRbtSolicitudTieneFirmasNecesariasNo);
	}

	public boolean agregarFirmaSolicitudNo()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlRbtFirmaSolicitudNo);
	}

	public boolean firmarEnviar()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnFirmarEnviarSolicitud);
	}

	public boolean firmarGuardar()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnFirmarGuardarSolicitud);
	}

	public boolean enviar()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnEnviarSolicitud);
	}


	public boolean verTerminosCondiciones2()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlLnkTerminosCondiciones2);
	}
	

	public boolean cerrarTerminosCondiciones2()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnCerrar);
	}

	public boolean cerrarPopUpUsuariosAutorizar()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnCerrarPopUpNew);
	}
	
	public boolean cerrarTerminosCondicionesNew()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnCerrarNew);
	}
	
	public boolean aceptarTerminosCondiciones2(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlChkAceptoTerminosCondiciones2CTS;
		}else{
			strNewValor=urlChkAceptoTerminosCondiciones2;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public boolean ingresarClave2(String strClaveNew) {
		String  strValorBoton = "";
		   String  strClave = strClaveNew;
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

	public boolean ingresarClaveDinamica2(String strDescripcion,String strBtnPagos) throws InterruptedException  {

		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlTxtIngresarClaveDinamica2CTS;
		}else{
			strNewValor=urlTxtIngresarClaveDinamica2;
		}
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, strNewValor, strDescripcion);
	}

	public boolean confirmar2(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")){
			strNewValor=urlBtnConfirmar2CTS;
		}else{
			strNewValor=urlBtnConfirmar2;
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strNewValor);
	}

	public boolean cancelarOperacion2()  {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnCancelarOperacion2);
	}

	public String obtenerNumeroDeSolicitud(String strBtnPagos)  {
		String strNewValor="";
		if(strBtnPagos.equals("Remuneraciones y CTS")) {
			strNewValor="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div[2]/div[4]/div/span[2]";
		}else {
			strNewValor="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[2]/div[4]/div/span[2]";
		}
		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath,strNewValor );
	}

	public void verificarPantallaConfirmacionAutorizacion()   {
		objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//*[@id='pasoEmpresa']/span[3]");
	}
	
	public void verificarPopUpUsuariosConfirmacion()   {
		objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div");
	}

	public boolean verTerminosYCondiciones() {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlLnkVerTerminosCondiciones);
	}
	
}
