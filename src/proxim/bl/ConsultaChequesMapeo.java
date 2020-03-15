package proxim.bl;

import java.io.IOException;

import proxim.be.ObjetosGenerales;

public class ConsultaChequesMapeo {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	
	String urlMenu="//html/body/div[2]/div[2]/div/ul/li[2]/a/span";
	String urlSubMenu="//html/body/div[2]/div[2]/div/ul/li[2]/div/div[1]/ul/li[2]/div[3]/a/span";
	String urlExitMenu="//html/body/div[2]/div[1]/div[2]/div[2]/ul/li";
	String urlCmbEmpresa="//*[@id='Enterprise_Origen']";
	String urlCmbCuenta="//*[@id='AcctIDFrom']";
	String urlRbtnOtrosValores="//*[@id='rb_option']";
	String urlSituacionCheque="//*[@id='txt_nroCheque']";
	String urlTxtFechaDesde="//*[@id='iniAnio']";
	String urlTxtFechaHasta="//*[@id='finAnio']";
	String urlRbtnBuscar="botonSubmit1";
	
	public boolean seleccionarMenu() throws InterruptedException, IOException{	
		
		return objObjetosGenerales.moveToElement(urlMenu);
	}
	
	public boolean seleccionarSubMenu() throws InterruptedException, IOException{
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, urlSubMenu);
	}
	
	public boolean salirMenu() throws InterruptedException, IOException{		
		return objObjetosGenerales.moveToElement(urlExitMenu);
	}
	
	public boolean seleccionarEmpresa(String strEmpresa) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.id, urlCmbEmpresa,strEmpresa);
	}
	public boolean seleccionarCuenta(String strCuenta) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.id, urlCmbCuenta,strCuenta);
	}

	public boolean seleccionarOtrosValores()throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.id,urlRbtnOtrosValores);
	}

	public boolean seleccionarSituacionCheque(String strSituacionCheque) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.selectByText(ObjetosGenerales.id, urlSituacionCheque,strSituacionCheque);
	}
	
	public boolean ingresarFechaDesde(String strFechaDesde) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.xpath2,urlTxtFechaDesde , strFechaDesde);
	}
	
	public boolean ingresarFechaHasta(String strFechaHasta) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.id,urlTxtFechaHasta , strFechaHasta);
	}

	public boolean buscar() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.id,urlRbtnBuscar);
	}
}
