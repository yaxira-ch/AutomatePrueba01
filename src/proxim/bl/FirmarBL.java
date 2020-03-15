package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import proxim.be.AutorizacionesPendientesBE;
import proxim.be.ComercioExtCartaFianzaRenovacionAutorizarBE;
import proxim.be.ContratosDigitalesAutorizarBE;
import proxim.be.FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE;
import proxim.be.FinanciamientoDesembolsoLineaAutorizarBE;
import proxim.be.FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE;
import proxim.be.PagosDocumentosAutorizarBE;
import proxim.be.PagosMasivosAdministracionAfiliadosBE;
import proxim.be.PagosMasivosBE;
import proxim.be.PagosRecibosAutorizarBE;
import proxim.be.PortabilidadAutorizacionBE;
import proxim.be.TransferenciaAutorizarBE;
import proxim.be.TransferenciaBE;
import proxim.dao.*;

public class FirmarBL {
	TransferenciaAutorizarBE objTransferenciaAutorizacionBL = new TransferenciaAutorizarBE();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	LoginBL2 objLogin = new LoginBL2();
	TransferenciaAutorizarBL objTransferenciaAutorizarBL =new TransferenciaAutorizarBL();
	AutorizacionesPendientesBE objAutorizacionesBL =new AutorizacionesPendientesBE();
	AutorizacionesPendientesBL objAutAutorizacionesPendientesBL =new AutorizacionesPendientesBL();
	PagosMasivosBE objEnviosBL = new PagosMasivosBE();
	FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE objFinanDescuentosCobEnvioPlanillasAutorizarBL = new FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE();
	FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE objFinanDocumentosEleEnvioPlanillasAutorizarBL = new FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE();
	PortabilidadAutorizacionBE objPortabilidadAutorizacionBL = new PortabilidadAutorizacionBE();
	FinanciamientoDesembolsoLineaAutorizarBE objFinanDesembolsoLineaAutorizarBL = new FinanciamientoDesembolsoLineaAutorizarBE();
	PagosRecibosAutorizarBE objPagRecibosAutorizarBL= new PagosRecibosAutorizarBE();
	PagosDocumentosAutorizarBE objPagDocumentosAutorizarBL= new PagosDocumentosAutorizarBE();
	PagosMasivosAutorizarBL objPagosMasivosAutorizarBL=new PagosMasivosAutorizarBL();
	FinanciamientoDescuentosCobEnvioPlanillasAutorizarBL objFinanciamientoDescuentosCobEnvioPlanillasAutorizarBL=new FinanciamientoDescuentosCobEnvioPlanillasAutorizarBL();
	FinanciamientoDocumentosEleEnvioPlanillasAutorizarBL objFinanciamientoDocumentosEleEnvioPlanillasAutorizarBL=new FinanciamientoDocumentosEleEnvioPlanillasAutorizarBL();
	PortabilidadAutorizacionBL objPortabilidadAutorizacionGeneralBL=new PortabilidadAutorizacionBL();
	FinanciamientoDesembolsoLineaAutorizarBL objFinanciamientoDesembolsoLineaAutorizarBL=new FinanciamientoDesembolsoLineaAutorizarBL();
	PagosRecibosAutorizarBL objPagosRecibosAutorizarBL=new PagosRecibosAutorizarBL();
	PagosMasivosProcesadosBL objPagosMasivosProcesadosBL=new PagosMasivosProcesadosBL();
	ComercioExtCartaFianzaRenovacionAutorizarBE objComerExtCartaFianzaSolicitudAutorizarBL=new ComercioExtCartaFianzaRenovacionAutorizarBE();
	TransferenciaConsultaHistoricaBL objTransferenciaConsultaHistoricaBL= new TransferenciaConsultaHistoricaBL();
	PagosMasivosBloqueadosBL ObjPagosMasivosBloqueadosBL=new PagosMasivosBloqueadosBL();
	FinanciamientoDesembolsoLineaProcesadasBL objFinanciamientoDesembolsoLineaProcesadasBL=new FinanciamientoDesembolsoLineaProcesadasBL();
	FinanciamientoDesembolsoLineaBloqueadasBL objFinanciamientoDesembolsoLineaBloqueadasBL=new FinanciamientoDesembolsoLineaBloqueadasBL();
	PagosRecibosProcesadosBL objPagosRecibosProcesadosBL=new PagosRecibosProcesadosBL();
	PagosRecibosBloqueadosBL objPagosRecibosBloqueadosBL=new PagosRecibosBloqueadosBL();
	PagosDocumentosAutorizarBL objPagoDocumentosAutorizarBL=new PagosDocumentosAutorizarBL();
	ComercioExtCartaFianzaSolicitudAutorizarBL objComercioExtCartaFianzaSolicitudAutorizarBL=new ComercioExtCartaFianzaSolicitudAutorizarBL();
	ComercioExtCartaFianzaRenovacionAutorizarBL objComercioExtCartaFianzaRenovacionAutorizarBL= new ComercioExtCartaFianzaRenovacionAutorizarBL();
	ContratosDigitalesAutorizarBE objContratosDigitalesAutorizarBE=new ContratosDigitalesAutorizarBE();
	ContratosDigitalesAutorizarBL objContratosDigitalesAutorizarBL=new ContratosDigitalesAutorizarBL();
	String fecha;

