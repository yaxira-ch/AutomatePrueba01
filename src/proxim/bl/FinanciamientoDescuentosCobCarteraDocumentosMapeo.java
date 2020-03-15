package proxim.bl;

import java.io.IOException;

import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;

public class FinanciamientoDescuentosCobCarteraDocumentosMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	boolean blnResultadoOperacion=false;
	
	public boolean verificarEnvioCamposObligatorios(){
		try {
			blnResultadoOperacion = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]");
		} catch (Exception e) {
			
		}
		return blnResultadoOperacion;
	}
	
	public boolean seleccionarEmpresa(String LstrEmpresa) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,"/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[4]/select" ,LstrEmpresa);
	}
	
	 public boolean seleccionarParticipeComo(String LstrEmpresa) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[6]/select",LstrEmpresa);
	 }
	 
	 public boolean seleccionarProducto(String LstrEmpresa) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[8]/select",LstrEmpresa);
	 }
	
	 public boolean seleccionarSituacion(String LstrEmpresa) throws InterruptedException, IOException{		
			return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[10]/select",LstrEmpresa);
	 }
	
	 public boolean ingresarNumeroDocumento(String strNroDocumento) throws InterruptedException, IOException{		
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[12]/input",strNroDocumento);
	 }
	 
	 public boolean ingresoBotonBuscar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/a/img");
	 }
	 
	 public boolean verificarTablaResultado(){
		 try {
			 blnResultadoOperacion = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[15]/div/div[5]/div/div/table");
		 } catch (Exception e) {}
		 return blnResultadoOperacion;
	 }
	
	 public boolean ingresoLinkEnviarEmail() throws InterruptedException, IOException{		
			return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[17]/div/div[1]/a");		
	 }
	 
	 public boolean ingresarCorreo( String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input", Descripcion);
	 }
		
	 public boolean ingresarMensajeCorreo( String Descripcion) throws InterruptedException, IOException{	
		 return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea", Descripcion);
	 }
		
	 public boolean ingresoBotonEnviar() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[4]/a/img");		
	 	}
	
	 public boolean ingresoBotonAceptarCorreo() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/a/img");		
	 	}
	
	 public boolean verificarMensajeCorreo(){
		 try {
			 blnResultadoOperacion = objObjetosGenerales.waitBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/span[2]");
		 } catch (Exception e) {}
		 return blnResultadoOperacion;
	 }
	
	 public boolean ingresoLinkExportarExcel() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[17]/div/div[4]/a");		
	 }
	 
	 public boolean ingresoLinkExportarPDF() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[17]/div/div[5]/a");		
	 }
	 
	 public boolean ingresoLinkImprimir() throws InterruptedException, IOException{		
		 return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[17]/div/div[6]/a");		
	 }
}
