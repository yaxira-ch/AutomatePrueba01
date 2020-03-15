package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ObjetosGenerales;
import proxim.be.TransfEntreCuentasPortabilidadBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class PortabilidadTransfEntreCuentasBL extends TransfEntreCuentasPortabilidadBE{
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	PortabilidadTransfEntreCuentasMapeo objTransfEntreCuentasPortabilidadMapeo=new PortabilidadTransfEntreCuentasMapeo();
	PortabilidadConsultaSaldosBL objPortabilidadConsultaSaldosBL=new PortabilidadConsultaSaldosBL();
	LoginPortabilidadBL objLoginPortabilidadBL=new LoginPortabilidadBL();
	static ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	FirmarBL objTransferenciaFirmanteBL =new FirmarBL();
	long lngHoraFin;
	long lngTiempoEjeCaso;
	long lngHoraInicio;
	boolean blnResultadoEsperado=true;
	boolean consultar1=false;
	boolean consultar2=false;
	boolean consultar3=false;
	String strTipoLog ;
	String strURLPortabilidad="https://130.30.25.24/bpi-empresas/";
	//String strURLPortabilidad="https://130.30.25.23:9444/bpi-empresas-v3/login";
	String strTextoImagen="1. Imagenes";

	
	public boolean realizarEnvio() throws SQLException, IOException{
		try{
			//----------------------------------------LOGIN PORTABILIDAD---------------------------------------------
			objLoginPortabilidadBL.loginPortabilidad(GstrTIE, GstrCLAVE, GstrTXT_CAPCHA, GstrBTN_SIGUIENTE, GstrBTN_SIGUIENTE1);
			//-----------------------------------------------------------------------------------------------
			
			boolean blnResultadoTransferencia=realizaEnvio();

			
			//----------------------------------------FIRMAR---------------------------------------------
			if (GstrFIRMAR.equals("SI")&&blnResultadoTransferencia){
				
				//----------------------------------------LOG OFF PORTABILIDAD---------------------------------------------
				objLoginPortabilidadBL.logOffPortabilidad(GstrLNK_CERRAR_SESION) ;
				//-----------------------------------------------------------------------------------------------
				
				
				if(GstrOPERADOR.equals(Mdl_Variables.Gstr_Ignore)){
					if (!GstrFIRMANTE3.equals(Mdl_Variables.Gstr_Ignore)){
						consultar3=true;
					}else if (!GstrFIRMANTE2.equals(Mdl_Variables.Gstr_Ignore)){
						consultar2=true;
					}else{
						if (!GstrFIRMANTE1.equals(Mdl_Variables.Gstr_Ignore)){
							consultar1=true;
						}
					}
				}
					
				String strTablaAutorizarTransferencias="APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D";
				String strTablaAutorizarPortabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
				String strTablaAutorizarPendientes="APP_AND_AUTORIZACIONES_PENDIENTES_D";
				
				if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1)){
					if (GstrFIRMANTE1.equals("PA")){
						Mdl_Variables.Gstr_Url=strURLPortabilidad;
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F1",consultar1);
					}else if (GstrFIRMANTE1.equals("PORT") ){
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F1' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia entre cuentas",consultar1,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_CUENTA_DESTINO);
					}else if (GstrFIRMANTE1.equals("AP")){
						Mdl_Variables.Gstr_Url=strURLPortabilidad;
						blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F1","Entre Cuentas",consultar1);
					}
					
				}
				
				if (blnResultadoEsperado){
					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
						if (GstrFIRMANTE2.equals("PA")){
							Mdl_Variables.Gstr_Url=strURLPortabilidad;
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F2",consultar2);
						}else if (GstrFIRMANTE2.equals("PORT") ){
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F2' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia entre cuentas",consultar2,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_CUENTA_DESTINO);
						}else if (GstrFIRMANTE2.equals("AP")){
							Mdl_Variables.Gstr_Url=strURLPortabilidad;
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F2","Entre Cuentas",consultar2);
						}
					}
					
					if (blnResultadoEsperado){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
							if (GstrFIRMANTE3.equals("PA")){
								Mdl_Variables.Gstr_Url=strURLPortabilidad;
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","F3",consultar3);
							}else if (GstrFIRMANTE3.equals("PORT") ){
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,GstrID_CASO+"-P","F3' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia entre cuentas",consultar3,GstrBTN_CONSULTA_SALDOS,GstrCMB_CUENTA_ORIGEN,GstrCMB_CUENTA_DESTINO);
							}else if (GstrFIRMANTE3.equals("AP")  ){
								Mdl_Variables.Gstr_Url=strURLPortabilidad;
								blnResultadoEsperado=objTransferenciaFirmanteBL.firmaAutorizaciones(strTablaAutorizarPendientes,GstrID_CASO+"-P","F3","Entre Cuentas",consultar3);
							}
						}
						
						if(blnResultadoEsperado&& objFuncionesGenerales.verificarIgnore(GstrOPERADOR)&&GstrOPERADOR.equals("PA") ){
							Mdl_Variables.Gstr_Url=strURLPortabilidad;
							blnResultadoEsperado=objTransferenciaFirmanteBL.firmaTransferencia(strTablaAutorizarTransferencias,GstrID_CASO+"-P","OP",true);
						}
						
					}
				}
			}else{
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONSULTA_SALDOS)){
					
					//Consulta en portabilidad
					String strEmpresa=null;
					String strLinkCuenta=null;
					String strMensajeCorreo=null;
					
					for (int i=1;i<=2;i++){
						
						if(i==1){
							strEmpresa=GstrCMB_EMPRESA_CUENTA_ORIGEN;
							Mdl_Variables.map=objFuncionesGenerales.obtenerDatosEmpresaVariante(GstrCMB_CUENTA_ORIGEN);
							strLinkCuenta=Mdl_Variables.map.get("strNumeroCuenta") ;//100-7000001698  
							strMensajeCorreo="ABONO: Consulta de saldos y movimientos Caso N° "+GstrID_CASO;
						}else{
							strEmpresa=GstrCMB_EMPRESA_CUENTA_DESTINO;
							Mdl_Variables.map=objFuncionesGenerales.obtenerDatosEmpresaVariante(GstrCMB_CUENTA_DESTINO);
							strLinkCuenta=Mdl_Variables.map.get("strNumeroCuenta") ;//100-7000001698  
							strMensajeCorreo="CARGO: Consulta de saldos y movimientos Caso N° "+GstrID_CASO;
						}
						
						Mdl_Variables.map.put("GstrBTN_CONSULTA_SALDOS", GstrBTN_CONSULTA_SALDOS);
						Mdl_Variables.map.put("GstrCMB_EMPRESA",strEmpresa );
						Mdl_Variables.map.put("GstrBTN_ENVIAR_EMAIL", GstrBTN_ENVIAR_EMAIL);
						Mdl_Variables.map.put("GstrTXT_CORREO", GstrTXT_CORREO);
						Mdl_Variables.map.put("GstrTXT_MENSAJE_CORREO", GstrTXT_MENSAJE_CORREO);
						Mdl_Variables.map.put("GstrBTN_ENVIAR_CORREO", GstrBTN_ENVIAR_CORREO);
						Mdl_Variables.map.put("GstrBTN_CERRAR_CORREO", GstrBTN_CERRAR_CORREO);
						Mdl_Variables.map.put("GstrBTN_SELECCIONAR_CUENTA", "CLICK");
						Mdl_Variables.map.put("GstrLNK_NUMERO_CUENTA", strLinkCuenta);
						Mdl_Variables.map.put("GstrBTN_ENVIAR_EMAIL_MOVIMIENTOS", "CLICK");
						Mdl_Variables.map.put("GstrTXT_CORREO_MOVIMIENTOS", GstrTXT_CORREO);
						Mdl_Variables.map.put("GstrTXT_MENSAJE_CORREO_MOVIMIENTOS",strMensajeCorreo );
						Mdl_Variables.map.put("GstrBTN_ENVIAR_CORREO_MOVIMIENTOS", "CLICK");
						Mdl_Variables.map.put("GstrBTN_CERRAR_CORREO_MOVIMIENTOS", "CLICK");
						
						objPortabilidadConsultaSaldosBL.ejecutarConsulta();
					}
					
					//----------------------------------------LOG OFF PORTABILIDAD---------------------------------------------
					objLoginPortabilidadBL.logOffPortabilidad(GstrLNK_CERRAR_SESION) ;
					//-----------------------------------------------------------------------------------------------
					//Mdl_Variables.Gstr_Ignore
					//consulta en la BPI
//					Mdl_Variables.Gstr_Url="";//formatear el url
//					objConexion.Conexion();
//					objLoginBL2.ingresoLogin( "0",Lstr_TxtNumTarjeta,Lstr_CHK_HACER_TARJETA_FRECUENTE,Lstr_IntentosPrevios,Lstr_BtnContinuar,Lstr_CerrarPopupClave,Lstr_TxtCapcha,Lstr_TxtColumnaError,Lstr_CambiarCapcha,Lstr_TxtMensajeError,Lstr_BtnToolTipAlerta,Lstr_BtnToolTipAceptar);
//					Mdl_Variables.Gstr_Tabla="APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D";
//					map=objFuncionesGenerales.obtenerCampos_ConsultarSaldos();
//					objFuncionesGenerales.insertSaldosMovimientos(strTipoProducto,map);
//					
//	
//					lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,"Cargo","APP_AND_PAGO_MAS_ADMPAGOS_D");
//					if(lbnResultadoEsperado){
//						lbnResultadoEsperado=objGlosasConsultaSaldosMovimientosBL.consultarGlosasSaldoMovimiento(strIdCaso,"Abono","APP_AND_PAGO_MAS_ADMPAGOS_D");
//					}
				}
			}
				//-----------------------------------------------------------------------------------------------		
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}

	public boolean realizaEnvio() throws SQLException, IOException{
	try{

		if (objFuncionesGenerales.verificarIgnore(GstrBTN_TRANSFERENCIAS)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresoTransferenciaLista()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Transferencia");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Transferencia");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			Thread.sleep(500);
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrLNK_TRANSFERENCIAS)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresoTransferenciaLink()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en Transferencia");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en Transferencia");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			Thread.sleep(500);
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_ORIGEN)&&GstrEMPRESA.equals("NO")){		
			lngHoraInicio = System.currentTimeMillis();	 
			if (objTransfEntreCuentasPortabilidadMapeo.seleccionarEmpresaCuentaOrigen(GstrCMB_EMPRESA_CUENTA_ORIGEN))
			{	
				objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA CUENTA DE ORIGEN, "+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";		
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA CUENTA DE ORIGEN, "+GstrCMB_EMPRESA_CUENTA_ORIGEN , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_ORIGEN)){		
			lngHoraInicio = System.currentTimeMillis();	 
			String strNewCuentaOrigen=  objFuncionesGenerales.newCuenta(GstrCMB_CUENTA_ORIGEN);
			if (objTransfEntreCuentasPortabilidadMapeo.seleccionarCuentaOrigen(strNewCuentaOrigen)){	
				objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DE ORIGEN, "+strNewCuentaOrigen , "" ,  "");
				strTipoLog="1";
				Thread.sleep(800);
			}else{
				strTipoLog="0";		
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DE ORIGEN, "+strNewCuentaOrigen , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCMB_EMPRESA_CUENTA_DESTINO)&&GstrEMPRESA.equals("NO")){		
			lngHoraInicio = System.currentTimeMillis();	 
			if (objTransfEntreCuentasPortabilidadMapeo.seleccionarEmpresaCuentaDestino(GstrCMB_EMPRESA_CUENTA_DESTINO)){	
				objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA CUENTA DESTINO, "+GstrCMB_EMPRESA_CUENTA_DESTINO , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";		
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA CUENTA DESTINO, "+GstrCMB_EMPRESA_CUENTA_DESTINO , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_DESTINO)){	
			lngHoraInicio = System.currentTimeMillis();	 
			String strNewCuentaDestino=  objFuncionesGenerales.newCuenta(GstrCMB_CUENTA_DESTINO);
			if (objTransfEntreCuentasPortabilidadMapeo.seleccionarCuentaDestino(strNewCuentaDestino)){	
				objFuncionesGenerales.callPasosAcierto(2, "de la CUENTA DESTINO, "+strNewCuentaDestino , "" ,  "");
				strTipoLog="1";
				CapturarPantalla.pageDown("400");
			}else{
				strTipoLog="0";			
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, "de la CUENTA DESTINO, "+strNewCuentaDestino , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA)){		
			lngHoraInicio = System.currentTimeMillis();	 
			if (objTransfEntreCuentasPortabilidadMapeo.seleccionarMoneda(GstrCMB_MONEDA)){	
				objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA, "+GstrCMB_MONEDA , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, "de la MONEDA, "+GstrCMB_MONEDA , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO)){	
			lngHoraInicio = System.currentTimeMillis();	  	
			if (objTransfEntreCuentasPortabilidadMapeo.ingresarMonto(GstrTXT_MONTO))
			{	
				objFuncionesGenerales.callPasosAcierto(3, "El MONTO, "+GstrTXT_MONTO , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, "El MONTO, "+GstrTXT_MONTO , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrTXT_DESCRIPCION_TRANSFERENCIA)){	
			lngHoraInicio = System.currentTimeMillis();	  	
			if (objTransfEntreCuentasPortabilidadMapeo.ingresarDescripcion(GstrTXT_DESCRIPCION_TRANSFERENCIA)){	
				objFuncionesGenerales.callPasosAcierto(3, "La DESCRIPCIÓN, "+GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, "La DESCRIPCIÓN, "+GstrTXT_DESCRIPCION_TRANSFERENCIA , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.pageDown("400");
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_TICKET_ESPECIAL)){	
			lngHoraInicio = System.currentTimeMillis();	  	
			if (objTransfEntreCuentasPortabilidadMapeo.ingresarNumeroTicket(GstrTXT_NUMERO_TICKET_ESPECIAL)){	
				objFuncionesGenerales.callPasosAcierto(3, "El numero de TK, "+GstrTXT_NUMERO_TICKET_ESPECIAL , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, "El numero de TK, "+GstrTXT_NUMERO_TICKET_ESPECIAL , "" ,  "");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.pageDown("400");
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresoBotonContinuar()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONTINUAR");
				strTipoLog="1";
				objTransfEntreCuentasPortabilidadMapeo.validarConfirmacionTransferencia();
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONTINUAR");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_DETALLE)){	//faltaaa
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.verDetalle()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Ver Detalle");
				strTipoLog="1";
				objTransfEntreCuentasPortabilidadMapeo.validarDetallerTransferencia();
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Ver Detalle");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrLNK_REGRESAR)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.regresar()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Ver Detalle");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Ver Detalle");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}

		if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_ERRONEA)||
				objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_ERRONEA_MIN)||
				objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_ERRONEA_MAX)){	
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_ERRONEA)){	
				validarContrasenia(GstrTXT_CLAVE_ERRONEA);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_ERRONEA_MIN)){	
				validarContrasenia(GstrTXT_CLAVE_ERRONEA_MIN);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_ERRONEA_MAX)){	
				validarContrasenia(GstrTXT_CLAVE_ERRONEA_MAX);
			}
			
		}else if (GstrTXT_CLAVE.toLowerCase().equalsIgnoreCase("SI")){	
			if (objFuncionesGenerales.verificarIgnore(GstrCLAVE)){	
				CapturarPantalla.pageDown("400");
				lngHoraInicio = System.currentTimeMillis();	  
				if (objTransfEntreCuentasPortabilidadMapeo.ingresoClave(GstrCLAVE)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CONTRASEÑA, ", GstrCLAVE,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CONTRASEÑA, ", GstrCLAVE,"");
				}
				lngHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_MOSTRAR_CLAVE)){	
				lngHoraInicio = System.currentTimeMillis();	  
				if (objTransfEntreCuentasPortabilidadMapeo.verClave()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón Mostrar Clave");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón Mostrar Clave");
				}
				lngHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
				lngHoraInicio = System.currentTimeMillis();	  
				if (objTransfEntreCuentasPortabilidadMapeo.ingresoBotonConfirmar1()){	
					objTransfEntreCuentasPortabilidadMapeo.guardarIdTabla();
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
					objTransfEntreCuentasPortabilidadMapeo.validarResultadoEsperadoTransferencia(GstrFIRMAR);
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				lngHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			   	CapturarPantalla.scrollCapturaPantalla2();
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			}
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_ERROR)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.compararMensajeError(GstrTXT_MENSAJE_ERROR)){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"se compara mensaje de ERROR");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"se compara mensaje de ERROR");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_EMAIL)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresoBotonEnviarEmail()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR EMAIL");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR EMAIL");
			}
	
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			Thread.sleep(1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresarCorreo(GstrTXT_CORREO)){	
				objFuncionesGenerales.callPasosAcierto(3, "El correo ", GstrTXT_CORREO,"");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, "El correo ", GstrTXT_CORREO,"");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_CORREO)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_CORREO)){	
				objFuncionesGenerales.callPasosAcierto(3, "El mensaje del coreo ", GstrTXT_MENSAJE_CORREO,"");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, "El mensaje del coreo ", GstrTXT_MENSAJE_CORREO,"");
			}
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
					
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresoBotonEnviar()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón ENVIAR");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón ENVIAR");
			}
	
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			
		}
		
		if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_CORREO)){	
			lngHoraInicio = System.currentTimeMillis();	  
			if (objTransfEntreCuentasPortabilidadMapeo.ingresoBotonCerrarCorreo()){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CERRAR CORREO");
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CERRAR CORREO");
			}
	
			lngHoraFin = System.currentTimeMillis();	  
			lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
		}
	    	
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}
	
	
	public boolean validarContrasenia(String strClave) throws  IOException{
		try{		
			
			if (objFuncionesGenerales.verificarIgnore(strClave)){	
				lngHoraInicio = System.currentTimeMillis();	  
				if (objTransfEntreCuentasPortabilidadMapeo.ingresoClave(strClave)){	
					objFuncionesGenerales.callPasosAcierto(3, "La CLAVE ", strClave,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(3, "La CLAVE ", strClave,"");
				}
				CapturarPantalla.pageDown("400");
				lngHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
				lngHoraInicio = System.currentTimeMillis();	  
				if (objTransfEntreCuentasPortabilidadMapeo.ingresoBotonConfirmar1()){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
					strTipoLog="1";
				}else{
					strTipoLog="0";									
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
				}
				lngHoraFin = System.currentTimeMillis();	  
				lngTiempoEjeCaso = (lngHoraFin- lngHoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(lngHoraInicio));
			}
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			blnResultadoEsperado = false;
		}
		return blnResultadoEsperado;
	}
}
