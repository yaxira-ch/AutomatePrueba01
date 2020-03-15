package proxim.bl;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class pagosMasivosAdministracionTest {
	boolean bandera;

	public boolean seleccionarSubMenu(String LstrProducto) throws InterruptedException, IOException{	
		String strSubMenu="";
		String strGetSubMenu="";
		Boolean blnResultado=false;
			
		for (int i=1;i<=3;i++){
			strSubMenu="//html/body/div[2]/div[2]/div/ul/li[4]/div/div/ul/li[2]/div/ul/li["+i+"]/a";
			strGetSubMenu= ObjetosGenerales.getText(ObjetosGenerales.xpath, strSubMenu);
			if(strGetSubMenu.equals(LstrProducto)){
				blnResultado=ObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strSubMenu);
				break;
			}
		}
		return blnResultado;
	}
	
	public boolean seleccionarSubMenuPestana(String LstrProducto) throws InterruptedException, IOException{	
		String strSubMenu="";
		String strGetSubMenu="";
		Boolean blnResultado=false;

			
		for (int i=1;i<=4;i++){
			strSubMenu="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/li["+i+"]/a";
			strGetSubMenu= objObjetosGenerales.getText(ObjetosGenerales.xpath, strSubMenu);
			if(strGetSubMenu.equals(LstrProducto)){
				blnResultado=objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strSubMenu);
				break;
			}
		}
		return blnResultado;
	}
	
	
	
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "empresaCombo",LstrProducto);
	}
	

	

	
	public boolean verificarMovimientos_AND4(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarCamposObligatoriosEnvioPagos(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarCamposObligatoriosBloqueados(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarPopUp(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	
	
	
	public boolean verificarMovimientos_AND1(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	public boolean detallePagoEnviar(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean informacionCorrespondienteProveedor(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/h1[2]/span");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	
	
	public boolean verificarDetallePagoEnviar(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarConfirmacionEnvio(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[1]/span[3]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarResusltado(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/div[2]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean verificarMovimientos_AND3(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean seleccionarProducto(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "productoCombo",LstrProducto);
	}
	
	public boolean seleccionarServicio(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "servicioCombo",LstrProducto);
	}
	
	public boolean seleccionarCuentaCargo(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "cuentaCargoCombo",LstrProducto);
	}
	
	public boolean ingresarDescripcion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "nombreSolicitudText", Descripcion);
	}

	public boolean seleccionarTipoProceso(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoProcesoCombo",LstrProducto);
	}
	
	public boolean ingresarFechaDiferido(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "fechaPago", Descripcion);
	}
	
	public boolean seleccionarTipoCarga(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoCargaCombo",LstrProducto);
	}
	
	public boolean ingresarRutaTxt(String Descripcion) throws InterruptedException, IOException{	
		return  objObjetosGenerales.setTextNew(ObjetosGenerales.name, "pagoMasivo", Descripcion);
//		WebElement Operacion =Mdl_Variables.Gwed_Driver.findElement(By.name("pagoMasivo"));
//		Operacion.sendKeys(Descripcion);
	}
	
	public boolean ingresoBotoAgregar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a[2]/img");
	}
	
	public boolean ingresoBotonAceptar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/a/img");		
	}
	
    public boolean verificarMensajeLoteDuplicado() {
    boolean var=false;
	try {
		String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/span[2]")).getText();
		if(str_Mensaje.equals("Tiene un lote con características similares. ¿Desea continuar?.")){
			var= true;
		}
	} catch (Exception e) {
		var= false;
	}
	return var;
}
    
	public boolean ingresoBotonCancelar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//td[2]/div/div/table/tbody/tr/td[2]/div/a/img");		
	}
	
	public boolean ingresoBotonContinuar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a[name=\"continuarPagoDocumentosLink\"] > img");		
	}

	
	public boolean ingresoBotonGuardarFinal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Guardar\"]");		
	}

	public boolean ingresoBotonCerrarLote() throws InterruptedException, IOException{
		int montoTotal=0;
		boolean valor =true;
		String servicio = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div[3]/div[1]/div[3]/div[4]/div/span[2]")).getText();
		if(PagosMasivosAdministracionAfiliadosBE.strCmbServicio.equals(servicio))//SERVICIO
		{
			String cuentaCargo = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div[3]/div[1]/div[3]/div[7]/div/span[2]")).getText();
			if(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO.equals(cuentaCargo))//SERVICIO
			{
				//WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
				WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div[3]/div[1]/div[6]/div[2]/div/div[5]/div/div/table"));
				
				
				List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
				int numero=num.size()-2;
				for (int j = 1;j<=numero;j++)
				{
					List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
					String monto=colss.get(7).getText();
					
					
					
					String nuecadena=monto.substring(0, monto.length()-3);
					String nuecadena1="";
					if(nuecadena.indexOf(",")!=-1)
					{
						int posicion=nuecadena.indexOf(",");
						nuecadena1=nuecadena.substring(0, posicion)+nuecadena.substring(posicion+1, nuecadena.length());
					}else{
						nuecadena1=nuecadena;
					}
					
					montoTotal=montoTotal+Integer.valueOf(nuecadena1);
					
				}
				valor= objConexionSqlServer.modificarCampos(servicio,cuentaCargo,montoTotal);
				if (valor){
					valor= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[2]/div/div[3]/div/div[7]/a[2]");
				}
			}else{
				valor= false;
			}
		}else{
			valor= false;
		}
		return valor;		
		//return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "img[title=\"Cerrar \"]");		
	}

	public boolean ingresoBotonEnviarLote() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector,"a.elementosAlineados.botonGeneral > img.iconoLink");	
	}
	
	
	//---------------AFILIADOS
	
	public boolean seleccionarTipoPersona(String LstrProducto) throws InterruptedException, IOException
	{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoPersonaCombo",LstrProducto);
	}
		
	public boolean ingresarNombreRazonSocial(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "nombreText", Descripcion);
	}
	
	public boolean ingresarTextoBuscar(String Descripcion,String RdbTexto) throws InterruptedException, IOException{	
		if(RdbTexto.equals("<IGNORE>")){
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/input", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/div/input", Descripcion);
		}
		
	}
	
	public boolean ingresarCodigoBeneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "codigoText", Descripcion);
	}
	
	public boolean seleccionarDocumentoIdentidad(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "documentoIdentidadCombo",LstrProducto);
	}

	public boolean seleccionarTipoDocumentoIdentidad(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/div/select",LstrProducto);
	}
	
	public boolean ingresarDocumentoIdentidad(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "documentoIdentidadText", Descripcion);
	}
	
	public boolean seleccionarTipoAbono(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoAbonoCombo",LstrProducto);
	}

	public boolean seleccionarTipoCuenta(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoCuentaCombo",LstrProducto);
	}
	
	public boolean seleccionarMoneda(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "monedaCuentaCombo",LstrProducto);
	}
	
	public boolean seleccionarNumeroCuenta(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "numeroCuentaCombo",LstrProducto);
	}
	
	public boolean ingresarNumeroCuenta(String Descripcion,String TipoAbono) throws InterruptedException, IOException{	
		if(TipoAbono.equals("Abono en cuenta IB")){
			return objObjetosGenerales.setText(ObjetosGenerales.name, "numeroCuentaIBText", Descripcion);
		}else{
			return objObjetosGenerales.setText(ObjetosGenerales.name, "numeroCuentaCCIText", Descripcion);
		}	
	}
	
	public boolean checkIngresarNuevaCuenta() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/table[3]/tbody/tr/td[5]/table/tbody/tr/td[1]/span/input");	
		
		
	}
	
	public boolean seleccionarDocuementoPago(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "documentoPagoCombo",LstrProducto);
	}
		
	public boolean ingresarDocuementoPago(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "documentoPagoText", Descripcion);
	}
	
	public boolean ingresarFechaVencimiento(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "fechaVencimiento", Descripcion);
	}
	
	public boolean seleccionarMonedaMontoOperacion(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "monedaMontoOperacionCombo",LstrProducto);
	}
	
	public boolean ingresarMonedaMontoOperacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "monedaMontoOperacionText", Descripcion);
	}
	
	public boolean seleccionarMonedaMontoIntangible(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.name, "monedaSumaSeisUltimosSueldosCombo",LstrProducto);
	}
	
	public boolean ingresarMonedaMontoIntangible(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name, "monedaMontoSumaSeisUltimosSueldos", Descripcion);
	}

	public boolean checkPagoEfectoRetencion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.name, "afectoRetencionCheck");		
	}

	public boolean ingresoBotonGuardar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.botonContinuar.posicionBotonEstandar > img.navbarimg");		
	}

	public boolean ingresoLinkVerProveedor() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/a");		
	}
	
	public boolean ingresoRdbNombre() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span/input");		
	}
	
	public boolean ingresoRdbNumeroDocumento() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/span/input");		
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/div/div[1]/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/a/img");		
	}
	
	public boolean ingresoBotonAceptar1() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//table/tbody/tr[2]/td[2]/div/div/div[4]/a/img");		
	}
	public boolean limpiarCampo(String campoLimpiar) throws InterruptedException, IOException{
		boolean var=false;
		switch (campoLimpiar) {
		case "CMB_TIPO_PROCESO" :
			var=objObjetosGenerales.selectByText(ObjetosGenerales.name, "tipoProcesoCombo","Seleccionar");
			break;
		case "CMB_SERVICIO":
			var = objObjetosGenerales.selectByText(ObjetosGenerales.name, "servicioCombo","Seleccionar");
			break;
		case "CMB_CUENTA_CARGO":
			var = objObjetosGenerales.selectByText(ObjetosGenerales.name, "cuentaCargoCombo","Seleccionar");
			break;
		case "TXT_DESCRIPCION":
			var = objObjetosGenerales.setText(ObjetosGenerales.name, "nombreSolicitudText", "");
			break;
		default:
			break;
		}

		return var;
	}
	
	public boolean ingresoBotonAgregarNuevoTrabajador() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.elementosAlineados.botonGeneral > img.navbarimg");	
	}
	
	public boolean ingresoBotonAgregarNuevoTrabajador1() throws InterruptedException, IOException{
		//return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.elementosAlineados.botonGeneral > img.navbarimg");	
		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div/table/tbody/tr[2]/td[2]/div/div/div[2]/a[1]/img");	
		
	}
	
	
	public boolean compararMensajeError(String Lstr_TxtMensajeError,String Lstr_TxtColumnaError ) throws InterruptedException, IOException{	
		String str_Mensaje="";
		switch (Lstr_TxtColumnaError) {
			case "CMB_TIPO_PERSONA" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[1]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_NOMBRE_RAZON_SOCIAL":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[2]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_CODIGO_BENEFICIARIO":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[3]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_DOCUMENTO_IDENTIDAD":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[4]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_DOCUMENTO_IDENTIDAD":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[4]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_TIPO_ABONO" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[5]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_TIPO_CUENTA" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/table[1]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_MONEDA" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/table[2]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_NUMERO_CUENTA":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/table[3]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_NUMERO_CUENTA":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/table[3]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_DOCUMENTO_PAGO":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/div[4]/table/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_DOCUMENTO_PAGO":
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/div[4]/table/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_FECHA_VENCIMIENTO" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/div[5]/table/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "CMB_MONEDA_MONTO_OPERACION" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[6]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			case "TXT_MONEDA_MONTO_OPERACION" :
				str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/div[3]/div[2]/div[1]/table[6]/tbody/tr/td[1]/div/span[2]")).getText();
				break;
			default:
				break;
		}
		if(Lstr_TxtMensajeError.equals(str_Mensaje))
		{
			return true;
		}else{
			return false;
		}	
	}
	
	public boolean ingresoBotonContinuarNuevo() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//table/tbody/tr[2]/td[2]/div/div/div[2]/a[2]");	
		//return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "div > img.iconoLink");	
		//return objObjetosGenerales.clickBoton(ObjetosGenerales.cssSelector, "a.elementosAlineados.botonGeneral > img.iconoLink");		
	}
	

	
	public String ObtenerMensajeMontoPagoRetencion() throws InterruptedException, IOException{
		String strMensaje = "";
		strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[4]/table/tbody/tr[3]/td/table/tbody/tr/td[1]/span");
		strMensaje += " " +objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[4]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/span");
		strMensaje += " " + objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[4]/table/tbody/tr[3]/td/table/tbody/tr/td[3]/span");
		return strMensaje;
	}
	
	public String BuscarCadenaTabla(String strCadena, String seccionGrilla) throws InterruptedException, IOException{		
		int intColumna=0;

		switch (seccionGrilla) {
		case "DetallePagoEnviarMonedaOperacion":
			intColumna=6;
			break;		
		case "DetallePagoEnviarMonedaCuenta":
			intColumna=9;	
			break;		
		case "GeneralPagoEnviarMonedaCuentaCargo":
			intColumna=9;	
			
		case "DetallePagoAutorizarMonedaOperacion":
			intColumna=2;	
		case "DetallePagoProcesadosMonedaOperacion":
			intColumna=5;	
			break;		
		case "DetallePagoBloqueadosMonedaOperacion":
			intColumna=6;	
			break;	
		default:
			break;
		}
		String strTexto;
		String nuevaCadena="";
		
		WebElement tabla = null;
		tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num= null;
		num = tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int k = 1;k<=numero;k++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+k+"]/td")));
			strTexto = colss.get(intColumna).getText();
			if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
			{	
				nuevaCadena+="- "+strTexto;
			}
		}	
		return nuevaCadena;		
	}
	
	public String ObtenerTextoMontoDetalleAutorizaciones() throws InterruptedException, IOException{
		String strMensaje = "";
		strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[2]/div[8]/div[1]/span[2]");
		return strMensaje;
	}
	public String ObtenerTextoMontoDetalleProcesados() throws InterruptedException, IOException{
		String strMensaje = "";
		strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div[8]/span[2]");
		return strMensaje;
	}
	public String ObtenerTextoMontoDetalleBloqueados() throws InterruptedException, IOException{
		String strMensaje = "";
		strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div[2]/div[2]/div[8]/span[2]");
		return strMensaje;
	}

}
