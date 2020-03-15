package proxim.bl;

import java.io.IOException;

import proxim.be.ObjetosGenerales;
import proxim.dao.Mdl_Variables;

public class TransferenciaCuentaPaypalMapeo {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	
	
	public boolean seleccionarLinkSubMenu(String LstrProducto) throws InterruptedException, IOException{	
		boolean var=false;
		String strXpathPestana="";
		
		for(int i=1;i<=2;i++){
			strXpathPestana="//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[2]/li["+i+"]/a";
			String valor= objObjetosGenerales.getText(ObjetosGenerales.xpath, strXpathPestana);
			
			if(objFuncionesGenerales.compararTextosIguales(LstrProducto, valor) ){
				var= objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, strXpathPestana);
				break;
			}
		}
		return var;			
	}

	public boolean clicBotonAfiliarCuentaPaypal() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/center[2]/button");		
	}
	
	public boolean clicBotonAceptar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[2]/button[1]");		
	}
	
	public boolean ingresarUsuarioPaypal(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/table[1]/tbody/tr/td[2]/input", Descripcion);
	}
	
	public boolean seleccionarEmpresa(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/table[2]/tbody/tr/td[2]/select" ,LstrProducto);
	}
	
	public boolean seleccionarCuentaPorAfiliar(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/table[3]/tbody/tr/td[2]/select" ,LstrProducto);
	}
	
	public boolean clicBotonAfiliar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/center/button" );		
	}
	
	public boolean clicCheckTerminosCondiciones() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/span[2]/input" );		
	}
	
	public boolean clicConfirmar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/center/button" );		
	}
	
	public boolean ingresarContrasena(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//*[@id='authorization_form']/div/p[3]/span/input" , Descripcion);
	}
	
	public String verificarPantallaPrincipal(String GstrBTN_ACEPTAR_MENSAJE) throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";
		boolean blnExisteElement=false;
		//------Verificar Valor de una Empresa:
		if (GstrBTN_ACEPTAR_MENSAJE.compareTo(Mdl_Variables.Gstr_Ignore)== 0){
			//------Verificar Afiliación:
			strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='AfiliacionPaypal']");
			strValorCampo="Afiliación";
			if(!strValorPantalla.equals(strValorCampo)){
				strResultadoEsperado=strResultadoEsperado+"El texto de la Pestaña son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
			}
			
			//------Verificar Afiliación:
			strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='RetiroFondosPaypal']");
			strValorCampo="Retiro de Fondos";
			if(!strValorPantalla.equals(strValorCampo)){
				strResultadoEsperado=strResultadoEsperado+"El texto de la Pestaña son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
			}
		}
				
		//------Verificar texto Cabecera 
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='titulo-paypal']");
		strValorCampo="PayPal es un medio de pago electrónico que te permite comprar o vender por Internet en más de 200 países.\n"+ 
						"Interbank y PayPal se han unido para que puedas retirar tu dinero directamente a tus cuentas Interbank:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Cabecera son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Icono Num Uno
		blnExisteElement= objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//*[@id='left']/div");
		
		if(!blnExisteElement){
			strResultadoEsperado=strResultadoEsperado+"No existe el Primer Icono";
		}
		
		//------Verificar texto Ico Uno 
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='left']/p");
		strValorCampo="Asocia tu cuenta PayPal a una de tus cuentas Interbank";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto del Recuadro Uno son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Icono Num Dos
		blnExisteElement= objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//*[@id='centro']/div");
		
		if(!blnExisteElement){
			strResultadoEsperado=strResultadoEsperado+"No existe el Segundo Icono";
		}
		
		//------Verificar texto Ico Dos 
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='centro']/p");
		strValorCampo="Solicita retirar tu dinero de PayPal a través de tu Banca por Internet";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto del Recuadro Dos son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
				
		//------Verificar Icono Num Tres
		blnExisteElement= objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//*[@id='right']/div");
		
		if(!blnExisteElement){
			strResultadoEsperado=strResultadoEsperado+"No existe el Tercer Icono";
		}
		
		//------Verificar texto Ico Dos 
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='right']/p");
		strValorCampo="Luego de 5 días útiles verás tu dinero en la cuenta afiliada";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto del Recuadro Tres son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}

		//------Verificar texto Consideraciones
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/h1");
		strValorCampo="Consideraciones";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Consideraciones no son iguales '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar texto Comisión
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='listacuadro']/li[1]");
		strValorCampo="Comisión: 1.5% de cada retiro; comisión mínima de US$17.00.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Comisión son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar texto Límite de Retiro
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='listacuadro']/li[2]");
		strValorCampo="Límite de Retiro: US$10,000 por operación. Puedes retirar las veces que deseas.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Límite de Retiro son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar texto Cuenta por afiliar:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='listacuadro']/li[3]/b");
		strValorCampo="Cuenta por afiliar:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Cuenta por afiliar son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar texto Expiración de afiliación 
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='listacuadro']/li[4]");
		strValorCampo="Expiración de afiliación: Deberás volver a afiliarte después de un año o de retirar US$ 100,000.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Expiración de afiliación son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar texto Quinta Consideracion 
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='listacuadro']/li[5]");
		strValorCampo="Una vez solicitado el retiro, no se podrá cancelar.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la quinta consideracion son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar texto Sexta Consideracion
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='listacuadro']/li[6]");
		strValorCampo="Tipo de Cambio: referencial.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Sexta Consideracion son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}

		return strResultadoEsperado;
	}
	
	public boolean clicBotonAutorizar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//*[@id='authorization_form']/div/p[6]/input" );		
	}
	
	public boolean clicBotonCancelar() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//*[@id='authorization_form']/div/p[6]/span/input" );		
	}
	
	public boolean clicBotonAceptarAfiliacion() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[2]/button[1]");		
	}

	public boolean clicBotonAceptarNoAdministrador() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[2]/button[1]");		
	}

	public boolean verificarPopUpAfiliado() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[1]");
	}
	
	public boolean verificarPopUpMensajeAdministrador()throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr/td/div");
	}
	
	public String verificarCamposResultadoEsperadoAfilicion(String strResultadoEsperadoData,String strUsuarioPaypalData,String strEmpresaData,String strCuentaAfiliarData) throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";

		//------Verificar Mensaje Resultado Esperado
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[1]/span");
		if(!strValorPantalla.equals(strResultadoEsperadoData)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Afiliación exitosa: '"+strValorPantalla+"' - '"+strResultadoEsperadoData+"'; ";
		}
		
		//------Verificar Fecha:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[2]/span[1]");
		strValorCampo="Fecha:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Fecha son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Hora:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[2]/span[3]");
		strValorCampo="Hora:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Hora son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Usuario PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/span[1]");
		strValorCampo="Usuario PayPal:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Usuario Paypal son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}

		//------Verificar Valor Usuario Cuenta PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/span[2]");
		if(!strValorPantalla.equals(strUsuarioPaypalData)){
			strResultadoEsperado=strResultadoEsperado+"El valor del Usuario Paypal son diferentes: '"+strValorPantalla+"' - '"+strUsuarioPaypalData+"'; ";
		}
		
		//------Verificar Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/div/span[1]");
		strValorCampo="Empresa:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Empresa son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Valor de una Empresa:
		if (strEmpresaData.compareTo(Mdl_Variables.Gstr_Ignore)!= 0){
			strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/div/span[2]");
			if(!strValorPantalla.equals(strEmpresaData)){
				strResultadoEsperado=strResultadoEsperado+"El valor de la Empresa son diferentes: '"+strValorPantalla+"' - '"+strEmpresaData+"'; ";
			}
		}
		
		//------Verificar Cuenta Afiliar :
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/span[3]");
		strValorCampo="Cuenta por afiliar:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Cuenta a Afiliar son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}

		//------Verificar Valor Cuenta Afiliar :
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[3]/span[4]");
		if(!strValorPantalla.equals(strCuentaAfiliarData)){
			strResultadoEsperado=strResultadoEsperado+"El valor de la Empresa son diferentes: '"+strValorPantalla+"' - '"+strCuentaAfiliarData+"'; ";
		}

		//------Verificar Texto de Indicaciones
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/span");
		strValorCampo="Recibirás un correo de confirmación de PayPal.Ya puedes empezar a retirar en la opción de "+'"'+"Retiro de Fondos"+'"'+".";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Términos y condiciones son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		return strResultadoEsperado;
	}	
	
	public boolean ingresarMontoRetiro(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/input" , Descripcion);
	}
	
	public boolean clicBotonRetirarFondos() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[5]/center/button" );		
	}
	
	public boolean clicBotonAceptarNoAfiliados() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[2]/button[1]" );		
	}
	
	public String verificarMensajeError(String GstrTXT_COLUMNA_ERROR,String GstrTXT_MENSAJE_ERROR,String GstrTXT_MONTO_SUPERA_LIMITE) throws InterruptedException, IOException{		
		String strCapturaMensaje="";
		
		switch (GstrTXT_COLUMNA_ERROR)   {
			case "TXT_EMPRESA": 
				strCapturaMensaje=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/span");
				break;	
			
			case "TXT_MONTOS": 
				if(GstrTXT_MONTO_SUPERA_LIMITE.equals("Monto_Supera_Limite")){
					GstrTXT_MENSAJE_ERROR="El monto ingresado es superior al saldo del que dispones. Por favor, ingresa un monto válido.";
				}
				strCapturaMensaje=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[4]/span");
				break;	
			
			case "TXT_EMPRESA_NO_AFILIADA":
				strCapturaMensaje=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div/div/div/div[2]/span");
				break;	
		}	
			
		if(strCapturaMensaje.equals(GstrTXT_MENSAJE_ERROR)){
			strCapturaMensaje="";
		}
		
		return strCapturaMensaje;		
	}
	
	public String verificarMensajeErrorMontoCuentaRestringida(String GstrTXT_COLUMNA_ERROR,String GstrTXT_MENSAJE_ERROR) throws InterruptedException, IOException{		
		String strMensaje=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div/div/div/div[2]/span");
		if(GstrTXT_COLUMNA_ERROR.equals("TXT_MONTO_RETIRAR")&&strMensaje.equals(GstrTXT_MENSAJE_ERROR)){
			strMensaje="";
		}
		return strMensaje;		
	}
	
	public boolean verificarPopUp() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[1]");
	}
	
	public boolean verificarAfiliaCamposObligatorios() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]");
	}
	
	public String ValidarPaginaDos(String strEmpresaData){	
		String strResultadoMensaje="";
		try {
			String strMensajeObligatorio="Los campos marcados con * son obligatorios";
			String strUsuarioPaypal="Usuario PayPal *";
			String strCuentaAfiliar="Cuenta por afiliar*";
			String strEmpresa,strEmpresaFormulario;

			
			if (strEmpresaData.compareTo(Mdl_Variables.Gstr_Ignore)== 0){
				strEmpresa="";
				strEmpresaFormulario="";
			}else{
				strEmpresa="Empresa*";//poner la descripcion del nombre
				strEmpresaFormulario=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='pasoEmpresaEtiqueta']/span[3]");//capturar el valor 
			}
			
			//------------Get Valores------------
			String strMensajeObligatorioFormulario=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]");
			String strUsuarioPaypalFormulario=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='pasoUsuarioPaypalEtiqueta']/span[3]");
			String strCuentaAfiliarFormulario=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//*[@id='pasoCuentaAfiliarEtiqueta']/span[3]");
			
			if(!strMensajeObligatorio.equals(strMensajeObligatorioFormulario )){
				strResultadoMensaje=strResultadoMensaje+"El mensaje de capos obligatorios son diferentes: '"+strMensajeObligatorio+"' - '"+strMensajeObligatorioFormulario+"'; ";
			}

			if(!strUsuarioPaypal.equals(strUsuarioPaypalFormulario)){
				strResultadoMensaje=strResultadoMensaje+"El mensaje de Usuario Paypal son diferentes: '"+strUsuarioPaypal+"' - '"+strUsuarioPaypalFormulario+"'; ";
			}

			if(!strCuentaAfiliar.equals(strCuentaAfiliarFormulario)){
				strResultadoMensaje=strResultadoMensaje+"El mensaje de la Cuenta a Afiliar son diferentes: '"+strCuentaAfiliar+"' - '"+strCuentaAfiliarFormulario+"'; ";
			}
			
			if(!strEmpresa.equals(strEmpresaFormulario)	){
				strResultadoMensaje=strResultadoMensaje+"El mensaje de la Empresa son diferentes: '"+strEmpresa+"' - '"+strEmpresaFormulario+"'; ";
			}
			
		} catch (Exception e) {
			
		}
		return strResultadoMensaje;
	}
	
	public boolean verificarResultadoFinal() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[1]/span");
	}
	
	public boolean verificarConfirmacionRetiro() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/h1");
	}
	
	public boolean ingresarClaveDinamica(String Descripcion) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[2]/input", Descripcion);
	}
	
	public boolean clicBotonConfirmarRetiro() throws InterruptedException, IOException{		
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[3]/center/button" );		
	}
	
	public boolean seleccionarEmpresaRetiro(String LstrProducto) throws InterruptedException, IOException{		
		return objObjetosGenerales.selectByText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/select" ,LstrProducto);
	}
	
	public boolean verificarRetiroFondos() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div");
	}
	
	public boolean verificarPopUpNoAfiliados() throws InterruptedException, IOException{
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr/td/div");
	}
	
	public boolean verificarResultadoEsprado(String LstrProducto ) throws InterruptedException, IOException{	
		boolean blnResultado=false;
		String str_ResultadoEsperado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div[1]/span" );	
		if(LstrProducto.equals(str_ResultadoEsperado)){
			blnResultado=true;
		}
		return blnResultado;
	}
	
	public String verificarCamposRetiros() throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";
		
		//------Verificar Retiro de fondos PayPal
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div");
		strValorCampo="Retiro de fondos PayPal";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado="Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		//------Verificar Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/span[1]");
		strValorCampo="Empresa:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Cuenta PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/span[1]");
		strValorCampo="Cuenta PayPal:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Saldo:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/span[3]");
		strValorCampo="Saldo:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Monto por retirar:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/span[3]");
		strValorCampo="Monto por retirar:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Monto por retirar:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]");
		strValorCampo="* Máximo $10,000 por retiro. Aplica una comisión de $17 o 1.5%.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
	
		return strResultadoEsperado;
	}
	
	public String verificarCamposPopUpNoAfiliado() throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";
		
		//------Verificar Retiro de fondos PayPal
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr/td/div");
		strValorCampo="No estás afiliado";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado="Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		//------Verificar Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[1]");
		strValorCampo="Para retirar fondos debes afiliar tu cuenta PayPal a una cuenta Interbank. Por favor, realiza la afiliación.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		return strResultadoEsperado;
	}
	public String verificarCamposConfirmacion(String strCuenta,String strEmpresa,String strMonto) throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";
		
		//------Verificar Confirmación de retiro
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/h1");
		strValorCampo="Confirmación de retiro";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado="Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		//------Verificar Usuario PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[1]");
		strValorCampo="Usuario PayPal:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Valor Usuario Cuenta PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[2]");
		if(!strValorPantalla.equals(strCuenta)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strCuenta+"'";
		}

		//------Verificar Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[3]");
		strValorCampo="Empresa:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Valor Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[4]");
		if(!strValorPantalla.equals(strEmpresa)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strEmpresa+"'";
		}
				
		//------Verificar Cuenta afiliada:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[5]");
		strValorCampo="Cuenta afiliada:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Monto solicitado:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[7]");
		strValorCampo="Monto solicitado:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
	
		//------Verificar Valor Monto solicitado:
