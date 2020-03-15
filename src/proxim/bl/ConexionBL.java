package proxim.bl;


import proxim.dao.*;

public class ConexionBL {
	
	ConexionSqlServer objConexionSqlServer = new ConexionSqlServer();
	
//	public void ActualizarTabla(String strColumna, String strValor)
//	{
//		objConexionSqlServer.ActualizarTabla( strColumna, strValor);
//	}
	
	public void ActualizarScheduleAntes(String strFuncionalidad)
	{
		objConexionSqlServer.actualizarScheduleAntes(strFuncionalidad);
	}
	
	public void actualizarTabla(String strTabla ,String strColumna, String strValor,String IDCASO)
	{
		objConexionSqlServer.actualizarTabla(strTabla, strColumna, strValor, IDCASO);
	}
	
	public void DatosLogin(String strValor)
	{
		objConexionSqlServer.optenerDatosLogin(strValor);
	}
	
	public void ActualizarScheduleDespues(String strFuncionalidad,long tiempoInicio)
	{
		objConexionSqlServer.actualizarScheduleDespues(strFuncionalidad,tiempoInicio);
	}

}
