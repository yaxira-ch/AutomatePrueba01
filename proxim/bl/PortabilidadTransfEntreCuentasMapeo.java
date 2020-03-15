package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import proxim.be.ObjetosGenerales;
import proxim.be.TransfEntreCuentasPortabilidadBE;
import proxim.be.TransferenciaBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PortabilidadTransfEntreCuentasMapeo extends TransfEntreCuentasPortabilidadBE{
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	static ConexionSqlServer objConexionSqlServer=new ConexionSqlServer();
	
	public boolean ingresoTransferenciaLista() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div/ul/li[2]/a/span");	
	}

	public boolean ingresoTransferenciaLink() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div/div/div/ul/li[1]/a/span");
	}

	public boolean seleccionarEmpresaCuentaOrigen(String strEmpresaOrigen) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, "//*[@id='cboEmpresaOrigen']",strEmpresaOrigen);
	}

	public boolean seleccionarCuentaOrigen(String strCuentaOrigen) throws InterruptedException, IOException{
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.id, "cboCuentaOrigen",strCuentaOrigen);
	}

	public boolean seleccionarEmpresaCuentaDestino(String strEmpresaDestino) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.xpath, "//*[@id='cboEmpresaDestino']",strEmpresaDestino);
	}

	public boolean seleccionarCuentaDestino(String strCuentaDestino) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.id, "cboCuentaDestino",strCuentaDestino);
	}

	public boolean ingresarNumeroTicket(String strDescripcionTransf) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.id,"txtDescripcion" , strDescripcionTransf);
	}
	public boolean seleccionarMoneda(String strMoneda) throws InterruptedException, IOException{
		String strMonedaValor=null;
		if(strMoneda.equals("Soles")){
			strMonedaValor="S/";
		}else{
			strMonedaValor="US$";
		}
		
		return objObjetosGenerales.clicPortaCmb(ObjetosGenerales.id, "cboMoneda",strMonedaValor);
	}

	public boolean ingresarMonto(String strMoneda) throws InterruptedException, IOException{
		return objObjetosGenerales.setText(ObjetosGenerales.xpath,"//*[@id='txtMonto']" , strMoneda);
	}

	public boolean ingresarDescripcion(String strDescripcionTransf) throws InterruptedException, IOException{
		TransferenciaBE.GstrTXT_DESCRIPCION_TRANSFERENCIA=strDescripcionTransf;
		return objObjetosGenerales.setText(ObjetosGenerales.id,"txtDescripcion" , strDescripcionTransf);
	}

	public boolean ingresoBotonContinuar() throws InterruptedException, IOException{
		if( (TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_DESTINO.contains("Soles") && 
			TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Soles")&&  
			TransfEntreCuentasPortabilidadBE.GstrCMB_MONEDA.contains("Soles"))||
				(TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_DESTINO.contains("Dólares") && 
						TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Dólares")&&  
						TransfEntreCuentasPortabilidadBE.GstrCMB_MONEDA.contains("Dólares"))){
			
		}else{
			String strNewValor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[1]/div");
			Mdl_Variables.GstrTipoCambio=strNewValor.substring(strNewValor.indexOf(":")+2,strNewValor.length());
			
			strNewValor=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[3]/div");
			Mdl_Variables.GstrMontoConvertido=strNewValor.substring(strNewValor.indexOf(':')+2,strNewValor.length());

		}

		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lnk_confirmar']");	
	}

	public boolean compararMensajeError(String strMensajeError) throws InterruptedException, IOException{
		String str_Mensaje = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//*[@id='mensajeErrorGeneral']")).getText();
		if(str_Mensaje.compareTo(strMensajeError) == 0)
		{
			return true;
		}else{
			return false;
		}
	}

	public boolean verDetalle() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lnk_mostrar_detalle']");		}

	public boolean regresar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lnk_retornar_confirmar']");	
	}
	
	public boolean verClave() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div[4]/form/div[1]/div[3]/div/a[2]");	
	}