//		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/span[8]");
//		strMonto="$ "+strMonto+".00";
//		if(!strValorPantalla.equals(strMonto)){
//			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strMonto+"'";
//		}
		
		//------Verificar Por favor, ingresa tu clave para confirmar la operación
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[1]/h2");
		strValorCampo="Por favor, ingresa tu clave para confirmar la operación";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		//------Verificar Ingresa tu Clave Dinámica
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/span[2]");
		strValorCampo="Ingresa tu Clave Dinámica";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		//------Verificar ¿Quieres saber como?
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div[2]/div[1]/a");
		strValorCampo="¿Quieres saber como?";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		return strResultadoEsperado;
	}
	
	public String verificarCamposResultadoEsperado(String strCuenta,String strEmpresa,String strMonto,String strNumeroCuenta, String strResultadoEsperadoFinal) throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";
		
		//------Verificar Existecia Icono
		boolean blnExisteElement= objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/img");
		
		if(!blnExisteElement){
			strResultadoEsperado="No existe el icono";
		}
		
		//------Verificar Usuario PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/span[1]");
		strValorCampo="Usuario PayPal:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Valor Usuario Cuenta PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/span[2]");
		if(!strValorPantalla.equals(strCuenta)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strCuenta+"'";
		}

		//------Verificar Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div/span[1]");
		strValorCampo="Empresa:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Valor Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div/span[2]");
		if(!strValorPantalla.equals(strEmpresa)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strEmpresa+"'";
		}
				
		//------Verificar Cuenta afiliada:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/span[3]");
		strValorCampo="Cuenta afiliada:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}

		//------Verificar Valor Cuenta afiliada:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/span[4]");
		if(!strValorPantalla.equals(strNumeroCuenta)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strNumeroCuenta+"'";
		}
				
		//------Verificar Monto solicitado:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/span[5]");
		strValorCampo="Monto solicitado:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
	
		//------Verificar Valor Monto solicitado:
