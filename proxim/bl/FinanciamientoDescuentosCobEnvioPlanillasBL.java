package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasDetalleBE;
import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasGeneralBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;


public class FinanciamientoDescuentosCobEnvioPlanillasBL extends FinanciamientoDescuentosCobEnvioPlanillasGeneralBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDescuentosCobEnvioPlanillasAutorizarMapeo objFinanciamientoDescuentosCobEnvioPlanillas = new FinanciamientoDescuentosCobEnvioPlanillasAutorizarMapeo();
	FinanciamientoDescuentosCobEnvioPlanillasDetalleBE objDetalleAceptanteBL = new FinanciamientoDescuentosCobEnvioPlanillasDetalleBE();
	FinanciamientoDescuentosCobEnvioPlanillasProcesadasBL objFinanciamientoDescuentosCobEnvioPlanillasProcesadasBL =new FinanciamientoDescuentosCobEnvioPlanillasProcesadasBL();
	private static String TipoLog = null;
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objFirmarBL =new FirmarBL();
	FinanciamientoDescuentosCobEnvioPlanillasDetalleBL objFinanciamientoDescuentosCobEnvioPlanillasDetalle=new FinanciamientoDescuentosCobEnvioPlanillasDetalleBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	int intResultadoNumero=0;
			
	public boolean financiamientoDescuentosCobEnvioPlanillas() throws SQLException, IOException{
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		boolean bandera = true;
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		boolean consultar4=false;
		String strCadena = "S/.";
		String strTexto; 
		try {
			//---------------------------------------MENU---------------------------------------
			
			//objFinanciamientoDescuentosCobEnvioPlanillas.verificarTutoriales();
			

			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENU)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFuncionesGenerales.seleccionarMenu(GstrTXT_MENU)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el MENU "+ GstrTXT_MENU);
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el MENU "+ GstrTXT_MENU);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarSubMenu(GstrTXT_SUBMENU)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+ GstrTXT_SUBMENU);
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+ GstrTXT_SUBMENU);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			objFuncionesGenerales.clicMenu();
			
			
			//---------------------------------------MENU---------------------------------------
			
			//objHeader.menuPrincipal( GstrTXT_MENU, GstrTXT_SUBMENU);
			