//	public boolean ingresarClave(String strClave) throws InterruptedException, IOException{	
//		return objObjetosGenerales.setText(ObjetosGenerales.xpath, "/", strClave);
//	}
	
	public boolean ingresoBotonConfirmar1() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//*[@id='lkn_confirmar']");	
	}

	public boolean guardarIdTabla() throws InterruptedException, IOException{
		Mdl_Variables.GstrNumeroSolicitud =objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p[1]/b");
		TransferenciaBE.GstrNUMERO_SOLICITUD=	Mdl_Variables.GstrNumeroSolicitud;
		boolean	valor= objConexionSqlServer.modificarNumeroSolicitud(Mdl_Variables.GstrNumeroSolicitud);
		PortabilidadTransfEntreCuentasBL.GstrNUMERO_SOLICITUD=Mdl_Variables.GstrNumeroSolicitud;
		return valor;
	}

	public boolean ingresoBotonEnviarEmail() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/footer/div/div/a");	
	}

	public boolean ingresarCorreo(String strCorreo) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.name,"destinatario" , strCorreo);
	}

	public boolean ingresarMensajeCorreo(String strMensajeCorreo) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.setText(ObjetosGenerales.name,"mensaje" , strMensajeCorreo);
	}

	public boolean ingresoBotonEnviar() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.id, "enviar");	
	}

	public boolean ingresoBotonCerrarCorreo() throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		return objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[2]/div/a");	
	}
	
	public boolean ingresoClave(String Lstr_Clave) throws InterruptedException, IOException{	
		return objObjetosGenerales.setText(ObjetosGenerales.name,"password" , Lstr_Clave);
	}
	
	
	public void validarConfirmacionTransferencia() throws SQLException, IOException, InterruptedException{
		String strCampo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[1]/div/div/p");
		String strNuevoValor="";
		int j=2;
		String strValoresDiferentes="";
		String strNewValaor1="";
		String strDetalle="";
		while(strCampo.equals("Confirma tu operación")){
			strDetalle=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div["+j+"]/span");
			
			switch(strDetalle){
				case "Cuenta de Origen":
					strNuevoValor="Cuenta de Origen\n"+GstrCMB_CUENTA_ORIGEN+"\nde "+GstrCMB_EMPRESA_CUENTA_ORIGEN;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div[2]");
					if(!strNuevoValor.equals(strNewValaor1))
						strValoresDiferentes=strValoresDiferentes+"- Valor esperado: "+strNuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
					
				case "Cuenta de Destino":	
					strNuevoValor="Cuenta de Destino\n"+GstrCMB_CUENTA_DESTINO+"\nde "+GstrCMB_EMPRESA_CUENTA_DESTINO;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div/div[2]/div[3]");
					strCampo=strDetalle;
					if(!strNuevoValor.equals(strNewValaor1))
						strValoresDiferentes=strValoresDiferentes+"- Valor esperado: "+strNuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
			}
			j++;	
		}
		
		if(!strValoresDiferentes.equals(""))
			System.out.println("Caso: "+PortabilidadAutorizacionBL.Gstr_ID_CASO+" - Valores diferentes en Pantalla de Confirmación: \n"  + strValoresDiferentes);
	}
	
	public void validarDetallerTransferencia() throws SQLException, IOException, InterruptedException{
		String campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[1]/div/div/p");
		String NuevoValor="";
		int j=1;
		String valoresDiferentes="";
		String strNewValaor1="";
		String strDetalle="";
		while(campo.equals("Detalle de operación")){
			if( ((TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_DESTINO.contains("Soles") && 
					TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Soles")&&  
					TransfEntreCuentasPortabilidadBE.GstrCMB_MONEDA.contains("Soles"))||
					(TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_DESTINO.contains("Dólares") && 
					TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Dólares")&&  
					TransfEntreCuentasPortabilidadBE.GstrCMB_MONEDA.contains("Dólares")))&&j==3){
					break;
				}else{
					strDetalle=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p["+j+"]/span");
				}
			
			switch(strDetalle){
				case "Cuenta de Origen":
					NuevoValor=GstrCMB_CUENTA_ORIGEN+"\nde "+GstrCMB_EMPRESA_CUENTA_ORIGEN;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[1]/b");
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
					
				case "Cuenta de Destino":	
					NuevoValor=GstrCMB_CUENTA_DESTINO+"\nde "+GstrCMB_EMPRESA_CUENTA_DESTINO;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[2]/b");
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;

				case "Tipo de Cambio":
					NuevoValor=Mdl_Variables.GstrTipoCambio;  
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[3]/b");
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
					
				case "Monto Convertido":	
					NuevoValor=Mdl_Variables.GstrMontoConvertido;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div/div[1]/div[2]/div/div/div/div/p[4]/b");
					campo=strDetalle;
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
			}
			j++;	
		}
		
		if(!valoresDiferentes.equals(""))
			System.out.println("Caso: "+PortabilidadAutorizacionBL.GstrID_CASO_LOTE+" - Valores diferentes en Detalle de la Trasferencia: \n"  + valoresDiferentes);
	}
	
	public void validarResultadoEsperadoTransferencia(String strFirmar) throws SQLException, IOException, InterruptedException{
		
		String campo=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[1]/div/div/p");
		String strMontoPagar=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[1]/div/ul/li/div/b[2]");
		Mdl_Variables.Gstr_strNewMonto=strMontoPagar;
		Mdl_Variables.GstrTotalPagar=objObjetosGenerales.formatearMonto("Transferencias", strMontoPagar);
		PortabilidadAutorizacionBL.GstrLBL_TIPO_OPERACION="Transferencia entre cuentas";
		TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA="Entre Cuentas";
		TransferenciaBE.GstrLNK_CERRAR_SESION=TransfEntreCuentasPortabilidadBE.GstrLNK_CERRAR_SESION;
		if(TransfEntreCuentasPortabilidadBE.GstrEMPRESA.equals("NO")){
			TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN=TransfEntreCuentasPortabilidadBE.GstrCMB_EMPRESA_CUENTA_ORIGEN;
		}else{
			TransferenciaBE.GstrCMB_EMPRESA_CUENTA_ORIGEN= Mdl_Variables.Gstr_Ignore;
		}
		TransferenciaBE.GstrCMB_CUENTA_ORIGEN=TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN;
		TransferenciaBE.GstrESTADO=TransfEntreCuentasPortabilidadBE.GstrESTADO;
		TransferenciaBE.GstrTXT_MONTO=TransfEntreCuentasPortabilidadBE.GstrTXT_MONTO;
		TransferenciaBE.GstrCONSULTAR_SALDOS_MOVIMIENTOS=TransfEntreCuentasPortabilidadBE.GstrBTN_CONSULTA_SALDOS;
		TransferenciaBE.Gstr_ID_CASO=TransfEntreCuentasPortabilidadBE.GstrID_CASO;
		//TransferenciaGeneralBL.GstrTXT_MENU="";
		
		String NuevoValor="";
		int j=1;
		String valoresDiferentes="";
		String strNewValaor1="";
		String strDetalle="";
		while(campo.equals("Resultado de operación")){
			if( ((TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_DESTINO.contains("Soles") && 
					TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Soles")&&  
					TransfEntreCuentasPortabilidadBE.GstrCMB_MONEDA.contains("Soles"))||
					(TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_DESTINO.contains("Dólares") && 
					TransfEntreCuentasPortabilidadBE.GstrCMB_CUENTA_ORIGEN.contains("Dólares")&&  
					TransfEntreCuentasPortabilidadBE.GstrCMB_MONEDA.contains("Dólares")))&&j==5){
					break;
				}else{
					strDetalle=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p["+j+"]/span");
				}
			
			
			switch(strDetalle){
				case "Fecha de Solicitud":	  
					NuevoValor=new SimpleDateFormat("dd/MM/yyy").format(Calendar.getInstance().getTime());
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p[2]/b");
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
				case "Cuenta de Origen":
					NuevoValor=GstrCMB_CUENTA_ORIGEN+"\nde "+GstrCMB_EMPRESA_CUENTA_ORIGEN;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p[3]/b");
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
				case "Cuenta de Destino":	
					NuevoValor=GstrCMB_CUENTA_DESTINO+"\nde "+GstrCMB_EMPRESA_CUENTA_DESTINO;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p[4]/b");
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					CapturarPantalla.pageDown("400");
					break;
				case "Tipo de Cambio":	   
					NuevoValor=Mdl_Variables.GstrTipoCambio;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p[5]/b");
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
				case "Monto Convertido":	
					NuevoValor=Mdl_Variables.GstrMontoConvertido;
					strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div/p[6]/b");
					campo=strDetalle;
					if(!NuevoValor.equals(strNewValaor1))
						valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
					break;
			}
			j++;	
		}
		
		if(strFirmar.equals("SI")){
			NuevoValor="(*) Esta operación se procesará cuando las firmas necesarias la autoricen en un plazo máximo de 72 horas, de lo contrario expirará automáticamente.";
			strNewValaor1=objObjetosGenerales.getText(ObjetosGenerales.xpath, "//html/body/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/p");
			if(!NuevoValor.equals(strNewValaor1))
				valoresDiferentes=valoresDiferentes+"- Valor esperado: "+NuevoValor+" ,obtenido: "+strNewValaor1+"\n";
		}
		
		if(!valoresDiferentes.equals(""))
			System.out.println("Caso: "+PortabilidadAutorizacionBL.GstrID_CASO_LOTE+" - Valores diferentes en Pantalla Resultado Esperado: \n"  + valoresDiferentes);
	}
	
}
