package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.RegistroAfiliadosPagosBE;
import proxim.dao.Mdl_Variables;


public class PagosMasivosAdministracionAfiliadosMantenimientoMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	boolean blnResultadoEsperado=true;
	
	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{			
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[1]/div/li[2]/a");
	}
	
	public boolean seleccionarEmpresa(String LstrEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select",LstrEmpresa);
	}
	
	public boolean seleccionarProducto(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/select",LstrProducto);
	}
	
	public boolean seleccionarServicio(String LstrServicio) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",LstrServicio);
	}
	
	public boolean ingresoBotoOpcionesAvanzadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/a/img");		
	}
	
	public boolean ingresoBotonOpcAvanzadas() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[4]/a/img");		
	}

	public boolean seleccionarBuscarPor(String LstrParametroBusq) throws InterruptedException, IOException{		
		if (LstrParametroBusq.equals("DNI")|| LstrParametroBusq.equals("Carnet de Extranjería")|| LstrParametroBusq.equals("RUC")){
			LstrParametroBusq="Documento de Identidad";
		}
		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[1]/tbody/tr/td[2]/select",LstrParametroBusq);
	}
	
	public boolean seleccionarTipoDocumento(String LstrTipoDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/select",LstrTipoDocumento);
	}
	
	public boolean ingresarNumeroDocumento(String LstrNumeroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/input",LstrNumeroDocumento);
	}
	
	public boolean ingresarNombre(String LstrNombre) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[3]/tbody/tr/td[2]/table/tbody/tr/td/input",LstrNombre);
	}
	
	public boolean ingresarRazonSocial(String LstrRazonSocial) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[4]/tbody/tr/td[2]/table/tbody/tr/td/input",LstrRazonSocial);
	}
	
	public boolean ingresarCorreo(String LstrRazonSocial) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input",LstrRazonSocial);
	}
	
	public boolean ingresarMensaje(String LstrRazonSocial) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea",LstrRazonSocial);
	}
	
	public boolean ingresoBotonPagina(String strPagina) throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorGrillaPaginacion']/div[2]/a[strPagina]");		
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	
	public boolean verificartablaBusqueda() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div[5]/div/div/table");
	}
	
	public boolean verificarMensaje()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]");
	}
	
	public boolean verificarMensajeResultadoBusqueda()throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div/div[3]/div");
	}
	
	public boolean ingresoBotonEliminar() throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
