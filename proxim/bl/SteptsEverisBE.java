package proxim.bl;

import java.io.IOException;
import proxim.be.ObjetosGenerales;

public class SteptsEverisBE {
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	
	public boolean seleccionarObjeto(String strBy,String strByValue,String strValor) throws InterruptedException, IOException{
		return objObjetosGenerales.selectByText(strBy, strByValue,strValor);
	}

	public boolean ingresarObjeto(String strBy,String strByValue,String strValor) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(strBy, strByValue, strValor);
	}
	
	public boolean clicObjeto(String strBy,String strByValue) throws InterruptedException, IOException{	
		return objObjetosGenerales.clickBoton(strBy, strByValue);
	}
}
