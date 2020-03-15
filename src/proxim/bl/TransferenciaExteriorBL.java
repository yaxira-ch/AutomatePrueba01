package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import proxim.be.ObjetosGenerales;
import proxim.be.TransferenciasExteriorBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class TransferenciaExteriorBL extends TransferenciasExteriorBE{
	boolean bandera;
	long LStr_HoraFin;
	long Lng_TiempoEjeCaso;
	long LStr_HoraInicio;
	ConexionBL objConexionBL = new ConexionBL();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	FirmarBL objFirmarBL =new FirmarBL();
	
	TransferenciaExteriorMapeo objTransferenciasExteriorMapeo=new TransferenciaExteriorMapeo();
	String strMensajeMostrarTK="";
	String strMensajeMostrarMonto="El monto y/o la moneda de la operación o de la cuenta de cargo no coincide con lo pactado en el número de ticket, por favor verifica y vuelve a intentar. (1901)";
	TransferenciaExteriorHistoricoBL objTransferenciaExteriorHistoricoBL= new TransferenciaExteriorHistoricoBL();
	static Map<String,String> mapValores;
	private static String TipoLog = null;
	

	
	
	public boolean realizarEnvio() throws SQLException, IOException{
		boolean banderaBancoIntermediario=false;
		Mdl_Variables.map= new HashMap<String,String>();
		boolean consultar1=false;
		boolean consultar2=false;
		boolean consultar3=false;
		bandera = true;
		try{			
			
			//---------------------------------------MENU---------------------------------------
			String txtMenu="/html/body/div[2]/div[2]/div/ul/li[6]/a/span";
			String txtSubMenu="/html/body/div[2]/div[2]/div/ul/li[6]/div/div/ul/li[1]/div[1]/a";
			FuncionesGenerales.MenuGeneralNew(txtMenu,txtSubMenu);
			
			/*objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[2]/div/ul/li[6]/a/span");
			System.out.println("Se seleccionó en Menu Comercio Exterior");
			Thread.sleep(2000);
			objObjetosGenerales.clickBoton(ObjetosGenerales.xpath, "/html/body/div[2]/div[2]/div/ul/li[6]/div/div/ul/li[1]/div[1]/a");
			System.out.println("Se seleccionó en Menu Transferencias al Exterior");		
			*/
			//objHeader.menuPrincipal("<IGNORE>", "Comercio Exterior", "Transferencias al Exterior");
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_SUBMENU1)){
				
				objTransferenciasExteriorMapeo.verificarCamObligatoriosNuevaSolicitud();
				LStr_HoraInicio = System.currentTimeMillis();	  
				if (objTransferenciasExteriorMapeo.seleccionarSubMenu1(GstrTXT_SUBMENU1)){	
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en "+GstrTXT_SUBMENU1);
					TipoLog="1";
				}else{
					TipoLog="0";								
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en "+GstrTXT_SUBMENU1);
				}
				LStr_HoraFin = System.currentTimeMillis();	  
    			Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (GstrTXT_SUBMENU1.equals("Solicitud Por Autorizar")){
				
				if(objTransferenciasExteriorMapeo.verificarPopUpSolAutorizarAviso()){
					LStr_HoraInicio = System.currentTimeMillis(); 
					String strResultadoPopUp=objTransferenciasExteriorMapeo.verificarMensajePopUpSolAutorizar();
					if (strResultadoPopUp.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(8,"Mensaje Correcto", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(8, "Mensaje Incorrecto, se muestra lo siguiente: "+strResultadoPopUp, "" ,"El botón IR A AUTORIZAR");
					}
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_IR_AUTORIZAR)){ 
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciasExteriorMapeo.irAutorizar()){ 
						objFuncionesGenerales.callPasosAcierto(1,"", "" ,"El botón IR A AUTORIZAR");
						TipoLog="1";
						objTransferenciasExteriorMapeo.verificarAutorizacionesPendientes();
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"El botón IR A AUTORIZAR");
					}
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_IR_CONSULTAR)){ 
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciasExteriorMapeo.irConsultar()){ 
						objFuncionesGenerales.callPasosAcierto(1,"", "" ,"El botón IR A CONSULTAR");
						TipoLog="1";
						objTransferenciasExteriorMapeo.verificarCamObligatoriosConHistorica();
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"El botón IR A CONSULTAR");
					}
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
				}

			}else{
			
			if (objFuncionesGenerales.verificarIgnore(GstrIND_EMPRESA)){		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (GstrIND_EMPRESA.equals("NO"))
				{ 
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_ORDENANTE))
				    {		          
						LStr_HoraInicio = System.currentTimeMillis();     
						if (objTransferenciasExteriorMapeo.seleccionarEmpresa( GstrTXT_NOMBRE_ORDENANTE))
						{ 
							objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrTXT_NOMBRE_ORDENANTE, "" ,"");
							TipoLog="1";
							Mdl_Variables.map.put("TXT_NOMBRE_ORDENANTE", GstrTXT_NOMBRE_ORDENANTE);
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrTXT_NOMBRE_ORDENANTE, "" ,"");
						}
						LStr_HoraFin = System.currentTimeMillis(); 
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				    }
				}
				
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DIRECCION_ORDENANTE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarDireccionOrdenante( GstrTXT_DIRECCION_ORDENANTE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"DIRECCION DEL ORDENANTE", GstrTXT_DIRECCION_ORDENANTE ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_DIRECCION_ORDENANTE", GstrTXT_DIRECCION_ORDENANTE);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "DIRECCION DEL ORDENANTE", GstrTXT_DIRECCION_ORDENANTE ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_TELEFONO_ORDENANTE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarTelefonoOrdenante( GstrTXT_TELEFONO_ORDENANTE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TELEFONO DEL ORDENANTE", GstrTXT_TELEFONO_ORDENANTE ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_TELEFONO_ORDENANTE", GstrTXT_TELEFONO_ORDENANTE);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "TELEFONO DEL ORDENANTE", GstrTXT_TELEFONO_ORDENANTE ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_EMAIL_ORDENANTE))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarEmailOrdenante( GstrTXT_EMAIL_ORDENANTE))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"EMAIL DEL ORDENANTE", GstrTXT_EMAIL_ORDENANTE ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_EMAIL_ORDENANTE", GstrTXT_EMAIL_ORDENANTE);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "EMAIL DEL ORDENANTE", GstrTXT_EMAIL_ORDENANTE ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
//			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))
//		    {		          
//				LStr_HoraInicio = System.currentTimeMillis();     
//				if (objTransferenciasExteriorMapeo.buscarMoneda( ))
//				{ 
//					objFuncionesGenerales.callPasosAcierto(8, "No se muestra moneda: REALES", "" ,"");
//					TipoLog="1";
//				}else{
//					TipoLog="0";
//					bandera = false;
//					objFuncionesGenerales.callPasosErrado(8,"Se muestra moneda: REALES", "" ,"");
//				}
//				LStr_HoraFin = System.currentTimeMillis(); 
//				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//				objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//				objTransferenciasExteriorMapeo.buscarMoneda( );
//		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarMoneda( GstrCMB_MONEDA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "MONEDA "+ GstrCMB_MONEDA, "" ,"");
					TipoLog="1";
					Mdl_Variables.map.put("CMB_MONEDA", GstrCMB_MONEDA);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "MONEDA "+ GstrCMB_MONEDA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			String strNuevoValorMonto="<IGNORE>";
			int intNuevoMonto=0;
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MINIMO))
			{       
				strNuevoValorMonto=GstrTXT_MONTO_MINIMO;
				intNuevoMonto=1;
			} else if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO)) { 
				strNuevoValorMonto=GstrTXT_MONTO_MAXIMO;
				intNuevoMonto=2;
			} else if(objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO)){  
				strNuevoValorMonto=GstrTXT_MONTO;
				intNuevoMonto=3;
			}
			
			if(!strNuevoValorMonto.equals("<IGNORE>"))
				Mdl_Variables.map.put("TXT_MONTO_INICIAL", strNuevoValorMonto);
			
			ingresarMonto(strNuevoValorMonto,intNuevoMonto);
			
