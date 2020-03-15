package proxim.bl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;

import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasGeneralBE;
import proxim.be.FinanciamientoDesembolsoLineaBE;
import proxim.be.FinanciamientoDocumentosEleEnvioPlanillasBE;
import proxim.be.ObjetosGenerales;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosRecibosBE;
import proxim.be.TransferenciaBE;
import proxim.be.TransferenciasExteriorBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

import org.openqa.selenium.*;



public class PortabilidadMapeo {

	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	
	String urlTxtTIE="//*[@id='tarjeta']";
	String urlTxtClave="//*[@id='password']";
	String urlTxtCapcha="//div[1]/div/div[3]/div[2]/div/input";
	String urlBtnSiguiente="//*[@id='btnSubmit']";
	String urlBtnCerrarCesion="//*[@id='lnkLogout']";
	String urlBtnSiguiente1="//*[@id='btnSubmit']";
	
	public boolean ingresoBotonSiguiente1() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,urlBtnSiguiente1 );	
	}
	
	public boolean IngresarTIE(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtTIE , Descripcion);
	}
	
	public boolean ingresarClave(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtClave, Descripcion);
	}
	
	public boolean ingresarCapcha(String txtCapcha) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtCapcha , txtCapcha);
	}
	
	public boolean ingresoBotonSiguiente() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,urlBtnSiguiente );		
	}
	
	public String obtenerMensajeTie(int nOpcion) throws InterruptedException, IOException
	{	
		if (nOpcion == 1){
			return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[1]/div/div[3]/p");
		}else {
			return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[1]/div/div[4]/p");
		}
	}
	
	public boolean ingresoAutorizacionesPendientes() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div/ul/li[3]/a/span");	
	}
	
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//*[@id='empresaCombo']",LstrProducto);
	}
	
	public boolean seleccionarEmpresaHistorial(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//*[@id='empresaCombo']",LstrProducto);
	}
	
	public boolean ingresoBotonAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lnk_autorizar']");		
	}
	
	public boolean ingresoBotonBloquear() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lnk_bloquear']");		
	}
	
	public boolean ingresoCheckAceptar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/fieldset/div/div");		
	}
	
	public boolean ingresarClaveAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//*[@id='password']", Descripcion);  
	}
	
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//*[@id='clave_dinamica']", Descripcion);
	}
	
	public boolean ingresoBotonConfirmar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lkn_confirmar']");		
	}
	
	public boolean ingresoBotonEnviarEmail() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/footer/div/div/a");		
	}
	
	public boolean ingresarCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//*[@id='destinatario']", Descripcion);
	}
	
	public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//*[@id='mensaje']", Descripcion);
	}
	
	public boolean ingresoBotonEnviar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='enviar']");		
	}
	
	public boolean ingresoBotonCerrarCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div[2]/div/a");		
	}
	
	public boolean ingresoBotonHistorial() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div/ul/li[4]/a");		
	}
	
	public boolean ingresoBotonHome() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='menu-interna']/li[1]/a");		
	}
	
	public boolean ingresoCerrarCesion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlBtnCerrarCesion);		
	}
	
	public String buscarAutorizacion(String strEstadoOpe,String strDescripcionOpeData,String strEstadoOpeData,String strMonto,int intNumero) throws InterruptedException, IOException{		
		String strDescripcionOperacion="";
		String strMontoOperacion="";
		String strMontoOperacionFromateado="";
		String strEstadoOperacion="";
		String strXpathBotonNew="";
		String strXpathBoton = "";
		String strNewMonto="";
		String strNewDescripcion="";
		String strNewEstadoOperacion="";
		WebElement wbeTabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//*[@id='resultFilter']"));
		List<WebElement> lstNumeroElemento=wbeTabla.findElements(By.xpath(".//li"));
		int intprueba=lstNumeroElemento.size();

		for(int i=1; i<=intprueba;i++){

			if(lstNumeroElemento.size()!=1){
				strDescripcionOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div/b[1]");
				strMontoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div/b[2]");
				strEstadoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div/b[3]");
				strXpathBotonNew= "//*[@id='resultFilter']/li["+i+"]/div/div/a";
			}else{
				strDescripcionOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div/b[1]");
				strMontoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div/b[2]");
				strEstadoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div/b[3]");
				strXpathBotonNew= "//*[@id='resultFilter']/li/div/div/a";
			}
			
			if(strEstadoOpeData.equals("Procesada")||strEstadoOpeData.equals("Enviada al Banco")){
				strNewEstadoOperacion="Autorizado";
			}else{
				if(strEstadoOpeData.equals("Bloqueada")){
					strNewEstadoOperacion="Bloqueado";
				}
			}
			
			strMontoOperacionFromateado=objObjetosGenerales.formatearMonto(strEstadoOpe, strMontoOperacion);

			if (intNumero==1){
				strNewMonto=strMonto;
				strNewDescripcion=strDescripcionOpeData;
			}else{
				strNewMonto=Mdl_Variables.GstrTotalPagar;
				strNewDescripcion=Mdl_Variables.GstrNumeroSolicitud;
			}
			
			if(strDescripcionOperacion.equals(strNewDescripcion) 
					&& strMontoOperacionFromateado.equals(strNewMonto)
					&&strEstadoOperacion.equals(strNewEstadoOperacion)){
				strXpathBoton=strXpathBotonNew;
				break;
			}
		}	
		return strXpathBoton;
		
	}
	
	
