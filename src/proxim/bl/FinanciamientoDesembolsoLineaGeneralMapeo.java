package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.FinanciamientoDesembolsoLineaAutorizarBE;
import proxim.be.FinanciamientoDesembolsoLineaBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;


public class FinanciamientoDesembolsoLineaGeneralMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	boolean bandera=false;
	String LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	String LStr_HoraInicio;
	String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();

	
	public boolean seleccionarSubMenu1(String strProducto) throws InterruptedException, IOException{
		String str_Mensaje="";
		String strPestana="";
		bandera=false;
		for(int i=1;i<=4;i++){
			strPestana="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a";
			str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strPestana)).getText();
			if(strProducto.equals(str_Mensaje)){
				bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strPestana);
				break;
			}
		}
		return bandera;
	}
	
	public boolean verificarEnvioSolicitud() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]");
	}
	
	public boolean verificarCaposObligatoriosAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean verificarLineaVigenteTitulo()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[1]");
	}
	
	public boolean verificarMontoSolicitud()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/span[3]");
	}
	
	public boolean verificarTerminoCargarAutorizar()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div[1]/span[2]");
	}
	
	public boolean verificarTablaAutorizar()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[1]/div/div/div[5]/div/div/table");
	}
	
	public boolean verOperacionDetalle()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/span[1]");
	}
	
	public boolean RegresarDetalleAutorizar()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/span[1]");
	}
	
	public boolean verificarLineaVigente()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[2]");
	}
	
	public boolean verificarTablaDetalle()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[2]/div[1]/div/div[2]");
	}
	
	public boolean verificarConfirmaOperacion()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div/div/span[3]");
	}
	
	public boolean verificarResultadoFinal()throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/span[1]");
	}
	
	public boolean verificarSolicitudAutorizar()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean verificarConfirmaOperacionAutorizar()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[1]/span[3]");
	}
	
	public boolean verificarResultadoFinalAutorizar()throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div[1]/span[1]");
	}
	
	public boolean verificarSolicitudesProcesadas()throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/span[4]");
	}
	
	public boolean verificarTerminarCargarProcesadas()throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[1]/span[2]");
	}
	
	public boolean verificarSolicitudBloqueada()throws InterruptedException, IOException{			
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	}
	
	public boolean GuardarCamposDesembolsoLinea() throws InterruptedException, IOException, SQLException{	
		String StrLinea_Vigente, StrLinea_Utilizada, StrLinea_Disponible,StrPlazo_Minimo,StrPlazo_Maximo,StrFecha_Vencimiento;
		StrLinea_Vigente=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[2]" );
		StrLinea_Utilizada=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[3]/span[2]");
		StrLinea_Disponible=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/span[2]" );
		StrPlazo_Minimo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[2]");
		StrPlazo_Maximo=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/span[2]" );
		StrFecha_Vencimiento=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/span[2]");
				
		return objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DESLINEA_D set LBN_LINEA_VIGENTE='"+StrLinea_Vigente+"',LBN_LINEA_UTILIZADA='"+StrLinea_Utilizada+"',LBN_LINEA_DISPONIBLE='"+StrLinea_Disponible+"',LBN_PLAZO_MINIMO='"+StrPlazo_Minimo+"',LBN_PLAZO_MAXIMO='"+StrPlazo_Maximo+"',LBN_FECHA_VENCIMIENTO='"+StrFecha_Vencimiento+"' where ID_CASO="+Mdl_Variables.Gint_IdCaso);
	}
	
	public boolean GuardarCamposInteresToralPagar() throws InterruptedException, IOException, SQLException{	
		FinanciamientoDesembolsoLineaBE.StrInteres=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[2]/div[2]/div[1]/span[2]" );
		FinanciamientoDesembolsoLineaBE.StrMontoMoneda=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[1]/div[2]/span[2]" );
		Mdl_Variables.GstrTotalPagar=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[2]/div[2]/div[2]/span[2]" );
				
		return objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DESLINEA_D set LBL_INTERES='"+FinanciamientoDesembolsoLineaBE.StrInteres+"',LBL_TOTAL_PAGAR='"+Mdl_Variables.GstrTotalPagar+"' where ID_CASO="+Mdl_Variables.Gint_IdCaso);
	}
	
	public boolean GuardarCamposTEA() throws InterruptedException, IOException, SQLException{	
		FinanciamientoDesembolsoLineaBE.StrTEA =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div/div[2]/div[8]/span[2]" );
		return objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DESLINEA_D set LBL_TEA='"+FinanciamientoDesembolsoLineaBE.StrTEA+"' where ID_CASO="+Mdl_Variables.Gint_IdCaso);
	}
		
    public boolean verificarMensaje()   {
		try {
			Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[4]"));
			bandera=true;
		} catch (Exception e) {
			bandera = false;
		}
		return bandera;
	}
    
	
    public boolean verificarMonto() throws InterruptedException, IOException{
    	return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[5]/input");
	}
    
	public boolean ingresarMonto(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[5]/input", strDescripcion);
	}
	
	public boolean ingresoBotonAceptar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");		
	}
	
	public boolean ingresoBotonSI() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/div[1]/a");		
	}
	
	public boolean ingresoBotonNO() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/div[2]/a");		
	}
	
	public boolean seleccionarEmpresa(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/select",strProducto);
	}
			
	public boolean seleccionarMoneda(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[7]/select",strProducto);
	}		
	
	public boolean seleccionarNumeroCuotas(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[9]/select",strProducto);
	}
	
	public boolean seleccionarFrecuencia(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[11]/select",strProducto);
	}
	
	public boolean seleccionarTipoCronograma(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[13]/select",strProducto);
	}
		
	public boolean ingresarFechaPrimeraCuota(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[15]/div/div/input", strDescripcion);
	}
	
	public boolean ingresoBotonContinuar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/a/img");		
	}
	
	public boolean seleccionarCuenta(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[4]/select",strProducto);
	}
	
	public boolean ingresoBotonContinuarNew() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/a/img");		
	}
	
	public boolean ingresarClaveDinamica(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div/div[5]/input", strDescripcion);
	}
	
	public boolean ingresoBotonConfirmar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div/div[6]/a[1]");		
	}
	
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div/div[6]/a[2]");		
	}
	
	public boolean compararMensajeResultanteAfiliado(String Lstr_TxtMensajeError) throws InterruptedException, IOException{	
		String str_Mensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/span[1]" );
		
		if(str_Mensaje.equals(Lstr_TxtMensajeError)){
			return true;
		}else{
			return false;
		}	
	}
	
	public boolean compararMensajePopUp(String Lstr_TxtMensajeError) throws InterruptedException, IOException{	
		return Mdl_Variables.Gwed_Driver.getPageSource().contains(Lstr_TxtMensajeError);
	}
	
	public boolean verificarMensajeFirmante() throws InterruptedException, IOException{	
		return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[3]/div[3]/span[6]");
	}
	
   public boolean compararResultadoEsperadoPositivo() throws InterruptedException, IOException{	
	   String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/span[1]" );
		   
	   if(str_Mensaje.equals("Tu operación ha sido enviada")){
			return true;
	   }else{
		   return false;
	   }	
   }

	//-----------------------AUTORIZACION
	public boolean seleccionarEmpresaAutorizacion(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/select",strProducto);
	}
	
	public boolean ingresarFechaOperacionDesdeAutorizacion(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarFechaOperacionHastaAutorizacion(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div[2]/input", strDescripcion);
	}
	
	public boolean ingresoBotonBuscarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/a/img");		
	}
	
	public boolean ingresoBotonAutorizarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/a[1]/div/img");		
	}
	
	public boolean ingresoBotonBloquearAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/div[2]/a[2]/div/img");		
	}
	
	public boolean seleccionarLoteAutorizacion() throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			//String ca="03/10/2016";
			if (colss.get(2).getText().equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&//Fecha Solicitud
					colss.get(3).getText().equals(FinanciamientoDesembolsoLineaBE.StrMontoMoneda)&&//Monto
					colss.get(4).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_NUMERO_CUOTAS)&&//Numero Cuotas
					colss.get(5).getText().equals(FinanciamientoDesembolsoLineaBE.GstrTXT_FECHA_PRIMERA_CUOTA)&&//Fecha Primera Cuota
					colss.get(6).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA)){//Cuenta Destino
				colss.get(0).click();
								
								
				
				if (objFuncionesGenerales.verificarIgnore( FinanciamientoDesembolsoLineaAutorizarBE.GstrLNK_VER)){	
					colss.get(1).click();
					 
					 verOperacionDetalle();
					 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					 
					// frecuencia=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[6]/div/span[2]" );
					// tipoCronograma=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[7]/div/span[2]" );
					
					 //if(frecuencia.equals(FinanDesembolsoLineaBL.GstrCMB_FRECUENCIA)){
						// if(tipoCronograma.equals(FinanDesembolsoLineaBL.GstrCMB_TIPO_CRONOGRAMA)){
							 bandera= true;
							 objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/a");	
								
							 break;
						// }
					 //}
					
					 	
	        	}
			}
			
		}
		return bandera;
	}
	
	public boolean verDetalleAutorizacion() throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if (colss.get(2).getText().equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&//Fecha Solicitud
					colss.get(3).getText().equals(FinanciamientoDesembolsoLineaBE.StrMontoMoneda)&&//Monto
					colss.get(4).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_NUMERO_CUOTAS)&&//Numero Cuotas
					colss.get(5).getText().equals(FinanciamientoDesembolsoLineaBE.GstrTXT_FECHA_PRIMERA_CUOTA)&&//Fecha Primera Cuota
					colss.get(6).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA)){//Cuenta Destino
				
				colss.get(1).click();
				bandera=true;
				break;
			}	
		}
		return bandera;
	}
	
	public boolean ingresoLinkRegresarAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div[1]/a");	
	}
	
	public boolean ingresarClaveDinamicaAutorizar(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[6]/input", strDescripcion);
	}
	
	public boolean ingresoBotonConfirmarAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[7]/a[1]");		
	}
	
	public boolean ingresoBotonCancelarOperacionAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[7]/a[2]");		
	}
	
	public boolean compararMensajeResultanteAutorizar(String Lstr_TxtMensajeError) throws InterruptedException, IOException{	
		String str_Mensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div[1]/span[1]" );
																				  
		if(str_Mensaje.equals(Lstr_TxtMensajeError))
		{
			return true;
		}else{
			return false;
		}	
	}
	
	public boolean GuardarDatosOperacion(int intNumero) throws InterruptedException, IOException, SQLException{	
		String Lstr_Num_Operacion;
		if(intNumero==1){
			Lstr_Num_Operacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/span[3]" );
			FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/span[5]" );
			FinanciamientoDesembolsoLineaBE.GstrLBL_HORA_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/span[7]" );
			FinanciamientoDesembolsoLineaBE.StrMontoPagar=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/span[4]" );
			
		}else{
			Lstr_Num_Operacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div[1]/span[3]" );
			FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div[1]/span[5]" );
			FinanciamientoDesembolsoLineaBE.GstrLBL_HORA_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div[1]/span[7]" );
		}
		
		//int totalCadena=FinanDesembolsoLineaBL.StrMontoPagar.length();
		
		 Mdl_Variables.Garr_montosBuscar=new String[1];
		 String nuevoValorMoneda;
		 if(FinanciamientoDesembolsoLineaBE.StrMontoPagar.contains("/")){
				Mdl_Variables.GstrTotalPagar=Mdl_Variables.GstrTotalPagar.substring(3, Mdl_Variables.GstrTotalPagar.length());
				 nuevoValorMoneda="S/-";
			}else{
				Mdl_Variables.GstrTotalPagar=Mdl_Variables.GstrTotalPagar.substring(4, Mdl_Variables.GstrTotalPagar.length());
				 nuevoValorMoneda="US$-";
			}
		 

		 Mdl_Variables.Garr_montosBuscar[0] =nuevoValorMoneda +Mdl_Variables.GstrTotalPagar;
		 
		 
		if(intNumero==1){
			bandera= objConexionSqlServer.updateTablaQuery("update "+Mdl_Variables.Gstr_Tabla+" set LBL_FECHA_OPERACION='"+FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION+"',LBL_HORA_OPERACION='"+FinanciamientoDesembolsoLineaBE.GstrLBL_HORA_OPERACION+"',LBL_OPERACION='"+Lstr_Num_Operacion+"' where ID_CASO="+Mdl_Variables.Gint_IdCaso);
		}else{
			bandera= objConexionSqlServer.updateTablaQuery("update APP_FINANCIAMIENTO_DESLINEA_AUTORIZAR_D set LBL_OPERACION='"+Lstr_Num_Operacion+"',LBL_FECHA_ENVIADA='"+FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION+"',LBL_HORA_ENVIADA='"+FinanciamientoDesembolsoLineaBE.GstrLBL_HORA_OPERACION+"' where ID_CASO="+FinanciamientoDesembolsoLineaAutorizarBE.Gstr_ID_CASO);
		}
		return bandera;
	}
	//---------------------------------------------PROCESADAS
	public boolean seleccionarEmpresaProcesadas(String strProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[2]/select",strProducto);
	}
	
	public boolean ingresarFechaOperacionDesdeProcesadas(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[1]/input", strDescripcion);
	}
	
	public boolean ingresarFechaOperacionHastaProcesadas(String strDescripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[2]/input", strDescripcion);
	}
	
	public boolean ingresoBotonBuscarProcesadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	public boolean verificarTablaProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div/div/div[5]/div/div/table");
	}
	
	public boolean verificarDetalleProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/span[1]");
	}
	
	public int buscarSolicitudProcesada() throws InterruptedException, IOException{		
		int intNumeroFila=0;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if (colss.get(1).getText().equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&//Fecha Solicitud
				colss.get(3).getText().equals(FinanciamientoDesembolsoLineaBE.StrMontoMoneda)&&//Monto
				colss.get(4).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_NUMERO_CUOTAS)&&//Numero Cuotas
				colss.get(5).getText().equals(FinanciamientoDesembolsoLineaBE.GstrTXT_FECHA_PRIMERA_CUOTA)&&//Fecha Proxima Cuota
				colss.get(6).getText().equals("Desembolsado")){//estado
				intNumeroFila=j;
				break;
			}
		}
		return intNumeroFila;
	}
	
	public boolean seleccionarSolicitudProcesada(int intNumeroFila) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		boolean bandera=false;
		
		if(num.size()-2==1){
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");		
		}else{
			bandera=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div/div/div[5]/div/div/table/tbody[1]/tr["+intNumeroFila+"]/td[1]/div/div/a");
		}
		return bandera;
	}
	
	//---------------------------------------------BLOQUEADA
		public boolean seleccionarEmpresaBloqueadas(String strProducto) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div[2]/select",strProducto);
		}
		
		public boolean ingresarFechaOperacionDesdeBloqueadas(String strDescripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[1]/input", strDescripcion);
		}
		
		public boolean ingresarFechaOperacionHastaBloqueadas(String strDescripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[2]/input", strDescripcion);
		}
		
		public boolean ingresoBotonBuscarBloqueadas() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/a/img");		
		}
		
		public boolean verificarTablaBloqueada() throws InterruptedException, IOException{		
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div/div[5]/div/div/table");
		}
		
		
		public boolean verificarDetalleBloqueada() throws InterruptedException, IOException{		
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/span[1]");
		}
		
		public boolean seleccionarSolicitudBloqueadas() throws InterruptedException, IOException{		
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			
			for (int j = 1;j<=num.size()-2;j++){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if (colss.get(1).getText().equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&//Fecha Solicitud
						colss.get(2).getText().equals(FinanciamientoDesembolsoLineaBE.StrMontoMoneda)&&//Monto
						colss.get(3).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_NUMERO_CUOTAS)&&//Numero Cuotas
						colss.get(4).getText().equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&//Fecha Proxima Cuota
						colss.get(5).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA)){//Numero Cuotas
						
						//colss.get(0).click();
						bandera=true;
						break;
				}
			}
			return bandera;
		}
		
		public boolean verDetalleBloqueadas() throws InterruptedException, IOException{		
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			
			for (int j = 1;j<=num.size()-2;j++){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if (colss.get(1).getText().equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&//Fecha Solicitud
					colss.get(2).getText().equals(FinanciamientoDesembolsoLineaBE.StrMontoMoneda)&&//Monto
					colss.get(3).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_NUMERO_CUOTAS)&&//Numero Cuotas
					colss.get(4).getText().equals(FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION)&&//Fecha Proxima Cuota
					colss.get(5).getText().equals(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA)){//Numero Cuotas
					
					colss.get(0).click();
					bandera=true;
					break;
				}
			}
			return bandera;
		}
} 