//			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
//				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//				if (objEnvioPlanillasDescCobBE.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
//					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
//					TipoLog="1";
//				}else{
//					TipoLog="0";								
//					bandera = false;
//					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
//				}
//				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//			}
			//------------------------------------------------------------------------------			
			
			objFinanciamientoDescuentosCobEnvioPlanillas.verificarEnvioCamposObligatorios();
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
			{		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarEmpresa(GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+ GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+  GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CARGA))
			{		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarTipoCarga(GstrCMB_TIPO_CARGA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE CARGA "+GstrCMB_TIPO_CARGA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE CARGA "+  GstrCMB_TIPO_CARGA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_POP_UP))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonPopupSI()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI del POP UP");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI del POP UP");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_POP_UP))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonPopupNO()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO del POP UP");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO del POP UP");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//-------------------------TIPO DE CARGA------------------------------------------------
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CARGA))
			{
				if (GstrCMB_TIPO_CARGA.equals("Importar Planilla"))//-----------------------------SELECCIONAR CUANDO ES CON TXT
				{
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_SELECCIONAR_ARCHIVO))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonArchivo(GstrBTN_SELECCIONAR_ARCHIVO)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SELECCIONAR ARCHIVO");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SELECCIONAR ARCHIVO");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_DESCARGAR_MACRO))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoDescargarMacro()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el link DESCARGAR MACRO");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el link DESCARGAR MACRO");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_AGREGAR))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonAgregar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.scrollCapturaPantalla();
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
				}else{ //-----------------------------CUANDO ES DIGITACION ELECTRONICA
					
					objFinanciamientoDescuentosCobEnvioPlanillas.verificarCuandoDigitacion();
					
					if (objFuncionesGenerales.verificarIgnore(GstrCMB_PRODUCTO))
					{		
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
						if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarProducto(GstrCMB_PRODUCTO))
						{	
							objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+ GstrCMB_PRODUCTO , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";		
							bandera = false;
							objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO "+ GstrCMB_PRODUCTO , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrCHK_PROTESTAR))
					{		
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoChkProtestar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el check Protestar");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el check Protestar");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrCHK_COBRAR_INTERES))
					{		
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoChkCobrarInteres()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el check cobrar interes");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el check cobrar interes");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
							
					if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))
					{		
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
						if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarMoneda(GstrCMB_MONEDA))
						{	
							objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";		
							bandera = false;
							objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CORRIENTE))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
						if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarCuentaCargo(GstrCMB_CUENTA_CORRIENTE))
						{	
							objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA de CARGO "+GstrCMB_CUENTA_CORRIENTE , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(2, "de la CUENTA de CARGO "+ GstrCMB_CUENTA_CORRIENTE , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_PLANILLA))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarNombrePlanilla(GstrTXT_NOMBRE_PLANILLA))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DE LA PLANILLA "+GstrTXT_NOMBRE_PLANILLA , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DE LA PLANILLA "+GstrTXT_NOMBRE_PLANILLA , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					//------------------------------------------------------------------------------------------------------
					
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_AGREGAR))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonAgregar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR) && objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
						String strMensajeFront =  objFinanciamientoDescuentosCobEnvioPlanillas.obtenerMensajeFront(GstrTXT_COLUMNA_ERROR,1);
						objFuncionesGenerales.callPasosAcierto(4, strMensajeFront, "" ,"");
						if (strMensajeFront.compareTo("<IGNORE>")!=0)
						{
							if (objFuncionesGenerales.compararTexto(strMensajeFront,GstrTXT_MENSAJE_ERROR))
							{
								objFuncionesGenerales.callPasosAcierto(5, strMensajeFront, GstrTXT_MENSAJE_ERROR ,"");
								TipoLog="1";
				    		}else{
				    			TipoLog="0";									
								bandera = false;
								objFuncionesGenerales.callPasosErrado(5, strMensajeFront, GstrTXT_MENSAJE_ERROR ,"");
				    		}
						}
					}
					
					
					//------DETALLE - LLENAR DATOS DE ACEPTANTE ----------
					if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CARGA))
					{	
						if(GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
							objFinanciamientoDescuentosCobEnvioPlanillas.verificarCabecera();
							
							objSQL.listaTablaIdCaso("SELECT ID_CASO_LOTE,CMB_TIPO_DOCUMENTO_ACEPTANTE, TXT_NRO_DOCUMENTO_ACEPTANTE, TXT_NOMBRE_ACEPTANTE,TXT_APEPAT_ACEPTANTE, TXT_APEMAT_ACEPTANTE, TXT_DIRECCION_ACEPTANTE, CMB_UBIGEO_ACEPTANTE, TXT_NUMERO_DOCUMENTOS, BTN_AGREGAR,LINK_VER,BTN_CERRAR FROM APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_DETALLE_D  WHERE  ID_CASO_LOTE="+Mdl_Variables.Gint_IdCaso+" GROUP BY ID_CASO_LOTE,CMB_TIPO_DOCUMENTO_ACEPTANTE, TXT_NRO_DOCUMENTO_ACEPTANTE, TXT_NOMBRE_ACEPTANTE,TXT_APEPAT_ACEPTANTE, TXT_APEMAT_ACEPTANTE, TXT_DIRECCION_ACEPTANTE, CMB_UBIGEO_ACEPTANTE, TXT_NUMERO_DOCUMENTOS, BTN_AGREGAR,LINK_VER,BTN_CERRAR","",5);//Captura todos los valores del detalle del caso
//							String strCampos = "MIN(NUM) AS ORDEN,CMB_TIPO_DOCUMENTO_ACEPTANTE,TXT_NRO_DOCUMENTO_ACEPTANTE,TXT_NOMBRE_ACEPTANTE,TXT_APEPAT_ACEPTANTE,TXT_APEMAT_ACEPTANTE,TXT_DIRECCION_ACEPTANTE,CMB_UBIGEO_ACEPTANTE,TXT_NUMERO_DOCUMENTOS,BTN_AGREGAR,TXT_COLUMNA_ERROR,TXT_MENSAJE_ERROR";
//							objSQL.listaTablaQuery(strCampos, "APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_DETALLE_D", "ID_CASO", GstrID_CASO, strCampos,"ORDEN", 1);
					    	while (Mdl_Variables.Grst_NuevaTabla.next()==true) {
								bandera = objDetalleAceptanteBL.FinanDescuentosCobEnvioPlanillasDetalle( Mdl_Variables.Grst_NuevaTabla,1);
				    			if(bandera){
									bandera = objFinanciamientoDescuentosCobEnvioPlanillasDetalle.FinanciamientoDescuentosCobEnvioPlanillasDetalle();
								}
							}
						}
					}
					//----------------------------------------termina datos aceptante------------
			    	
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_CREAR_PLANILLA))
					{	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoCrearPlantilla()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CREAR PLANTILLA");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CREAR PLANTILLA");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
				}
			}
			
						
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_SELECCIONAR))
			{	
				//Caso2: Monto total de la planilla a enviar de la grilla envio
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarTablaVerificacion();
				strTexto = objFinanciamientoDescuentosCobEnvioPlanillas.buscarCadenaTabla(strCadena,"MontoTotalGrillaEnvio");
				if(!strTexto.equals(""))
				{	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Monto Total de la grilla Envío: "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Monto Total de la grilla Envío", strCadena, strTexto);
				}else						{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Monto Total de la grilla Envío: ", "" ,"");
				}
				
				//Thread.sleep(1800);
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				intResultadoNumero=objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarPlanillaColumna(GstrTXT_NOMBRE_PLANILLA,7,0);
				
				if (intResultadoNumero!=0){	
					objFuncionesGenerales.callPasosAcierto(2, "el CHECK de la Planilla "+ GstrTXT_NOMBRE_PLANILLA, "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2,  "el CHECK de la Planilla "+ GstrTXT_NOMBRE_PLANILLA, "" ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_VER)&&intResultadoNumero!=0)
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarPlanillaVer(GstrTXT_NOMBRE_PLANILLA,7,0,intResultadoNumero)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"el Link VER ");
					TipoLog="1";
					
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"el Link VER ");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			//----------------------------------------------------------
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_VER)&&intResultadoNumero!=0)
				{	
					if(GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){
						objFinanciamientoDescuentosCobEnvioPlanillas.verificarLinkRegresar();
						strTexto = objFinanciamientoDescuentosCobEnvioPlanillas.buscarCadenaTabla(strCadena,"MontoDetallePlanilla");//CASO3: ver el detalle de la operacion
						if(!strTexto.equals(""))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Monto Detalle de Planilla: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Monto Detalle de Planilla", strCadena, strTexto);
						}else{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Monto Detalle de Planilla: ", "" ,"");
						}
						
						objSQL.listaTablaIdCaso("SELECT ID_CASO_LOTE,CMB_TIPO_DOCUMENTO_ACEPTANTE, TXT_NRO_DOCUMENTO_ACEPTANTE, TXT_NOMBRE_ACEPTANTE,TXT_APEPAT_ACEPTANTE, TXT_APEMAT_ACEPTANTE, TXT_DIRECCION_ACEPTANTE, CMB_UBIGEO_ACEPTANTE, TXT_NUMERO_DOCUMENTOS, BTN_AGREGAR,LINK_VER,BTN_CERRAR FROM APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_DETALLE_D  WHERE  ID_CASO_LOTE="+Mdl_Variables.Gint_IdCaso+" GROUP BY ID_CASO_LOTE,CMB_TIPO_DOCUMENTO_ACEPTANTE, TXT_NRO_DOCUMENTO_ACEPTANTE, TXT_NOMBRE_ACEPTANTE,TXT_APEPAT_ACEPTANTE, TXT_APEMAT_ACEPTANTE, TXT_DIRECCION_ACEPTANTE, CMB_UBIGEO_ACEPTANTE, TXT_NUMERO_DOCUMENTOS, BTN_AGREGAR,LINK_VER,BTN_CERRAR","",5);//Captura todos los valores del detalle del caso
						while (Mdl_Variables.Grst_NuevaTabla.next()==true) {
							bandera = objDetalleAceptanteBL.FinanDescuentosCobEnvioPlanillasDetalle( Mdl_Variables.Grst_NuevaTabla,1);
							
							if (objFuncionesGenerales.verificarIgnore(FinanciamientoDescuentosCobEnvioPlanillasDetalleBE.GstrLINK_VER))
							{	
								LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkVerDetalle()){	
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK del detalle");
									TipoLog="1";
								}else{
									TipoLog="0";									
									bandera = false;
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK del detalle");
								}
								LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
							}
							
							if(bandera){
								if (objFuncionesGenerales.verificarIgnore(FinanciamientoDescuentosCobEnvioPlanillasDetalleBE.GstrLINK_VER)){
									objFinanciamientoDescuentosCobEnvioPlanillas.verificarTablaDetalleEmpresaPlanilla();//CASO4:Validar el detalle de la operacion
									strTexto = objFinanciamientoDescuentosCobEnvioPlanillas.buscarCadenaTabla(strCadena,"MontoDetalleEmpresaPlanilla");
									if(!strTexto.equals(""))
									{	
										objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Monto Detalle de la Empresa Planilla: "+strTexto, "" ,"");
										objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Monto Detalle de la Empresa Planilla", strCadena, strTexto);
									}else						{
										objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Monto Detalle de la Empresa Planilla: ", "" ,"");
									}
								}
							}
							
							if (objFuncionesGenerales.verificarIgnore(FinanciamientoDescuentosCobEnvioPlanillasDetalleBE.GstrBTN_CERRAR))
							{	
								LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonCerrar()){	
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR");
									TipoLog="1";
								}else{
									TipoLog="0";									
									bandera = false;
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR");
								}
								LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
							}
							
						}
					}
				}
			}
			//----------------------------------------------------------
			if (objFuncionesGenerales.verificarIgnore(GstrLINK_REGRESAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkRegresar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link REGRESAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link REGRESAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoEnviar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if(bandera && objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR)){
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarConfirmacionEnvio();
				strTexto = objFinanciamientoDescuentosCobEnvioPlanillas.buscarCadenaTabla(strCadena,"MontoTotalConfirmacion");
				if(!strTexto.equals("")){	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Monto Total de la Confirmación: "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Monto Total de la Confirmación", strCadena, strTexto);
				}else						{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Monto Total de la Confirmación: ", "" ,"");
				}

			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR) && !objFuncionesGenerales.verificarIgnore(GstrCHK_SELECCIONAR) && objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				String strMensajeFront =  objFinanciamientoDescuentosCobEnvioPlanillas.obtenerMensajeFront("CHK_SELECCIONAR",3);
				objFuncionesGenerales.callPasosAcierto(4, strMensajeFront, "" ,"");
				if (strMensajeFront.compareTo("<IGNORE>")!=0){
					if (objFuncionesGenerales.compararTexto(strMensajeFront,GstrTXT_MENSAJE_ERROR)){
						objFuncionesGenerales.callPasosAcierto(5, strMensajeFront, GstrTXT_MENSAJE_ERROR ,"");
						TipoLog="1";
		    		}else{
		    			TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, strMensajeFront, GstrTXT_MENSAJE_ERROR ,"");
		    		}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_ACEPTO_TERMINO)){	
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarConfirmacionEnvio();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoChkAcepto()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en CHECK ACEPTO TERMINO");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en CHECK ACEPTO TERMINO");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (GstrTXT_CLAVE.equals("SI")){	
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarConfirmacionEnvio();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoClave(Mdl_Variables.Gstr_Clave)){	
					objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarConfirmacionEnvio();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La CLAVE DINAMICA "+GstrTXT_CLAVE_DINAMICA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La CLAVE DINAMICA "+GstrTXT_CLAVE_DINAMICA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarConfirmacionEnvio();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonConfirmar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en botón CONFIRMAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en botón CONFIRMAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarConfirmacionEnvio();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonCancelarOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en botón CANCELAR OPERACIÓN");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en botón CANCELAR OPERACIÓN");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR) && objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				String strMensajeFront =  objFinanciamientoDescuentosCobEnvioPlanillas.obtenerMensajeFront(GstrTXT_COLUMNA_ERROR,4);
				objFuncionesGenerales.callPasosAcierto(4, strMensajeFront, "" ,"");
				if (strMensajeFront.compareTo("<IGNORE>")!=0)
				{
					if (objFuncionesGenerales.compararTexto(strMensajeFront,GstrTXT_MENSAJE_ERROR))
					{
						objFuncionesGenerales.callPasosAcierto(5, strMensajeFront, GstrTXT_MENSAJE_ERROR ,"");
						TipoLog="1";
		    		}else{
		    			TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, strMensajeFront, GstrTXT_MENSAJE_ERROR ,"");
		    		}
				}
			}
	
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				String strMensaje =  objFinanciamientoDescuentosCobEnvioPlanillas.obtenerResultadoEsperado();
				//objFuncionesGenerales.callPasosAcierto(4, strMensaje, "" ,"");
				if (objFuncionesGenerales.compararTexto(strMensaje,GstrRESULTADO_ESPERADO)){
					objFuncionesGenerales.callPasosAcierto(5, strMensaje, GstrRESULTADO_ESPERADO ,"");
					TipoLog="1";
					
					
					strTexto = objFinanciamientoDescuentosCobEnvioPlanillas.buscarCadenaTabla(strCadena,"MontoTotalResultadoEsperado");
					if(!strTexto.equals("")){	
						objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Monto Total del Resultado Esperado: "+strTexto, "" ,"");
						objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Monto Total del Resultado Esperado", strCadena, strTexto);
					}else						{
						objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Monto Total del Resultado Esperado: ", "" ,"");
					}
					
	    		}else{
	    			TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, strMensaje, GstrRESULTADO_ESPERADO ,"");
	    		}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_REALIZAR_OTRA_OPERACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkRealizarOtraOperacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Realizar otra operación");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Realizar otra operación");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
						
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkEnviarEmail()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar por e-mail");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Enviar por e-mail");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO )){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarCorreo ( GstrTXT_CORREO )){	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO  , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO  , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO )){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarMensajeCorreo ( GstrTXT_MENSAJE_CORREO )){	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO  , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO  , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO )){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonEnviar ()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ENVIAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CORREO )){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
				objFinanciamientoDescuentosCobEnvioPlanillas.verificarMensajeCorreo();
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonAceptarCorreo ()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ACEPTAR");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón ACEPTAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkExportarExcel()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkExportarPDF()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkImprimir()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK  Imprimir");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK  Imprimir");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if(bandera){
				if (objFinanciamientoDescuentosCobEnvioPlanillas.compararResultadoEsperadoPositivo()){	
					objFinanciamientoDescuentosCobEnvioPlanillas.guardarDatosOperacion();
					if(GstrFIRMAR.equals("NO") && GstrESTADO.equals("Procesada")){
						bandera=objConsultaHistoricaBL.consultaHistorico("Descuentos y Cobranza de Documentos",GstrCMB_EMPRESA,GstrCMB_CUENTA_CORRIENTE,1,GstrESTADO,GstrCONSULTAR_SALDOS_MOVIMIENTOS,Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
					}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
			
			if (bandera){
				if(GstrFIRMAR.equals("SI")){
					
					if(!GstrOPERADOR.equals("<IGNORE>")){
						consultar4=true;
					}else if (!GstrFIRMANTE3.equals("<IGNORE>")){
						consultar3=true;
					}else{
						if (!GstrFIRMANTE2.equals("<IGNORE>")){
							consultar2=true;
						}else{
							if (!GstrFIRMANTE1.equals("<IGNORE>")){
								consultar1=true;
							}
						}
						
					}
					
				if (bandera){
					String tabla_Autorizar_Plantilla="APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_AUTORIZAR_D";
					String tabla_Autorizar_Portabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
					String tabla_Autorizar_autorizacion="APP_AND_AUTORIZACIONES_PENDIENTES_D";
					
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))	{
						if (GstrFIRMANTE1.equals("PA")  ){
							bandera=objFirmarBL.descuentosCobranzas(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F1",consultar1);
						}else if (GstrFIRMANTE1.equals("PORT") ){
							bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Descuentos y Cobranza de Documentos",consultar1,null,null,null);
						}else{
							bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F1",GstrCMB_PRODUCTO,consultar1);
						}
					}
					
					if(bandera){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2))
						{
							if (GstrFIRMANTE2.equals("PA") ){
								bandera=objFirmarBL.descuentosCobranzas(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F2",consultar2);
							}else if (GstrFIRMANTE2.equals("PORT")  ){
								bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Descuentos y Cobranza de Documentos",consultar2,null,null,null);
							}else{
								bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F2",GstrCMB_PRODUCTO,consultar2);
							}
						}
						
						if(bandera){
							if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3))
							{
								if (GstrFIRMANTE3.equals("PA") ){
									bandera=objFirmarBL.descuentosCobranzas(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F3",consultar3);
								}else if (GstrFIRMANTE3.equals("PORT") ){
									bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Descuentos y Cobranza de Documentos",consultar3,null,null,null);
								}else{
									bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F3",GstrCMB_PRODUCTO,consultar3);
								}
							}
							
							if(bandera){
								if(objFuncionesGenerales.verificarIgnore(GstrOPERADOR)){
									if (GstrOPERADOR.equals("PA") ){
										bandera=objFirmarBL.descuentosCobranzas(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"OP",consultar4);
									}else{
										bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"OP",GstrCMB_PRODUCTO,consultar4);
									}
								}
							}
						}
					}
				}
			}
		}	
		}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}
	
}
