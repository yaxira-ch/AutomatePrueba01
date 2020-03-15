package proxim.bl;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ComercioExtCartaFianzaGeneralBE;
import proxim.be.ComercioExtCartaFianzaRenovacionAutorizarBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;


public class ComercioExtCartaFianzaGeneralMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	boolean bandera=false;
	String strResultadoEsperado="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[1]/div/div[1]/span";	//modificado v1
	
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
	
	public boolean verificarCamposObligatoriosSolicitud() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/span[1]");
	}
	
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[2]/select",LstrProducto);
	}
	
	public boolean ingresoRDBAfianzarSI() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[1]/span/input");		
	}
	
	public boolean ingresoRDBAfianzarNO() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/span/input");		
	}
	
	public boolean ingresarNombreAfianzado(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean seleccionarDireccionViaAfianzado(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select",LstrProducto);
	}
	
	public boolean ingresarDireccionNombreAfianzado(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean ingresarDireccion_N_MZ_LOTE_Afianzado(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean ingresarDireccionInteriorAfianzado(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean ingresarDireccionUbicacionAfianzado(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean seleccionarDireccionDistritoAfianzado(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td/table/tbody/tr/td/input",LstrProducto);
	}
	
	public boolean ingresarNombreBeneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[3]/tbody/tr/td[2]/input", Descripcion);
	}
	
	public boolean seleccionarDireccionViaBeneficiario(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/select",LstrProducto);
	}																	  
	
	public boolean ingresarDireccionNombreBeneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean ingresarDireccion_N_MZ_LOTE_Beneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean ingresarDireccionInteriorBeneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean ingresarDireccionUbicacionBeneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input", Descripcion);
	}
	
	public boolean seleccionarDireccionDistritoBeneficiario(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[4]/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td/table/tbody/tr/td/input",LstrProducto);
	}
	
	public boolean ingresoUsarPlantillaEstandar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[1]/span/input");		
	}
	
	public boolean ingresoLinkPlantillaEstandar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[2]/a");		
																		
	}
	
	public boolean verificarPlantillaEstandar() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/span");
	}
	
	public boolean ingresoBotonCambioNombreBeneficiario() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[4]/span");		
	}
	
	public boolean ingresarNuevoNombreBeneficiario(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[4]/div/div[4]/input", Descripcion);
	}
	
	public boolean ingresoBotonAceptarCambioNombreBeneficiario() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[4]/div/div[5]/a/img");		
	}
	
	public boolean ingresoBotonCambioNombreAfianzado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[7]/span[2]");		
	}
	
	public boolean ingresarNuevoNombreAfianzado(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[7]/div/div[4]/input", Descripcion);
	}
	
	public boolean ingresoBotonAceptarCambioNombreAfianzado() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[7]/div/div[5]/a/img");		
	}
	
	public boolean ingresoBotonImporte() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[8]/span[2]");		
	}
	
	public boolean ingresarNuevoMonto(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[8]/div/div[4]/input", Descripcion);
	}
	
	public boolean seleccionarNuevaMoneda(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[8]/div/div[4]/select",LstrProducto);
	}
	
	public boolean ingresarObligacionesGarantizadas(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[10]/div/textarea", Descripcion);
	}
	
	public boolean ingresoBotonPlazo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[12]/span[2]");		
	}
	
	public boolean ingresarNuevoPlazoDias(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[12]/div/div[5]/input", Descripcion);
	}
	
	public boolean ingresarNuevoPlazoFechas(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[12]/div/div[5]/div/div/input", Descripcion);
	}
	
	public boolean ingresoBotonAceptarCambioPlazo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[12]/div/div[6]/a/img");		
	}
	
	public boolean ingresoBotonGuardar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[25]/a/img");		
	}
	
	public boolean ingresoBotonAceptarCambiarImporte() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div[8]/div/div[6]/a/img");		
	}
	
	public boolean ingresoAdjuntarArchivo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[4]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span/input");		
	}
	
	public boolean ingresoLinkAdjuntarArchivo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[6]/tbody/tr/td[2]/table/tbody/tr/td[4]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a");																			
	}
	
	public boolean verificarArchicoAdjunto() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/div/p/span");
	}
	
	public boolean verificarBotonContinuar() throws InterruptedException, IOException{		
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/a/img");
	}
	
	public boolean ingresoBotonSeleccionarArchivo(String Descripcion) throws InterruptedException, IOException, AWTException{
		return  objObjetosGenerales.setTextNew(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/div/form/input", Descripcion);
		
//		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/div/form/input");	
//		StringSelection ss=new StringSelection(Descripcion);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Robot robot = new Robot();
//		robot.delay(250);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.delay(50);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		return true;
	}
	
	public boolean ingresoBotonGrabar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/a/img");		
	}
	
	public boolean ingresarMonto(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/table[2]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr[1]/td/input", Descripcion);
	}
	
	public boolean seleccionarMoneda(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/table[2]/tbody/tr/td[2]/table/tbody/tr/td[3]/table/tbody/tr/td/select",LstrProducto);
	}
	
	public boolean ingresarFechaInicio(String FechaInicio) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[5]/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/div/div/input", FechaInicio);																	
	}
	
	public boolean ingresarPlazoDias(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td/input", Descripcion);																	
	}
	
	public boolean ingresarPlazoFecha(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/table[1]/tbody/tr/td[4]/table/tbody/tr[2]/td/div/div/input", Descripcion);
	}
	
	public boolean capturarDatos() throws InterruptedException, IOException{	
		Thread.sleep(500);
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='pasoOperacionPlazo']/span[3]");
		if(!ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS.equals("<IGNORE>")){
			//ComerExtCartaFianzaSolicitudBL.GstrTXT_PLAZO_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/table[2]/tbody/tr/td[4]/table/tbody/tr[2]/td/div/div/input" );
			String fecha=objObjetosGenerales.getText(ObjetosGenerales.xpath3,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/table[1]/tbody/tr/td[4]/table/tbody/tr[2]/td/div/div/input" );
			ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA=fecha;
		}else{
			if(!ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA .equals("<IGNORE>")){
				ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS=objObjetosGenerales.getText(ObjetosGenerales.xpath3,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[5]/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td/input" );
			}
		}
		return true;
	}
	
	public boolean ingresoBotonContinuar1() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/a/img");	
	}
	
	public boolean ingresoChkFirmaAutografa() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[7]/tbody/tr/td[2]/table/tbody/tr/td/span/input");		
	}
	
	public boolean ingresarNombrePersonaResponsable(String NombrePersonaResponsable) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[8]/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/input", NombrePersonaResponsable);
	}
	
	public boolean seleccionarTipoDocumento(String TipoDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[8]/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/select",TipoDocumento);
	}
	
	public boolean ingresarNroDocumento(String NroDocumento) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[8]/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr[2]/td/input", NroDocumento);

	}
	
	public boolean ingresarCorreoContacto(String Correo) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[9]/tbody/tr/td[2]/table/tbody/tr[1]/td/input", Correo);		
	}
	
	public boolean ingresoBotonContinuarReg() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/a/img");		
	}
	
	public boolean ingresoLinkRegresar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[4]/a");		
	}
	
	public boolean ingresoLinkVerDescripcion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[1]/div[3]/a");		
	}
	
	public boolean ingresoChkAceptarTerminos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.id, "gwt-uid-809");
	}
	
	public boolean chkAceptarTerminosAutorizar() throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[4]/div[1]/span/input");	                                                                	
	}
	
	public boolean ingresoLinkContrato() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[1]/div[4]/a[1]");		
	}
	
	public boolean ingresoLinkCartillaInformacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[1]/div[4]/a[2]");		
	}
	
	public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException{	
	   String  strValorBoton = "";
	   String  strClave = Lstr_Clave;
	   String  strLetraValor = "";
	   
	   for (int i = 1;i<=strClave.length();i++){
		   strLetraValor = strClave.split("")[i - 1];
		   Thread.sleep(500);
		   for (int j = 1; j <= 10; j++){
			   Thread.sleep(250);
			   strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).getText();
        
			   if (strValorBoton.equals(strLetraValor)){
				   Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).click();
				   break;
			   }
		   }
       }
	   return true;
   }
	
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[7]/input", Descripcion);																
	}

	public boolean ingresoLinkQuieresSaberComo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[1]/div[6]/a");		
	}

	public boolean ingresoBotonConfirmar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[8]/a[1]");		
	}
	
	public boolean ingresoBotonCancelarOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[1]/div[8]/a[2]");		
	}
		
	public boolean verificarResultadoEsperadoCartaFianza() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strResultadoEsperado);
	}
	
	 public boolean compararResultadoEsperado(String Lstr_TxtMensajeError) throws InterruptedException, IOException{	
		   String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,strResultadoEsperado );  
		   
		   if(str_Mensaje.equals(Lstr_TxtMensajeError))
		   {
				return true;
		   }else{
			   return false;
		   }	
	   }
	
	 public boolean compararResultadoEsperadoPositivo() throws InterruptedException, IOException{	
		   String str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[1]/div/div[1]/span" );  
		   
		   if(str_Mensaje.equals("Tu operación ha sido enviada"))
		   {
				return true;
		   }else{
			   return false;
		   }	
	   }
	 
	 public boolean buscarMensajeResultadoFinal() throws InterruptedException, IOException{
		 return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[1]/div[7]/span");
	 }
	 
	 public boolean GuardarDatosOperacionAutorizar() throws InterruptedException, IOException, SQLException{	

		 ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[1]/div/div[2]/span[2]" );
		 ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[1]/div/div[3]/span[2]" );
		 ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[1]/div/div[4]/span[2]" );
		 ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[2]/div/table/tbody/tr[8]/td[2]" );
		 ComercioExtCartaFianzaGeneralBE.GstrLBN_FECHA_VENCIMIENTO=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[2]/div/table/tbody/tr[7]/td[2]" );
		 
		 String[] part=ComercioExtCartaFianzaGeneralBE.GstrLBN_FECHA_VENCIMIENTO.split("-");
		 
		 ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS=part[0].substring(0, part[0].length()-6);
		 ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA=part[1].trim();
		 
		 String montoOperacion;

		 montoOperacion=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[2]/div/table/tbody/tr[8]/td[2]" );
		 int totalCadena=montoOperacion.length();

		 if(montoOperacion.contains("/")){
			 Mdl_Variables.GstrTotalPagar=montoOperacion.substring(3, totalCadena);
		 }else{
			 Mdl_Variables.GstrTotalPagar=montoOperacion.substring(4, totalCadena);
		 }

		 ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL=montoOperacion;

		 if(buscarMensajeResultadoFinal()){
			 ComercioExtCartaFianzaGeneralBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[1]/div[7]/span" );
		 }

		 bandera= objConexionSqlServer.updateTablaQuery("update APP_COMERCIO_EXT_CARTA_FIANZA_D set LBN_OPERACION='"+ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL+"', LBN_FECHA_VENCIMIENTO='"+ComercioExtCartaFianzaGeneralBE.GstrLBN_FECHA_VENCIMIENTO+"' where ID_CASO="+ComercioExtCartaFianzaGeneralBE.Gstr_ID_CASO);
		 return bandera;
	 }
	 
	 public boolean ingresoLnkVerDescripcionFinal() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[1]/div[3]/a");		
	 }
	 
	 public boolean ingresoLinkAgregarOperacionesFrecuentes() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[1]/div[5]/span/a");		
	 }
	 
	 public boolean ingresarDescripcionOF(String descripcion)throws InterruptedException, IOException{
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/input", descripcion);
	 }
	 
	 public boolean ingresoContinuarOperacionesFrecuentes() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[2]/div[6]/a");		
	 }
	 
	 public boolean verificarResultado() throws InterruptedException, IOException{		
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div[1]/span");
	}
	 
	 public boolean ingresoLinkCrearNuevaSolicitud() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[2]/div[7]/span/a");		
	 }
	 
	 public boolean ingresoLinkVerMisOperacionesFrecuentes() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/a");		
	 }
	 
	 public boolean seleccionarOF() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/div/div[5]/div/div/table/tbody[1]/tr[1]/td[1]/div/div/input");		
	 }
	 
	 public boolean ingresoAceptarOF() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[3]/a");		
	 }
	 
	 public boolean ingresoLinkRealizarOtraOperacion() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div[1]/div[6]/span/a");		
	 }
	 
	 public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[8]/div/div[1]/a");																			
	 }
	 
	 public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[8]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[8]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/div[2]/div[1]/div[8]/div/div[6]/a");		
	 }
	
	 
	
	//---------------------------------------------------------AUTORIZAR------------------------------------------------------------------
	 
		public boolean seleccionarEmpresaAutorizacion(String LstrProducto) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/table/tbody/tr/td[2]/select" ,LstrProducto);
		}
		
		public boolean ingresarFechaInicioAutorizacion(String Descripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/input", Descripcion);
		}
		
		public boolean ingresarFechaFinAutorizacion(String Descripcion) throws InterruptedException, IOException{	
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[2]/input", Descripcion);
		}
		
		public boolean seleccionarTipoOperacionAutorizacion(String LstrProducto) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",LstrProducto);
		}
		
		public boolean ingresoBotonBuscarAutorizacion() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/img");
		}
		
		public boolean ingresoLinkVerSolicitudesExpiradosAutorizacion() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/a");
		}
		
		public boolean ingresoLinkRegresarSolicitudesExpiradosAutorizacion() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div/div[3]/a");
		}
		
		public boolean ingresoLinkEnviarEmailAutorizacion() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[1]/a");		
	 }
	 
	public boolean verificarTablaCorreo() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]");
	}
	 
	 public boolean ingresarCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}
		
	public boolean ingresarMensajeCorreoAutorizacion(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}
		
	public boolean ingresoBotonEnviarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");		
	 }
	
	public boolean ingresoBotonAceptarAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");	
	 }
		
	 public boolean ingresoLinkExportarExcelAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDFAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimirAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[3]/div/div[6]/a");		
	 }
	 
	 public boolean ingresoLinkEnviarEmailDetalle() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[1]/a");		
	 }
	 
	 public boolean ingresoLinkExportarExcelDetalle() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[4]/a");		
	 }
		 
	 public boolean ingresoLinkExportarPDFDetalle() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[5]/a");			
	 }
		 
	 public boolean ingresoLinkImprimirDetalle() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[6]/a");		
	 }
		
	 public boolean ingresoChkTodosAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/thead/tr/th[1]/input");
	 }

	 public boolean verificarTablaAutorizacion() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table");
	 }

	 public boolean verificarDetalleLoteEnviarAutorizacion() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/span[1]");
	 }

	 public boolean ingresoBotonAutorizarAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/a[1]/div/img");
	 }

	 public boolean ingresoBotonBloquearAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[2]/a[2]/div/img");
	 }

	 public boolean ingresoLinkVerOperacionAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div/div/a");
	 }

	 public boolean descargarArchivoOperacionAutorizacion() throws InterruptedException, IOException{		
		 if (ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div/div/div[5]/div/div/table/tbody[1]/tr/td[8]/div/div[1]/img");

		 }else{
			 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[3]/div/div/div[5]/div/div/table/tbody[1]/tr/td[9]/div/div[1]/img");

		 }
	 } 
		 
	 public boolean seleccionarLoteFirmar() throws InterruptedException, IOException
		{	
		 boolean var=false;
		 try {
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			
			//String beneficiarioBD=ComerExtCartaFianzaSolicitudBL.GstrTXT_NOMBRE_BENEFICIARIO;
			
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
//					String beneficiarioTabla="";
//					
//					if(j==1)
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[5]/div/div/span");
//					else
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[5]/div/div/span");
//					
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)&&//Empresa					
						colss.get(3).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)&&//Producto
						colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
						colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)&&//Producto
						colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)&&//Compara NOMBRE PLANILLA
						colss.get(8).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)){//Compara MONTO TOTAL
						var=true;												
					}
							//}
				}else{
//					String beneficiarioTabla="";
//										
//					if(j==1)
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div/div/span");
//					else
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[4]/div/div/span");
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)&&//Producto
						colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
						colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)&&//Producto
						colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)&&//Compara NOMBRE PLANILLA
						colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION )){//Compara MONTO TOTAL
						var=true;											
					}
				}
				if(var){
					colss.get(0).click();
					break;
				}
			}

		} catch (Exception e) {
			 var=false;
		}
		 return var;
	}
		 
	 public boolean verDetalleLoteFirmar() throws InterruptedException, IOException
		{	
		 boolean var=false;
		// String beneficiarioTabla;
		 try {
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			
			//String beneficiarioBD=ComerExtCartaFianzaSolicitudBL.GstrTXT_NOMBRE_BENEFICIARIO;
						
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					
//					if(j==1)
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[5]/div/div/span");
//					else
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[5]/div/div/span");
//					
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)&&//Empresa					
						colss.get(3).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)&&//Producto
							//if ( beneficiarioTabla.equals(beneficiarioBD)){//Compara NOMBRE PLANILLA
						colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
						colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)&&//Producto
						colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)&&//Compara NOMBRE PLANILLA
						colss.get(8).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)){//Compara MONTO TOTAL
						var=true;												
					}
							//}
				}else{
//					if(j==1)
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div/div/span");
//					else
//						beneficiarioTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[4]/div/div/span");
					
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)&&//Producto
						//if (beneficiarioTabla.equals(beneficiarioBD)){//Compara NOMBRE PLANILLA
							colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
							colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)&&//Producto
							colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)&&//Compara NOMBRE PLANILLA
							colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION )){//Compara MONTO TOTAL
							var=true;											
						}
						//}
				}
				if(var){
					colss.get(1).click();
					break;
				}
			}
		} catch (Exception e) {
			 var=false;
		}
		 return var;
	}
	 
	 public boolean verificarLinkRegresar() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/a");
	 }
		 
	public boolean ingresoLinkRegresarDetalleAutorizacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/a");		
	}
		
	 public boolean descargarArchivoDescargar() throws InterruptedException, IOException
		{	
		 boolean var=false;
		 try {
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			for (int j = num.size()-2;j>=1;j--)
			{
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				
				if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)|| colss.get(3).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)){//Producto
					//if (colss.get(3).getText().equals(ComerExtCartaFianzaSolicitudBL.GstrTXT_NOMBRE_BENEFICIARIO)|| colss.get(4).getText().equals(ComerExtCartaFianzaSolicitudBL.GstrTXT_NOMBRE_BENEFICIARIO)){//Compara NOMBRE PLANILLA
						if (colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)|| colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)){//Compara MONTO TOTAL
							if (colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)|| colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)){//Producto
								if (colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)|| colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)){//Compara NOMBRE PLANILLA
									if (colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)|| colss.get(8).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)){//Compara MONTO TOTAL
										var=true;
										if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
											if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)){//Producto
												var=true;
											}else{
												var=false;
											}
										}
									}
								}
							}
						}
					//}
				}
				if(var){
					if (colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)){
						colss.get(9).click();
					}else{
						colss.get(8).click();
					}
					
					break;
				}
			}
		} catch (Exception e) {
			 var=false;
		}
		 return var;
	}
	 
	 public boolean cerrarArchivoDescargar() throws InterruptedException, IOException{
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");	
	 }
	 
	 public boolean verificarConfirmarOperacionAutorizacion() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[1]/span[3]"); 
	 }

	 public boolean ingresarClaveDinamicaAutorizacion(String strClaveDinamica) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[7]/input",strClaveDinamica);
	 }

	 public boolean ingresoLinkQuieresSaberComoAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[6]/a");		
	 }

	 public boolean ingresoBotonConfirmarAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[8]/a[1]");
	 }

	 public boolean ingresoBotonCancelarOperacionAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[1]/div[8]/a[2]");
	 }

	 public boolean verificarmensajeFinal() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/div[1]/span");
	}

	 public boolean verificarmensajeFinalAutorizar(String strEstado) throws InterruptedException, IOException{
		 if(strEstado.equals("Procesada")){
			 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[2]");
				
		 }else{
			 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[2]");
		 }
	 }																	   

	 public boolean buscarMensaje() throws InterruptedException, IOException{
		 return objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[2]");
	 }

	 public boolean compararResultadoEsperadoPositivoAutorizar(String ResultadoEsperado,String strEstado) throws InterruptedException, IOException, SQLException{	
		 String str_Mensaje ;
		 
		 if(strEstado.equals("Procesada")){
			 str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[2]" );  
		 }else{
			 str_Mensaje =objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[2]" );  
		 }
		 
		 																		  
		 if(str_Mensaje.equals(ResultadoEsperado)){
			 
			 if(strEstado.equals("Procesada")){
				 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[3]/span[2]" );
				 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[3]/span[4]" );
				 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[3]/span[6]" );

				 if(ComercioExtCartaFianzaRenovacionAutorizarBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[4]/div/div/div[5]/div/div/table/tbody[1]/tr/td[3]/div" );
				 }else{																														 
					 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[4]/div/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div" );//cuando es autorizacion GE
				 }

				 if(buscarMensaje()){
					 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[2]" );
				 }
			}else{
				 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[3]/span[2]" );
				 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_FECHA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[3]/span[4]" );
				 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_HORA=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[3]/span[6]" );

				 if(ComercioExtCartaFianzaRenovacionAutorizarBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
					 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[4]/div/div/div[5]/div/div/table/tbody[1]/tr/td[3]/div" );
				 }else{
					 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[4]/div/div/div[5]/div/div/table/tbody[1]/tr/td[4]/div" );//cuando es autorizacion GE
				 }

				 if(buscarMensaje()){
					 ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_RESULTADO_FINAL=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[4]/div[1]/div/div[2]" );
				 }
			}
			 
			 objConexionSqlServer.updateTablaQuery("update APP_COMERCIO_EXT_CARTA_FIANZA_AUTORIZAR_D set LBN_OPERACION='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION+"',LBN_OPERACION_FECHA='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_FECHA+"',LBN_OPERACION_HORA='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_OPERACION_HORA+"',LBN_MONTO_TOTAL='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_MONTO_TOTAL+"', LBN_RESULTADO_FINAL='"+ComercioExtCartaFianzaRenovacionAutorizarBE.GstrLBN_RESULTADO_FINAL+"' where ID_CASO="+ComercioExtCartaFianzaRenovacionAutorizarBE.Gstr_ID_CASO);

			 return true;
		 }else{
			 return false;
		 }	
	 }

	 public boolean ingresoLinkEnviarEmailFinalAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[1]/a");		
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

	 public boolean ingresoLinkExportarExcelFinalAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[4]/a");		
	 }

	 public boolean ingresoLinkExportarPDFFinalAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[5]/a");		
	 }

	 public boolean ingresoLinkImprimirFinalAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[2]/div/div[7]/div/div[6]/a");		
	 }

	 public boolean ingresoLinkRealizarOtraOperacionAutorizacion() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[3]/div[3]/div/a");		
	 }

	 //--------------------------------------PROCESADOS

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

	 public boolean verificarTablaProcesados() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div/div/div[5]/div/div/table");
	}
			 
	public int seleccionarSolicitudProcesada() throws InterruptedException, IOException{
		//String dias="";
		int intNumValor=0;
		//dias=ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA+"- "+ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS+" días";
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));			
			
			if ((colss.get(2).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)||colss.get(3).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA))&&
					(colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)||colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL))&&
				//	(colss.get(6).getText().equals(dias)||colss.get(7).getText().equals(dias))&& ---Descomentar cuando corrigan el hallazgo
					(colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION)||colss.get(8).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION))){
					intNumValor=j; 
					if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){
						String empresaTabla;
						if(j==1){
							empresaTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div/div/div[5]/div/div/table/tbody[1]/tr/td[2]/div/div/span");
						}else{
							empresaTabla=objObjetosGenerales.getTooltipText("xpath","//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div/div/div/div[5]/div/div/table/tbody[1]/tr["+j+"]/td[2]/div/div/span");
						}
						
						if(empresaTabla.equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA)){
							intNumValor=j; 
						}
					}
			}
			
			if(intNumValor!=0){
				break;
			}
		}
		return intNumValor;
	}
				
	public boolean VerDetalleProcesada(int intValor) {
		boolean blnResultadoEsperado=true;
		try {
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intValor+"]/td")));
			colss.get(0).click();
		} catch (Exception e) {
			blnResultadoEsperado=false;
		}
		return blnResultadoEsperado;
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
	 //--------------------------------------BLOQUEADOS
	public boolean verificarCamposObligatoriosGeneral() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]");
	 }

	 public boolean seleccionarEmpresaBloqueados(String LstrEmpresa) throws InterruptedException, IOException{		
		 return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table/tbody/tr/td[2]/select",LstrEmpresa);
	 }

	 public boolean ingresarFechaOperacionDesdeBloqueados(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input", Descripcion);
	 }

	 public boolean ingresarFechaOperacionHastaBloqueados(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input", Descripcion);
	 }

	 public boolean ingresoBotonBuscarBloqueados() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a/img");		
	 }

	 public boolean verificarTablaBloqueados() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div/div[5]/div/div/table");
	}

	 public boolean verificarDetalleBloqueados() throws InterruptedException, IOException{
		 return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/div[1]/span[1]");
	 }
			 
	 public int seleccionarSolicitudBloqueadas() throws InterruptedException, IOException{		
	 	int intNewResultado=0;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
						
			if(!ComercioExtCartaFianzaGeneralBE.GstrCMB_EMPRESA.equals("<IGNORE>")){

				if (colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
					colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)&&//Producto
					colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)&&//Compara NOMBRE PLANILLA
					colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION )&&//Compara MONTO TOTAL
					colss.get(8).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)){
					intNewResultado=j;												
				}
			}else{
				if (colss.get(3).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_MONTO_TOTAL)&&//Compara MONTO TOTAL
					colss.get(4).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_DIAS)&&//Producto
					colss.get(5).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrTXT_PLAZO_FECHA)&&//Compara NOMBRE PLANILLA
					colss.get(6).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrCMB_TIPO_OPERACION )&&//Compara MONTO TOTAL
					colss.get(7).getText().equals(ComercioExtCartaFianzaGeneralBE.GstrLBN_OPERACION_FECHA)){
					intNewResultado=j;	
				}
			}
			if(intNewResultado!=0){
				break;
			}
		}
		return intNewResultado;
	 }
				
			 
	 public boolean verSolicitudBloqueadas(int intNewResultado) {
		 boolean blnResultadoEsperado=true;
		 try {
			 WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
			 List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intNewResultado+"]/td")));
			 colss.get(0).click();
		} catch (Exception e) {
			blnResultadoEsperado=false;
		}
		 return blnResultadoEsperado;
	 }
			 
	 public boolean ingresoLinkEnviarEmailFinalBloqueadas() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[1]/a");		
	 }

	 public boolean ingresarCorreoFinalBloqueadas(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	 }

	 public boolean ingresarMensajeCorreoFinalBloqueadas(String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	 }

	 public boolean ingresoBotonEnviarFinalBloqueadas() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 }

	 public boolean ingresoLinkExportarExcelFinalBloqueadas() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[4]/a");		
	 }

	 public boolean ingresoLinkExportarPDFFinalBloqueadas() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[5]/a");		
	 }

	 public boolean ingresoLinkImprimirFinalBloqueadas() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[6]/a");		
	 }

	 public String obtenerAfianzado() throws InterruptedException, IOException{
		 // TODO Auto-generated method stub
		 return objObjetosGenerales.getText(ObjetosGenerales.xpath3, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td/input");
	 }

	public void quitarDesplegableDistrito() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/table[2]/tbody/tr/td[1]/div/span[3]");	
	}

	public boolean ingresoLinkEnviarEmailFinalProcesadaTotal() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[1]/a");	
	}

	public boolean ingresoLinkExportarExcelFinalProcesadaTotal() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[4]/a");	
	}

	public boolean ingresoLinkExportarPDFFinalProcesadaTotal() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[5]/a");	
	}

	public boolean ingresoLinkImprimirFinalProcesadaTotal() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div/div[6]/a");	
	}	
}