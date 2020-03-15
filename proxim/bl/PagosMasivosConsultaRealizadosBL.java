package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosRealizadosBE;
import proxim.be.RegistroAfiliadosPagosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PagosMasivosConsultaRealizadosBL extends PagosMasivosAdministracionAfiliadosBE {

	
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	PagosRealizadosBE objPagosRealizadosBE = new PagosRealizadosBE();
	RegistroAfiliadosPagosBE objRegistroAfiliadosBL = new RegistroAfiliadosPagosBE(); 
	HeaderBL objHeader = new HeaderBL();
	
	public boolean administracionPagosRealizados() throws SQLException, IOException{
		boolean bandera = true;
		String strTipoLog = null;
		long strHoraFin;
		long lngTiempoEjeCaso;
		long strHoraInicio = System.currentTimeMillis();	
		String fechaBusqueda = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		String strTextoImagen="1. Imagenes";
		try{
			
			objHeader.menuPrincipal(Mdl_Variables.Gstr_Ignore, "PAGOS", "Consulta de Pagos Realizados");
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.seleccionarEmpresa(PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa)){	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA "+PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA "+PagosMasivosAdministracionAfiliadosBE.strCmbEmpresa , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)){	
				objPagosRealizadosBE.verificarProducto();
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.seleccionarProducto(PagosMasivosAdministracionAfiliadosBE.strCmbProducto)){	
					objFuncionesGenerales.callPasosAcierto(2, "del PRODUCTO "+PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del PRODUCTO "+PagosMasivosAdministracionAfiliadosBE.strCmbProducto , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strCmbServicio)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.seleccionarServicio(PagosMasivosAdministracionAfiliadosBE.strCmbServicio)){	
					objFuncionesGenerales.callPasosAcierto(2, "del SERVICIO "+PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del SERVICIO "+PagosMasivosAdministracionAfiliadosBE.strCmbServicio , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (PagosMasivosAdministracionAfiliadosBE.strCmbProducto.equals("Pago a Proveedores")){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.seleccionarEstadoPago("Abonado")){	
					objFuncionesGenerales.callPasosAcierto(2, "del ESTADO de Pago"+"Abonado" , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del ESTADO de Pago "+"Abonado" , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.ingresarFechaProcesoDesde(fechaBusqueda))
				{	
					objFuncionesGenerales.callPasosAcierto(3, "La Fecha de Proceso Desde "+fechaBusqueda , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La Fecha de Proceso Desde "+fechaBusqueda , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}

			if (objFuncionesGenerales.verificarIgnore(fechaBusqueda)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.ingresarFechaProcesoHasta(fechaBusqueda)){	
					objFuncionesGenerales.callPasosAcierto(3, "La Fecha de Proceso Hasta "+fechaBusqueda , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "La Fecha de Proceso Hasta "+fechaBusqueda , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//Busca combo Canal 
			if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){		
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.comboVerificarCanal()){ 
					objFuncionesGenerales.callPasosAcierto(8, "Se muestra el Combo", "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(8, "No se muestra el Combo", "" ,"");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
    			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			
			
			if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO)){	
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.seleccionarCanalEnvio(PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO)){	
					objFuncionesGenerales.callPasosAcierto(2, "del CANAL ENVIO "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO , "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "del CANAL ENVIO "+PagosMasivosAdministracionAfiliadosBE.GstrCMB_CANAL_ENVIO , "" ,  "");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
			
			//----------------------------------------------BUSCAR AFILIADOS--------------------------------------------------
			int intNum = 0;
			
			if(GstrCMB_TIPO_CARGA.equals("Ingreso Manual")&& objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.strNumAfiliados)){
				FuncionesGenerales.casosEjecutar(PagosMasivosAdministracionAfiliadosBE.strNumAfiliados,2);//captura todos los id a hacer prueba
				for(int i=0;i<=Mdl_Variables.Garr_CasoAfiliacion.length-1;i++){
					objSQL.listaTablaIdCaso("APP_AND_AFILIADO","where ID_CASO="+Mdl_Variables.Garr_CasoAfiliacion[i],2);
					
					
					while (Mdl_Variables.Grst_TablaLogin.next()) {	
						boolean bObtuvoAfiliados = objRegistroAfiliadosBL.Afiliados(Mdl_Variables.Grst_TablaLogin, 2);
						
						if(bObtuvoAfiliados){
							intNum ++; 
							if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)&& intNum == 1){	////1era vez---------------OPCIONES AVANZADAS
								strHoraInicio = System.currentTimeMillis();	  
								if (objPagosRealizadosBE.ingresoOpcionesAvanzadas()){
									objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón OPCIONES AVANZADAS");
									strTipoLog="1";
								}else{
									strTipoLog="0";			
									bandera = false;
									objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón OPCIONES AVANZADAS");
								}
								strHoraFin = System.currentTimeMillis();	  
				    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
							   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
					    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
							}
						}
						
						if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD)){	
							strHoraInicio = System.currentTimeMillis();	  
							if (objPagosRealizadosBE.seleccionarTipoDocumentoIdentidad(RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD)){
								objFuncionesGenerales.callPasosAcierto(2, "del TIPO DOCUMENTO IDENTIDAD "+RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
								strTipoLog="1";
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(2, "del TIPO DOCUMENTO IDENTIDAD "+RegistroAfiliadosPagosBE.GstrCMB_DOCUMENTO_IDENTIDAD , "" ,  "");
							}
							strHoraFin = System.currentTimeMillis();	  
			    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
						}
						
						if (objFuncionesGenerales.verificarIgnore(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD)){	
							strHoraInicio = System.currentTimeMillis();	  	
							if (objPagosRealizadosBE.ingresarNumeroDocIdentidad(RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD)){	
								objFuncionesGenerales.callPasosAcierto(3, "El NUMERO DE DOCUMENTO de Identidad "+RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD , "" ,  "");
								strTipoLog="1";
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(3, "El NUMERO DE DOCUMENTO de Identidad "+RegistroAfiliadosPagosBE.GstrTXT_DOCUMENTO_IDENTIDAD , "" ,  "");
							}
							strHoraFin = System.currentTimeMillis();	  
			    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
						}
						
						if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){	
							strHoraInicio = System.currentTimeMillis();	  
							if (objPagosRealizadosBE.ingresoBuscarDetalle()){
								objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón BUSCAR");
								strTipoLog="1";
								objPagosRealizadosBE.verificarTablaRealizados();
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón BUSCAR");
							}
							strHoraFin = System.currentTimeMillis();	  
			    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
						   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
						}
						
						if (PagosMasivosAdministracionAfiliadosBE.GstrESTADO.equals("Procesada")){	
							objPagosRealizadosBE.verificarTablaResultados();
							strHoraInicio = System.currentTimeMillis();	  
							if (objPagosRealizadosBE.obtenerRegistroBuscado(PagosMasivosAdministracionAfiliadosBE.strCmbProducto, RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO,
									RegistroAfiliadosPagosBE.GstrCMB_TIPO_ABONO, RegistroAfiliadosPagosBE.GstrCMB_NUMERO_CUENTA, 
									RegistroAfiliadosPagosBE.GstrCMB_MONEDA_MONTO_OPERACION, RegistroAfiliadosPagosBE.GstrTXT_MONEDA_MONTO_OPERACION, fechaBusqueda, "Abonado",RegistroAfiliadosPagosBE.GstrTXT_NUMERO_CUENTA)){
								objFuncionesGenerales.callPasosAcierto(6, "Registro del Afiliado " + RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO, "" ,"");
								strTipoLog="1";
							}else{
								strTipoLog="0";			
								bandera = false;
								objFuncionesGenerales.callPasosErrado(6, "Registro del Afiliado " + RegistroAfiliadosPagosBE.GstrTXT_CODIGO_BENEFICIARIO, "" ,"");
							}
							strHoraFin = System.currentTimeMillis();	  
			    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
						   	CapturarPantalla.scrollCapturaPantalla();
				    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
						}
					}
				}
					
				
			}
			//-----------------------------------------------------------------------------------------------------------------
			
			if(intNum==0 && objFuncionesGenerales.verificarIgnore("Buscar")){
				strHoraInicio = System.currentTimeMillis();	  
				if (objPagosRealizadosBE.ingresoBuscarDetalle()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el botón BUSCAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el botón BUSCAR");
				}
				strHoraFin = System.currentTimeMillis();	  
    			lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla();
			   	CapturarPantalla.scrollCapturaPantallaHorizontal("/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/div/div[1]/div[5]/div/div[5]");
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
		}
		catch (Exception e) {
			bandera = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso)); 
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return bandera;
	}
}
