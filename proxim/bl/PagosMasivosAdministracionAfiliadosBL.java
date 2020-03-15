package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosMasivosAdministracionAfiliadosBL extends PagosMasivosAdministracionAfiliadosBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	RegistroAfiliadosMasivoBL objRegistroAfiliadosMasivoBL = new RegistroAfiliadosMasivoBL();
	PagosMasivosAdministracionAfiliadosMapeo objPagoMasivoAdministracionAfiliadosBE = new PagosMasivosAdministracionAfiliadosMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	PagosMasivosAdministracionAfiliadosMantenimientoBL objPagosMasivosMantenimientoAfiliadosBL =new PagosMasivosAdministracionAfiliadosMantenimientoBL();
	
	public boolean administracionAfiliados() throws SQLException, IOException{
		boolean lbnResultadoEsperado = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio;
		String TipoLog = null;
		
		try {
			
			//---------------------------------------MENU---------------------------------------
			objHeader.menuPrincipal( "<IGNORE>",PagosMasivosAdministracionAfiliadosBE.strTxtMenu, PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu);
			//----------------------------------------------------------------------------------
			
			if (PagosMasivosAdministracionAfiliadosBE.GstrACCION.equals("SI")){	
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_POP_UP)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonSiPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI del POP UP");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI del POP UP");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_POP_UP)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonNoPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO del POP UP");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO del POP UP");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR))
				{		
					if(GstrTXT_COLUMNA_ERROR.equals("BTN_SI_POP_UP")){
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
						if (objPagoMasivoAdministracionAfiliadosBE.compararMensajeError(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR))
						{	
							objFuncionesGenerales.callPasosAcierto(5, "El mensaje del POP UP", " El mensaje esperado" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";										
							lbnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(5, "El mensaje del POP UP", " El mensaje esperado" ,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ACEPTAR_POP_UP)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonAceptarPopUp()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR del POP UP");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR del POP UP");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
	//			org.openqa.selenium.Point coordinates1=Mdl_Variables.Gwed_Driver.findElement(By.xpath("//div/div[2]/table[4]/tbody/tr/td[1]/div/span")).getLocation();
	//			Robot robot1=new Robot();
	//			robot1.mouseMove(coordinates1.getX(), coordinates1.getY());
				
				
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objPagoMasivoAdministracionAfiliadosBE.seleccionarSubMenu1(PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1))
					{	
						objFuncionesGenerales.callPasosAcierto(2, PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1 , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, PagosMasivosAdministracionAfiliadosBE.strTxtSubMenu1 , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				//------------------------------------------------------------------------------
							
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objPagoMasivoAdministracionAfiliadosBE.seleccionarEmpresa(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa))
					{	
						objFuncionesGenerales.callPasosAcierto(2, PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
					lbnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objPagoMasivoAdministracionAfiliadosBE.seleccionarProducto(PagosMasivosAdministracionAfiliadosBE.strCmbProducto))
					{	
						objFuncionesGenerales.callPasosAcierto(2, PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";	
					lbnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
	
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbServicio)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objPagoMasivoAdministracionAfiliadosBE.seleccionarServicio(PagosMasivosAdministracionAfiliadosBE.strCmbServicio))
					{	
						objFuncionesGenerales.callPasosAcierto(2, PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objPagoMasivoAdministracionAfiliadosBE.ingresarDescripcion(PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "Operaciones frecuentes", PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "Operaciones frecuentes", PagosMasivosAdministracionAfiliadosBE.strTxtDescripcion,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objPagoMasivoAdministracionAfiliadosBE.seleccionarTipoCarga(PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, PagosMasivosAdministracionAfiliadosBE.GstrCMB_TIPO_CARGA , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					
					if (objPagoMasivoAdministracionAfiliadosBE.ingresarRutaTxt(PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO))
					{	
						objFuncionesGenerales.callPasosAcierto(3, PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, PagosMasivosAdministracionAfiliadosBE.GstrBTN_RUTA_ARCHIVO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_AGREGAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotoAgregar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_CONTINUAR_REG)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonContinuar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
	
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_AGREGAR_NUEVA)){	
					objPagoMasivoAdministracionAfiliadosBE.verificarBotonAgregarNuevoProveedor();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonAgregarNuevoProveedor()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR NUEVO TRABAJADOR");
						TipoLog="1";
					}else{
						TipoLog="0";								
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR NUEVO TRABAJADOR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				//------------------------INFORMACION DEL AFILIADO--------------------------------------------
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_AGREGAR_NUEVA)){	
					FuncionesGenerales.casosEjecutar(PagosMasivosAdministracionAfiliadosBE.strNumAfiliados,2);//captura todos los id a hacer prueba
					
//					for(int i=1;i<=Mdl_Variables.Garr_CasoAfiliacion.length;i++){
//					String strNewCadena=Mdl_Variables.Garr_CasoAfiliacion[i];	
//							if ( !larr_CasiEjecutar[i].equals("") ) 
//							{
//								var = true;
//								break;
//							}	                      
//						
//					}
					
					objSQL.listaTablaIdCaso("APP_AND_AFILIADO","where SCRIPT='"+Mdl_Variables.Gstr_Tabla+"'",2);
					
					while (Mdl_Variables.Grst_TablaLogin.next()==true) {	
			    		
			    		if 	(FuncionesGenerales.existeCasosEjecutar(Mdl_Variables.Garr_CasoAfiliacion) == true){  
				    		if (FuncionesGenerales.buscarCasosEjecutar(Mdl_Variables.Grst_TablaLogin.getString("ID_CASO"),2) == true)
				    		{
				    			lbnResultadoEsperado = objRegistroAfiliadosMasivoBL.administracionAfiliados();
				    		}
			    		}
					}
				}
				//-----------------------------------------------------------------------------------------
					
					//agregar nuevo trabajador/ txt_ buscar /buscar
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_GUARDARFINAL)){	
					objPagoMasivoAdministracionAfiliadosBE.verificarBotonGuardar();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonGuardarFinal()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón GUARDAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón GUARDAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				//------------------------ENVIO DE AFILIADOS--------------------------------------------
				if(PagosMasivosAdministracionAfiliadosBE.GstrENVIO_AFILIADOS.equals("SI")){	
					objPagoMasivoAdministracionAfiliadosBE.verificarBotonEnviar();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								
					if (objPagoMasivoAdministracionAfiliadosBE.enviarAfiliadosNew()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check del Afiliado a Enviar");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check del Afiliado a Enviar");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				//-----------------------------------------------------------------------------------------
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_ENVIAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonEnviarAfiliado()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE.equals("SI")){
					if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
						objPagoMasivoAdministracionAfiliadosBE.verificarBotonConfirmar();
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFuncionesGenerales.ingresoClave(Mdl_Variables.Gstr_Clave)){	
							objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							lbnResultadoEsperado = false;
							objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA)){	
					objPagoMasivoAdministracionAfiliadosBE.verificarBotonConfirmar();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoMasivoAdministracionAfiliadosBE.ingresarClaveDinamica(PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA)){	
						objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica", PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "La clave dinamica", PagosMasivosAdministracionAfiliadosBE.GstrTXT_CLAVE_DINAMICA,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_CONFIRMAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonConfirmarAfil()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrBTN_CANCELAR_OPERACION)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objPagoMasivoAdministracionAfiliadosBE.ingresoBotonCancelarOperacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
						TipoLog="1";
					}else{
						TipoLog="0";								
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrRESULTADO_ESPERADO))
				{		
					objPagoMasivoAdministracionAfiliadosBE.verificarResultadoFinal();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
					if (objPagoMasivoAdministracionAfiliadosBE.compararMensajeResultanteAfiliado(PagosMasivosAdministracionAfiliadosBE.GstrRESULTADO_ESPERADO))
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"se compara resultado esperado");
						TipoLog="1";
					}else{
						TipoLog="0";										
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"se compara resultado esperado");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
//				if(objPagoMasivoAdministracionAfiliadosBE.verificarLinkRechazado()){
//					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
//					if (objPagoMasivoAdministracionAfiliadosBE.ingresoLinkRechazado())
//					{	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link 'Ver detalle de operaciones rechazadas'");
//						TipoLog="1";
//					}else{
//						TipoLog="0";										
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link 'Ver detalle de operaciones rechazadas'");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
				
				if(objPagoMasivoAdministracionAfiliadosBE.verificarMensajeRechazado()){
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
					if (objPagoMasivoAdministracionAfiliadosBE.cerrarMensajeRechazado())
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la x para cerrar el mensaje de rechazado");
						TipoLog="1";
					}else{
						TipoLog="0";										
						lbnResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la x para cerrar el mensaje de rechazado");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
		//-------------------------------------------VERIFICAR AFILIACION
			if (PagosMasivosAdministracionAfiliadosBE.GstrCONSULTAR.equals("SI")&&lbnResultadoEsperado){	
				lbnResultadoEsperado= objPagosMasivosMantenimientoAfiliadosBL.MantenimientoAfiliado();
			}
		//-------------------------------------------
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(PagosMasivosAdministracionAfiliadosBE.GstrLNK_CERRAR_SESION,PagosMasivosAdministracionAfiliadosBE.GstrLNK_CERRAR_SESION);
			}
			
		} catch (Exception e) {
			lbnResultadoEsperado=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	
		}
		return lbnResultadoEsperado;
	}
}