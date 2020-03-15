package proxim.bl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.be.TransferenciasExteriorBE;
import proxim.dao.Mdl_Variables;

public class TransferenciaExteriorHistoricoMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();

	public boolean seleccionarOpcion(String LstrProducto) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		boolean var=false;
		for(int i=1;i<=4;i++){
			String valor= Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div[@class='contenedorTabs']/li["+i+"]//a")).getText();
			if(LstrProducto.equals(valor)){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//div[@class='contenedorTabs']/li["+i+"]//a");
				break;
			}
		}
		return var;
	}

	public boolean seleccionarTipoConsulta(String strTipoConsulta) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[2]/tbody/tr/td[2]/select",strTipoConsulta);
	}
	
	public boolean seleccionarEstado(String strEstado) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[3]/tbody/tr/td[2]/select",strEstado);
	}

	public boolean ingresarFechaDesde(String fecha) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/input" , fecha);
	}

	public boolean ingresarFechaHasta(String fecha) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[4]/tbody/tr/td[2]/table/tbody/tr/td/div/div[2]/input" , fecha);
	}

	public boolean buscar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[3]/button");
	}

	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr/td[2]/select",strEmpresa);
	}

	public boolean ingresarEnvioCorreo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[1]/a");
	}

	public boolean ingresarTituloCorreo(String Descripcion) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	}

	public boolean ingresarMensajeCorreo(String Descripcion) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	}

	public boolean enviarCorreo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a");
	}

	public void aceptarEnvio() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a");
	}

	public boolean exportarExcel() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[4]/a");
	}

	public boolean exportarPdf() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[5]/a");
	}

	public boolean imprimir() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[7]/div/div[6]/a");
	}

	public boolean seleccionarNroReferencia(String NroReferencia,String estado) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		List<WebElement> colss;
		
		if(estado.equals(Mdl_Variables.Gstr_Parametros[10])){
			if(numero==1)
				colss = (tabla.findElements(By.xpath(".//tr/td")));	
			else
				colss = (tabla.findElements(By.xpath(".//tr[1]/td")));	
			colss.get(2).click();
			return true;
				
		}else{			
			
			for (int j = 1;j<=numero;j++)
			{
				if(numero==1)
					colss = (tabla.findElements(By.xpath(".//tr/td")));	
				else
					colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
				String nroRefTabla;
				if(estado.equals(Mdl_Variables.Gstr_Parametros[12])||estado.equals(Mdl_Variables.Gstr_Parametros[11])||estado.equals(Mdl_Variables.Gstr_Parametros[16]))
					nroRefTabla=colss.get(2).getText();
				else
					nroRefTabla=colss.get(1).getText();	
				if(nroRefTabla.equals(NroReferencia)){
					if(estado.equals(Mdl_Variables.Gstr_Parametros[12])||estado.equals(Mdl_Variables.Gstr_Parametros[11])||estado.equals(Mdl_Variables.Gstr_Parametros[16]))
						colss.get(2).click();
					else
						colss.get(1).click();	
					return true;
				}
			}
			
		}		
		
		return false;
	}

	public String verificarDetalleConsultaHistorica(String nroRefe)  throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		String valor;
		
		String TXT_NOMBRE_ORDENANTE=Mdl_Variables.map.get("TXT_NOMBRE_ORDENANTE");
		String TXT_DIRECCION_ORDENANTE=Mdl_Variables.map.get("TXT_DIRECCION_ORDENANTE");
		String TXT_TELEFONO_ORDENANTE=Mdl_Variables.map.get("TXT_TELEFONO_ORDENANTE");
		String TXT_EMAIL_ORDENANTE=Mdl_Variables.map.get("TXT_EMAIL_ORDENANTE");
		String CMB_MONEDA=Mdl_Variables.map.get("CMB_MONEDA");
		String TXT_MONTO=Mdl_Variables.map.get("TXT_MONTO");
		String CMB_CUENTA_CARGO=Mdl_Variables.map.get("CMB_CUENTA_CARGO");
		String TXT_FECHA_CARGO=Mdl_Variables.map.get("TXT_FECHA_CARGO");
		String LBL_TIPO_CAMBIO=Mdl_Variables.map.get("LBL_TIPO_CAMBIO");
		String TXT_NUMERO_TICKET=Mdl_Variables.map.get("TXT_NUMERO_TICKET");	
