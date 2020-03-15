package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import proxim.be.ObjetosGenerales;
import proxim.be.TransferenciaBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	boolean bandera=false;
	String strTransfernciaBCR="A otros Bancos BCR";
	String strTransfernciaCCE="A otros Bancos CCE";
	String strTransfernciaTerceros="A Terceros";
	String strOperacionFecha="',LBN_OPERACION_FECHA='";
	String strOperacionHora="',LBN_OPERACION_HORA='";
	String strSeccionEnvios="SeccionEnvios";
	String strSeccionAutorizar="SeccionAutorizar";
	String strMontoTotal="',LBN_MONTO_TOTAL='";
	String strIdCaso="' where ID_CASO=";
	String strNombreEmpresa="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/div/span";
	String strCuentaDestino="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[5]/div/span";
	String strTipoCambioReferencial="//div/div[2]/div/div[3]/div[1]/span[2]";
	String strTipoCambioEpecialIn="//*[@id='tipoCambioEspecialEtiqueta']/span";
	
	
	public boolean seleccionarSubMenu1(String strProducto) throws InterruptedException, IOException{	
		boolean var=false;
		String strXpathPestana="";
		
		for(int i=1;i<=5;i++){
			strXpathPestana="//div[@class='contenedorTabs']/li["+i+"]//a";
			String valor= objObjetosGenerales.getText(ObjetosGenerales.xpath, strXpathPestana);
			
			if(strProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strXpathPestana);
				break;
			}
		}
		return var;			
	}
	
	public boolean seleccionarLinkTransferencia(String strProducto) throws InterruptedException{	
		boolean var=false;
		for(int i=1;i<=4;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorLinks']/li["+i+"]//a")).getText();
			if(strProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorLinks']/li["+i+"]//a");
				Thread.sleep(4000);
				break;
			}
		}
		return var;			
	}
	
	public boolean seleccionarVerOperacionesFrecuentes(){
		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/a");
	}
	
	public boolean ingresoBotonConfirmar1() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonConfirmar");		
	}
	
	public boolean ingresoBotonCancelarOperacion() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonCancelarOperacion");		
	}
	
	public boolean verificarResultadoFinal() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/span[1]");
	}
	
	public boolean verificarConfirmacionTransferenciaCCE() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/h1");
	}
	
	public boolean verificarResultadoEsperadoTransferenciaCCE() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/span[1]");
	}
	
	
	public boolean verificarResultadoFinalBCR() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[1]/span");
	}
	public boolean guardarIdTabla() throws InterruptedException, IOException{	
		if (TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
			Mdl_Variables.GstrNumeroSolicitud =Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='transferencias separacionPanelTop']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]//span[2]")).getText();
		}else{
			if (TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
				Mdl_Variables.GstrNumeroSolicitud =Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='transferencias separacionPanelTop']/div[6]/div[1]/div[2]/div[1]//span[2]")).getText();
			}else{
				Mdl_Variables.GstrNumeroSolicitud =Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='transferencias']/div[2]/div[2]/div[2]/div[1]//span[2]")).getText();
			}
		}
		boolean	valor= objConexionSqlServer.modificarNumeroSolicitud(Mdl_Variables.GstrNumeroSolicitud);
		TransferenciaBE.GstrNUMERO_SOLICITUD=Mdl_Variables.GstrNumeroSolicitud;
	return valor;
	}
	
	public boolean verificarPestaniaTransferencias() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[1]/li[1]/a");
	}

	public boolean verificarResultadoEsperadoTerceros() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/span[1]");
	}
	
	public boolean verificarVentanaEntreCuentas() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[1]/li[1]/a");
	}
	
	public boolean verificarPopUp() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]");
	}
	
	public boolean verificarPopUpConfirmacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div");
	}
	
	public boolean verificarResultadoEsperado() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[1]");
	}

	public boolean verificarVentanaConfirmacion() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div/div/div[1]/span[1]");
	}
	
	public boolean verificarTransferenciasBCR() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/h1");
	}
	
	public boolean seleccionarEmpresaCuentaOrigen(String strProducto) throws InterruptedException, IOException{	
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			return objObjetosGenerales.selectByText(ObjetosGenerales.cssSelector, "select.gwt-ListBox",strProducto);
		}else{
			return objObjetosGenerales.selectByText(ObjetosGenerales.name, "empresaOrigenCombo",strProducto);
		}
	}
	
	public boolean seleccionarCuentaOrigen(String strProducto) throws InterruptedException, IOException{		
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[4]/div/div/div/div[2]/select",strProducto);
		}else{
			return objObjetosGenerales.selectByText(ObjetosGenerales.name, "productoOrigenCombo",strProducto);
		}
	}
	
	public boolean seleccionarEmpresaCuentaDestino(String strProducto) throws InterruptedException, IOException{
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "empresaDestinoCombo",strProducto);
	}
	
	public boolean seleccionarCuentaDestino(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "productoDestinoCombo",strProducto);
	}
	
	public boolean ingresarMonto(String strDescripcion) throws InterruptedException, IOException{	
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.inputMonto", strDescripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.tamanioTextoMonto", strDescripcion);
		}
	}
	
	public boolean ingresarNombre(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.inputNombreEmpresa", strDescripcion);
	}
	
	public boolean ingresarNumeroDocumento(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.numeroDocumentoIdentidadAfiliacion", strDescripcion);
	}
	
	public boolean seleccionarMoneda(String strProducto) throws InterruptedException, IOException{		
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			return objObjetosGenerales.selectByText(ObjetosGenerales.cssSelector, "div.tipoNumeroDocumentoIdentidad > select.gwt-ListBox",strProducto);
		}else{
			return objObjetosGenerales.selectByText(ObjetosGenerales.name, "monedaCombo",strProducto);
		}
	}
	
	public boolean buscarComa(String valor){
		boolean blnResultado=false;
		
		if(valor.contains(",")){
			blnResultado= true;
		}
		
		return blnResultado;
	}
	
	public boolean seleccionarTipoDocumento(String strProducto) throws InterruptedException, IOException{		
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoDoiCombo",strProducto);
		}else{
			return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoDocIdentidadCombo",strProducto);
		}
	}
	
	public boolean seleccionarTipoCambioEspecial() {	
		String texto=null;
		
		switch (TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA) {
			case "Entre Cuentas": 
				texto="//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/span/span";
				break;
			case "A Terceros": 
				texto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[7]/div/div/div[2]/div/span/span/input";
				break;
			case "A otros Bancos CCE": 
				texto="//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/span/span/input";
				break;
			default:
				texto="//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/span/span/input";
			    break; 
		 }	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,texto );
	}
	
	public boolean ingresarTipoCambioEspecial(String strTipoCambio) throws InterruptedException, IOException{	

		boolean var=false;
		
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals("Entre Cuentas")){
																		  
			var = objObjetosGenerales.setTextNew(ObjetosGenerales.xpath, "//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/span/div/input", strTipoCambio);
		}else if ( TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)|| TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaTerceros)){
			var = objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div/div[2]/div/span/div/input", strTipoCambio);
		}	 
		return var;
	}
	
	public boolean seleccionarEmpresaPropietariaCuenta(){		
		String texto=null;
	
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)) {
			texto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[5]/div/div/div[2]/div/div/strong/span/input"; 
		}else if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){ 
			texto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/div/div/div[2]/div/strong/span/input";
		}
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, texto);
	}
	
	public boolean ingresarFechaProgramaOperacion(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.fechaFin", strDescripcion);
	}
	
	public boolean ingresarDescripcion(String strDescripcion) throws InterruptedException, IOException{	
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "div.componenteInternoPaso > input.inputCuentaDestino", strDescripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.anchoCajaTexto", strDescripcion);
		}
	}
	
   public boolean compararResultadoEsperado(String strTxtMensajeError) {	
	   String strMensaje;
	   boolean blnResultado=false;
	   if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
		   strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[1]/span[1]")).getText();
	   }else{
		   if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			   strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='transferencias separacionPanelTop']/div[6]/div[1]/div[1]//span")).getText(); 			   							
		   }else{
			   strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[2]/div[2]/div[1]/span[1]")).getText(); 
		   }
	   }   
	     
	   if(strMensaje.equals(strTxtMensajeError)){
		   blnResultado= true;
	   }	
	   
	   return blnResultado;
   }
   
   public String obtenerResultado(){	
	   String strMensaje;
	   
	   if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
		   strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[1]/span[1]")).getText();
	   }else{
		   if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			   strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='transferencias separacionPanelTop']/div[6]/div[1]/div[1]//span")).getText(); 			   							
		   }else{
			   strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[2]/div[2]/div[1]/span[1]")).getText(); 
		   }
	   }   
	   
	   return strMensaje;
   }
   
	public boolean ingresoBotonContinuar() {
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonContinuar");	
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.name, "continuar");	
		}
	}
	
	public boolean ingresoBotonSiPopUp() {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//img[@title='Si']");	
	}
	
	public boolean ingresoBotonNoPopUp(){
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//img[@title='No']");	
	}
	
	public String compararMensajeError(String strTxtMensajeError,String strTxtColumnaError ) {	
		String strMensaje="";
		String strNuevoResultado="";
		switch (strTxtColumnaError) {
		
		case "CMB_EMPRESA_CUENTA_ORIGEN" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div/div/span")).getText();
			break;
		case "TXT_MONTO" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[6]/div/div/span")).getText();
			break;
		case "CMB_CUENTA_ORIGEN" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[4]/div/div/span")).getText();
			break;
		case "TXT_CUENTA_DESTINO" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strNombreEmpresa)).getText();
			break;
		case "TXT_NOMBRE_EMPRESA" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strNombreEmpresa)).getText();
			break;
		case "CMB_TIPO_DOCUMENTO_IDENTIDAD" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strNombreEmpresa)).getText();
			break;
		case "TXT_NUMERO_IDENTIDAD" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strNombreEmpresa)).getText();
			break;
		case "TXT_DESCRIPCION_TRANSFERENCIA" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[9]/div/span")).getText();
			break;
		case "TXT_PROGRAMA_OPERACION" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[8]/div/span")).getText();
			break;
			
		case "TXT_TIPO_CAMBIO_ESPECIAL_INVALIDO" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipoCambioEpecialIn)).getText();
			break;
			
		case "TXT_TIPO_CAMBIO_ESPECIAL_INCOMPLETO" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipoCambioEpecialIn)).getText();
			break;
			
		case "TXT_TIPO_CAMBIO_ESPECIAL_INEXISTENTE" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTipoCambioEpecialIn)).getText();
			break;
		default:
			break;
		}
		
		if(!strTxtMensajeError.equals(strMensaje))
		{
			strNuevoResultado= " Mensaje esperado:'"+strTxtMensajeError+"', Mensaje mostrado:'"+strMensaje+"'.";
		}	
		
		return strNuevoResultado;
	}
	public boolean compararMensajeErrorCCE(String strTxtMensajeError,String strTxtColumnaError ) {	
		String strMensaje="";
		boolean blnResultado=false;
		switch (strTxtColumnaError) {

		case "CMB_EMPRESA_CUENTA_ORIGEN" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[3]/div/div/span")).getText();
			break;
		case "CMB_CUENTA_ORIGEN" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[4]/div/div/span")).getText();
			break;
		case "TXT_CUENTA_DESTINO" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strCuentaDestino)).getText();
			break;
		case "TXT_NOMBRE_EMPRESA" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strCuentaDestino)).getText();
			break;
		case "CMB_TIPO_DOCUMENTO_IDENTIDAD" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strCuentaDestino)).getText();
			break;
		case "TXT_NUMERO_IDENTIDAD" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strCuentaDestino)).getText();
			break;
		case "TXT_MONTO" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[6]/div/div/span")).getText();
			break;
		case "CMB_MONEDA" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[6]/div/div/span")).getText();
			break;
		case "TXT_DESCRIPCION_TRANSFERENCIA" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[8]/div/span")).getText();
			break;
		case "CHK_TIPO_CAMBIO_ESPECIAL" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[7]/div/span")).getText();
			break;

		default:
			break;
		}
		
		if(strTxtMensajeError.equals(strMensaje)){
			 blnResultado= true;
		}	
		return blnResultado;
	}
	
	public boolean compararMensajeError1(String strTxtMensajeError,String strTxtColumnaError ) {	
		String strMensaje="";
		boolean blnResultado=false;
		switch (strTxtColumnaError) {
		case "TXT_CLAVE" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/span")).getText();
			break;
		case "TXT_CLAVE_DINAMICA" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/span[2]")).getText();
			break;	

		default:
			break;
		}
		
		if(strTxtMensajeError.equals(strMensaje)){
			blnResultado= true;
		}
		return blnResultado;
	}
	
	public boolean botonSiCopia() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/a/img");	
	}
	
	public boolean compararMensajeRepetido() {	
		boolean blnResultado=false;
		String strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/span[1]")).getText();
		if(strMensaje.equals("Esta operación presenta el nombre de Beneficiario, Ordenante, Número de Operación y Monto de una transferencia enviada anteriormente.")){
			blnResultado= true;
		}
		return blnResultado;
	}
	
	public boolean compararMensajeErrorCCE1(String strTxtMensajeError,String strTxtColumnaError ) {	
		String strMensaje="";
		boolean blnResultado=false;
		switch (strTxtColumnaError) {
		case "TXT_CLAVE" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/span")).getText();
			break;
		case "TXT_CLAVE_DINAMICA" :
			strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[4]/div[1]/span[2]")).getText();
			break;	

		default:
			break;
		}
		
		if(strTxtMensajeError.equals(strMensaje)){
			blnResultado =true;
		}	
		
		return blnResultado;
	}
	
	public boolean ingresoBotonAceptar() {
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonAceptarPagoRecibo");	
	}
	
	public boolean ingresoAgregarOperacionesFrecuentes(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[5]/a");
	}
	
	public boolean ingresarDescripcionOperacionFrecuente(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.inputCuentaDestino", strDescripcion);
	}
	
	public boolean ingresoBotonContinuarOperacionFrecuente(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div[2]/a");
	}
	
	public boolean seleccionarTipoCuenta(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoCuentaDestinoCombo",strProducto);
	}
	
	public boolean ingresarNumeroCuenta(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.inputCuentaDestino", strDescripcion);
	}																	        
	
	public boolean ingresoBotonCorreo() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img.navbarimg");		
	}
	
	public boolean ingresoCorreos(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.mailTransferencias", strDescripcion);
	}
	
	public boolean ingresarMensaje(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "textarea.mensajeMailTransferencias", strDescripcion);
	}
	
	public boolean ingresarClaveDinamica(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.cssSelector, "input.textoAlineadoTR", strDescripcion);
	}
	
	//07/03/2017(sconcha)update para modificar el campo CMB_EMPRESA_CUENTA_DESTINO
	public boolean insertNombreEmpresa() throws SQLException{
		String strCadenaNombreEmpresa;
		bandera=true;
		try {
			strCadenaNombreEmpresa = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[2]/span[2]");
			Map<String,String> map= new HashMap<String, String>();
			map=objFuncionesGenerales.obtenerDatosEmpresa(strCadenaNombreEmpresa);		
			String strNombreEmpresaA= map.get("strNombreEmpresa");
			Mdl_Variables.Gstr_EmpresaDestino=strNombreEmpresaA;
			bandera= objConexionSqlServer.updateTablaQuery("update APP_AND_TRANSFERENCIAS_A_TERCEROS_D set CMB_EMPRESA_CUENTA_DESTINO='"+strNombreEmpresaA+"'  where ID_CASO="+TransferenciaBE.Gstr_ID_CASO);
		} catch (IOException e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean verificarTablaTransferencias() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[1]/div/div/div[5]/div/div/table");
	}
	
	public boolean verificarImagenOpeEnviada () throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]/img");
	}
	
	public boolean verificarImagenTransfEnviada () throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/img");
	}
	
	public boolean verificarTecladoEntreCuentas() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/button[1]");
	}
	
	public boolean verificarTecladoEntreCuentas1() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]");
	}
	
	public String obtenerTextoSeccion(String seccion) throws InterruptedException, IOException{
		String strMensaje = "";
		switch (seccion){
			case "ECTAS_TipCamRef_TipoCambio":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, strTipoCambioReferencial);
				break;
			case "ECTAS_TipCamRef_MontoConvertido":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/div[2]/div/div[3]/div[2]/span[2]");
			break;
			case "ECTAS_TipCamEsp_TipoCambio":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/div/div[1]/span[2]");
				break;
			case "ECTAS_TipCamEsp_MontoConvertido":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/div/div[2]/span[2]");
				break;
			//------Confirmar-----
			case "ECTAS_Confirmar_MontoTotalTransferir":
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/span[2]");
				}else{
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[3]/span[2]");
				}
				break;
			case "ECTAS_Confirmar_ComisionPorTransfer":
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[6]/span[2]");
				}else{
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[4]/span[2]");
				}
				break;
			case "ECTAS_Confirmar_TipoCambio":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[5]/span[2]");
				break;
			case "ECTAS_Confirmar_MontoConvertTransferir":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[6]/span[2]");
				break;
			case "ECTAS_Confirmar_MontoTotalPagar":
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[8]/span[2]");
				}else{
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[7]/span[2]");
				}
				break;
			//------Enviado-----
			case "ECTAS_Enviado_MontoTotalTransferir":
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]/span[2]");
				}else{
					if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR))
					{
						strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[2]/div[6]/span[2]");
					}else{
						strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/span[2]");
					}
				}
				break;
			case "ECTAS_Enviado_Comision": //CCE
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[2]/div[7]/span[2]");
				}else{
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[5]/span[2]");
				}
				break;
			case "ECTAS_Enviado_TipoCambio":
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[6]/span[2]");
				}else{
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[6]/span[2]");
				}
				break;
			case "ECTAS_Enviado_MontoConvertTransferir":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[7]/span[2]");
				break;
			case "ECTAS_Enviado_MontoTotalPagar": //CCE
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[2]/div[9]/span[2]");
				}else{
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[8]/span[2]");
				}
				break;
			//------Operaciones Frecuentes-----	
			case "ECTAS_OpeFrecuente_Monto":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/span[2]");
				break;
			case "ECTAS_OpeFrecuente_MontoRealizado":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div[3]/div[2]/div[3]/div[4]/span[2]");
				break;
			default:
			    break; 
		}
		return strMensaje;
	}
	
	public String obtenerMontoSeccion(String seccion) throws InterruptedException, IOException{
		String strMensaje = "";
		if (seccion.equals("ECTAS_TipCamRef_TipoCambio")){
			strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div/div[2]/div/div[3]/div[1]/span[3]");
		}else if (seccion.equals("ECTAS_TipCamEsp_TipoCambio")){
			strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='tipoCambioEspecialEtiqueta']/div/div[2]/div/div/div[1]/span[3]");
		}
		return strMensaje;
	}
	
	public boolean ingresoEnviarCorreo(String strSeccion) {		
		boolean bResp = false;
		if (strSeccion.equals(strSeccionEnvios)){
			if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[6]/div/div[1]/a");
			}else{
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[6]/div/div[1]/a");
				}else{
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[1]/a");
				}
			}
		}else if ( strSeccion.equals(strSeccionAutorizar)){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[1]/a");
		}
		return bResp;
				
	}
	
	public boolean ingresarTituloCorreo(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarMensajeCorreo(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", strDescripcion);
	}
	
	public boolean ingresoBotonEnviarCorreo() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");		
	}
	
	public boolean ingresoBotonEnviarCorreo2(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");		
	} 
	
	public boolean ingresoExportarExcel(String strSeccion) {		
		boolean bResp = false;
		if (strSeccion.equals(strSeccionEnvios)){
			if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[6]/div/div[4]/a");
				}else{
					if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
						bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[6]/div/div[4]/a");
					}else{
						bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[4]/a");
					}
				}
		}else if( strSeccion.equals(strSeccionAutorizar)){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[4]/a");
		}
		return bResp;
	}
	
	public boolean ingresoExportarPdf(String strSeccion) {		
		boolean bResp = false;
		if (strSeccion.equals(strSeccionEnvios)){
			if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[6]/div/div[5]/a");
			}else{
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[6]/div/div[5]/a");
				}else{
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[5]/a");
				}
			}
		}else if(strSeccion.equals( strSeccionAutorizar)){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[5]/a");
		}
		return bResp; 		
	}
	public boolean ingresoImprimir(String strSeccion){		
		boolean bResp = false;
		if (strSeccion.equals(strSeccionEnvios)){
			if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)){
				bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[6]/div/div[6]/a");
			}else{
				if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[6]/div/div[6]/a");
				}else{
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[6]/div/div[6]/a");
				}
			}
		}else if(strSeccion.equals(strSeccionAutorizar)){
			bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[6]/a");
		}
		return bResp; 		
	}
	public boolean visibleTipoCambioReferencial() throws InterruptedException, IOException{		
		boolean bResp = false;
		bResp = objObjetosGenerales.existElement(ObjetosGenerales.xpath,strTipoCambioReferencial);
		if(bResp){
			if(objObjetosGenerales.visibleElement(ObjetosGenerales.xpath,strTipoCambioReferencial)){
				bResp = true;
			}else {
				bResp = false;
			}
		}
		return bResp; 		
	}
	
	public boolean hayCambioMoneda(String strOrigen, String strTransaccion){
		boolean bResp = false;
		int indOrigen = 0;
		int indTransac = 0;
		if (objFuncionesGenerales.buscarCadena("S/", strOrigen) || objFuncionesGenerales.buscarCadena("SOLES", strOrigen.toUpperCase())){
			indOrigen = 1;
		}
		if (objFuncionesGenerales.buscarCadena("S/", strTransaccion) || objFuncionesGenerales.buscarCadena("SOLES", strTransaccion.toUpperCase())){
			indTransac = 1;
		}
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			indTransac = indOrigen;
		}
		if(indOrigen + indTransac == 1){
			bResp = true;
		}
		return bResp;
	}

	public boolean guardarDatosOperacionAutorizar()  throws InterruptedException, IOException, SQLException{
		if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaBCR)){
			TransferenciaBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[1]/p/span[1]" );		
			TransferenciaBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[1]/p/span[2]" );
			TransferenciaBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[1]/p/span[3]" );
			TransferenciaBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[2]/div[6]/span[2]" );			
		}else if(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA.equals(strTransfernciaCCE)) {
			TransferenciaBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/span[2]" );																										  
			TransferenciaBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/span[3]" );
			TransferenciaBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]/span[5]" );
			TransferenciaBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]/span[2]" );
		}else{
			TransferenciaBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/span[2]" );
			TransferenciaBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/span[3]" );
			TransferenciaBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/span[5]" );
			TransferenciaBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[4]/span[2]" );
		}
		
		switch(TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA){
			case "Entre Cuentas":
				bandera= objConexionSqlServer.updateTablaQuery("update APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D set LBN_OPERACION='"+TransferenciaBE.GstrLBN_OPERACION+strOperacionFecha+TransferenciaBE.GstrLBN_OPERACION_FECHA+strOperacionHora+TransferenciaBE.GstrLBN_OPERACION_HORA+strMontoTotal+TransferenciaBE.GstrLBN_MONTO_TOTAL+strIdCaso+TransferenciaBE.Gstr_ID_CASO);break;
			case "A Terceros":
				bandera= objConexionSqlServer.updateTablaQuery("update APP_AND_TRANSFERENCIAS_A_TERCEROS_D set LBN_OPERACION='"+TransferenciaBE.GstrLBN_OPERACION+strOperacionFecha+TransferenciaBE.GstrLBN_OPERACION_FECHA+strOperacionHora+TransferenciaBE.GstrLBN_OPERACION_HORA+strMontoTotal+TransferenciaBE.GstrLBN_MONTO_TOTAL+strIdCaso+TransferenciaBE.Gstr_ID_CASO);break;
			case "A otros Bancos CCE":
				bandera= objConexionSqlServer.updateTablaQuery("update APP_AND_TRANSFERENCIAS_OTROS_BANCOS_CCE_D set LBN_OPERACION='"+TransferenciaBE.GstrLBN_OPERACION+strOperacionFecha+TransferenciaBE.GstrLBN_OPERACION_FECHA+strOperacionHora+TransferenciaBE.GstrLBN_OPERACION_HORA+strMontoTotal+TransferenciaBE.GstrLBN_MONTO_TOTAL+strIdCaso+TransferenciaBE.Gstr_ID_CASO);break;
			case "A otros Bancos BCR":
				bandera= objConexionSqlServer.updateTablaQuery("update APP_AND_TRANSFERENCIAS_OTROS_BANCOS_BCR_D set LBN_OPERACION='"+TransferenciaBE.GstrLBN_OPERACION+strOperacionFecha+TransferenciaBE.GstrLBN_OPERACION_FECHA+strOperacionHora+TransferenciaBE.GstrLBN_OPERACION_HORA+strMontoTotal+TransferenciaBE.GstrLBN_MONTO_TOTAL+strIdCaso+TransferenciaBE.Gstr_ID_CASO);break;
			default:
			    break; 
		}

		return bandera;
	}
	
	//-------Transfrecnias a trceros
	
	public boolean verificarConfirmacionTerceros() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//*[@id='cuentaOrigen']/div/div[1]/span[1]");
	}
}
