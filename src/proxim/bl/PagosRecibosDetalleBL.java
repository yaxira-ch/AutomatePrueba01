package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.PagosRecibosDetalleBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosRecibosDetalleBL extends PagosRecibosDetalleBE {

	private static String TipoLog = null;
	PagosRecibosDetalleMapeo objDetallePagoRegistroBE=new PagosRecibosDetalleMapeo()	;
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionBL objConexionBL = new ConexionBL();
	
	public boolean pagosRecibosDetalle(int numero,int indice,int totalregistros) throws SQLException, IOException{
		boolean bandera = true;
		long LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		long LStr_HoraInicio;	 
		
		try {
			if(numero==1){
				if (objFuncionesGenerales.verificarIgnore(GstrIMG_BUSCAR)){	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objDetallePagoRegistroBE.ingresoBotonBuscarEmpresa(indice)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR EMPRESA");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR EMPRESA");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
		
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_EMPRESA_BUSCAR)){	
					LStr_HoraInicio = System.currentTimeMillis();	  	
					if (objDetallePagoRegistroBE.ingresarEmpresaBusca(GstrTXT_EMPRESA_BUSCAR))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El NOMBRE DE LA EMPRESA a buscar "+GstrTXT_EMPRESA_BUSCAR , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El NOMBRE DE LA EMPRESA a buscar "+GstrTXT_EMPRESA_BUSCAR , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				
				if (objFuncionesGenerales.verificarIgnore(GstrLST_EMPRESA)){		
					LStr_HoraInicio = System.currentTimeMillis();
					if (objDetallePagoRegistroBE.seleccionarEmpresaBusca(GstrTXT_EMPRESA_BUSCAR))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+GstrTXT_EMPRESA_BUSCAR , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+GstrTXT_EMPRESA_BUSCAR , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosRecibosDetalleBE.GstrBTN_ACEPTAR)){	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objDetallePagoRegistroBE.ingresoBotonAceptar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ACEPTAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ACEPTAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_SERVICIO)){		
					LStr_HoraInicio = System.currentTimeMillis();
					if (objDetallePagoRegistroBE.seleccionarServicio(GstrCMB_SERVICIO,indice))
					{	
						objFuncionesGenerales.callPasosAcierto(2, "del SERVICIO "+GstrCMB_SERVICIO , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";		
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "del SERVICIO "+GstrCMB_SERVICIO , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(PagosRecibosDetalleBE.GstrTXT_CODIGO_DEUDOR)){	
					LStr_HoraInicio = System.currentTimeMillis();	  	
					if (objDetallePagoRegistroBE.ingresarCodigoDeudor(GstrTXT_CODIGO_DEUDOR,indice))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "El CODIGO del DEUDOR "+GstrTXT_CODIGO_DEUDOR , "" ,  "");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El CODIGO del DEUDOR "+GstrTXT_CODIGO_DEUDOR , "" ,  "");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrIMG_GUARDAR)){	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objDetallePagoRegistroBE.ingresoBotonGuardar(indice)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón GUARDAR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón GUARDAR");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
			//	if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
					if(GstrTXT_COLUMNA_ERROR.equals("TXT_CODIGO_DEUDOR")){
						LStr_HoraInicio = System.currentTimeMillis();	
						if (objDetallePagoRegistroBE.compararMensajeError(GstrTXT_MENSAJE_ERROR)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"se compara el mensaje de error");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"se compara el mensaje de error");
						}
						LStr_HoraFin = System.currentTimeMillis();	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				}
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS)){	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objDetallePagoRegistroBE.ingresoTodos(1,indice)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check ");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check ");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				} 
				
				if (objFuncionesGenerales.verificarIgnore(GstrIMG_ELIMINAR)){	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objDetallePagoRegistroBE.ingresoBotonEliminar(indice)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check ");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check ");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				} 
				
				if (objFuncionesGenerales.verificarIgnore(GstrIMG_EDITAR)){	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objDetallePagoRegistroBE.ingresoBotonEditar(indice)){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check ");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check ");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				} 
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_NUEVO_REGISTRO)){	
					LStr_HoraInicio = System.currentTimeMillis();	
					if (objDetallePagoRegistroBE.ingresoBotonNuevoRegistro()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón NUEVO REGISTRO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón NUEVO REGISTRO");
					}
					LStr_HoraFin = System.currentTimeMillis();	  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}else{//en caso de que el tipo de pago sea PAGOS RECURRENTES.
				if(numero==2){ 
					if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS)){	
						LStr_HoraInicio = System.currentTimeMillis();	
						if (objDetallePagoRegistroBE.ingresoTodos(2,indice)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check ");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check ");
						}
						LStr_HoraFin = System.currentTimeMillis();	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
				}else{
					
					if (objFuncionesGenerales.verificarIgnore(PagosRecibosDetalleBE.GstrTXT_MODO_PAGO)){	
						LStr_HoraInicio = System.currentTimeMillis();
						Thread.sleep(900);
						if (objDetallePagoRegistroBE.seleccionarModoPago(GstrTXT_MODO_PAGO,indice,totalregistros))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El MONTO A PAGAR "+GstrTXT_MODO_PAGO , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El MONTO A PAGAR "+ GstrTXT_MODO_PAGO, "" ,  "");//
						}
						LStr_HoraFin = System.currentTimeMillis();	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
					
					if (objFuncionesGenerales.verificarIgnore(PagosRecibosDetalleBE.GstrTXT_MONTO_PAGAR)){	
						LStr_HoraInicio = System.currentTimeMillis();	
						Thread.sleep(900);
						if (objDetallePagoRegistroBE.ingresarMontoPagar(GstrTXT_MONTO_PAGAR,indice,totalregistros))
						{	
							objFuncionesGenerales.callPasosAcierto(3, "El MONTO A PAGAR "+GstrTXT_MONTO_PAGAR , "" ,  "");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "El MONTO A PAGAR "+ GstrTXT_MONTO_PAGAR, "" ,  "");//
						}
						LStr_HoraFin = System.currentTimeMillis();	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
					
					if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS1)){	
						LStr_HoraInicio = System.currentTimeMillis();	
						Thread.sleep(900);
						if (objDetallePagoRegistroBE.checkEnviar(indice,totalregistros)){	
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check ");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check ");
						}
						LStr_HoraFin = System.currentTimeMillis();	  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
				}
			}
//			}else{
//				if (objFuncionesGenerales.verificarIgnore(GstrCHK_TODOS1)){	
//					LStr_HoraInicio = System.currentTimeMillis();	
//					if (objDetallePagoRegistroBE.ingresoTodos(1,indice)){	
//						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Check ");
//						TipoLog="1";
//					}else{
//						TipoLog="0";			
//						bandera = false;
//						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Check ");
//					}
//					LStr_HoraFin = System.currentTimeMillis();	  
//					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				   	CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//		    		objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				} 
//				
//			}
			
		}catch (Exception e) {
			bandera =false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
	}

