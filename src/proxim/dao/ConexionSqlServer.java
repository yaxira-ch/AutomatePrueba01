package proxim.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import proxim.bl.FuncionesGenerales;

public class ConexionSqlServer {
	static ConexionSqlServer objSQL = new  ConexionSqlServer();
	String strUpdate="UPDATE ";
	String strSelect="SELECT * FROM ";
	String strErrorTabla="Error en Tabla de Funcionalidad: ";
	String strErrorLog="Error en Log_Detalle: ";
	String strWhereIdCaso="' WHERE [ID_CASO] = ";
	
	public enum BasedeDatos{ //enum: contiene definición de los enumerados, de los campos asociados a cada enumerado y los tipos y valores de estos campos, constructor intrínseco y métodos para acceder a los campos.
		ACCESS,SQL,MYSQL,SQL2008,ACCESS2007,ORACLE,ORACLE10G,DB2,AS400, NOVALUE;
		public static BasedeDatos getValue(String str){
            try {
                return valueOf(str);//valueOf: retorna el valor dependiendo del valor que contenga 
            }catch (IllegalArgumentException ex) {
                return NOVALUE;
            }
        }
    }

	public static void conectarBaseDatos(String strBaseDatos ,String strGestorBasedeDatos ,String strUsuario ,String strPassword ,String strServidor) throws SQLException{
        switch (BasedeDatos.getValue(strGestorBasedeDatos.toUpperCase())){
        	case ACCESS:
        		break;
        	case ACCESS2007:
        		break;
        	case AS400:                           
        		break;
        	case DB2:
        		break;
        	case MYSQL:
        		break;
        	case ORACLE:
                	break;
        	case ORACLE10G:
        		break;
        	case SQL:
        		SQLServerDataSource ds = new SQLServerDataSource();
        		ds.setServerName(strServidor); 
        		ds.setDatabaseName(strBaseDatos);   
        		ds.setUser(strUsuario);
        		ds.setPassword(strPassword);     
        			
        		Mdl_Variables.Gcnn_Conexion = ds.getConnection();
//        		String url="jdbc:sqlserver://S432VA3\\BDT;DatabaseName=BPI_EMPRESA;integratedSecurity=true";
//			try {
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			Mdl_Variables.Gcnn_Conexion=DriverManager.getConnection(url);
        		break;

        	case SQL2008:
        		break;
            default:
        		break;
        }
    }
	