//		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/span[6]");
//		strMonto="$ "+strMonto+".00";
//		if(!strValorPantalla.equals(strMonto)){
//			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strMonto+"'";
//		}
		
		//------Verificar Fecha: 
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/span[1]");
		strValorCampo="Fecha:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		//------Verificar Hora:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[3]/span[3]");
		strValorCampo="Hora:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strValorCampo+"'";
		}
		
		//------Verificar Hora:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/span" );	
		if(!strValorPantalla.equals(strResultadoEsperadoFinal)){
			strResultadoEsperado=strResultadoEsperado+"; Valores que no coinciden: '"+strValorPantalla+"' y '"+strResultadoEsperadoFinal+"'";
		}
		
		return strResultadoEsperado;
	}
	public boolean verificarResultadoFinalRetiro() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/span");
	}
	
	public boolean verificarResultadoEspradoRetiro(String LstrProducto ) throws InterruptedException, IOException{	
		boolean blnResultado=false;
		String str_ResultadoEsperado= objObjetosGenerales.getText(ObjetosGenerales.xpath,"//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[2]/span" );	
		if(LstrProducto.equals(str_ResultadoEsperado)){
			blnResultado=true;
		}
		return blnResultado;
	}
	
	public boolean verificarConfirmacionAfiliacion() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/h1");
	}
	
	public String verificarMensajePopUpAfiliado() throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";

		//------Verificar Titulo Confirmacion:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr/td/div");
		strValorCampo="Afiliación vigente";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Afiliación son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Usuario PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[1]");
		strValorCampo="Ya tienes una cuenta PayPal afiliada";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}

		return strResultadoEsperado;
	}
	
	public String verificarMensajePopUpNoAdministrador() throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";

		//------Verificar Titulo :
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[1]/tbody/tr/td/div");
		strValorCampo="Recuerda";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto del Titulo son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Contenido
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div/table[2]/tbody/tr/td/div/div[1]");
		strValorCampo="Solo los usuarios administradores pueden acceder a esta opción. Para conocer los usuarios configurados con este perfil comunícate al 311-9001 (Lima) o 0801-00801 (Provincias).";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		return strResultadoEsperado;
	}
	
	public String verificarCamposConfirmacionAfilicion(String strUsuarioPaypalData,String strEmpresaData,String strCuentaAfiliarData) throws InterruptedException, IOException{
		String strResultadoEsperado="";
		String strValorCampo="";
		String strValorPantalla="";

		//------Verificar Titulo Confirmacion:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/h1");
		strValorCampo="Confirmación de afiliación";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Confirmación son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Usuario PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[1]");
		strValorCampo="Usuario PayPal:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Usuario Paypal son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}

		//------Verificar Valor Usuario Cuenta PayPal:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[2]");
		if(!strValorPantalla.equals(strUsuarioPaypalData)){
			strResultadoEsperado=strResultadoEsperado+"El valor del Usuario Paypal son diferentes: '"+strValorPantalla+"' - '"+strUsuarioPaypalData+"'; ";
		}
		

		//------Verificar Empresa:
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/span[1]");
		strValorCampo="Empresa:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Empresa son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Valor de una Empresa:
		if (strEmpresaData.compareTo(Mdl_Variables.Gstr_Ignore)!= 0)
		{
			strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/div/span[2]");
			if(!strValorPantalla.equals(strEmpresaData)){
				strResultadoEsperado=strResultadoEsperado+"El valor de la Empresa son diferentes: '"+strValorPantalla+"' - '"+strEmpresaData+"'; ";
			}
		}
		
		//------Verificar Cuenta Afiliar :
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[3]");
		strValorCampo="Cuenta por afiliar:";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de la Cuenta a Afiliar son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}

		//------Verificar Valor Cuenta Afiliar :
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span[4]");
		if(!strValorPantalla.equals(strCuentaAfiliarData)){
			strResultadoEsperado=strResultadoEsperado+"El valor de la Empresa son diferentes: '"+strValorPantalla+"' - '"+strCuentaAfiliarData+"'; ";
		}

		//------Verificar TÉRMINOS Y CONDICIONES
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/span[1]");
		strValorCampo="TÉRMINOS Y CONDICIONES";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de Términos y condiciones son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Existecia cuadro de texto
		boolean blnExisteElement= objObjetosGenerales.getElementVisibility(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/div/textarea");
		
		if(!blnExisteElement){
			strResultadoEsperado=strResultadoEsperado+"No existe cuadro de texto de los términos y condiciones; ";
		}
		
		//------Verificar Texto de Check
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/span[3]");
		strValorCampo="He leído y aceptado los términos y condiciones";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de aceptación son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		
		//------Verificar Mensaje inferior
		strValorPantalla= objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[3]/span[4]");
		strValorCampo="Al hacer clic en "+'"'+"Confirmar"+'"'+", aparecerá una ventana emergente en donde deberás colocar tu clave PayPal.";
		if(!strValorPantalla.equals(strValorCampo)){
			strResultadoEsperado=strResultadoEsperado+"El texto de informe son diferentes: '"+strValorPantalla+"' - '"+strValorCampo+"'; ";
		}
		return strResultadoEsperado;
	}	
	
	
	public boolean verificarConfirmacionPaypal() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//*[@id='main']/ul/li[2]");
	}
	
	public boolean verificarPaginaPrincipalPaypal() throws InterruptedException, IOException{	
		return objObjetosGenerales.waitElementBy(ObjetosGenerales.xpath, "//*[@id='AfiliacionPaypal']");
	}
}
