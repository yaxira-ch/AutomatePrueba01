package proxim.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import proxim.be.ConsultaDocumentosRelacionPagaresBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class ConsultaDocumentosRelacionPagaresBL extends ConsultaDocumentosRelacionPagaresBE{

	private static String TipoLog = null;
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	ConexionBL objConexionBL = new ConexionBL();
	HeaderBL objHeader = new HeaderBL();
	
	ConsultaDocumentosRelacionPagaresMapeo objConsultaPagaresBE = new ConsultaDocumentosRelacionPagaresMapeo();
	
	public boolean ConsultaPagares(int nOpcion) throws SQLException, IOException{
		boolean bandera = true;
		String LStr_HoraFin;
		long Lng_TiempoEjeCaso;
		String LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	 
		try {
			
			//---------------------------------------MENU---------------------------------------
			
			objHeader.menuPrincipal("<IGNORE>", strTXT_MENU, strTXT_SUBMENU);
			
			//------------------------------------------------------------------------------			
			
			if (objFuncionesGenerales.verificarIgnore(strCMB_EMPRESA))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				objConsultaPagaresBE.verificarTitulo();
				if (objConsultaPagaresBE.seleccionarEmpresa(strCMB_EMPRESA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la EMPRESA, "+strCMB_EMPRESA, "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la EMPRESA, "+strCMB_EMPRESA, "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strCMB_SITUACION))
			{		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				objConsultaPagaresBE.verificarTitulo();
				if (objConsultaPagaresBE.seleccionarSituacion(strCMB_SITUACION))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la SITUACION, "+strCMB_SITUACION, "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la SITUACION, "+strCMB_SITUACION, "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strCMB_MONEDA))
			{		
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				if (objConsultaPagaresBE.seleccionarMoneda(strCMB_MONEDA))
				{	
					objFuncionesGenerales.callPasosAcierto(2, "de la MONEDA, "+strCMB_MONEDA, "" ,  "");
					TipoLog="1";
				}else{
					TipoLog="0";		
					bandera = false;
					objFuncionesGenerales.callPasosErrado(2, "de la MONEDA, "+strCMB_MONEDA, "" ,  "");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			if (objFuncionesGenerales.verificarIgnore(strBTN_BUSCAR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
				if (objConsultaPagaresBE.ingresoBuscar()){
					objFuncionesGenerales.callPasosAcierto(1, "", "" ,"en el Botón BUSCAR");
					TipoLog="1";
				}else{
					TipoLog="0";									
					bandera = false;
					objFuncionesGenerales.callPasosErrado(1, "", "" ,"en el Botón BUSCAR");
				}
				LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
			   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
	    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
			}
			
			boolean bMensajeError = false;
			if (objFuncionesGenerales.verificarIgnore(strTXT_MENSAJE_ERROR))
			{	
				bMensajeError = true;
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				Thread.sleep(1800);
				String strMensajeFront =  objConsultaPagaresBE.obtenerMensajeFront(strTXT_COLUMNA_ERROR);
				objFuncionesGenerales.callPasosAcierto(4, strMensajeFront, "" ,"");
				if (strMensajeFront.compareTo("<IGNORE>")!=0)
				{
					if (objFuncionesGenerales.compararTexto(strMensajeFront,strTXT_MENSAJE_ERROR))
					{
						objFuncionesGenerales.callPasosAcierto(5, strMensajeFront, strTXT_MENSAJE_ERROR ,"");
						TipoLog="1";
		    		}else{
		    			TipoLog="0";									
						bandera = false;
						objFuncionesGenerales.callPasosErrado(5, strMensajeFront, strTXT_MENSAJE_ERROR ,"");
		    		}
				}
			}
			
			boolean bCompararDatos = false;
			if (objFuncionesGenerales.verificarIgnore(strCOMPARAR_DATOS))
			{	
				if (objFuncionesGenerales.compararTexto(strCOMPARAR_DATOS.toUpperCase(),"SI"))
				{
					bCompararDatos = true;
	    		}
			}
			
			if(!bMensajeError)
			{
				if (objConsultaPagaresBE.existeTabla()) //VER SI EXISTE TABLA
				{
					objFuncionesGenerales.callPasosAcierto(6, "Existe Tabla de resultados.", "" ,"");
					TipoLog="1";
	    		}else{
	    			if(bCompararDatos)
	    			{
	    				TipoLog="0";									
	    				bandera = false;
	    				objFuncionesGenerales.callPasosErrado(6, "No Existe Tabla de resultados.", "" ,"");
	    			}
	    		}
			}
			
			boolean bColumnasCorrectas = false;
			if(!bMensajeError)// VERIFICAR COLUMNAS CORRECTAS
			{
				if (objConsultaPagaresBE.columnasCorrectas()) 
				{
					objFuncionesGenerales.callPasosAcierto(6, "Las columnas son correctas.", "" ,"");
					TipoLog="1";
					bColumnasCorrectas = true;
	    		}else{
	    			if(bCompararDatos)
	    			{
	    				TipoLog="0";									
	    				bandera = false;
	    				objFuncionesGenerales.callPasosErrado(6, "Las columnas no son correctas.", "" ,"");
	    			}
	    		}
			}
			
			if (bColumnasCorrectas)//GUARDAR TABLA
			{
				if(objConsultaPagaresBE.guardarTabla(strID_CASO))
				{
					objFuncionesGenerales.callPasosAcierto(6, "Se guardó la tabla de resultados.", "" ,"");
					TipoLog="1";
				}
				else
				{
					TipoLog="0";									
    				bandera = false;
    				objFuncionesGenerales.callPasosErrado(6, "No se guardó la tabla de resultados.", "" ,"");
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strCOMPARAR_DATOS)) // COMPARAR DATOS
			{	
				if (objFuncionesGenerales.compararTexto(strCOMPARAR_DATOS.toUpperCase(),"SI"))
				{
					if (compararTablasBD())
					{
						objFuncionesGenerales.callPasosAcierto(6, "Se guardó la tabla de resultados.", "" ,"");
						TipoLog="1";
					}
					else
					{
						TipoLog="0";									
	    				bandera = false;
	    				objFuncionesGenerales.callPasosErrado(6, "No se guardó la tabla de resultados.", " " ,"");
					}
	    		}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strLNK_EXPORTAR_PDF))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				if(strLNK_EXPORTAR_PDF.toUpperCase().equals("SI"))
				{
					if (objConsultaPagaresBE.ingresoExportarPdf())
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,  "EXPORTAR A PDF");
						Thread.sleep(3800);
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "" , "" ,  "EXPORTAR A PDF");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strLNK_EXPORTAR_EXCEL))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				if(strLNK_EXPORTAR_EXCEL.toUpperCase().equals("SI"))
				{
					if (objConsultaPagaresBE.ingresoExportarExcel())
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,  "EXPORTAR A EXCEL");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "" , "" ,  "EXPORTAR A EXCEL");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (objFuncionesGenerales.verificarIgnore(strLNK_IMPRIMIR))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				if(strLNK_IMPRIMIR.toUpperCase().equals("SI"))
				{
					if (objConsultaPagaresBE.ingresoImprimir())
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,  "IMPRIMIR");
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "" , "" ,  "IMPRIMIR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			boolean bIngresoLnkEmail = false;
			if (objFuncionesGenerales.verificarIgnore(strLNK_ENVIAR_EMAIL))
			{	
				LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				if(strLNK_ENVIAR_EMAIL.toUpperCase().equals("SI"))
				{
					if (objConsultaPagaresBE.ingresoEmail())
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,  "ENVIAR POR EMAIL");
						bIngresoLnkEmail = true;
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "" , "" ,  "ENVIAR POR EMAIL");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
			}
			
			if (bIngresoLnkEmail)
			{
				boolean bIngresoTituloEmail = false;
				if (objFuncionesGenerales.verificarIgnore(strTXT_EMAIL))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
					if (objConsultaPagaresBE.ingresarEmail(strTXT_EMAIL))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "en el E-EMAIL:", strTXT_EMAIL ,"");
						bIngresoTituloEmail = true;
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "en el E-EMAIL:", strTXT_EMAIL,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				
				if (objFuncionesGenerales.verificarIgnore(strTXT_MENSAJE_EMAIL))
				{	
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
					if (objConsultaPagaresBE.ingresarMensaje(strLNK_ENVIAR_EMAIL))
					{	
						objFuncionesGenerales.callPasosAcierto(3, "en el MENSAJE:", strTXT_MENSAJE_EMAIL ,"");
						bIngresoLnkEmail = true;
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(3, "en el MENSAJE:", strTXT_MENSAJE_EMAIL,  "");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}
				if(bIngresoTituloEmail)
				{
					LStr_HoraInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				
					if (objConsultaPagaresBE.ingresoBotonEnviarmail())
					{	
						objFuncionesGenerales.callPasosAcierto(1, "", "" ,  "ENVIAR");
						bIngresoLnkEmail = true;
						TipoLog="1";
					}else{
						TipoLog="0";			
						bandera = false;
						objFuncionesGenerales.callPasosErrado(1, "" , "" ,  "ENVIAR");
					}
					LStr_HoraFin = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());	  
	    			Lng_TiempoEjeCaso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraFin).getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(LStr_HoraInicio).getTime()) / (1000);
				   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
		    		objSQL.logDetalle(TipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(Lng_TiempoEjeCaso),LStr_HoraInicio);
				}	
			}
			
			if (objFuncionesGenerales.verificarIgnore(strLNK_CERRAR_SESION))
			{	
				objHeader.cerrarSesion(strLNK_CERRAR_SESION,strLNK_CERRAR_SESION);
			}

		}
		catch (Exception e) {
			objConexionBL.actualizarTabla( Mdl_Variables.Gstr_Tabla, "EJECUCION_AC_ERR", "0", Integer.toString(Mdl_Variables.Gint_IdCaso));
	        CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + "1. Imagenes" );
			System.out.println("Error: "  + e.getMessage() + " About: " + e.getClass().getName() + " ClassName: " + this.getClass().getName());
			bandera = false;
		}
		return bandera;
			
	}
	
	/*
	private boolean guardarTabla()
	{
		List<String[]> tabla;
		tabla = objConsultaPagaresBE.obtenerTabla();
		if(tabla == null)
		{
			return false;
		}
		else
		{
			String strQuery = "";
			strQuery += " DELETE FROM APP_AND_CONSULTA_PAGARES_TABLA_D ";
			strQuery += " WHERE ID_CASO = "+ strID_CASO +" ; ";
			objSQL.listaTablaQuery(strQuery, "", "", "","","", 0);

			for (int j = 1 ;j<=tabla.size()-2 ;j++)
			{
				String strFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				strQuery = "";
				strQuery += " INSERT INTO APP_AND_CONSULTA_PAGARES_TABLA_D ";
				strQuery += " VALUES ("+strID_CASO+" ,";
				strQuery += " "+j+" ,";
				strQuery += "'"+strFechaHora+"',";
				strQuery += "'"+tabla.get(j)[1] +"',";//NUMERODOC
				strQuery += "'"+tabla.get(j)[2]+"',";//DESCRIPCION
				strQuery += "'"+tabla.get(j)[3]+"',";//MONEDA
				strQuery += "'"+tabla.get(j)[4]+"',";//FECHA_INGRESO
				strQuery += "'"+tabla.get(j)[5]+"',";//FECHA_VENCIMIENTO
				strQuery += "'"+tabla.get(j)[6]+"',";//SALDO
				strQuery += "'"+tabla.get(j)[7]+"') ";//SITUACION
				objSQL.listaTablaQuery(strQuery, "", "", "","","", 0);
			}
			
			return true;
		}
		
	}*/
	
	private boolean compararTablasBD()
	{
		//FALTA LA QUERY PARA COMPARAR
		return true;
		
	}
	
	
}


