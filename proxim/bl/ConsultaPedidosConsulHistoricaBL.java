package proxim.bl;

import java.io.IOException;

import proxim.be.ConsultaPedidosBE;
import proxim.be.ObjetosGenerales;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaPedidosConsulHistoricaBL extends ConsultaPedidosBE{

	
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	ObjetosGenerales objObjetosGenerales = new ObjetosGenerales();
	HeaderBL objHeader = new HeaderBL();
	//--------------------------------
	ConsultaPedidosMapeo objConsultasyPedidosBE = new ConsultaPedidosMapeo();
	
	public boolean consultasyPedidos() throws   IOException{
		String strTipoLog = null;
		boolean blnResultadoEsperado = true;
		long strHoraFin;
		long lngTiempoEjeCaso;
		long strHoraInicio;	
		int intNumeroRegistro=0;
		String strTextoImagen="1. Imagenes";
		try {

			if (objFuncionesGenerales.verificarIgnore("Consulta Histórica")){	
				strHoraInicio = System.currentTimeMillis();    
				if (objConsultasyPedidosBE.seleccionarPestanha()){	
					objFuncionesGenerales.callPasosAcierto(2, "en la PESTAÑA, Consulta Histórica", "" ,  "");
					strTipoLog="1";
				}else{
					strTipoLog="0";			
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "en la PESTAÑA, Consulta Histórica" , "" ,  "");
				}
				 strHoraFin = System.currentTimeMillis(); 
		         lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		         CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		         objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			}
									
			if (objFuncionesGenerales.verificarIgnore(strCmbEMPRESA)){       
				strHoraInicio = System.currentTimeMillis();     
				if (objConsultasyPedidosBE.seleccionarEmpresaConsultaHistorica( strCmbEMPRESA)){ 
					objFuncionesGenerales.callPasosAcierto(2, "EMPRESA "+ strCmbEMPRESA, "" ,"");
					strTipoLog="1";
				}else{
					strTipoLog="0";
					blnResultadoEsperado = false;
					objFuncionesGenerales.callPasosErrado(2, "EMPRESA "+ strCmbEMPRESA, "" ,"");
				}
				strHoraFin = System.currentTimeMillis(); 
				lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
				CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
				objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
			} 
		     
			if (objFuncionesGenerales.verificarIgnore( Mdl_Variables.Gstr_Click)){	
				strHoraInicio = System.currentTimeMillis();
				String strSubTipo;
					
				if(objFuncionesGenerales.verificarIgnore(strCmbDOCUMENTO)){
					strSubTipo=strCmbDOCUMENTO;
				}else if(objFuncionesGenerales.verificarIgnore(strCmbDeCUANDO)){
					strSubTipo=strCmbDeCUANDO;
				}else if(objFuncionesGenerales.verificarIgnore(strCmbModuloWEB)){
					strSubTipo=strCmbModuloWEB;
		    	 }else{
		    		 strSubTipo="";
		    	 }
		    	 objConsultasyPedidosBE.verificarTabla();
		    	 intNumeroRegistro=objConsultasyPedidosBE.seleccionarSolicitudProcesada(strCmbPRODUCTO,strCmbTIPO,strSubTipo);	
						
		    	 if (intNumeroRegistro!=0){	
		    		 objFuncionesGenerales.callPasosAcierto(6, "La operación registrada", "" ,"");
		    		 strTipoLog="1";
		    	 }else{
		    		 strTipoLog="0";									
		    		 blnResultadoEsperado = false;
		    		 objFuncionesGenerales.callPasosErrado(6, "La operación registrada", "" ,"");
		    	 }
		    	 strHoraFin = System.currentTimeMillis();	  
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.scrollCapturaPantalla();
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     } 
		     
		     if(intNumeroRegistro!=0 && blnResultadoEsperado){	
		    	 strHoraInicio = System.currentTimeMillis();	  
		    	 if (objConsultasyPedidosBE.verDetalleProcesada(intNumeroRegistro)){	
		    		 objFuncionesGenerales.callPasosAcierto(1, "", "" ," ver detalle de la Solicitud Procesada");
		    		 strTipoLog="1";
		    		 objConsultasyPedidosBE.verificarPopUp();
		    		 CapturarPantalla.pageDown("-4000");
		    	 }else{
		    		 strTipoLog="0";									
		    		 blnResultadoEsperado = false;
		    		 objFuncionesGenerales.callPasosErrado(1, "", "" ," ver detalle de la Solicitud Procesada");
		    	 }
		    	 strHoraFin = System.currentTimeMillis();	  
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     }
		     
		     if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){ 
		    	 strHoraInicio = System.currentTimeMillis();    
		    	 String valoresIncorrectos=objConsultasyPedidosBE.verificarDetalleConsultaHistoricaPopUp(strCmbPRODUCTO);
		    	 if (valoresIncorrectos.equals("")){ 
		    		 objFuncionesGenerales.callPasosAcierto(7, "Todos", "" ,"");
		    		 strTipoLog="1";
		    	 }else{
		    		 strTipoLog="0";
		    		 blnResultadoEsperado = false;
		    		 objFuncionesGenerales.callPasosErrado(7, valoresIncorrectos, "" ,"");			        
		    	 }
		    	 strHoraFin = System.currentTimeMillis();  
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 CapturarPantalla.scrollCapturaPantallaVertical("//html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div", Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     } 
		     
		     
		     if (objFuncionesGenerales.verificarIgnore(Mdl_Variables.Gstr_Click)){       
		    	 strHoraInicio = System.currentTimeMillis();   
		    	 Thread.sleep(500);
		    	 if (objConsultasyPedidosBE.cerrarPopUp()) { 
		    		 objFuncionesGenerales.callPasosAcierto(1, "", "" ,"Enviar");
		    		 strTipoLog="1";
		    	 }else{
		    		 strTipoLog="0";
		    		 blnResultadoEsperado = false;
		    		 objFuncionesGenerales.callPasosErrado(1, "", "" ,"Enviar");
		    	 }
		    	 strHoraFin = System.currentTimeMillis();  
		    	 lngTiempoEjeCaso = (strHoraFin- strHoraInicio)/ (1000);
		    	 objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),Long.toString(strHoraInicio));
		     } 
			
		}catch (Exception e) {
			blnResultadoEsperado = false;
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
	    	System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
		}
		return blnResultadoEsperado;
	}


}
	
