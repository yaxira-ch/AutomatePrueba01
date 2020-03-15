package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.PagosDocumentosAutorizarBE;
import proxim.be.PagosDocumentosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosDocumentosMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	boolean bandera;

	
	//----------------------------------------------PAGO DOCUMENTOS------------------------------
	
	public boolean verificarCamposObligatoriosDocumentos(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	public boolean verificarMensajeInformativo(){	
		boolean bandera = false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/span");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarNoMensajeInformativo(){	
		boolean bandera = true;
		try {
			bandera = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/span");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	public boolean ingresoAceptar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");
	}
	
	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",strEmpresa);
	}
	public boolean seleccionarBusqueda(String strBusqueda) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",strBusqueda);
	}
	public boolean seleccionarSituacion(String strSituacion) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/select",strSituacion);
	}
	public boolean seleccionarMoneda(String strMoneda) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/select",strMoneda);
	}
	public boolean ingresarNroDocumento(String strNroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/input",strNroDocumento);
	}
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a");
	}
	public boolean verificarTabla(){
			try {
				bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div[5]/div/div/table");
			} catch (Exception e) {
				
			}
			return bandera;
		}

	public boolean verificarPaginacion(){
		boolean paginacion=false;
		try {
			paginacion = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div[2]");
		} catch (Exception e) {
			
		}
		return paginacion;
	}
	
	public boolean seleccionarCheckDocumento(String strNumeroDocumento) throws InterruptedException, IOException{		
		boolean bandera = false;
		int numeroTotalPaginas;
		
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div[5]/div/div/table"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			int numero=num.size();
			numero = numero -2;
			
			if(verificarPaginacion()) {
				WebElement pag = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div[2]"));
				List<WebElement> numPag=pag.findElements(By.xpath(".//a"));
				numeroTotalPaginas=numPag.size();
			}else{
				numeroTotalPaginas=1;
			}
			
			for(int i=1;i<=numeroTotalPaginas;i++)
			{
				if(i!=1){
					objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/div/div[2]/a["+i+"]");
					Thread.sleep(10000);
				}
				
				for (int j =1 ;j<=numero;j++)
				{ 
					List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
					if (colss.get(2).getText().equals(strNumeroDocumento)){//NUMERO DOCUMENTO
						colss.get(0).click();
						bandera = true;
						break;
					}
				}
				if(bandera){
					break;
				}
			}
		

		return bandera;		
	}
	
	public boolean ingresoBotonContinuar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/a");
	}
	
	public boolean verificarMensajeFinal() throws InterruptedException, IOException{	
		String TXT_Mensaje_Error;
		boolean LBN_Var=false;
		switch (PagosDocumentosBE.strTXT_COLUMNA_ERROR) 
		{
			case "BTN_CONTINUAR": //LOGIN
				verificarMensajeInformativo();
				TXT_Mensaje_Error=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/span" );  
				
				if(  TXT_Mensaje_Error.replace("\n\n", "\r\n\r\n").equals(PagosDocumentosBE.strTXT_MENSAJE_ERROR))
				{ 
					LBN_Var= true;
				}
		}	
	    		
		return LBN_Var;
	}
	
	public boolean ingresoMensajeAceptar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");
	}
	
	public boolean seleccionarCuentaCargo(String strCuentaCargo) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/select",strCuentaCargo);
	}
	
	public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException
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
	
	public boolean ingresarClaveDinamica(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[7]/input", strClaveDinamica);
	}
	public boolean ingresoBotonConfirmar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[8]/a[1]");
	}
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[8]/a[2]");
	}
	
	public boolean verificarImagenPagoEnviado (){	
		boolean bandera = false;
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[1]/img");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	public String obtenerResultado() throws InterruptedException, IOException{	
		   String str_Mensaje;
		   str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[1]")).getText(); 
		   return str_Mensaje;
	}
	
	public String obtenerEstadoLoteMensaje() throws InterruptedException, IOException{	
		   String str_Mensaje;
		   str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[3]/span")).getText(); 
		   return str_Mensaje;
	}
	
	public boolean compararResultadoEsperadoPositivo() throws InterruptedException, IOException{	
		   String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[1]" );  
		   
		   if(str_Mensaje.equals("Tu operación ha sido realizada con éxito"))
		   {
				return true;
		   }else{
			   return false;
		   }	
	   }
	
	public boolean GuardarDatosOperacion() throws InterruptedException, IOException, SQLException{	
		//String saldo,InteresMoratorio,InteresCompensatorio,Comision;
		 
		 PagosDocumentosBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/span[2]" );
		 PagosDocumentosBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/span[4]" );
		 PagosDocumentosBE.TIPO_DOCUMENTO=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[2]/div" );
		 PagosDocumentosBE.NUMERO_DOCUMENTO=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[3]/div" );
		 PagosDocumentosBE.RELACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div" );
		 PagosDocumentosBE.SITUACION_ESTADO=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[5]/div" );
		 PagosDocumentosBE.MONEDA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[6]/div" );
		 //saldo=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[7]/div" );
		 //InteresMoratorio=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[8]/div" );
		 //InteresCompensatorio=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[9]/div" );
		 //Comision=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[10]/div" );
		 PagosDocumentosBE.IMPORTE_TOTAL_PAGAR=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[11]/div" );
		 PagosDocumentosBE.FECHA_VENCIMIENTO=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[12]/div" );

			

		 PagosDocumentosBE.GstrLBN_MONTO_TOTAL=PagosDocumentosBE.IMPORTE_TOTAL_PAGAR;
		 Mdl_Variables.GstrTotalPagar=PagosDocumentosBE.IMPORTE_TOTAL_PAGAR;
		 
		 Mdl_Variables.Garr_montosBuscar=new String[1];
		 if(PagosDocumentosBE.MONEDA.equals("Soles")){
			 Mdl_Variables.Garr_montosBuscar[0] = "S/-"+objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[11]/div" );

		 }else{
			 Mdl_Variables.Garr_montosBuscar[0] ="US$-"+ objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[11]/div" );

		 }
		 
		 if(buscarMensaje()){
			 PagosDocumentosBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[3]/span" );
		 }else{
			 PagosDocumentosBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div" );
		}
		 
		 bandera= objConexionSqlServer.updateTablaQuery("update APP_PAGOS_DOCUMENTOS_D set LBN_OPERACION='"+PagosDocumentosBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+PagosDocumentosBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+PagosDocumentosBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+PagosDocumentosBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+PagosDocumentosBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+PagosDocumentosBE.Gstr_ID_CASO);
		 return bandera;
		 
		 
		
	 }
	//--------------PAGOS POR AUTORIZAR------------------
	
	public boolean buscarMensaje(){
		try {
			bandera = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/div[3]/span");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean buscarMensaje1(){
		try {
			bandera = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/span");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean seleccionarLinkPago(String LstrProducto) throws InterruptedException, IOException{	
		boolean var=false;
		for(int i=1;i<=4;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorLinks']/li["+i+"]//a")).getText();
			if(LstrProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorLinks']/li["+i+"]//a");
				Thread.sleep(4000);
				break;
			}
		}
		return var;			
	}
	
	
	
	
	public boolean ingresoBotonBuscar_Autorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/a");
	}
	public boolean seleccionarCheckAutorizar(String strNumeroDocumento) throws InterruptedException, IOException{		
		boolean bandera = false;
		
		while (bandera == false)
		{
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div/div[5]/div/div/table"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			int numero=num.size();
			numero = numero -2;
			for (int j = numero;j>=1;j--)
			{ 
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				if (colss.get(1).getText().equals(strNumeroDocumento)){//NUMERO DOCUMENTO
					colss.get(0).click();
				}
			}
		}
		return true;
	}
   
	//-------------------------------------------------------Autorizar-------------------------------------------------------
	
	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
		boolean var=false;
		for(int i=1;i<=4;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]//a")).getText();
			if(LstrProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]//a");
				break;
			}
		}
		return var;			
	}
	
	
	public boolean verificarCamposObligatoriosAutorizar(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean seleccionarEmpresa_Autorizar(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/select",strEmpresa);
	}
	
	public boolean seleccionarTipoDocumentoAutorizar(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/select",strEmpresa);
	}
	
	public boolean seleccionarMonedaAutorizar(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[9]/select",strEmpresa);
	}
	
	public boolean ingresarFechaInicioOperacionAutorizar(String strNroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div/div[1]/input",strNroDocumento);
	}
	
	public boolean ingresarFechaFinOperacionAutorizar(String strNroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div/div[2]/input",strNroDocumento);
	}
	
	public boolean ingresoVerPagosExpiradosAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/div/a");		
	}
	
	public boolean ingresoRegresarPagosExpiradosAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/a");		
	}
	
	public boolean ingresoBotonBuscarAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[13]/a/img");		
	}
	
	public boolean verificarTablaAutorizacion(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div/div[5]/div/div/table");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean ingresoChkTodosAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div/div[5]/div/div/table/thead/tr/th[1]/input");
	}
	
	 public boolean ingresoLinkEnviarEmailAutorizacion() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonEnviarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
	
	public boolean ingresoBotonAceptarCorreoAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");	
	}
	

	
	public boolean verificarMensajeFinalAutorizar() throws InterruptedException, IOException{	
		String TXT_Mensaje_Error;
		boolean LBN_Var=false;
		switch (PagosDocumentosAutorizarBE.GstrTXT_COLUMNA_ERROR) 
		{
			case "BTN_AUTORIZAR": //LOGIN
				verificarMensajeInformativo();
				TXT_Mensaje_Error=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/span" );  
				
				if(  TXT_Mensaje_Error.replace("\n\n", "\r\n\r\n").equals(PagosDocumentosAutorizarBE.GstrTXT_MENSAJE_ERROR))
				{ 
					LBN_Var= true;
				}
		}	
	    		
		return LBN_Var;
	}
	
	public boolean ingresoMensajeAceptarAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");
	}
	
	public boolean verificarMensajeCorreoAutorizacion(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	 public boolean ingresoLinkExportarExcelAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[16]/div/div[6]/a");		
	 }
	 
	public boolean seleccionarLoteFirmar(String empresaOperacion,String tipoDocumentoOperacion,String numeroDocumentoOperacion,String relacionOperacion, String situacionEstadoOperacion,String monedaOperacion,String importeTotalOperacion,String fechaVencimientoOperacion) throws InterruptedException, IOException
	{	
		boolean var=false;
//		String numeroDocumento=null;
//		String tipoDocumento=null;	
//		String relacion=null;	
//		String moneda=null;	
//		String importeTotal=null;	
//		String estado=null;	
//		String fechaVencimiento=null;	
		try {
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
				String numeroDocumento=colss.get(1).getText();
				String tipoDocumento=colss.get(2).getText();	
				String relacion=colss.get(3).getText();	
				String moneda=colss.get(4).getText();	
				String importeTotal=colss.get(5).getText();	
				String estado=colss.get(6).getText();	
				String fechaVencimiento=colss.get(7).getText();	
			 
				if( tipoDocumento.equals(tipoDocumentoOperacion)
					&&relacion.equals(relacionOperacion)
					&&moneda.equals(monedaOperacion)
					&&importeTotal.equals(importeTotalOperacion)  
					&& estado.equals(situacionEstadoOperacion) 
					&&fechaVencimiento.equals(fechaVencimientoOperacion)	
					&&numeroDocumento.equals(numeroDocumentoOperacion)){
					var = true;
					break;
				}
			}
		} catch (Exception e) {
			var=false;
		}
		return var;
	}
	
	public boolean verDetalleLoteFirmar(String empresaOperacion,String tipoDocumentoOperacion,String numeroDocumentoOperacion,String relacionOperacion, String situacionEstadoOperacion,String monedaOperacion,String importeTotalOperacion,String fechaVencimientoOperacion) throws InterruptedException, IOException
	{	
		boolean var=false;
//		String numeroDocumento=null;
//		String tipoDocumento=null;	
//		String relacion=null;	
//		String moneda=null;	
//		String importeTotal=null;	
//		String estado=null;	
//		String fechaVencimiento=null;	
		try {
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
				String numeroDocumento=colss.get(1).getText();
				String tipoDocumento=colss.get(2).getText();	
				String relacion=colss.get(3).getText();	
				String moneda=colss.get(4).getText();	
				String importeTotal=colss.get(5).getText();	
				String estado=colss.get(6).getText();	
				String fechaVencimiento=colss.get(7).getText();	
			 
				if( tipoDocumento.equals(tipoDocumentoOperacion)
					&&relacion.equals(relacionOperacion)
					&&moneda.equals(monedaOperacion)
					&&importeTotal.equals(importeTotalOperacion)  
					&& estado.equals(situacionEstadoOperacion) 
					&&fechaVencimiento.equals(fechaVencimientoOperacion)	
					&&numeroDocumento.equals(numeroDocumentoOperacion)){
					var = true;
					colss.get(0).click();
					colss.get(1).click();
					break;
				}

			}	
		} catch (Exception e) {
			var=false;
		}
		return var;
	}
	
	public boolean verificarDetalleLoteEnviar(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/h1");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean RegresarLinkDetalle() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/a");		
	 }
	
	public boolean ingresoBotonAutorizarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/a[1]/div/img");
	}
	
	public boolean ingresoBotonBloquearAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[15]/a[2]/div/img");
	}
	
	public boolean ingresoLinkVerOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[3]/table/tbody[1]/tr/td[1]/div/div/a");
	}
	
	public boolean verificarConfirmarDetalleOperacionAutorizacion(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h1");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean ingresoLinkRegresarDetalleVerOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/a");
	}
	
	public boolean verificarConfirmarOperacionAutorizacion(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//*[@id='pasoConfirmacionPago']/span[3]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean ingresoClaveAutorizar(String Lstr_Clave) throws InterruptedException, IOException
	   {	
		
			String  strValorBoton = "";
			   String  strClave = Lstr_Clave;
			   String  strLetraValor = "";

			   for (int i = 1;i<=strClave.length();i++)
		       {
				   strLetraValor = strClave.split("")[i - 1];
		        
				   for (int j = 1; j <= 10; j++)
				   {
					                                           
					   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/button["+j+"]")).getText();
					   
					   if (strValorBoton.equals(strLetraValor))
					   {
						   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/button["+j+"]")).click();
						   break;
					   }
				   }
		       }

		   
		   return true;
	   }
	
	public boolean ingresarClaveDinamicaAutorizacion(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/input",strClaveDinamica);
	}
	
	public boolean ingresoLinkQuieresSaberComoAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/a");		
	 }
	
	public boolean ingresoBotonConfirmarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[7]/a[1]");
	}
	
	public boolean ingresoBotonCancelarOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[7]/a[2]");
	}
	
	public boolean verificarmensajeFinal(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/span");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean compararResultadoEsperadoPositivoAutorizar(String ResultadoEsperado) throws InterruptedException, IOException, SQLException{	
		String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/span" );  
		   
		if(str_Mensaje.equals(ResultadoEsperado)){
			PagosDocumentosAutorizarBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/span[2]" );
			PagosDocumentosAutorizarBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/span[4]" );
			   
			if(PagosDocumentosBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
				PagosDocumentosAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[6]/div" );
			}else{

			}
			   
			if(buscarMensaje1()){
				PagosDocumentosAutorizarBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/span" );
			}else{
				PagosDocumentosBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div" );
				bandera= objConexionSqlServer.updateTablaQuery("update APP_PAGOS_DOCUMENTOS_D set  LBN_OPERACION='"+PagosDocumentosBE.GstrLBN_OPERACION+"' where ID_CASO="+PagosDocumentosBE.Gstr_ID_CASO);
			}
			objConexionSqlServer.updateTablaQuery("update APP_PAGOS_DOCUMENTOS_AUTORIZAR_D set LBN_OPERACION_FECHA='"+PagosDocumentosAutorizarBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+PagosDocumentosAutorizarBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+PagosDocumentosAutorizarBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+PagosDocumentosAutorizarBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+PagosDocumentosAutorizarBE.Gstr_ID_CASO);
				
			return true;
		}else{
			return false;
		}	
	}
	
	
	
	
	
	public boolean compararMensajeRechazado() throws InterruptedException, IOException{	
		boolean var=false;
		try {
			String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[1]/div/a")).getText();
			if(str_Mensaje.equals("Ver detalle de operaciones rechazadas"))
			{
				var= true;
			}
		} catch (Exception e) {
			var= false;
		}
		return var;
	}
	
	 public boolean ingresoLinkVerOperacionRechazadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[1]/div/a");
	}
	 
	 public boolean ingresoBotonCerrarPopUp() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
		}
	 
	public boolean ingresoLinkEnviarEmailFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreoFinalAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoFinalAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonEnviarFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
	
	public boolean ingresoBotonAceptarCorreoFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
	
	public boolean verificarMensajeCorreoFinalAutorizacion(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	 public boolean ingresoLinkExportarExcelFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirFinalAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/div[6]/a");		
	 }
	 
	 public boolean ingresoLinkRealizarOtraOperacionAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[4]/a");		
	 }
	 
	 
	 
	//-------------------------------------------------------PROCESADOS------------------------------------------------------
	
	
	public boolean verificarCamposObligatoriosProcesadas(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	public boolean seleccionarEmpresaProcesadas(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",strEmpresa);
	}
	
	public boolean seleccionarTipoDocumentoProcesadas(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",strEmpresa);
	}
	
	public boolean seleccionarMonedaProcesadas(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/select",strEmpresa);
	}
	
	public boolean ingresarFechaDesdeProcesadas(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/input", strClaveDinamica);
	}                                                               
	
	public boolean ingresarFechaHastaProcesadas(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[2]/input", strClaveDinamica);
	}
	
	public boolean ingresoBotonBuscarProcesadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	
	public boolean ingresoLinkEnviarEmailProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreoProcesada(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoProcesada(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonAceptarCorreoProcesado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
	
	public boolean verificarMensajeCorreoProcesado(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean ingresoBotonEnviarProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
		
	 public boolean ingresoLinkExportarExcelProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[6]/a");		
	 }
	
	 public boolean verificarTablaProcesados(){
			try {
				bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[11]/div/div[5]/div/div/table");
			} catch (Exception e) {
				
			}
			return bandera;
		}
	 
	 public int seleccionarSolicitudProcesada(String numeroDoc){	
		 String strNumeroInterno=null;
		 int intValorRegistro=0;
		 		
		 //System.out.println(">> CLICK - seleccionarSolicitudProcesada >> empresaOperacion: "+ numeroDoc);
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		 List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		 
		 for (int j = num.size()-2;j>=1;j--){
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			 strNumeroInterno=colss.get(0).getText();			
			 System.out.println(">> CLICK - seleccionarSolicitudProcesada >> empresaOperacion: >> FOR : -"+ strNumeroInterno + "-");

			 if(numeroDoc.trim().equals(strNumeroInterno.trim())){
				 intValorRegistro=j;
				 break;	
			 }
		 }
		 return intValorRegistro;
	 }
	 
	public boolean VerDetalleProcesada(int intNumeroRegistro) {	
		boolean var=true;
		 
		try {
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			//List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intNumeroRegistro+"]/td")));
			
			colss.get(1).click();
					
		} catch (Exception e) {
			 var=false;
		}
		 return var;
	}
	//-------------------------------------------------------BLOQUEADOS-------------------------------------------------------

	public boolean verificarCamposObligatoriosBloqueados(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	public boolean seleccionarEmpresaBloqueado(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",strEmpresa);
	}
	
	public boolean seleccionarTipoDocumentoBloqueado(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",strEmpresa);
	}
	
	public boolean seleccionarMonedaBloqueado(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/select",strEmpresa);
	}
	
	public boolean ingresarFechaDesdeBloqueado(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[1]/input", strClaveDinamica);
	}
	
	public boolean ingresarFechaHastaBloqueado(String strClaveDinamica) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/div/div[2]/input", strClaveDinamica);
	}
	
	public boolean ingresoBotonBuscarBloqueado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	
	public boolean ingresoLinkEnviarEmailBloqueadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreoBloqueadas(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoBloqueadas(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonEnviarBloqueadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }
		
	public boolean ingresoBotonAceptarCorreoBloqueadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 }
	
	public boolean verificarMensajeCorreoBloqueadas(){
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	 public boolean ingresoLinkExportarExcelBloqueadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFBloqueadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirBloqueadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/div/div[6]/a");		
	 }	
	 public int seleccionarSolicitudBloqueada(String numeroDoc){	
		 String strNumeroInterno=null;
		 int intValorRegistro=0;
		 		
		 //System.out.println(">> CLICK - seleccionarSolicitudProcesada >> empresaOperacion: "+ numeroDoc);
		 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		 List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		 
		 for (int j = num.size()-2;j>=1;j--){
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			 strNumeroInterno=colss.get(1).getText();			
			 System.out.println(">> CLICK - seleccionarSolicitudProcesada >> empresaOperacion: >> FOR : -"+ strNumeroInterno + "-");

			 if(numeroDoc.trim().equals(strNumeroInterno.trim())){
				 intValorRegistro=j;
				 break;	
			 }
		 }
		 return intValorRegistro;
	 }
	 
	// public boolean VerDetalleProcesada(String numeroDoc,String empresaOperacion,String tipoDocumentoOperacion,String numeroDocumentoOperacion,String relacionOperacion, String situacionEstadoOperacion,String monedaOperacion,String importeTotalOperacion,String fechaVencimientoOperacion) throws InterruptedException, IOException
//	public boolean VerDetalleBloqueada(int intNumeroRegistro) {	
//		boolean var=true;
//		 
//		try {
//			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
//			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
//			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intNumeroRegistro+"]/td")));
//			
//			colss.get(1).click();
//					
//		} catch (Exception e) {
//			 var=false;
//		}
//		 return var;
//	}
}
