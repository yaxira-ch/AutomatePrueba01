package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ConsultaChequesBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaChequesBL extends ConsultaChequesBE{
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	ConsultaChequesMapeo objConsultarChequesMapeo=new ConsultaChequesMapeo();
	
	private static String TipoLog = null;
	
	public boolean consultarCheque() throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;
		try{
			if (objFuncionesGenerales.verificarIgnore("Consultas"))
			{	
				LStr_HoraInicio = System.currentTimeMillis();    	 
				if (objConsultarChequesMapeo.seleccionarMenu())
				{	
					objFuncionesGenerales.callPasosAcierto(2, "MENU, Consultas" , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "MENU, Consultas" , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
		        Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
		        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore("Cheques Emitidos"))
			{	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objConsultarChequesMapeo.seleccionarSubMenu())
				{	
					objFuncionesGenerales.callPasosAcierto(2, "SUB MENU, Cheques Emitidos", "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "SUB MENU, Cheques Emitidos" , "" ,  "");
				}
				 LStr_HoraFin = System.currentTimeMillis(); 
		         Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
		         CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		         objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			objConsultarChequesMapeo.salirMenu();
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objConsultarChequesMapeo.seleccionarEmpresa( GstrCMB_EMPRESA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrCMB_EMPRESA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objConsultarChequesMapeo.seleccionarCuenta( GstrCMB_CUENTA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "CUENTA DEL CHEQUE "+ GstrCMB_CUENTA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "CUENTA DEL CHEQUE "+ GstrCMB_CUENTA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrRBTN_OTROS_VALORES))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objConsultarChequesMapeo.seleccionarOtrosValores())
				{ 
					objFuncionesGenerales.callPasosAcierto(1, ""+ "", "" ,"Por Otros Valores...");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosAcierto(1, ""+ "", "" ,"Por Otros Valores...");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_SITUACION_CHEQUE))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objConsultarChequesMapeo.seleccionarSituacionCheque( GstrCMB_SITUACION_CHEQUE))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "SITUACIÓN DEL CHEQUE "+ GstrCMB_SITUACION_CHEQUE, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "SITUACIÓN DEL CHEQUE "+ GstrCMB_SITUACION_CHEQUE, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objConsultarChequesMapeo.ingresarFechaDesde( GstrTXT_FECHA_DESDE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"FECHA DE COBRO DESDE", GstrTXT_FECHA_DESDE ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA DE COBRO DESDE", GstrTXT_FECHA_DESDE ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objConsultarChequesMapeo.ingresarFechaHasta( GstrTXT_FECHA_HASTA))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"FECHA DE COBRO HASTA", GstrTXT_FECHA_HASTA ,"");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA DE COBRO HASTA", GstrTXT_FECHA_HASTA ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){	
				LStr_HoraInicio = System.currentTimeMillis();  
				if (objConsultarChequesMapeo.buscar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
					Thread.sleep(600);
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}
}
