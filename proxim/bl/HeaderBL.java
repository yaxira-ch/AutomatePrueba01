package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;

import proxim.be.HeaderBE;
import proxim.dao.*;

public class HeaderBL {
	HeaderBE objHeaderBE = new HeaderBE();
	static FuncionesGenerales objGeneral= new FuncionesGenerales();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new ConexionSqlServer();
	
	long lngHoraFinEjecucion;
	long lngTiempoEjecucion;
	long lngHoraInicioEjecucion;
	String strTipoLog = null;
	boolean blnResultadoOperacion = true; 
	
	public boolean menuPrincipal(String strLink, String strMenu ,String strSubMenu) throws InterruptedException, IOException, SQLException {	
		try {
			objHeaderBE.verificarTutoriales();
			
			if (objFuncionesGenerales.verificarIgnore(strLink)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				
				if (objHeaderBE.seleccionarLinkOferta()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK de oferta de Tipo de Cambio");
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK de oferta de Tipo de Cambio");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			
			}
			
			if (objFuncionesGenerales.verificarIgnore( strMenu)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objHeaderBE.seleccionarMenu( strMenu)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el MENU "+strMenu );
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el MENU "+strMenu);
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}

			if (objFuncionesGenerales.verificarIgnore( strSubMenu)){	
				lngHoraInicioEjecucion = System.currentTimeMillis();	  
				if (objHeaderBE.seleccionarSubMenu( strSubMenu)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción "+strSubMenu);
					strTipoLog="1";
				}else{
					strTipoLog="0";		
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción "+strSubMenu);
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			
			    objHeaderBE.clicMenu();
			 }
			
		} catch (Exception e) {
			blnResultadoOperacion = false;
			e.printStackTrace();
            System.out.println("Error:"  + e.getMessage());
		}
		return blnResultadoOperacion;
	}

	public boolean cerrarSesion(String valor1 ,String valor2) throws InterruptedException, IOException, SQLException {
		String Lstr_nombre;
		try{
			
			CapturarPantalla.pageDown("-2000");
			
			if (objFuncionesGenerales.verificarIgnore(valor1)){		
				lngHoraInicioEjecucion = System.currentTimeMillis();	 
				Lstr_nombre = Mdl_Variables.Gwed_Driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[2]/div[1]/div[1]/ul/li/a/div")).getText(); 
				if (objHeaderBE.cerrarSesionMenu()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+Lstr_nombre+" para cerrar cesión");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+Lstr_nombre);
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(valor2)){	
				objHeaderBE.verificarCerrar();
				lngHoraInicioEjecucion = System.currentTimeMillis();	 
				if (objHeaderBE.cerrarSesionSubMenu()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Cerrar Sesión");
					strTipoLog="1";
				}else{
					strTipoLog="0";								
					blnResultadoOperacion = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Cerrar Sesión");
				}
				lngHoraFinEjecucion = System.currentTimeMillis();	  
    			lngTiempoEjecucion = (lngHoraFinEjecucion- lngHoraInicioEjecucion)/ (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjecucion),Long.toString(lngHoraInicioEjecucion));
			}
			
			//Cierra pantallas para iniciar con un sistema limpio
	    	FuncionesGenerales.CerrarPantallas();	
    		
		} catch (Exception e) {
			blnResultadoOperacion = false;
			e.printStackTrace();
            System.out.println("Error:"  + e.getMessage());
		}
		return blnResultadoOperacion;
	}
}
