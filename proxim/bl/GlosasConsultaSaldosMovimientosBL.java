package proxim.bl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import proxim.be.ConsultaSaldosMovimientosBE;
import proxim.be.PortabilidadConsultaSaldosBE;
import proxim.dao.ConexionSqlServer;
import proxim.dao.Mdl_Variables;

public class GlosasConsultaSaldosMovimientosBL {
	ConexionBL objConexionBL = new ConexionBL();
	ConexionSqlServer objSQL = new  ConexionSqlServer();
	PortabilidadConsultaSaldosBE objConsultaSaldosPortabilidadBE=new PortabilidadConsultaSaldosBE();
	PortabilidadConsultaSaldosBL objConsultaSaldosPortabilidadBL=new PortabilidadConsultaSaldosBL();
	ConsultaSaldosMovimientosBL objConsultaSaldoMovimientoBL=new ConsultaSaldosMovimientosBL();
	ConsultaSaldosMovimientosBE objSaldoMovimientoBL = new ConsultaSaldosMovimientosBE();
	LoginBL2 objLogin = new LoginBL2();
	
	public boolean consultarGlosasSaldoMovimiento(String strIdCasoLote,String strCargoAbono,String strTabla,String strTipoProducto) throws SQLException, IOException{
		boolean lbnResultadoEsperado=true;
		String strTipoCarga="";
		String strCadena="";
		try {
			
			if(strCargoAbono.equals("Cargo")||strCargoAbono.equals("Rechazo")){
				strCadena=" and (CMB_TIPO_OPERACION='Cargo' or CMB_TIPO_OPERACION='Rechazo')";
				strTipoCarga="Cargo";
			}else{
				strCadena=" and CMB_TIPO_OPERACION='Abono' ";
				strTipoCarga="Abono";
			}
			Mdl_Variables.Gstr_RutaAplicativoNew=Mdl_Variables.Gstr_RutaAplicativo ;
			Mdl_Variables.Gstr_RutaAplicativo =Mdl_Variables.Gstr_RutaAplicativo+"1. Imagenes\\" +strTipoCarga	+"\\";
			File file = new File(Mdl_Variables.Gstr_RutaAplicativo+"\\1. Imagenes\\");
			file.mkdirs();
			
			//-------------------BPI
//			if(strTipoCarga.equals("Abono")&&strTipoProducto.equals("A Terceros")){
				if (strTabla.equals("APP_AND_TRANSFERENCIAS"))
					objSQL.listaTablaIdCaso("APP_AND_CONSULTA_SALDOS_MOVIMIENTOS_D"," where TABLA_CARGA like '"+strTabla+"%' and ID_CASO_LOTE="+strIdCasoLote+strCadena,8);				
				else
					objSQL.listaTablaIdCaso("APP_AND_CONSULTA_SALDOS_MOVIMIENTOS_D"," where TABLA_CARGA='"+strTabla+"' and ID_CASO_LOTE="+strIdCasoLote+strCadena,8);
				
		    	while (Mdl_Variables.Grst_ListaCasosConsultaBPI.next()) {	
		    		if (objSaldoMovimientoBL.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosConsultaBPI, 8)){ 
						objConexionBL.DatosLogin(ConsultaSaldosMovimientosBE.Gstr_ID_CASO_LOGIN);//Mdl_Variables.Grst_TablaLogin: captura todos los datos para ingresar al login
						while (Mdl_Variables.Grst_TablaLogin.next()){	
							if (objLogin.ingresoLogin("0", Mdl_Variables.Grst_TablaLogin)){ 
								lbnResultadoEsperado = objConsultaSaldoMovimientoBL.consultasSaldosMovimientos();
							}
				    	}
					
					}
		    	}
			//}
			//-------------------PORTABILIDAD
	    	if(strCargoAbono.equals("Cargo")||strCargoAbono.equals("Rechazo")){
				strCadena=" and (TIPO_OPERACION='Cargo' or TIPO_OPERACION='Rechazo')";
				strTipoCarga="Cargo";
			}else{
				strCadena=" and TIPO_OPERACION='Abono' ";
				strTipoCarga="Abono";
			}
	    	
	    	if (strTabla.equals("APP_AND_TRANSFERENCIAS")){
	    		objSQL.listaTablaIdCaso("CONSULTA_SALDOS_PORTABILIDAD"," where TABLA_CARGA like '"+strTabla+"%' and ID_CASO_LOTE="+strIdCasoLote+strCadena,9 );
	    	}else{
	    		objSQL.listaTablaIdCaso("CONSULTA_SALDOS_PORTABILIDAD"," where TABLA_CARGA='"+strTabla+"' and ID_CASO_LOTE="+strIdCasoLote+strCadena,9 );
	    	}
	    	
	    	while (Mdl_Variables.Grst_ListaCasosConsultaPortabilidad.next()) {	
				if (objConsultaSaldosPortabilidadBE.obtenerCamposBD(Mdl_Variables.Grst_ListaCasosConsultaPortabilidad)){ 
					lbnResultadoEsperado = objConsultaSaldosPortabilidadBL.consultarSaldo();
				}
			}
	    	
	    	
	    	Mdl_Variables.Gstr_Url=Mdl_Variables.Gstr_Url1;
	    	Mdl_Variables.Gstr_RutaAplicativo=Mdl_Variables.Gstr_RutaAplicativoNew;
	    	
		} catch (Exception e) {
			lbnResultadoEsperado = false;
            System.out.println("Error:"  + e.getMessage());
		}
		return lbnResultadoEsperado;
	}
}