//		String CMB_TIPO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("CMB_TIPO_DOCUMENTO_BENEFICIARIO");	
//		String TXT_NUMERO_DOCUMENTO_BENEFICIARIO=Mdl_Variables.map.get("TXT_NUMERO_DOCUMENTO_BENEFICIARIO");	
		String TXT_NOMBRE_BENEFICIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BENEFICIARIO");
		String TXT_DIRECCION_BENEFICIARIO=Mdl_Variables.map.get("TXT_DIRECCION_BENEFICIARIO");
		String CMB_PAIS_BENEFICIARIO=Mdl_Variables.map.get("CMB_PAIS_BENEFICIARIO");
		String TXT_CIUDAD_BENEFICIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BENEFICIARIO");
		String TXT_TELEFONO_BENEFICIARIO=Mdl_Variables.map.get("TXT_TELEFONO_BENEFICIARIO");
		String TXT_CUENTA_ABONO=Mdl_Variables.map.get("TXT_CUENTA_ABONO");
		String TXT_NOMBRE_BANCO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO");
		String CMB_PAIS_BANCO=Mdl_Variables.map.get("CMB_PAIS_BANCO");
		String TXT_CIUDAD_BANCO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO");
		String CMB_TIPO_CODIGO_BANCO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO");
		String TXT_CODIGO_BANCO=Mdl_Variables.map.get("TXT_CODIGO_BANCO");
		String TXT_NOMBRE_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_NOMBRE_BANCO_INTERMEDIARIO");
		String CMB_PAIS_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_PAIS_BANCO_INTERMEDIARIO");
		String TXT_CIUDAD_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CIUDAD_BANCO_INTERMEDIARIO");
		String CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO");
		String TXT_CODIGO_BANCO_INTERMEDIARIO=Mdl_Variables.map.get("TXT_CODIGO_BANCO_INTERMEDIARIO");
		String CMB_MOTIVO_TRANSFERENCIA=Mdl_Variables.map.get("CMB_MOTIVO_TRANSFERENCIA");
		String CMB_GASTOS_CORRESPONSAL=Mdl_Variables.map.get("CMB_GASTOS_CORRESPONSAL");
		String TXT_DETALLE_PAGO=Mdl_Variables.map.get("TXT_DETALLE_PAGO");
		
		String valoresDiferentes="";
		
		if(nroRefe!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[1]/div/div[3]/span[2]");
			if(!nroRefe.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_REFERENCIA esperado: "+nroRefe+" ,obtenido: "+valor+"\n";
		}

		if(TXT_NOMBRE_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/span[4]");
			if(!TXT_NOMBRE_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_ORDENANTE esperado: "+TXT_NOMBRE_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/span[6]");
			if(!TXT_DIRECCION_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_ORDENANTE esperado: "+TXT_DIRECCION_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/span[8]");
			if(!TXT_TELEFONO_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_ORDENANTE esperado: "+TXT_TELEFONO_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(TXT_EMAIL_ORDENANTE!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/span[10]");
			if(!TXT_EMAIL_ORDENANTE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_EMAIL_ORDENANTE esperado: "+TXT_EMAIL_ORDENANTE+" ,obtenido: "+valor+"\n";
		}
		if(CMB_MONEDA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/span[12]");
			if(!CMB_MONEDA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MONEDA esperado: "+CMB_MONEDA+" ,obtenido: "+valor+"\n";
		}
		if(TXT_MONTO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/span[14]");
			if(!TXT_MONTO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_MONTO esperado: "+TXT_MONTO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_CUENTA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/span[16]");
			valor=valor.substring(0, valor.length()-11)+"-"+valor.substring(valor.length()-10, valor.length());
			CMB_CUENTA_CARGO=CMB_CUENTA_CARGO.substring(0, CMB_CUENTA_CARGO.length()-11)+"-"+CMB_CUENTA_CARGO.substring(CMB_CUENTA_CARGO.length()-10, CMB_CUENTA_CARGO.length());
			if(!CMB_CUENTA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_CUENTA_CARGO esperado: "+CMB_CUENTA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_FECHA_CARGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/div[1]/span[2]");
			if(!TXT_FECHA_CARGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_FECHA_CARGO esperado: "+TXT_FECHA_CARGO+" ,obtenido: "+valor+"\n";
		}
		if(LBL_TIPO_CAMBIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/div[2]/span[2]");
			if(!LBL_TIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- LBL_TIPO_CAMBIO esperado: "+LBL_TIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_TICKET!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/div[5]/span[2]");
			if(!TXT_NUMERO_TICKET.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_TICKET esperado: "+TXT_NUMERO_TICKET+" ,obtenido: "+valor+"\n";
		}
		/*if(CMB_TIPO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "");
			if(!CMB_TIPO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_DOCUMENTO_BENEFICIARIO esperado: "+CMB_TIPO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NUMERO_DOCUMENTO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "");
			if(!TXT_NUMERO_DOCUMENTO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NUMERO_DOCUMENTO_BENEFICIARIO esperado: "+TXT_NUMERO_DOCUMENTO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}*/
		if(TXT_NOMBRE_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[3]/div/span[4]");
			if(!TXT_NOMBRE_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BENEFICIARIO esperado: "+TXT_NOMBRE_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DIRECCION_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[3]/div/span[6]");
			if(!TXT_DIRECCION_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DIRECCION_BENEFICIARIO esperado: "+TXT_DIRECCION_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_TELEFONO_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[3]/div/div/span[2]");
			if(!TXT_TELEFONO_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_TELEFONO_BENEFICIARIO esperado: "+TXT_TELEFONO_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[3]/div/span[8]");			
			if(!CMB_PAIS_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BENEFICIARIO esperado: "+CMB_PAIS_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BENEFICIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[3]/div/span[10]");			
			if(!TXT_CIUDAD_BENEFICIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BENEFICIARIO esperado: "+TXT_CIUDAD_BENEFICIARIO+" ,obtenido: "+valor+"\n";
		}		
		if(TXT_CUENTA_ABONO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[3]/div/span[12]");
			if(!TXT_CUENTA_ABONO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CUENTA_ABONO esperado: "+TXT_CUENTA_ABONO+" ,obtenido: "+valor+"\n";
		}
		
		CapturarPantalla.pageDown("200");
		
		if(TXT_NOMBRE_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[4]/div/span[4]");
			if(!TXT_NOMBRE_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO esperado: "+TXT_NOMBRE_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[4]/div/span[6]");
			if(!CMB_PAIS_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO esperado: "+CMB_PAIS_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[4]/div/span[8]");
			if(!TXT_CIUDAD_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO esperado: "+TXT_CIUDAD_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_TIPO_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[4]/div/span[10]");
			if(!CMB_TIPO_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO esperado: "+CMB_TIPO_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[4]/div/span[12]");
			if(!TXT_CODIGO_BANCO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO esperado: "+TXT_CODIGO_BANCO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_NOMBRE_BANCO_INTERMEDIARIO!=null){
			
			CapturarPantalla.pageDown("200");
			
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/div/div/span[4]");
																		
			                                                            
			if(!TXT_NOMBRE_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_NOMBRE_BANCO_INTERMEDIARIO esperado: "+TXT_NOMBRE_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_PAIS_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/div/div/span[6]");
			if(!CMB_PAIS_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_PAIS_BANCO_INTERMEDIARIO esperado: "+CMB_PAIS_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CIUDAD_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/div/div/span[8]");
			if(!TXT_CIUDAD_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CIUDAD_BANCO_INTERMEDIARIO esperado: "+TXT_CIUDAD_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/div/div/span[10]");
			if(!CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO esperado: "+CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		if(TXT_CODIGO_BANCO_INTERMEDIARIO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[5]/div/div/span[12]");
			if(!TXT_CODIGO_BANCO_INTERMEDIARIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_CODIGO_BANCO_INTERMEDIARIO esperado: "+TXT_CODIGO_BANCO_INTERMEDIARIO+" ,obtenido: "+valor+"\n";
		}
		
		CapturarPantalla.pageDown("200");
		
		if(CMB_MOTIVO_TRANSFERENCIA!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[6]/div/span[4]");
			if(!CMB_MOTIVO_TRANSFERENCIA.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_MOTIVO_TRANSFERENCIA esperado: "+CMB_MOTIVO_TRANSFERENCIA+" ,obtenido: "+valor+"\n";
		}
		if(CMB_GASTOS_CORRESPONSAL!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[6]/div/span[6]");
			if(!CMB_GASTOS_CORRESPONSAL.equals(valor))
				valoresDiferentes=valoresDiferentes+"- CMB_GASTOS_CORRESPONSAL esperado: "+CMB_GASTOS_CORRESPONSAL+" ,obtenido: "+valor+"\n";
		}
		if(TXT_DETALLE_PAGO!=null){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[6]/div/div/pre/span");			
			if(!TXT_DETALLE_PAGO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TXT_DETALLE_PAGO esperado: "+TXT_DETALLE_PAGO+" ,obtenido: "+valor+"\n";
		}
		
		if(!TransferenciasExteriorBE.strTIPO_CAMBIO.equals("")){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/div[2]/span[2]");			
			if(!TransferenciasExteriorBE.strTIPO_CAMBIO.equals(valor))
				valoresDiferentes=valoresDiferentes+"- TIPO_CAMBIO esperado: "+TransferenciasExteriorBE.strTIPO_CAMBIO+" ,obtenido: "+valor+"\n";
		}
		
		if(!TransferenciasExteriorBE.strARBITRAJE.equals("")){
			valor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[2]/div/div[3]/span[2]");			
			if(!TransferenciasExteriorBE.strARBITRAJE.equals(valor))
				valoresDiferentes=valoresDiferentes+"- ARBITRAJE esperado: "+TransferenciasExteriorBE.strARBITRAJE+" ,obtenido: "+valor+"\n";
		}
		
		if(!valoresDiferentes.equals("")){
			valoresDiferentes="Los valores diferentes son: \n"+valoresDiferentes;
		}
		
		return valoresDiferentes;
	}

	public boolean ingresarEnvioCorreoDetalle() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[9]/div/div[1]/a");
	}

	public boolean exportarExcelDetalle() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[9]/div/div[4]/a");
	}

	public boolean exportarPdfDetalle() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[9]/div/div[5]/a");
	}

	public boolean imprimirDetalle() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[9]/div/div[6]/a");
	}

	public boolean regresar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[5]/div[2]/div[8]/div/div/a");
	}

	public boolean seleccionarSwift(String NroReferencia, String estado) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		List<WebElement> colss;
		
	
		for (int j = 1;j<=numero;j++)
		{
			if(numero==1)
				colss = (tabla.findElements(By.xpath(".//tr/td")));	
			else
				colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			String nroRefTabla;				
			nroRefTabla=colss.get(1).getText();	
			if(nroRefTabla.equals(NroReferencia)){					
					colss.get(5).click();	
				return true;
			}
		}
		
		return false;

	}

	public boolean seleccionarDebito(String NroReferencia, String estado) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//table[@class='cellTableWidget']"));
		List<WebElement> num=tabla.findElements(By.xpath(".//tr"));
		int numero=num.size()-2;
		List<WebElement> colss;
		
	
		for (int j = 1;j<=numero;j++)
		{
			if(numero==1)
				colss = (tabla.findElements(By.xpath(".//tr/td")));	
			else
				colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			
			String nroRefTabla;				
			nroRefTabla=colss.get(1).getText();	
			if(nroRefTabla.equals(NroReferencia)){					
					colss.get(6).click();	
				return true;
			}
		}
		
		return false;

	}

	public boolean ingresarEnvioCorreoSwift() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[1]/a");
	}

	public boolean exportarPdfSwift() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[5]/a");
	}

	public boolean imprimirSwift() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div/div[6]/a");
	}

	public boolean regresarSwift() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[3]/div[1]/a");
	}

	public boolean ingresarEnvioCorreoDebito() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[2]/div/div[1]/a");
	}

	public boolean exportarPdfDebito() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[2]/div/div[5]/a");
	}

	public boolean imprimirDebito() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[2]/div/div[6]/a");
	}

	public boolean regresarDebito() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/div[3]/div[1]/a");
	}
}
