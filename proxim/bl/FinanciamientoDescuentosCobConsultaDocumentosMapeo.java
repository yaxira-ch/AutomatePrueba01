package proxim.bl;

import java.io.IOException;

import proxim.be.ObjetosGenerales;

public class FinanciamientoDescuentosCobConsultaDocumentosMapeo {
	
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();

	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[4]/select",strEmpresa);
	}

	public boolean seleccionarProducto(String strProducto) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[6]/select",strProducto);
	}

	public boolean seleccionarSituacion(String strSituacion) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[8]/select",strSituacion);
	}

	public boolean seleccionarDocumento(String strDocumento) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/select",strDocumento);
	}

	public boolean ingresarNumeroDocumento(String strNumDocumento) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[10]/input" , strNumDocumento);
	}

	public boolean seleccionarTipoBusqueda(String strTipoBusqueda) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[12]/select",strTipoBusqueda);
	}

	public boolean ingresarFechaDesde(String strFechaDesde) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div/div[1]/input" , strFechaDesde);
	}

	public boolean ingresarFechaHasta(String strFechaHasta) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[14]/div/div[2]/input" , strFechaHasta);
	}

	public boolean buscar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/a");
	}

	public boolean ingresarEnvioCorreo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[17]/div/div[1]/a");
	}

	public boolean ingresarTituloCorreo(String strCorreo) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[1]/input" , strCorreo);
	}

	public boolean ingresarMensajeCorreo(String strMensajeCorreo) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/div/div[3]/textarea" , strMensajeCorreo);
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
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[17]/div/div[4]/a");
	}

	public boolean exportarPdf() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[17]/div/div[5]/a");
	}

	public boolean imprimir() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[17]/div/div[6]/a");
	}

}
