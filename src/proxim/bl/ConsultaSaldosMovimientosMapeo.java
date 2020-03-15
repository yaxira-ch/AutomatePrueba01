package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ConsultaSaldosMovimientosBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaSaldosMovimientosMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	boolean bandera=false;
	
	public boolean seleccionarSubMenu1(String LstrProducto) throws InterruptedException, IOException{	
		boolean var=false;
		for(int i=1;i<=2;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorTabs']/li["+i+"]//a")).getText();
			if(LstrProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
				break;
				
			}
		}
		return var;			
	}
	public boolean verificarPestania(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[1]/div/li[1]");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[1]/select",LstrProducto);
	}
	
	public boolean seleccionarEmpresaMovimiento(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/select",LstrProducto);
	}
	
	public boolean seleccionarTipoCuentaMovimiento(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/select",LstrProducto);
	}
	
	public boolean seleccionarMonedaMovimiento(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/select",LstrProducto);
	}
	
	public boolean seleccionarTipoProducto(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.cssSelector, "div.posicionIntegradaFiltroProducto > select.gwt-ListBox",LstrProducto);
	}
	
	public boolean seleccionarMoneda(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.cssSelector, "div.posicionIntegradaFiltroMoneda > select.gwt-ListBox",LstrProducto);
	}
	
	public boolean guardarSaldoDisponible(String LstrProducto) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		boolean bandera = false;
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String numCuenta=colss.get(1).getText();
		
			
			if (LstrProducto.equals(numCuenta)){//ESTADO
				bandera= objConexionSqlServer.modificarSaldoDisponible(colss.get(3).getText());
				
				break;
			}
		}
		return bandera;		
	}
	
	public boolean guardarSaldoDisponible1(String LstrProducto) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		boolean bandera = false;
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String numCuenta=colss.get(1).getText();
			String nuevoNumCuenta=numCuenta.substring(4,14);
			
			if (LstrProducto.equals(nuevoNumCuenta)){//ESTADO
				bandera= objConexionSqlServer.modificarSaldoDisponible(colss.get(3).getText());
				break;
			}
		}
		return bandera;		
	}
	
	public boolean clickNumeroCuenta(String LstrProducto) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		boolean bandera = false;
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String numCuenta=colss.get(1).getText();
			String nuevoNumCuenta=numCuenta.substring(4,14);
			
			if (LstrProducto.equals(nuevoNumCuenta)){//ESTADO
				colss.get(3).click();
				bandera = true;
				break;
			}
		}
		return bandera;		
	}
	
	public String obtenerTotalSolesEmepresa() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[5]/div/div[1]/span");
		return strMensaje;
	}
	
	public boolean ingresarAlias(String LstrProducto) throws InterruptedException, IOException{		
		Boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		
		for (int j = 1;j<=39;j++){
		
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if(colss.get(1).getText().equals(ConsultaSaldosMovimientosBE.GstrTXT_NUMERO_CUENTA)){//producto
				tabla.findElement(By.xpath("//tr["+j+"]/td[3]/div/div[2]/a/img")).click();
				tabla.findElement(By.xpath("(//input[@name=''])["+j+"]")).clear();
				tabla.findElement(By.xpath("(//input[@name=''])["+j+"]")).sendKeys(LstrProducto);
			    tabla.findElement(By.xpath("//tr["+j+"]/td[3]/div/div[2]/a/img")).click();
						var=true;
						break;
			}
		}
		return var;
	}
	
	public boolean ingresoLinkEnviarTexto() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[7]/div/div[2]/a");		
	}
	
	public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[7]/div/div[4]/a");		
	}
	
	public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[7]/div/div[5]/a");		
	}
	
	public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[7]/div/div[6]/a");		
	}
	
	public boolean seleccionarLinkNumeroCuenta() throws InterruptedException, IOException{	
		Boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		
		for (int j = 1;j<=numero;j++){			
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String columna=colss.get(1).getText().substring(colss.get(1).getText().length()-10, colss.get(1).getText().length());
			String bd=ConsultaSaldosMovimientosBE.GstrLNK_NUMERO_CUENTA.substring(ConsultaSaldosMovimientosBE.GstrLNK_NUMERO_CUENTA.length()-10, ConsultaSaldosMovimientosBE.GstrLNK_NUMERO_CUENTA.length());
			if(columna.equals(bd)){//producto
				colss.get(1).click();
				var=true;
				break;
			}
		}
		return var;	
	}
	
	public boolean obtenerSaldoByNumeroCuenta(String lstrNumeroCuenta) throws InterruptedException, IOException{	
		Boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++){
		
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			if(colss.get(1).getText().equals(lstrNumeroCuenta)){//producto
				Mdl_Variables.Gstr_SaldoDisponible=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[4]/div/div/div/table/tbody[1]/tr["+j+"]/td[4]/div/div/a");
				var=true;
				break;
			}
		}
		return var;	
	}
	
	
	public boolean verificarMovimientosCuenta(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean visibleMovimientosCuenta(){		
		try {
			bandera = objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean verificarSaldosCuenta(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/h2/span");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean visibleSaldosCuenta(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[1]/h2/span");
		} catch (Exception e) {
			bandera=false;
		}
		return bandera;
	}
	
	public boolean ingresoBotonSaldoDisponible() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]/img");		
	}
	
	public boolean ingresoBotonDepositoCheque() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/table/tbody/tr/td[1]/img");		
	}
	
	public boolean ingresoLinkRegresarSaldo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[7]/a");		
	}
	
	public boolean ingresoLinkExportarExcelSaldo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[8]/div/div[4]/a");		
	}
	
	public boolean ingresoLinkExportarPDFSaldo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[8]/div/div[5]/a");		
	}
	
	public boolean ingresoLinkImprimirSaldo() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[8]/div/div[6]/a");		
	}
	
	public boolean seleccionarLinkSaldoDisponible() throws InterruptedException, IOException{	
		Boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		for (int j = 1;j<=num.size()-2;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String columna=colss.get(1).getText().substring(colss.get(1).getText().length()-10, colss.get(1).getText().length());
			String bd=ConsultaSaldosMovimientosBE.GstrTXT_NUMERO_CUENTA.substring(ConsultaSaldosMovimientosBE.GstrTXT_NUMERO_CUENTA.length()-10, ConsultaSaldosMovimientosBE.GstrTXT_NUMERO_CUENTA.length());
			if(columna.equals(bd)){//producto
				Mdl_Variables.Gwed_Driver.findElement(By.linkText(colss.get(3).getText())).click();
				var=true;
				break;
			}
		}
		return var;	
	}
	
	public boolean seleccionarLinkSaldoDisponible1(String Numero_Cuenta_Buscar) throws InterruptedException, IOException{	
		Boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		String strNumeroCuenta,strNumCuent;
		
		for (int j = 1;j<=num.size()-2;j++){
		
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			strNumCuent=colss.get(1).getText();
			strNumeroCuenta=strNumCuent.substring(4, strNumCuent.length());
			if(strNumeroCuenta.equals(Numero_Cuenta_Buscar)){//producto
				Mdl_Variables.Gwed_Driver.findElement(By.linkText(colss.get(3).getText())).click();
				var=true;
				break;
			}
		}
		return var;	
	}
	
	public boolean verDetalle(String LstrProducto) throws InterruptedException, IOException{		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		boolean bandera = false;
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String numCuenta=colss.get(1).getText();
			String nuevoNumCuenta=numCuenta.substring(4,14);
			
			if (LstrProducto.equals(nuevoNumCuenta)){//ESTADO
				colss.get(3).click();
				
				break;
			}
		}
		return bandera;		
	}
	
	public boolean seleccionarCuentaMovimiento(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/select",LstrProducto);
	}

	
	public boolean seleccionarFechaProceso() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[4]/div/span[2]/input");		
	}
	
	public boolean seleccionarFechaOperacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[4]/div/span[1]/input");		
	}
	
	public boolean ingresarFechaDesde(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[4]/div/div/div[1]/input", Descripcion);
	}
	
	public boolean ingresarFechaHasta(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[4]/div/div/div[2]/input", Descripcion);
	}
	
	public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[7]/div/a/img");		
	}
	
	
	public boolean verificarTablaResultado() throws InterruptedException, IOException{  
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table");
	}
	
	public String BuscarCadenaTabla(String strCadena, String seccionGrilla) throws InterruptedException, IOException{		
		int intColumna=0;
		String strPathPagina = "";
		boolean caso=true;
		WebElement tabla=null;
		List<WebElement> num=null;
		
		switch (seccionGrilla) {
			case "DetalleMovimientosMontoCuentaPlazos":
				intColumna=3;
				strPathPagina = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table"));
				break;
				
			case "DetalleMovimientosSaldoDisponible":
				intColumna=4;
				strPathPagina = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table"));
				break;
			
			case "DetalleMovimientosMonto":
				intColumna=4;
				strPathPagina = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table"));
				break;
				
			case "DetalleMovimientosSaldoContable":
				intColumna=5;
				strPathPagina = "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table"));
				break;
				
			case "SaldoDisponibleCuenta":
				intColumna=3;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
				break;
			
			case "DetalleSaldo":
				intColumna=5;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[5]/li/table"));
				break;
				
			case "DetallValorCuota":
				intColumna=3;
				strPathPagina = "";
				tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[5]/li/table"));
				break;
				
			default:
				
				break;
		}
		String strTexto;
		String nuevaCadena="";
		
		boolean booleanLink=false;
		int j=2;	
		while(caso){
			
			
			num=tabla.findElements(By.xpath(".//tr"));
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
			
			if (seccionGrilla.equals("DetalleMovimientosMonto") || seccionGrilla.equals("DetalleMovimientosSaldoContable") ){
			
				booleanLink=objObjetosGenerales.existElement(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
					if (j==2){
						j=+2;
					}
			}else if (seccionGrilla.equals("SaldoDisponibleCuenta")){
				booleanLink=false;
			}else{
				booleanLink=objObjetosGenerales.existElement(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
				j=+1;
			}
						
			if(booleanLink){
				objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,strPathPagina+"["+j+"]");
			}else{
				caso=false;
				
			}
		}
		
		return nuevaCadena;		
	}
	
	
	public boolean ingresoLinkEnviarTextoMovimientos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[5]/div/div[2]/a");		
	}
	
	public boolean ingresoLinkExportarExcelMovimientos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[5]/div/div[4]/a");		
	}
	
	public boolean ingresoLinkExportarPDFMovimientos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[5]/div/div[5]/a");		
	}
	
	public boolean ingresoLinkImprimirMovimientos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[5]/div/div[6]/a");		
	}
	
	public boolean ingresoLinkRegresarMovimientos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/a");		
	}
	
	public boolean comparaSaldos() throws InterruptedException, IOException{		
		Boolean var=false;
		String saldoDisponible="";
		String saldoContable="";
		String NuevosaldoDispoonible="";
		String NuevosaldoContable="";
		int rowCount;
		int id_caso_tabla;

		try {
			saldoDisponible=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[1]/span" );
			saldoContable=objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[3]/span" );

				objConexionSqlServer.listaTablaIdCaso("Select * from [dbo].[APP_CONSULTA_SALDOS_MOVIMIENTOS_DETALLE_D] "
						+ "where idCaso='"+ConsultaSaldosMovimientosBE.Gstr_ID_CASO+"' AND ISNULL(Validado,'')=''","",7);
				
				if(Mdl_Variables.Grst_RegistroBPI.last()){
					rowCount = Mdl_Variables.Grst_RegistroBPI.getRow();
				    Mdl_Variables.Grst_RegistroBPI.beforeFirst();
					
				    if(rowCount!=0){
				    	id_caso_tabla = Mdl_Variables.Grst_RegistroBPI.getInt("ID");
				    	NuevosaldoDispoonible=Mdl_Variables.Grst_RegistroBPI.getString("SaldoDisponible");
						NuevosaldoContable=Mdl_Variables.Grst_RegistroBPI.getString("SaldoContable");
						
						bandera= objConexionSqlServer.listaTablaQueryDinamico("UPDATE  [dbo].[APP_CONSULTA_SALDOS_MOVIMIENTOS_DETALLE_D]"
								+ "SET Validado='X'"
								+ "where ID="+id_caso_tabla);
						
						if (NuevosaldoContable.equals(saldoContable) && NuevosaldoDispoonible.equals(saldoDisponible)){
							var=true;
						}
				    }	
				}
			
			
		} catch (SQLException e) {
			var=false;
		}
		return var;
	}
	
	public String obtenerCapital() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[4]/div[1]/span");
		return strMensaje;
	}
	public String obtenerDepositoCheque() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[4]/div[2]/span");
		return strMensaje;
	}
	public String obtenerTotalRetenciones() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[4]/div[3]/span");
		return strMensaje;
	}
	public String obtenerMontoCancelacion() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[4]/div[4]/span");
		return strMensaje;
	}
	public String obtenerInteresProyectadoVencimiento() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[4]/div[6]/span");
		return strMensaje;
	}
	
	public String obtenerSaldodisponible() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[1]/span");
		return strMensaje;
	}
	
	public String obtenerSaldoNoDisponible() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]/div/span/strong");
		return strMensaje;
	}
	
	public String obtenerDepositoConCheques() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/table/tbody/tr/td[2]/div/span/strong");
		return strMensaje;
	}
	
	public String obtenerUnDia() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/div/div/div/div/div[1]/span");
		return strMensaje;
	}
	
	public String obtenerDosDias() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/div/div/div/div/div[2]/span");
		return strMensaje;
	}
	
	public String obtenerTresDias() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/div/div/div/div/div[3]/span");
		return strMensaje;
	}
	
	public String obtenerMasTresDias() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/div/div/div/div/div[4]/span");
		return strMensaje;
	}
	
	public String obtenerOtrasRetenciones() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/div/div/div/div/div[5]/span");
		return strMensaje;
	}
	
	public String obtenerSaldoContable() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[3]/span");
		return strMensaje;
	}
	
	public String obtenerSobregiroAutorizado() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[4]/span");
		return strMensaje;
	}
	
	public String obtenerInteres() throws InterruptedException, IOException{
		String strMensaje= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div[3]/div[5]/span");
		return strMensaje;
	}
	
	public int seleccionarCodigoUbicacion() throws InterruptedException, IOException{	
		int numTotal=0;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table"));
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		for (int j = 1;j<=numero;j++){
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String codigoUnico=colss.get(6).getText();
			
			if(codigoUnico.equals(ConsultaSaldosMovimientosBE.GstrCODIGO_UBICACION)){
				numTotal=j;
				break;
			}
		}
		
		return numTotal;	
	}
	
	public boolean verificarPopUp(){  
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[4]/a");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean HacerClicCodigoUnico(int numeroFila) throws InterruptedException, IOException{	
		Boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table"));
		List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+numeroFila+"]/td")));
		colss.get(6).click();
		
		if(verificarPopUp()){
			var=true;
		}else{
			var=false;
		}
		
		return var;	
	}
	
	public boolean validarCampos() throws InterruptedException, IOException{	
		boolean blnValorCampo=false;
		String strTitulo, strCodigo, strDescarga;
		boolean blnCompara1=false;
		boolean blnCompara2=false;
		boolean blnCompara3=false;
		
		strTitulo= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[1]" );
		if(strTitulo.equals("Detalle de ubicación")){
			blnCompara1=true;
		}
		
		strCodigo= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[3]/div/div/div[5]/div/div/table/tbody[1]/tr/td[1]/div" );
		if(strCodigo.equals(ConsultaSaldosMovimientosBE.GstrCODIGO_UBICACION)){
			blnCompara2=true;
		}
		
		strDescarga= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[4]/a" );
		if(strDescarga.equals("Descarga aquí la lista completa de todos nuestros canales")){
			blnCompara3=true;
		}
		
		if(blnCompara1&&blnCompara2&&blnCompara3){
			blnValorCampo=true;
		}
		return blnValorCampo;
	}
	
	public boolean ingresoBtn_CerrarPopUp() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[1]/td[2]/div/a");		
	}
	
	public boolean ingresoLinkDescargar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div[4]/a");		
	}
	
	public boolean comparaMovimietnosCicsBpi() throws InterruptedException, IOException{		
		Boolean var=true;
		String fechaOperacion="";
		String fechaProceso="";
		String descripcion="";
		//String referencia="";
		String montoGeneral="";
		String moneda="";
		String tipoOperacion="";
		String monto="";
		String mensajeExiste="";
		int rowCount;
		int id_caso_tabla;
		//boolean existeBusqueda=true;
		//boolean bandera=true;
		try {
			
			if(objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[2]/div[2]/div/div" )){
				
				mensajeExiste= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[2]/div[2]/div/div" );
				if(mensajeExiste.equals("Lo sentimos, no tenemos información registrada para tu consulta")){
					
					objConexionSqlServer.listaTablaIdCaso("Select * from [dbo].[APP_CONSULTA_SALDOS_MOVIMIENTOS_DETALLE_D] where"
							+ "idcASO='"+ConsultaSaldosMovimientosBE.Gstr_ID_CASO,"",7);
					
					if(Mdl_Variables.Grst_RegistroBPI.last()){
						rowCount = Mdl_Variables.Grst_RegistroBPI.getRow();
					    Mdl_Variables.Grst_RegistroBPI.beforeFirst();
						
					    if(rowCount==0){
					    	var=true;
						}
					}
				}
			}else{
			
				while(bandera=true){
					WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
					List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
					
					for (int j = 1;j<=num.size()-2;j++){
						
						List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
						fechaOperacion=colss.get(0).getText();
						fechaProceso=colss.get(1).getText();
						descripcion=colss.get(2).getText();
						//referencia=colss.get(3).getText();
						montoGeneral=colss.get(4).getText();
						
						if (montoGeneral.substring(0,2).equals("S/.")){
							moneda="S/.";
						}else{
							if (montoGeneral.substring(0,2).equals("US$")){
								moneda="US$";
							}
						}
						
						if (montoGeneral.substring(3,4).equals("-")){
							tipoOperacion="-";//de
							monto=montoGeneral.substring(4,montoGeneral.length());
						}else{
							tipoOperacion="";//abono
							monto=montoGeneral.substring(3,montoGeneral.length());
						}
						
						objConexionSqlServer.listaTablaIdCaso("Select ID from [dbo].[APP_CONSULTA_SALDOS_MOVIMIENTOS_DETALLE_D] "
								+ "where idCaso='"+ConsultaSaldosMovimientosBE.Gstr_ID_CASO+"' "
								+ "and fechaOperacion='"+fechaOperacion+"' "
								+ "and fechaProceso='"+fechaProceso+"'	"
								+ "and tipoOperacion='"+tipoOperacion+"' "
								+ "and moneda='"+moneda+"' "
								+ "and monto='"+monto+"' "
								+ "and descripcion='"+descripcion+"' "
								+ "AND ISNULL(Validado,'')=''","",7);
						
						if(Mdl_Variables.Grst_RegistroBPI.last()){
							rowCount = Mdl_Variables.Grst_RegistroBPI.getRow();
						    Mdl_Variables.Grst_RegistroBPI.beforeFirst();
							
						    if(rowCount!=0){
						    	id_caso_tabla = Mdl_Variables.Grst_RegistroBPI.getInt("ID");
							
						    	bandera= objConexionSqlServer.listaTablaQueryDinamico("UPDATE  [dbo].[APP_CONSULTA_SALDOS_MOVIMIENTOS_DETALLE_D]"
										+ "SET Validado='X'"
										+ "where ID="+id_caso_tabla);
							}else{
								objConexionSqlServer.insertCampo("insert into [APP_CONSULTA_SALDOS_MOVIMIENTOS_DETALLE_D] values"
										+ " ('"+ConsultaSaldosMovimientosBE.Gstr_ID_CASO+"','"+fechaOperacion+"','"+fechaProceso+"','"+tipoOperacion+"',"
										+ "'"+moneda+"','"+monto+"','"+descripcion+"',NULL,NULL,'N')");
								var=false;
							}
						}
					}
					
					if(objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a[2]" )){
						
						mensajeExiste= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a[2]" );
						if(mensajeExiste.equals("Siguiente")){
							objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a[2]");	
						}else{
							if(objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a[4]" )){
								
								mensajeExiste= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a[4]" );
								if(mensajeExiste.equals("Siguiente")){
									objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/h3[1]/div/div/a[4]");	
								}
							}else{
								bandera=false;
							}
						}
					}else{
						bandera=false;
					}
				}
				
				//VERIFICAR SI EXISTE ALGUN REGISTRO QUE NO ESTA EN LA BPI
				objConexionSqlServer.listaTablaIdCaso("Select * from [dbo].[APP_CONSULTA_SALDOS_MOVIMIENTOS_DETALLE_D] where"
						+ "idcASO='"+ConsultaSaldosMovimientosBE.Gstr_ID_CASO+"' AND (ISNULL(Validado,'')='' OR Validado='N')","",7);
				
				if(Mdl_Variables.Grst_RegistroBPI.last()){
					rowCount = Mdl_Variables.Grst_RegistroBPI.getRow();
				    Mdl_Variables.Grst_RegistroBPI.beforeFirst();
					
				    if(rowCount!=0){
				    	var=false;
				    	//MUESTRE UN MENSAJE CON LOS RESULTADOS OBTENIDOS
					}
				}
			}	
			
		} catch (SQLException e) {
			var=false;
		}
		return var;
	}
	
	public boolean buscarMonto(String strMonto) throws InterruptedException, IOException{		
		Boolean var=false;
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/table"));
			
		
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		for (int j = 1;j<=num.size()-2;j++)
		{
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			String strMontoMonivimientos=colss.get(4).getText();
			if (strMontoMonivimientos.equals(strMonto) ){//Compara con el nombre del LOTE
				var = true;
				break;
			}
		}
		return var;
	}
	
	public boolean seleccionarEmpresaEstadoCuenta(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/select",LstrProducto);
	}
	
	public boolean seleccionarCuentaEstadoCuenta(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/select",LstrProducto);
	}
	
	public boolean ingresoBotonEstadoCuenta() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[4]/div/a/img");		
	}
	
	public boolean ingresoVerificarError(String columna, String mensaje) throws InterruptedException, IOException{	
		boolean var=false;
		String mensajeErrorMostrado="";
		switch (columna) 
		{
			case "TXT_FECHA_DESDE,TXT_FECHA_HASTA": //LOGIN
				mensajeErrorMostrado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[4]/div/span[3]" );
				
				if(mensaje.equals(mensajeErrorMostrado)){
					var=true;
				}
				break;
			
			case "CMB_EMPRESA_MOVIMIENTO": //LOGIN
				mensajeErrorMostrado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/span[1]" );
				
				if(mensaje.equals(mensajeErrorMostrado)){
					var=true;
				}
				break;
				
			case "CMB_TIPO_CUENTA": //LOGIN
				mensajeErrorMostrado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/span[1]" );
				
				if(mensaje.equals(mensajeErrorMostrado)){
					var=true;
				}
				break;
				
			case "CMB_CUENTA_MOVIMIENTO": //LOGIN
				mensajeErrorMostrado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[3]/span[1]" );
				
				if(mensaje.equals(mensajeErrorMostrado)){
					var=true;
				}
				break;
				
			case "CMB_EMPRESA": //LOGIN
				mensajeErrorMostrado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[1]/span[1]" );
				
				if(mensaje.equals(mensajeErrorMostrado)){
					var=true;
				}
				break;
				
			case "CMB_CUENTA": //LOGIN
				mensajeErrorMostrado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[2]/span[1]" );
				
				if(mensaje.equals(mensajeErrorMostrado)){
					var=true;
				}
				break;
		}	
		return var;
	}
}
