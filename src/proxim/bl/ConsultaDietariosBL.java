package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.ConsultaDietariosBE;
import proxim.be.ConsultaSaldosMovimientosBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaDietariosBL extends ConsultaDietariosBE {
	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConsultaDietariosMapeo objConsultaDietariosBE = new ConsultaDietariosMapeo();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	boolean blnBandera = true;
	
	public boolean ConsultaDietarios() throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		
		Mdl_Variables.GstrSIS_GRUPOEJECUCION = Gstr_ID_CASO + "-"+ new SimpleDateFormat("yyyyMMddHHmm").format(Calendar.getInstance().getTime());
		try {
			
//ACCESO AL MENÚ
			
			obtenerCuenta();
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrTXT_MENU)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaDietariosBE.seleccionarMenu(ConsultaDietariosBE.GstrTXT_MENU)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el MENU, "+ConsultaDietariosBE.GstrTXT_MENU);
				}else{								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el MENU, "+ConsultaDietariosBE.GstrTXT_MENU);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrTXT_SUBMENU1)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaDietariosBE.seleccionarSubMenu1(ConsultaDietariosBE.GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el SUB MENU, "+ConsultaDietariosBE.GstrTXT_SUBMENU1);
				}else{								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el SUB MENU, "+ConsultaDietariosBE.GstrTXT_SUBMENU1);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			objConsultaDietariosBE.clicMenu();

//INGRESO DE DATA
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrCMB_EMPRESA))
			{		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objConsultaDietariosBE.seleccionarEmpresa(ConsultaDietariosBE.GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA CUENTA DE ORIGEN, "+ConsultaDietariosBE.GstrCMB_EMPRESA , "" ,  "");
				}else{	
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA CUENTA DE ORIGEN, "+ConsultaDietariosBE.GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_DESDE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objConsultaDietariosBE.seleccionarFechaDesde(GstrTXT_FECHA_DESDE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE OPERACIÓN DESDE "+ GstrTXT_FECHA_DESDE , "" ,  "");
				}else{			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE OPERACIÓN DESDE "+ GstrTXT_FECHA_DESDE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_HASTA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objConsultaDietariosBE.seleccionarFechaHasta(GstrTXT_FECHA_HASTA))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE OPERACIÓN HASTA "+ GstrTXT_FECHA_HASTA , "" ,  "");
				}else{		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE OPERACIÓN DESDE "+ GstrTXT_FECHA_HASTA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}			
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrCMB_CUENTA_CARGO))
			{		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				String cuentaCargo=ConsultaDietariosBE.GstrCMB_CUENTA_CARGO+" Saldo Disponible "+Mdl_Variables.Gstr_SaldoDisponible;
				if (objConsultaDietariosBE.seleccionarCuentaCargo(cuentaCargo)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DE CARGO, "+ConsultaDietariosBE.GstrCMB_CUENTA_CARGO , "" ,  "");
				}else{		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "CUENTA DE CARGO, "+ConsultaDietariosBE.GstrCMB_CUENTA_CARGO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
//CLICK BOTÓN BUSCAR
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrBTN_BUSCAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaDietariosBE.ingresoBotonBuscar()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONSULTAR");
				}else{								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONSULTAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
//VALIDANDO CAMPOS VACÍOS			
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
				if(GstrTXT_COLUMNA_ERROR.equals("CMB_EMPRESA")||GstrTXT_COLUMNA_ERROR.equals("TXT_FECHA_DESDE")||GstrTXT_COLUMNA_ERROR.equals("TXT_FECHA_HASTA")||GstrTXT_COLUMNA_ERROR.equals("TXT_CUENTA_CARGO")){
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
					if (objConsultaDietariosBE.compararMensajeError(GstrTXT_MENSAJE_ERROR,GstrTXT_COLUMNA_ERROR)){	
						objFuncionesGenerales.callPasosAcierto(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					}
					else{
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, "Entre el mensaje de error", "el mensaje esperado" ,"");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
//LINK DE EXPORTABLES
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrLNK_EXPORTAR_CSV)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaDietariosBE.ingresoExportarCsv()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR CSV");
				}else{		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR CSV");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaDietariosBE.ingresoExportarExcel()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
				}else{		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrLNK_EXPORTAR_PDF)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaDietariosBE.ingresoExportarPdf()){
					Thread.sleep(3000);
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
				}else{		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
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

	private void obtenerCuenta() {
		// TODO Auto-generated method stub
		
		try{
			
			String LStr_HoraFin;
			long Lng_TiempoEjeCaso;
			String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
			ConsultaSaldosMovimientosMapeo objConsultaSaldoMovimientoBE= new ConsultaSaldosMovimientosMapeo();
			
			if (objFuncionesGenerales.verificarIgnore("Saldos y Movimientos")){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldoMovimientoBE.seleccionarSubMenu1("Saldos y Movimientos")){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+ConsultaSaldosMovimientosBE.GstrTXT_SUBMENU1);
					TipoLog="1";
				}else{
					TipoLog="0";								
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+ConsultaSaldosMovimientosBE.GstrTXT_SUBMENU1);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrCMB_EMPRESA))
			{		
				if (objConsultaSaldoMovimientoBE.seleccionarEmpresa(ConsultaDietariosBE.GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+ConsultaDietariosBE.GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+ConsultaDietariosBE.GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			String lstrIipoProducto="";
			String lstrMoneda="";
			String lstrNumeroCuenta=ConsultaDietariosBE.GstrCMB_CUENTA_CARGO.substring(ConsultaDietariosBE.GstrCMB_CUENTA_CARGO.length()-14);
			
			if(ConsultaDietariosBE.GstrCMB_CUENTA_CARGO.contains("Ahorros")){
				lstrIipoProducto="Cuenta de Ahorros";
			}else{
				lstrIipoProducto="Cuenta Corriente";
			}
			
			if(ConsultaDietariosBE.GstrCMB_CUENTA_CARGO.contains("Soles")){
				lstrMoneda="Soles";
			}else{
				lstrMoneda="Dólares";
			}
			
			
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrCMB_CUENTA_CARGO))
			{		
				if (objConsultaSaldoMovimientoBE.seleccionarTipoProducto(lstrIipoProducto))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE PRODUCTO "+lstrIipoProducto , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DE PRODUCTO "+lstrIipoProducto , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrCMB_CUENTA_CARGO))
			{		
				if (objConsultaSaldoMovimientoBE.seleccionarMoneda(lstrMoneda))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+lstrMoneda , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+lstrMoneda , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(ConsultaDietariosBE.GstrCMB_CUENTA_CARGO)){	//Para ingresar a saldos
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaSaldoMovimientoBE.obtenerSaldoByNumeroCuenta(lstrNumeroCuenta)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la opción NUMERO DE CUENTA "+ConsultaDietariosBE.GstrCMB_CUENTA_CARGO);
					TipoLog="1";
				}else{
					TipoLog="0";									
					blnBandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en la opción NUMERO DE CUENTA "+ConsultaDietariosBE.GstrCMB_CUENTA_CARGO);
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
		
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnBandera = false;
		}
		
	}
}