    public static boolean schedule(String strBaseDatos ,String strGestorBasedeDatos ,String strUsuario ,String strPassword ,String strServidor ){
		try{
			//Se conecta con la base de datos
			conectarBaseDatos(strBaseDatos, strGestorBasedeDatos, strUsuario, strPassword, strServidor);
      
			//Consulta que devuelve todos los registros que se tienen que ejecutar y que aún no han sido ejecutados de la máquina que ejecutara en la tabla schedule.
			Mdl_Variables.Grst_QaPendienes = Mdl_Variables.Gcnn_Conexion.prepareCall("SELECT * FROM TBL_SCHEDULE_EXEC  WHERE EXECUTAR = 'TRUE' AND EXECUTADO = 'FALSE' AND upper(MAQUINA)='" + Mdl_Variables.Gstr_Maquina.trim().toUpperCase() + "' ORDER BY DATA_EXEC, HORA_EXEC, INDICE").executeQuery();
        
			//Valida que existan scripts pendientes por ejecución
			if (Mdl_Variables.Grst_QaPendienes.next()){
				String strAmbiente;
				Mdl_Variables.Gint_Indice = Mdl_Variables.Grst_QaPendienes.getInt("INDICE");
				Mdl_Variables.Gstr_DataExec =  Mdl_Variables.Grst_QaPendienes.getString("DATA_EXEC");
				Mdl_Variables.Gstr_HoraExec = Mdl_Variables.Grst_QaPendienes.getString("HORA_EXEC");
				
//				if (General.DateCompare(Mdl_Variables.Gstr_DataExec + " " + Mdl_Variables.Gstr_HoraExec) == true)
//	            {
					Mdl_Variables.Gbln_Pendiente = true;
					Mdl_Variables.Gcnn_Conexion.prepareCall( "UPDATE TBL_SCHEDULE_EXEC SET EXECUTADO = 'TRUE', FECHA_INICIO_EXEC = '" + new Date() + "' WHERE INDICE = " + Mdl_Variables.Gint_Indice).execute();		  
					
					Mdl_Variables.Gstr_Tabla = Mdl_Variables.Grst_QaPendienes.getString("SCRIPT");
					Mdl_Variables.Gstr_Sprint = Mdl_Variables.Grst_QaPendienes.getString("SPRINT");
					Mdl_Variables.Gstr_Tarjeta = Mdl_Variables.Grst_QaPendienes.getString("TARJETA");
	        		Mdl_Variables.Gstr_Modulo =  Mdl_Variables.Grst_QaPendienes.getString("MODULO");//TABLA
					Mdl_Variables.Gstr_NombreVersion = Mdl_Variables.Grst_QaPendienes.getString("NOMBRE_VERSION");
					Mdl_Variables.Gstr_Corrida = Mdl_Variables.Grst_QaPendienes.getString("CORRIDA");
					Mdl_Variables.Gstr_CasosEjecutar = Mdl_Variables.Grst_QaPendienes.getString("CASOS_EJECUTAR");
					Mdl_Variables.Gbln_LimpiaCasos = Mdl_Variables.Grst_QaPendienes.getBoolean("LIMPIA_CASOS");
					Mdl_Variables.Gstr_Sistema = Mdl_Variables.Grst_QaPendienes.getString("SISTEMA");    
					Mdl_Variables.Gstr_Aplicativo = Mdl_Variables.Grst_QaPendienes.getString("APLICATIVO");
					Mdl_Variables.Gstr_TesterResponsable = Mdl_Variables.Grst_QaPendienes.getString("TESTER_RESPONSABLE");
					Mdl_Variables.Gstr_Arquitecto = Mdl_Variables.Grst_QaPendienes.getString("ARQUITECTO_RESPONSABLE");
	        		Mdl_Variables.Gstr_TipoApp = Mdl_Variables.Grst_QaPendienes.getString("TIPOAPP");
	        		Mdl_Variables.Gstr_Dispositivo = Mdl_Variables.Grst_QaPendienes.getString("DISPOSITIVO");
	        		Mdl_Variables.Gstr_Paquete = Mdl_Variables.Grst_QaPendienes.getString("PAQUETE");         
	        		Mdl_Variables.Gstr_Actividad = Mdl_Variables.Grst_QaPendienes.getString("ACTIVIDAD");
	        		strAmbiente=Mdl_Variables.Grst_QaPendienes.getString("AMBIENTE");
	        		Mdl_Variables.Grst_QaPendienes.close();
	        		
	        		//objSQL.listaTablaIdCaso("TBL_AMBIENTES WHERE ID_AMBIENTE="+Lstr_Ambiente+" ","",4);
	        		objSQL.listaTablaIdCaso("SELECT "
	        				+ "IIF( a2.DIRECCION_PRINCIPAL is NULL and a1.DIRECCION_PRINCIPAL like '%web%',NULL,a1.DIRECCION_PRINCIPAL) as URLBPI, "
	        				+ "IIF(a2.DIRECCION_PRINCIPAL is NULL and a1.DIRECCION_PRINCIPAL like '%web%',a1.DIRECCION_PRINCIPAL,a2.DIRECCION_PRINCIPAL) as URLPORTA "
	        				+ "FROM TBL_AMBIENTES AS a1 LEFT OUTER JOIN TBL_AMBIENTES AS a2 "
	        				+ "ON a1.ID_PORTA = a2.ID_AMBIENTE "
	        				+ "WHERE (a1.ID_AMBIENTE = "+strAmbiente+") ","",6);
	    			while (Mdl_Variables.Grst_Firmante.next()) {
	    				Mdl_Variables.Gstr_Url = Mdl_Variables.Grst_Firmante.getString("URLBPI");
	    				Mdl_Variables.Gstr_Url1 = Mdl_Variables.Grst_Firmante.getString("URLBPI");
	    				Mdl_Variables.Gstr_UrlPorta = Mdl_Variables.Grst_Firmante.getString("URLPORTA");
	    			}
//	            }else{
//	            	Mdl_Variables.Gbln_Pendiente = false;
//	            }
			}else{
				Mdl_Variables.Gbln_Pendiente = false;
			}
		}catch(Exception ex){
    		Mdl_Variables.Gbln_Pendiente = false;
    		System.out.println("Error en ConexionSqlServer.Schedule: " + ex.getMessage());
    	}
		return Mdl_Variables.Gbln_Pendiente;
	}   
    		
