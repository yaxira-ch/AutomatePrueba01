package proxim.bl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaDocumentosRelacionPagaresMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	boolean bandera=false;
	

	public boolean verificarTitulo(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/h1");
		} catch (Exception e) {
			
		}
		return bandera;
	}
	
	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[3]/table[1]/tbody/tr/td[2]/select",strEmpresa);
	}
	
	public boolean seleccionarSituacion(String strSituacion) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[3]/table[2]/tbody/tr/td[2]/select",strSituacion);
	}
	
	public boolean seleccionarMoneda(String strMoneda) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[3]/table[3]/tbody/tr/td[2]/select",strMoneda);
	}

	public boolean ingresoBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[4]/a/img");		
	}
	
	public boolean verificarTablaResultados(){		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[5]/div/div/div/div[5]/div/div/table");
		} catch (Exception e) {
			bandera = false;
		}
		return bandera;
	}
	
	public boolean guardarTabla(String strID_caso) {		

		bandera = false;	
		//-------SQL BORRAR TABLA DETALLE----------
		String strQuery = "";
		strQuery += " DELETE FROM APP_AND_CONSULTA_PAGARES_TABLA_D ";
		strQuery += " WHERE ID_CASO = "+ strID_caso +" ; ";
		objSQL.listaTablaQueryDinamico(strQuery);
		
		
		//List<String[]> lista = null;//Arrays.asList(new String[]{"1", "2"}, new String[]{"1", "2"});
		String[] strRegTemp;
		
		
		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[5]/div/div/div/div[5]/div/div/table"));
		boolean bandera = false;
		List<WebElement> reg=tabla.findElements(By.xpath(".//tr"));
		int numregs=reg.size()-2;
		for (int j = 1 ;j<=numregs;j++)
		{
			strRegTemp = null;
			strRegTemp = new String[7]; 
			List<WebElement> colss = (tabla.findElements(By.xpath(".//tr["+j+"]/td")));
			strRegTemp[0] = colss.get(0).getText();
			strRegTemp[1] = colss.get(1).getText();
			strRegTemp[2] = colss.get(2).getText();
			strRegTemp[3] = colss.get(3).getText();
			strRegTemp[4] = colss.get(4).getText();
			strRegTemp[5] = colss.get(5).getText();
			strRegTemp[6] = colss.get(6).getText();
			//lista.add(strRegTemp);
			
			//------------SQL INSERTAR REGISTRO-----------
			String strFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
			strQuery = "";
			strQuery += " INSERT INTO APP_AND_CONSULTA_PAGARES_TABLA_D ";
			strQuery += " VALUES ("+strID_caso+" ,";
			strQuery += " "+j+" ,";
			strQuery += "'"+strFechaHora+"',";
			strQuery += "'"+strRegTemp[0] +"',";//NUMERODOC
			strQuery += "'"+strRegTemp[1]+"',";//DESCRIPCION
			strQuery += "'"+strRegTemp[2]+"',";//MONEDA
			strQuery += "'"+strRegTemp[3]+"',";//FECHA_INGRESO
			strQuery += "'"+strRegTemp[4]+"',";//FECHA_VENCIMIENTO
			strQuery += "'"+strRegTemp[5]+"',";//SALDO
			strQuery += "'"+strRegTemp[6]+"') ";//SITUACION
			objSQL.listaTablaQueryDinamico(strQuery);
			
		}

		bandera = true;
		return bandera;		
	}
	
	public boolean compararDatos() throws InterruptedException, IOException{		
		return true;		
		//FALTA
	}
	
	public boolean ingresoExportarPdf() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[7]/div/div[5]/a");
	}
	
	public boolean ingresoExportarExcel() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[7]/div/div[4]/a");		
	}
	
	public boolean ingresoImprimir() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[7]/div/div[6]/a");		
	}
	
	public boolean ingresoEmail() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[7]/div/div[6]/a");		
	}
	
	public boolean ingresarEmail(String strEmail) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input",strEmail);		
	}
	
	public boolean ingresarMensaje(String strMensaje) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea",strMensaje);		
	}
	
	public boolean ingresoBotonEnviarmail() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	}
	
	
	
	public String obtenerMensajeFront(String strColumna) throws InterruptedException, IOException{	
		
		String texto = "<IGNORE>";
			
		texto= "";
		switch (strColumna)
		{
			case "CMB_EMPRESA":
				texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[3]/table[1]/tbody/tr/td[1]/div/span[2]");
				break;
			case "CMB_SITUACION":
				texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[3]/table[2]/tbody/tr/td[1]/div/span[2]");
				break;
			case "CMB_MONEDA":
				texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[3]/table[3]/tbody/tr/td[1]/div/span[2]");
				break;
			case "<IGNORE>":
				texto = objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[5]/div/div/div[1]/div[3]");
				break;
		}

		return texto;
	}
	
	public boolean existeTabla() throws InterruptedException, IOException{		
		try {
			bandera = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/h1");
		} catch (Exception e) {
			bandera = false;
		}
		return bandera;
	}
	
	public boolean columnasCorrectas() throws InterruptedException, IOException{	
		boolean flag = false;

		WebElement tabla = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div/div[5]/div/div/div/div[5]/div/div/table"));
		List<WebElement> reg=tabla.findElements(By.xpath(".//tr"));
		int numregs=reg.size();
		if(numregs>0){
			flag= true;
		}
		else{
			flag= false;
		}
		return flag;		
	}

}
