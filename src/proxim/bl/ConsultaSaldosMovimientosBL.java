package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaSaldosMovimientosBL extends ConsultaSaldosMovimientosBE{
	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConsultaSaldosMovimientosMapeo objConsultaSaldoMovimientoBE = new ConsultaSaldosMovimientosMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	
	public boolean consultasSaldosMovimientos() throws SQLException, IOException{
		boolean lbn_ResultadoEsperado = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		String strCadena = "S/.";
		String strTexto; 
		try {
				
			objHeader.menuPrincipal("<IGNORE>",GstrTXT_MENU, GstrTXT_SUBMENU);
			
			//-------------------------------------------------------------------------------------------------------------------
			
			if (GstrTXT_SUBMENU1.equals("Saldos y Movimientos")){
				objConsultaSaldoMovimientoBE.verificarPestania();

				if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA))
				{		
					if (objConsultaSaldoMovimientoBE.seleccionarEmpresa(GstrCMB_EMPRESA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_PRODUCTO))
				{		
					if (objConsultaSaldoMovimientoBE.seleccionarTipoProducto(GstrCMB_TIPO_PRODUCTO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE PRODUCTO "+GstrCMB_TIPO_PRODUCTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, "del TIPO DE PRODUCTO "+GstrCMB_TIPO_PRODUCTO , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))
				{		
					if (objConsultaSaldoMovimientoBE.seleccionarMoneda(GstrCMB_MONEDA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+GstrCMB_MONEDA , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				//----------------------------Validar Soles
				
				strTexto = objConsultaSaldoMovimientoBE.BuscarCadenaTabla(strCadena,"SaldoDisponibleCuenta");
				if(!strTexto.equals(""))
				{	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldos disponibles de las cuentas: "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Saldos disponibles de las cuentas" , strCadena, strTexto);
				}else						{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldos disponibles de las cuentas", "" ,"");
				}
				
				strTexto = objConsultaSaldoMovimientoBE.obtenerTotalSolesEmepresa();
				if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
				{	
					objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Total Soles Empresa: "+strTexto, "" ,"");
					objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Total Soles Empresa", strCadena, strTexto);
				}else						{
					objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Total Soles Empresa: "+strTexto, "" ,"");
				}
				//----------------------------
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_ALIAS))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
					if (objConsultaSaldoMovimientoBE.ingresarAlias(GstrTXT_ALIAS))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El ALIAS "+GstrTXT_ALIAS , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, "El ALIAS "+GstrTXT_ALIAS , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				//-------------------EXPORTAR SALDOS Y MOVIMIENTOS
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_TEXTO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkEnviarTexto()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar a Texto");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Enviar a Texto");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkExportarExcel()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkExportarPDF()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkImprimir()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Imprimir");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Imprimir");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
		    		CapturarPantalla.esc();
				}
				
				//--------------------------------------------FIN EXPORTACION
				
				//--------------------------------------------INICIO DE SALDOS
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_NUMERO_CUENTA)){	//Para ingresar a saldos
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.seleccionarLinkNumeroCuenta()){	
						objConsultaSaldoMovimientoBE.verificarSaldosCuenta();
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción NUMERO DE CUENTA "+GstrLNK_NUMERO_CUENTA);
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción NUMERO DE CUENTA "+GstrLNK_NUMERO_CUENTA);
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_SALDO_DISPONIBLE)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoBotonSaldoDisponible()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Saldo No Disponible");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Saldo No Disponible");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_DEPOSITOS_CHEQUES)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoBotonDepositoCheque()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Depósito con Cheques");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"Depósito con Cheques");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				
				if (objFuncionesGenerales.verificarIgnore(GstrVALIDAR_SALDOS_CICS)){//Validar saldos	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.comparaSaldos()){	
						objFuncionesGenerales.callPasosAcierto(1, "Saldos Mostrados en el CICS", "Saldos Mostrados en la BPI" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "Saldos Mostrados en el CICS", "Saldos Mostrados en la BPI" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
//-----------------Verificar los simbolos Soles
				
				if(objConsultaSaldoMovimientoBE.visibleSaldosCuenta()){
					if(GstrCMB_TIPO_PRODUCTO.equals("Depósitos a Plazos")){
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerCapital();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Capital: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Capital" , strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Capital: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerDepositoCheque();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Depósito con cheque: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Depósito con cheque" , strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Depósito con cheque: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerTotalRetenciones();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Total Retenciones: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo , "Total Retenciones",strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Total Retenciones: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerMontoCancelacion();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Monto de Cancelación: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Monto de Cancelación", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Monto de Cancelación: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerInteresProyectadoVencimiento();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Interés Proyectado al Vencimiento: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Interés Proyectado al Vencimiento", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Interés Proyectado al Vencimiento: "+strTexto, "" ,"");
						}
					}else if(GstrCMB_TIPO_PRODUCTO.equals("Fondos Mutuos")){ 
						strTexto = objConsultaSaldoMovimientoBE.BuscarCadenaTabla(strCadena,"DetallValorCuota");
						if(!strTexto.equals(""))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldos disponibles de las cuentas: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Detalle Saldo Valor Cuota", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldos disponibles de las cuentas", "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.BuscarCadenaTabla(strCadena,"DetalleSaldo");
						if(!strTexto.equals(""))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldos disponibles de las cuentas: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo , "Detalle Saldo Saldo ",strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldos disponibles de las cuentas", "" ,"");
						}
					}else{
						strTexto = objConsultaSaldoMovimientoBE.obtenerSaldodisponible();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldo disponible: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Saldo Disponible" , strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldo disponible: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerSaldoNoDisponible();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldo No Disponible: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Saldo No Disponible" , strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldo No Disponible: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerDepositoConCheques();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Depósito con Cheques: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo , "Depósito con Cheques",strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Depósito con Cheques: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerUnDia();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, 01 Día: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"01 Día", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, 01 Día: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerDosDias();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, 02 Días: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"02 Días", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, 02 Días: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerTresDias();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, 03 Días: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"03 Días", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, 03 Días: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerMasTresDias();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Más de 03 Días: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Más de 03 Días", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Más de 03 Días: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerOtrasRetenciones();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Otras retenciones: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Otras retenciones", strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Otras retenciones: "+strTexto, "" ,"");
						}
						
						strTexto = objConsultaSaldoMovimientoBE.obtenerSaldoContable();
						if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
						{	
							objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldo Contable: "+strTexto, "" ,"");
							objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Saldo Contable" , strCadena, strTexto);
						}else						{
							objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldo Contable: "+strTexto, "" ,"");
						}
						
						if(!GstrCMB_TIPO_PRODUCTO.equals("Cuenta de Ahorros")){ 
							strTexto = objConsultaSaldoMovimientoBE.obtenerSobregiroAutorizado();
							if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
							{	
								objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Sobregiro Autorizado: "+strTexto, "" ,"");
								objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Sobregiro Autorizado" , strCadena, strTexto);
							}else						{
								objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Sobregiro Autorizado: "+strTexto, "" ,"");
							}
						}else{
							strTexto = objConsultaSaldoMovimientoBE.obtenerInteres();
							if(objFuncionesGenerales.buscarCadena(strCadena, strTexto))
							{	
								objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Interes: "+strTexto, "" ,"");
								objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo,"Interes" , strCadena, strTexto);
							}else						{
								objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Interes: "+strTexto, "" ,"");
							}
						}
					}
				}
				//-----------------------------------------------------------------------
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL_SALDOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkExportarExcelSaldo()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF_SALDOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkExportarPDFSaldo()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR_SALDOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkImprimirSaldo()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Imprimir");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Imprimir");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
		    		CapturarPantalla.esc();
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_SALDOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
					Thread.sleep(600);
					if (objConsultaSaldoMovimientoBE.ingresoLinkRegresarSaldo()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Regresar a la pantalla anterior ");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Regresar a la pantalla anterior ");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				
				//-------realizar verificacion de los saldos
				
				//--------------------------------------------FIN SALDOS
				
				//------------------------------------------------MOVIMIENTOS-----------------------------------------------
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_SALDO_DISPONIBLE)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.seleccionarLinkSaldoDisponible()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción SALDO DISPONIBLE "+GstrLNK_SALDO_DISPONIBLE);
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción SALDO DISPONIBLE "+GstrLNK_SALDO_DISPONIBLE);
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				
//				if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_MOVIMIENTO))
//				{		
//					objConsultaSaldoMovimientoBE.verificarPestania();
//					if (objConsultaSaldoMovimientoBE.seleccionarEmpresaMovimiento(GstrCMB_EMPRESA_MOVIMIENTO))
//					{	
//						objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA_MOVIMIENTO , "" ,  "");
//						TipoLog="1";
//					}else{
//						TipoLog="0";		
//						lbn_ResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA_MOVIMIENTO , "" ,  "");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CUENTA))
//				{		
//					if (objConsultaSaldoMovimientoBE.seleccionarTipoCuentaMovimiento(GstrCMB_TIPO_CUENTA))
//					{	
//						objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE PRODUCTO "+GstrCMB_TIPO_CUENTA , "" ,  "");
//						TipoLog="1";
//					}else{
//						TipoLog="0";		
//						lbn_ResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(2, "del TIPO DE PRODUCTO "+GstrCMB_TIPO_CUENTA , "" ,  "");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_MOVIMIENTO))
//				{		
//					if (objConsultaSaldoMovimientoBE.seleccionarCuentaMovimiento(GstrCMB_CUENTA_MOVIMIENTO))
//					{	
//						objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA "+GstrCMB_CUENTA_MOVIMIENTO , "" ,  "");
//						TipoLog="1";
//					}else{
//						TipoLog="0";		
//						lbn_ResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(2, "de la CUENTA "+GstrCMB_CUENTA_MOVIMIENTO, "" ,  "");
//					}
//					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRBT_FECHA_OPERACION)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.seleccionarFechaOperacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción FECHA OPERACION "+GstrRBT_FECHA_OPERACION);
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción FECHA OPERACION "+GstrRBT_FECHA_OPERACION);
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrRBT_FECHA_PROCESO)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.seleccionarFechaProceso()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción FECHA PROCESO "+GstrRBT_FECHA_PROCESO);
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción SALDO PROCESO "+GstrRBT_FECHA_PROCESO);
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
		
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE))
				{		
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresarFechaDesde(GstrTXT_FECHA_DESDE))
					{	
						objFuncionesGenerales.callPasosAcierto(3, GstrTXT_FECHA_DESDE , "" ,  "");
					}else{			
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, GstrTXT_FECHA_DESDE , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA))
				{		
					if (objConsultaSaldoMovimientoBE.ingresarFechaHasta(GstrTXT_FECHA_HASTA))
					{	
						objFuncionesGenerales.callPasosAcierto(3, GstrTXT_FECHA_HASTA , "" ,  "");
					}else{			
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(3, GstrTXT_FECHA_HASTA , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){			
					if (objConsultaSaldoMovimientoBE.ingresoBotonBuscar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
						Thread.sleep(10000);
						if (objConsultaSaldoMovimientoBE.visibleMovimientosCuenta()){
							//objConsultaSaldoMovimientoBE.verificarTablaResultado();
							if(GstrCMB_TIPO_PRODUCTO.equals("Depósitos a Plazos")||GstrCMB_TIPO_PRODUCTO.equals("Fondos Mutuos")){
								strTexto = objConsultaSaldoMovimientoBE.BuscarCadenaTabla(strCadena,"DetalleMovimientosMontoCuentaPlazos");
								if(!strTexto.equals(""))
								{	
									objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldos disponibles de las cuentas: "+strTexto, "" ,"");
									objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Detalle Movimientos Monto", strCadena, strTexto);
								}else						{
									objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldos disponibles de las cuentas", "" ,"");
								}
								
								strTexto = objConsultaSaldoMovimientoBE.BuscarCadenaTabla(strCadena,"DetalleMovimientosSaldoDisponible");
								if(!strTexto.equals(""))
								{	
									objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldos disponibles de las cuentas: "+strTexto, "" ,"");
									objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo , "Detalle Movimientos Saldo disponible",strCadena, strTexto);
								}else						{
									objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldos disponibles de las cuentas", "" ,"");
								}
							}
						}else { 
							strTexto = objConsultaSaldoMovimientoBE.BuscarCadenaTabla(strCadena,"DetalleMovimientosMonto");
							if(!strTexto.equals(""))
							{	
								objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldos disponibles de las cuentas: "+strTexto, "" ,"");
								objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Detalle Movimientos Monto", strCadena, strTexto);
							}else						{
								objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldos disponibles de las cuentas", "" ,"");
							}
							
							strTexto = objConsultaSaldoMovimientoBE.BuscarCadenaTabla(strCadena,"DetalleMovimientosSaldoContable");
							if(!strTexto.equals(""))
							{	
								objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Saldos disponibles de las cuentas: "+strTexto, "" ,"");
								objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo , "Detalle Movimientos Saldo Contable",strCadena, strTexto);
							}else						{
								objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Saldos disponibles de las cuentas", "" ,"");
							}
						}
					}
					else{									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
	    			CapturarPantalla.scrollCapturaPantalla();
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_TEXTO_MOVIMIENTOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkEnviarTextoMovimientos()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Enviar a Texto");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Enviar a Texto");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL_MOVIMIENTOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkExportarExcelMovimientos()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a Excel");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a Excel");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF_MOVIMIENTOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkExportarPDFMovimientos()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Exportar a PDF");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Exportar a PDF");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR_MOVIMIENTOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkImprimirMovimientos()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Imprimir");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Imprimir");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
		    		CapturarPantalla.esc();
				}
				
				
				//----------------------------Validad POP UP--------------------------------// 
				int numeroFila=0;
				if (objFuncionesGenerales.verificarIgnore(GstrCODIGO_UBICACION)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					numeroFila=objConsultaSaldoMovimientoBE.seleccionarCodigoUbicacion();
					if (numeroFila!=0){	
						objFuncionesGenerales.callPasosAcierto(6, "", "" ,"el Código Ubicación: "+GstrCODIGO_UBICACION);
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(6, "", "" ,"el Código Ubicación: "+GstrCODIGO_UBICACION);
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				
				
					if (numeroFila!=0){	
						if (objFuncionesGenerales.verificarIgnore("CLICK")){	
							LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							if (objConsultaSaldoMovimientoBE.HacerClicCodigoUnico(numeroFila)){	
								objFuncionesGenerales.callPasosAcierto(1, "en el Código Ubicación: "+GstrCODIGO_UBICACION, "" ,"");
								TipoLog="1";
							}else{
								TipoLog="0";									
								lbn_ResultadoEsperado = false;
								objFuncionesGenerales.callPasosErrado(1, "en el Código Ubicación: "+GstrCODIGO_UBICACION, "" ,"");
							}
							LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
						}
						
						if(lbn_ResultadoEsperado){
							
							if (objFuncionesGenerales.verificarIgnore("CLICK")){	
								LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								if (objConsultaSaldoMovimientoBE.validarCampos()){	
									objFuncionesGenerales.callPasosAcierto(7, "Validacion del: Titulo, Codigo, del mensaje de descarga. ", "" ,"");
									TipoLog="1";
								}else{
									TipoLog="0";									
									lbn_ResultadoEsperado = false;
									objFuncionesGenerales.callPasosErrado(7, "Validacion del: Titulo, Codigo, del mensaje de descarga. ", "" ,"");
								}
								LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
							}
							
							if (objFuncionesGenerales.verificarIgnore(GstrLNK_DESCARGAR_EXPORTABLE)){	
								LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								if (objConsultaSaldoMovimientoBE.ingresoLinkDescargar()){	
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Descargar guía de los canales.");
									TipoLog="1";
								}else{
									TipoLog="0";									
									lbn_ResultadoEsperado = false;
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Descargar guía de los canales.");
								}
								LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
							}
							
							if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_POP_UP)){	
								LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
								if (objConsultaSaldoMovimientoBE.ingresoBtn_CerrarPopUp()){	
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Boton Cerrar.");
									TipoLog="1";
								}else{
									TipoLog="0";									
									lbn_ResultadoEsperado = false;
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Boton Cerrar.");
								}
								LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
							   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
							}
						}
						
					}
				}
				//--------------------------------------------------------------------------// 
				
				
				//Validar el movimiento
				if (objFuncionesGenerales.verificarIgnore(GstrVALIDAR_MOVIMIENTOS_CICS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.comparaMovimietnosCicsBpi()){	
						objFuncionesGenerales.callPasosAcierto(1, "Movimientos Mostrados en el CICS", "Movimientos Mostrados en la BPI" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "Movimientos Mostrados en el CICS", "Movimientos Mostrados en la BPI" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR_MOVIMIENTOS)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoLinkRegresarMovimientos()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Regresar a la pantalla anterior ");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Regresar a la pantalla anterior ");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				//----------------------------------------------------------------------------------------------------------
			}else{
				objConsultaSaldoMovimientoBE.verificarPestania();
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
						TipoLog="1";
					}else{
						TipoLog="0";								
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.scrollCapturaPantalla();
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(ConsultaSaldosMovimientosBE.GstrCMB_EMPRESA))
				{		
					if (objConsultaSaldoMovimientoBE.seleccionarEmpresaEstadoCuenta(ConsultaSaldosMovimientosBE.GstrCMB_EMPRESA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+ConsultaSaldosMovimientosBE.GstrCMB_EMPRESA , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+ConsultaSaldosMovimientosBE.GstrCMB_EMPRESA , "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA))
				{		
					if (objConsultaSaldoMovimientoBE.seleccionarCuentaEstadoCuenta(GstrCMB_CUENTA))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA "+GstrCMB_CUENTA , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(2, "de la CUENTA "+GstrCMB_CUENTA, "" ,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_BUSCAR)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objConsultaSaldoMovimientoBE.ingresoBotonEstadoCuenta()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Boton Buscar");
						TipoLog="1";
					}else{
						TipoLog="0";									
						lbn_ResultadoEsperado = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Boton Buscar");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldoMovimientoBE.ingresoVerificarError(GstrTXT_COLUMNA_ERROR,GstrTXT_MENSAJE_ERROR)){	
					objFuncionesGenerales.callPasosAcierto(5, "Mensaje esperado", "Mensaje mostrado" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					lbn_ResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(5, "Mensaje esperado", "Mensaje mostrado" ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_CERRAR_SESION)){	
				objHeader.cerrarSesion( GstrLNK_CERRAR_SESION, GstrLNK_CERRAR_SESION);
			}	
			
			
		}catch (Exception e) {
			lbn_ResultadoEsperado = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso)); 
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return lbn_ResultadoEsperado;
	}
}
	