    public void listaTablaIdCaso(String tabla, String tabla1,int valor){
    	try{
    		 switch (valor) {
    		 case 1:
    			 Mdl_Variables.Grst_ListaCasosEjecutar = Mdl_Variables.Gcnn_Conexion.prepareCall(strSelect +tabla+tabla1 + " ORDER BY ID_CASO").executeQuery();
    			 break;
    		 case 2:
    			 Mdl_Variables.Grst_TablaLogin= Mdl_Variables.Gcnn_Conexion.prepareCall(strSelect +tabla+" "+tabla1 + " ORDER BY ID_CASO").executeQuery();
    			 break;
    		 case 3:
    			 Mdl_Variables.Grst_NuevaTabla= Mdl_Variables.Gcnn_Conexion.prepareCall(strSelect +tabla+" "+tabla1 ).executeQuery();
    			 break;
    		 case 4:
    			 Mdl_Variables.Grst_Firmante= Mdl_Variables.Gcnn_Conexion.prepareCall(strSelect +tabla+" "+tabla1 ).executeQuery();
    			 break;
    		 case 5:
    			 Mdl_Variables.Grst_NuevaTabla= Mdl_Variables.Gcnn_Conexion.prepareCall(tabla ).executeQuery();
    			 break;
    		 case 6:
    			 Mdl_Variables.Grst_Firmante= Mdl_Variables.Gcnn_Conexion.prepareCall(tabla ).executeQuery();
    			 break;
    		 case 7:
    			 Mdl_Variables.Grst_RegistroBPI= Mdl_Variables.Gcnn_Conexion.prepareCall(tabla ).executeQuery();
    			 break;	 
    		
    		 case 8:
    			 Mdl_Variables.Grst_ListaCasosConsultaBPI = Mdl_Variables.Gcnn_Conexion.prepareCall(strSelect +tabla+tabla1 ).executeQuery();
    			 break;
    			 
    		 case 9:
    			 Mdl_Variables.Grst_ListaCasosConsultaPortabilidad = Mdl_Variables.Gcnn_Conexion.prepareCall(strSelect +tabla+tabla1 ).executeQuery();
    			 break;
    		 default:
    			 break;
    		 }
    	}catch(Exception ex){
	        Mdl_Variables.Gbln_Pendiente = false;
	        System.out.println(strErrorTabla + ex.getMessage());
		}	
    }
    
    public void listaTablaQuery(String campos, String tabla,String campoWhere,String datoWhere ,String camposGroupBy,String orderBy,int strTablaNro ){
    	try{
    		String strQuery = "";
    		strQuery = " select " + campos;
    		strQuery += " from  " + tabla;
    		if(campoWhere.compareTo("")!= 0) {strQuery += " where  " + campoWhere + " = '" + datoWhere + "' ";}
    		if(camposGroupBy.compareTo("")!= 0) {strQuery += " group by  " + camposGroupBy;}
    		if(orderBy.compareTo("")!= 0) {strQuery += " order by " + orderBy;}
    		
    		
    		 switch (strTablaNro) {
    		
    		 case 1:
    			 Mdl_Variables.Grst_TablaDetalle1 =  Mdl_Variables.Gcnn_Conexion.prepareCall(strQuery).executeQuery(); 
    			 break;
    		 case 2:
    			 Mdl_Variables.Grst_TablaDetalle2 =  Mdl_Variables.Gcnn_Conexion.prepareCall(strQuery).executeQuery();  
    			 break;
    		 case 3:
    			 Mdl_Variables.Grst_ListaCasosEjecutar = Mdl_Variables.Gcnn_Conexion.prepareCall(strQuery).executeQuery();
    			 break;
    		 case 4:
    			 Mdl_Variables.Grst_NuevaTabla = Mdl_Variables.Gcnn_Conexion.prepareCall(strQuery).executeQuery();
    			 break;
    		 default:
    			 break;
    		 }
    		    																					
    	}catch(Exception ex){
	        Mdl_Variables.Gbln_Pendiente = false;
	        System.out.println(strErrorTabla + ex.getMessage());
		}	
    }
    
	
    public void modificarTablaPasos(){
    	try{
    		Mdl_Variables.Gcnn_Conexion.prepareCall( strUpdate + Mdl_Variables.Gstr_Tabla + "  SET DESIGN_STEPS = '"+ Mdl_Variables.Gstr_PasosEvidencia + strWhereIdCaso + Mdl_Variables.Gint_IdCaso).execute();	
    	}catch(Exception ex){
	        System.out.println(strErrorTabla + ex.getMessage());
		}	
    }
    
