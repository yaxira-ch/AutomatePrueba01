package proxim.bl;

import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class ConsultaPedidosMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
		
		String strCuentas="Cuentas";//""
		String strNumeroCCI="NÚMERO CCI";//""
		String urlCmbEmpresa="empresaCombo";
		String urlCmbProducto="productoCombo";
		String urlCmbTipo="tipoCombo";	
		String urlCmbCargoAbono="cargoAbonoCombo";
		String urlBtnAdjunarArchivo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[17]/tbody/tr/td[2]/form/input";
		String urlBtnAdjunarArchivoOtro="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[14]/tbody/tr/td[2]/form/input";
		String urlCmbTipoPoder="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[5]/tbody/tr/td[2]/select";
		String urlCmbDeCuando="deCuandoCombo";
		String urlTxtFechaOperacion="fechaProcesarOperacion";
		String urlTxtFechaCargo="fechaCargo";
		String urlTxtFechaHecho="fechaHecho";
		String urlCmbCuenta="cuentaCombo";
		String urlTxtComentario="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[16]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/textarea";
		String urlLnkAdjuntar="aquí.";
		String urlTxtCorreo="correoElectronicoText";		
		String urlTxtTelefono="telefonoText";
		String urlRutaArchivo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[10]/tbody/tr/td[2]/form/input";
		String urlCmbDocumento="tipoDocumentoCombo";//sprint10
		String urlTxtNumeroCheque="numeroDeChequeTextBox";//sprint10
		String urlTxtImporteCheque="importeText";//sprint10
		String urlCmbMonedaCheque="monedaCombo";//sprint10
		String urlTxtTIEAfectada="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[12]/tbody/tr/td[2]/input";
		String urlLnkAdjuntarInconv="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[14]/tbody/tr/td[2]/form/input";
		String urlCmbModuloWeb="moduloWebCombo";
		String urlBtnEnviar="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/button";
		String strCadena="\\";
		String strRetencionesJudiciales="Retenciones judiciales";
		String strInconvenientesWeb="Inconvenientes con la web";
		String strObtenido=" ,obtenido: ";
		String strTabla="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div/div/div[5]/div/div/table";
		
		public boolean seleccionarEmpresa(String strEmpresa) {  
		  return objObjetosGenerales.selectByText(ObjetosGenerales.name, urlCmbEmpresa,strEmpresa);
		 }
		
		public boolean verificarProducto() {
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.name,urlCmbProducto );
		}
		
		public boolean seleccionarProducto(String strProducto) {  
			return objObjetosGenerales.selectByText(ObjetosGenerales.name, urlCmbProducto,strProducto);
		}
		
		public boolean seleccionarTipo(String strTipo) {  
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbTipo ,strTipo);
		}

		public boolean ingresoAqui()  { 
		    return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[3]/tbody/tr/td[2]/div/div/a");
		}
			
		public boolean comboVerificar(String strCmbProducto)  { 
			boolean resultado;
			boolean blnResultadoFinal=false;
			resultado=objObjetosGenerales.visibleElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[3]/tbody/tr/td[2]/div/select");
			if(((strCmbProducto.isEmpty()||strCmbProducto.equals("Elige el tipo de producto")||strCmbProducto.equals(strCuentas))&&resultado)||  ((strCmbProducto.equals("Tarifario")||strCmbProducto.equals("Otros"))&&resultado==false)){
				blnResultadoFinal=true;
			}
			return blnResultadoFinal;
		}
		
		public boolean comboConData(String strValoresCombo)  { 
			boolean resultado=false;
			String strCombo="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[3]/tbody/tr/td[2]/div/select";
			List<WebElement> allOptions=objObjetosGenerales.selectAllElementCombo(ObjetosGenerales.xpath, strCombo);
																										    
			if ((strValoresCombo.equals("SI")&&allOptions.size()>1)||(strValoresCombo.equals("NO")&& allOptions.size()==1)) {
				resultado=true;
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strCombo); 
			}else{
				resultado=true;
			}
			
			return resultado;
		}
		
		public boolean seleccionarCargoAbono(String strCargoAbono) {  
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbCargoAbono ,strCargoAbono);
		 }
		public boolean seleccionarTipoPoder(String strTipoPoder) {  
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbTipoPoder ,strTipoPoder);
		 }
		public boolean seleccionarDeCuando(String strDeCuando) {  
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbDeCuando ,strDeCuando);
		 }
		public String obtenerTituloPopup() {
			return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr/td/span");
		 }
		public String obtenerMensajePopup() {
			return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div");
		 }
		public boolean ingresoCerrarPopup() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
		}
		  
		public boolean ingresoAquiPopup() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/a");
		}
		  
		public String obtenerTituloRedireccion(String strObjeto) throws InterruptedException {
			String texto="";
			if(strObjeto.equals("CMB_PRODUCTO")){
					Thread.sleep(10000);
					String oldTab=Mdl_Variables.Gwed_Driver.getWindowHandle();
					ArrayList<String> tabs= new ArrayList<String>(Mdl_Variables.Gwed_Driver.getWindowHandles());
					tabs.remove(oldTab);
					Mdl_Variables.Gwed_Driver.switchTo().window(tabs.get(0));
					texto=Mdl_Variables.Gwed_Driver.getCurrentUrl();		
					Mdl_Variables.Gwed_Driver.switchTo().window(oldTab);
			}else if (strObjeto.equals("CMB_DE_CUANDO") ){
				texto=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[1]/div/li[1]/a");				
			}
			return texto;
		 }
		
		public boolean ingresarFechaOperacion(String strFechaOperacion,String strTipo,String strCmbProducto) throws InterruptedException { 
			String strNewRuta="";
			if(strCmbProducto.equals(strCuentas)) {
				if(strTipo.equals(strRetencionesJudiciales)){
					strNewRuta=urlTxtFechaCargo;
				}else{
					strNewRuta=urlTxtFechaOperacion;
				}
			}else {
				strNewRuta=urlTxtFechaHecho; 
			}
			return objObjetosGenerales.setText(ObjetosGenerales.name,strNewRuta , strFechaOperacion);
		 }
		
		public boolean ingresarFechaHecho(String strFechaHecho) throws InterruptedException  {
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtFechaHecho , strFechaHecho);
		}
		
		public boolean seleccionarCuenta(String strCuenta) {  
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbCuenta ,strCuenta);
		}
		
		public boolean ingresarComentario(String strComentario) throws InterruptedException { 
			return objObjetosGenerales.setText(ObjetosGenerales.xpath,urlTxtComentario , strComentario);
		}
		 
		public boolean seleccionarAdjuntar() {  
			return objObjetosGenerales.clickBoton(ObjetosGenerales.linkText,urlLnkAdjuntar);
		}
		
		public boolean ingresarCorreo(String strCorreo) throws InterruptedException { 
			return objObjetosGenerales.setText(ObjetosGenerales.name, urlTxtCorreo, strCorreo);
		}
		
		public boolean ingresarTelefono(String strTelefono) throws InterruptedException { 
			return objObjetosGenerales.setText(ObjetosGenerales.name, urlTxtTelefono, strTelefono);
		}
		
		public boolean ingresoEnviar() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,urlBtnEnviar );
		}
		
		public boolean ingresoClicProducto() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.name, urlCmbProducto);
		}
		
		public boolean ingresoClicTipo() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.name, urlCmbTipo);
		}
		
		public boolean ingresoClicDocumento() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.name, urlCmbDocumento);
		}
		
		public String obtenerResultadoEsperado() {
			return objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[1]/span");
		}
		
		public boolean ingresoBotonNuevaConsulta() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[3]/button");
		}
		
		public boolean evaluarInicioPopup(String strObjeto, String strValor) { 
			boolean bIniciar = false;
			
			if(strObjeto.equals("CMB_DE_CUANDO") && strValor.toLowerCase().equalsIgnoreCase("MENOR A 6 MESES") ){
				bIniciar = true;}
			if(strObjeto.equals("CMB_TIPO_PODER") && strValor.toLowerCase().equalsIgnoreCase("PODERES A TRAVÉS DE LA BANCA POR INTERNET") ){
				bIniciar = true;}
		    if(strObjeto.equals("CMB_PRODUCTO") && strValor.toLowerCase().equalsIgnoreCase("TARIFARIO") ){
				bIniciar = true;}
		    if(strObjeto.equals("CMB_TIPO") &&( strValor.toLowerCase().equalsIgnoreCase(strNumeroCCI)||strValor.equalsIgnoreCase("Quiero saber el código SWIFT") ) ){
		    	bIniciar = true;}
		    return bIniciar;
		}
		
		public String obtenerMensajeError(String seccion) {
			String strMensaje = "";
			switch (seccion){
			case "CMB_EMPRESA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[1]/tbody/tr/td[1]/div[1]/span[2]");
				break;
			case "CMB_TIPO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[3]/tbody/tr/td[1]/div/span[2]");
				break;
			case "CMB_CARGO_ABONO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[7]/tbody/tr/td[1]/div/span[2]");
				break;
			case "TXT_FECHA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[8]/tbody/tr/td[1]/div/span[2]");
				break;
			case "CMB_DE_CUANDO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[6]/tbody/tr/td[1]/div/span[2]");
				break;
			case "CMB_TIPO_PODER":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[5]/tbody/tr/td[1]/div/span[2]");
				break;
			case "CMB_CUENTA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[11]/tbody/tr/td[1]/div/span[2]");
				break;
			case "TXT_COMENTARIO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[12]/tbody/tr/td[1]/div/span[2]");
				break;
			case "TXT_CORREO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[14]/tbody/tr/td[1]/div/span[2]");
				break;			
			case "TXT_TELEFONO":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[14]/tbody/tr/td[1]/div/span[2]");
				break;
			case "TXT_NUMERO_CHEQUE":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "yyy");
				break;
			case "CMB_MONEDA":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "yyy");
				break;
			case "TXT_IMPORTE":
				strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "yyy");
				break;
			default:
			    break;
			}
			return strMensaje;			
		}
		
		
		public String verificarExiste() {
			String camposNoExisten="";
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[1]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL EMPRESA
				camposNoExisten += "Etiqueta Empresa,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.name, urlCmbEmpresa)){ //OBJETO EMPRESA
				camposNoExisten += "Objeto Empresa,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[2]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL PRODUCTO
				camposNoExisten += "Etiqueta Producto,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.name, urlCmbProducto)){ //OBJETO PRODUCTO
				camposNoExisten += "Objeto Producto,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[3]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL TIPO SOLICITUD
				camposNoExisten += "Etiqueta Tipo,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.name, urlCmbTipo)){ //OBJETO TIPO SOLICITUD
				camposNoExisten += "Objeto Tipo,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[6]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL CARGO O ABONO
				camposNoExisten += "Etiqueta Cargo o Abono,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, urlCmbCargoAbono)){ //OBJETO CARGO O ABONO
				camposNoExisten += "Objeto Cargo o Abono,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[4]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL TIPO PODER
				camposNoExisten += "Etiqueta Tipo Poder,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, urlCmbTipoPoder)){ //OBJETO TIPO PODER
				camposNoExisten += "Objeto Tipo Poder,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[5]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL DE CUANDO
				camposNoExisten += "Etiqueta De Cuando,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, urlCmbDeCuando)){ //OBJETO DE CUANDO
				camposNoExisten += "Objeto De Cuando,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[7]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL FECHA DE OPERACION
				camposNoExisten += "Etiqueta Fecha de Operacion,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.name, urlTxtFechaOperacion)){ //OBJETO FECHA DE OPERACION
				camposNoExisten += "Objeto Fecha de Operacion,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[8]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL CUENTA
				camposNoExisten += "Etiqueta Cuenta,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.name, urlCmbCuenta)){ //OBJETO CUENTA
				camposNoExisten += "Objeto Cuenta,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[9]/tbody/tr/td[1]/div[1]/span[3]")){ //LABEL COMENTARIO
				camposNoExisten += "Etiqueta Comentario,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, urlTxtComentario)){ //OBJETO COMENTARIO
				camposNoExisten += "Objeto Comentario,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.linkText,urlLnkAdjuntar)){ //OBJETO LINK ADJUNTAR
				camposNoExisten += "Objeto Link Adjuntar,";	}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath,urlRutaArchivo)){ //BTN ADJUNTAR
				camposNoExisten += "Objeto Botón Adjuntar,";	}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[11]/tbody/tr/td[1]/div/span[3]")){ //LABEL CORREO = TELEFONO
				camposNoExisten += "Etiqueta Contacto,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.name, urlTxtCorreo)){ //OBJETO CORREO
				camposNoExisten += "Objeto Correo,";			}			
			if(!objObjetosGenerales.existElement(ObjetosGenerales.name, urlTxtTelefono)){ //OBJETO TELEFONO
				camposNoExisten += "Objeto Telefono,";			}
			if(!objObjetosGenerales.existElement(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/div/a")){ //OBJETO ENVIAR
				camposNoExisten += "Objeto Enviar";			}
			return camposNoExisten;
		}
			
		public boolean ingresarRutaTxt(String strDescripcion,String strTipoOperacion) throws InterruptedException, AWTException  {	
			if(strTipoOperacion.equals(strInconvenientesWeb)){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,urlBtnAdjunarArchivoOtro );	
			}else{
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,urlBtnAdjunarArchivo );	
			}
			
			Thread.sleep(500);
			StringSelection ss=new StringSelection(strDescripcion);
			Thread.sleep(500);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Thread.sleep(500);
			Robot robot = new Robot();
			Thread.sleep(500);
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(50);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(50);
			robot.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(50);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(50);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(50);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(50);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);
			return true;
		}

		public String obtenerCamposDeResultado(String campo,String strTipo,String strCmbProducto) {
			String strResultado = "";
			try{
				switch (campo){
					case "CMB_EMPRESA":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[2]");
						break;
					case "CMB_PRODUCTO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[4]");
						break;
					case "CMB_TIPO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[6]");
						break;																 
					case "CMB_CARGO_ABONO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[14]");
						break;
					case "TXT_FECHA":	
						if(strCmbProducto.equals(strCuentas)) {
							if(strTipo.equals(strRetencionesJudiciales)){//Fecha de cargo
								strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[22]");
							}else{
								strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[16]");
							}
						}else {
							strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[26]");
						}
						break;

					case "CMB_CUENTA":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[32]");
						Mdl_Variables.map.put("GstrCMB_CUENTA", strResultado);
						break;	
					case "TXT_COMENTARIO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/pre/span");
						break;	
					case "RUTA_ARCHIVO":
						if(strTipo.equals(strInconvenientesWeb)){
							strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[28]");
						}else{
							strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[35]");
						}
						break;	
					case "TXT_CORREO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[37]");
						break;													            		
					case "TXT_TELEFONO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[38]");
						break;
					case "CMB_TIPO_PODER":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[10]");
						break;
					case "CMB_DOCUMENTO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[8]");
						break;
					case "CMB_DE_CUANDO":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[12]");
						break;
					
					case "TXT_NUMERO_CHEQUE":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[18]");
						break;
					case "TXT_IMPORTE":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[20]");
						break;
					case "CMB_MODULO_WEB":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[30]");
						break;
					case "TXT_TIE_AFECTADA":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[24]");
						break;
					case "RUTA_ARCHIVO_INCONV":
						strResultado = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div/div[2]/span[28]");
						break;
					 default:
						    break;

				}
			}
			catch(Exception e){				
				return "";	
			}
			return strResultado;	
		}
		
		public String obtenerCamposret(String campo) {
			String strPrimerValor= campo.substring(0, 6);
			int intNumeroTotal=campo.length();
			String strSegundoValor=campo.substring(11,intNumeroTotal);
			 return strPrimerValor+"*****"+strSegundoValor;
		}
		public boolean comparaMensaje(String strDocumento,String strColumna) {  
			String strMensaje; 
			boolean resultado=false;
			
			if(strColumna.equals("LNB_CONTACTO")) {
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[14]/tbody/tr/td[1]/div/div");
					if( objFuncionesGenerales.compararTextosIguales(strMensaje,strDocumento.replace(" \r\n", "\n")) )
						resultado=true;
			}else if (strColumna.equals("LBN_LINK")) {
					strMensaje = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/table[3]/tbody/tr/td[2]/div/div");
					if(strMensaje.equals( strDocumento)){
						resultado=true;
					}
			}
			return resultado;
		 }
		
		public boolean seleccionarDocumento(String strDocumento) {  
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbDocumento ,strDocumento);
		}
		
		public boolean ingresarNumeroCheque(String strNumeroCheque) throws InterruptedException { 
			return objObjetosGenerales.setText(ObjetosGenerales.name,urlTxtNumeroCheque , strNumeroCheque);
		}
		
		public boolean ingresarImporte(String strImporteCheque) throws InterruptedException { 
			return objObjetosGenerales.setText(ObjetosGenerales.name,urlTxtImporteCheque , strImporteCheque);
		}
		
