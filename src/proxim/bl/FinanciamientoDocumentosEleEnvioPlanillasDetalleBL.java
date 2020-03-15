package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.FinanciamientoDocumentosEleEnvioPlanillasDetalleBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class FinanciamientoDocumentosEleEnvioPlanillasDetalleBL extends FinanciamientoDocumentosEleEnvioPlanillasDetalleBE {

	private static String TipoLog = null;
	PagosRecibosDetalleMapeo objDetallePagoRegistroBE=new PagosRecibosDetalleMapeo()	;
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionBL objConexionBL = new ConexionBL();
	FinanciamientoDocumentosEleEnvioPlanillasMapeo objFinanciamientoDocEleEnvioPlanillasBE= new FinanciamientoDocumentosEleEnvioPlanillasMapeo();
	FinanciamientoDocumentosEleEnvioPlanillasDetalleBE objFinanDocumentosEleEnvioPlanillasDetalleBL = new FinanciamientoDocumentosEleEnvioPlanillasDetalleBE();
	
	public boolean FinanciamientoEnvioPlanillasDocElecEnvioPlanillas(int numero,int indice) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;	 
		
		try {
			if(numero==1){
				objFinanciamientoDocEleEnvioPlanillasBE.verificarDesplegarCampos();
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_PROVEDOR_AFILIADO))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objFinanciamientoDocEleEnvioPlanillasBE.seleccionarProveedorAfiliado(GstrCMB_PROVEDOR_AFILIADO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "del PROVEEDOR AFILIADO "+GstrCMB_PROVEDOR_AFILIADO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "del PROVEEDOR AFILIADO "+GstrCMB_PROVEDOR_AFILIADO , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_DOCUMENTO))
				{		
					LStr_HoraInicio = System.currentTimeMillis();	 
					if (objFinanciamientoDocEleEnvioPlanillasBE.seleccionarTipoDocumento(GstrCMB_TIPO_DOCUMENTO))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "del TIPO DE DOCUMENTO "+GstrCMB_TIPO_DOCUMENTO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "del TIPO DE DOCUMENTO "+GstrCMB_TIPO_DOCUMENTO , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_DOCUMENTOS))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	  	
					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresarNumeroDocumentos(GstrTXT_NUMERO_DOCUMENTOS))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "La descripción "+GstrTXT_NUMERO_DOCUMENTOS , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La descripción "+GstrTXT_NUMERO_DOCUMENTOS , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	    
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_AGREGAR))
				{	
					LStr_HoraInicio = System.currentTimeMillis();	  	
					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresoBotonAgregar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ," en el Boton AGREGAR");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ," en el Boton AGREGAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	    
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				//--------------------detalle del detalle
				
				objFinanciamientoDocEleEnvioPlanillasBE.verificarTablaDetalle();
				objSQL.listaTablaIdCaso(" SELECT  ID_CASO, ID_CASO_LOTE, BTN_ELIMINAR,BTN_SI_ELIMINAR, BTN_NO_ELIMINAR, LBL_EMPRESA, LBL_NOMBRE_PROVEEDOR, LBL_DOC_PROVEEDOR, LBL_TIPO_DOCUMENTO,TXT_NUMERO_DOCUMENTO, TXT_MONTO, TXT_FECHA_VENCIMIENTO, TXT_FECHA_CARGO, TXT_FECHA_ADELANTO, LBL_OBSERVACION FROM APP_FINANCIAMIENTO_DOCELC_ENVPLANILLAS_DETALLE WHERE  ID_CASO_LOTE="+Mdl_Variables.Gint_IdCaso+" and CMB_PROVEDOR_AFILIADO='"+GstrCMB_PROVEDOR_AFILIADO+"' and CMB_TIPO_DOCUMENTO='"+GstrCMB_TIPO_DOCUMENTO+"' and TXT_NUMERO_DOCUMENTOS="+GstrTXT_NUMERO_DOCUMENTOS,"",6);//Captura todos los valores del detalle del caso
				int numeroDetalle=0;
				while (Mdl_Variables.Grst_Firmante.next()==true) {
					numeroDetalle=numeroDetalle+1;
					bandera = objFinanDocumentosEleEnvioPlanillasDetalleBL.FinanDocumentosEleEnvioPlanillasDetalle(Mdl_Variables.Grst_Firmante,2);
	    			
					if(bandera){
	    				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ELIMINAR)){	
	    					LStr_HoraInicio = System.currentTimeMillis();	
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresoBotonEliminar(indice)){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ELIMINAR");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ELIMINAR");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
	    		
	    				if (objFuncionesGenerales.verificarIgnore(GstrBTN_SI_ELIMINAR)){	
	    					LStr_HoraInicio = System.currentTimeMillis();	
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresoBotonEliminarSI()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrBTN_NO_ELIMINAR)){	
	    					LStr_HoraInicio = System.currentTimeMillis();	
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresoBotonEliminarNO()){	
	    						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_DOCUMENTO))
	    				{	
	    					LStr_HoraInicio = System.currentTimeMillis();	  	
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresarNumeroDocumento(GstrTXT_NUMERO_DOCUMENTO,indice))
	    					{	
	    						objFuncionesGenerales.callPasosAcierto(3, "El NÚMERO DE DOCUMENTO "+GstrTXT_NUMERO_DOCUMENTO , "" ,  "");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "El NÚMERO DE DOCUMENTO "+GstrTXT_NUMERO_DOCUMENTO , "" ,  "");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
	    				
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO))
	    				{		
	    					LStr_HoraInicio = System.currentTimeMillis();
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.seleccionarMonto(GstrTXT_MONTO,indice))
	    					{	
	    						objFuncionesGenerales.callPasosAcierto(3, "del MONTO: "+GstrTXT_MONTO , "" ,  "");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";		
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "del MONTO: "+GstrTXT_MONTO , "" ,  "");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_VENCIMIENTO))
	    				{	
	    					LStr_HoraInicio = System.currentTimeMillis();	  	
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresarFechaVencimiento(GstrTXT_FECHA_VENCIMIENTO,indice))
	    					{	
	    						objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE VENCIMIENTO: "+GstrTXT_FECHA_VENCIMIENTO , "" ,  "");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "La FECHA DE VENCIMIENTO: "+GstrTXT_FECHA_VENCIMIENTO , "" ,  "");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_CARGO))
	    				{	
	    					LStr_HoraInicio = System.currentTimeMillis();	  	
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresarFechaCargo(GstrTXT_FECHA_CARGO,indice))
	    					{	
	    						objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE CARGO: "+GstrTXT_FECHA_CARGO , "" ,  "");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "La FECHA DE CARGO: "+GstrTXT_FECHA_CARGO , "" ,  "");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
	    				
	    				if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_ADELANTO))
	    				{	
	    					LStr_HoraInicio = System.currentTimeMillis();	  	
	    					if (objFinanciamientoDocEleEnvioPlanillasBE.ingresarFechaAdelanto(GstrTXT_FECHA_ADELANTO,indice))
	    					{	
	    						objFuncionesGenerales.callPasosAcierto(3, "La FECHA DE ADELANTO: "+GstrTXT_FECHA_ADELANTO , "" ,  "");
	    						TipoLog="1";
	    					}else{
	    						TipoLog="0";			
	    						bandera = false;
	    						objFuncionesGenerales.callPasosErrado(3, "La FECHA DE ADELANTO: "+GstrTXT_FECHA_ADELANTO , "" ,  "");
	    					}
	    					LStr_HoraFin = System.currentTimeMillis();	  
	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
	    				}
					}
				}
				
				
			
			}
		}catch (Exception e) {
			bandera =false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
	}