    public boolean modificarNumeroSolicitud(String campo) {
    	boolean valor=true;
    	try{
    		Mdl_Variables.Gcnn_Conexion.prepareCall( strUpdate + Mdl_Variables.Gstr_Tabla + "  SET NUMERO_SOLICITUD = '"+ campo + strWhereIdCaso + Mdl_Variables.Gint_IdCaso).execute();	
    	}catch(Exception ex){
	       valor=false;
    		System.out.println(strErrorTabla + ex.getMessage());
		}	
    	return valor;
    }
    
    public boolean modificarSaldoDisponible(String campo) {
    	boolean valor;
    	try{
    		Mdl_Variables.Gcnn_Conexion.prepareCall( strUpdate + Mdl_Variables.Gstr_Tabla + "  SET SALDO_DISPONIBLE = '"+ campo + strWhereIdCaso + Mdl_Variables.Gint_IdCaso).execute();	
    		valor=true;
    	}catch(Exception ex){
	       valor=false;
    		System.out.println(strErrorTabla + ex.getMessage());
		}	
    	return valor;
    }
    
    public boolean modificarCampos(String servicio,String cuentaCargo,int montoTotal) {
    	boolean valor;
    	try{
    		Mdl_Variables.Gcnn_Conexion.prepareCall( strUpdate + Mdl_Variables.Gstr_Tabla + "  SET LBN_SERVICIO_REGISTRO = '"+ servicio + "', LBN_CUENTA_CARGO_REGISTRO='"+cuentaCargo+"', LBN_MONTO_TOTAL="+montoTotal+" WHERE [ID_CASO] = " + Mdl_Variables.Gint_IdCaso).execute();	
    		valor=true;
    	}catch(Exception ex){
	       valor=false;
    		System.out.println(strErrorTabla + ex.getMessage());
		}	
    	return valor;
    }
    
    public void actualizarTabla(String strTabla ,String strColumna, String strValor,String strIdCaso) {
    	try {
    		Mdl_Variables.Gstr_TablaDestino = strUpdate+  strTabla + " SET " + strColumna + " = '" + strValor + "' WHERE ID_CASO = " + strIdCaso + ";";
            Mdl_Variables.Gcnn_Conexion.prepareCall(Mdl_Variables.Gstr_TablaDestino).execute();
    	} catch (Exception ex) {
    		System.out.println(strErrorLog + ex.getMessage());
    	}
    }
    
    public void optenerDatosLogin(String strValor){
    	try{
    		Mdl_Variables.Grst_TablaLogin = Mdl_Variables.Gcnn_Conexion.prepareCall("Select * from APP_AND_LOGIN_D where ID_CASO="+strValor).executeQuery();
    	}catch(Exception ex){
	        System.out.println(strErrorTabla + ex.getMessage());
		}	
    }
    
