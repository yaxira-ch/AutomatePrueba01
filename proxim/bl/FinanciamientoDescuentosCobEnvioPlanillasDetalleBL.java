package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasDetalleBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDescuentosCobEnvioPlanillasDetalleBL extends FinanciamientoDescuentosCobEnvioPlanillasDetalleBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	FinanciamientoDescuentosCobEnvioPlanillasAutorizarMapeo objFinanciamientoDescuentosCobEnvioPlanillas = new FinanciamientoDescuentosCobEnvioPlanillasAutorizarMapeo();
	FinanciamientoDescuentosCobEnvioPlanillasDetalleBE objFinanDescuentosCobEnvioPlanillasDetalle=new FinanciamientoDescuentosCobEnvioPlanillasDetalleBE();
	private static String TipoLog = null;
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	
	public boolean FinanciamientoDescuentosCobEnvioPlanillasDetalle() throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	
		String strCadena = "S/.";
		String strTexto; 
		try {
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_TIPO_DOCUMENTO_ACEPTANTE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarTipoDocumentoAceptante( GstrCMB_TIPO_DOCUMENTO_ACEPTANTE))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DOCUMENTO "+ GstrCMB_TIPO_DOCUMENTO_ACEPTANTE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del TIPO DOCUMENTO "+  GstrCMB_TIPO_DOCUMENTO_ACEPTANTE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NRO_DOCUMENTO_ACEPTANTE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarNroDocumentoAceptante( GstrTXT_NRO_DOCUMENTO_ACEPTANTE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NRO DOCUMENTO "+ GstrTXT_NRO_DOCUMENTO_ACEPTANTE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El NRO DOCUMENTO "+  GstrTXT_NRO_DOCUMENTO_ACEPTANTE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRE_ACEPTANTE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarNombreAceptante( GstrTXT_NOMBRE_ACEPTANTE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE "+ GstrTXT_NOMBRE_ACEPTANTE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El NOMBRE "+  GstrTXT_NOMBRE_ACEPTANTE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_APEPAT_ACEPTANTE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarApePatAceptante( GstrTXT_APEPAT_ACEPTANTE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El APELLIDO PATERNO "+ GstrTXT_APEPAT_ACEPTANTE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El APELLIDO PATERNO "+  GstrTXT_APEPAT_ACEPTANTE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_APEMAT_ACEPTANTE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarApeMatAceptante( GstrTXT_APEMAT_ACEPTANTE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El APELLIDO MATERNO "+ GstrTXT_APEMAT_ACEPTANTE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El APELLIDO MATERNO "+  GstrTXT_APEMAT_ACEPTANTE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_ACEPTANTE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarDireccionAceptante( GstrTXT_DIRECCION_ACEPTANTE))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La DIRECCION "+ GstrTXT_DIRECCION_ACEPTANTE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La DIRECCION "+  GstrTXT_DIRECCION_ACEPTANTE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_UBIGEO_ACEPTANTE))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.seleccionarUbigeo( GstrCMB_UBIGEO_ACEPTANTE))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del UBIGEO "+ GstrCMB_UBIGEO_ACEPTANTE , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del UBIGEO "+  GstrCMB_UBIGEO_ACEPTANTE , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NUMERO_DOCUMENTOS))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarNumeroDocumentos( GstrTXT_NUMERO_DOCUMENTOS))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "El NUMERO DE DOCUMENTOS "+ GstrTXT_NUMERO_DOCUMENTOS , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "El NUMERO DE DOCUMENTOS "+  GstrTXT_NUMERO_DOCUMENTOS , "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore( GstrBTN_AGREGAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoBotonAgregarAceptante()){	
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
			
