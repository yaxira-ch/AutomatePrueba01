package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.dao.Mdl_Variables;
	
public class PagosMasivosAdministracionAfiliadosMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean lbnResultadoFinal=true;

	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div/div[1]/div/li[1]/a");	
	}
	
	public boolean seleccionarProducto(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "productoCombo",LstrProducto);
	}
	
	public boolean ingresoBotonSiPopUp() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='adquisicionProductoBotones']/div[1]//a");		
	}
	
	public boolean ingresoBotonNoPopUp() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='adquisicionProductoBotones']/div[2]//a");		
	}
	
	public boolean compararMensajeError(String Lstr_TxtMensajeError,String Lstr_TxtColumnaError ) throws InterruptedException, IOException{	
		String str_Mensaje="";
		
		switch (Lstr_TxtColumnaError) {
			case "CMB_TIPO_PROCESO" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[6]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "BTN_SI_POP_UP":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[4]/div/table/tbody/tr[2]/td[2]/div/div/span")).getText();
				break;
			case "CMB_SERVICIO":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_CUENTA_CARGO":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_DESCRIPCION":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[5]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_FECHA_DIFERIDO" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div/div[2]/table[6]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "BTN_RUTA_ARCHIVO" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[2]/div[7]/div[1]/span[2]")).getText();
				break;
			case "BTN_ENVIAR" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/span[2]")).getText();
				break;	
			default:
				break;
		}
		return objFuncionesGenerales.compararTexto(Lstr_TxtMensajeError, str_Mensaje) ;
	}
	
	public boolean ingresoBotonAceptarPopUp() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='dialogMiddleCenterInner dialogContent']/div/div[2]//a");		
	}
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "empresaCombo",LstrProducto);
	}
	
	public boolean seleccionarServicio(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "servicioCombo",LstrProducto);
	}
	
	public boolean ingresarDescripcion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "descripcionText", Descripcion);
	}

	public boolean seleccionarTipoCarga(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoCargaCombo",LstrProducto);
	}
	
	public boolean ingresarRutaTxt(String Descripcion) throws InterruptedException, IOException{
		WebElement Operacion =Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[2]/form/input"));
		Operacion.sendKeys(Descripcion);

		return true;
	}
	
	public boolean ingresoBotoAgregar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Agregar\"]");		
	}
	
	public boolean ingresoBotonContinuar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a[name=\"continuarPagoDocumentosLink\"] > img");		
	}
	
	public boolean ingresoBotonAgregarNuevoProveedor() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img.navbarimg");		
	}
	
	public boolean ingresarCodigoBeneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "codigoText", Descripcion);
	}
	
	public boolean seleccionarTipoPersona(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoPersonaCombo",LstrProducto);
	}
	
	public boolean ingresarNombreRazonSocial(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "nombreText", Descripcion);
	}
	
	public boolean seleccionarDocumentoIdentidad(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "documentoIdentidadCombo",LstrProducto);
	}
	
	public boolean ingresarDocumentoIdentidad(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "documentoIdentidadText", Descripcion);
	}
	
	public boolean ingresarDireccion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "direccionText", Descripcion);
	}
	
	public boolean ingresarEmail(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "emailText", Descripcion);
	}
	
	public boolean seleccionarTipoAbonoSoles(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoAbonoSolesCombo",LstrProducto);
	}
	
	public boolean ingresarMontoLimiteSoles(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "montoLimiteSolesText", Descripcion);
	}
	
	public boolean seleccionarTipoCuentaSoles(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "cuentaSolesCombo",LstrProducto);
	}
	
	public boolean ingresarNumeroCuentaSoles(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "numeroCuentaSolesText", Descripcion);
	}
	
	public boolean seleccionarTipoAbonoDolares(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoAbonoDolaresCombo",LstrProducto);
	}
	
	public boolean ingresarMontoLimiteDolares(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "montoLimiteDolaresText", Descripcion);
	}
	
	public boolean seleccionarTipoCuentaDolares(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "cuentaDolaresCombo",LstrProducto);
	}
	
	public boolean ingresarNumeroCuentaDolares(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "numeroCuentaDolaresText", Descripcion);
	}
	
	public boolean ingresoBotonGuardar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonContinuar.posicionBotonEstandar > img.navbarimg");		
	}
	
	public boolean ingresoBotonContinuarNuevo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "div > img.iconoLink");		
	}
	
	public boolean ingresoBotonGuardarFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a[name=\"eliminarAfiliadosLink\"] > img");		
	}
	
	public boolean verificarBotonAgregarNuevo() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/a/img");
	}
	
	public boolean verificarBotonGuardar() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[6]/div[3]/a/img");
	}
	
	public boolean verificarBotonAgregarNuevoProveedor() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[5]/a/img");
	}
	
	public boolean verificarBotonConfirmar() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[6]/a[1]");
	}
	
	public boolean verificarBotonEnviar() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/a/img");
	}
	
	public boolean enviarAfiliados() throws InterruptedException, IOException{		
		boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if (colss.get(6).getText().equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion) ){//Compara con el nombre del LOTE
				colss.get(0).click();
				var = true;
				break;
			}
		}	
		return var;
	}
	
	public boolean enviarAfiliadosNew() throws InterruptedException, IOException{		
		boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		String strDescripcion=null;
		for (int j = 1;j<=numero;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			if (PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa.equals("<IGNORE>")){
				strDescripcion=colss.get(5).getText();
			}else{
				strDescripcion=colss.get(6).getText();
			}
			
			if (strDescripcion.equals(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion) ){//Compara con el nombre del LOTE
				colss.get(0).click();
				var = true;
				break;
			}
			
		}	
		return var;
	}
	public boolean ingresoBotonEnviarLote() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "div > img.iconoLink");		
	}
	
	public boolean ingresoBotonEnviarAfiliado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/a/img");		
	}
	
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.classname, "textoAlineado", Descripcion);
	}
	
	public boolean ingresoBotonConfirmarAfil() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[6]/a[1]");
	}
	
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonCancelarOperacion");		
	}

	public boolean verificarResultadoFinal() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li[1]/a");
	}
	
	public boolean compararMensajeResultanteAfiliado(String Lstr_TxtMensajeError) throws InterruptedException, IOException{	
		String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[1]")).getText();
		
		return objFuncionesGenerales.compararTexto(Lstr_TxtMensajeError, str_Mensaje) ;
	}
	
//	public boolean verificarLinkRechazado(){	
//		lbnResultadoFinal = false;
//		try {
//			WebElement Operacion = null;
//		} catch (Exception e) {
//				lbnResultadoFinal = false;
//			}
//		return lbnResultadoFinal;
//	}
	
	public boolean ingresoLinkRechazado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/a");		
	}
	
	public boolean verificarMensajeRechazado(){
		try {
			Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]"));
			lbnResultadoFinal=true;
		} catch (Exception e) {
				lbnResultadoFinal = false;
		}
		return lbnResultadoFinal;
	}
	
	public boolean cerrarMensajeRechazado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");		
	}
}