    public void logDetalle( String strTipoLog, String strMensajeLog, String strTiempoEjecucion,String strFechaEjecucion ){
    	try {
    		Mdl_Variables.Gstr_LogDetalle = "INSERT INTO TBL_LOG_DETALLE ( ID_MAESTRO, CICLO ,INDICE ,TIPO_LOG ,MENSAJE_LOG ,IMAGEN ,TIEMPO_EJECUCION_CASO, VERSION,FECHA,INDICE_SCHEDULE) Values (" + Mdl_Variables.GStr_IdMaestro + ",'" + Mdl_Variables.Gstr_Corrida + "',"+Mdl_Variables.Gint_IdCaso+","+strTipoLog+",'" + strMensajeLog + "','" + Mdl_Variables.Gstr_NombreImagen + "',"+strTiempoEjecucion+",'" + Mdl_Variables.Gstr_NombreVersion + "','"+  strFechaEjecucion+"'," + Mdl_Variables.Gint_Indice + ")";
            Mdl_Variables.Gcnn_Conexion.prepareCall(Mdl_Variables.Gstr_LogDetalle).execute();
    	} catch (Exception ex) {
    		System.out.println(strErrorLog + ex.getMessage());
    	}
    }
    
    public void actualizarScheduleDespues(String strFuncionalidad,long tiempoInicio){
    	try {
        	long tiempoTotal=(System.currentTimeMillis()-tiempoInicio)/1000;
    		String strHoraExecutado=FuncionesGenerales.fechaActual();
	    	Mdl_Variables.Gstr_TablaDestino = "UPDATE TBL_SCHEDULE_EXEC SET EXECUTADO ='" +  "1"  + "' , HORA_EJECUTADO = '" + strHoraExecutado + "', TMP_EXEC_EN_SEGUNDOS = '" +  tiempoTotal  + "'  WHERE INDICE = '" + Mdl_Variables.Gint_Indice + "';";
            Mdl_Variables.Gcnn_Conexion.prepareCall(Mdl_Variables.Gstr_TablaDestino).execute();
    	} catch (Exception ex) {
    		System.out.println(strErrorLog + ex.getMessage());
    	}
   }
    
    public void actualizarScheduleAntes(String strFuncionalidad){
    	try {
    		String strHoraExecutar=FuncionesGenerales.fechaActual();
    		Mdl_Variables.Gstr_TablaDestino = "UPDATE TBL_SCHEDULE_EXEC SET DATA_EXEC ='" +  new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime())  + "' , HORA_EXEC = '" + strHoraExecutar + "', FECHA_INICIO_EXEC = '" +  new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()) + "'  WHERE SCRIPT = '" + strFuncionalidad + "';";
            Mdl_Variables.Gcnn_Conexion.prepareCall(Mdl_Variables.Gstr_TablaDestino).execute();
    	} catch (Exception ex) {
    		System.out.println(strErrorLog + ex.getMessage());
    	}
    }
    
    public boolean listaTablaQueryDinamico(String query ){//funcionalidad
    	boolean flag = true;
    	try{
    		Mdl_Variables.Gcnn_Conexion.prepareCall(query).executeQuery(); 																
    	}catch(Exception ex){
	        flag = false;
	        System.out.println("Error en ejecución del script SQL: " + ex.getMessage());
		}	
    	return flag;
    }
    
    public boolean updateTablaQuery(String query ) throws SQLException{
    	boolean flag = true;
    	try{
    		Mdl_Variables.Gcnn_Conexion.prepareCall(query).executeUpdate();
    	}catch(Exception ex){
    		flag = false;
	        System.out.println("Error en ejecución del script SQL: " + ex.getMessage());
		} 
    	return flag;
    }
    
    public void insertCampo( String cadena ){
    	try {
            Mdl_Variables.Gcnn_Conexion.prepareCall(cadena).execute();
    	} catch (Exception ex) {
    		System.out.println("Error insertando registros en la tabla de saldos y movimientos: " + ex.getMessage());
    	}
    }

	public String obtenerTipoUsuario(String strIdCasoLogin) {
		String tipo="";
		try{
			ResultSet rs=Mdl_Variables.Gcnn_Conexion.prepareCall("Select * from Operador_Firmante where IDLOGIN="+strIdCasoLogin).executeQuery();
			if (rs.next() ) 
				tipo=rs.getString("SIMBOLO");
    	}catch(Exception ex){
	        System.out.println("Error al obtener tipo Firmante: " + ex.getMessage());
		}	
		return tipo;
	}
    
}