//			if (objFuncionesGenerales.verificarIgnore( GstrTXT_COLUMNA_ERROR) && objFuncionesGenerales.verificarIgnore( GstrTXT_MENSAJE_ERROR))
//			{	
//				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
//				String strMensajeFront =  objFinanciamientoDescuentosCobEnvioPlanillas.obtenerMensajeFront( GstrTXT_COLUMNA_ERROR,2);
//				objFuncionesGenerales.callPasosAcierto(4, strMensajeFront, "" ,"");
//				if (strMensajeFront.compareTo("<IGNORE>")!=0)
//				{
//					if (objFuncionesGenerales.compararTexto(strMensajeFront, GstrTXT_MENSAJE_ERROR))
//					{
//						objFuncionesGenerales.callPasosAcierto(5, strMensajeFront,  GstrTXT_MENSAJE_ERROR ,"");
//						TipoLog="1";
//		    		}else{
//		    			TipoLog="0";									
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(5, strMensajeFront,  GstrTXT_MENSAJE_ERROR ,"");
//		    		}	
//				}
//			}
			
			//------------------------------------------------------LLENAR EL DETALLE DE LAS TABLAS-----------------------------------
			
			//--------------------detalle del detalle
			
			objFinanciamientoDescuentosCobEnvioPlanillas.verificarCabecera();
			//CASO1
			strTexto = objFinanciamientoDescuentosCobEnvioPlanillas.buscarCadenaTabla(strCadena,"MontoPlanilla");
			if(!strTexto.equals(""))
			{	
				objFuncionesGenerales.callPasosAcierto(7, "INCORRECTO, Símbolo en el Monto Grilla envío: "+strTexto, "" ,"");
				objFuncionesGenerales.insertarTablaErrorReporte(Mdl_Variables.Gstr_Tabla, String.valueOf(Mdl_Variables.Gint_IdCaso), Mdl_Variables.Gstr_Corrida , Mdl_Variables.Gstr_NombreVersion, Mdl_Variables.Gstr_RutaAplicativo ,"Símbolo en el Monto Grilla envío", strCadena, strTexto);
			}else						{
				objFuncionesGenerales.callPasosAcierto(7, "CORRECTO, Símbolo en el Monto Grilla envío: ", "" ,"");
			}
			
			objSQL.listaTablaIdCaso("SELECT ID_CASO,NUM, ID_CASO_LOTE, BTN_ELIMINAR,BTN_SI_ELIMINAR, BTN_NO_ELIMINAR, LBN_EMPRESA,LBN_NOMBRE_ACEPTANTE, LBN_DOCUMENTO_ACEPTANTE,TXT_NRO_DOCUMENTO,TXT_MONTO, TXT_MONTO,TXT_FECHA_VENCIMIENTO,  TXT_OBSERVACION  FROM APP_FINANCIAMIENTO_DESCOB_ENVPLANILLAS_DETALLE_D WHERE  ID_CASO_LOTE="+Mdl_Variables.Gint_IdCaso+" and CMB_TIPO_DOCUMENTO_ACEPTANTE='"+GstrCMB_TIPO_DOCUMENTO_ACEPTANTE+"' and TXT_NRO_DOCUMENTO_ACEPTANTE='"+GstrTXT_NRO_DOCUMENTO_ACEPTANTE+"' and TXT_NOMBRE_ACEPTANTE='"+GstrTXT_NOMBRE_ACEPTANTE+"'","",6);//detalle del detalle
			
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				
				bandera = objFinanDescuentosCobEnvioPlanillasDetalle.FinanDescuentosCobEnvioPlanillasDetalle(Mdl_Variables.Grst_Firmante,2);
    			
				if(bandera){
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_DOCUMENTO))
	    			{	
	    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
	    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarNroDocumento(GstrTXT_NUMERO_DOCUMENTO, GstrNUM))
	    				{	
	    					objFuncionesGenerales.callPasosAcierto(3, "El N° DOCUMENTO"+ GstrTXT_NUMERO_DOCUMENTO , "" ,  "");
	    					TipoLog="1";
	    				}else{
	    					TipoLog="0";			
	    					bandera = false;
	    					objFuncionesGenerales.callPasosErrado(3, "El N° DOCUMENTO "+ GstrTXT_NUMERO_DOCUMENTO , "" ,  "");
	    				}
	    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
	    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
	    			}
    				
    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO))
	    			{	
	    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
	    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarMonto(GstrTXT_MONTO, GstrNUM))
	    				{	
	    					objFuncionesGenerales.callPasosAcierto(3, "El MONTO "+ GstrTXT_MONTO , "" ,  "");
	    					TipoLog="1";
	    				}else{
	    					TipoLog="0";			
	    					bandera = false;
	    					objFuncionesGenerales.callPasosErrado(3, "El MONTO "+ GstrTXT_MONTO , "" ,  "");
	    				}
	    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
	    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
	    			}
    				
    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_VENCIMIENTO))
	    			{	
	    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
	    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarFechaVencimiento(GstrTXT_FECHA_VENCIMIENTO, GstrNUM))
	    				{	
	    					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE VENCIMIENTO "+ GstrTXT_FECHA_VENCIMIENTO , "" ,  "");
	    					TipoLog="1";
	    				}else{
	    					TipoLog="0";			
	    					bandera = false;
	    					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE VENCIMIENTO "+ GstrTXT_FECHA_VENCIMIENTO , "" ,  "");
	    				}
	    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
	    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
	    			}
    				
    				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ELIMINAR))
	    			{	
	    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
	    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoEliminarDetalle(GstrNUM))
	    				{	
	    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ELIMINAR del detalle ");
	    					TipoLog="1";
	    				}else{
	    					TipoLog="0";									
	    					bandera = false;
	    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ELIMINAR del detalle ");
	    				}
	    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
	    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
	    			}
				}
			}
			
