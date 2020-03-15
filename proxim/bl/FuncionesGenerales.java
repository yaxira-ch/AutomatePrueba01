package proxim.bl;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import proxim.be.FinanciamientoDesembolsoLineaBE;
import proxim.be.ObjetosGenerales;
import proxim.be.PagosDocumentosBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosRecibosBE;
import proxim.be.TransferenciaBE;
import proxim.be.TransferenciasExteriorBE;
import proxim.dao.*;
import java.lang.Thread;

public class FuncionesGenerales {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer = new ConexionSqlServer();
	static ConexionSqlServer objSQL = new ConexionSqlServer();

	public static boolean removeReadOnly(String strXpath) {
		boolean bandera = true;
		((JavascriptExecutor) Mdl_Variables.Gwed_Driver).executeScript(
				"arguments[0].removeAttribute('readonly','readonly')",
				Mdl_Variables.Gwed_Driver.findElement(By.xpath(strXpath)));
		return bandera;
	}

	public static void MenuGeneralNew(String xpathMenu, String xpathSubMenu) throws InterruptedException, IOException {
		Thread.sleep(2000);
		ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathMenu);
		System.out.println("Se seleccionó en Menu ");
		Thread.sleep(2000);
		if (!xpathSubMenu.equals("<IGNORE>")) {
			objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, xpathSubMenu);
			System.out.println("Se seleccionó en SubMenu");
		}
	}

	public static void CerrarPantallas() throws IOException, InterruptedException {
		Thread.sleep(3000);
		Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
		Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefoxdriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM safari.exe");
		Runtime.getRuntime().exec("taskkill /F /IM safaridriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM opera.exe");
		Runtime.getRuntime().exec("taskkill /F /IM operadriver.exe");
		if (Mdl_Variables.Gstr_Aplicativo.toLowerCase().equals("explorer")) {
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}

	public void irPestanaUno() throws InterruptedException, IOException {
		Robot robot;
		try {
			Thread.sleep(15000);
			robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_1);
			Thread.sleep(100);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyRelease(java.awt.event.KeyEvent.VK_1);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void retornarPestanaPrincipal() throws InterruptedException, IOException {
		Robot robot;
		try {
			Thread.sleep(15000);
			robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_ALT);
			robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
			Thread.sleep(100);
			robot.keyRelease(java.awt.event.KeyEvent.VK_ALT);
			robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<String> focoPantallaEmergente() throws InterruptedException, IOException {
		ArrayList<String> tabs2 = new ArrayList<String>(Mdl_Variables.Gwed_Driver.getWindowHandles());
		Mdl_Variables.Gwed_Driver.switchTo().window(tabs2.get(1));
		Thread.sleep(1000);
		return tabs2;
	}

	public static boolean CompararFecha(String Ldt_Date2) throws ParseException {
		Date Date_Now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date_Now = (Date) formatter.parse(Ldt_Date2);
		return Date_Now.after(new Date());// devuelve true si la fecha es superior a la fecha actual y false si no lo es
	}

	public void CallPasos(String Lstr_Pasos) {
		if (!Lstr_Pasos.contentEquals("")) {
			Lstr_Pasos = Lstr_Pasos.replace("'", "''");
		}

		if (!Mdl_Variables.Gstr_PasosEvidencia.contentEquals("")) {
			Mdl_Variables.Gstr_PasosEvidencia = Mdl_Variables.Gstr_PasosEvidencia + "|>.<|" + Lstr_Pasos;
		} else {
			Mdl_Variables.Gstr_PasosEvidencia = Lstr_Pasos;
		}

		objConexionSqlServer.modificarTablaPasos();
	}

	public static void casosEjecutar(String lstr_Casos, int lint_Valor) {
		if (lstr_Casos.indexOf("-") != -1) {
			String[] Larr_CasosEjecutar = lstr_Casos.split("-");
			String[] Larr_CasosEjecutar1 = new String[(Integer.parseInt(Larr_CasosEjecutar[1])
					- Integer.parseInt(Larr_CasosEjecutar[0])) + 1];
			int j = 0;

			for (int i = Integer.parseInt(Larr_CasosEjecutar[0]); i <= Integer.parseInt(Larr_CasosEjecutar[1]); i++) {
				Larr_CasosEjecutar1[j] = Integer.toString(i);
				j++;
			}

			if (lint_Valor == 1) {
				Mdl_Variables.Garr_CasosEjecutar = Larr_CasosEjecutar1;
			} else {
				Mdl_Variables.Garr_CasoAfiliacion = Larr_CasosEjecutar1;
			}

		} else {
			String[] Larr_CasosEjecutar1 = new String[1];
			if (lint_Valor == 1) {
				if (lstr_Casos.indexOf(",") != -1) {
					Mdl_Variables.Garr_CasosEjecutar = lstr_Casos.split(",");
				} else {
					Larr_CasosEjecutar1[0] = lstr_Casos;
					Mdl_Variables.Garr_CasosEjecutar = Larr_CasosEjecutar1;
				}
			} else {
				if (lstr_Casos.indexOf(",") != -1) {
					Mdl_Variables.Garr_CasoAfiliacion = lstr_Casos.split(",");
				} else {
					Larr_CasosEjecutar1[0] = lstr_Casos;
					Mdl_Variables.Garr_CasoAfiliacion = Larr_CasosEjecutar1;
				}
			}
		}
	}

	// 07/03/2017(sconcha)función que separa de una cadena el tipo del producto,
	// numero de cuenta, tipo moneda y nombre de la empresa
	public Map<String, String> obtenerDatosEmpresa(String strCadena) throws SQLException, IOException {
		Map<String, String> map = new HashMap<String, String>();

		String strTipoProductoA = strCadena.substring(0, 16);
		String strTipoMonedaA = null;
		String strNumeroCuentaA = null;
		String strNombreEmpresaA = null;

		if (strTipoProductoA.equals("Cuenta Corriente")) {
			strTipoMonedaA = strCadena.substring(17, 22);
			if (strTipoMonedaA.equals("Soles")) {
				strNumeroCuentaA = strCadena.substring(23, 37);
				strNombreEmpresaA = strCadena.substring(41, strCadena.length());
			} else {
				strTipoMonedaA = strCadena.substring(17, 24);
				strNumeroCuentaA = strCadena.substring(25, 39);
				strNombreEmpresaA = strCadena.substring(43, strCadena.length());
			}
		} else {
			strTipoProductoA = strCadena.substring(0, 14);// se quito 3 para que quede Ahorro Dólares
			strTipoMonedaA = strCadena.substring(18, 23);
			if (strTipoMonedaA.equals("Soles")) {
				strNumeroCuentaA = strCadena.substring(24, 38);
				strNombreEmpresaA = strCadena.substring(42, strCadena.length());
			} else {
				strTipoMonedaA = strCadena.substring(18, 25);
				strNumeroCuentaA = strCadena.substring(26, 40);
				strNombreEmpresaA = strCadena.substring(44, strCadena.length());
			}
		}
		map.put("strTipoProducto", strTipoProductoA);
		map.put("strTipoMoneda", strTipoMonedaA);
		map.put("strNumeroCuenta", strNumeroCuentaA);
		map.put("strNombreEmpresa", strNombreEmpresaA);

		return map;
	}

	// 07/03/2017(sconcha)función que separa de una cadena el tipo del producto,
	// numero de cuenta y tipo moneda
	public Map<String, String> obtenerDatosEmpresaVariante(String strCadena) throws SQLException, IOException {
		Map<String, String> map = new HashMap<String, String>();

		String strTipoProductoA = strCadena.substring(0, 16);
		String strTipoMonedaA = null;
		String strNumeroCuentaA = null;
		int intLongitud = strCadena.length();

		if (strTipoProductoA.equals("Cuenta Corriente")) {
			strTipoMonedaA = strCadena.substring(17, 22);
			if (strTipoMonedaA.equals("Soles")) {
				strNumeroCuentaA = strCadena.substring(23, intLongitud);

			} else {
				strTipoMonedaA = strCadena.substring(17, 24);
				strNumeroCuentaA = strCadena.substring(25, intLongitud);

			}
		} else {
			strTipoProductoA = strCadena.substring(0, 17);// se quito 3 para que quede Ahorro
			strTipoMonedaA = strCadena.substring(18, 23);
			if (strTipoMonedaA.equals("Soles")) {
				strNumeroCuentaA = strCadena.substring(24, intLongitud);

			} else {
				strTipoMonedaA = strCadena.substring(18, 25);
				strNumeroCuentaA = strCadena.substring(26, intLongitud);

			}
		}
		map.put("strTipoProducto", strTipoProductoA);
		map.put("strTipoMoneda", strTipoMonedaA);
		map.put("strNumeroCuenta", strNumeroCuentaA);

		return map;
	}

	public String newCuenta(String strCuenta) {
		strCuenta = strCuenta.substring(strCuenta.length() - 10, strCuenta.length());
		// if(strCuenta.contains("Cuenta Corriente")){
		// strCuenta=strCuenta.replace("Cuenta Corriente", "CTE");
		// }else if(strCuenta.contains("Cuenta de Ahorros")){
		// strCuenta=strCuenta.replace("Cuenta de Ahorros", "AHO");
		// }
		//
		// if(strCuenta.contains("Soles")){
		// strCuenta=strCuenta.replace("Soles", "SOL");
		// }else if(strCuenta.contains("Dólares")){
		// strCuenta=strCuenta.replace("Dólares", "DOL");
		// }

		return strCuenta;
	}

	private static String obtenerTipoCuenta(String cuenta) {
		if (cuenta.contains("Ahorros"))
			return "Cuenta de Ahorros";
		else
			return "Cuenta Corriente";
	}

	private static String obtenerMoneda(String cuenta) {
		if (cuenta.contains("Soles"))
			return "Soles";
		else
			return "Dólares";
	}

	public static boolean existeCasosEjecutar(String[] larr_CasiEjecutar) throws ParseException {// verifica si el array
																									// esta vacio o
																									// tiene algun dato
		boolean var = false;
		for (int i = 0; i <= larr_CasiEjecutar.length - 1; i++) {
			if (!larr_CasiEjecutar[i].equals("")) {
				var = true;
				break;
			}
		}
		return var;
	}

	public boolean seleccionarMenu(String LstrProducto) throws InterruptedException, IOException {
		boolean var = false;
		for (int i = 2; i <= 7; i++) {
			String valor = Mdl_Variables.Gwed_Driver
					.findElement(By.xpath("//html/body/div[2]/div[2]/div/ul/li[" + i + "]/a//span")).getText();
			if (LstrProducto.toLowerCase().equals(valor.toLowerCase())) {
				if (valor.toLowerCase().equals("transferencias")) {
					var = objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,
							"//html/body/div[2]/div[2]/div/ul/li[" + i + "]/a//span");
				} else {
					var = objObjetosGenerales.moveToElement("//html/body/div[2]/div[2]/div/ul/li[" + i + "]/a//span");
				}
				Thread.sleep(2500);
				break;
			}
		}
		return var;
	}

	public boolean clicMenu() throws InterruptedException, IOException {
		return objObjetosGenerales.moveToElement("//html/body/div[2]/div[1]/div[2]/div[1]/div[2]/a");
	}

	public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException {
		String strValorBoton = "";
		String strClave = Lstr_Clave;
		String strLetraValor = "";

		for (int i = 1; i <= strClave.length(); i++) {
			strLetraValor = strClave.split("")[i - 1];

			for (int j = 1; j <= 10; j++) {
				strValorBoton = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]"))
						.getText();

				if (strValorBoton.equals(strLetraValor)) {
					Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[1]/div[2]/div/Button[" + j + "]")).click();
					break;
				}
			}
		}
		return true;
	}

	public static boolean buscarCasosEjecutar(String idCaso, int valor) throws ParseException {
		boolean var = false;
		if (valor == 1) {
			for (int i = 0; i <= Mdl_Variables.Garr_CasosEjecutar.length - 1; i++) {
				if ((!Mdl_Variables.Garr_CasosEjecutar[i].equals("")
						|| !Mdl_Variables.Garr_CasosEjecutar[i].equals(null))
						&& Mdl_Variables.Garr_CasosEjecutar[i].compareTo(idCaso) == 0) {
					Mdl_Variables.Garr_CasosEjecutar[i] = "";
					var = true;
					break;
				}
			}
		} else {
			for (int i = 0; i <= Mdl_Variables.Garr_CasoAfiliacion.length - 1; i++) {
				if ((!Mdl_Variables.Garr_CasoAfiliacion[i].equals("")
						|| !Mdl_Variables.Garr_CasoAfiliacion[i].equals(null))
						&& Mdl_Variables.Garr_CasoAfiliacion[i].compareTo(idCaso) == 0) {
					Mdl_Variables.Garr_CasoAfiliacion[i] = "";
					var = true;
					break;
				}
			}
		}
		return var;
	}

	public static String fechaActual() throws ParseException {
		Calendar calendario = new GregorianCalendar();
		int hora, minutos, segundos;
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		return hora + ":" + minutos + ":" + segundos;
	}

	/**
	 * CAA_2013-02-04 Begin Crea la estructura de las carpetas para la generación de
	 * evidencia en la ruta indicada por el parametro
	 * 
	 * @param ruta
	 *            : La ruta se esta armando antes de llamar esta rutina con
	 *            Gstr_RutaAplicativo + Gstr_VersionAplicativo + Gstr_Ciclo
	 */
	public static void crearRutaEvidencia() {
		String tabla = "";
		switch (Mdl_Variables.Gstr_Tabla) {
		case "APP_AND_LOGIN_D": // LOGIN
			tabla = "Login";
			break;
		case "APP_AND_PAGO_MAS_ADMAFILIADOS_D":// PAGOS-MASIVOS:Administración de Afiliados
			tabla = "Administración de Afiliados";
			break;
		case "APP_AND_PAGO_MAS_ADMPAGOS_D":// PAGOS-MASIVOS:Administración de Pagos-Envío de Pagos
			tabla = "Administración de Pagos";
			break;
		case "APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D":// TRANSFERENCIAS-Envío transferencia: Entre Cuentas
			tabla = "Transferencias Entre Cuentas";
			break;
		case "APP_AND_TRANSFERENCIAS_A_TERCEROS_D":// TRANSFERENCIAS-Envío transferencia: a Terceros
			tabla = "Transferencias a Terceros";
			break;
		case "APP_AND_TRANSFERENCIAS_OTROS_BANCOS_CCE_D":// TRANSFERENCIAS-Envío transferencia: a otros bancos CCE
			tabla = "Transferencias a Otros Bancos CCE";
			break;
		case "APP_AND_TRANSFERENCIAS_OTROS_BANCOS_BCR_D":// TRANSFERENCIAS-Envío transferencia: a otros bancos BCR
			tabla = "Transferencias a Otros Bancos BCR";
			break;
		case "APP_AND_CONSULTA_SALDOS_MOVIMIENTOS_D":// CONSULTAS-Saldos y Movimientos
			tabla = "Consulta de Saldos y Movimientos";
			break;
		case "APP_PAGOS_RECIBOS_D":// PAGOS-De Recibos
			tabla = "Pago de Recibos";
			break;
		case "APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS":// FINANCIAMIENTO-Documentos Electrónicos:Documentos Electrónicos
			tabla = "Documentos Electronicos";
			break;
		case "APP_AND_AUTORIZACIONES_PENDIENTES_D":// AUTORIZACIONES-Autorizaciones Pendientes
			tabla = "Autorizaciones Pendientes";
			break;
		case "APP_AND_CONSULTA_PAGARES_D":// CONSULTA Relacion de Pagares
			tabla = "Consulta de Pagares";
			break;
		case "APP_FINANCIAMIENTO_DESLINEA_D":// PAGOS-MASIVOS:Administración de Pagos-Envío de Pagos
			tabla = "Desembolso en Línea";
			break;
		case "APP_COMERCIO_EXT_CARTA_FIANZA_D":// PAGOS-MASIVOS:Administración de Pagos-Envío de Pagos
			tabla = "Carta Fianza";
			break;
		case "APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_D":
			tabla = "Descuentos y Cobranzas";
			break;
		case "APP_AUTORIZACIONES_PORTABILIDAD_D":
			tabla = "Portabilidad";
			break;
		case "APP_CONSULTAS_Y_PEDIDOS_D":
			tabla = "Consultas y Pedidos";
			break;
		case "APP_TRANSFERENCIAS_EXTERIOR":
			tabla = "Transferencias al exterior";
			break;
		case "APP_CONSULTA_CHEQUES":
			tabla = "Cheques emitidos";
			break;
		case "APP_COMERCIO_EXT_CARTA_FIANZA_RENOVACION_D":
			tabla = "Renovacion Carta Fianza";
			break;
		case "CONSULTA_SALDOS_PORTABILIDAD":
			tabla = "Consulta Saldos Portabilidad";
			break;
		case "APP_PAGOS_DOCUMENTOS_D":
			tabla = "Pago de Documentos";
			break;
		case "APP_CONSULTA_RECAUDACION_D":
			tabla = "Consultas Recaudacion";
			break;
		case "APP_FINANCIAMIENTO_DOCELC_REPORTES":
			tabla = "Financiamiento Documentos Electrónicos Reportes";
			break;
		case "APP_TRANSFERENCIAS_CUENTA_PAYPAL_D":
			tabla = "Cuenta Paypal";
			break;
		case "APP_PAGOS_PRELIQUIDACION_D":
			tabla = "Pagos de Pre Liquidación";
			break;
		case "APP_FINANCIAMIENTO_DESCOB_CARDOCUMENTOS_D":
			tabla = "Cartera de Documentos";
			break;
		case "APP_FINANCIAMIENTO_CONSULTA_DOCUMENTO":
			tabla = "Financiamiento Consulta Documentos";
			break;
		case "APP_FINANCIAMIENTO_NOTIFIVENCIMIENTO":
			tabla = "Financiamiento Notificacion Vencimiento";
			break;
		case "APP_CONSULTA_DOC_ELECTRONICO":
			tabla = "Consulta Documentos Electrónicos";
			break;
		case "TBL_TRANSFERENCIA_ENTRE_CUENTA_PORTABILIDAD":
			tabla = "Portabilidad Transferencia entre cuentas";
			break;
		case "APP_FINANCIAMIENTO_DOCELC_CONPREAFI_CONAFILIADOS":
			tabla = "Consulta y Pre Afiliación de Proveedores";
			break;
		case "TBL_TRANSFERENCIA_A_TERCEROS_PORTABILIDAD":
			tabla = "Portabilidad Transferencia a Terceros";
			break;

		case "APP_SOLICITUDES_CONTRATOS_DIGITALES":
			tabla = "Solicutudes de Contratos Digitales";
			break;
		}
		Mdl_Variables.Gstr_RutaAplicativo = Mdl_Variables.Gstr_RutaEvidencia + "\\" + Mdl_Variables.Gstr_Sprint + "\\"
				+ Mdl_Variables.Gstr_Tarjeta + "\\" + tabla + "\\Version_" + Mdl_Variables.Gstr_NombreVersion
				+ "\\Ciclo_" + Mdl_Variables.Gstr_Corrida + "\\CasoPrueba_" + Mdl_Variables.Gint_IdCaso + "\\";
		Mdl_Variables.Gstr_RutaReportHTML = Mdl_Variables.Gstr_RutaEvidencia + "\\" + Mdl_Variables.Gstr_Sprint + "\\"
				+ Mdl_Variables.Gstr_Tarjeta + "\\" + tabla + "\\Version_" + Mdl_Variables.Gstr_NombreVersion
				+ "\\Ciclo_" + Mdl_Variables.Gstr_Corrida + "\\";
		File file = new File(Mdl_Variables.Gstr_RutaAplicativo + Mdl_Variables.Gstr_CarpetaImagenes);
		file.mkdirs();
		file = new File(Mdl_Variables.Gstr_RutaReportHTML + Mdl_Variables.Gstr_CarpetaReporteHTML);
		file.mkdirs();
	}

	/**
	 * procedimiento que valida si existe un alert y lo cierra, y tambiÃ©n valida si
	 * existe el link "Vaya a este sitio web (no recomendado)." y le da clic
	 */
	public static void Click_Aceptar() {
		try {
			// Si existe un alert lo cierra
			Mdl_Variables.Gwed_Driver.switchTo().alert().accept();
			// click en el link
			Mdl_Variables.Gwed_Driver.findElement(By.id("overridelink")).click();
			Thread.sleep(3000);
			Mdl_Variables.Gwed_Driver.findElement(By.id("overridelink")).click();
		} catch (Throwable e) {
		}
	}

	public boolean verificarIgnore(String strVariable) {
		strVariable = strVariable.replace("\r\n", "");
		boolean blnResultado = false;
		if (strVariable.compareTo(Mdl_Variables.Gstr_Ignore) != 0) {
			blnResultado = true;
		}
		return blnResultado;
	}

	public boolean insertSaldosMovimientos(Map<String, String> mapDatosInsertar, String strTipoProducto) {
		String StrTipoEmpresa;
		int intIdCasoLote = Integer.valueOf(mapDatosInsertar.get("ID_CASO_LOTE"));
		String strFechaOperacion = mapDatosInsertar.get("OPERACION_FECHA");
		String strHoraOperacion = mapDatosInsertar.get("OPERACION_HORA");
		String strEmpresa = mapDatosInsertar.get("CMB_EMPRESA_CARGO");
		String strCuenta = mapDatosInsertar.get("LNK_NUMERO_CUENTA_CARGO");
		String strTipoCuenta = mapDatosInsertar.get("CMB_TIPO_PRODUCTO_CARGO");
		String strTipoMoneda = mapDatosInsertar.get("CMB_MONEDA_CARGO");
		String strEjecucionCics = mapDatosInsertar.get("UTILIZADO_CICS");
		String strNombreTabla = mapDatosInsertar.get("TABLA_CARGA");
		int intIdCasoLogin = Integer.valueOf(mapDatosInsertar.get("ID_CASO_LOGIN_CARGO"));
		String strConsultarCics = mapDatosInsertar.get("CICS");
		int strCantidadCuentasAbonos = Integer.parseInt(mapDatosInsertar.get("NUMERO_CUENTAS_ABONO"));
		String strTie = mapDatosInsertar.get("TIE_CARGO");
		String strClave = mapDatosInsertar.get("CLAVE_CARGO");

		if (!strEmpresa.contentEquals("<IGNORE>")) {
			StrTipoEmpresa = "Empresa";
		} else {
			StrTipoEmpresa = "Grupo Económico";
		}

		boolean blnResultado = true;
		try {

			insertarRegistros(mapDatosInsertar, intIdCasoLogin, strEmpresa, strTipoCuenta, strCuenta, strTipoMoneda,
					strTie, strClave, "Cargo", intIdCasoLote, strHoraOperacion, strFechaOperacion, strNombreTabla,
					strConsultarCics, strEjecucionCics, StrTipoEmpresa, strTipoProducto);

			if (strCantidadCuentasAbonos > 0) {
				for (int i = 0; i < strCantidadCuentasAbonos; i++) {
					StrTipoEmpresa = Mdl_Variables.Gstr_Ignore;
					intIdCasoLogin = 0;
					strEmpresa = Mdl_Variables.Gstr_Ignore;
					strTipoCuenta = Mdl_Variables.Gstr_Ignore;
					strCuenta = Mdl_Variables.Gstr_Ignore;
					strTipoMoneda = Mdl_Variables.Gstr_Ignore;
					strTie = Mdl_Variables.Gstr_Ignore;
					strClave = Mdl_Variables.Gstr_Ignore;

					intIdCasoLogin = Integer.valueOf(mapDatosInsertar.get("ID_CASO_LOGIN_ABONO_" + i));
					strEmpresa = mapDatosInsertar.get("CMB_EMPRESA_ABONO_" + i);
					strTipoCuenta = mapDatosInsertar.get("CMB_TIPO_PRODUCTO_ABONO_" + i);
					strCuenta = mapDatosInsertar.get("LNK_NUMERO_CUENTA_ABONO_" + i);
					strTipoMoneda = mapDatosInsertar.get("CMB_MONEDA_ABONO_" + i);
					strTie = mapDatosInsertar.get("TIE_ABONO_" + i);
					strClave = mapDatosInsertar.get("CLAVE_ABONO_" + i);

					if (!strEmpresa.contentEquals("<IGNORE>")) {
						StrTipoEmpresa = "Empresa";
					} else {
						StrTipoEmpresa = "Grupo Económico";
					}

					insertarRegistros(mapDatosInsertar, intIdCasoLogin, strEmpresa, strTipoCuenta, strCuenta,
							strTipoMoneda, strTie, strClave, "Abono", intIdCasoLote, strHoraOperacion,
							strFechaOperacion, strNombreTabla, strConsultarCics, strEjecucionCics, StrTipoEmpresa,
							strTipoProducto);
				}
			}
		} catch (Exception Ex) {
			blnResultado = false;
		}
		return blnResultado;
	}

	private void insertarRegistros(Map<String, String> mapDatosInsertar, int intIdCasoLogin, String strEmpresa,
			String strTipoCuenta, String strCuenta, String strTipoMoneda, String strTie, String strClave,
			String tipoOperacion, int intIdCasoLote, String strHoraOperacion, String strFechaOperacion,
			String strNombreTabla, String strConsultarCics, String strEjecucionCics, String StrTipoEmpresa,
			String strTipoProducto) throws SQLException, IOException {
		String query = "";
		String strFechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		String strResultadoEsperado = "Realizar Consultas de Saldos y Movimientos  de Saldos de " + StrTipoEmpresa
				+ ", con Cuenta de " + "Cargo: " + strTipoCuenta + ", Tipo de moneda: " + strTipoMoneda
				+ ", Tipo de Fecha Búsqueda: Fecha Operación con descarga de documento: "
				+ "Envío de texto, Exportar a Excel y Exportar a PDF";

		// if(tipoOperacion.equals("Abono")&&strTipoProducto.equals("A Terceros")){
		objConexionSqlServer.listaTablaIdCaso("select * from APP_AND_CONSULTA_SALDOS_MOVIMIENTOS_D where id_caso_lote="
				+ intIdCasoLote + " and TABLA_CARGA='" + strNombreTabla + "' and TXT_NUMERO_CUENTA like '%"
				+ strCuenta.substring(strCuenta.length() - 10, strCuenta.length()) + "'" + "AND CMB_TIPO_OPERACION = '"
				+ tipoOperacion + "'", "", 5);

		if (Mdl_Variables.Grst_NuevaTabla.next() == true) {
			objConexionSqlServer.updateTablaQuery("update APP_AND_CONSULTA_SALDOS_MOVIMIENTOS_D set " + "CMB_EMPRESA='"
					+ strEmpresa + "'," + "CMB_TIPO_PRODUCTO='" + strTipoCuenta + "'," + "CMB_MONEDA='" + strTipoMoneda
					+ "'," + "CMB_TIPO_CUENTA='" + strCuenta + "'," + "OPERACION_FECHA='" + strFechaOperacion + "' , "
					+ "OPERACION_HORA='" + strHoraOperacion + "'," + "TXT_FECHA_DESDE='" + strFechaBusqueda + "', "
					+ "TXT_FECHA_HASTA='" + strFechaBusqueda + "' " + "where ID_CASO="
					+ Mdl_Variables.Grst_NuevaTabla.getInt("ID_CASO"));
		} else {
			query = "INSERT APP_AND_CONSULTA_SALDOS_MOVIMIENTOS_D ( ID_CASO_LOGIN, CICS, ID_CASO_LOTE, TABLA_CARGA, TXT_MENU, TXT_SUBMENU, "
					+ "TXT_SUBMENU1, CMB_EMPRESA, CMB_TIPO_PRODUCTO, CMB_MONEDA, TXT_NUMERO_CUENTA, LNK_NUMERO_CUENTA, VALIDAR_SALDOS_CICS, TXT_ALIAS,"
					+ " LNK_SALDO_DISPONIBLE, CMB_EMPRESA_MOVIMIENTO, CMB_TIPO_CUENTA, CMB_CUENTA, RBT_FECHA_OPERACION, RBT_FECHA_PROCESO, TXT_FECHA_DESDE, "
					+ "TXT_FECHA_HASTA, BTN_BUSCAR, VALIDAR_MOVIMIENTOS_CICS, CONSULTA_EXISTE, CODIGO_UBICACION, BTN_CERRAR_POP_UP, LNK_DESCARGAR_EXPORTABLE, "
					+ "BTN_SALDO_DISPONIBLE, BTN_DEPOSITOS_CHEQUES, LNK_REGRESAR_SALDOS, LNK_EXPORTAR_EXCEL_SALDOS, LNK_EXPORTAR_PDF_SALDOS, LNK_IMPRIMIR_SALDOS, "
					+ "LNK_REGRESAR_MOVIMIENTOS, LNK_OCULTAR_MOSTRAR_ITF, CMB_CUENTA_MOVIMIENTO, LNK_ENVIAR_TEXTO_MOVIMIENTOS, LNK_EXPORTAR_EXCEL_MOVIMIENTOS, "
					+ "LNK_EXPORTAR_PDF_MOVIMIENTOS, LNK_IMPRIMIR_MOVIMIENTOS, LNK_ENVIAR_TEXTO, LNK_EXPORTAR_EXCEL, LNK_EXPORTAR_PDF, LNK_IMPRIMIR, CMB_CUENTA_ESTADO, "
					+ "BTN_BUSCAR_ESTADO, LNK_CERRAR_SESION, TXT_COLUMNA_ERROR, TXT_MENSAJE_ERROR,CMB_TIPO_OPERACION, MENSAJE_LOG, DESIGN_STEPS, DESCRIPTION, ESTADO_CASO, UTILIZADO, "
					+ "ACIERTO_ERROR, EJECUCION_AC_ERR, UTILIZADO_CICS, OPERACION_FECHA, OPERACION_HORA, HORA, TIEMPO_EJECUCION_CASO) VALUES "
					+ "(" + intIdCasoLogin + ", NULL, '" + intIdCasoLote + "', '" + strNombreTabla
					+ "', 'CONSULTAS', 'Saldos y Movimientos', 'Saldos y Movimientos', '" + strEmpresa + "', '"
					+ strTipoCuenta + "', '" + strTipoMoneda + "', '" + strCuenta + "', '" + strCuenta
					+ "', NULL, NULL, 'CLICK', NULL, NULL, NULL, 'CLICK', NULL," + " '" + strFechaBusqueda + "', '"
					+ strFechaBusqueda
					+ "', 'CLICK', NULL, NULL, NULL, NULL, 'CLICK', 'CLICK', 'CLICK', 'CLICK', 'CLICK', 'CLICK', NULL, 'CLICK', NULL, NULL,"
					+ " 'CLICK', 'CLICK', 'CLICK', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'CLICK', NULL, NULL,'"
					+ tipoOperacion + "', NULL, NULL, '" + strResultadoEsperado + "', " + "'Activo', 0, -1, NULL, '"
					+ strEjecucionCics + "', '" + strFechaOperacion + "', '" + strHoraOperacion + "', NULL, NULL)";

			objConexionSqlServer.insertCampo(query);
		}
		// }

		objConexionSqlServer.listaTablaIdCaso("select * from CONSULTA_SALDOS_PORTABILIDAD where id_caso_lote="
				+ intIdCasoLote + " and TABLA_CARGA='" + strNombreTabla + "' and LNK_NUMERO_CUENTA like '%"
				+ strCuenta.substring(strCuenta.length() - 10, strCuenta.length()) + "'" + "AND TIPO_OPERACION = '"
				+ tipoOperacion + "'", "", 5);

		if (Mdl_Variables.Grst_NuevaTabla.next() == true) {
			objConexionSqlServer.updateTablaQuery("update CONSULTA_SALDOS_PORTABILIDAD set " + "OPERACION_FECHA='"
					+ strFechaOperacion + "' , " + "OPERACION_HORA='" + strHoraOperacion + "' ," + "CMB_EMPRESA='"
					+ strEmpresa + "' " + "where ID_CASO=" + Mdl_Variables.Grst_NuevaTabla.getInt("ID_CASO"));
		} else {
			query = "INSERT CONSULTA_SALDOS_PORTABILIDAD (RUTA,TIE,CLAVE,FIRMANTE,TXT_CAPCHA,BTN_SIGUIENTE,BTN_SIGUIENTE1, "
					+ "BTN_CONSULTA_SALDOS,CMB_EMPRESA,BTN_ENVIAR_EMAIL,TXT_CORREO,TXT_MENSAJE_CORREO,BTN_ENVIAR_CORREO,BTN_CERRAR_CORREO,"
					+ "LNK_NUMERO_CUENTA,BTN_SELECCIONAR_CUENTA,LBL_GLOSA,LBL_ORDENANTE,LBL_FECHA,TIPO_OPERACION,LBL_MONTO,CMB_MONEDA,"
					+ "BTN_ENVIAR_EMAIL_MOVIMIENTOS,TXT_CORREO_MOVIMIENTOS,TXT_MENSAJE_CORREO_MOVIMIENTOS,BTN_ENVIAR_CORREO_MOVIMIENTOS,"
					+ "BTN_CERRAR_CORREO_MOVIMIENTOS,BTN_CERRAR_SESION,CICS,ID_CASO_LOTE,TABLA_CARGA,OPERACION_FECHA,OPERACION_HORA,ID_CASO_LOGIN,"
					+ "CMB_TIPO_PRODUCTO,UTILIZADO_CICS,DESIGN_STEPS,DESCRIPTION,ESTADO_CASO,UTILIZADO,ACIERTO_ERROR,EJECUCION_AC_ERR,HORA,"
					+ "TIEMPO_EJECUCION_CASO) VALUES " + "('https://130.30.24.181:9443/bpie-web/inicio', '" + strTie
					+ "','" + strClave + "', NULL, NULL, 'CLICK', 'CLICK', 'CLICK', '" + strEmpresa + "',"
					+ "'CLICK', 'sconchah@everis.com', 'AUTOMATIZADO - Consulta Saldos Portabilidad - Nro Caso Lote: "
					+ intIdCasoLote + "', 'CLICK', 'CLICK', '" + strCuenta + "', 'CLICK', NULL, NULL, NULL, '"
					+ tipoOperacion + "', NULL, '" + strTipoMoneda + "', 'CLICK', 'sconchah@everis.com',  "
					+ "'AUTOMATIZADO MOVIMIENTOS- Consulta Saldos Portabilidad - Nro Caso Lote: " + intIdCasoLote
					+ "', 'CLICK', 'CLICK', 'CLICK', " + "'CLICK','" + intIdCasoLote + "','" + strNombreTabla + "','"
					+ strFechaOperacion + "', '" + strHoraOperacion + "'," + intIdCasoLogin + "," + "'" + strTipoCuenta
					+ "', 0,NULL, '" + strResultadoEsperado + "', 'Activo', '0', '-1', NULL,NULL, NULL)";
			objConexionSqlServer.insertCampo(query);
		}
	}

	public long tiempoTotal(long lngTiempoInicio, String strXpath) throws InterruptedException, IOException {
		objObjetosGenerales.waitBy(ObjetosGenerales.xpath, strXpath);
		long lngHoraFin = System.currentTimeMillis();
		long lngResultado = ((lngHoraFin - lngTiempoInicio) / 1000) / 60;
		return lngResultado;
	}

	public void callPasosAcierto(int strTipo, String strTexto1, String strTexto2, String strObjeto) {
		switch (strTipo) {
		case 1:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Dar clic en: "; // el button
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strObjeto;
			break;
		case 2:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Seleccionar valor: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 3:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Ingresar: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1 + " "
					+ strTexto2;
			break;
		case 4:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Texto guardado: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 5:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Valores iguales: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1 + " y "
					+ strTexto2;
			break;
		case 6:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Existe: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 7:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Valores Correctos: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 8:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		}
		CallPasos(Mdl_Variables.Gstr_PasosEvidenciaMensaje);
	}

	public void callPasosErrado(int strTipo, String strTexto1, String strTexto2, String strObjeto) throws Exception {
		switch (strTipo) {
		case 1:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "No se ha dado clic en: "; // el button
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strObjeto;
			break;
		case 2:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "No se ha seleccionado valor: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 3:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "No se ingresó: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 4:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "No se guardado texto: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 5:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Valores diferentes: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1 + " y "
					+ strTexto2;
			break;
		case 6:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "No existe: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 7:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "Valores Incorrectos: ";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		case 8:
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = "";
			Mdl_Variables.Gstr_PasosEvidenciaMensaje = Mdl_Variables.Gstr_PasosEvidenciaMensaje + strTexto1;
			break;
		}
		CallPasos(Mdl_Variables.Gstr_PasosEvidenciaMensaje);
		throw new Exception("Error: " + Mdl_Variables.Gstr_PasosEvidenciaMensaje);
	}

	public boolean compararTexto(String strTexto1, String strTexto2) {
		boolean blnResultado = false;

		if (strTexto1.trim().compareTo(strTexto2.trim()) == 0)
			blnResultado = true;

		return blnResultado;
	}

	public boolean compararTextosIguales(String strTexto1, String strTexto2) {
		boolean blnResultado = false;

		if (strTexto1.equals(strTexto2))
			blnResultado = true;

		return blnResultado;
	}

	public boolean buscarCadena(String strCadenaBusq, String strTexto) {
		boolean blnResultado = true;

		if (strTexto.indexOf(strCadenaBusq.trim()) == -1)
			blnResultado = false;

		return blnResultado;
	}

	public boolean insertarTablaErrorReporte(String strTabla, String strIdCaso, String strCorrida, String strVersion,
			String strRuta, String strUbicacion, String strCadena, String strtexto) {
		boolean blnResultado = false;
		try {
			String query = "";
			String LStr_Hora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
			query = "INSERT INTO TBL_REPORTE VALUES ('" + strTabla + "','" + strIdCaso + "','" + strCorrida + "','"
					+ strVersion + "','" + strRuta + "','" + strUbicacion + "','" + strCadena + "','" + strtexto + "','"
					+ LStr_Hora + "') ";
			blnResultado = objConexionSqlServer.listaTablaQueryDinamico(query);
		} catch (Exception Ex) {
			blnResultado = false;
		}
		return blnResultado;
	}

	public static Map<String, String> obtenerCampos_ConsultarSaldos() throws SQLException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> mapDatosLogin = new HashMap<String, String>();
		String idLoginAbono = "";
		String nombreEmpresaCargo = "";
		String nombreEmpresaAbono = "";
		map.put("CICS", null);
		map.put("UTILIZADO_CICS", "0");
		// String strFechaActual = new
		// SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		switch (Mdl_Variables.Gstr_Tabla) {
		case "APP_AND_PAGO_MAS_ADMPAGOS_D":
			map.put("ID_CASO_LOTE", PagosMasivosAdministracionAfiliadosBE.strIdCaso);
			map.put("TABLA_CARGA", "APP_AND_PAGO_MAS_ADMPAGOS_D");
			map.put("OPERACION_FECHA", PagosMasivosAdministracionAfiliadosBE.GstrLBL_FECHA_OPERACION);
			map.put("OPERACION_HORA", PagosMasivosAdministracionAfiliadosBE.GstrLBL_HORA_OPERACION);

			mapDatosLogin = obtenerEmpresaByIDCasoLogin(PagosMasivosAdministracionAfiliadosBE.strIdCasoLogin);

			nombreEmpresaCargo = mapDatosLogin.get("strNombre");
			map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
			map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));

			map.put("ID_CASO_LOGIN_CARGO", PagosMasivosAdministracionAfiliadosBE.strIdCasoLogin);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO",
					formatearCuenta(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO));
			map.put("CMB_TIPO_PRODUCTO_CARGO",
					obtenerTipoCuenta(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CUENTA_CARGO));

			// if(PagosMasivosAdministracionAfiliadosBE.GstrCMB_PRODUCTO.equals("Pago a
			// Proveedores")||PagosMasivosAdministracionAfiliadosBE.GstrCMB_PRODUCTO.equals("Pagos
			// Varios")){
			// RegistroAfiliadosPagosBE objRegistroAfiliadosBL = new
			// RegistroAfiliadosPagosBE();
			//
			// int cantidadCuentasAbonos=0;
			// for(int i=0;i<=Mdl_Variables.Garr_CasoAfiliacion.length-1;i++){
			// objSQL.listaTablaIdCaso("APP_AND_AFILIADO","where
			// ID_CASO="+Mdl_Variables.Garr_CasoAfiliacion[i],2);
			// while (Mdl_Variables.Grst_TablaLogin.next()==true)
			// {
			// objRegistroAfiliadosBL.Afiliados(Mdl_Variables.Grst_TablaLogin, 2);
			//
			// mapDatosLogin=obtenerIDLoginByNombreEmpresa(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL,map,i);
			//
			// idLoginAbono=mapDatosLogin.get("strIdLogin_Abono");
			// map.put("TIE_CARGO",mapDatosLogin.get("strTie"));
			// map.put("CLAVE_CARGO",mapDatosLogin.get("strContrasenia"));
			//
			// if(!idLoginAbono.equals("")){
			// map.put("ID_CASO_LOGIN_ABONO_"+i,idLoginAbono);
			// map.put("CMB_EMPRESA_ABONO_"+i,RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL);
			// map.put("LNK_NUMERO_CUENTA_ABONO_"+i,formatearCuenta(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA));
			// map.put("CMB_TIPO_PRODUCTO_ABONO_"+i,RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA);
			// map.put("CMB_MONEDA_ABONO_"+i,RegistroAfiliadosPagosBE.GstrCMB_MONEDA);
			// cantidadCuentasAbonos++;
			// }
			// }
			// }
			// map.put("NUMERO_CUENTAS_ABONO",""+cantidadCuentasAbonos);
			// }else{
			// map.put("NUMERO_CUENTAS_ABONO","0");
			// }
			map.put("NUMERO_CUENTAS_ABONO", "0");
			break;
		case "APP_AND_TRANSFERENCIAS_A_TERCEROS_D":
			map.put("ID_CASO_LOTE", TransferenciaBE.Gstr_ID_CASO);
			map.put("TABLA_CARGA", "APP_AND_TRANSFERENCIAS_A_TERCEROS_D");
			map.put("OPERACION_FECHA", TransferenciaBE.GstrLBN_OPERACION_FECHA);
			map.put("OPERACION_HORA", TransferenciaBE.GstrLBN_OPERACION_HORA);

			mapDatosLogin = obtenerEmpresaByIDCasoLogin(TransferenciaBE.Gstr_ID_CASO_LOGIN);

			nombreEmpresaCargo = mapDatosLogin.get("strNombre");
			map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
			map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));

			map.put("ID_CASO_LOGIN_CARGO", TransferenciaBE.Gstr_ID_CASO_LOGIN);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO", formatearCuenta(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("CMB_TIPO_PRODUCTO_CARGO", obtenerTipoCuenta(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));

			mapDatosLogin = obtenerIDLoginByNombreEmpresa(Mdl_Variables.Gstr_EmpresaDestino, map, 0);
			idLoginAbono = mapDatosLogin.get("strIdLogin_Abono");

			if (!idLoginAbono.equals("")) {
				map.put("ID_CASO_LOGIN_ABONO_0", idLoginAbono);
				map.put("CMB_EMPRESA_ABONO_0", Mdl_Variables.Gstr_EmpresaDestino);
				map.put("LNK_NUMERO_CUENTA_ABONO_0", formatearCuenta(TransferenciaBE.GstrTXT_CUENTA_DESTINO));
				map.put("CMB_TIPO_PRODUCTO_ABONO_0", obtenerTipoCuenta(TransferenciaBE.GstrCMB_TIPO_CUENTA));
				map.put("CMB_MONEDA_ABONO_0", obtenerMoneda(TransferenciaBE.GstrCMB_TIPO_CUENTA));
				map.put("TIE_ABONO_0", mapDatosLogin.get("strTie_Abono"));
				map.put("CLAVE_ABONO_0", mapDatosLogin.get("strContrasenia_Abono"));
				map.put("NUMERO_CUENTAS_ABONO", "1");
			} else {
				map.put("NUMERO_CUENTAS_ABONO", "0");
			}
			break;

		case "APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D":
			map.put("ID_CASO_LOTE", TransferenciaBE.Gstr_ID_CASO);
			map.put("TABLA_CARGA", "APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D");
			map.put("OPERACION_FECHA", TransferenciaBE.GstrLBN_OPERACION_FECHA);
			map.put("OPERACION_HORA", TransferenciaBE.GstrLBN_OPERACION_HORA);

			if (TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN.equals(Mdl_Variables.Gstr_Ignore)) {
				mapDatosLogin = obtenerEmpresaByIDCasoLogin(TransferenciaBE.Gstr_ID_CASO_LOGIN);

				nombreEmpresaCargo = mapDatosLogin.get("strNombre");
				map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
				map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));
				idLoginAbono = TransferenciaBE.Gstr_ID_CASO_LOGIN;
				nombreEmpresaAbono = nombreEmpresaCargo;
			} else {
				nombreEmpresaCargo = TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN;
				mapDatosLogin = obtenerIDLoginByNombreEmpresa(TransferenciaBE.GstrCMB_EMPRESA_CUENTA_DESTINO, map, 0);
				idLoginAbono = mapDatosLogin.get("strIdLogin_Abono");
				map.put("TIE_CARGO", mapDatosLogin.get("strTie"));
				map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia"));

				nombreEmpresaAbono = TransferenciaBE.GstrCMB_EMPRESA_CUENTA_DESTINO;
			}

			map.put("ID_CASO_LOGIN_CARGO", TransferenciaBE.Gstr_ID_CASO_LOGIN);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO", formatearCuenta(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("CMB_TIPO_PRODUCTO_CARGO", obtenerTipoCuenta(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("ID_CASO_LOGIN_ABONO_0", idLoginAbono);
			map.put("CMB_EMPRESA_ABONO_0", nombreEmpresaAbono);
			map.put("LNK_NUMERO_CUENTA_ABONO_0", formatearCuenta(TransferenciaBE.GstrCMB_CUENTA_DESTINO));
			map.put("CMB_TIPO_PRODUCTO_ABONO_0", obtenerTipoCuenta(TransferenciaBE.GstrCMB_CUENTA_DESTINO));
			map.put("CMB_MONEDA_ABONO_0", obtenerMoneda(TransferenciaBE.GstrCMB_CUENTA_DESTINO));
			map.put("NUMERO_CUENTAS_ABONO", "1");
			break;
		case "APP_AND_TRANSFERENCIAS_OTROS_BANCOS_CCE_D":
			map.put("ID_CASO_LOTE", TransferenciaBE.Gstr_ID_CASO);
			map.put("TABLA_CARGA", "APP_AND_TRANSFERENCIAS_OTROS_BANCOS_CCE_D");
			map.put("OPERACION_FECHA", TransferenciaBE.GstrLBN_OPERACION_FECHA);
			map.put("OPERACION_HORA", TransferenciaBE.GstrLBN_OPERACION_HORA);

			mapDatosLogin = obtenerEmpresaByIDCasoLogin(TransferenciaBE.Gstr_ID_CASO_LOGIN);
			if (TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN.equals(Mdl_Variables.Gstr_Ignore)) {
				nombreEmpresaCargo = mapDatosLogin.get("strNombre");
			} else {
				nombreEmpresaCargo = TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN;
			}

			map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
			map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));

			map.put("ID_CASO_LOGIN_CARGO", TransferenciaBE.Gstr_ID_CASO_LOGIN);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO", formatearCuenta(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("CMB_TIPO_PRODUCTO_CARGO", obtenerTipoCuenta(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(TransferenciaBE.GstrCMB_CUENTA_ORIGEN));
			map.put("NUMERO_CUENTAS_ABONO", "0");
			break;
		case "APP_FINANCIAMIENTO_DESLINEA_D":
			map.put("ID_CASO_LOTE", FinanciamientoDesembolsoLineaBE.Gstr_ID_CASO);
			map.put("TABLA_CARGA", "APP_FINANCIAMIENTO_DESLINEA_D");
			map.put("OPERACION_FECHA", FinanciamientoDesembolsoLineaBE.GstrLBL_FECHA_OPERACION);
			map.put("OPERACION_HORA", FinanciamientoDesembolsoLineaBE.GstrLBL_HORA_OPERACION);
			mapDatosLogin = obtenerEmpresaByIDCasoLogin(FinanciamientoDesembolsoLineaBE.Gstr_ID_CASO_LOGIN);

			nombreEmpresaCargo = mapDatosLogin.get("strNombre");
			map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
			map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));

			map.put("ID_CASO_LOGIN_CARGO", FinanciamientoDesembolsoLineaBE.Gstr_ID_CASO_LOGIN);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO", formatearCuenta(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA));
			map.put("CMB_TIPO_PRODUCTO_CARGO", obtenerTipoCuenta(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA));
			map.put("ID_CASO_LOGIN_ABONO_0", FinanciamientoDesembolsoLineaBE.Gstr_ID_CASO_LOGIN);
			map.put("CMB_EMPRESA_ABONO_0", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_ABONO_0", formatearCuenta(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA));
			map.put("CMB_TIPO_PRODUCTO_ABONO_0", obtenerTipoCuenta(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA));
			map.put("CMB_MONEDA_ABONO_0", obtenerMoneda(FinanciamientoDesembolsoLineaBE.GstrCMB_CUENTA));
			map.put("NUMERO_CUENTAS_ABONO", "1");
			break;

		case "APP_PAGOS_RECIBOS_D":
			map.put("ID_CASO_LOTE", PagosRecibosBE.Gstr_ID_CASO);
			map.put("TABLA_CARGA", "APP_PAGOS_RECIBOS_D");
			map.put("OPERACION_FECHA", PagosRecibosBE.GstrLBL_FECHA_OPERACION);
			map.put("OPERACION_HORA", PagosRecibosBE.GstrLBL_HORA_OPERACION);

			mapDatosLogin = obtenerEmpresaByIDCasoLogin(PagosRecibosBE.Gstr_ID_CASO_LOGIN);

			nombreEmpresaCargo = mapDatosLogin.get("strNombre");
			map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
			map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));
			map.put("ID_CASO_LOGIN_CARGO", PagosRecibosBE.Gstr_ID_CASO_LOGIN);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO", formatearCuenta(PagosRecibosBE.GstrCMB_CUENTA_CARGO));
			map.put("CMB_TIPO_PRODUCTO_CARGO", obtenerTipoCuenta(PagosRecibosBE.GstrCMB_CUENTA_CARGO));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(PagosRecibosBE.GstrCMB_CUENTA_CARGO));
			map.put("NUMERO_CUENTAS_ABONO", "0");
			break;

		case "APP_PAGOS_DOCUMENTOS_D":
			map.put("ID_CASO_LOTE", PagosDocumentosBE.Gstr_ID_CASO);
			map.put("TABLA_CARGA", "APP_PAGOS_DOCUMENTOS_D");
			map.put("OPERACION_FECHA", PagosDocumentosBE.GstrLBN_OPERACION_FECHA);
			map.put("OPERACION_HORA", PagosDocumentosBE.GstrLBN_OPERACION_HORA);

			mapDatosLogin = obtenerEmpresaByIDCasoLogin(PagosDocumentosBE.GstrID_CASO_LOGIN);

			nombreEmpresaCargo = mapDatosLogin.get("strNombre");
			map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
			map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));

			map.put("ID_CASO_LOGIN_CARGO", PagosDocumentosBE.GstrID_CASO_LOGIN);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO", formatearCuenta(PagosDocumentosBE.strCMB_CUENTA_CARGO));
			map.put("CMB_TIPO_PRODUCTO_CARGO", obtenerTipoCuenta(PagosDocumentosBE.strCMB_CUENTA_CARGO));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(PagosDocumentosBE.strCMB_CUENTA_CARGO));

			objSQL.listaTablaIdCaso("APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_D",
					" where ID_CASO=" + PagosDocumentosBE.GstrID_CASO_LOTE, 3);
			ResultSet Rst_Funcionalidad = Mdl_Variables.Grst_NuevaTabla;
			if (Rst_Funcionalidad.next() == true) {
				mapDatosLogin = obtenerEmpresaByIDCasoLogin(Rst_Funcionalidad.getString("ID_CASO_LOGIN"));

				nombreEmpresaCargo = mapDatosLogin.get("strNombre");
				map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
				map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));

				map.put("ID_CASO_LOGIN_ABONO_0", Rst_Funcionalidad.getString("ID_CASO_LOGIN"));
				map.put("CMB_EMPRESA_ABONO_0", nombreEmpresaCargo);
				map.put("LNK_NUMERO_CUENTA_ABONO_0",
						formatearCuenta(Rst_Funcionalidad.getString("CMB_CUENTA_CORRIENTE")));
				map.put("CMB_TIPO_PRODUCTO_ABONO_0",
						obtenerTipoCuenta(Rst_Funcionalidad.getString("CMB_CUENTA_CORRIENTE")));
				map.put("CMB_MONEDA_ABONO_0", obtenerMoneda(Rst_Funcionalidad.getString("CMB_CUENTA_CORRIENTE")));
				map.put("NUMERO_CUENTAS_ABONO", "1");
			} else {
				map.put("NUMERO_CUENTAS_ABONO", "0");
			}
			break;
		case "APP_TRANSFERENCIAS_EXTERIOR":
			map.put("ID_CASO_LOTE", TransferenciasExteriorBE.GstrID_CASO);
			map.put("TABLA_CARGA", "APP_TRANSFERENCIAS_EXTERIOR");
			map.put("OPERACION_FECHA", TransferenciasExteriorBE.GstrLBL_FECHA);
			map.put("OPERACION_HORA", TransferenciasExteriorBE.GstrLBL_HORA);

			mapDatosLogin = obtenerEmpresaByIDCasoLogin(TransferenciasExteriorBE.GstrID_CASO_LOGIN);

			nombreEmpresaCargo = mapDatosLogin.get("strNombre");
			map.put("TIE_CARGO", mapDatosLogin.get("strTie_Cargo"));
			map.put("CLAVE_CARGO", mapDatosLogin.get("strContrasenia_Cargo"));

			map.put("ID_CASO_LOGIN_CARGO", TransferenciasExteriorBE.GstrID_CASO_LOGIN);
			map.put("CMB_EMPRESA_CARGO", nombreEmpresaCargo);
			map.put("LNK_NUMERO_CUENTA_CARGO", formatearCuenta(TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO));
			map.put("CMB_TIPO_PRODUCTO_CARGO", obtenerTipoCuenta(TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO));
			map.put("CMB_MONEDA_CARGO", obtenerMoneda(TransferenciasExteriorBE.GstrCMB_CUENTA_CARGO));
			map.put("NUMERO_CUENTAS_ABONO", "0");
			break;
		// case "TBL_TRANSFERENCIA_ENTRE_CUENTA_PORTABILIDAD":
		// map.put("ID_CASO_LOTE",PortabilidadAutorizacionBE.Gstr_ID_CASO);
		// map.put("TABLA_CARGA","APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D");
		// map.put("OPERACION_FECHA",PortabilidadAutorizacionBE.GstrLBN_OPERACION_FECHA);
		// map.put("OPERACION_HORA",PortabilidadAutorizacionBE.GstrLBN_OPERACION_HORA);
		//
		// if(PortabilidadAutorizacionBE.GstrCMB_EMPRESA_CUENTA_ORIGEN.equals(Mdl_Variables.Gstr_Ignore)){
		// mapDatosLogin=obtenerEmpresaByIDCasoLogin(PortabilidadAutorizacionBE.Gstr_ID_CASO_LOGIN);
		//
		// nombreEmpresaCargo=mapDatosLogin.get("strNombre");
		// map.put("TIE_CARGO",mapDatosLogin.get("strTie"));
		// map.put("CLAVE_CARGO",mapDatosLogin.get("strContrasenia"));
		// idLoginAbono=PortabilidadAutorizacionBE.Gstr_ID_CASO_LOGIN;
		// nombreEmpresaAbono=nombreEmpresaCargo;
		// }else{
		// nombreEmpresaCargo=PortabilidadAutorizacionBE.GstrCMB_EMPRESA_CUENTA_ORIGEN;
		// mapDatosLogin=obtenerIDLoginByNombreEmpresa(PortabilidadAutorizacionBE.GstrCMB_EMPRESA_CUENTA_DESTINO,map,0);
		// idLoginAbono=mapDatosLogin.get("strIdLogin_Abono");
		// map.put("TIE_CARGO",mapDatosLogin.get("strTie_Cargo"));
		// map.put("CLAVE_CARGO",mapDatosLogin.get("strContrasenia_Cargo"));
		//
		// nombreEmpresaAbono=PortabilidadAutorizacionBE.GstrCMB_EMPRESA_CUENTA_DESTINO;
		// }
		//
		// map.put("ID_CASO_LOGIN_CARGO",PortabilidadAutorizacionBE.Gstr_ID_CASO_LOGIN);
		// map.put("CMB_EMPRESA_CARGO",nombreEmpresaCargo);
		// map.put("LNK_NUMERO_CUENTA_CARGO",formatearCuenta(PortabilidadAutorizacionBE.GstrCMB_CUENTA_ORIGEN));
		// map.put("CMB_TIPO_PRODUCTO_CARGO",obtenerTipoCuenta(PortabilidadAutorizacionBE.GstrCMB_CUENTA_ORIGEN));
		// map.put("CMB_MONEDA_CARGO",obtenerMoneda(PortabilidadAutorizacionBE.GstrCMB_CUENTA_ORIGEN));
		// map.put("ID_CASO_LOGIN_ABONO_0",idLoginAbono);
		// map.put("CMB_EMPRESA_ABONO_0",nombreEmpresaAbono);
		// map.put("LNK_NUMERO_CUENTA_ABONO_0",formatearCuenta(PortabilidadAutorizacionBE.GstrCMB_CUENTA_DESTINO));
		// map.put("CMB_TIPO_PRODUCTO_ABONO_0",obtenerTipoCuenta(PortabilidadAutorizacionBE.GstrCMB_CUENTA_DESTINO));
		// map.put("CMB_MONEDA_ABONO_0",obtenerMoneda(PortabilidadAutorizacionBE.GstrCMB_CUENTA_DESTINO));
		// map.put("NUMERO_CUENTAS_ABONO","1");
		// break;
		}
		return map;
	}

	private static Map<String, String> obtenerEmpresaByIDCasoLogin(String gstr_ID_CASO_LOGIN) throws SQLException {
		Map<String, String> mapDatosLogin = new HashMap<String, String>();
		objSQL.listaTablaIdCaso(
				"select top 1 NOMBRE_EMPRESA,TIE,Contraseña from Operador_Firmante f , TBL_EMPRESA e where f.ID_EMPRESA=e.ID_EMPRESA and IDLOGIN="
						+ gstr_ID_CASO_LOGIN,
				"", 5);
		ResultSet Rst_Funcionalidad = Mdl_Variables.Grst_NuevaTabla;
		while (Rst_Funcionalidad.next() == true) {
			mapDatosLogin.put("strNombre", Rst_Funcionalidad.getString("NOMBRE_EMPRESA"));
			mapDatosLogin.put("strTie_Cargo", Rst_Funcionalidad.getString("TIE"));
			mapDatosLogin.put("strContrasenia_Cargo", Rst_Funcionalidad.getString("Contraseña"));
		}
		return mapDatosLogin;
	}

	private static String formatearCuenta(String cuenta) {
		String cuentaFormateada = "";
		int tam = cuenta.length();
		cuentaFormateada = "100-" + cuenta.substring(tam - 10, tam);
		return cuentaFormateada;
	}

	private static Map<String, String> obtenerIDLoginByNombreEmpresa(String nombreEmpresa, Map<String, String> map,
			int i) throws SQLException {
		String IDLogin = "";
		boolean IDLoginGuardado = false;
		Map<String, String> mapDatosLogin = new HashMap<String, String>();

		if (i > 0) {
			int j = 0;
			while (j < i || IDLoginGuardado) {
				String empresaGuardada = map.get("CMB_EMPRESA_ABONO_" + j);
				if (empresaGuardada != null) {
					if (empresaGuardada.equals(nombreEmpresa)) {
						IDLogin = map.get("ID_CASO_LOGIN_ABONO_" + j);
						objSQL.listaTablaIdCaso("select top 1  TIE,Contraseña from Operador_Firmante where IDLOGIN="
								+ map.get("ID_CASO_LOGIN_CARGO") + " order by Nro", "", 5);
						ResultSet Rst_Funcionalidad = Mdl_Variables.Grst_NuevaTabla;
						while (Rst_Funcionalidad.next() == true) {
							IDLogin = Rst_Funcionalidad.getString("IDLOGIN");
							mapDatosLogin.put("strTie_Abono", Rst_Funcionalidad.getString("TIE"));
							mapDatosLogin.put("strContrasenia_Abono", Rst_Funcionalidad.getString("Contraseña"));
							mapDatosLogin.put("strIdLogin_Abono", IDLogin);
						}
						IDLoginGuardado = true;
					}
				}
				j++;
			}
		}

		if (!IDLoginGuardado) {
			objSQL.listaTablaIdCaso(
					"select top 1 IDLOGIN ,TIE,Contraseña from Operador_Firmante f , TBL_EMPRESA e where f.ID_EMPRESA=e.ID_EMPRESA and NOMBRE_EMPRESA='"
							+ nombreEmpresa + "' order by Nro",
					"", 5);
			ResultSet Rst_Funcionalidad = Mdl_Variables.Grst_NuevaTabla;
			while (Rst_Funcionalidad.next() == true) {
				IDLogin = Rst_Funcionalidad.getString("IDLOGIN");
				mapDatosLogin.put("strIdLogin_Abono", IDLogin.substring(0, IDLogin.length() - 2));
				mapDatosLogin.put("strTie_Abono", Rst_Funcionalidad.getString("TIE"));
				mapDatosLogin.put("strContrasenia_Abono", Rst_Funcionalidad.getString("Contraseña"));
			}
		}
		return mapDatosLogin;
	}

}