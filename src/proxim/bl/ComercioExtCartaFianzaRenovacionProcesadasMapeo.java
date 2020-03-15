package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ComercioExtCartaFianzaGeneralBE;
import proxim.be.ComercioExtCartaFianzaRenovacionBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ComercioExtCartaFianzaRenovacionProcesadasMapeo {
	
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	
	String xpathMenu="//html/body/div[2]/div[2]/div/ul/li[6]/a/span";
	String xpathSubMenu="//html/body/div[2]/div[2]/div/ul/li[6]/div/div/ul/li[3]/div/ul/li[2]/a/span";
	String xpathExitMenu="//html/body/div[2]/div[1]/div[2]/div[2]/ul/li";
	String xpathCmbEmpresa="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select";
	String xpathTxtNumeroCartaFianza="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/input";
	String xpathTxtFechaDesde="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input";
	String xpathTxtFechaHasta="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input";
	String xpathCmbEstadoOperacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td[2]/select";
	String xpathBtnBuscar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/a";
	String xpathTblCartaFianza="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div/div/div[5]/div/div/table";
	String xpathLnkEnviarEmailDetalle="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[1]/a";
	String xpathLnkExportarExcelDetalle="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[4]/a";
	String xpathLnkExportarPDFDetalle="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[5]/a";
	String xpathLnkImprimirDetalle="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[6]/a";
	String xpathLnkRegresarTabla="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/a";
	String xpathBtnContinuar1="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/a";
	String xpathLblNumCartaFianzaEnvio="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[1]/div/span[2]";
	String xpathLblNombreAfianzadoEnvio="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[2]/div/span[2]";
	String xpathLblNombreBeneficiarioEnvio="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[4]/div/span[2]";
	String xpathLblMontoEnvio="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[6]/div/span[2]";
	String xpathLblPlazoFechaVencEnvio="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[7]/div/span[2]";
	String xpathTxtumeroDiasNuevo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/input";
	String xpathTxtFechaHastaNuevo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div/div/input";
	String xpathTxtInformacionContacto="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[2]/table[2]/tbody/tr/td[3]/table/tbody/tr[1]/td/input";
	String xpathBtnContinuar2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[4]/a/div";
	String xpathLblNumCartaFianzaEnvio2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[2]/div/span[2]";
	String xpathLblNombreAfianzadoEnvio2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[3]/div/span[2]";
	String xpathLblNombreBeneficiarioEnvio2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[5]/div/span[2]";
	String xpathLblMontoEnvio2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[7]/div/span[2]";
	String xpathLblPlazoFechaVencEnvio2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[8]/div/span[2]";
	String xpathLblPlazoFechaVencNuevoEnvio2="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[9]/div/span[2]";
	String xpathTxtClaveDinamica="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[5]/input";
	String xpathLnkQuieresSaberComo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[4]/a";
	String xpathBtnCerrarQuieresSaberComo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[3]/a";
	String xpathBtnConfirmar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[7]/a[1]";
	String xpathBtnCancelaroperacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[1]/div[7]/a[2]";
	String xpathLblNumCartaFianzaConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[1]/div/span[2]";
	String xpathLblNombreAfianzadoConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[2]/div/span[2]";
	String xpathLblNombreBeneficiarioConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[4]/div/span[2]";
	String xpathLblMontoConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[6]/div/span[2]";
	String xpathLblPlazoFechaVencConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[7]/div/span[2]";
	String xpathLblPlazoFechaVencNuevoConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[8]/div/span[2]";
	String xpathLblFechaSolicitudConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[9]/div/span[2]";
	String xpathLblEmailConfirmacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[3]/div[12]/span";
	String xpathLnkEnviarEmail="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[7]/div/div[1]/a";
	String xpathTxtCorreo="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input";
	String xpathTxtMensaje="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea";
	String xpathBtnEnviarEmail="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a";
	String xpathBtnAceptarEnviarEmail="//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a";
	String xpathLnkExportarExcel="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[7]/div/div[4]/a";
	String xpathLnkExportarPDF="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[7]/div/div[5]/a";
	String xpathLnkImprimir="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[7]/div/div[6]/a";
	String xpathLnkRegresar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[6]/a";
	String xpathLblOperacion="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[2]/div[2]/span[2]";
	String xpathLblOperacionFecha="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[2]/div[3]/span[2]";
	String xpathLblOperacionHora="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[2]/div[4]/span[2]";
	
	public boolean seleccionarMenu() throws InterruptedException, IOException{		
		return objObjetosGenerales.moveToElement(xpathMenu);
	}	
	
	public boolean seleccionarSubMenu() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathSubMenu);
	}
	
	public boolean salirMenu() throws InterruptedException, IOException{		
		return objObjetosGenerales.moveToElement(xpathExitMenu);
	}

	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, xpathCmbEmpresa,strEmpresa);
	}

	public boolean ingresarNumeroCartaFianza(String strNumeroCartaFianza) throws InterruptedException, IOException{
		objObjetosGenerales.waitBy(ObjetosGenerales.xpath,xpathTxtNumeroCartaFianza);
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtNumeroCartaFianza , strNumeroCartaFianza);
	}

	public boolean ingresarFechaDesde(String strFechaDesde) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtFechaDesde , strFechaDesde);
	}

	public boolean ingresarFechaHasta(String strFechaHasta) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtFechaHasta , strFechaHasta);
	}

	public boolean seleccionarEstadoOperacion(String strEstadoOperacion) throws InterruptedException, IOException{
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, xpathCmbEstadoOperacion,strEstadoOperacion);
	}

	public boolean buscarCartaFianza() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnBuscar);
	}

	public boolean verificarTablaCartaFianza() throws InterruptedException, IOException{
		return objObjetosGenerales.waitBy(ObjetosGenerales.xpath, xpathTblCartaFianza);
	}

	public boolean seleccionarCartaFianza() throws InterruptedException, IOException{
		boolean bandera=false;
		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		String beneficiarioBD="";
		
		if(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.length()>17){
			beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.substring(0,16);
		}else{
			beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO;
		}
		
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String beneficiarioTabla="";	
			if(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){				
				if(colss.get(3).getText().length()>17){
					beneficiarioTabla=colss.get(3).getText().substring(0,16);
				}else{
					beneficiarioTabla=colss.get(3).getText();
				}				
			}else{
				if(colss.get(4).getText().length()>17){
					beneficiarioTabla=colss.get(4).getText().substring(0,16);
				}else{
					beneficiarioTabla=colss.get(4).getText();
				}
			}
				
			if(beneficiarioTabla.equals(beneficiarioBD)){
				//String monto=formatearMonto(ComerExtCartaFianzaSolicitudBL.GstrTXT_MONTO);
				if(colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)||colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){
					bandera=true; 								
				}
			}
			
			if(bandera){
				colss.get(0).click();
			}
				
		}

		return bandera;
	}

	public boolean continuarEnvio() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnContinuar1);
	}

	public boolean verDetalleLoteEnviar() throws InterruptedException, IOException{
		boolean bandera=false;
		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		String beneficiarioBD="";
		
		if(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.length()>17){
			beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO.substring(0,16);
		}else{
			beneficiarioBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO;
		}
		
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String beneficiarioTabla="";	
			if(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){				
				if(colss.get(3).getText().length()>17){
					beneficiarioTabla=colss.get(3).getText().substring(0,16);
				}else{
					beneficiarioTabla=colss.get(3).getText();
				}				
			}else{
				if(colss.get(4).getText().length()>17){
					beneficiarioTabla=colss.get(4).getText().substring(0,16);
				}else{
					beneficiarioTabla=colss.get(4).getText();
				}
			}
				
			if(beneficiarioTabla.equals(beneficiarioBD)){
				//String monto=formatearMonto(ComerExtCartaFianzaSolicitudBL.GstrTXT_MONTO);
				if(colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)||colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){
					bandera=true; 								
				}
			}
			
			if(bandera){
				colss.get(1).click();
			}
				
		}

		return bandera;
	}
	
	/*private String formatearMonto(String monto) {
		double prueba2=new Double(monto);
		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		simbolo.setGroupingSeparator(',');
		simbolo.setDecimalSeparator('.');
		DecimalFormat formatea=new DecimalFormat("###,###.##",simbolo);
		monto=formatea.format(prueba2);
		if(monto.indexOf(".")!=-1){
			int decimales=(monto.substring(monto.indexOf(".")+1,monto.length())).length();
			if(decimales==1)
				monto=monto+"0";
		}else
			monto=monto+".00";
		if(ComerExtCartaFianzaSolicitudBL.GstrCMB_MONEDA.equals("Soles"))
			monto="S/ "+monto;
		else
			monto="US$ "+monto;
		return monto;
	}*/

	public boolean ingresoLinkEnviarEmailDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkEnviarEmailDetalle);	
	}

		public boolean ingresoLinkExportarExcelDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkExportarExcelDetalle);	
	}

	public boolean ingresoLinkExportarPDFDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkExportarPDFDetalle);	
	}

	public boolean ingresoLinkImprimirDetalle() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkImprimirDetalle);	
	}
	
	public boolean regresarTablaCartaFianza() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkRegresarTabla);
	}

	public String verificarDatosEnvio() throws InterruptedException, IOException{
		String DatosDiferentes="";
		
		String lStrNumCartaFianza=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNumCartaFianzaEnvio);
		String lStrNombreAfianzado=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNombreAfianzadoEnvio);
		String lStrNombreBeneficiario=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNombreBeneficiarioEnvio);
		String lStrMonto=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblMontoEnvio);
		String lStrPlazoFechaVenc=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblPlazoFechaVencEnvio);
		
		String nombreAfianzadoBD="";
		if(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO!=null)
			nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO;
		else
			nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_CAMBIO_NOMBRE_AFIANZADO;
		
		String PlazoFechaVencBD="";
		if(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS!=null)
			PlazoFechaVencBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS;
		else
			PlazoFechaVencBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA;
		
		if(!lStrNumCartaFianza.contains(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_CARTA_FIANZA)){
			DatosDiferentes=DatosDiferentes+lStrNumCartaFianza+"\n";
		}if(!lStrNombreAfianzado.equals(nombreAfianzadoBD)){
			DatosDiferentes=DatosDiferentes+lStrNombreAfianzado+"\n";
		}if(!lStrNombreBeneficiario.equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)){
			DatosDiferentes=DatosDiferentes+lStrNombreBeneficiario+"\n";
		}if(!lStrMonto.equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_MONTO)){
			DatosDiferentes=DatosDiferentes+lStrMonto+"\n";
		}if(!lStrPlazoFechaVenc.contains(PlazoFechaVencBD)){
			DatosDiferentes=DatosDiferentes+lStrPlazoFechaVenc+"\n";
		}
		
		return DatosDiferentes;
	}
	
	public boolean ingresarNumeroDiasNuevo(String strNumeroDiasNuevo) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtumeroDiasNuevo , strNumeroDiasNuevo);
	}

	public boolean ingresarFechaHastaNuevo(String strFechaHastaNuevo) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtFechaHastaNuevo , strFechaHastaNuevo);
	}

	public boolean ingresarInformacionContacto(String strTxtInformacionContacto) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtInformacionContacto , strTxtInformacionContacto);
	}

	public boolean continuarEnvio2() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnContinuar2);
	}

	public String verificarDatosEnvio2() throws InterruptedException, IOException{
		String DatosDiferentes="";
		
		String lStrNumCartaFianza=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNumCartaFianzaEnvio2);
		String lStrNombreAfianzado=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNombreAfianzadoEnvio2);
		String lStrNombreBeneficiario=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNombreBeneficiarioEnvio2);
		String lStrMonto=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblMontoEnvio2);
		String lStrPlazoFechaVenc=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblPlazoFechaVencEnvio2);
		String lStrPlazoFechaVencNuevo=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblPlazoFechaVencNuevoEnvio2);
		
		String nombreAfianzadoBD="";
		if(objFuncionesGenerales.verificarIgnore(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO))
			nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO;
		else
			nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO;
		
		String PlazoFechaVencBD="";
		/*if(objFuncionesGenerales.verificarIgnore(ComerExtCartaFianzaSolicitudBL.GstrTXT_PLAZO_DIAS))
			PlazoFechaVencBD=ComerExtCartaFianzaSolicitudBL.GstrTXT_PLAZO_DIAS;
		else
			PlazoFechaVencBD=ComerExtCartaFianzaSolicitudBL.GstrTXT_PLAZO_FECHA;*/
		PlazoFechaVencBD=ComercioExtCartaFianzaGeneralBE.GstrLBN_FECHA_VENCIMIENTO;
		
		String PlazoFechaVencNuevoBD="";
		if(objFuncionesGenerales.verificarIgnore(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO))
			PlazoFechaVencNuevoBD=ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO+" días - ";
		else
			PlazoFechaVencNuevoBD=" días - "+ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO;
		
		if(!lStrNumCartaFianza.contains(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_CARTA_FIANZA)){
			DatosDiferentes=DatosDiferentes+lStrNumCartaFianza+"\n";
		}if(!lStrNombreAfianzado.equals(nombreAfianzadoBD)){
			DatosDiferentes=DatosDiferentes+lStrNombreAfianzado+"\n";
		}if(!lStrNombreBeneficiario.equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)){
			DatosDiferentes=DatosDiferentes+lStrNombreBeneficiario+"\n";
		}if(!lStrMonto.equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){
			DatosDiferentes=DatosDiferentes+lStrMonto+"\n";
		}if(!lStrPlazoFechaVenc.equals(PlazoFechaVencBD)){
			DatosDiferentes=DatosDiferentes+lStrPlazoFechaVenc+"\n";
		}if(!lStrPlazoFechaVencNuevo.contains(PlazoFechaVencNuevoBD)){
			DatosDiferentes=DatosDiferentes+lStrPlazoFechaVencNuevo+"\n";
		}
		
		return DatosDiferentes;
	}

	public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException
	{	
		String  strValorBoton = "";
		String  strClave = Lstr_Clave;
		String  strLetraValor = "";
		Thread.sleep(500);
		for (int i = 1;i<=strClave.length();i++)
		{
			strLetraValor = strClave.split("")[i - 1];
			Thread.sleep(500);
			for (int j = 1; j <= 10; j++)
			{
				strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).getText();

				if (strValorBoton.equals(strLetraValor))
				{
					Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).click();
					Thread.sleep(500);
					break;
				}
			}							
       }
	   return true;
	}
	
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, xpathTxtClaveDinamica, Descripcion);
	}

	public boolean ingresoLinkQuieresSaberComo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkQuieresSaberComo);		
	}
	
	public boolean cerrarLinkQuieresSaberComo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnCerrarQuieresSaberComo);		
	}
	
	public boolean ingresoBotonConfirmar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnConfirmar);		
	}
	
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnCancelaroperacion);		
	}

	public String verificarDatosConfirmacion() throws InterruptedException, IOException{

		String DatosDiferentes="";
		
		String lStrNumCartaFianza=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNumCartaFianzaConfirmacion);
		String lStrNombreAfianzado=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNombreAfianzadoConfirmacion);
		String lStrNombreBeneficiario=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblNombreBeneficiarioConfirmacion);
		String lStrMonto=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblMontoConfirmacion);
		String lStrPlazoFechaVenc=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblPlazoFechaVencConfirmacion);
		String lStrPlazoFechaVencNuevo=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblPlazoFechaVencNuevoConfirmacion);
		String lStrFechaSolicitud=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblFechaSolicitudConfirmacion);
		String lStrEmail=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblEmailConfirmacion);
		
		
		String nombreAfianzadoBD="";
		if(objFuncionesGenerales.verificarIgnore(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO))
			nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO_TERCERO;
		else
			nombreAfianzadoBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO;
		
		String PlazoFechaVencBD="";
		if(objFuncionesGenerales.verificarIgnore(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS))
			PlazoFechaVencBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS;
		else
			PlazoFechaVencBD=ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA;
		
		String PlazoFechaVencNuevoBD="";
		if(objFuncionesGenerales.verificarIgnore(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO))
			PlazoFechaVencNuevoBD=ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO;
		else
			PlazoFechaVencNuevoBD=ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO;
		
		Date fechaActual=new Date();
		DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
		String fecha= formatoFecha.format(fechaActual);
		
		if(!lStrNumCartaFianza.contains(ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_CARTA_FIANZA)){
			DatosDiferentes=DatosDiferentes+lStrNumCartaFianza+"\n";
		}if(!lStrNombreAfianzado.equals(nombreAfianzadoBD)){
			DatosDiferentes=DatosDiferentes+lStrNombreAfianzado+"\n";
		}if(!lStrNombreBeneficiario.equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)){
			DatosDiferentes=DatosDiferentes+lStrNombreBeneficiario+"\n";
		}if(!lStrMonto.equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){
			DatosDiferentes=DatosDiferentes+lStrMonto+"\n";
		}if(!lStrPlazoFechaVenc.contains(PlazoFechaVencBD)){
			DatosDiferentes=DatosDiferentes+lStrPlazoFechaVenc+"\n";
		}if(!lStrPlazoFechaVencNuevo.contains(PlazoFechaVencNuevoBD)){
			DatosDiferentes=DatosDiferentes+lStrPlazoFechaVencNuevo+"\n";
		}if(!lStrFechaSolicitud.equals(fecha)){
			DatosDiferentes=DatosDiferentes+fecha+"\n";
		}if(!lStrEmail.equals(ComercioExtCartaFianzaRenovacionBE.GstrTXT_CORREO_CONTACTO)){
			DatosDiferentes=DatosDiferentes+lStrEmail+"\n";
		}
		
		return DatosDiferentes;
	}

	public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkEnviarEmail);	
	}

	public boolean ingresarCorreo(String strCorreo) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtCorreo , strCorreo);
	}

	public boolean ingresarMensajeCorreo(String strMensaje) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,xpathTxtMensaje , strMensaje);
	}

	public boolean ingresoBotonEnviar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnEnviarEmail);	
	}

	public void ingresoBotonAceptarEnviar() throws InterruptedException, IOException{
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathBtnAceptarEnviarEmail);	
	}

	public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkExportarExcel);	
	}

	public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkExportarPDF);	
	}

	public boolean ingresoLinkImprimir() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkImprimir);	
	}

	public boolean ingresoLinkRegresar() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathLnkRegresar);
	}

	public boolean capturarDatos() throws InterruptedException, IOException{
		Thread.sleep(500);
		if(!ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO.equals("<IGNORE>")){
			String fecha=objObjetosGenerales.getText(ObjetosGenerales.xpath3,xpathTxtFechaHastaNuevo );
			ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO=fecha;
		}else{
			if(!ComercioExtCartaFianzaRenovacionBE.GstrTXT_FECHA_HASTA_NUEVO.equals("<IGNORE>")){
				ComercioExtCartaFianzaRenovacionBE.GstrTXT_NUMERO_DIAS_NUEVO=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathTxtumeroDiasNuevo );
			}
		}
		return true;
	}

	public void GuardarDatosOperacionAutorizar() throws InterruptedException, IOException, SQLException{
		ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblOperacion );
		ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblOperacionFecha);
		ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblOperacionHora);
		String montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,xpathLblMontoConfirmacion);
		
		int totalCadena=montoOperacion.length();
		 if(montoOperacion.contains("/")){
				Mdl_Variables.GstrTotalPagar=montoOperacion.substring(3, totalCadena);
			}else{
				Mdl_Variables.GstrTotalPagar=montoOperacion.substring(4, totalCadena);
			}
		
		objConexionSqlServer.updateTablaQuery("update APP_COMERCIO_EXT_CARTA_FIANZA_RENOVACION_D set LBN_OPERACION='"+ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+ComercioExtCartaFianzaRenovacionBE.GstrLBN_OPERACION_HORA+"' where ID_CASO="+ComercioExtCartaFianzaRenovacionBE.GstrID_CASO);
	}
	
	
	//----------------------------------------------------------------------PROCESADOS---------------------------------------------------------------------------------
	
	public boolean verificarCamposObligatoriosProcesados(){
		boolean bandera=false;
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		 } catch (Exception e) {

		 }
		 return bandera;
	 }

	 public boolean seleccionarEmpresaProcesadas(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select",LstrEmpresa);
	 }



	 public boolean ingresarFechaOperacionDesdeProcesadas(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input", Descripcion);
	 }

	 public boolean ingresarFechaOperacionHastaProcesadas(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input", Descripcion);
	 }

	 public boolean seleccionarEstadoOperacionProcesadas(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",LstrEmpresa);
	 }

	 public boolean ingresarNumeroCartaFianzaProcesadas(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td[2]/table/tbody/tr[1]/td/input", Descripcion);
	 }

	 public boolean ingresoBotonBuscarProcesadas() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	 }

	 public boolean verificarTablaProcesados(){
		 boolean bandera=false;
		 try {
			 bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div/div/div[5]/div/div/table");
		 } catch (Exception e) {

		 }
		 return bandera;
	 }
			 
	public boolean seleccionarSolicitudProcesada() throws InterruptedException, IOException{
		boolean bandera=false;
		String dias="";
		dias=ComercioExtCartaFianzaGeneralBE.GstrTXT_CAMBIO_PLAZO_FECHA+"- "+ComercioExtCartaFianzaGeneralBE.GstrTXT_CAMBIO_PLAZO_DIAS+" días";
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)||colss.get(3).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)){
				if(colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)||colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)){
					if(colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)||colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){
						if(colss.get(6).getText().equals(dias)||colss.get(7).getText().equals(dias)){
							if(colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)||colss.get(8).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)){
								bandera=true; 
								if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
									if(colss.get(1).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)){
										bandera=true; 
									}else{
										bandera=false; 
									}
								}
							}
						}
					}
				}
			}
			
			if(bandera){
				break;
			}
		}
		return bandera;
	}
				
	public boolean VerDetalleProcesada() throws InterruptedException, IOException{
		boolean bandera=false;
		String dias="";
		dias=ComercioExtCartaFianzaGeneralBE.GstrTXT_CAMBIO_PLAZO_FECHA+"- "+ComercioExtCartaFianzaGeneralBE.GstrTXT_CAMBIO_PLAZO_DIAS+" días";
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		bandera=false; 
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)||colss.get(3).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)){
				if(colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)||colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_BENEFICIARIO)){
					if(colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)||colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){
						if(colss.get(6).getText().equals(dias)||colss.get(7).getText().equals(dias)){
							if(colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)||colss.get(8).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)){
								bandera=true; 
								if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
									if(colss.get(1).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)){
										bandera=true; 
									}else{
										bandera=false; 
									}
								}
							}
						}
					}
				}
			}
			
			if(bandera){
				colss.get(0).click();
				break;
			}
		}
		return bandera;
	}
									

	public boolean ingresoLinkEnviarEmailFinalProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[1]/a");	
	 }
	 
	 public boolean ingresarCorreoFinalProcesada(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoFinalProcesada(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonEnviarFinalProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");		
	 }
	
	public boolean ingresoBotonAceptarEnviarFinalProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");		
	 }
	
		
	 public boolean ingresoLinkExportarExcelFinalProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFFinalProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirFinalProcesada() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[4]/div/div[6]/a");		
	 }
	 
	 public boolean verificarCamposObligatoriosSolicitud(){	
		 boolean bandera=false;
			try {
				bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/span[1]");
			} catch (Exception e) {
				
			}
			return bandera;
		}
	 public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
			boolean var=false;
			for(int i=1;i<=4;i++){
				String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorTabs']/li["+i+"]//a")).getText();
				
				if(LstrProducto.equals(valor) ){
					var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
					break;
				}
			}	
			return var;	
		}
	 public boolean ingresoLinkEnviarEmailFinalProcesadaTotal() throws InterruptedException, IOException{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[1]/a");	
		}

		public boolean ingresoLinkExportarExcelFinalProcesadaTotal() throws InterruptedException, IOException{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[4]/a");	
		}

		public boolean ingresoLinkExportarPDFFinalProcesadaTotal() throws InterruptedException, IOException{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[5]/a");	
		}

		public boolean ingresoLinkImprimirFinalProcesadaTotal() throws InterruptedException, IOException{
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[6]/a");	
		}

		public boolean ingresarNuevoMonto(String NuevoMonto) throws InterruptedException, IOException{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "", NuevoMonto);
		}

		public boolean ingresarNombreResponsable(String NombreResponsable) throws InterruptedException, IOException{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "", NombreResponsable);
		}

		public boolean seleccionarTipoDocumento(String TipoDocumento) throws InterruptedException, IOException{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "", TipoDocumento);
		}

		public boolean ingresarNumeroDocumento(String NumeroDocumento) throws InterruptedException, IOException{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "", NumeroDocumento);
		}
	
	//----------------------------------------------------------------------BLOQUEADOS---------------------------------------------------------------------------------

	
	
}
