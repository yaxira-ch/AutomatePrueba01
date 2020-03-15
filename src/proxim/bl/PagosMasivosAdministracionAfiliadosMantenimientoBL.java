package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.*;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosMasivosAdministracionAfiliadosMantenimientoBL  extends PagosMasivosAdministracionAfiliadosBE{
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PagosMasivosAdministracionAfiliadosMantenimientoMapeo objMantAfiliadoBE = new PagosMasivosAdministracionAfiliadosMantenimientoMapeo();
	private static String TipoLog = null;
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	RegistroAfiliadosPagosBE objRegistroAfiliadosBL = new RegistroAfiliadosPagosBE();
	
	public boolean MantenimientoAfiliado() throws SQLException, IOException{
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		boolean lbnResultadoEsperado=true;
		long LStr_HoraInicio;	 
		String LtrTXT_SUBMENU1="Mantenimiento de Afiliados";
		try {
			
			if (objFuncionesGenerales.verificarIgnore(LtrTXT_SUBMENU1)){	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objMantAfiliadoBE.seleccionarSubMenu1(LtrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+LtrTXT_SUBMENU1);
					TipoLog="1";
				}else{
					TipoLog="0";								
					lbnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+LtrTXT_SUBMENU1);
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
				    			
			if (objFuncionesGenerales.verificarIgnore(strCmbEmpresa))
			{		
				LStr_HoraInicio = System.currentTimeMillis();	 
				if (objMantAfiliadoBE.seleccionarEmpresa(strCmbEmpresa))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+ strCmbEmpresa , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					lbnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+  strCmbEmpresa , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
		
			if (objFuncionesGenerales.verificarIgnore(strCmbProducto))
			{		
				LStr_HoraInicio = System.currentTimeMillis();	 
				if (objMantAfiliadoBE.seleccionarProducto(strCmbProducto))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+ strCmbProducto , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					lbnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO "+ strCmbProducto , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
		
			if (objFuncionesGenerales.verificarIgnore(strCmbServicio))
			{		
				LStr_HoraInicio = System.currentTimeMillis();	 
				if (objMantAfiliadoBE.seleccionarServicio(strCmbServicio))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "del SERVICIO "+ strCmbServicio , "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					lbnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "del SERVICIO "+ strCmbServicio , "" ,  "");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			//------------------------INFORMACION DEL AFILIADO--------------------------------------------
			//VOLVER AL INICIO LA VARIABLE
			if (!strNumAfiliados.equals("<IGNORE>")){
				
//				if (!PagosMasivosBL.GstrACCION.equals("SI")){
//					FuncionesGenerales.casosEjecutar(PagosMasivosBL.Gstr_NUM_AFILIADOS,2);//captura todos los id a hacer prueba
//					objSQL.listaTablaIdCaso("APP_AND_AFILIADO","where SCRIPT='"+Mdl_Variables.Gstr_Tabla+"'",2);
//				}
				
//				if (FuncionesGenerales.buscarCasosEjecutar(Mdl_Variables.Grst_TablaLogin.getString("ID_CASO"),2) == true){
				objSQL.listaTablaIdCaso("APP_AND_AFILIADO","where SCRIPT='"+Mdl_Variables.Gstr_Tabla+"' and ID_CASO='"+strNumAfiliados+"'",2);
				Mdl_Variables.Grst_TablaLogin.next();
				    			lbnResultadoEsperado = objRegistroAfiliadosBL.Afiliados(Mdl_Variables.Grst_TablaLogin, 1);
				    			boolean busquedaPor=false;
				    			
				    			if (objFuncionesGenerales.verificarIgnore("CLICK")){//GstrBTN_OPCION_AVANZADA	
				    				LStr_HoraInicio = System.currentTimeMillis();	  
				    						
				    				if (objMantAfiliadoBE.ingresoBotoOpcionesAvanzadas()){	
				    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón OPCIONES AVANZADAS");
				    					TipoLog="1";
				    				}else{
				    					TipoLog="0";									
				    					lbnResultadoEsperado = false;
				    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón OPCIONES AVANZADAS");
				    				}
				    				LStr_HoraFin = System.currentTimeMillis();	  
				        			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    			    CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				            		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    			}
				    			
				    			
				    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR))
				    			{		
				    				LStr_HoraInicio = System.currentTimeMillis();	 
				    				if (objMantAfiliadoBE.seleccionarBuscarPor(RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR))
				    				{	
				    					objFuncionesGenerales.callPasosAcierto(2, "de BUSQUEDA POR "+ RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR , "" ,  "");
				    					TipoLog="1";
				    					busquedaPor=true;
				    				}else{
				    					TipoLog="0";		
				    					lbnResultadoEsperado = false;
				    					objFuncionesGenerales.callPasosErrado(2, "de BUSQUEDA POR "+ RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR , "" ,  "");
				    				}
				    				LStr_HoraFin = System.currentTimeMillis();	  
				    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    			}
		
				    			if(busquedaPor){
				    	    		if (RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR.equals("DNI")||RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR.equals("Carnet de Extranjería")||RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR.equals("RUC")){
				    	    			
				    	    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD)){		
				    	    				LStr_HoraInicio = System.currentTimeMillis();	 
				    	    				if (objMantAfiliadoBE.seleccionarTipoDocumento(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD)){	
				    	    					objFuncionesGenerales.callPasosAcierto(2, "de TIPO DOCUMENTO "+ RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
				    	    					TipoLog="1";
				    	    				}else{
				    	    					TipoLog="0";		
				    	    					lbnResultadoEsperado = false;
				    	    					objFuncionesGenerales.callPasosErrado(2, "de TIPO DOCUMENTO "+ RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
				    	    				}
				    	    				LStr_HoraFin = System.currentTimeMillis();	  
				    	    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    	    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    	    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    	    			}
				    	    			
				    	    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD)){	
				    	    				LStr_HoraInicio = System.currentTimeMillis();	 
				    	    				if (objMantAfiliadoBE.ingresarNumeroDocumento(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD)){	
				    	    					objFuncionesGenerales.callPasosAcierto(3, "El NRO DOCUMENTO "+ RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD , "" ,  "");
				    	    					TipoLog="1";
				    	    				}else{
				    	    					TipoLog="0";			
				    	    					lbnResultadoEsperado = false;
				    	    					objFuncionesGenerales.callPasosErrado(3, "El NRO DOCUMENTO "+ RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD , "" ,  "");
				    	    				}
				    	    				LStr_HoraFin = System.currentTimeMillis();	  
				    	    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    	    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    	    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    	    			}
				    	    		}else{
				    	    			if (RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR.equals("Nombre")){
				    	    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL))
				    	    				{	
				    	    					LStr_HoraInicio = System.currentTimeMillis();	 
				    	    					if (objMantAfiliadoBE.ingresarNombre(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL))
				    	    					{	
				    	    						objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE "+ RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL , "" ,  "");
				    	    						TipoLog="1";
				    	    					}else{
				    	    						TipoLog="0";			
				    	    						lbnResultadoEsperado = false;
				    	    						objFuncionesGenerales.callPasosErrado(3, "El NOMBRE "+ RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL , "" ,  "");
				    	    					}
				    	    					LStr_HoraFin = System.currentTimeMillis();	  
				    	    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    	    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    	    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    	    				}
				    		    		}else{
				    		    			if (RegistroAfiliadosPagosBE.GstrCMB_BUSQUEDAPOR.equals("Razón Social")){
				    		    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL))
				    		    				{	
				    		    					LStr_HoraInicio = System.currentTimeMillis();	 
				    		    					if (objMantAfiliadoBE.ingresarRazonSocial(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL))
				    		    					{	
				    		    						objFuncionesGenerales.callPasosAcierto(3, "La RAZON SOCIAL "+ RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL , "" ,  "");
				    		    						TipoLog="1";
				    		    					}else{
				    		    						TipoLog="0";			
				    		    						lbnResultadoEsperado = false;
				    		    						objFuncionesGenerales.callPasosErrado(3, "La RAZON SOCIAL "+ RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL , "" ,  "");
				    		    					}
				    		    					LStr_HoraFin = System.currentTimeMillis();	  
				    		    					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    		    				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    		    		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    		    				}
				    			    		}
				    		    		}
				    	    		}
				    	    		

			    				}
			    			
				    			
				    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_BUCARAFILIADO)){	
				    				LStr_HoraInicio = System.currentTimeMillis();	  
				    				if (objMantAfiliadoBE.ingresoBotonBuscar()){	
				    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
				    					TipoLog="1";
				    				}else{
				    					TipoLog="0";									
				    					lbnResultadoEsperado = false;
				    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				    				}
				    				LStr_HoraFin = System.currentTimeMillis();	  
				    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    			   	CapturarPantalla.scrollCapturaPantalla();
				    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    			}
				    			
			    	    		if(lbnResultadoEsperado&&RegistroAfiliadosPagosBE.GstrBTN_ELIMINAR.equals("<IGNORE>")&&RegistroAfiliadosPagosBE.GstrBTN_EDITAR.equals("<IGNORE>")){
			    	    			LStr_HoraInicio = System.currentTimeMillis();	  
			    	    			objMantAfiliadoBE.verificartablaBusqueda();
			    	    			if (objMantAfiliadoBE.VerificarAfiliado()){	
			    	    				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Existe el afiliado");
			    	    				TipoLog="1";
			    	    			}else{
			    	    				TipoLog="0";									
			    	    				lbnResultadoEsperado = false;
			    	    				objFuncionesGenerales.callPasosErrado(1, "", "" ,"No existe el afiliado");
			    	    			}
			    	    			LStr_HoraFin = System.currentTimeMillis();	  
			    	    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			    	    			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    	    			objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			    			
			    	    		}
				    			
				    			boolean borrar = false;
				    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_ELIMINAR)){	
				    				LStr_HoraInicio = System.currentTimeMillis();	  
				    				objMantAfiliadoBE.verificartablaBusqueda();
				    				if (objMantAfiliadoBE.ingresoBotonEliminar()){	
				    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la imagen ELIMINAR");
				    					TipoLog="1";
				    					borrar = true;
				    				}else{
				    					TipoLog="0";									
				    					lbnResultadoEsperado = false;
				    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el imagen ELIMINAR");
				    				}
				    				LStr_HoraFin = System.currentTimeMillis();	  
				    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    			}
				    			
				    			if (borrar){	
				    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_SI_POP_UP_ELIMINAR)){
					    				LStr_HoraInicio = System.currentTimeMillis();	
					    				objMantAfiliadoBE.verificarMensaje();
					    				if (objMantAfiliadoBE.ingresoBotonSI()){	
					    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Boton SI");
					    					TipoLog="1";
					    				}else{
					    					TipoLog="0";									
					    					lbnResultadoEsperado = false;
					    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Boton SI");
					    				}
					    				LStr_HoraFin = System.currentTimeMillis();	  
					    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					    			}
				    			
					    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_NO_POP_UP_ELIMINAR))
					    			{	
					    				LStr_HoraInicio = System.currentTimeMillis();	
					    				objMantAfiliadoBE.verificarMensaje();
					    				if (objMantAfiliadoBE.ingresoBotonNO()){	
					    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Boton NO");
					    					TipoLog="1";
					    				}else{
					    					TipoLog="0";									
					    					lbnResultadoEsperado = false;
					    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Boton NO");
					    				}
					    				LStr_HoraFin = System.currentTimeMillis();	  
					    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					    			}
				    			
					    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_BUCARAFILIADO)){	
					    				LStr_HoraInicio = System.currentTimeMillis();	  
					    				if (objMantAfiliadoBE.ingresoBotonBuscar()){	
					    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					    					TipoLog="1";
					    				}else{
					    					TipoLog="0";									
					    					lbnResultadoEsperado = false;
					    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
					    				}
					    				LStr_HoraFin = System.currentTimeMillis();	  
					    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					    			   	CapturarPantalla.scrollCapturaPantalla();
					    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					    			}
					    			
