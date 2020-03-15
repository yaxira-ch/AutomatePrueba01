package proxim.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Map;
//import java.util.logging;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Mdl_Variables {
	
	public static Boolean Gbln_Pendiente=false; 
	public static Boolean Gbln_LimpiaCasos= null; 
	public static Connection Gcnn_Conexion = null;
	public static Date Gdt_EntradaSistema= null; //P_Entrada_Sistema
	public static Date Gdt_TiempoTotalSistema= null;//P_TiempoTotal_Sistema
	public static int Gint_Action=0;
	public static int Gint_contSegFuncionalidad=0;
	public static int Gint_MsgValido =1;
	public static int Gint_MsgError =2;
	public static int Gint_RowCount= 0; 
	public static int Gint_TipoLog= 0; 
	public static int Gint_TiempoEntradaSistema= 0;
	public static int Gint_TiempoEspera = 40;
	public static int Gint_TiempoTotalEjecucionOrg= 0; 
	public static int Gint_TiempoTotalEjecucionDst= 0; 
	public static int Gint_Izquierda=0;//Coordenadas Tbl_Objetos
	public static int Gint_IdCaso=0;
	public static int Gint_Indice=0;//Coordenadas Tbl_Objetos
	public static int Gint_Arriba=0;//Coordenadas Tbl_Objetos
	public static int Gint_Alto=0;//Coordenadas Tbl_Objetos
	public static int Gint_Ancho=0;//Coordenadas Tbl_Objetos
	public static String GstrSIS_GRUPOEJECUCION;
	public static ResultSet Grst_Coordenadas = null; 
	public static ResultSet Grst_DescripcionEvidencia = null;
	public static ResultSet Grst_Evidencia = null; 
	public static ResultSet Grst_Log = null;//Rst_Log
	public static ResultSet Grst_LogDetalleIndice = null;
	public static ResultSet Grst_ListaCasosEjecutar = null;
	public static ResultSet Grst_ListaCasosConsultaBPI = null;
	public static ResultSet Grst_ListaCasosConsultaPortabilidad = null;
	public static ResultSet Grst_TablaLogin = null; 
	public static ResultSet Grst_NuevaTabla = null;
	public static ResultSet Grst_QaPendienes = null; //Rst_QaPendienes
	public static ResultSet Grst_Tabla = null;
	public static ResultSet Grst_Firmante= null;
	public static ResultSet Grst_RegistroBPI= null;
	public static ResultSet Grst_TablaDetalle1= null;
	public static ResultSet Grst_TablaDetalle2= null;
	public static long Glng_HoraInicio;
	public static long Glng_HoraFin;
	public static String Gstr_Actividad= null;
	public static String Gstr_Aplicativo= null;
	public static String Gstr_Arquitecto= null;
	public static String Gstr_Browser= null;
	public static String Gstr_CasosEjecutar= null;//P_Str_CasosExec
	public static String Gstr_CadenaMaestro= "";//P_Str_CasosExec
	public static String Gstr_Corrida= null; //Gstr_Ciclo
	public static String Gstr_Click = "CLICK";//P_Str_CLICK
	public static String Gstr_Clave=null;
	public static String Gstr_ComplementoDescripcion= "";
	public static String Gstr_Datos= null;
	public static String Gstr_DataExec= null; 
	public static String Gstr_DescripcionAciertoError= null;
	public static String Gstr_DescAccAnt= null;
	public static String Gstr_DescErrAnt= null;
	public static String Gstr_Descripcion= null;
	public static String Gstr_Dispositivo= null;
	public static String Gstr_Executado;
	public static String Gstr_HoraExec= null;
	public static String Gstr_IdEvidencia= "";//P_Str_IdEvidencia
	public static String GStr_IdMaestro;//P_Str_ID_MAESTRO
	public static String Gstr_Ignore = "<IGNORE>";//P_Str_IGNORE
	public static String Gstr_LimpiarDatos= null;
	public static String Gstr_LogDetalle = null;//Sql_Log_Detalle
	public static String Gstr_Maquina= null;//P_Str_NombreMaquina 
	public static String Gstr_MensajeLog= null;
	public static String Gstr_Modulo= null;
	public static String Gstr_NombreVersion= null;
	public static String Gstr_NombreImagen= null;
	public static String GstrNumeroSolicitud= null;
	public static String Gstr_PasosEvidencia = "";
	public static String Gstr_PasosEvidenciaMensaje = "";
	public static String Gstr_Paquete= null;
	public static String Gstr_PEvidencia = "";
	public static String Gstr_RutaEvidencia= null;
	public static String Gstr_RutaAplicativo= null;//--------------------------------
	public static String Gstr_RutaAplicativoNew= null;//--------------------------------
	public static String Gstr_Sistema= null;//P_Str_Sistema
	public static String Gstr_SqlLogMaestro= null;//Sql_Log_Maestro   Gstr_Tbl_Log_Maestro
	public static String Gstr_TablaAnterior = null;//--------------------------------------------------------------
	public static String Gstr_Tabla= null;//P_Str_Tabla
	public static String Gstr_Sprint= null;
	public static String Gstr_Tarjeta= null;
	public static String Gstr_TablaDestino = null;
	public static String Gstr_TesterResponsable= null;
	public static String Gstr_TipoAplicativo= null;
	public static String Gstr_Tbl_Log_Detalle= null;
	public static String Gstr_Url= null;
	public static String Gstr_TipoApp= null;
	public static String Gstr_UrlPorta= null;
	public static String GstrTipoCambio= null;
	public static String GstrMontoConvertido= null;
	public static String Gstr_Url1= null;
	public static String Gstr_Usuario= null;
	public static String Gstr_FechaSolicitud= null;
	public static String Gstr_Monto= null;
	public static String Gstr_NumeroCuotas= null;
	public static String Gstr_FechaPrimeraCuota= null;
	public static String Gstr_CuotaDestino= null;
	public static String GstrTotalPagar;
	public static String Gstr_strNewMonto= null;
	public static String Gstr_CarpetaImagenes= "1. Imagenes";//CH:18-04-2017
	public static String Gstr_CarpetaReporteHTML= "0. Reporte HTML";//CH:18-04-2017
	public static String Gstr_RutaReportHTML= null;//CH:18-04-2017
	public static String Gstr_Logo = "\\\\XT6998T6AW7-1\\Evidencias\\logo_ch.jpg";//CH:18-04-2017
	public static String[] Garr_CasoAfiliacion= {};
	public static String[] Garr_CasosEjecutar = {};
	public static String[] Garr_montosBuscar = {};
	public static Select Gslt_ObjPerform;//objPerform_Select
	public static WebElement Gwel_ObjPerform;
	public static WebDriver Gwed_Driver;
	public static String Gstr_EmpresaDestino=null;
	public static String Gstr_SaldoDisponible=null;
	public static String[] Gstr_Parametros= {};
	public static Map<String,String> map;
	
//------------------------------------------------

	
}