//			String strCodigoBeneficiario=colss.get(2).getText();
//			String strNombreBeneficiario=colss.get(3).getText();
//			String strTipDocBeneficiario=colss.get(4).getText();
//			String strNumDocBeneficiario=colss.get(5).getText();
//			String strDireccionBeneficiario=colss.get(6).getText();
//			String strTipCueSolBeneficiario=colss.get(7).getText();
//			String strNumCueSolValBeneficiario1=colss.get(8).getText();
//			String strNumCueSolValBeneficiario2=colss.get(9).getText();
//			String strTipCueDolBeneficiario=colss.get(10).getText();
//			String strNumCueDolValBeneficiario1=colss.get(11).getText();
//			String strNumCueDolValBeneficiario2=colss.get(12).getText();
//			String strTipPerBeneficiario=colss.get(13).getText();
			
			if (colss.get(2).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO)){// &&//CodigoProveedor
//					colss.get(3).getText().equals(PagosMasivosAfiliadosBL.GstrTXT_NOMBRE_RAZON_SOCIAL)&&//Nombre
//					colss.get(4).getText().equals(PagosMasivosAfiliadosBL.GstrCMB_DOCUMENTO_IDENTIDAD)&&//tipoDoc
//					colss.get(5).getText().equals(PagosMasivosAfiliadosBL.GstrTXT_DOCUMENTO_IDENTIDAD)&&//numDoc
//					colss.get(6).getText().equals(PagosMasivosAfiliadosBL.GstrTXT_DIRECCION)){//Direccion
//					colss.get(7).getText().equals(PagosMasivosAfiliadosBL.GstrCMB_TIPO_CUENTA_SOLES)&&//CuentaSoles
//					(colss.get(8).getText().equals(PagosMasivosAfiliadosBL.GstrTXT_NUMERO_CUENTA_SOLES)||colss.get(9).getText().equals(PagosMasivosAfiliadosBL.GstrTXT_NUMERO_CUENTA_SOLES) )&&
//					colss.get(10).getText().equals(PagosMasivosAfiliadosBL.GstrCMB_TIPO_CUENTA_DOLARES) &&//CuentaDolares
//					(colss.get(11).getText().equals(PagosMasivosAfiliadosBL.GstrTXT_NUMERO_CUENTA_DOLARES)||colss.get(12).getText().equals(PagosMasivosAfiliadosBL.GstrTXT_NUMERO_CUENTA_DOLARES)) &&//CCIDolares
//					colss.get(13).getText().equals(PagosMasivosAfiliadosBL.GstrCMB_TIPO_PERSONA) ){//TipoPersona
				colss.get(1).click();
				blnResultadoEsperado = true;
				break;
			}
		}
		return blnResultadoEsperado;
	}
	
	public boolean ingresoBotonEditar() throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if (colss.get(2).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO)&&//CodigoProveedor
				colss.get(3).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL)&&//Nombre
				colss.get(4).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD)&&//tipoDoc
				colss.get(5).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD)&&//numDoc
				colss.get(6).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION)&&//Direccion
				colss.get(7).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES)&&//CuentaSoles
				(colss.get(8).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES)||colss.get(9).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES) )&&
				colss.get(10).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES)&&//CuentaDolares
				(colss.get(11).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES)||colss.get(12).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES) )&&//CCIDolares
				colss.get(13).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA) ){//TipoPersona
				colss.get(0).click();
				blnResultadoEsperado = true;
				break;
			}
		}
		return blnResultadoEsperado;
	}
	
	public boolean VerificarUsuario() throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if(RegistroAfiliadosPagosBE.GstrBTN_NO_POP_UP_ELIMINAR.equals("CLICK")&&
				colss.get(2).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO) &&//CodigoProveedor
				colss.get(3).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL) &&//Nombre
				colss.get(4).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD) &&//tipoDoc
				colss.get(5).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD) &&//numDoc
				colss.get(6).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION) &&//Direccion
				colss.get(7).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES) &&//CuentaSoles
				(colss.get(8).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES)||colss.get(9).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES) )&&
				colss.get(10).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES) &&//CuentaDolares
				(colss.get(11).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES)||colss.get(12).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES) )&&//CCIDolares
				colss.get(13).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA) ){//TipoPersona
					colss.get(1).click();
					blnResultadoEsperado = true;
					break;
				
			}else if(RegistroAfiliadosPagosBE.GstrBTN_SI_POP_UP_ELIMINAR.equals("CLICK")){
				blnResultadoEsperado=true;
					if (colss.get(2).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO) &&//CodigoProveedor
						colss.get(3).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL) &&//Nombre
						colss.get(4).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD) &&//tipoDoc
						colss.get(5).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD) &&//numDoc
						colss.get(6).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION) &&//Direccion
						colss.get(7).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES) &&//CuentaSoles
						(colss.get(8).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES)||colss.get(9).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES) )&&
						colss.get(10).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES) &&//CuentaDolares
						(colss.get(11).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES)||colss.get(12).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES) )&&//CCIDolares
						colss.get(13).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA) ){//TipoPersona
						colss.get(1).click();
						blnResultadoEsperado = false;
						break;
					}
				}
			}
		return blnResultadoEsperado;
	}
	
	public boolean ingresoModificacion() throws InterruptedException, IOException{		
WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if(RegistroAfiliadosPagosBE.GstrBTN_NO_POP_UP_MODIFICAR.equals("CLICK")&&
				colss.get(2).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO) &&//CodigoProveedor
				colss.get(3).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL) &&//Nombre
				colss.get(4).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD) &&//tipoDoc
				colss.get(5).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD) &&//numDoc
				colss.get(6).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION) &&//Direccion
				colss.get(7).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES) &&//CuentaSoles
				(colss.get(8).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES)||colss.get(9).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES) )&&
				colss.get(10).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES) &&//CuentaDolares
				(colss.get(11).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES)||colss.get(12).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES)) &&//CCIDolares
				colss.get(13).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA) ){//TipoPersona
				colss.get(1).click();
				blnResultadoEsperado = true;
				break;
			}else{
				if(RegistroAfiliadosPagosBE.GstrBTN_SI_POP_UP_MODIFICAR.equals("CLICK")&&
					colss.get(2).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO) &&//CodigoProveedor
					colss.get(3).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL_EDIT) &&//Nombre
					colss.get(4).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD_EDIT) &&//tipoDoc
					colss.get(5).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD_EDIT) &&//numDoc
					colss.get(6).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION_EDIT) &&//Direccion
					colss.get(7).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES_EDIT) &&//CuentaSoles
					(colss.get(8).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES_EDIT)||colss.get(9).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES_EDIT) )&&
					colss.get(10).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES_EDIT) &&//CuentaDolares
					(colss.get(11).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES_EDIT)||colss.get(12).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES_EDIT) )&&//CCIDolares
					colss.get(13).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA_EDIT) ){//TipoPersona
					colss.get(1).click();
					blnResultadoEsperado = true;
					break;
				}
			}
		}
		return blnResultadoEsperado;
	}
	
	public boolean VerificarAfiliado() throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				if (colss.get(2).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO) &&//CodigoProveedor
					colss.get(3).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL) &&//Nombre
					colss.get(4).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD) &&//tipoDoc
					colss.get(5).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD) &&//numDoc
					colss.get(6).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION) &&//Direccion
					colss.get(7).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES) &&//CuentaSoles
					(colss.get(8).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES)||colss.get(9).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES) )&&
					colss.get(10).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES) &&//CuentaDolares
					(colss.get(11).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES)||colss.get(12).getText().equals(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES) )&&//CCIDolares
					colss.get(13).getText().equals(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA) ){//TipoPersona
					//colss.get(1).click();
					blnResultadoEsperado = true;
					break;
				}
			}
		return blnResultadoEsperado;
	}
	
	public boolean ingresoBotonSI() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/a/img");		
	}
	
	public boolean ingresoBotonNO() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[2]/a/img");		
	}
	
	public boolean ingresoBotonEnviar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	}
	
	public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[4]/a");		
	}
	
	public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[5]/a");		
	}
	
	public boolean ingresoLnikImprimir() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[6]/a");		
	}
	public boolean ingresoLinkEnvioCorreo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[1]/a");		
	}

	
	public boolean ingresoBotonEditarAfiliado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	}
	
	public boolean seleccionarRegistroAfiliado(String strCodigoAfiliado, int nColumBusq,int nColumSelec) throws InterruptedException, IOException
	{	
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size();
		for (int j = 1;j<=numero-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if (colss.get(nColumBusq).getText().equals(strCodigoAfiliado) ){
				colss.get(nColumSelec).click();
				blnResultadoEsperado = true;
				break;
			}
		}
		return blnResultadoEsperado;
	}
	
	public boolean verificarNoExisteData(){	
		try {
			Mdl_Variables.Gwed_Driver.getPageSource().contains("Lo sentimos, no tenemos información registrada para tu consulta");
			blnResultadoEsperado=true;
		} catch (Exception e) {
			blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}
	
	//------------------OBTENIENDO DATOS DEL REGISTRO DETALLADO---------------------
	
	public String obtenerEmpresa_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[1]/div/span[2]");
	}
	
	public String obtenerProducto_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div/span[2]");
	}
	
	public String obtenerServicio_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[3]/div/span[2]");
	}
	
	public String obtenerCodigo_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[1]/tbody/tr/td[2]/input");
	}
	
	public String obtenerTipoPersona_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[2]/tbody/tr/td[2]/select");
	}
	
	public String obtenerNombreRazon_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[3]/tbody/tr/td[2]/input");
	}
	
	public String obtenerTipoDocumento_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td[1]/select");
	}
	
	public String obtenerNumeroDocumento_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td[2]/input");
	}
	
	public String obtenerDireccion_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[5]/tbody/tr/td[2]/input");
	}
	
	public String obtenerEmail_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[6]/tbody/tr/td[2]/input");
	}
	
	public String obtenerTipoAbonoSoles_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select");
	}
	
	public String obtenerTipoCuentaSoles_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[4]/td/select");
	}
	
	public String obtenerMontoLimiteSoles_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input");
	}
	
	public String obtenerNumeroCuentaSoles_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/input");
	}
	
	public String obtenerTipoAbonoDolar_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select");
	}
	
	public String obtenerTipoCuentaDolar_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[4]/td/select");
	}
	
	public String obtenerMontoLimiteDolar_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input");
	}
	
	public String obtenerNumeroCuentaDolar_Edit() throws InterruptedException, IOException{		
		return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/input");
	}
	
	public boolean ingresoBotonRegresar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/div[5]/a");		
	}
	
	
	//------------------EDITANDO REGISTRO ---------------------
	
		
		public boolean seleccionarTipoPersona_Edit(String strTipoPersona) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[2]/tbody/tr/td[2]/select",strTipoPersona);
		}
		
		public boolean ingresarNombreRazon_Edit(String strNombreRazon) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[3]/tbody/tr/td[2]/input",strNombreRazon);
		}
		
		public boolean seleccionarTipoDocumento_Edit(String strTipoDocumento) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td[1]/select",strTipoDocumento);
		}
		
		public boolean ingresarNumeroDocumento_Edit(String strNumeroDocumento) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td[2]/input",strNumeroDocumento);
		}
		
		public boolean ingresarDireccion_Edit(String strDireccion) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[5]/tbody/tr/td[2]/input",strDireccion);
		}
		
		public boolean ingresarEmail_Edit(String strEmail) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[6]/tbody/tr/td[2]/input",strEmail);
		}
		
		public boolean seleccionarTipoAbonoSoles_Edit(String strTipoAbonoSoles) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select",strTipoAbonoSoles);
		}
		
		public boolean seleccionarTipoCuentaSoles_Edit(String strTipoCuentaSoles) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[4]/td/select",strTipoCuentaSoles);
		}
		
		public boolean ingresarMontoLimiteSoles_Edit(String strMontoLimiteSoles) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input",strMontoLimiteSoles);
		}
		
		public boolean ingresarNumeroCuentaSoles_Edit(String strNumeroCuentaSoles) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/input",strNumeroCuentaSoles);
		}
		
		public boolean seleccionarTipoAbonoDolar_Edit(String strTipoAbonoDolares) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select",strTipoAbonoDolares);
		}
		
		public boolean seleccionarTipoCuentaDolar_Edit(String strTipoCuentaDolares) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[4]/td/select",strTipoCuentaDolares);
		}
		
		public boolean ingresarMontoLimiteDolar_Edit(String strMontoLimiteDolares) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/input",strMontoLimiteDolares);
		}
		
		public boolean ingresarNumeroCuentaDolar_Edit(String strNumeroCuentaDolares) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/input",strNumeroCuentaDolares);
		}

		//--------------------------------------------------------------------------------------------------------------
		
		public boolean ingresoBotonModificar() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/a/img");		
		}
		
		public boolean ingresoBotonSI_Edit() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='gwt-DialogBox']/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/a/div/img");		
		}

		public boolean ingresoBotonNO_Edit() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='gwt-DialogBox']/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[2]/div/a/div/img");		
		}
		
		public boolean ingresoLinkEmail() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[1]/a");		
		}

		public boolean ingresarNombreEmail_Edit(String strNombreEmail) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='gwt-DialogBox']/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input",strNombreEmail);
		}
		
		public boolean ingresarMensajeEmail_Edit(String strMensajeEmail) throws InterruptedException, IOException{		
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//div[@class='gwt-DialogBox']/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea",strMensajeEmail);
		}
		
		public boolean ingresoEnviarEmail_Edit() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='gwt-DialogBox']/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");
		}
		
		public String obtenerMensajeFront(String strColumna,int nSeccion) throws InterruptedException, IOException{	
			
			String texto = "<IGNORE>";
			if(nSeccion == 1) //seccion busqueda
			{ 	
				texto= "";
				switch (strColumna){
					case "CMB_EMPRESA":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_PRODUCTO":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_SERVICIO":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_DOCUMENTO_IDENTIDAD":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[2]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "TXT_DOCUMENTO_IDENTIDAD":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[2]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "TXT_NOMBRE":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[3]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "TXT_RAZON_SOCIAL":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[2]/div[5]/table[4]/tbody/tr/td[1]/div[1]/span[2]");
						break;
				}
			}
			if(nSeccion == 2) //seccion EDITAR
			{	
				texto= "";
				switch (strColumna){
					case "CMB_TIPO_PERSONA_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[2]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "TXT_NOMBRE_RAZON_SOCIAL_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[3]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_DOCUMENTO_IDENTIDAD_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[4]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "TXT_DOCUMENTO_IDENTIDAD_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[4]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_TIPO_ABONO_SOLES_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_TIPO_CUENTA_SOLES_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "TXT_NRO_CUENTA_SOLES_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[7]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_TIPO_ABONO_DOLAR_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "CMB_TIPO_CUENTA_DOLAR_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[1]/div[1]/span[2]");
						break;
					case "TXT_NRO_CUENTA_DOLAR_EDIT":
						texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//div[@class='contenedorPrincipal']/div[1]/div[1]/div[2]/div/div[3]/div/table[8]/tbody/tr/td[1]/div[1]/span[2]");
						break;
				}
			}
			
			return texto;
		}
		
		
		
		
}