	public boolean firmaTransferencia(String tabla, String id_caso, String firmante,boolean consultar) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			id_caso="'"+id_caso+"'";
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and CMB_TIPO_TRANSFERENCIA='"+TransferenciaBE.GstrLNK_ENVIO_TRANSFERENCIA+"' and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				Lbln_Bandera = objTransferenciaAutorizacionBL.obtenerCamposBD(Mdl_Variables.Grst_Firmante, 1);//CAPTURA TODOS LOS CALORES PARA REALIZAR LA AUTORIZACION
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(TransferenciaAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
					while (Mdl_Variables.Grst_TablaLogin.next()==true) {	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
			    		
						if (Lbln_Bandera)
							actualizarFechaConsulta( tabla,  id_caso);
							objSQL.updateTablaQuery("update "+tabla+ " set TXT_FECHA_SOLICITUD_DESDE='"+ fecha+"' where id_caso_lote="+ id_caso);							
							objSQL.updateTablaQuery("update "+tabla+ " set TXT_FECHA_SOLICITUD_HASTA='"+ fecha+"' where id_caso_lote="+ id_caso);
							TransferenciaAutorizarBE.GstrTXT_FECHA_SOLICITUD_DESDE=fecha;
							TransferenciaAutorizarBE.GstrTXT_FECHA_SOLICITUD_HASTA=fecha;
							Lbln_Bandera = objTransferenciaAutorizarBL.transferenciaAutorizarGeneral(2,consultar);
					}
				
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean firmaAutorizaciones(String tabla, String id_caso, String firmante,String tipoProducto,boolean consultar) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			id_caso="'"+id_caso+"'";
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" AND TIPO_PRODUCTO='"+tipoProducto+"' and FIRMANTE='"+firmante+"' ","",4);
			
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				Lbln_Bandera =objAutorizacionesBL.obtenerCamposBD(Mdl_Variables.Grst_Firmante, 1);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(AutorizacionesPendientesBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
					while (Mdl_Variables.Grst_TablaLogin.next()==true){	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objAutAutorizacionesPendientesBL.autorizacionesPendientes(2,consultar);
			    	}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	
	public boolean firmaContratosDigitales(String tabla, String id_caso, String firmante,boolean consultar,String codigoSolicitud) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			id_caso="'"+id_caso+"'";
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				Lbln_Bandera =objContratosDigitalesAutorizarBE.ContratosDigitalesAutorizar(Mdl_Variables.Grst_Firmante);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(ContratosDigitalesAutorizarBE.GstrID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
					while (Mdl_Variables.Grst_TablaLogin.next()==true){	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objContratosDigitalesAutorizarBL.contratosDigitalesAutorizar(consultar,codigoSolicitud);
			    	}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean firmaAutorizacionesPortabilidad(String tabla, String id_caso, String firmante,boolean consulta,String consultarSaldos,String cuentaOrigen,String cuentaDestino) throws InterruptedException, IOException{		
		boolean Lbln_Bandera=true;
		try {
			id_caso="'"+id_caso+"'";
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true){
				Lbln_Bandera = objPortabilidadAutorizacionBL.Portabilidad(Mdl_Variables.Grst_Firmante);
				
				if (Lbln_Bandera)
					Lbln_Bandera = objPortabilidadAutorizacionGeneralBL.autorizacionesPendientes(2,consulta,consultarSaldos);
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean firmaPagos(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				Lbln_Bandera = objEnviosBL.obtenerCamposBD(Mdl_Variables.Grst_Firmante, 2);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(PagosMasivosBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true) { //SACA VALORES DEL LOGIN
			    		
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera){ 
							FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
							if (objFuncionesGenerales.verificarIgnore(PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO)){
								PagosMasivosBE.GstrTXT_FECHA_FIN=PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO;
								PagosMasivosBE.GstrTXT_FECHA_INICIO=PagosMasivosAdministracionAfiliadosBE.GstrTXT_FECHA_DIFERIDO;
							}else{
								actualizarFechaConsulta(tabla, id_caso);
								objSQL.updateTablaQuery("update "+tabla+ " set TXT_FECHA_INICIO='"+ fecha+"' where id_caso_lote="+ id_caso);								
								objSQL.updateTablaQuery("update "+tabla+ " set TXT_FECHA_FIN='"+ fecha+"' where id_caso_lote="+ id_caso);
								PagosMasivosBE.GstrTXT_FECHA_INICIO=fecha;
								PagosMasivosBE.GstrTXT_FECHA_FIN=fecha;
							}
							Lbln_Bandera = objPagosMasivosAutorizarBL.administracionPagosPorAutorizar(2,consulta);
						}
			    	}
				
	    		}
	
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean descuentosCobranzas(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) 
			{
				Lbln_Bandera = objFinanDescuentosCobEnvioPlanillasAutorizarBL.FinanDescuentosCobEnvioPlanillasAutorizar(Mdl_Variables.Grst_Firmante, 2);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(FinanciamientoDescuentosCobEnvioPlanillasAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true) //SACA VALORES DEL LOGIN
			    	{	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objFinanciamientoDescuentosCobEnvioPlanillasAutorizarBL.financiamientoDescuentosCobEnvioPlanillasAutorizar(consulta);
			    	}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	
	public boolean documentosElectronicos(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) 			{
				Lbln_Bandera = objFinanDocumentosEleEnvioPlanillasAutorizarBL.FinanDocumentosEleEnvioPlanillasAutorizar(Mdl_Variables.Grst_Firmante, 2);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(FinanciamientoDocumentosEleEnvioPlanillasAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true) { //SACA VALORES DEL LOGIN
			    		
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objFinanciamientoDocumentosEleEnvioPlanillasAutorizarBL.financiamientoDocumentosEleEnvioPlanillasAutorizar(2,consulta);
					}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean cartaFianza(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' and TXT_SUBMENU='Solicitud de Carta Fianza'","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				Lbln_Bandera = objComerExtCartaFianzaSolicitudAutorizarBL.ComerExtCartaFianzaSolicitudAutorizar(Mdl_Variables.Grst_Firmante, 2);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(ComercioExtCartaFianzaRenovacionAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true){	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objComercioExtCartaFianzaSolicitudAutorizarBL.comercioExtCartaFianzaSolicitudAutorizar(2,consulta);
					}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean cartaFianzaRenovacion(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' and TXT_SUBMENU='Solicitud de Renovación'","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) 
			{
				Lbln_Bandera = objComerExtCartaFianzaSolicitudAutorizarBL.ComerExtCartaFianzaSolicitudAutorizar(Mdl_Variables.Grst_Firmante, 2);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(ComercioExtCartaFianzaRenovacionAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true) {	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objComercioExtCartaFianzaRenovacionAutorizarBL.comercioExtCartaFianzaRenovacionAutorizar(2,consulta);
			    	}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean firmaFinanciamiento(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) 	{
				Lbln_Bandera = objFinanDesembolsoLineaAutorizarBL.FinanDesembolsoLineaAutorizar(Mdl_Variables.Grst_Firmante);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(FinanciamientoDesembolsoLineaAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true) {	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objFinanciamientoDesembolsoLineaAutorizarBL.FinanciamientoDesembolsoLineaAutorizar(2,consulta);
			    	}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	public boolean firmaRecibos(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				Lbln_Bandera = objPagRecibosAutorizarBL.PagosRecibosAutorizar(Mdl_Variables.Grst_Firmante);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(PagosRecibosAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true){	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera){ 
							actualizarFechaConsulta( tabla,  id_caso);
							objSQL.updateTablaQuery("update "+tabla+ " set TXT_FECHA_SOLICITUD_DESDE='"+ fecha+"' where id_caso_lote="+ id_caso);							
							objSQL.updateTablaQuery("update "+tabla+ " set TXT_FECHA_SOLICITUD_HASTA='"+ fecha+"' where id_caso_lote="+ id_caso);
							PagosRecibosAutorizarBE.GstrTXT_FECHA_SOLICITUD_DESDE=fecha;
							PagosRecibosAutorizarBE.GstrTXT_FECHA_SOLICITUD_HASTA=fecha;
							Lbln_Bandera = objPagosRecibosAutorizarBL.PagosRecibosAutorizar(2,consulta);
						}
			    	}
				
	    		}
	
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}
	
	
	public boolean firmaDocumentos(String tabla, String id_caso, String firmante,boolean consulta) throws Exception{		
		boolean Lbln_Bandera=true;
		try {
			
			objSQL.listaTablaIdCaso(tabla+" WHERE ID_CASO_LOTE="+id_caso+" and FIRMANTE='"+firmante+"' ","",4);
			while (Mdl_Variables.Grst_Firmante.next()==true) {
				Lbln_Bandera = objPagDocumentosAutorizarBL.PagosDocumentosAutorizar(Mdl_Variables.Grst_Firmante);
				
				if (Lbln_Bandera){ 
				//Busqueda de los casos del login 
					objConexionBL.DatosLogin(PagosDocumentosAutorizarBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin
					while (Mdl_Variables.Grst_TablaLogin.next()==true) {	
						Lbln_Bandera = objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin);//INGRESA AL LOGIN
    		    		
						if (Lbln_Bandera)
							Lbln_Bandera = objPagoDocumentosAutorizarBL.PagoDocumentosAutorizar(2,consulta);
					}
				}
			}
		} catch (SQLException e) {
			Lbln_Bandera=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Lbln_Bandera;
	}

	
	public void actualizarFechaConsulta(String tabla, String id_caso){
		Date fechaActual=new Date();
		DateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
		fecha= formatoFecha.format(fechaActual);
	}
	
	public boolean firmarOperacion(String strFirmante,String strIdCaso,String strNumFirmante,boolean blnConsultar,String strConsultarSaldosMovimientos,String strCuentaOrigen,String strCuentaDestino,String strEnvioTransferencia) throws Exception{
		boolean blnResultadoEsperado=false;
		String strTablaAutorizarTransferencias="APP_AND_TRANSFERENCIAS_TRA_AUTORIZAR_D";
		String strTablaAutorizarPortabilidad="APP_AUTORIZACIONES_PORTABILIDAD_D";
		String strTablaAutorizarPendientes="APP_AND_AUTORIZACIONES_PENDIENTES_D";
		
			if (strFirmante.equals("PA")){
				blnResultadoEsperado=firmaTransferencia(strTablaAutorizarTransferencias,strIdCaso,strNumFirmante,blnConsultar);
			}else if (strFirmante.equals("PORT") ){
				blnResultadoEsperado=firmaAutorizacionesPortabilidad(strTablaAutorizarPortabilidad,strIdCaso,strNumFirmante+"' AND LBL_TIPO_OPERACION='Transferencias' and LBL_TIPO_PRODUCTO='Transferencia entre cuentas",blnConsultar,strConsultarSaldosMovimientos, strCuentaOrigen,strCuentaDestino);
			}else if (strFirmante.equals("AP")  ){
				blnResultadoEsperado=firmaAutorizaciones(strTablaAutorizarPendientes,strIdCaso,strNumFirmante,strEnvioTransferencia,blnConsultar);
			}
			
		return blnResultadoEsperado;
	}
}