//		public boolean ingresarImporte(String strImporte) throws InterruptedException { 
//			return objObjetosGenerales.setText(ObjetosGenerales.name,urlTxtImporte , strImporte);z
//		}
		
		public boolean ingresarMoneda(String strMonedaCheque) { 
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbMonedaCheque , strMonedaCheque);
		}
		
//		public boolean ingresarMonedaDietario(String strMonedaDietario) { z
//			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,urlCmbMonedaDietario , strMonedaDietario);
//		}

		//-------------------------------------------------CUNSULTA HISTÓRICA------------------------------
		
		public boolean seleccionarPestanha() {		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div/div/li[2]/a" );
		}
		
		public boolean seleccionarEmpresaConsultaHistorica(String strEmpresa) { 
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/select", strEmpresa);
		}	
		
		public int seleccionarSolicitudProcesada(String strProducto,String strTipo, String strSubTipo) {
			String strFecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());	 
		
			String strNuevoTipo="";
			if(strProducto.equals("Tarifario")||strProducto.equals("Otros")){
				strNuevoTipo="-";
			}else{
				if (!strSubTipo.equals("")){
					strNuevoTipo=strTipo+" / "+strSubTipo;
				}else{
					strNuevoTipo=strTipo;
				}
			}
			
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
			int intNumeroRegistro=0;
			
			for (int j = 1;j<=num.size();j++){
				List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				String strNewFecha=colss.get(1).getText();
				String strNewProducto=colss.get(2).getText();
				String strNewNuevoTipo=colss.get(3).getText();
				
				if((objFuncionesGenerales.compararTextosIguales(strNewFecha, strFecha)&&//FECHA	
						objFuncionesGenerales.compararTextosIguales(strNewProducto, strProducto) &&//PRODUCTO
						objFuncionesGenerales.compararTextosIguales(strNewNuevoTipo, strNuevoTipo))){//TIPO
					intNumeroRegistro=j;
					break; 	
				}
			}
			return intNumeroRegistro;
		}
		
		public boolean verificarPopUp(){		
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div");
		}
		
		
		public boolean verificarTabla() {		
			return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, strTabla);
		}
		
		public boolean verDetalleProcesada(int intNumeroRegistro) {
			WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath(strTabla));
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+intNumeroRegistro+"]/td")));
			colss.get(0).click();
			return true;
		}
		
		public String verificarDetalleConsultaHistoricaPopUp(String strCmbProductoBD)  {
			String valor;
			String strNewValor;
			String strCmbEMPRESA =Mdl_Variables.map.get("GstrCMB_EMPRESA");
			String strCmbPRODUCTO =Mdl_Variables.map.get("GstrCMB_PRODUCTO");
			String strCmbTIPO =Mdl_Variables.map.get("GstrCMB_TIPO");
			String strCmbDOCUMENTO =Mdl_Variables.map.get("GstrCMB_DOCUMENTO");
			String strCmbDeCUANDO =Mdl_Variables.map.get("GstrCMB_DE_CUANDO");
			String strTxtFecha =Mdl_Variables.map.get("GstrTXT_FECHA");
			String strTxtNumeroCHEQUE =Mdl_Variables.map.get("GstrTXT_NUMERO_CHEQUE");
			String strTxtImporte =Mdl_Variables.map.get("GstrTXT_IMPORTE");
			String strCmbMoneda =Mdl_Variables.map.get("GstrCMB_MONEDA");
			String strTxtCOMENTARIO =Mdl_Variables.map.get("GstrTXT_COMENTARIO");
			String strRutaARCHIVO =Mdl_Variables.map.get("GstrRUTA_ARCHIVO");
			String strTxtCORREO =Mdl_Variables.map.get("GstrTXT_CORREO"); 
			String strTxtTELEFONO = Mdl_Variables.map.get("GstrTXT_TELEFONO");
			String strRutaArchivoINCONV= Mdl_Variables.map.get("GstrRUTA_ARCHIVO_INCONV");
			String strCmbModuloWEB = Mdl_Variables.map.get("GstrCMB_MODULO_WEB");
			String strTxtTieAFECTADA = Mdl_Variables.map.get("GstrTXT_TIE_AFECTADA");
			//String strTxtFechaHECHO = Mdl_Variables.map.get("GstrTXT_FECHA_HECHO");
			
			String valoresDiferentes="";
			
			//FECHA 
			
			if(strCmbEMPRESA!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/span[2]");
				if(!strCmbEMPRESA.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrCMB_EMPRESA esperado: "+strCmbEMPRESA+strObtenido+valor+"\n";
			}

			if(strCmbPRODUCTO!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/span[2]");
				if(!strCmbPRODUCTO.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrCMB_PRODUCTO esperado: "+strCmbPRODUCTO+strObtenido+valor+"\n";
			}
			
			if(strCmbTIPO!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[5]/span[2]");
				if(!strCmbTIPO.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrCMB_TIPO esperado: "+strCmbTIPO+strObtenido+valor+"\n";
			}
			
			if(strCmbDOCUMENTO!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[8]/span[2]");
				
				if(!strCmbDOCUMENTO.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrCMB_DOCUMENTO esperado: "+strCmbDOCUMENTO+strObtenido+valor+"\n";
			}
						
			if(strCmbDeCUANDO!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[10]/span[2]");
				if(!strCmbDeCUANDO.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrCMB_DE_CUANDO esperado: "+strCmbDeCUANDO+strObtenido+valor+"\n";
			}
			
			if(strTxtFecha!=null && !strCmbTIPO.equals(strRetencionesJudiciales)){
				if (strCmbProductoBD.equals(strCuentas)) {
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[9]/span[2]");
				}else {
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[16]/span[2]");
				}
				if(!strTxtFecha.equals(valor)) {
					valoresDiferentes=valoresDiferentes+"- GstrTXT_FECHA esperado: "+strTxtFecha+strObtenido+valor+"\n";
				}
			}
			
			if(strTxtNumeroCHEQUE!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[11]/span[2]");
				if(!strTxtNumeroCHEQUE.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrTXT_NUMERO_CHEQUE esperado: "+strTxtNumeroCHEQUE+strObtenido+valor+"\n";
			}
			
			if(strTxtImporte!=null && strCmbMoneda!=null){//+++++  5,000,000.00 Soles
				DecimalFormat decimalFormat=new DecimalFormat("#.00");
				strNewValor=  decimalFormat.format(Double.parseDouble(strTxtImporte)).replace(',', '.') +" "+strCmbMoneda;
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[12]/span[2]").replace(",", "");
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrTXT_IMPORTE esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			
			if(strTxtCOMENTARIO!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[19]/div/pre/span");
				if(!strTxtCOMENTARIO.equals(valor))						
					valoresDiferentes=valoresDiferentes+"- GstrTXT_COMENTARIO esperado: "+strTxtCOMENTARIO+strObtenido+valor+"\n";
			}
			
			if(strRutaARCHIVO!=null){//+++++ 
				if(strCmbTIPO!=null){
					if(strCmbTIPO.equals(strInconvenientesWeb)){
						valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[17]/span[2]");
					}else{
						valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[20]/span[2]");
					}
				}else{
					valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[20]/span[2]");
				}

				String strTextoBD = '"'+strRutaARCHIVO.substring(strRutaARCHIVO.lastIndexOf(strCadena)+1,strRutaARCHIVO.length())+'"';
				if(!strTextoBD.equals(valor)){
					valoresDiferentes=valoresDiferentes+"- GstrRUTA_ARCHIVO esperado: "+strTextoBD +",obtenido: "+valor+"\n";
				}
			}

			if(strRutaArchivoINCONV!=null){//+++++ 
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[17]/span[2]");
				 String strTextoBD = '"'+strRutaArchivoINCONV.substring(strRutaArchivoINCONV.lastIndexOf(strCadena)+1,strRutaArchivoINCONV.length())+'"';
				if(!strTextoBD.equals(valor)){
					valoresDiferentes=valoresDiferentes+"- GstrRUTA_ARCHIVO esperado: "+strTextoBD +",obtenido: "+valor+"\n";
				}
			}
			
			if(strTxtCORREO!=null||strTxtTELEFONO!=null){//+++++  123456789, enrique.mejia@avantica.net
				strNewValor=strTxtTELEFONO+", "+strTxtCORREO;
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[21]/span[2]");
				if(!strNewValor.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrTXT_CORREO esperado: "+strNewValor+strObtenido+valor+"\n";
			}
			// inicio sp22
			if(strCmbModuloWEB!=null){//+++++
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[14]/span[2]");
				if(!strCmbModuloWEB.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrCMB_MODULO_WEB esperado: "+strCmbModuloWEB+strObtenido+valor+"\n";
			}
			
			if(strTxtTieAFECTADA!=null){//+++++
				String strNewTie=obtenerCamposret(strTxtTieAFECTADA) ;
				valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[15]/span[2]");
				if(!strNewTie.equals(valor))
					valoresDiferentes=valoresDiferentes+"- GstrTXT_TIE_AFECTADA esperado: "+strNewTie+strObtenido+valor+"\n";
			}
			return valoresDiferentes;
		}
		
		public boolean cerrarPopUp() { 
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");
		}

		public boolean ingresarTIEAfectada(String strTIEAfectada) throws InterruptedException {
			return objObjetosGenerales.setText(ObjetosGenerales.xpath, urlTxtTIEAfectada , strTIEAfectada);
		}

		public boolean seleccionarAdjuntarInconv() {
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,urlLnkAdjuntarInconv);
		}

		public boolean seleccionarModuloWeb(String strModuloWeb) {
			return objObjetosGenerales.selectByText(ObjetosGenerales.name,urlCmbModuloWeb , strModuloWeb);
		}

		
}