//	    	
//	    	String strCondicion = " isnull(TXT_MENSAJE_ERROR,'') = '' ";
//			objSQL.listaTablaQuery("*", "APP_AND_FINANCIAMIENTO_DES_ENVPLANILLAS_DET_D", "ID_CASO", GstrID_CASO + " AND " +strCondicion,"","ID_CASO", 2);
//			boolean btnCrearPlanilla = false;
//			int row = 0;
//	    	while (Mdl_Variables.Grst_TablaDetalle2.next()==true) 
//	    	{	
//	    		if (objFuncionesGenerales.verificarIgnore(GstrBTN_CREAR_PLANILLA))
//	    		{
//	    			btnCrearPlanilla = true;
//	    		}
//
//	    		if(FinanDescuentosCobEnvioPlanillasDetalle(Mdl_Variables.Grst_TablaDetalle2, 2))
//	    		{
//	    			row++;	
//	    			boolean bRegistroCorrecto = false;
//	    			if (!objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR))
//	    			{	
//	    				String strGetNroDocTabla= objFinanciamientoDescuentosCobEnvioPlanillas.obtenerNroDocumentoAceptanteTabla(row);
//		    			objFuncionesGenerales.callPasosAcierto(4, strGetNroDocTabla, "" ,"");
//		    			String strTipoNroDoc = GstrCMB_TIPO_DOCUMENTO_ACEPTANTE + " " + GstrTXT_NRO_DOCUMENTO_ACEPTANTE;
//	    				if (objFuncionesGenerales.compararTexto(strGetNroDocTabla,strTipoNroDoc))
//	    				{	bRegistroCorrecto = true;
//	    					objFuncionesGenerales.callPasosAcierto(5, strGetNroDocTabla,strTipoNroDoc ,"");
//	    					TipoLog="1";
//	    	    		}else{
//	    	    			TipoLog="0";									
//	    					bandera = false;
//	    					objFuncionesGenerales.callPasosErrado(5, strGetNroDocTabla,strTipoNroDoc ,"");
//	    	    		}
//	    				
//	    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//	    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//	    			}
//	    			if(bRegistroCorrecto)
//	    			{
//	    				
//	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_NRO_DOCUMENTO))
//		    			{	
//		    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
//		    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarNroDocumento(GstrTXT_NRO_DOCUMENTO, row))
//		    				{	
//		    					objFuncionesGenerales.callPasosAcierto(3, "El N° DOCUMENTO"+ GstrTXT_NRO_DOCUMENTO , "" ,  "");
//		    					TipoLog="1";
//		    				}else{
//		    					TipoLog="0";			
//		    					bandera = false;
//		    					objFuncionesGenerales.callPasosErrado(3, "El N° DOCUMENTO "+ GstrTXT_NRO_DOCUMENTO , "" ,  "");
//		    				}
//		    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//		        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//		    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//		    			}
//	    				
//	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO))
//		    			{	
//		    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
//		    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarMonto(GstrTXT_MONTO, row))
//		    				{	
//		    					objFuncionesGenerales.callPasosAcierto(3, "El MONTO "+ GstrTXT_MONTO , "" ,  "");
//		    					TipoLog="1";
//		    				}else{
//		    					TipoLog="0";			
//		    					bandera = false;
//		    					objFuncionesGenerales.callPasosErrado(3, "El MONTO "+ GstrTXT_MONTO , "" ,  "");
//		    				}
//		    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//		        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//		    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//		    			}
//	    				
//	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_VENCIMIENTO))
//		    			{	
//		    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
//		    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresarFechaVencimiento(GstrTXT_FECHA_VENCIMIENTO, row))
//		    				{	
//		    					objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE VENCIMIENTO "+ GstrTXT_FECHA_VENCIMIENTO , "" ,  "");
//		    					TipoLog="1";
//		    				}else{
//		    					TipoLog="0";			
//		    					bandera = false;
//		    					objFuncionesGenerales.callPasosErrado(3, "La FECHA DE VENCIMIENTO "+ GstrTXT_FECHA_VENCIMIENTO , "" ,  "");
//		    				}
//		    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//		        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//		    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//		    			}
//	    				
//	    				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ELIMINAR))
//		    			{	
//		    				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
//		    				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoEliminarDetalle(row))
//		    				{	
//		    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ELIMINAR del detalle ");
//		    					TipoLog="1";
//		    				}else{
//		    					TipoLog="0";									
//		    					bandera = false;
//		    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ELIMINAR del detalle ");
//		    				}
//		    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//		        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//		    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//		    			}
//	    			}
//	    		}
//	    	}
//	    	Mdl_Variables.Grst_TablaDetalle2.close();
//	    	Mdl_Variables.Grst_TablaDetalle2 = null;
//			//----------------------------------------termina datos tabla detalle-----------
//	    	
//	    	//-----------------------------CREAR PLANILLA y VALIDAR OBSERVACIONES   ---------
//	    	boolean bExisteObservaciones = false;
//	    	if (btnCrearPlanilla)
//	    	{
//				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//				if (objFinanciamientoDescuentosCobEnvioPlanillas.ingresoCrearPlanilla()){	
//					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CREAR PLANILLA");
//					TipoLog="1";
//				}else{
//					TipoLog="0";									
//					bandera = false;
//					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CREAR PLANILLA");
//				}
//				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//	    	}
//
//	    	int row2 = 0;
//			objSQL.listaTablaQuery("*", "APP_AND_FINANCIAMIENTO_DES_ENVPLANILLAS_DET_D", "ID_CASO", GstrID_CASO + " AND " +strCondicion,"","ID_CASO", 2);
//	    	while (Mdl_Variables.Grst_TablaDetalle2.next()==true) 
//	    	{	
//	    		
//	    		if(FinanDescuentosCobEnvioPlanillasDetalle(Mdl_Variables.Grst_TablaDetalle2, 2))
//	    		{
//	    			row2++;	
//	    			boolean bRegistroCorrecto = false;
//	    			if (!objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR))
//	    			{	
//	    				String strGetNroDocTabla= objFinanciamientoDescuentosCobEnvioPlanillas.obtenerNroDocumentoAceptanteTabla(row2);
//		    			objFuncionesGenerales.callPasosAcierto(4, strGetNroDocTabla, "" ,"");
//		    			String strTipoNroDoc = GstrCMB_TIPO_DOCUMENTO_ACEPTANTE + " " + GstrTXT_NRO_DOCUMENTO_ACEPTANTE;
//	    				if (objFuncionesGenerales.compararTexto(strGetNroDocTabla,strTipoNroDoc))
//	    				{	bRegistroCorrecto = true;
//	    					objFuncionesGenerales.callPasosAcierto(5, strGetNroDocTabla,strTipoNroDoc ,"");
//	    					TipoLog="1";
//	    	    		}else{
//	    	    			TipoLog="0";									
//	    					bandera = false;
//	    					objFuncionesGenerales.callPasosErrado(5, strGetNroDocTabla,strTipoNroDoc ,"");
//	    	    		}
//	    				
//	    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//	        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//	    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//	    			}
//	    			if(bRegistroCorrecto)
//	    			{
//	    				
//	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_OBSERVACION))
//		    			{	bExisteObservaciones = true;
//		    				String strTexto= objFinanciamientoDescuentosCobEnvioPlanillas.obtenerObservacion(row);
//		    				if (objFuncionesGenerales.compararTexto(GstrTXT_OBSERVACION,strTexto))
//		    				{	bRegistroCorrecto = true;
//		    					objFuncionesGenerales.callPasosAcierto(5, GstrTXT_OBSERVACION,strTexto ,"");
//		    					TipoLog="1";
//		    	    		}else{
//		    	    			TipoLog="0";									
//		    					bandera = false;
//		    					objFuncionesGenerales.callPasosErrado(5, GstrTXT_OBSERVACION,strTexto ,"");
//		    	    		}
//		    				
//		    				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
//		        			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
//		    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
//		    			}
//	    			}
//	    		}
//	    	}
//	    	Mdl_Variables.Grst_TablaDetalle2.close();
//	    	Mdl_Variables.Grst_TablaDetalle2 = null;
//			//----------------------------------------termina recorrer mensajes de OBSERVACION-----------
//	    	
//	    	//---------------------------SELECCIONAR REGISTRO A ENVIAR--------------------
//	    	if(!bExisteObservaciones)
//	    	{
//	    		Thread.sleep(5000);
//	    	}
//			//------------------------------------------------------------------------------------------------------------------------
//			
			
			
		} catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}
}
