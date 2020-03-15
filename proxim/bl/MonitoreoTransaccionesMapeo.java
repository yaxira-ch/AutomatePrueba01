package proxim.bl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import proxim.be.MonitoreoTransaccionesGeneralBE;
import proxim.dao.ConexionSqlServer;

public class MonitoreoTransaccionesMapeo {
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	MonitoreoTransaccionesGeneralBE objMonitoreoTransaccionesGeneralBL = new MonitoreoTransaccionesGeneralBE();
	boolean bandera=false; 
	
	public boolean CargarLote(String strID_CASO,String strRuta, String strNombreArchivo) throws SQLException, IOException{
		String strArchivo = leerArchivo(strRuta+"\\"+strNombreArchivo);
		String[] strFilas = strArchivo.split("\\n");
		String strQuery = "";
		
		strQuery += " DELETE FROM APP_AND_ARCHIVOTEXTO_DETALLE_D ";
		strQuery += " WHERE ID_CASO = '"+strID_CASO+"' ";
		objSQL.listaTablaQueryDinamico(strQuery);

		for(int c=0;c<strFilas.length;c++) {
			
			String strReg = strFilas[c];
			strQuery = "";
			strQuery += " INSERT INTO APP_AND_ARCHIVOTEXTO_DETALLE_D ";
			strQuery += " VALUES ( ";

			int pos = 0;
			int ant = 0;
			int indUltimo = strReg.lastIndexOf("|");
			
			strQuery += " '"+strID_CASO+"', ";
			strQuery += " '"+(c+1)+"', ";
			
			while ((pos = strReg.indexOf("|", pos)) != -1) {
			    //System.out.println(pos);
			    //System.out.println(strReg.substring(ant,pos));
				
				strQuery += "'"+strReg.substring(ant,pos)+"',";
				if(indUltimo == pos)
				{
					int nLargo = strReg.length();
					if (nLargo > pos+1){
						strQuery += "'"+strReg.substring(pos+1,nLargo)+"',";	
					}
					else {
						strQuery += "'',";
					}
				}
			    ant = pos + 1;
			    pos++;
			}
			//strQuery =  strQuery.substring(0, strQuery.length()-1);
			strQuery += " '' ) ";
			objSQL.listaTablaQueryDinamico(strQuery);
			/*
			if (objSQL.listaTablaQueryDinamico(strQuery))
			{
				ninsfilas++;
			}*/
		}
		return true;
	}
	
	private String leerArchivo(String strRutaCompleta)
	{	
		String texto="";
		//String[] strMatr = new String[1];
		try{
			BufferedReader br=new BufferedReader(new FileReader(strRutaCompleta));
			//int num = br.read();
			//String[] strMatriz = new String[num];
			String temp="";
			String bfRead;
			//int i = 0;
			while((bfRead = br.readLine()) !=null)
			{
				//i++;
				temp = temp+bfRead + "\n";
				//strMatriz[i] = bfRead;
				
			}
			//return strMatriz;
			texto=temp;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return texto;
		//return strMatr;
	}
	
	public boolean GuardarLog() throws SQLException, IOException{
		//boolean bandera = false;
		String strQuery = "";
		strQuery += " INSERT INTO APP_AND_ARCHIVOTEXTO_HISTO ";
		strQuery += " VALUES ( ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrTIPO_TRANSACCION +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrTIPO_GRUPO_EMPRESA +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrCODIGO_CANAL +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrCODIGO_TRANSACCION +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrDETALLE_CODIGO_TRANSACCION +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrNRO_TARJETA_INTERACTIVA +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrFECHA_ACUSE_TARJETA +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrFECHA_TRANSACCION +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrHORA_TRANSACCION +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrMONEDA +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrIMPORTE +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrCODIGO_UNICO_CLIENTE +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrDNI_CLIENTE +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrDISPOSITIVO_TRANSACCION +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrIP_IMEI +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrTIPO_MONEDA_ORIGEN +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrTIPO_CUENTA_ORIGEN +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrCODIGO_OFICINA_ORIGEN +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrNUMERO_CUENTA_ORIGEN +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrTIPO_MONEDA_DESTINO +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrTIPO_CUENTA_DESTINO +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrCODIGO_OFICINA_DESTINO +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrNUMERO_CUENTA_DESTINO +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrCCI_CUENTA_DESTINIO +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrPUNTO_SERVICIO +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrNIVEL_TRANSACCIONAL +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrTIPO_ACCESO +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrSALDO_DISPONIBLE_ORIGEN +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrFECHA_EJECUCION +"', ";
		strQuery += " '"+objMonitoreoTransaccionesGeneralBL.GstrHORA_EJECUCION +"' ";
		strQuery += " ) ";
		
		objSQL.listaTablaQueryDinamico(strQuery);
		
		return true;
	}
	
	public boolean InsertarLog(String strTipoTransaccion, String strID_CASO, String strGrupoEjecucion) throws SQLException, IOException{
		//boolean bandera = false;
		String strQuery = "";
		
		switch (strTipoTransaccion.toUpperCase())
		{ 
			case "TRANSFERENCIA ENTRE CUENTAS":
				strQuery += " INSERT INTO LOG_APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D ";
				strQuery += " SELECT *,CONVERT(VARCHAR(20),getdate(),120),'"+strGrupoEjecucion+"' FROM APP_AND_TRANSFERENCIAS_ENTRE_CUENTAS_D ";
				strQuery += " WHERE ID_CASO = '"+strID_CASO+"' ";
			break;
		
			case "TRANSFERENCIA A_TERCEROS":
				strQuery += " INSERT INTO LOG_APP_AND_TRANSFERENCIAS_A_TERCEROS_D ";
				strQuery += " SELECT *,CONVERT(VARCHAR(20),getdate(),120),'"+strGrupoEjecucion+"' FROM APP_AND_TRANSFERENCIAS_A_TERCEROS_D ";
				strQuery += " WHERE ID_CASO = '"+strID_CASO+"' ";
			break;
		}

		objSQL.listaTablaQueryDinamico(strQuery);
		
		return true;
	}
	
	
}
