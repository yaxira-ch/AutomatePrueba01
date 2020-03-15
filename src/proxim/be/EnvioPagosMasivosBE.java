package proxim.be;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.bl.CapturarPantalla;
import proxim.bl.FuncionesGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;


public class EnvioPagosMasivosBE {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();

	boolean strResultadoEsperado=false;
	String strEnvioCorreo="/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[1]/a";
	String strExportarExcel="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[4]/a";
	String strExportarPdf="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[5]/a";
	String strExportarImprimir="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[6]/a";
	String strTabla="//table[@class='cellTableWidget']";
	String strLoteObservacionesCabecera = "Lote con observaciones cabecera" ;
	String strLoteObservaciones = "Lote con observaciones" ;
	String strLoteCorrecto = "Lote correcto" ;
	String strSoles = "Soles" ;
	String strTr = ".//tr" ;
	String strNewTr = ".//tr[" ;
	
	public boolean verificarTutoriales() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[1]/div[2]/div[1]/div[2]/a");
	}

	public boolean verificarPagosMasivos()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]");
	}
	
	public boolean verificarTablaCorrecto()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[1]/div/div[5]/div/div/table");
	}
	
	public boolean verificarTablaTransferencia()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/select");
	}
	
	public boolean verificarNumeroSolicitud()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//div[4]/div[1]/div[4]/span[2]");
	}	
	
	public boolean verificarDetallePagosRecibos()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/span");
	}
	
	public boolean verificarDetalleProducto()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/span");
	}
	
	public boolean verificarEnvioPagos()throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/h1");
	}
	
	public boolean verificarPagosAutorizar()throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean verificarTablaAutorizar()throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div/div[5]/div/div/table");
	}
	
	public boolean verificarConfirmarOperacion()throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[1]/span[3]");
	}
		
	public boolean seleccionarEmpresa(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean seleccionarProducto(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "productoCombo",strProducto);
	}
	
	public boolean seleccionarEmpresaBloqueado(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean verificarPagosProcesos()throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean seleccionarEmpresaPagosProcesados(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean seleccionarServicio(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "servicioCombo",strProducto);
	}
	
	public boolean seleccionarCanalEnvio(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[2]/select",strProducto);
	}
	
	public boolean ingresarFechaInicio(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.classname, "fechaInicio", strDescripcion);
	}
	
	public boolean ingresarFechaFin(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.classname, "fechaFin", strDescripcion);
	}
	
	public boolean comboVerificar() throws InterruptedException, IOException { 
		boolean blnComboCanal=false;
		boolean blnNombreCanal=false;
		boolean blnResultadoFinal=false;
		blnComboCanal=objObjetosGenerales.visibleElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[2]/select");
		String lbnCanal=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='pasoCanal']/span[3]");
		if(lbnCanal.equals("Canal de Envío")){
			blnNombreCanal=true;
		}
		if(blnComboCanal&&blnNombreCanal){
			blnResultadoFinal=true;
		}
		return blnResultadoFinal;
	}
	
	public boolean ingresoBotonEnviar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Enviar\"]");		
	}
	
	public boolean ingresoBotonBuscar() {		
		if(PagosMasivosBE.GstrTXT_SUBMENU1.equals("Pagos por Autorizar")){
			return objObjetosGenerales.clickBoton(ObjetosGenerales.name, "botonBuscar");
		}else{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonBusqueda");
		}
	}
	
	public boolean ingresoBotonBuscarBloqueados() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");
	}
	
	public boolean verificarResultadoTablaBloqueo()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[5]/div/div/table");
	}
	public boolean verificarResultadoTablaProcesadoDetalle()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[5]/div/div[5]");
	}
	
	public boolean ingresoBotonBuscar1() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");
	}
	
	public boolean buscarNumeroInterno() throws InterruptedException, IOException{
		String strCadena="Canal";
		String strTexto=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[5]/div/div/table/thead/tr/th[12]");
		return objFuncionesGenerales.buscarCadena(strCadena, strTexto);
	}
	
	public boolean ingresoBotonAutorizar() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Autorizar\"]");		
	}
	
	public boolean ingresoBotonBloquear() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Bloquear\"]");		
	}
	  
	public boolean ingresarClaveDinamica(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.classname, "textoAlineado", strDescripcion);
	}
	   
	public boolean ingresoBotonConfirmar() {	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Confirmar\"]");
	}
	
	public boolean ingresoBotonConfirmarAfil() {	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[6]/a[1]");
	}
	
	public boolean ingresoBotonConfirmar1() {		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonConfirmar");		
	}

	public boolean verificarResultadoConfirmacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[2]/div/div/div[5]");
	}																	  
	
	public boolean verificarResultadoEsperadoFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div/div[3]/div[2]/div/div[5]");
	}
	
	public boolean ingresoBotonCancelarOperacion(){		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonCancelarOperacion");		
	}
	
	public boolean compararResultadoEsperado(String resultado) {
		boolean blnResultado=false;
		String strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[5]/div/div[2]/span")).getText(); 
	     
		if(resultado.equals(strMensaje)){
			blnResultado= true;
		}
		return blnResultado;		
	}
	
	public boolean verificarmensajeFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//div[1]/div[2]/div/div[5]/div/div[2]/span");
	}
	
	public boolean compararMensajeResultante(String strTxtMensajeError) {	
		boolean blnResultado=false;
		String strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='separacionPanelTop panelResultadoEnvioPagos']/div[@class='tituloConfirmacion tituloConfirmacionEnvio']")).getText();
		if(strMensaje.compareTo(strTxtMensajeError) == 0){
			blnResultado= true;
		}
			return blnResultado;
	}
	
		public boolean guardarDatosOperacion() throws InterruptedException, IOException, SQLException{	
			String strMonedaCuenta;
			PagosMasivosAdministracionAfiliadosBE.GstrLBL_FECHA_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[3]/span[4]" );
			PagosMasivosAdministracionAfiliadosBE.GstrLBL_HORA_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[3]/span[6]" );
			String strNumeroOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[3]/span[2]" );
			if(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa.equals("<IGNORE>")){
				PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_SOLES=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[7]/div" );
				PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_DOLARES=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[8]/div" );
				strMonedaCuenta=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[13]/div" );
				PagosMasivosAdministracionAfiliadosBE.GstrMONTO_SOLES_PAGAR=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[11]/div" );
				PagosMasivosAdministracionAfiliadosBE.GstrMONTO_DOLARES_PAGAR=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[12]/div" );
			}else{
				PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_SOLES=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[8]/div" );
				PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_DOLARES=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[9]/div" );
				strMonedaCuenta=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[14]/div" );
				PagosMasivosAdministracionAfiliadosBE.GstrMONTO_SOLES_PAGAR=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[12]/div" );
				PagosMasivosAdministracionAfiliadosBE.GstrMONTO_DOLARES_PAGAR=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[5]/div/div[5]/div/div/table/tbody[1]/tr/td[13]/div" );
			}
			
			Mdl_Variables.GstrTotalPagar=PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_SOLES+"-"+PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_DOLARES;
			Mdl_Variables.Garr_montosBuscar=new String[1];
			strResultadoEsperado= objConexionSqlServer.updateTablaQuery("update APP_AND_PAGO_MAS_ADMPAGOS_D set LBL_FECHA_OPERACION='"+PagosMasivosAdministracionAfiliadosBE.GstrLBL_FECHA_OPERACION+"',LBL_HORA_OPERACION='"+PagosMasivosAdministracionAfiliadosBE.GstrLBL_HORA_OPERACION+"',LBL_MONTO_DOLARES='"+PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_DOLARES+"',LBL_MONTO_SOLES='"+PagosMasivosAdministracionAfiliadosBE.GstrLBL_MONTO_SOLES+"',LBL_OPERACION='"+strNumeroOperacion+"' where ID_CASO="+PagosMasivosAdministracionAfiliadosBE.strIdCaso);
			return strResultadoEsperado;
		}
		
		public boolean compararMensajeError(String strTxtMensajeError,String strTxtColumnaError ) {	
			String strMensaje="";
			boolean lbnResultadoFinal=false;
			
			switch (strTxtColumnaError) {
				case "CMB_TIPO_PROCESO" :
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[6]/tbody/tr/td[1]/div/span[2]")).getText();
					break;
				case "BTN_SI_POP_UP":
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[4]/div/table/tbody/tr[2]/td[2]/div/div/span")).getText();
					break;
				case "CMB_SERVICIO":
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td[1]/div/span[2]")).getText();
					break;
				case "CMB_CUENTA_CARGO":
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[1]/div/span[2]")).getText();
					break;
				case "TXT_DESCRIPCION":
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[5]/tbody/tr/td[1]/div/span[2]")).getText();
					break;
				case "TXT_FECHA_DIFERIDO" :
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[6]/tbody/tr/td[1]/div/span[2]")).getText();
					break;
				case "BTN_RUTA_ARCHIVO" :
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[2]/div[7]/div[1]/span[2]")).getText();
					break;
				case "BTN_ENVIAR" :
					strMensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/span[2]")).getText();
					break;	
				default:
					break;
			}
			
			if(strTxtMensajeError.equals(strMensaje)){
				lbnResultadoFinal= true;
			}	
			return lbnResultadoFinal;
		}

		
		public boolean seleccionarLoteEnviar(int opcion) throws InterruptedException, IOException{	
			Boolean var=false;
			
			if(opcion==1){
				//seleccionar los 9 primeros valores
				String strNuevoServicio= PagosMasivosAdministracionAfiliadosBE.strCmbServicio.substring(0, 10);
				String strNuevaMoneda=null;
				String strNuevoCuentaCargo=null;
				
				String strTextoValidar= PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(0, 16);
				
				if(strTextoValidar.equals("Cuenta Corriente")){
					strNuevaMoneda=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(17, 22);
					if(strNuevaMoneda.equals(strSoles)){
						strNuevoCuentaCargo=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(23, 37);
					}else{
						strNuevaMoneda=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(17, 24);
						strNuevoCuentaCargo=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(26, 39);
					}
				}else{
					//strTextoValidar= PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(0, 17);
					strNuevaMoneda=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(19, 22);
					if(strNuevaMoneda.equals(strSoles)){
						strNuevoCuentaCargo=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(25, 38);
					}else{
						strNuevaMoneda=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(19, 25);
						strNuevoCuentaCargo=PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.substring(27, 40);
					}
				}
				
				WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
				
				for (int j = 1;j<=39;j++){
					List<WebElement> colss = (tabla.findElements(By.xpath(strNewTr+j+"]/td")));
	
					if ((colss.get(3).getText().equals(strLoteCorrecto)||colss.get(3).getText().equals(strLoteObservaciones)||colss.get(3).getText().equals(strLoteObservacionesCabecera))//ESTADO
							&&(colss.get(4).getText().equals(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)&&//producto
							colss.get(9).getText().equals(strNuevaMoneda)&&//moneda
							colss.get(10).getText().equals(strNuevoCuentaCargo)&&//cuenta_cargo
							colss.get(11).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)&&//descripcion
							colss.get(13).getText().equals(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_PROCESO)&&//tipo_proceso
							colss.get(14).getText().equals(strNuevoServicio))){//servicio
												colss.get(0).click();
												var=true;
												break;
					}
				}
			}else{
				Thread.sleep(3000);
				WebElement tabla = null;
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
				List<WebElement> num=null;
				num=tabla.findElements(By.xpath(strTr));
				
				for (int j = 1;j<=num.size()-2;j++){
					List<WebElement> colss = null;
					colss = (tabla.findElements(By.xpath(strNewTr+j+"]/td")));
					
					if( colss.get(3).getText().equals("Validando")){
						verificarTablaCorrecto();
					}else if ((colss.get(3).getText().equals(strLoteCorrecto)||colss.get(3).getText().equals(strLoteObservaciones)||colss.get(3).getText().equals(strLoteObservacionesCabecera))&& (colss.get(11).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)  || colss.get(12).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion) )){//Compara con el nombre del LOTE
						colss.get(0).click();
						var = true;
						break;
					}
				}
			}
			return var;
		}
		
		public boolean esperarTiempoCambioEstado() throws InterruptedException, IOException{
			Boolean var=false;
			int t = 10000;
			while (var == false){
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				if(t==10000){
					Thread.sleep(10000);
				}else{
					Thread.sleep(1000);
				}
				
				WebElement tabla = null;
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
				String estado = "";
				List<WebElement> colss = null;
				colss = (tabla.findElements(By.xpath(strNewTr+1+"]/td")));
				
				if( colss.get(3).getText().equals("Validando")){
					verificarTablaCorrecto();
				}
				estado = colss.get(3).getText();
				if ( (colss.get(11).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)  || 
						colss.get(12).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion) )&&
						(estado.equals(strLoteCorrecto) || 
						estado.equals(strLoteObservaciones)|| 
						estado.equals(strLoteObservacionesCabecera)||
						estado.equals("Archivo incorrecto"))){
						var = true;
						break;
				}
				t++;
			}
			return var;
		}
		
		public boolean seleccionarLoteFirmar() {	
			boolean var=false;
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			List<WebElement> num=tabla.findElements(By.xpath(strTr));
			int numero=num.size()-2;
			for (int j = 1;j<=numero;j++){
				List<WebElement> colss = (tabla.findElements(By.xpath(strNewTr+j+"]/td")));
				if (colss.get(9).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)
						|| colss.get(10).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)){//Compara con el nombre del LOTE
					colss.get(0).click();
					var = true;
					break;
				}
			}
			return var;
		}
			
		public boolean seleccionarLoteVerDetalle(String fechaBusqueda) {	
			Boolean var=false;
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			List<WebElement> num=tabla.findElements(By.xpath(strTr));
			for (int j = num.size()-2;j>=1;j--){
				List<WebElement> colss = (tabla.findElements(By.xpath(strNewTr+j+"]/td")));
				if (colss.get(4).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)
						&& colss.get(7).getText().equals(fechaBusqueda) 
						&& colss.get(6).getText().equals(PagosMasivosAdministracionAfiliadosBE.GstrMONTO_DOLARES_PAGAR)
						&&colss.get(5).getText().equals(PagosMasivosAdministracionAfiliadosBE.GstrMONTO_SOLES_PAGAR)
						&&colss.get(11).getText().equals(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO)){//Compara con el nombre del LOTE
					//CapturarPantalla.scrollMoveIzquierda("/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div[5]");
					colss.get(0).click();
					var = true;
					break;
				}
			}
			return var;
		}
		
		public int seleccionarLoteVerDetalleBloqueada(String fechaBusqueda){	
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			List<WebElement> num=tabla.findElements(By.xpath(strTr));
			int intResultado=0;
			
			for (int j = 1;j<=num.size()-2;j++){
				List<WebElement> colss = (tabla.findElements(By.xpath(strNewTr+j+"]/td")));
				if (colss.get(4).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)
						&& colss.get(7).getText().equals(fechaBusqueda) 
						//&& colss.get(6).getText().equals(PagosMasivosAdministracionAfiliadosBE.GstrMONTO_DOLARES_PAGAR)
						//&&colss.get(5).getText().equals(PagosMasivosAdministracionAfiliadosBE.GstrMONTO_SOLES_PAGAR)
						){
					intResultado = j;
					break;
					
				}
			}
			return intResultado;
		}
		
		public boolean  seleccionarVerDetalleBloqueada(int intResultadoEsperado){	
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			List<WebElement> colss = (tabla.findElements(By.xpath(strNewTr+intResultadoEsperado+"]/td")));
			colss.get(0).click();
			return true;
		}
		
		public boolean verificarPagosBloqueadosDetalle() throws InterruptedException, IOException{		
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/span");
		}
		
		public boolean verificarPopUpCorreo() throws InterruptedException, IOException{		
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		}
		
		public boolean seleccionarLoteDetalle() {	
			Boolean var=false;
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			
			for (int j = 1;j<=39;j++){
				List<WebElement> colss = (tabla.findElements(By.xpath(strNewTr+j+"]/td")));
				if(colss.get(1).getText().equals(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)//producto
					&&colss.get(4).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)//descripcion
					&&colss.get(9).getText().equals(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_PROCESO)){//tipo_proceso
					colss.get(0).click();
					var=true;
					break;
				}
			}
			return var;
		}
		
		//------- PIE DE PAGINA DE LA CABECERA
		
		public boolean ingresoEnviarCorreoCab(String strSeccion){		
			boolean bResp = false;
			switch (strSeccion){
				case "SeccionEnvios":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[1]/a");
					break;
				case "SeccionPagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[1]/a");
					break;
				case "SeccionDetallePagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[7]/div/div[1]/a");
					break;
				case "SeccionPagosProcesados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strEnvioCorreo);
					break;
				case "SeccionPagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strEnvioCorreo);
					break;
				case "SeccionDetallePagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[1]/a");
					break;
				default:
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strEnvioCorreo);
			}
			return bResp;
		}
		
		public boolean ingresoExportarExcelCab(String strSeccion) {		
			boolean bResp = false;
			switch (strSeccion){
				case "SeccionEnvios":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[4]/a");
					break;
				case "SeccionPagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[4]/a");
					break;
				case "SeccionDetallePagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[7]/div/div[4]/a");
					break;
				case "SeccionPagosProcesados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarExcel);
					break;
				case "SeccionPagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarExcel);
					break;
				case "SeccionDetallePagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[4]/a");
					break;
				default:
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarExcel);
			}
			return bResp;
		}
		public boolean ingresoExportarPdfCab(String strSeccion) {		
			boolean bResp = false;
			switch (strSeccion){
				case "SeccionEnvios":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[5]/a");
					break;
				case "SeccionPagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[5]/a");
					break;
				case "SeccionDetallePagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[7]/div/div[5]/a");
					break;
				case "SeccionPagosProcesados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarPdf);
					break;
				case "SeccionPagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarPdf);
					break;
				case "SeccionDetallePagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[5]/a");
					break;
				default:
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarPdf);
			}
			return bResp; 		
		}
		
		public boolean ingresoImprimirCab(String strSeccion) {		
			boolean bResp = false;
			switch (strSeccion){
				case "SeccionEnvios":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div[3]/div/div[6]/a");
					break;
				case "SeccionPagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/div/div[6]/a");
					break;
				case "SeccionDetallePagosAutorizar":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[7]/div/div[6]/a");
					break;
				case "SeccionPagosProcesados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarImprimir);
					break;
				case "SeccionPagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarImprimir);
					break;
				case "SeccionDetallePagosBloqueados":
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[6]/a");
					break;
				default:
					bResp = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strExportarImprimir);
			}
			return bResp; 		
		}
		public boolean comparaCampos() throws InterruptedException, IOException{
			boolean blnResultadoComparado=false;
			String strCanal=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div[11]/span[1]");
			String strCanalValor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div[11]/span[2]");
			
			if(strCanal.equals("Canal:")&&strCanalValor.equals(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO)){
				blnResultadoComparado=true;
			}
			return blnResultadoComparado;		
		}
		
		public boolean ingresoEnviarCorreo() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[1]/a");		
		}
		public boolean ingresoExportarExcel(){		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[4]/a");
		}
		public boolean ingresoExportarPdf(){		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[5]/a");		
		}
		public boolean ingresoImprimir() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[7]/div/div[6]/a");		
		}
		public boolean ingresarTituloCorreo(String strDescripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", strDescripcion);
		}
		public boolean ingresarMensajeCorreo(String strDescripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", strDescripcion);
		}
		public boolean ingresoBotonEnviarCorreo() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
		}
		public boolean ingresoBotonEnviarCorreo2() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");		
		} 

		public boolean ingresoVerPagosExpirados() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/a");		
		} 
}