public boolean ingresarDetalleHistorico(String strXpathBoton,int intNumero) throws InterruptedException, IOException{		
	boolean blnResultadoEsperado = false;
	
	if(intNumero==1){
		int intNumero1=objObjetosGenerales.positionElement(strXpathBoton)-200; 
		CapturarPantalla.pageDown(Integer.toString(intNumero1)) ;
	}

	blnResultadoEsperado= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strXpathBoton);	

	if(blnResultadoEsperado&&intNumero==2){
		blnResultadoEsperado=verificarDetalleHistorico();
	}
	return blnResultadoEsperado;
}

public boolean verificarDetalleHistorico() throws InterruptedException, IOException{
	boolean blnResultadoFinal=true;
	
	Thread.sleep(2500);
	CapturarPantalla.scrollCapturaPantalla2( );
	CapturarPantalla.pageDown("500");
	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	try {
		validarDetaller(PortabilidadAutorizacionBL.gstrLblTipoProducto);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return blnResultadoFinal;
}

	public boolean ingresoOperacion(String tipo_Operacion) throws InterruptedException, IOException{
		String tipOperacion;
		boolean bandera = false;
																		  
		try {
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div/ul"));
			
			
			List<WebElement> num=tabla.findElements(By.xpath(".//li"));
		
			int numX=num.size();
			
			for(int i=2; i<=numX;i++){
				tipOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div/div/div/ul/li["+i+"]/a/span/b");
				
				if(tipOperacion.equals(tipo_Operacion)){
					bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div/div/div/ul/li["+i+"]/a/span/b");	
					break;
				}					
			}
			
		} catch (Exception e) {
			bandera=false;
		} 
		return bandera;
	}
	
	public boolean verificarDesembolsoLinea() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p[1]/span");
	}
	
	public boolean verificarDesembolsoLineaDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//*[@id='lnkAutorizacionesProcesos']/span");
	}
	
	public boolean verificarDesembolsoLineaListado() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "/html/body/div[1]/div[1]/div/div/div[2]/div/label");
	}
	
	public boolean seleccionarLote(String LstrLBL_TIPO_OPERACION,String LstrLBL_TIPO_PRODUCTO) throws InterruptedException, IOException{		
		String descripcionOperacion,montoOperacion, totalCuotas,tasaInteresCompensatorio,totalInteres,totalPagar;
		boolean bandera = false;
		boolean banderaBusqueda=false;
		switch (LstrLBL_TIPO_OPERACION){
			case "Pagos Masivos": 
				Mdl_Variables.GstrNumeroSolicitud= PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion;
				break;
	    		
			case "Desembolso en Línea": 
				Mdl_Variables.GstrNumeroSolicitud="-";
	    		break;
	    		
			case "Pago de Recibos": 
				Mdl_Variables.GstrNumeroSolicitud=PagosRecibosBE.GstrTXT_NOMBRE_SOLICITUD;
	    		break;
	    		
			case "Transferencias": 
				Mdl_Variables.GstrNumeroSolicitud=TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA;
				break;
	    	
			case "Descuentos y Cobranza de Documentos": 
				Mdl_Variables.GstrNumeroSolicitud=FinanciamientoDescuentosCobEnvioPlanillasGeneralBE.GstrTXT_NOMBRE_PLANILLA;
				break;
			
			case "Documentos Electrónicos": 
				Mdl_Variables.GstrNumeroSolicitud=FinanciamientoDocumentosEleEnvioPlanillasBE.GstrTXT_NOMBRE_PLANILLA;
				break;
				
			case "Carta Fianza": 
				Mdl_Variables.GstrNumeroSolicitud="-";
				break;
	    	
			case "Pago de Documentos": 
				Mdl_Variables.GstrNumeroSolicitud="-";
				break;
			case "Renovacion Carta Fianza": 
				Mdl_Variables.GstrNumeroSolicitud="-";
				break;
			case "Comercio Exterior": 
				Mdl_Variables.GstrNumeroSolicitud=TransferenciasExteriorBE.GstrTXT_NOMBRE_BENEFICIARIO;
				break;
		}
		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//*[@id='resultFilter']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//li"));
		String montoOperacionFormateado="";
		CapturarPantalla.pageDown("10000");
		for(int i=num.size(); i>=1;i--){
			
			if(LstrLBL_TIPO_OPERACION.equals("Desembolso en Línea")){
				if(num.size()!=1){
					montoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[1]/label/span/b[2]");
					
					if(montoOperacion.equals(FinanciamientoDesembolsoLineaBE.StrMontoPagar)){ 
						bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[2]/a");	
						verificarDesembolsoLineaDetalle();

						if(bandera){
							totalCuotas= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p[3]/b");
							tasaInteresCompensatorio= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p[4]/b");
							totalInteres= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p[5]/b");
							totalPagar= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p[6]/b");
							montoOperacionFormateado=objObjetosGenerales.formatearMonto(LstrLBL_TIPO_OPERACION,totalPagar);	
							if(totalCuotas.equals(FinanciamientoDesembolsoLineaBE.GstrCMB_NUMERO_CUOTAS)&&
								tasaInteresCompensatorio.equals(FinanciamientoDesembolsoLineaBE.StrTEA)&&
								totalInteres.equals(FinanciamientoDesembolsoLineaBE.StrInteres)&&
								montoOperacionFormateado.equals(Mdl_Variables.GstrTotalPagar)){
											bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lnkAutorizacionesProcesos']/span");	
											banderaBusqueda=true;
											break;
							}
							if (banderaBusqueda==true && bandera==true){
								verificarDesembolsoLineaListado();
								Thread.sleep(2000);
								bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[1]/label");
							}

						}
					}
				}else{
					montoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div[1]/label/span/b[2]");
					montoOperacionFormateado=objObjetosGenerales.formatearMonto(LstrLBL_TIPO_OPERACION,montoOperacion);	
					if(montoOperacion.equals(FinanciamientoDesembolsoLineaBE.StrMontoPagar)){  
						bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div[1]/label/span");	
						break;
					}
				}
			}else{
				if(num.size()!=1){
					descripcionOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[1]/label/span/b[1]");
					montoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[1]/label/span/b[2]");
					montoOperacionFormateado=objObjetosGenerales.formatearMonto(LstrLBL_TIPO_OPERACION,montoOperacion);	
					
					if(descripcionOperacion.equals(Mdl_Variables.GstrNumeroSolicitud) && montoOperacionFormateado.equals(Mdl_Variables.GstrTotalPagar)){													
						ingresarDetalle(i);
						bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[1]/label/span");	
						break;
					}
				}else{
					descripcionOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div[1]/label/span/b[1]");
					montoOperacion= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div[1]/label/span/b[2]");
					montoOperacionFormateado=objObjetosGenerales.formatearMonto(LstrLBL_TIPO_OPERACION,montoOperacion);	
					if(descripcionOperacion.equals(Mdl_Variables.GstrNumeroSolicitud) && montoOperacionFormateado.equals(Mdl_Variables.GstrTotalPagar)){									
						ingresarDetalle(0); 
						bandera= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div[1]/label/span");	
						break;
					}
				}

			}
		}
		return bandera;
	}
	private void ingresarDetalle(int i) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		//selecciona el icono para entrar al detalle
		if(i>0)
			objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[2]/a");
		else
			objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div[2]/a");
		
		objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//*[@id='lnkAutorizacionesProcesos2']");
		CapturarPantalla.scrollCapturaPantalla2( );
		CapturarPantalla.pageDown("500");
		CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		
		try {
			validarDetaller(PortabilidadAutorizacionBL.GstrLBL_TIPO_OPERACION);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//clic en el ícono volver
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lnkAutorizacionesProcesos2']");		

		if(i>0)			
			objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li["+i+"]/div[2]/a");
		else
			objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//*[@id='resultFilter']/li/div[2]/a");
		
		CapturarPantalla.pageDown("10000");
		
	}

	public void validarDetaller(String strTipoOperacion) throws SQLException, IOException, InterruptedException{
		String campo=null;
		String valor="";
		int j=1;
		String valoresDiferentes="";
		
		if(strTipoOperacion.equals("Comercio Exterior")){
			//realizar la verificación del detalle
			campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p[1]/span");
			
			while(!campo.equals("Firmantes")){
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p["+j+"]/b");
				
				switch(campo){
					case "Empresa":
						if(!TransferenciasExteriorBE.GstrTXT_NOMBRE_ORDENANTE.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TransferenciasExteriorBE.GstrTXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
						break;
					case "Número de Referencia":				
						if(!TransferenciasExteriorBE.GstrLBL_NRO_REFERENCIA.equals(valor))
							valoresDiferentes=valoresDiferentes+"- LBL_NRO_REFERENCIA esperado: "+TransferenciasExteriorBE.GstrLBL_NRO_REFERENCIA+" ,obtenido: "+valor+"\n";
						break;
					case "Monto de Cargo":
						valor=objObjetosGenerales.formatearMonto(PortabilidadAutorizacionBL.GstrLBL_TIPO_OPERACION,valor);
						if(!Mdl_Variables.GstrTotalPagar.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TransferenciasExteriorBE.GstrTXT_MONTO+" ,obtenido: "+valor+"\n";
						break;
					case "Cuenta de Cargo":
						String cuentaCargoObtenida=valor.substring(0, valor.length()-11)+"-"+valor.substring(valor.length()-10, valor.length());
						String cuentaCargoBD=valor.substring(0, TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.length()-11)+"-"+
								TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.substring(TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.length()-10,
										TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.length());
						if(!cuentaCargoBD.equals(cuentaCargoObtenida))
							valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
						break;	
					case "Tipo de Cambio" :
						if(!TransferenciasExteriorBE.strTIPO_CAMBIO.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TIPO DE CAMBIO esperado: "+TransferenciasExteriorBE.strTIPO_CAMBIO+" ,obtenido: "+valor+"\n";
						break;
					
					case "Tipo de Cambio Referencial":
						if(!TransferenciasExteriorBE.strTIPO_CAMBIO.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TIPO DE CAMBIO REFERENCIAL esperado: "+TransferenciasExteriorBE.strTIPO_CAMBIO+" ,obtenido: "+valor+"\n";
						break;
						
					case "Arbitraje":
						if(!TransferenciasExteriorBE.strARBITRAJE.equals(valor))
							valoresDiferentes=valoresDiferentes+"- ARBITRAJE esperado: "+TransferenciasExteriorBE.strARBITRAJE+" ,obtenido: "+valor+"\n";
						break;	
						
					case "Arbitraje Referencial":
						if(!TransferenciasExteriorBE.strARBITRAJE.equals(valor))
							valoresDiferentes=valoresDiferentes+"- ARBITRAJE REFERENCIAL esperado: "+TransferenciasExteriorBE.strARBITRAJE+" ,obtenido: "+valor+"\n";
						break;
						
					case "Nombre del Beneficiario":					
						if(!TransferenciasExteriorBE.GstrTXT_NOMBRE_BENEFICIARIO.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TransferenciasExteriorBE.GstrTXT_NOMBRE_BENEFICIARIO+" ,obtenido: "+valor+"\n";
						break;	
					case "Ubicación del Beneficiario":	
						String ubicacionBene=TransferenciasExteriorBE.GstrTXT_CIUDAD_BENEFICIARIO+", "+TransferenciasExteriorBE.GstrCMB_PAIS_BENEFICIARIO;
						if(!ubicacionBene.equals(valor))
							valoresDiferentes=valoresDiferentes+"- UBICACION_BENEFICIARIO esperado: "+ubicacionBene+" ,obtenido: "+valor+"\n";
						break;	
					case "Cuenta de Abono":					
						if(!TransferenciasExteriorBE.GstrTXT_CUENTA_ABONO.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TransferenciasExteriorBE.GstrTXT_CUENTA_ABONO+" ,obtenido: "+valor+"\n";
						break;
					case "Banco del Beneficiario":					
						if(!TransferenciasExteriorBE.GstrTXT_NOMBRE_BANCO.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TransferenciasExteriorBE.GstrTXT_NOMBRE_BANCO+" ,obtenido: "+valor+"\n";
						break;
					case "Ubicación del Banco Beneficiario":
						String ubicacionBanco=TransferenciasExteriorBE.GstrTXT_CIUDAD_BANCO+", "+TransferenciasExteriorBE.GstrCMB_PAIS_BANCO;
						if(!ubicacionBanco.equals(valor))
							valoresDiferentes=valoresDiferentes+"- UBICACION_BANCO esperado: "+ubicacionBanco+" ,obtenido: "+valor+"\n";
						break;					
					case "Código del Banco Beneficiario":	
						String codBanco=TransferenciasExteriorBE.GstrCMB_TIPO_CODIGO_BANCO+" "+TransferenciasExteriorBE.GstrTXT_CODIGO_BANCO;
						if(!codBanco.equals(valor))
							valoresDiferentes=valoresDiferentes+"- CODIGO_BANCO esperado: "+codBanco+" ,obtenido: "+valor+"\n";
						break;	
					case "Banco Intermediario":
						if(!TransferenciasExteriorBE.GstrTXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TransferenciasExteriorBE.GstrTXT_NOMBRE_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
						break;
					case "Ubicación del Banco Intermediario":			
						String ubiBancoInter=TransferenciasExteriorBE.GstrTXT_CIUDAD_BANCO_INTERMEDIARIO+", "+TransferenciasExteriorBE.GstrCMB_PAIS_BANCO_INTERMEDIARIO;
						if(!ubiBancoInter.equals(valor))
							valoresDiferentes=valoresDiferentes+"- UBICACION_BANCO_INTERMEDIARIO esperado: "+ubiBancoInter+" ,obtenido: "+valor+"\n";
						break;
					case "Código del Banco Intermediario":
						String codBancoInter=TransferenciasExteriorBE.GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" "+TransferenciasExteriorBE.GstrTXT_CODIGO_BANCO_INTERMEDIARIO;
						if(!codBancoInter.equals(valor))
							valoresDiferentes=valoresDiferentes+"- CODIGO_BANCO_INTERMEDIARIO esperado: "+codBancoInter+" ,obtenido: "+valor+"\n";
						break;
					case "Motivo de Transferencia":					
						if(!TransferenciasExteriorBE.GstrCMB_MOTIVO_TRANSFERENCIA.equals(valor))
							valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+TransferenciasExteriorBE.GstrCMB_MOTIVO_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
						break;
					case "Gastos":					
						if(!TransferenciasExteriorBE.GstrCMB_GASTOS_CORRESPONSAL.equals(valor))
							valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+TransferenciasExteriorBE.GstrCMB_GASTOS_CORRESPONSAL+" ,obtenido: "+valor+"\n";
						break;
					case "Detalle del Pago":					
						if(!TransferenciasExteriorBE.GstrTXT_DETALLE_PAGO.equals(valor))
							valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TransferenciasExteriorBE.GstrTXT_DETALLE_PAGO+" ,obtenido: "+valor+"\n";
						break;
				}
				j++;
				campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p["+j+"]/span");				
			}
			if(!valoresDiferentes.equals(""))
				System.out.println("Caso: "+PortabilidadAutorizacionBL.GstrID_CASO_LOTE+" - Valores diferentes en Detalle de Autorización Portabilidad: \n"  + valoresDiferentes);

		}else if (strTipoOperacion.equals("Transferencia entre cuentas")){
			campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p[1]/span");
			
			while(!campo.equals("Firmantes")){
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p["+j+"]/b");
				switch(campo){
					case "Tipo de Transferencia":
						if(!PortabilidadAutorizacionBL.gstrLblTipoProducto.equals(valor))
							valoresDiferentes=valoresDiferentes+"- Tipo de Transferencia esperado: "+PortabilidadAutorizacionBL.GstrLBL_TIPO_OPERACION+" ,obtenido: "+valor+"\n";
						break;
					case "Número de Solicitud":				
						if(!Mdl_Variables.GstrNumeroSolicitud.equals(valor))
							valoresDiferentes=valoresDiferentes+"- Número de Solicitud esperado: "+Mdl_Variables.GstrNumeroSolicitud+" ,obtenido: "+valor+"\n";
						break;
					case "Fecha de Solicitud":
						String strNuevoValor=new SimpleDateFormat("dd/MM/yyy").format(Calendar.getInstance().getTime());
						
						if(!strNuevoValor.equals(valor))
							valoresDiferentes=valoresDiferentes+"- Fecha de Solicitud esperado: "+strNuevoValor+" ,obtenido: "+valor+"\n";
						break;
//					case "Cuenta de Origen":
//						String cuentaCargoObtenida=valor.substring(0, valor.length()-11)+"-"+valor.substring(valor.length()-10, valor.length());
//						String cuentaCargoBD=valor.substring(0, TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.length()-11)+"-"+
//								TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.substring(TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.length()-10,
//										TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO.length());
//						if(!cuentaCargoBD.equals(cuentaCargoObtenida))
//							valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
//						break;	
//					case "Cuenta de Destino" :
//						if(!TransferenciasExteriorBE.strTIPO_CAMBIO.equals(valor))
//							valoresDiferentes=valoresDiferentes+"- TIPO DE CAMBIO esperado: "+TransferenciasExteriorBE.strTIPO_CAMBIO+" ,obtenido: "+valor+"\n";
//						break;
					
					case "Descripción":
						if(!TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA.equals(valor))
							valoresDiferentes=valoresDiferentes+"- Descripción esperado: "+TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
						break;
						
					case "Monto a Transferir":
						//valor=objObjetosGenerales.formatearMonto(AutorizacionPorPortabilidadBL.GstrLBL_TIPO_OPERACION,valor);
						if(!Mdl_Variables.Gstr_strNewMonto.equals(valor))
							valoresDiferentes=valoresDiferentes+"- Monto a Transferir esperado: "+Mdl_Variables.Gstr_strNewMonto+" ,obtenido: "+valor+"\n";
						break;	
						
					
				}
				j++;
				campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div[2]/div/p["+j+"]/span");
			}
				
		}

	}
	
	
	
	public String obtenerCuentaCargo() throws InterruptedException, IOException
	{	
		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[1]/div/div[3]/p");
		
	}
	public String obtenerCuentaAbono() throws InterruptedException, IOException
	{	
		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[1]/div/div[3]/p");
		
	}

	public void registrarDatosConsultar(Map<String, String> mapDatosConsultar, String lstrRUTA) throws SQLException, IOException{
		// TODO Auto-generated method stub
		
		insertarRegistros(mapDatosConsultar,mapDatosConsultar.get("ID_CASO_LOGIN_CARGO"),mapDatosConsultar.get("CMB_EMPRESA_CARGO"),
				mapDatosConsultar.get("CMB_TIPO_PRODUCTO_CARGO") ,mapDatosConsultar.get("LNK_NUMERO_CUENTA_CARGO"),mapDatosConsultar.get("CMB_MONEDA_CARGO"),lstrRUTA,"Cargo");
		String cuentaAbono=mapDatosConsultar.get("NUMERO_CUENTAS_ABONO");
		if(cuentaAbono!=null){
			int numCuentasAbono=Integer.parseInt(cuentaAbono);
			if(numCuentasAbono>0){
				for(int i=0;i<numCuentasAbono;i++){
					String id=mapDatosConsultar.get("ID_CASO_LOGIN_ABONO_"+i);
					String empresa=mapDatosConsultar.get("CMB_EMPRESA_ABONO_"+i);
					String tipo=mapDatosConsultar.get("CMB_TIPO_PRODUCTO_ABONO_"+i);
					String cuenta=mapDatosConsultar.get("LNK_NUMERO_CUENTA_ABONO_"+i);
					String moneda=mapDatosConsultar.get("CMB_MONEDA_ABONO_"+i);
					insertarRegistros(mapDatosConsultar,id,empresa,tipo,cuenta,moneda,lstrRUTA,"Abono");
				}
			}
		}
	}

	private void insertarRegistros(Map<String, String> mapDatosConsultar, String idLogin, String empresa, String tipoProducto, String numCuenta, String moneda,String lstrRUTA,String tipoOperacion) throws SQLException, IOException{
		// TODO Auto-generated method stub
		String campo_TXT_MENSAJE_CORREO="AUTOMATIZADO - Consulta Saldos Portabilidad - Nro Caso: "+mapDatosConsultar.get("ID_CASO_LOTE");
		String campo_TXT_MENSAJE_CORREO_MOVIMIENTOS="AUTOMATIZADO - Movimientos Portabilidad - Nro Caso: "+mapDatosConsultar.get("ID_CASO_LOTE");
		String campoTIE="";
		String campoClave="";
		
		objConexionSqlServer.listaTablaIdCaso("Select * from CONSULTA_SALDOS_PORTABILIDAD where ID_CASO_LOTE="+mapDatosConsultar.get("ID_CASO_LOTE") 
			+" and TABLA_CARGA='"+mapDatosConsultar.get("TABLA_CARGA")+"' and LNK_NUMERO_CUENTA='"+numCuenta+"'","",5);
		if (Mdl_Variables.Grst_NuevaTabla.next()==true) 							
    	{	
			objConexionSqlServer.updateTablaQuery("update CONSULTA_SALDOS_PORTABILIDAD set OPERACION_FECHA='"+mapDatosConsultar.get("OPERACION_FECHA")+"' , "
					+ "OPERACION_HORA='"+mapDatosConsultar.get("OPERACION_HORA")+"' where ID_CASO="	+Mdl_Variables.Grst_NuevaTabla.getInt("ID_CASO"));
    	}else{
			objConexionSqlServer.listaTablaIdCaso("Select * from APP_AND_LOGIN_D where ID_CASO="+idLogin,"",5);
			while (Mdl_Variables.Grst_NuevaTabla.next()==true) 							
	    	{	
				campoTIE=Mdl_Variables.Grst_NuevaTabla.getString("TXT_NUM_TARJETA") ;
				campoClave=Mdl_Variables.Grst_NuevaTabla.getString("TXT_CLAVE") ;
	    	}				
			objConexionSqlServer.insertCampo("INSERT INTO CONSULTA_SALDOS_PORTABILIDAD "
					+ "(RUTA,TIE, CLAVE, BTN_SIGUIENTE, BTN_SIGUIENTE1, BTN_CONSULTA_SALDOS, CMB_EMPRESA, "
					+ "BTN_ENVIAR_EMAIL, TXT_CORREO, TXT_MENSAJE_CORREO, BTN_ENVIAR_CORREO, BTN_CERRAR_CORREO, "
					+ "LNK_NUMERO_CUENTA, BTN_SELECCIONAR_CUENTA,TIPO_OPERACION,CMB_MONEDA, BTN_ENVIAR_EMAIL_MOVIMIENTOS,TXT_CORREO_MOVIMIENTOS, "
					+ "TXT_MENSAJE_CORREO_MOVIMIENTOS, BTN_ENVIAR_CORREO_MOVIMIENTOS, BTN_CERRAR_CORREO_MOVIMIENTOS,BTN_CERRAR_SESION,"
					+ "CICS, ID_CASO_LOTE, "
					+ "TABLA_CARGA, OPERACION_FECHA, "
					+ "OPERACION_HORA, ID_CASO_LOGIN, "
					+ "CMB_TIPO_PRODUCTO, UTILIZADO_CICS) "
					+ "VALUES "
					+ "('"+lstrRUTA+"','"+campoTIE+"','"+campoClave+"',"+"'CLICK','CLICK','CLICK','"+empresa+"',"
					+ "'CLICK','"+Mdl_Variables.Gstr_Parametros[3] +"','"+campo_TXT_MENSAJE_CORREO+"','CLICK','CLICK','"
					+ numCuenta+"','CLICK','"+tipoOperacion+"','"+ moneda+"','CLICK','"+Mdl_Variables.Gstr_Parametros[3] +"','"
					+ campo_TXT_MENSAJE_CORREO_MOVIMIENTOS+"','CLICK','CLICK','CLICK','"
					+ mapDatosConsultar.get("CICS")+"','"+mapDatosConsultar.get("ID_CASO_LOTE") +"','"
					+ mapDatosConsultar.get("TABLA_CARGA")+"','"+mapDatosConsultar.get("OPERACION_FECHA") +"','"
					+ mapDatosConsultar.get("OPERACION_HORA")+"','"+ idLogin+"','"
					+ tipoProducto+"','"+mapDatosConsultar.get("UTILIZADO_CICS") +"')");
    	}
	}

	public void verificarMensaje() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String mensaje72HBD="(*) "+Mdl_Variables.Gstr_Parametros[15];
		String mensaje72H=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div[2]/p");
		if(!mensaje72HBD.equals(mensaje72H)){			
			System.out.println("Caso: "+TransferenciasExteriorBE.GstrID_CASO+" Mensaje72 esperado: "+mensaje72HBD+" ,obtenido: "+mensaje72H);
		}else{
			System.out.println("Caso: "+TransferenciasExteriorBE.GstrID_CASO+"Mensaje72 ok en portabilidad");
		}
	}
}
