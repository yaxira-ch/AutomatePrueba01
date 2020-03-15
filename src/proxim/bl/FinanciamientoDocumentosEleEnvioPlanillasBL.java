package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleEnvioPlanillasBL extends FinanciamientoDocumentosEleEnvioPlanillasBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	FinanciamientoDocumentosEleEnvioPlanillasMapeo objFinanciamientoDocumentosEleEnvioPlanillasBE= new FinanciamientoDocumentosEleEnvioPlanillasMapeo();
	private static String TipoLog = null;
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	FinanciamientoDocumentosEleEnvioPlanillasDetalleBE objFinanDocumentosEleEnvioPlanillasDetalleBL = new FinanciamientoDocumentosEleEnvioPlanillasDetalleBE();
	FinanciamientoDocumentosEleEnvioPlanillasDetalleBL objFinanciamientoEnvioPlanillasDocElectronicosDetalleBL=new FinanciamientoDocumentosEleEnvioPlanillasDetalleBL();
	FirmarBL objFirmarBL =new FirmarBL();

	public boolean financiamientoDocElecEnvioPlanillas() throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		boolean consultar4=false;
		try {
				
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			
//			if (objFuncionesGenerales.verificarIgnore(FinanDocumentosEleEnvioPlanillasBL.GstrTXT_SUBMENU1)){	
//				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//				if (objFinanciamientoDocEleEnvioPlanillas.seleccionarSubMenu1(FinanDocumentosEleEnvioPlanillasBL.GstrTXT_SUBMENU1)){	
//					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+FinanDocumentosEleEnvioPlanillasBL.GstrTXT_SUBMENU1);
//					TipoLog="1";
//				}else{
//					TipoLog="0";								
//					bandera = false;
//					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+FinanDocumentosEleEnvioPlanillasBL.GstrTXT_SUBMENU1);
//				}
//				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//			}
			//------------------------------------------------------------------------------			
			objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarEnvioCamposObligatorios();
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA)){		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarTipoEmpresa(GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA: "+GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA: "+GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CARGA)){		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarTipoCarga(GstrCMB_TIPO_CARGA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE CARGA '"+GstrCMB_TIPO_CARGA +"'", "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE CARGA '"+GstrCMB_TIPO_CARGA +"'", "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_POP_UP)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonSiPopUp()){	
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_POP_UP)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonNoPopUp()){	
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_PRODUCTO) && GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarProducto(GstrCMB_PRODUCTO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO '"+GstrCMB_PRODUCTO+"'", "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO '"+GstrCMB_PRODUCTO +"'", "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrRDB_PROVEEDOR)&& GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoRDBProveedor()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Radio Button PROVEEDOR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Radio Button PROVEEDOR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrRDB_CLIENTE)&& GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoRDBCliente()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Radio Button CLIENTE");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Radio Button CLIENTE");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA)&& GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarMoneda(GstrCMB_MONEDA))
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CARGO)&& GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarCuentaCargo(GstrCMB_CUENTA_CARGO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA de CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la CUENTA de CARGO "+GstrCMB_CUENTA_CARGO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_PLANILLA) && GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresarNombrePlanilla(GstrTXT_NOMBRE_PLANILLA)){	
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

			if (objFuncionesGenerales.verificarIgnore(GstrRDB_CON_CONFIRMACION)&& GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoRDBConConfirmacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Radio Button CON CONFIRMACION");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Radio Button CON CONFIRMACION");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrRDB_SIN_CONFIRMACION)&& GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoRDBSinConfirmacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Radio Button SIN CONFIRMACION");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Radio Button SIN CONFIRMACION");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_SELECCIONAR_ARCHIVO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonSeleccionarArchivo(GstrBTN_SELECCIONAR_ARCHIVO)){	
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
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_AGREGAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonAgregar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón AGREGAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón AGREGAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   //	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
    			CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			
			//------------------------------LLENAR DETALLE------------------------------
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CARGA) &&GstrCMB_TIPO_CARGA.equals("Digitación Electrónica")){	
				objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarCabecera();
				objSQL.listaTablaIdCaso("SELECT ID_CASO_LOTE,CMB_PROVEDOR_AFILIADO, CMB_TIPO_DOCUMENTO, TXT_NUMERO_DOCUMENTOS, BTN_AGREGAR FROM APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS_DETALLE  WHERE  ID_CASO_LOTE="+Mdl_Variables.Gint_IdCaso+"GROUP BY ID_CASO_LOTE,CMB_PROVEDOR_AFILIADO,CMB_TIPO_DOCUMENTO,TXT_NUMERO_DOCUMENTOS,BTN_AGREGAR","",5);//Captura todos los valores del detalle del caso
				int numeroDetalle=0;
				while (Mdl_Variables.Grst_NuevaTabla.next()==true) {
					numeroDetalle=numeroDetalle+1;
					bandera = objFinanDocumentosEleEnvioPlanillasDetalleBL.FinanDocumentosEleEnvioPlanillasDetalle( Mdl_Variables.Grst_NuevaTabla,1);
	    			if(bandera){
						bandera = objFinanciamientoEnvioPlanillasDocElectronicosDetalleBL.FinanciamientoEnvioPlanillasDocElecEnvioPlanillas(1,numeroDetalle);
					}
				}
				
			}
			
			//---------------------------------------------------------------------------

			if (objFuncionesGenerales.verificarIgnore(FinanciamientoDocumentosEleEnvioPlanillasBE.GstrBTN_CREAR_PLANILLA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonCrearPlanilla()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ," en el Botón CREAR PLANILLA");
					TipoLog="1";
					
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ," en el Botón CREAR PLANILLA");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//------------------------------SELECCIONAR REGISTROS A ENVIAR------------------------------
			
			if(objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS)){
				objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarTablaLotes();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if(objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoCheckTodos()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LOTE a enviar");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LOTE a enviar");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if(objFuncionesGenerales.verificarIgnore(GstrCHK_LOTE)){
				objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarTablaLotes();
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if(objFinanciamientoDocumentosEleEnvioPlanillasBE.seleccionarLoteEnviar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LOTE a enviar");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LOTE a enviar");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//---------------------------------------------------------------------------
			if(bandera){
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonEnviar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ," en el Botón ENVIAR ");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ," en el Botón ENVIAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (GstrTXT_CLAVE.equals("SI")){	
					objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarConfirmarEnvio();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoClave(Mdl_Variables.Gstr_Clave)){	
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
					objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarConfirmarEnvio();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
						objFuncionesGenerales.callPasosAcierto(3, "La clave dinámica", GstrTXT_CLAVE_DINAMICA,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La clave dinámica", GstrTXT_CLAVE_DINAMICA,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){
					objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarConfirmarEnvio();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonConfirmar()){//se guarda en base de datos	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleEnvioPlanillasBE.ingresoBotonCancelarOperacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
						TipoLog="1";
					}else{
						TipoLog="0";								
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACIÓN");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO)){	
					objFinanciamientoDocumentosEleEnvioPlanillasBE.verificarResultadoFinal();
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objFinanciamientoDocumentosEleEnvioPlanillasBE.compararMensajeResultante(GstrRESULTADO_ESPERADO)){	
						objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado", "Resultado Obtenido" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado", "Resultado Obtenido" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.scrollCapturaPantalla();
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if(bandera){
					if (objFinanciamientoDocumentosEleEnvioPlanillasBE.compararResultadoEsperadoPositivo()){	
						objFinanciamientoDocumentosEleEnvioPlanillasBE.GuardarDatosOperacionAutorizar();
						
						if(GstrFIRMAR.equals("NO") && GstrESTADO.equals("Procesada")){
							bandera=objConsultaHistoricaBL.consultaHistorico("Documentos Electrónicos",GstrCMB_EMPRESA,GstrCMB_CUENTA_CARGO,1,GstrESTADO,GstrCONSULTAR_SALDOS_MOVIMIENTOS,Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
//							bandera=objFinanciamientoDocumentosEleEnvioPlanillasProcesadasBL.financiamientoDocumentosEleEnvioPlanillasProcesadas(1);
//						
//							if (bandera&& objFuncionesGenerales.verificarIgnore(GstrCONSULTAR_SALDOS_MOVIMIENTOS)){
//								bandera=objConsultaSaldoMovimientoConsolidadoBL .ConsultaSaldoMovimientos(FinanDocumentosEleEnvioPlanillasBL.GstrCMB_EMPRESA,FinanDocumentosEleEnvioPlanillasBL.GstrCMB_CUENTA_CARGO);
//							}
						}
					}
				}
					
//				if (objFuncionesGenerales.verificarIgnore( GstrLNK_REALIZAR_OTRA_OPERACION)){	
//					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//					if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkRealizarOtraOperacion()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Realizar otra operación");
//						TipoLog="1";
//					}else{
//						TipoLog="0";								
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Realizar otra operación");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				    CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	        		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
//							
//				if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL)){	
//					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//					if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkEnviarEmail()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar por e-mail");
//						TipoLog="1";
//					}else{
//						TipoLog="0";								
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Enviar por e-mail");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				    CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	        		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL)){	
//					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//					if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkExportarExcel()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
//						TipoLog="1";
//					}else{
//						TipoLog="0";								
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				    CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	        		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_PDF)){	
//					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//					if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkExportarPDF()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
//						TipoLog="1";
//					}else{
//						TipoLog="0";								
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				    CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	        		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore( GstrLNK_IMPRIMIR)){	
//					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//					if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoLinkImprimir()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK  Imprimir");
//						TipoLog="1";
//					}else{
//						TipoLog="0";								
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK  Imprimir");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				    CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	        		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
			
			if (bandera && GstrFIRMAR.equals("SI")){
					
					if(!GstrOPERADOR.equals("<IGNORE>")){
						consultar4=true;
					}else{
						if (!GstrFIRMANTE3.equals("<IGNORE>")){
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
					}
						
					
						String tabla_Autorizar_Plantilla="APP_FINANCIAMIENTO_DOCELE_ENVPLANILLAS_AUTORIZAR_D";
						String tabla_Autorizar_Portabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
						String tabla_Autorizar_autorizacion="APP_AND_AUTORIZACIONES_PENDIENTES_D";
						
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))	{
							if (GstrFIRMANTE1.equals("PA") || GstrFIRMANTE1.equals("PA-B") ){
								bandera=objFirmarBL.documentosElectronicos(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F1",consultar1);
							}else if (GstrFIRMANTE1.equals("PORT") || GstrFIRMANTE1.equals("PORT-B") ){
								bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F1' AND LBL_TIPO_OPERACION='Documentos Electrónicos",consultar1,null,null,null);
							}else{
								bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F1",GstrCMB_PRODUCTO,consultar1);
							}
							
						}
						
						if(bandera){
							if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
								if (GstrFIRMANTE2.equals("PA") || GstrFIRMANTE2.equals("PA-B")){
									bandera=objFirmarBL.documentosElectronicos(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F2",consultar2);
								}else if (GstrFIRMANTE2.equals("PORT") || GstrFIRMANTE2.equals("PORT-B") ){
									bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F2' AND LBL_TIPO_OPERACION='Documentos Electrónicos",consultar2,null,null,null);
								}else{
									bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F2",GstrCMB_PRODUCTO,consultar2);
								}
							}
							
							if(bandera){
								if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
									if (GstrFIRMANTE3.equals("PA") || GstrFIRMANTE3.equals("PA-B")){
										bandera=objFirmarBL.documentosElectronicos(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F3",consultar3);
									}else if (GstrFIRMANTE3.equals("PORT") || GstrFIRMANTE3.equals("PORT-B") ){
										bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F3' AND LBL_TIPO_OPERACION='Documentos Electrónicos",consultar3,null,null,null);
									}else{
										bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F3",GstrCMB_PRODUCTO,consultar3);
									}
								}
								
								if(bandera&&objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
									bandera=objFirmarBL.documentosElectronicos(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"OP",consultar4);
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
