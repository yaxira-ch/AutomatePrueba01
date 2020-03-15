package proxim.bl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class SteptsEveris {
	
	SteptsEverisBE objSteptsEverisBE = new SteptsEverisBE();
	FuncionesGenerales objFuncionesGenerales = new FuncionesGenerales();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	String strTipoLog = null;
	String strHoraFin;
	String strHoraInicio ;	 
	long lngTiempoEjeCaso;
	boolean blnResultadoEsperado = true;
	String strFechaHora="dd/MM/yyyy HH:mm:ss";
	String strTextoImagen="1. Imagenes";
	
	
	public void selecionarObjetoValor(String strBy, String strByValue,String strDescription ,String strValor) throws  Exception{
		if (objFuncionesGenerales.verificarIgnore(strValor)){		
			strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	 
			if (objSteptsEverisBE.seleccionarObjeto(strBy,strByValue,strValor)){	
				objFuncionesGenerales.callPasosAcierto(2, strDescription+strValor , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";		
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(2, strDescription+strValor , "" ,  "");
			}
			strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
		}
	}
	
	public void ingresarValorObjeto(String strBy, String strByValue,String strDescription ,String strValor) throws  Exception{
		if (objFuncionesGenerales.verificarIgnore(strValor)){	
			strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  	
			if (objSteptsEverisBE.ingresarObjeto(strBy,strByValue,strValor)){	
				objFuncionesGenerales.callPasosAcierto(3, strDescription+strValor , "" ,  "");
				strTipoLog="1";
			}else{
				strTipoLog="0";			
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(3, strDescription+strValor , "" ,  "");
			}
			strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
			objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
		}
	}
	
	public void clicValorObjeto(String strBy, String strByValue,String strDescription ,String strValor) throws  Exception{
		if (objFuncionesGenerales.verificarIgnore(strValor)){	
			strHoraInicio = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
			if (objSteptsEverisBE.clicObjeto(strBy, strByValue)){	
				objFuncionesGenerales.callPasosAcierto(1, "", "" ,strDescription);
				strTipoLog="1";
			}else{
				strTipoLog="0";									
				blnResultadoEsperado = false;
				objFuncionesGenerales.callPasosErrado(1, "", "" ,strDescription);
			}
			strHoraFin = new SimpleDateFormat(strFechaHora).format(Calendar.getInstance().getTime());	  
			lngTiempoEjeCaso = (new SimpleDateFormat(strFechaHora).parse(strHoraFin).getTime() - new SimpleDateFormat(strFechaHora).parse(strHoraInicio).getTime()) / (1000);
		   	CapturarPantalla.capturaPantalla( Mdl_Variables.Gstr_RutaAplicativo + strTextoImagen );
    		objSQL.logDetalle(strTipoLog, Mdl_Variables.Gstr_PasosEvidenciaMensaje, Long.toString(lngTiempoEjeCaso),strHoraInicio);
		}
	}
}
