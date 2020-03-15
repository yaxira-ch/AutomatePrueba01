package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ComercioExtCartaFianzaSolicitudBL extends ComercioExtCartaFianzaGeneralBE {
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ObjetosGenerales objObjetosGenerales=new ObjetosGenerales();
	ComercioExtCartaFianzaGeneralMapeo objComercioExtCartaFianzaSolicitudBE = new ComercioExtCartaFianzaGeneralMapeo();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objFirmarBL =new FirmarBL();
	ConsultaHistoricaBL objConsultaHistoricaBL=new ConsultaHistoricaBL();
	
	public boolean comercioExteriorCartaFianzaSolicitud() throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio;
		String TipoLog = null;
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		
		try {
			
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal("<IGNORE>", GstrTXT_MENU, GstrTXT_SUBMENU);
			
			//---------------------------------------PANTALLA REGISTRO---------------------------------------
			
			objComercioExtCartaFianzaSolicitudBE.verificarCamposObligatoriosSolicitud();
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_EMPRESA)){
	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarEmpresa( GstrCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
					TipoLog="1";
					
				}else{
					TipoLog="0";	
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrCMB_EMPRESA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
        		Thread.sleep(22000);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrRDB_AFIANZAR_TERCERO_SI)){
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objComercioExtCartaFianzaSolicitudBE.ingresoRDBAfianzarSI()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en SI Afianzar a TERCERO");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en SI Afianzar a TERCERO");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrRDB_AFIANZAR_TERCERO_NO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objComercioExtCartaFianzaSolicitudBE.ingresoRDBAfianzarNO()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en NO Afianzar a TERCERO");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en NO Afianzar a TERCERO");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRE_AFIANZADO_TERCERO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarNombreAfianzado( GstrTXT_NOMBRE_AFIANZADO_TERCERO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DEL AFIANZADO TERCERO: "+GstrTXT_NOMBRE_AFIANZADO_TERCERO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DEL AFIANZADO TERCERO: "+GstrTXT_NOMBRE_AFIANZADO_TERCERO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}else{
				ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO=objComercioExtCartaFianzaSolicitudBE.obtenerAfianzado();
				objSQL.actualizarTabla("APP_COMERCIO_EXT_CARTA_FIANZA_D", "TXT_NOMBRE_AFIANZADO", ComercioExtCartaFianzaGeneralBE.GstrTXT_NOMBRE_AFIANZADO, Gstr_ID_CASO);
			}
			
			//TIPO DE VIA
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_DIRECCION_VIA_AFIANZADO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarDireccionViaAfianzado( GstrCMB_DIRECCION_VIA_AFIANZADO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "el tipo de VÍA: "+GstrCMB_DIRECCION_VIA_AFIANZADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "el tipo de VÍA: "+GstrCMB_DIRECCION_VIA_AFIANZADO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//NOMBRE VIA
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_NOMBRE_AFIANZADO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccionNombreAfianzado( GstrTXT_DIRECCION_NOMBRE_AFIANZADO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_NOMBRE_AFIANZADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_NOMBRE_AFIANZADO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_N_MZ_LOTE_AFIANZADO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccion_N_MZ_LOTE_Afianzado( GstrTXT_DIRECCION_N_MZ_LOTE_AFIANZADO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El N°|MZ|LOTE DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_N_MZ_LOTE_AFIANZADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El N°|MZ|LOTE DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_N_MZ_LOTE_AFIANZADO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_INTERIOR_AFIANZADO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccionInteriorAfianzado( GstrTXT_DIRECCION_INTERIOR_AFIANZADO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El INTERIOR DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_INTERIOR_AFIANZADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El INTERIOR DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_INTERIOR_AFIANZADO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//URBANIZACIÓN
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_UBICACION_AFIANZADO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccionUbicacionAfianzado( GstrTXT_DIRECCION_UBICACION_AFIANZADO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La UBICACIÓN DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_UBICACION_AFIANZADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "La UBICACIÓN DE LA DIRECCIÓN DEL AFIANZADO: "+GstrTXT_DIRECCION_UBICACION_AFIANZADO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_DIRECCION_DISTRITO_AFIANZADO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarDireccionDistritoAfianzado( GstrCMB_DIRECCION_DISTRITO_AFIANZADO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "El DISTRITO DE LA DIRECCIÓN DEL AFIANZADO: "+GstrCMB_DIRECCION_DISTRITO_AFIANZADO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "El DISTRITO DE LA DIRECCIÓN DEL AFIANZADO: "+GstrCMB_DIRECCION_DISTRITO_AFIANZADO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			objComercioExtCartaFianzaSolicitudBE.quitarDesplegableDistrito();
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRE_BENEFICIARIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarNombreBeneficiario( GstrTXT_NOMBRE_BENEFICIARIO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DEL BENEFICIARIO: "+GstrTXT_NOMBRE_BENEFICIARIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DEL BENEFICIARIO: "+GstrTXT_NOMBRE_BENEFICIARIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//TIPO DE VIA
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_DIRECCION_VIA_BENEFICIARIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarDireccionViaBeneficiario( GstrCMB_DIRECCION_VIA_BENEFICIARIO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "el tipo de VÍA: "+GstrCMB_DIRECCION_VIA_BENEFICIARIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "el tipo de VÍA: "+GstrCMB_DIRECCION_VIA_BENEFICIARIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			//NOMBRE DE VIA
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_NOMBRE_BENEFICIARIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccionNombreBeneficiario( GstrTXT_DIRECCION_NOMBRE_BENEFICIARIO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_NOMBRE_BENEFICIARIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_NOMBRE_BENEFICIARIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccion_N_MZ_LOTE_Beneficiario( GstrTXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El N°|MZ|LOTE DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El N°|MZ|LOTE DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_N_MZ_LOTE_BENEFICIARIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_INTERIOR_BENEFICIARIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccionInteriorBeneficiario( GstrTXT_DIRECCION_INTERIOR_BENEFICIARIO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El INTERIOR DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_INTERIOR_BENEFICIARIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El INTERIOR DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_INTERIOR_BENEFICIARIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			//URBANIZACIÓN
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_UBICACION_BENEFICIARIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDireccionUbicacionBeneficiario( GstrTXT_DIRECCION_UBICACION_BENEFICIARIO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La UBICACIÓN DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_UBICACION_BENEFICIARIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "La UBICACIÓN DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrTXT_DIRECCION_UBICACION_BENEFICIARIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_DIRECCION_DISTRITO_BENEFICIARIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarDireccionDistritoBeneficiario( GstrCMB_DIRECCION_DISTRITO_BENEFICIARIO))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "El DISTRITO DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrCMB_DIRECCION_DISTRITO_BENEFICIARIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "El DISTRITO DE LA DIRECCIÓN DEL BENEFICIARIO: "+GstrCMB_DIRECCION_DISTRITO_BENEFICIARIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_FECHA_INICIO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			
				if (objComercioExtCartaFianzaSolicitudBE.ingresarFechaInicio( GstrTXT_FECHA_INICIO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "FECHA HASTA "+GstrTXT_FECHA_INICIO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "FECHA DE INICIO "+GstrTXT_FECHA_INICIO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			objComercioExtCartaFianzaSolicitudBE.quitarDesplegableDistrito();
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_PLAZO_DIAS)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.ingresarPlazoDias( GstrTXT_PLAZO_DIAS))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NÚMERO DE DÍAS "+GstrTXT_PLAZO_DIAS , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El NÚMERO DE DÍAS "+GstrTXT_PLAZO_DIAS , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_PLAZO_FECHA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
			
				if (objComercioExtCartaFianzaSolicitudBE.ingresarPlazoFecha( GstrTXT_PLAZO_FECHA))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "FECHA HASTA "+GstrTXT_PLAZO_FECHA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "FECHA HASTA "+GstrTXT_PLAZO_FECHA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			//CAPTURA LA FECHA O NUMERO DE DÍAS AUTOGENERADO
			objComercioExtCartaFianzaSolicitudBE.capturarDatos();
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MONTO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.ingresarMonto( GstrTXT_MONTO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MONTO "+GstrTXT_MONTO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";	
				bandera = false;
				objFuncionesGenerales.callPasosErrado(3, "El MONTO "+GstrTXT_MONTO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}

			if (objFuncionesGenerales.verificarIgnore( GstrCMB_MONEDA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarMoneda( GstrCMB_MONEDA))
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
			
			//DESEO ADJUNTAR UN ARCHIVO (TEXTO ESPECIAL)
			if (objFuncionesGenerales.verificarIgnore( GstrRDB_ADJUNTAR_ARCHIVO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objComercioExtCartaFianzaSolicitudBE.ingresoAdjuntarArchivo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ADJUNTAR ARCHIVO");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ADJUNTAR ARCHIVO");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLINK_ADJUNTAR_ARCHIVO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkAdjuntarArchivo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en LINK ADJUNTAR ARCHIVO");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en LINK ADJUNTAR ARCHIVO");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLINK_ADJUNTAR_ARCHIVO)&& bandera){
				bandera= objComercioExtCartaFianzaSolicitudBE.verificarArchicoAdjunto();
				
				if(bandera){
					
				
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_SELECCIONAR_ARCHIVO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonSeleccionarArchivo(GstrBTN_SELECCIONAR_ARCHIVO)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Seleccionar Archivo");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Seleccionar Archivo");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
		        		
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_GRABAR)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonGrabar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón GRABAR");
							TipoLog="1";
							objComercioExtCartaFianzaSolicitudBE.verificarBotonContinuar();
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón GRABAR");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
		        		//Thread.sleep(1000);
					}
				}
			}

			//DESEO USAR LA PLANTILLA ESTÁNDAR			
			if (objFuncionesGenerales.verificarIgnore( GstrRDB_PLANTILLA_ESTANDAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objComercioExtCartaFianzaSolicitudBE.ingresoUsarPlantillaEstandar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en USAR PLANTILLA ESTANDAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en USAR PLANTILLA ESTANDAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_PLANTILLA_ESTANDAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkPlantillaEstandar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK plantilla estándar");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK plantilla estándar");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    CapturarPantalla.pageDown("-600");
			    objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_PLANTILLA_ESTANDAR)&& bandera){
				bandera= objComercioExtCartaFianzaSolicitudBE.verificarPlantillaEstandar();
				
				if(bandera){
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_CAMBIO_NOMBRE_BENEFICIARIO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonCambioNombreBeneficiario()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Cambio Nombre Beneficiario");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Cambio Nombre Beneficiario");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
		
					if (objFuncionesGenerales.verificarIgnore( GstrTXT_CAMBIO_NOMBRE_BENEFICIARIO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresarNuevoNombreBeneficiario( GstrTXT_CAMBIO_NOMBRE_BENEFICIARIO))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El nuevo nombre del BENEFICIARIO: "+GstrTXT_CAMBIO_NOMBRE_BENEFICIARIO , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El nuevo nombre del BENEFICIARIO: "+GstrTXT_CAMBIO_NOMBRE_BENEFICIARIO , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CAMBIO_NOMBRE_BENEFICIARIO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonAceptarCambioNombreBeneficiario()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Aceptar Cambio Nombre Beneficiario");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Aceptar Cambio Nombre Beneficiario");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_CAMBIO_NOMBRE_AFIANZADO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonCambioNombreAfianzado()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CAMBIO NOMBRE AFIANZADO");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CAMBIO NOMBRE AFIANZADO");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrTXT_CAMBIO_NOMBRE_AFIANZADO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresarNuevoNombreAfianzado( GstrTXT_CAMBIO_NOMBRE_AFIANZADO))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El nuevo nombre del AFIANZADO: "+GstrTXT_CAMBIO_NOMBRE_AFIANZADO , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El nuevo nombre del AFIANZADO: "+GstrTXT_CAMBIO_NOMBRE_AFIANZADO , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CAMBIO_NOMBRE_AFIANZADO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonAceptarCambioNombreAfianzado()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR CAMBIO NOMBRE AFIANZADO");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR CAMBIO NOMBRE AFIANZADO");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_IMPORTE)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonImporte()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón IMPORTE");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón IMPORTE");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrTXT_CAMBIO_MONTO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresarNuevoMonto( GstrTXT_CAMBIO_MONTO))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El nuevo MONTO: "+GstrTXT_CAMBIO_MONTO , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El nuevo MONTO: "+GstrTXT_CAMBIO_MONTO , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
		
					if (objFuncionesGenerales.verificarIgnore( GstrCMB_CAMBIO_MONEDA)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						
						if (objComercioExtCartaFianzaSolicitudBE.seleccionarNuevaMoneda( GstrCMB_CAMBIO_MONEDA))
						{	
							objFuncionesGenerales.callPasosAcierto(2, "de la nueva MONEDA: "+GstrCMB_CAMBIO_MONEDA, "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(2, "de la nueva MONEDA: "+GstrCMB_CAMBIO_MONEDA, "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
		
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CAMBIO_IMPORTE)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonAceptarCambiarImporte()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR cambiar importe");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR cambiar importe");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrTXT_OBLIGACIONES_GARANTIZADAS)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresarObligacionesGarantizadas( GstrTXT_OBLIGACIONES_GARANTIZADAS))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "Las OBLIGACIONES GARANTIZADAS: "+GstrTXT_OBLIGACIONES_GARANTIZADAS , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "Las OBLIGACIONES GARANTIZADAS: "+GstrTXT_OBLIGACIONES_GARANTIZADAS , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
								
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_PLAZO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonPlazo()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón PLAZO");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón PLAZO");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrTXT_CAMBIO_PLAZO_DIAS)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresarNuevoPlazoDias( GstrTXT_CAMBIO_PLAZO_DIAS))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El nuevo PLAZO en días: "+GstrTXT_CAMBIO_PLAZO_DIAS , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El nuevo PLAZO en días: "+GstrTXT_CAMBIO_PLAZO_DIAS , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
		    			Thread.sleep(1000);
		    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrTXT_CAMBIO_PLAZO_FECHA)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
						if (objComercioExtCartaFianzaSolicitudBE.ingresarNuevoPlazoFechas( GstrTXT_CAMBIO_PLAZO_FECHA))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El nuevo PLAZO en FECHAS: "+GstrTXT_CAMBIO_PLAZO_FECHA , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";	
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El nuevo PLAZO en FECHAS: "+GstrTXT_CAMBIO_PLAZO_FECHA , "" ,  "");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
		    			Thread.sleep(1000);
		    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
								
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_ACEPTAR_CAMBIO_PLAZO)){	
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonAceptarCambioPlazo()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR de cambio de plazo");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR de cambio de plazo");
						}
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
					}
					
					if (objFuncionesGenerales.verificarIgnore( GstrBTN_GUARDAR)){	
						
						LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
									
						if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonGuardar()){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón GUARDAR");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón GUARDAR");
						}
						CapturarPantalla.pageDown("-500");
						LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
		    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
					    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
		        		Thread.sleep(1000);
					}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCHK_FIRMA_AUTOGRAFA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoChkFirmaAutografa()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check Firma Autografa");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check Firma Autografa");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRE_PERSONA_RESPONSABLE_CARTA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objComercioExtCartaFianzaSolicitudBE.ingresarNombrePersonaResponsable(GstrTXT_NOMBRE_PERSONA_RESPONSABLE_CARTA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La INFORMACION DEL CONTACTO ", GstrTXT_NOMBRE_PERSONA_RESPONSABLE_CARTA,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La INFORMACION DEL CONTACTO ", GstrTXT_NOMBRE_PERSONA_RESPONSABLE_CARTA,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarTipoDocumento( GstrCMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA "+GstrCMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA "+GstrCMB_TIPO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objComercioExtCartaFianzaSolicitudBE.ingresarNroDocumento(GstrTXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La INFORMACION DEL CONTACTO ", GstrTXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La INFORMACION DEL CONTACTO ", GstrTXT_NRO_DOCUMENTO_PERSONA_RESPONSABLE_CARTA,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO_CONTACTO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objComercioExtCartaFianzaSolicitudBE.ingresarCorreoContacto(GstrTXT_CORREO_CONTACTO)){	
					objFuncionesGenerales.callPasosAcierto(3, "La INFORMACION DEL CONTACTO ", GstrTXT_CORREO_CONTACTO,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La INFORMACION DEL CONTACTO ", GstrTXT_CORREO_CONTACTO,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}			

			
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONTINUAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
							
				if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonContinuar1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
    			CapturarPantalla.pageDown("-600");
    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
						
			
			
			
			//---------------------------------------PANTALLA ENVÍO---------------------------------------
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_VER_DESCRIPCION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkVerDescripcion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Ver Descripción");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Ver Descripción");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    CapturarPantalla.pageDown("-600");
			    objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCHK_ACEPTAR_TERMINOS)&&!esOperador()){
				
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoChkAceptarTerminos()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el CHK Aceptar Terminos");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el CHK Aceptar Terminos");
				}
				CapturarPantalla.pageDown("-600");
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_CONTRATO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkContrato()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Contrato");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Contrato");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_CARTILLA_INFORMACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkCartillaInformacion()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Cartilla de Información");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Cartilla de Información");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			if( GstrTXT_CLAVE.equals("SI")){
				if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Clave)){	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
					if (objComercioExtCartaFianzaSolicitudBE.ingresoClave(Mdl_Variables.Gstr_Clave)){	
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
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CLAVE_DINAMICA)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objComercioExtCartaFianzaSolicitudBE.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CLAVE DINAMICA ", GstrTXT_CLAVE_DINAMICA,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La CLAVE DINAMICA ", GstrTXT_CLAVE_DINAMICA,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_QUIERES_SABER_COMO)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkQuieresSaberComo()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link Quieres Saber Como");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link Quieres Saber Como");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CONFIRMAR)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonConfirmar()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_CANCELAR_OPERACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonCancelarOperacion()){	
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
			
			//---------------------------------------PANTALLA CONFIRMACIÓN---------------------------------------
			
			objComercioExtCartaFianzaSolicitudBE.verificarResultadoEsperadoCartaFianza();
			
			if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
				
				if (objComercioExtCartaFianzaSolicitudBE.compararResultadoEsperado(GstrRESULTADO_ESPERADO))
				{	
					objFuncionesGenerales.callPasosAcierto(5, "Resultado Esperado", "Resultado Obtenido" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(5, "Resultado Esperado", "Resultado Obtenido" ,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
    		}
			
			
			
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_VER_DESCRIPCION_FINAL)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLnkVerDescripcionFinal()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Ver descripción de la Carta Fianza");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Ver descripción de la Carta Fianza");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_ENVIAR_EMAIL)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkEnviarEmail()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CORREO))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objComercioExtCartaFianzaSolicitudBE.ingresarCorreoFinalProcesada( GstrTXT_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El Correo "+ GstrTXT_CORREO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_CORREO))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  	
				if (objComercioExtCartaFianzaSolicitudBE.ingresarMensajeCorreoFinalProcesada( GstrTXT_MENSAJE_CORREO))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El MENSAJE del correo "+ GstrTXT_MENSAJE_CORREO , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_ENVIAR_CORREO))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoBotonEnviarFinalProcesada()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón ENVIAR");
					TipoLog="1";
					Thread.sleep(1000);
					objComercioExtCartaFianzaSolicitudBE.ingresoBotonAceptarEnviarFinalProcesada();
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_EXPORTAR_EXCEL)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkExportarExcel()){	
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
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkExportarPDF()){	
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
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkImprimir()){	
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
				if (objComercioExtCartaFianzaSolicitudBE.compararResultadoEsperadoPositivo()){	
					objComercioExtCartaFianzaSolicitudBE.GuardarDatosOperacionAutorizar();
					if(GstrFIRMAR.equals("NO") && GstrESTADO.equals("Procesada")){
						bandera=objConsultaHistoricaBL.consultaHistorico("Carta Fianza",GstrCMB_EMPRESA,"",1,GstrESTADO,"",ComercioExtCartaFianzaGeneralBE.Gstr_ID_CASO);//1 cuadno se hace desde el mismo modulo;2 cuando se hace desde auorixaciones
					}
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkAgregarOperacionesFrecuentes()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el LINK Agregar a mis operaciones frecuentes");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el LINK Agregar a mis operaciones frecuentes");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DESCRIPCION_OF)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresarDescripcionOF(GstrTXT_DESCRIPCION_OF)){	
					objFuncionesGenerales.callPasosAcierto(3, " Descripción de OF ", GstrTXT_DESCRIPCION_OF,"");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, " Descripción de OF ", GstrTXT_DESCRIPCION_OF,"");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoContinuarOperacionesFrecuentes()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón continuar de mis operaciones frecuentes");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón continuar de mis operaciones frecuentes");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.verificarResultado()){	
					objFuncionesGenerales.callPasosAcierto(6, " Tu operación ha sido enviada", "" ,"");
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(6, " Tu operación ha sido enviada", "" ,"");;
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkCrearNuevaSolicitud()){	
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"en el LINK Crear Nueva Solicitud");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1,"", "" ,"en el LINK Crear Nueva Solicitud");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkVerMisOperacionesFrecuentes()){	
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"en el LINK Ver mis operaciones frecuentes");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1,"", "" ,"en el LINK Ver mis operaciones frecuentes");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.seleccionarOF()){	
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"en la operación frecuente a usar");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1,"", "" ,"en la operación frecuente a usar");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoAceptarOF()){	
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"en el Botón Aceptar de mis operaciones frecuentes");
					TipoLog="1";
					Thread.sleep(1000);
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1,"", "" ,"en el Botón Aceptar de mis operaciones frecuentes");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_REALIZAR_OTRA_OPERACION)){	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objComercioExtCartaFianzaSolicitudBE.ingresoLinkRealizarOtraOperacion()){	
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
			
			if (objFuncionesGenerales.verificarIgnore( GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion( GstrLNK_CERRAR_SESION, GstrLNK_CERRAR_SESION);
			}
			
			
			
			//---------------------------------------FLUJO DE FIRMAS---------------------------------------
			
			if (bandera && GstrFIRMAR.equals("SI")){

				if(GstrOPERADOR.equals("<IGNORE>")){
					if (!GstrFIRMANTE3.equals("<IGNORE>")){
						consultar3=true;
					}else if (!GstrFIRMANTE2.equals("<IGNORE>")){
						consultar2=true;
					}else{
						if (!GstrFIRMANTE1.equals("<IGNORE>")){
							consultar1=true;
						}
					}
				}					
					
						String tabla_Autorizar_Plantilla="APP_COMERCIO_EXT_CARTA_FIANZA_AUTORIZAR_D";
						String tabla_Autorizar_Portabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
						String tabla_Autorizar_autorizacion="APP_AND_AUTORIZACIONES_PENDIENTES_D";
						
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1))	{
							if (GstrFIRMANTE1.equals("PA") || GstrFIRMANTE1.equals("PA-B") ){
								bandera=objFirmarBL.cartaFianza(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F1",consultar1);
							}else if (GstrFIRMANTE1.equals("PORT") || GstrFIRMANTE1.equals("PORT-B") ){
								bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F1' AND TIPO_CARTA_FIANZA='Carta Fianza",consultar1,null,null,null);
							}else{
								bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F1","Carta Fianza",consultar1);
							}
						}
						
						if(bandera){
							if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2))
							{
								if (GstrFIRMANTE2.equals("PA") || GstrFIRMANTE2.equals("PA-B")){
									bandera=objFirmarBL.cartaFianza(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F2",consultar2);
								}else if (GstrFIRMANTE2.equals("PORT") || GstrFIRMANTE2.equals("PORT-B") ){
									bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F2' AND TIPO_CARTA_FIANZA='Carta Fianza",consultar2,null,null,null);
								}else{
									bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F2","Carta Fianza",consultar2);
								}
							}
							
							if(bandera){
								if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3))
								{
									if (GstrFIRMANTE3.equals("PA") || GstrFIRMANTE3.equals("PA-B")){
										bandera=objFirmarBL.cartaFianza(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"F3",consultar3);
									}else if (GstrFIRMANTE3.equals("PORT") || GstrFIRMANTE3.equals("PORT-B") ){
										bandera=objFirmarBL.firmaAutorizacionesPortabilidad(tabla_Autorizar_Portabilidad,Gstr_ID_CASO,"F3' AND TIPO_CARTA_FIANZA='Carta Fianza",consultar3,null,null,null);
									}else{
										bandera=objFirmarBL.firmaAutorizaciones(tabla_Autorizar_autorizacion,Gstr_ID_CASO,"F3","Carta Fianza",consultar3);
									}
								}
								
								if(bandera){
									if(objFuncionesGenerales.verificarIgnore(GstrOPERADOR)){
										if (GstrOPERADOR.equals("PA") ){
											bandera=objFirmarBL.cartaFianza(tabla_Autorizar_Plantilla,Gstr_ID_CASO,"OP",true);
										}
									}
								}

							}
						}
			
				
			}	
			
		} catch (Exception e) {
			bandera=false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));  
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
        	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
	
		}
		return bandera;
	}

	private boolean esOperador() {
		// TODO Auto-generated method stub
		String tipo=objSQL.obtenerTipoUsuario(Gstr_ID_CASO_LOGIN);
		if(tipo.equals("OP"))
			return true;
		else
			return false;
		
	}
}