//					    			if (lbnResultadoEsperado)
//					    			{	
//					    				LStr_HoraInicio = System.currentTimeMillis();	  
//					    				objMantAfiliadoBE.verificartablaBusqueda();
//					    				if (objMantAfiliadoBE.VerificarUsuario()){	
//					    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la imagen ELIMINAR");
//					    					TipoLog="1";
//					    				}else{
//					    					TipoLog="0";									
//					    					lbnResultadoEsperado = false;
//					    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el imagen ELIMINAR");
//					    				}
//					    				LStr_HoraFin = System.currentTimeMillis();	  
//					    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//					    			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//					    	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//					    			}
				    			
				    			}
				    			
				    			boolean bGraboEditar = false;
				    			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_EDITAR))
				    			{	
				    				LStr_HoraInicio = System.currentTimeMillis();	  
				    				objMantAfiliadoBE.verificartablaBusqueda();
				    				if (objMantAfiliadoBE.ingresoBotonEditar()){	
				    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la imagen EDITAR");
				    					TipoLog="1";
				    					bGraboEditar=true;
				    				}else{
				    					TipoLog="0";									
				    					lbnResultadoEsperado = false;
				    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el imagen EDITAR");
				    				}
				    				LStr_HoraFin = System.currentTimeMillis();	  
				    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    			}

			    			
			    			//Modificar
			    			if(bGraboEditar){
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.seleccionarTipoPersona_Edit(RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(2, "del TIPO PERSONA "+RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(2, "del TIPO PERSONA "+ RegistroAfiliadosPagosBE.GstrCMB_TIPO_PERSONA_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarNombreRazon_Edit(RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE/RAZON SOCIAL "+ RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "El NOMBRE/RAZON SOCIAL "+ RegistroAfiliadosPagosBE.GstrTXT_NOMBRE_RAZON_SOCIAL_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.seleccionarTipoDocumento_Edit(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(2, "del TIPO DOCUMENTO "+RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(2, "del TIPO DOCUMENTO "+ RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarNumeroDocumento_Edit(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "El NUMERO DOCUMENTO IDENTIDAD "+ RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "El NUMERO DOCUMENTO IDENTIDAD "+ RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarDireccion_Edit(RegistroAfiliadosPagosBE.GstrTXT_DIRECCION_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "La DIRECCION "+ RegistroAfiliadosPagosBE.GstrTXT_DIRECCION_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "La DIRECCION "+ RegistroAfiliadosPagosBE.GstrTXT_DIRECCION_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_EMAIL_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarEmail_Edit(RegistroAfiliadosPagosBE.GstrTXT_EMAIL_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "El EMAIL "+ RegistroAfiliadosPagosBE.GstrTXT_EMAIL_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "El EMAIL "+ RegistroAfiliadosPagosBE.GstrTXT_EMAIL_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.seleccionarTipoAbonoSoles_Edit(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(2, "del TIPO ABONO SOLES "+RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(2, "del TIPO ABONO SOLES "+ RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_SOLES_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.seleccionarTipoCuentaSoles_Edit(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(2, "del TIPO CUENTA SOLES "+RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(2, "del TIPO CUENTA SOLES "+ RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_SOLES_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarMontoLimiteSoles_Edit(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "El MONTO LIMITE SOLES "+ RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "El MONTO LIMITE SOLES "+ RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_SOLES_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarNumeroCuentaSoles_Edit(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "El NUMERO CUENTA SOLES "+ RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "El NUMERO CUENTA SOLES "+ RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_SOLES_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLAR_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.seleccionarTipoAbonoDolar_Edit(RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLAR_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(2, "del TIPO ABONO DOLAR "+RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLAR_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(2, "del TIPO ABONO DOLAR "+ RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO_DOLAR_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.seleccionarTipoCuentaDolar_Edit(RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(2, "del TIPO CUENTA DOLAR "+RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(2, "del TIPO CUENTA DOLAR "+ RegistroAfiliadosPagosBE.GstrCMB_TIPO_CUENTA_DOLARES_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLAR_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarMontoLimiteDolar_Edit(RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLAR_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "El MONTO LIMITE DOLAR "+ RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLAR_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "El MONTO LIMITE DOLAR "+ RegistroAfiliadosPagosBE.GstrTXT_MONTO_LIMITE_DOLAR_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES_EDIT))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	 
			        				if (objMantAfiliadoBE.ingresarNumeroCuentaDolar_Edit(RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES_EDIT))
			        				{	
			        					objFuncionesGenerales.callPasosAcierto(3, "El NUMERO CUENTA DOLAR "+ RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES_EDIT , "" ,  "");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";			
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(3, "El NUMERO CUENTA DOLAR "+ RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA_DOLARES_EDIT , "" ,  "");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_MODIFICAR))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	  
			        				if (objMantAfiliadoBE.ingresoBotonModificar()){	
			        					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón MODIFICAR");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";									
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón MODIFICAR");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_SI_POP_UP_MODIFICAR))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	  
			        				if (objMantAfiliadoBE.ingresoBotonSI_Edit()){	
			        					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón SI del PopUp");
			        					bGraboEditar = true;
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";									
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón SI del PopUp");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				

			    				
			    				if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_NO_POP_UP_MODIFICAR))
			        			{	
			        				LStr_HoraInicio = System.currentTimeMillis();	  
			        				if (objMantAfiliadoBE.ingresoBotonNO_Edit()){	
			        					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NO del PopUp");
			        					TipoLog="1";
			        				}else{
			        					TipoLog="0";									
			        					lbnResultadoEsperado = false;
			        					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NO del PopUp");
			        				}
			        				LStr_HoraFin = System.currentTimeMillis();	  
			            			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			        			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			        	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			        			}
			    				
			    				if (lbnResultadoEsperado)
				    			{	
				    				LStr_HoraInicio = System.currentTimeMillis();	  
				    				objMantAfiliadoBE.verificartablaBusqueda();
				    				if (objMantAfiliadoBE.ingresoModificacion()){	
				    					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en la imagen ELIMINAR");
				    					TipoLog="1";
				    				}else{
				    					TipoLog="0";									
				    					lbnResultadoEsperado = false;
				    					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el imagen ELIMINAR");
				    				}
				    				LStr_HoraFin = System.currentTimeMillis();	  
				    				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				    			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				    	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    			}
			    				
			    			}
			    		}
			    	//} *3

			
			if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrBTN_BUSCAR))
			{	
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objMantAfiliadoBE.ingresoBotonBuscar()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					lbnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = System.currentTimeMillis();	  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
//			if (lbnResultadoEsperado)
//			{	
//				LStr_HoraInicio = System.currentTimeMillis();
//				if(objMantAfiliadoBE.verificartablaBusqueda() ||objMantAfiliadoBE.verificarMensajeResultadoBusqueda() ){
//						
//					if(objMantAfiliadoBE.verificarNoExisteData()){
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Existe Afiliados en este Producto");
//						TipoLog="1";
//					}else{
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"No Existe afiliados en este producto.");
//						TipoLog="1";
//					}
//				}else{
//					TipoLog="0";									
//					lbnResultadoEsperado = false;
//					objFuncionesGenerales.callPasosErrado(1, "", "" ,"No existe informacion");
//				}
//				LStr_HoraFin = System.currentTimeMillis();	  
//				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//			   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//	    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//			}
//				
//				  
//    
//			
//			//----
//			if(objMantAfiliadoBE.verificartablaBusqueda()){
//				if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_CORREO))
//				{	
//					LStr_HoraInicio = System.currentTimeMillis();	  
//					if (objMantAfiliadoBE.ingresoLinkEnvioCorreo()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link ENVIAR EMAIL");
//						TipoLog="1";
//					}else{
//						TipoLog="0";									
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link ENVIAR EMAIL");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO))
//				{	
//					LStr_HoraInicio = System.currentTimeMillis();	 
//					if (objMantAfiliadoBE.ingresarCorreo(GstrTXT_CORREO))
//					{	
//						objFuncionesGenerales.callPasosAcierto(3, "El CORREO: "+ GstrTXT_CORREO , "" ,  "");
//						TipoLog="1";
//					}else{
//						TipoLog="0";			
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(3, "El CORREO: "+ GstrTXT_CORREO , "" ,  "");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE))
//				{	
//					LStr_HoraInicio = System.currentTimeMillis();	 
//					if (objMantAfiliadoBE.ingresarMensaje(GstrTXT_MENSAJE))
//					{	
//						objFuncionesGenerales.callPasosAcierto(3, "El MENSAJE: "+ GstrTXT_MENSAJE , "" ,  "");
//						TipoLog="1";
//					}else{
//						TipoLog="0";			
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(3, "El MENSAJE: "+ GstrTXT_MENSAJE , "" ,  "");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO))
//				{	
//					LStr_HoraInicio = System.currentTimeMillis();	  
//					if (objMantAfiliadoBE.ingresoBotonEnviar()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVÍAR");
//						TipoLog="1";
//					}else{
//						TipoLog="0";									
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVÍAR");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL))
//				{	
//					LStr_HoraInicio = System.currentTimeMillis();	  
//					if (objMantAfiliadoBE.ingresoLinkExportarExcel()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link EXPORTAR EXCEL");
//						TipoLog="1";
//					}else{
//						TipoLog="0";									
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link EXPORTAR EXCEL");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF))
//				{	
//					LStr_HoraInicio = System.currentTimeMillis();	  
//					if (objMantAfiliadoBE.ingresoLinkExportarPDF()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link EXPORTAR PDF");
//						TipoLog="1";
//					}else{
//						TipoLog="0";									
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Link EXPORTAR PDF");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
//				
//				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR))
//				{	
//					LStr_HoraInicio = System.currentTimeMillis();	  
//					if (objMantAfiliadoBE.ingresoLnikImprimir()){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Link IMPRIMIR");
//						TipoLog="1";
//					}else{
//						TipoLog="0";									
//						lbnResultadoEsperado = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón IMPRIMIR");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				}
//			}
			//---------------------------------------------------------------------------------------		


}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			lbnResultadoEsperado = false;
		}
		return lbnResultadoEsperado;
	}

}