//			if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO))
//			{       
//				LStr_HoraInicio = System.currentTimeMillis();        
//				if (objTransferenciasExteriorMapeo.ingresarMonto( GstrTXT_MONTO))
//				{ 
//					objFuncionesGenerales.callPasosAcierto(3,"MONTO", GstrTXT_MONTO ,"");
//					TipoLog="1";
//					String monto=GstrTXT_MONTO;
//					double prueba2=new Double(monto);
//					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
//					simbolo.setGroupingSeparator(',');
//					simbolo.setDecimalSeparator('.');
//					DecimalFormat formatea=new DecimalFormat("###,###.##",simbolo);
//					monto=formatea.format(prueba2);
//					if(monto.indexOf(".")!=-1){
//						int decimales=(monto.substring(monto.indexOf(".")+1,monto.length())).length();
//						if(decimales==1)
//							monto=monto+"0";
//					}else
//						monto=monto+".00";
//					map.put("TXT_MONTO", monto);
//				}else{
//					TipoLog="0";
//					bandera = false;
//					objFuncionesGenerales.callPasosErrado(3, "MONTO", GstrTXT_MONTO ,"");
//				}
//				LStr_HoraFin = System.currentTimeMillis();      
//				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
//				CapturarPantalla.CapturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
//				objSQL.Log_Detalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
//			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CARGO)){		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarCuentaCargo( GstrCMB_CUENTA_CARGO)){ 
					objFuncionesGenerales.callPasosAcierto(2, "CUENTA DE CARGO "+ GstrCMB_CUENTA_CARGO, "" ,"");
					TipoLog="1";
					Mdl_Variables.map.put("CMB_CUENTA_CARGO", GstrCMB_CUENTA_CARGO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "CUENTA DE CARGO "+ GstrCMB_CUENTA_CARGO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			
			if (objFuncionesGenerales.verificarIgnore(GstrLBL_TIPO_CAMBIO))
		    {		          
				Mdl_Variables.map.put("LBL_TIPO_CAMBIO", GstrLBL_TIPO_CAMBIO);				
		    }
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_TICKET))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.activarTicket())
				{ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"CHECK TICKET");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"CHECK TICKET");
				}
				Thread.sleep(5000);
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrIND_TIENE_TICKET))
			{       				    
				if (GstrIND_TIENE_TICKET.equals("NO")){
					LStr_HoraInicio = System.currentTimeMillis();    
					if(objTransferenciasExteriorMapeo.obtenerMensajeErrorTicket().equals(GstrTXT_MENSAJE_ERROR)){					
						objFuncionesGenerales.callPasosAcierto(5,objTransferenciasExteriorMapeo.obtenerMensajeErrorTicket(), GstrTXT_MENSAJE_ERROR ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, objTransferenciasExteriorMapeo.obtenerMensajeErrorTicket(), GstrTXT_MENSAJE_ERROR ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			}
			
		String strNumeroTicket="<IGNORE>";
		int intValor=0;	
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_INVALIDO))
			{       
				strNumeroTicket=GstrTXT_NUMERO_INVALIDO;
				intValor=1;
			} else if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_INCOMPLETO)) { 
				strNumeroTicket=GstrTXT_NUMERO_INCOMPLETO;
				intValor=2;
			} else if(objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_TICKET)){  
				strNumeroTicket=GstrTXT_NUMERO_TICKET;
				intValor=3;
			}
			
			//Ingresar Numero de TK
			ingresarNumeroTK(strNumeroTicket,intValor);
	
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_CARGO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();  
				
				String fecha=actualizarFechaCargo();
				
				if (objTransferenciasExteriorMapeo.ingresarFechaCargo(fecha))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"FECHA DE CARGO", fecha ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_FECHA_CARGO", fecha);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "FECHA DE CARGO", fecha ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}else{
				Date fechaActual=new Date();
				DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");		
				String fecha= formatoFecha.format(fechaActual);
				Mdl_Variables.map.put("TXT_FECHA_CARGO", fecha);
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_BENEFICIARIO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarNombreBeneficiario( GstrTXT_NOMBRE_BENEFICIARIO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"NOMBRE DE BENEFICIARIO", GstrTXT_NOMBRE_BENEFICIARIO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_NOMBRE_BENEFICIARIO", GstrTXT_NOMBRE_BENEFICIARIO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "NOMBRE DE BENEFICIARIO", GstrTXT_NOMBRE_BENEFICIARIO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
						
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DIRECCION_BENEFICIARIO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarDireccionBeneficiario( GstrTXT_DIRECCION_BENEFICIARIO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"DIRECCION DE BENEFICIARIO", GstrTXT_DIRECCION_BENEFICIARIO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_DIRECCION_BENEFICIARIO", GstrTXT_DIRECCION_BENEFICIARIO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "DIRECCION DE BENEFICIARIO", GstrTXT_DIRECCION_BENEFICIARIO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_PAIS_BENEFICIARIO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarPaisBeneficiario( GstrCMB_PAIS_BENEFICIARIO))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "PAIS DEL BENEFICIARIO "+ GstrCMB_PAIS_BENEFICIARIO, "" ,"");
					TipoLog="1";
					Mdl_Variables.map.put("CMB_PAIS_BENEFICIARIO", GstrCMB_PAIS_BENEFICIARIO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "PAIS DEL BENEFICIARIO "+ GstrCMB_PAIS_BENEFICIARIO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CIUDAD_BENEFICIARIO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarCiudadBeneficiario( GstrTXT_CIUDAD_BENEFICIARIO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"CIUDAD DE BENEFICIARIO", GstrTXT_CIUDAD_BENEFICIARIO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_CIUDAD_BENEFICIARIO", GstrTXT_CIUDAD_BENEFICIARIO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "CIUDAD DE BENEFICIARIO", GstrTXT_CIUDAD_BENEFICIARIO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_TELEFONO_BENEFICIARIO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarTelefonoBeneficiario( GstrTXT_TELEFONO_BENEFICIARIO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"TELEFONO DE BENEFICIARIO", GstrTXT_TELEFONO_BENEFICIARIO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_TELEFONO_BENEFICIARIO", GstrTXT_TELEFONO_BENEFICIARIO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "TELEFONO DE BENEFICIARIO", GstrTXT_TELEFONO_BENEFICIARIO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CUENTA_ABONO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarCuentaAbono( GstrTXT_CUENTA_ABONO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"CUENTA DE ABONO", GstrTXT_CUENTA_ABONO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_CUENTA_ABONO", GstrTXT_CUENTA_ABONO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "CUENTA DE ABONO", GstrTXT_CUENTA_ABONO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_BANCO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarNombreBanco( GstrTXT_NOMBRE_BANCO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"NOMBRE DEL BANCO BENEFICIARIO", GstrTXT_NOMBRE_BANCO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_NOMBRE_BANCO", GstrTXT_NOMBRE_BANCO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "NOMBRE DEL BANCO BENEFICIARIO", GstrTXT_NOMBRE_BANCO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_PAIS_BANCO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarPaisBanco( GstrCMB_PAIS_BANCO))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "PAIS DEL BANCO DEL BENEFICIARIO "+ GstrCMB_PAIS_BANCO, "" ,"");
					TipoLog="1";
					Mdl_Variables.map.put("CMB_PAIS_BANCO", GstrCMB_PAIS_BANCO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "PAIS DEL BANCO DEL BENEFICIARIO "+ GstrCMB_PAIS_BANCO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CIUDAD_BANCO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarCiudadBanco( GstrTXT_CIUDAD_BANCO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"CIUDAD DEL BANCO BENEFICIARIO", GstrTXT_CIUDAD_BANCO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_CIUDAD_BANCO", GstrTXT_CIUDAD_BANCO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "CIUDAD DEL BANCO BENEFICIARIO", GstrTXT_CIUDAD_BANCO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CODIGO_BANCO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarTipoCodigoBanco( GstrCMB_TIPO_CODIGO_BANCO))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "TIPO DE CÓDIGO DEL BANCO DEL BENEFICIARIO "+ GstrCMB_TIPO_CODIGO_BANCO, "" ,"");
					TipoLog="1";
					Mdl_Variables.map.put("CMB_TIPO_CODIGO_BANCO", GstrCMB_TIPO_CODIGO_BANCO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "TIPO DE CÓDIGO DEL BANCO DEL BENEFICIARIO "+ GstrCMB_TIPO_CODIGO_BANCO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CODIGO_BANCO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarCodigoBanco( GstrTXT_CODIGO_BANCO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"CÓDIGO DEL BANCO BENEFICIARIO", GstrTXT_CODIGO_BANCO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_CODIGO_BANCO", GstrTXT_CODIGO_BANCO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "CÓDIGO DEL BANCO BENEFICIARIO", GstrTXT_CODIGO_BANCO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCHK_BANCO_INTERMEDIARIO))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarBancoIntermediario( ))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "DESEO UTILIZAR UN BANCO INTERMEDIARIO "+ GstrCHK_BANCO_INTERMEDIARIO, "" ,"");
					TipoLog="1";
					banderaBancoIntermediario=true;					
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "DESEO UTILIZAR UN BANCO INTERMEDIARIO "+ GstrCHK_BANCO_INTERMEDIARIO, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if(banderaBancoIntermediario){
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_BANCO_INTERMEDIARIO))
				{       
					LStr_HoraInicio = System.currentTimeMillis();        
					if (objTransferenciasExteriorMapeo.ingresarNombreBancoIntermediario( GstrTXT_NOMBRE_BANCO_INTERMEDIARIO))
					{ 
						objFuncionesGenerales.callPasosAcierto(3,"NOMBRE DEL BANCO INTERMEDIARIO", GstrTXT_NOMBRE_BANCO_INTERMEDIARIO ,"");
						TipoLog="1";
						Mdl_Variables.map.put("TXT_NOMBRE_BANCO_INTERMEDIARIO", GstrTXT_NOMBRE_BANCO_INTERMEDIARIO);
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "NOMBRE DEL BANCO INTERMEDIARIO", GstrTXT_NOMBRE_BANCO_INTERMEDIARIO ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_PAIS_BANCO_INTERMEDIARIO))
			    {		          
					LStr_HoraInicio = System.currentTimeMillis();     
					if (objTransferenciasExteriorMapeo.seleccionarPaisBancoIntermediario( GstrCMB_PAIS_BANCO_INTERMEDIARIO))
					{ 
						objFuncionesGenerales.callPasosAcierto(2, "PAIS DEL BANCO INTERMEDIARIO "+ GstrCMB_PAIS_BANCO_INTERMEDIARIO, "" ,"");
						TipoLog="1";
						Mdl_Variables.map.put("CMB_PAIS_BANCO_INTERMEDIARIO", GstrCMB_PAIS_BANCO_INTERMEDIARIO);
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "PAIS DEL BANCO INTERMEDIARIO "+ GstrCMB_PAIS_BANCO_INTERMEDIARIO, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis(); 
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			    }				
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CIUDAD_BANCO_INTERMEDIARIO))
				{       
					LStr_HoraInicio = System.currentTimeMillis();        
					if (objTransferenciasExteriorMapeo.ingresarCiudadBancoIntermediario( GstrTXT_CIUDAD_BANCO_INTERMEDIARIO))
					{ 
						objFuncionesGenerales.callPasosAcierto(3,"CIUDAD DEL BANCO INTERMEDIARIO", GstrTXT_CIUDAD_BANCO_INTERMEDIARIO ,"");
						TipoLog="1";
						Mdl_Variables.map.put("TXT_CIUDAD_BANCO_INTERMEDIARIO", GstrTXT_CIUDAD_BANCO_INTERMEDIARIO);
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "CIUDAD DEL BANCO INTERMEDIARIO", GstrTXT_CIUDAD_BANCO_INTERMEDIARIO ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO))
			    {		          
					LStr_HoraInicio = System.currentTimeMillis();     
					if (objTransferenciasExteriorMapeo.seleccionarTipoCodigoBancoIntermediario( GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO))
					{ 
						objFuncionesGenerales.callPasosAcierto(2, "TIPO DE CÓDIGO DEL BANCO INTERMEDIARIO "+ GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO, "" ,"");
						TipoLog="1";
						Mdl_Variables.map.put("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO", GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO);
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(2, "TIPO DE CÓDIGO DEL BANCO INTERMEDIARIO "+ GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis(); 
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			    }
				
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CODIGO_BANCO_INTERMEDIARIO))
				{       
					LStr_HoraInicio = System.currentTimeMillis();        
					if (objTransferenciasExteriorMapeo.ingresarCodigoBancoIntermediario( GstrTXT_CODIGO_BANCO_INTERMEDIARIO))
					{ 
						objFuncionesGenerales.callPasosAcierto(3,"CÓDIGO DEL BANCO INTERMEDIARIO", GstrTXT_CODIGO_BANCO_INTERMEDIARIO ,"");
						TipoLog="1";
						Mdl_Variables.map.put("TXT_CODIGO_BANCO_INTERMEDIARIO", GstrTXT_CODIGO_BANCO_INTERMEDIARIO);
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "CÓDIGO DEL BANCO INTERMEDIARIO", GstrTXT_CODIGO_BANCO_INTERMEDIARIO ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}				
			}
			
			
			if (objFuncionesGenerales.verificarIgnore(GstrLBL_MENSAJE_PAIS))
			{       
		          
		          LStr_HoraInicio = System.currentTimeMillis();    
		          String mensaje=objTransferenciasExteriorMapeo.obtenerMensajePopup();
		          if (mensaje.equals(GstrLBL_MENSAJE_PAIS)){ 
		        	  objFuncionesGenerales.callPasosAcierto(5, mensaje, GstrLBL_MENSAJE_PAIS ,"");
		        	  TipoLog="1";
		        	  Thread.sleep(2000);
		          }else{
		        	  TipoLog="0";
		        	  bandera = false;
		        	  objFuncionesGenerales.callPasosErrado(5, mensaje, GstrLBL_MENSAJE_PAIS ,"");			        
		          }
		          LStr_HoraFin = System.currentTimeMillis();  
		          Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
		          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		          objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_POPUP_PAIS))
			{       
				LStr_HoraInicio = System.currentTimeMillis();  
				Thread.sleep(2000);
				if (objTransferenciasExteriorMapeo.cerrarPopupPais())
				{ 
					objFuncionesGenerales.callPasosAcierto(1,"", "" ,"CERRAR POPUP PAIS DEL BENEFICIARIO NO AFILIADO");
					TipoLog="1";
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"CERRAR POPUP PAIS DEL BENEFICIARIO NO AFILIADO");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MOTIVO_TRANSFERENCIA))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarMotivoTransferencia( GstrCMB_MOTIVO_TRANSFERENCIA))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "MOTIVO DE TRANSFERENCIA "+ GstrCMB_MOTIVO_TRANSFERENCIA, "" ,"");
					TipoLog="1";
					Mdl_Variables.map.put("CMB_MOTIVO_TRANSFERENCIA", GstrCMB_MOTIVO_TRANSFERENCIA);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "MOTIVO DE TRANSFERENCIA "+ GstrCMB_MOTIVO_TRANSFERENCIA, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_GASTOS_CORRESPONSAL))
		    {		          
				LStr_HoraInicio = System.currentTimeMillis();     
				if (objTransferenciasExteriorMapeo.seleccionarGastosCorresponsal( GstrCMB_GASTOS_CORRESPONSAL))
				{ 
					objFuncionesGenerales.callPasosAcierto(2, "GASTOS DEL CORRESPONSAL "+ GstrCMB_GASTOS_CORRESPONSAL, "" ,"");
					TipoLog="1";
					Mdl_Variables.map.put("CMB_GASTOS_CORRESPONSAL", GstrCMB_GASTOS_CORRESPONSAL);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "GASTOS DEL CORRESPONSAL "+ GstrCMB_GASTOS_CORRESPONSAL, "" ,"");
				}
				LStr_HoraFin = System.currentTimeMillis(); 
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
		    }
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DETALLE_PAGO))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarDetallePago( GstrTXT_DETALLE_PAGO))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"DETALLE DEL PAGO ", GstrTXT_DETALLE_PAGO ,"");
					TipoLog="1";
					Mdl_Variables.map.put("TXT_DETALLE_PAGO", GstrTXT_DETALLE_PAGO);
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "DETALLE DEL PAGO ", GstrTXT_DETALLE_PAGO ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_GUARDAR))
			{       
				if (objFuncionesGenerales.verificarIgnore("Guardar"))
				{ 
					LStr_HoraInicio = System.currentTimeMillis();        
					if (objTransferenciasExteriorMapeo.guardar( ))
					{ 
						if(objTransferenciasExteriorMapeo.obtenerMensaje().equals(GstrRESULTADO_ESPERADO_1)){
							objFuncionesGenerales.callPasosAcierto(5, "Obtenido: "+objTransferenciasExteriorMapeo.obtenerMensaje() , "Esperado: "+GstrRESULTADO_ESPERADO_1,"");
							TipoLog="1";
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(5, "Obtenido: "+objTransferenciasExteriorMapeo.obtenerMensaje() , "Esperado: "+GstrRESULTADO_ESPERADO_1,"");
						}
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1,"", "" ," Guardar Operación ");
					}
					CapturarPantalla.pageDown("-1000");
					LStr_HoraFin = System.currentTimeMillis();      
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				
				if (objFuncionesGenerales.verificarIgnore("Guardar")){
					LStr_HoraInicio = System.currentTimeMillis();    
					String valoresInc=objTransferenciasExteriorMapeo.verificarCamposLlenados(1);
					if (valoresInc.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, valoresInc, "" ,"");			        
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					CapturarPantalla.pageDown("400");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					
				}
				
				
				
				if (objFuncionesGenerales.verificarIgnore(GstrCONSULTA_HISTORICA))
				{ 
					Date fechaActual=new Date();
					DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
					String fecha= formatoFecha.format(fechaActual);
					objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "TXT_FECHA_DESDE_HISTORICA", fecha, GstrID_CASO);
					GstrTXT_FECHA_DESDE_HISTORICA=fecha;
					
					objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "TXT_FECHA_HASTA_HISTORICA", fecha, GstrID_CASO);
					GstrTXT_FECHA_HASTA_HISTORICA=fecha;
					
					objTransferenciaExteriorHistoricoBL.consultarHistorico("Operaciones no procesadas",Mdl_Variables.Gstr_Parametros[10],false);
				}
				
				
			
			}else{
				
				//boton Enviar
				botonEnviar();

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_INVALIDO))
				{      
					strMensajeMostrarTK="El número de ticket de autorización no existe. Por favor, verifica y vuelve a intentar (1905)";
					bandera=objTransferenciasExteriorMapeo.ingresarNumeroTicketInvalidoIncompleto(strMensajeMostrarTK,1);

					if (bandera&&objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_INCOMPLETO)){
						ingresarNumeroTK( GstrTXT_NUMERO_INCOMPLETO, 2);
						botonEnviar();
						strMensajeMostrarTK="Debes ingresar los 7 números del ticket de tipo de cambio especial";
						bandera=objTransferenciasExteriorMapeo.ingresarNumeroTicketInvalidoIncompleto(strMensajeMostrarTK,2);
						if (bandera&&objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_TICKET) ){
							ingresarNumeroTK( GstrTXT_NUMERO_TICKET, 3);
							botonEnviar();
						}
					}
				} else if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_INCOMPLETO)) { 
					strMensajeMostrarTK="Debes ingresar los 7 números del ticket de tipo de cambio especial";
					bandera=objTransferenciasExteriorMapeo.ingresarNumeroTicketInvalidoIncompleto(strMensajeMostrarTK,1);
					if (bandera&&objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_TICKET)){
						ingresarNumeroTK( GstrTXT_NUMERO_TICKET, 3);
						botonEnviar();
					}
				}

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MINIMO))
				{      
					bandera=objTransferenciasExteriorMapeo.ingresarNumeroTicketInvalidoIncompleto(strMensajeMostrarMonto,0);

					if (bandera&&objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO)){
						ingresarMonto( GstrTXT_MONTO_MAXIMO, 2);
						botonEnviar();
						bandera=objTransferenciasExteriorMapeo.ingresarNumeroTicketInvalidoIncompleto(strMensajeMostrarMonto,0);
						if (bandera&&objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO) ){
							ingresarMonto( GstrTXT_MONTO, 3);
							botonEnviar();
						}
					}
				} else if (objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO_MAXIMO)) { 
					bandera=objTransferenciasExteriorMapeo.ingresarNumeroTicketInvalidoIncompleto(strMensajeMostrarMonto,0);
					if (bandera&&objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO)){
						ingresarMonto( GstrTXT_MONTO, 3);
						botonEnviar();
					}
				}


				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO_1)){       
					String moneda="";
					mapValores= objFuncionesGenerales.obtenerDatosEmpresaVariante(GstrCMB_CUENTA_CARGO);
					String strMonedaCuenta=mapValores.get("strTipoMoneda");
					if(GstrCMB_MONEDA.equals("Dólares Americanos"))
						moneda="Dólares";
					if(!moneda.equals(strMonedaCuenta)){
						String valoresIncorrectos="";
						LStr_HoraInicio = System.currentTimeMillis();  
						valoresIncorrectos=objTransferenciasExteriorMapeo.validarTCK(GstrIND_TIENE_TICKET, GstrCMB_MONEDA, GstrCMB_CUENTA_CARGO,"Confirmacion");
					
						if (valoresIncorrectos.equals("")){ 
							objFuncionesGenerales.callPasosAcierto(7, "Arbitraje, mensaje y el valor.", "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
						}
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
				}

				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO_1))
				{       

					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );					
					CapturarPantalla.pageDown("400");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					LStr_HoraInicio = System.currentTimeMillis();    
					String valoresIncorrectos=objTransferenciasExteriorMapeo.verificarPantallaConfirmacion();
					if (valoresIncorrectos.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));					
				}

				if (objFuncionesGenerales.verificarIgnore(GstrLNK_TERMINOS_CONDICIONES))
				{       

					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.verTerminosCondiciones())		          { 
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Términos y Condiciones");
						TipoLog="1";	
						Thread.sleep(2000);
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"Términos y Condiciones");			        
					}	
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_TERMINOS_CONDICIONES))
				{       

					LStr_HoraInicio = System.currentTimeMillis();   

					if (objTransferenciasExteriorMapeo.cerrarTerminosCondiciones())
					{ 
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"CerrarPopup");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"CerrarPopup");
					}
					Thread.sleep(2000);
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_QUIERES_SABER_COMO))
				{       

					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.verQuieresSaberComo())		          { 
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"¿Quieres saber como?");
						TipoLog="1";
						Thread.sleep(2000);
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"¿Quieres saber como?");			        
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}	
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CERRAR_QUIERES_SABER_COMO))
				{       

					LStr_HoraInicio = System.currentTimeMillis();		          
					if (objTransferenciasExteriorMapeo.cerrarPopupQuieresSaberComo())		          { 
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Cerrar ¿Quieres saber como?");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"Cerrar ¿Quieres saber como?");			        
					}
					Thread.sleep(2000);
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrCHK_ACEPTO_TERMINOS_CONDICIONES))
				{       

					LStr_HoraInicio = System.currentTimeMillis();   
					if (objTransferenciasExteriorMapeo.aceptarTerminosCondiciones())
					{ 
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Acepto Términos y condiciones");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"Acepto Términos y condiciones");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE)){				
					LStr_HoraInicio = System.currentTimeMillis();   
					if (objTransferenciasExteriorMapeo.ingresarClave(GstrTXT_CLAVE)){	
						objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}else{		
					LStr_HoraInicio = System.currentTimeMillis();   
					if(!objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR)){
						if (objTransferenciasExteriorMapeo.ingresarClave(Mdl_Variables.Gstr_Clave)){	
							objFuncionesGenerales.callPasosAcierto(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
							TipoLog="1";
						}else{
							TipoLog="0";									
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "La contraseña ", Mdl_Variables.Gstr_Clave,"");
						}
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
				}
				CapturarPantalla.pageDown("400");
				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CLAVE_DINAMICA)){	
					LStr_HoraInicio = System.currentTimeMillis();   
					if (objTransferenciasExteriorMapeo.ingresarClaveDinamica(GstrTXT_CLAVE_DINAMICA)){	
						objFuncionesGenerales.callPasosAcierto(3, "La clave dinamica ", GstrTXT_CLAVE_DINAMICA,"");
						TipoLog="1";
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "La clave dinamica ", GstrTXT_CLAVE_DINAMICA,"");
					}
					Thread.sleep(5000);
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONFIRMAR)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciasExteriorMapeo.confirmar()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CONFIRMAR");
						TipoLog="1";
						Thread.sleep(600);
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CONFIRMAR");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrBTN_CANCELAR_OPERACION)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciasExteriorMapeo.cancelarOperacion()){	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón CANCELAR OPERACION");
						TipoLog="1";
						Thread.sleep(600);
					}else{
						TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón CANCELAR OPERACION");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if(objFuncionesGenerales.verificarIgnore(GstrTXT_COLUMNA_ERROR)){
					String strTexto = objTransferenciasExteriorMapeo.obtenerMensajeError(GstrTXT_COLUMNA_ERROR);
					if(objFuncionesGenerales.buscarCadena(GstrTXT_MENSAJE_ERROR, strTexto)){	
						objFuncionesGenerales.callPasosAcierto(7, "BPI:  "+strTexto +" Esperado:"+GstrTXT_MENSAJE_ERROR, "" ,"");						
					}else{
						objFuncionesGenerales.callPasosErrado(7, "BPI:  "+strTexto +" Esperado:"+GstrTXT_MENSAJE_ERROR, "" ,"");	
					}
				}
				CapturarPantalla.pageDown("-200");			
				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO_2))
				{       

					LStr_HoraInicio = System.currentTimeMillis();    
					String resultado=objTransferenciasExteriorMapeo.obtenerResultadoEsperado2();
					if (resultado.equals(GstrRESULTADO_ESPERADO_2)){ 
						objFuncionesGenerales.callPasosAcierto(5, GstrRESULTADO_ESPERADO_2, resultado ,"");
						TipoLog="1";

					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, GstrRESULTADO_ESPERADO_2, resultado ,"");			        
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO_2)){       
					//Map<String,String> aux;
					String moneda="";
					mapValores= objFuncionesGenerales.obtenerDatosEmpresaVariante(GstrCMB_CUENTA_CARGO);
					String strMonedaCuenta=mapValores.get("strTipoMoneda");
					if(GstrCMB_MONEDA.equals("Dólares Americanos"))
						moneda="Dólares";
					if(!moneda.equals(strMonedaCuenta)){
						LStr_HoraInicio = System.currentTimeMillis();    
						String valoresIncorrectos=objTransferenciasExteriorMapeo.validarTCK(GstrIND_TIENE_TICKET, GstrCMB_MONEDA, GstrCMB_CUENTA_CARGO,"ResultadoFinal");
						if (valoresIncorrectos.equals("")){ 
							objFuncionesGenerales.callPasosAcierto(7, "Arbitraje, mensaje y el valor.", "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
						}
						CapturarPantalla.pageDown("-200");
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}
				}

				//verificar campos tipo de transferencia y número de referencia
				if (objFuncionesGenerales.verificarIgnore(GstrRESULTADO_ESPERADO_2))
				{       

					LStr_HoraInicio = System.currentTimeMillis(); 
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );					
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					
					
					if(objFuncionesGenerales.verificarIgnore(GstrESTADO)){
						String valoresIncorrectos="";
						if( GstrFIRMAR.equals("NO")){
							valoresIncorrectos=objTransferenciasExteriorMapeo.verificarPantallaResultado(true);
						}else{
							valoresIncorrectos=objTransferenciasExteriorMapeo.verificarPantallaResultado(false);
						}
						if (valoresIncorrectos.equals("")){ 
							objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
							TipoLog="1";

							objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "LBL_OPERACION", objTransferenciasExteriorMapeo.obtenerOperacion(), GstrID_CASO);
							objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "LBL_FECHA", objTransferenciasExteriorMapeo.obtenerFecha(), GstrID_CASO);
							objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "LBL_HORA", objTransferenciasExteriorMapeo.obtenerHora(), GstrID_CASO);
							GstrLBL_NRO_REFERENCIA=objTransferenciasExteriorMapeo.obtenerNroReferencia();
							objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "LBL_NRO_REFERENCIA", GstrLBL_NRO_REFERENCIA, GstrID_CASO);
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
						}		          
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));	
					}
					
									
				}

				//-------------------EXPORTABLES Y PIE DE PAGINA-------------------------------

				if (objFuncionesGenerales.verificarIgnore(GstrLNK_ENVIAR_EMAIL)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciasExteriorMapeo.ingresarEnvioCorreo()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ENVIAR CORREO");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_CORREO_POPUP)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.ingresarTituloCorreo(GstrTXT_CORREO_POPUP)){
						objFuncionesGenerales.callPasosAcierto(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Titulo del Correo : " + GstrTXT_CORREO_POPUP, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrTXT_MENSAJE_POPUP)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.ingresarMensajeCorreo(GstrTXT_MENSAJE_POPUP)){
						objFuncionesGenerales.callPasosAcierto(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "El Mensaje del Correo : " + GstrTXT_MENSAJE_POPUP, "" ,"");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR_CORREO_POPUP)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.enviarCorreo()){
						Thread.sleep(3000);
						objTransferenciasExteriorMapeo.aceptarEnvio();
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en BOTON ENVIAR CORREO");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en BOTON ENVIAR CORREO");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				CapturarPantalla.pageDown("1200");

				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_EXCEL)){	
					LStr_HoraInicio = System.currentTimeMillis();   
					if (objTransferenciasExteriorMapeo.exportarExcel()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR EXCEL");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR EXCEL");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}

				if (objFuncionesGenerales.verificarIgnore(GstrLNK_EXPORTAR_PDF)){	
					LStr_HoraInicio = System.currentTimeMillis();  
					if (objTransferenciasExteriorMapeo.exportarPdf()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en EXPORTAR PDF");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en EXPORTAR PDF");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_IMPRIMIR)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.imprimir()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en IMPRIMIR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en IMPRIMIR");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_REALIZAR_OTRA_TRANSFERENCIA)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.realizarOtraTransferencia()){
						Thread.sleep(3000);
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en REALIZAR OTRA TRANSFERENCIA");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en REALIZAR OTRA TRANSFERENCIA");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					CapturarPantalla.pageDown("-200");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );

				}
					
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_AGREGAR_OPERACIONES_FRECUENTES)){	
					LStr_HoraInicio = System.currentTimeMillis();    
					if (objTransferenciasExteriorMapeo.agregarOperacionFrecuente()){
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en AGREGAR OPERACION FRECUENTE");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "", "" ,"en AGREGAR OPERACION FRECUENTE");
					}
					LStr_HoraFin = System.currentTimeMillis();  
					Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					CapturarPantalla.pageDown("-1000");
				
					String valoresIncorrectos=objTransferenciasExteriorMapeo.verificarDatosOF();
					if (valoresIncorrectos.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						TipoLog="1";
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
					}		    
					if (objFuncionesGenerales.verificarIgnore(GstrTXT_DESCRIPCION_OF))
					{       
						LStr_HoraInicio = System.currentTimeMillis();        
						if (objTransferenciasExteriorMapeo.ingresarDescripcionOF( GstrTXT_DESCRIPCION_OF))
						{ 
							objFuncionesGenerales.callPasosAcierto(3,"DESCRIPCIÓN DE OPERACIÓN FRECUENTE", GstrTXT_DESCRIPCION_OF ,"");
							TipoLog="1";
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(3, "DESCRIPCIÓN DE OPERACIÓN FRECUENTE", GstrTXT_DESCRIPCION_OF ,"");
						}
						LStr_HoraFin = System.currentTimeMillis();      
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
						CapturarPantalla.pageDown("600");
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						CapturarPantalla.pageDown("600");
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					}
					if (objFuncionesGenerales.verificarIgnore(GstrBTN_CONTINUAR_OF)){	
						LStr_HoraInicio = System.currentTimeMillis();    
						if (objTransferenciasExteriorMapeo.continuarOF()){
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en CONTINUAR OPERACION FRECUENTE");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en CONTINUAR OPERACION FRECUENTE");
						}
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
						
					}
					String valoresIncorrectos2=objTransferenciasExteriorMapeo.verificarDatosOFResultado(GstrTXT_DESCRIPCION_OF);
					if (valoresIncorrectos2.equals("")){ 
						objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
						TipoLog="1";
						GstrLBL_IDENTIFICADOR_OF=objTransferenciasExteriorMapeo.obtenerIdOF();
						objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "LBL_IDENTIFICADOR_OF", GstrLBL_IDENTIFICADOR_OF, GstrID_CASO);
						Thread.sleep(1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						CapturarPantalla.pageDown("600");
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					}else{
						TipoLog="0";
						bandera = false;
						objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos2, "" ,"");			        
					}					
					
					if (objFuncionesGenerales.verificarIgnore(GstrLNK_REALIZAR_OTRA_TRANSF_OF)){	
						LStr_HoraInicio = System.currentTimeMillis();    
						if (objTransferenciasExteriorMapeo.realizarOtraTransferenciaOF()){
							objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en REALIZAR OTRA TRANSFERENCIA");
							TipoLog="1";
						}else{
							TipoLog="0";			
							bandera = false;
							objFuncionesGenerales.callPasosErrado(1, "", "" ,"en REALIZAR OTRA TRANSFERENCIA");
						}
						LStr_HoraFin = System.currentTimeMillis();  
						Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
						CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
						objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					}	
					verOperacionFrecuente(true);
				}				
				
				if (objFuncionesGenerales.verificarIgnore(GstrCONSULTA_HISTORICA_ENVIO)){ 
					if(bandera && GstrFIRMAR.equals("SI")){
						realizarHistorico("Operaciones no procesadas",Mdl_Variables.Gstr_Parametros[11],false);
					}else{
						realizarHistorico("Operaciones no procesadas",GstrESTADO,false);
					}
				}
				
				if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION)){	
					objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
				}
								
				if(bandera && GstrFIRMAR.equals("SI")){					
					
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


					if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE1)){
						if (GstrFIRMANTE1.equals("PORT") || GstrFIRMANTE1.equals("PORT-B") ){
							bandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",GstrID_CASO,"F1' AND LBL_TIPO_OPERACION='Comercio Exterior",consultar1,null,null,null);
						}else{
							bandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",GstrID_CASO,"F1","Transferencia al exterior",consultar1);
						}
					}

					if(bandera){
						if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE2)){
							if (GstrFIRMANTE2.equals("PORT") || GstrFIRMANTE2.equals("PORT-B") ){
								bandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",GstrID_CASO,"F2' AND LBL_TIPO_OPERACION='Comercio Exterior",consultar2,null,null,null);
							}else{
								bandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",GstrID_CASO,"F2","Transferencia al exterior",consultar2);
							}
						}

						if(bandera){
							if (objFuncionesGenerales.verificarIgnore(GstrFIRMANTE3)){
								if (GstrFIRMANTE3.equals("PORT") || GstrFIRMANTE3.equals("PORT-B") ){
									bandera=objFirmarBL.firmaAutorizacionesPortabilidad("APP_AUTORIZACIONES_PORTABILIDAD_D",GstrID_CASO,"F3' AND LBL_TIPO_OPERACION='Comercio Exterior",consultar3,null,null,null);
								}else{
									bandera=objFirmarBL.firmaAutorizaciones("APP_AND_AUTORIZACIONES_PENDIENTES_D",GstrID_CASO,"F3","Transferencia al exterior",consultar3);
								}
							}
						}
					}
				}
			}
			
			//---------------------------------------------------------
		
			}
			
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}

	public boolean consultarHistorico() throws SQLException, IOException{
		try{
			Mdl_Variables.map= new HashMap<String,String>();
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_ORDENANTE))
				Mdl_Variables.map.put("TXT_NOMBRE_ORDENANTE", GstrTXT_NOMBRE_ORDENANTE);
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_DIRECCION_ORDENANTE))
				Mdl_Variables.map.put("TXT_DIRECCION_ORDENANTE", GstrTXT_DIRECCION_ORDENANTE);
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_TELEFONO_ORDENANTE)) 
				Mdl_Variables.map.put("TXT_TELEFONO_ORDENANTE", GstrTXT_TELEFONO_ORDENANTE);
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_EMAIL_ORDENANTE))
				Mdl_Variables.map.put("TXT_EMAIL_ORDENANTE", GstrTXT_EMAIL_ORDENANTE);
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_MONEDA))
				Mdl_Variables.map.put("CMB_MONEDA", GstrCMB_MONEDA);
			if(objFuncionesGenerales.verificarIgnore(GstrTXT_MONTO)){
				Mdl_Variables.map.put("TXT_MONTO_INICIAL", GstrTXT_MONTO);
				Mdl_Variables.map.put("TXT_MONTO", formatearMonto(GstrTXT_MONTO));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_CUENTA_CARGO))
				Mdl_Variables.map.put("CMB_CUENTA_CARGO", GstrCMB_CUENTA_CARGO);
			if (objFuncionesGenerales.verificarIgnore(GstrLBL_TIPO_CAMBIO))	          
				Mdl_Variables.map.put("LBL_TIPO_CAMBIO", GstrLBL_TIPO_CAMBIO);				
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_FECHA_CARGO)){
				//String fecha=actualizarFechaCargo();
				Mdl_Variables.map.put("TXT_FECHA_CARGO", GstrTXT_FECHA_CARGO);
			}
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_BENEFICIARIO))
				Mdl_Variables.map.put("TXT_NOMBRE_BENEFICIARIO", GstrTXT_NOMBRE_BENEFICIARIO);
			/*if (objFuncionesGenerales.verificarIgnore( GstrCMB_TIPO_DOCUMENTO_BENEFICIARIO))
				Mdl_Variables.map.put("CMB_TIPO_DOCUMENTO_BENEFICIARIO", GstrCMB_TIPO_DOCUMENTO_BENEFICIARIO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NUMERO_DOCUMENTO_BENEFICIARIO))
				Mdl_Variables.map.put("TXT_NUMERO_DOCUMENTO_BENEFICIARIO", GstrTXT_NUMERO_DOCUMENTO_BENEFICIARIO);*/
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DIRECCION_BENEFICIARIO))
				Mdl_Variables.map.put("TXT_DIRECCION_BENEFICIARIO", GstrTXT_DIRECCION_BENEFICIARIO);
			if (objFuncionesGenerales.verificarIgnore(GstrCMB_PAIS_BENEFICIARIO))
				Mdl_Variables.map.put("CMB_PAIS_BENEFICIARIO", GstrCMB_PAIS_BENEFICIARIO);
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CIUDAD_BENEFICIARIO))
				Mdl_Variables.map.put("TXT_CIUDAD_BENEFICIARIO", GstrTXT_CIUDAD_BENEFICIARIO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_TELEFONO_BENEFICIARIO))
				Mdl_Variables.map.put("TXT_TELEFONO_BENEFICIARIO", GstrTXT_TELEFONO_BENEFICIARIO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CUENTA_ABONO))
				Mdl_Variables.map.put("TXT_CUENTA_ABONO", GstrTXT_CUENTA_ABONO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRE_BANCO))
				Mdl_Variables.map.put("TXT_NOMBRE_BANCO", GstrTXT_NOMBRE_BANCO);
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_PAIS_BANCO))
				Mdl_Variables.map.put("CMB_PAIS_BANCO", GstrCMB_PAIS_BANCO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CIUDAD_BANCO))
				Mdl_Variables.map.put("TXT_CIUDAD_BANCO", GstrTXT_CIUDAD_BANCO);
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_TIPO_CODIGO_BANCO))
				Mdl_Variables.map.put("CMB_TIPO_CODIGO_BANCO", GstrCMB_TIPO_CODIGO_BANCO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CODIGO_BANCO))
				Mdl_Variables.map.put("TXT_CODIGO_BANCO", GstrTXT_CODIGO_BANCO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_NOMBRE_BANCO_INTERMEDIARIO))
				Mdl_Variables.map.put("TXT_NOMBRE_BANCO_INTERMEDIARIO", GstrTXT_NOMBRE_BANCO_INTERMEDIARIO);
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_PAIS_BANCO_INTERMEDIARIO)) 
				Mdl_Variables.map.put("CMB_PAIS_BANCO_INTERMEDIARIO", GstrCMB_PAIS_BANCO_INTERMEDIARIO);
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_CIUDAD_BANCO_INTERMEDIARIO))
				Mdl_Variables.map.put("TXT_CIUDAD_BANCO_INTERMEDIARIO", GstrTXT_CIUDAD_BANCO_INTERMEDIARIO);
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO))
				Mdl_Variables.map.put("CMB_TIPO_CODIGO_BANCO_INTERMEDIARIO", GstrCMB_TIPO_CODIGO_BANCO_INTERMEDIARIO);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_CODIGO_BANCO_INTERMEDIARIO))
				Mdl_Variables.map.put("TXT_CODIGO_BANCO_INTERMEDIARIO", GstrTXT_CODIGO_BANCO_INTERMEDIARIO);
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_MOTIVO_TRANSFERENCIA))
				Mdl_Variables.map.put("CMB_MOTIVO_TRANSFERENCIA", GstrCMB_MOTIVO_TRANSFERENCIA);
			if (objFuncionesGenerales.verificarIgnore( GstrCMB_GASTOS_CORRESPONSAL))
				Mdl_Variables.map.put("CMB_GASTOS_CORRESPONSAL", GstrCMB_GASTOS_CORRESPONSAL);
			if (objFuncionesGenerales.verificarIgnore( GstrTXT_DETALLE_PAGO))
				Mdl_Variables.map.put("TXT_DETALLE_PAGO", GstrTXT_DETALLE_PAGO);
			if (objFuncionesGenerales.verificarIgnore(GstrTXT_NUMERO_TICKET))
				Mdl_Variables.map.put("TXT_NUMERO_TICKET", GstrTXT_NUMERO_TICKET);
			
			realizarHistorico(GstrCMB_TIPO_CONSULTA_HISTORICA,Mdl_Variables.Gstr_Ignore,true);
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}
	
	public boolean realizarHistorico(String tipoConsulta,String estado,boolean indOtraOpcion) throws SQLException, IOException{
		
		try{
			if(!objFuncionesGenerales.verificarIgnore(TransferenciasExteriorBE.GstrIND_SOLO_HISTORICA)){
				Date fechaActual=new Date();
				DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
				String fecha= formatoFecha.format(fechaActual);
				objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "TXT_FECHA_DESDE_HISTORICA", fecha, GstrID_CASO);
				GstrTXT_FECHA_DESDE_HISTORICA=fecha;
				
				objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "TXT_FECHA_HASTA_HISTORICA", fecha, GstrID_CASO);
				GstrTXT_FECHA_HASTA_HISTORICA=fecha;
			}
			objTransferenciaExteriorHistoricoBL.consultarHistorico(tipoConsulta,estado,indOtraOpcion);
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
		
	}
	
	void botonEnviar(){
		
		 try {
			 if (objFuncionesGenerales.verificarIgnore(GstrBTN_ENVIAR))
				{       
			          
			          LStr_HoraInicio = System.currentTimeMillis();    
			          if (objTransferenciasExteriorMapeo.enviar())		          { 
			        	  objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Enviar");
			        	  TipoLog="1";
			          }else{
			        	  TipoLog="0";
			        	  bandera = false;
			        	  objFuncionesGenerales.callPasosErrado(1, "", "" ,"Enviar");			        
			          }
			          CapturarPantalla.pageDown("-200");
			          LStr_HoraFin = System.currentTimeMillis();  
			          Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
			          CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			          objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	void ingresarNumeroTK(String strNumeroTK,int intValor){
		try {
			if(objFuncionesGenerales.verificarIgnore(strNumeroTK)){  
				
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarNumeroTicket( strNumeroTK))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"NUMERO DE TICKET", strNumeroTK ,"");
					TipoLog="1";
					if(intValor==3){
						Mdl_Variables.map.put("TXT_NUMERO_TICKET", strNumeroTK);
					}
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "NUMERO DE TICKET", strNumeroTK ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void ingresarMonto(String strMonto,int intValor){
		try {
			
			if (objFuncionesGenerales.verificarIgnore(strMonto))
			{       
				LStr_HoraInicio = System.currentTimeMillis();        
				if (objTransferenciasExteriorMapeo.ingresarMonto( strMonto))
				{ 
					objFuncionesGenerales.callPasosAcierto(3,"MONTO", strMonto ,"");
					TipoLog="1";
					if(intValor==3){
						String monto=formatearMonto(strMonto);
						Mdl_Variables.map.put("TXT_MONTO", monto);
						Mdl_Variables.GstrTotalPagar=monto;
					}
				}else{
					TipoLog="0";
					bandera = false;
					objFuncionesGenerales.callPasosErrado(3, "MONTO", strMonto ,"");
				}
				LStr_HoraFin = System.currentTimeMillis();      
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String formatearMonto(String strMonto){
		String monto=strMonto;
		double prueba2=new Double(monto);
		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		simbolo.setGroupingSeparator(',');
		simbolo.setDecimalSeparator('.');
		DecimalFormat formatea=new DecimalFormat("###,###.##",simbolo);
		monto=formatea.format(prueba2);
		if(monto.indexOf(".")!=-1){
			int decimales=(monto.substring(monto.indexOf(".")+1,monto.length())).length();
			if(decimales==1)
				monto=monto+"0";
		}else
			monto=monto+".00";
		return monto;
	}
	
	public String actualizarFechaCargo() throws ParseException{
		Date fechaActual=new Date();
		DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");		
		SimpleDateFormat objSimpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date fechaBD=objSimpleDateFormat.parse(GstrTXT_FECHA_CARGO);
		
		String fecha;
		if(fechaBD.before(fechaActual)){
			fecha= formatoFecha.format(fechaActual);
			objSQL.actualizarTabla("APP_TRANSFERENCIAS_EXTERIOR", "TXT_FECHA_CARGO", fecha, GstrID_CASO);
		}else
			fecha=GstrTXT_FECHA_CARGO;
		
		return fecha;
	}
	
	public boolean consultarOF() throws SQLException, IOException{
		try{
			
			objHeader.menuPrincipal( "<IGNORE>","Comercio Exterior", "Transferencias al Exterior");
			
			verOperacionFrecuente(false);
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(GstrLNK_CERRAR_SESION,GstrLNK_CERRAR_SESION);
			}
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}

	public boolean verOperacionFrecuente(boolean indFlujoCompleto) throws SQLException, IOException{
		try{
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_OPERACIONES_FRECUENTES)){	
				
				if (objFuncionesGenerales.verificarIgnore(GstrIND_EMPRESA))
			    {		          
					LStr_HoraInicio = System.currentTimeMillis();     
					if (GstrIND_EMPRESA.equals("NO"))
					{ 
						if (objFuncionesGenerales.verificarIgnore(GstrTXT_NOMBRE_ORDENANTE))
					    {		          
							LStr_HoraInicio = System.currentTimeMillis();     
							if (objTransferenciasExteriorMapeo.seleccionarEmpresa( GstrTXT_NOMBRE_ORDENANTE))
							{ 
								objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ GstrTXT_NOMBRE_ORDENANTE, "" ,"");
								TipoLog="1";
							}else{
								TipoLog="0";
								bandera = false;
								objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ GstrTXT_NOMBRE_ORDENANTE, "" ,"");
							}
							LStr_HoraFin = System.currentTimeMillis(); 
							Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
							CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
							objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
					    }
					}
					
			    }
					
				CapturarPantalla.pageDown("-600");
				LStr_HoraInicio = System.currentTimeMillis(); 
				if (objTransferenciasExteriorMapeo.verOperacionesFrecuentes()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en VER OPERACIONES FRECUENTES");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en VER OPERACIONES FRECUENTES");
				}
				Thread.sleep(500);
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrLNK_VER_OPERACIONES_FRECUENTES)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				//if (objTransferenciasExteriorMapeo.seleccionarOF(GstrLBL_IDENTIFICADOR_OF)){
				if (objTransferenciasExteriorMapeo.seleccionarOF(GstrTXT_DESCRIPCION_OF)){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en SELECCIONAR OPERACION FRECUENTE");
					TipoLog="1";
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en SELECCIONAR OPERACION FRECUENTE");
				}
				Thread.sleep(500);
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
			if (objFuncionesGenerales.verificarIgnore(GstrBTN_ACEPTAR_OF)){	
				LStr_HoraInicio = System.currentTimeMillis();    
				if (objTransferenciasExteriorMapeo.aceptarOF()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en ACEPTAR OPERACION FRECUENTE");
					TipoLog="1";
					CapturarPantalla.pageDown("-100");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );					
					CapturarPantalla.pageDown("400");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					CapturarPantalla.pageDown("600");
					CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
					
					if(indFlujoCompleto){
						String valoresInc=objTransferenciasExteriorMapeo.verificarCamposLlenados(2);
						if (valoresInc.equals("")){ 
							objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
							TipoLog="1";
						}else{
							TipoLog="0";
							bandera = false;
							objFuncionesGenerales.callPasosErrado(7, valoresInc, "" ,"");			        
						}
					}
				}else{
					TipoLog="0";			
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en ACEPTAR OPERACION FRECUENTE");
				}
				LStr_HoraFin = System.currentTimeMillis();  
				Lng_TiempoEjeCaso = (LStr_HoraFin- LStr_HoraInicio)/ (1000);
				objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),Long.toString(LStr_HoraInicio));
			}
		}catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
	}
}