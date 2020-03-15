package proxim.be;

import java.sql.ResultSet;

import proxim.dao.Mdl_Variables;

public class RegistroAfiliadosPagosBE {
	
	public static String GstrID_CASO;
	public static String GstrCMB_TIPO_PERSONA;
	public static String GstrTXT_NOMBRE_RAZON_SOCIAL;
	public static String GstrTXT_CODIGO_BENEFICIARIO;
	public static String GstrCMB_DOCUMENTO_IDENTIDAD;
	public static String GstrTXT_DOCUMENTO_IDENTIDAD;
	public static String GstrBTN_GUARDAR;
	public static String GstrBTN_AGREGAR_NUEVO_PROVEEDOR;  
	public static String GstrBTN_CONTINUARNEW;
	public static String GstrBTN_AGREGAR_NUEVO_PROVEEDOR_FINAL;  
	public static String GstrTXT_COLUMNA_ERROR;
	public static String GstrTXT_MENSAJE_ERROR;
	
	
	//-------------1
	public static String GstrTXT_DIRECCION;
	public static String GstrTXT_EMAIL;
	public static String GstrCMB_TIPO_ABONO_SOLES;
	public static String GstrTXT_MONTO_LIMITE_SOLES;
	public static String GstrCMB_TIPO_CUENTA_SOLES;
	public static String GstrTXT_NUMERO_CUENTA_SOLES;
	public static String GstrCMB_TIPO_ABONO_DOLARES;
	public static String GstrTXT_MONTO_LIMITE_DOLARES;
	public static String GstrCMB_TIPO_CUENTA_DOLARES;
	public static String GstrTXT_NUMERO_CUENTA_DOLARES;
	public static String GstrTXT_TRANS_MONTO;
	public static String GstrCMB_BUSQUEDAPOR;
	public static String GstrBTN_BUCARAFILIADO;
	
	public static String GstrBTN_SI_POP_UP_ELIMINAR;
	public static String GstrBTN_NO_POP_UP_ELIMINAR;
	public static String GstrCMB_TIPO_PERSONA_EDIT;
	public static String GstrTXT_NOMBRE_RAZON_SOCIAL_EDIT;
	public static String GstrCMB_DOCUMENTO_IDENTIDAD_EDIT;
	public static String GstrTXT_DOCUMENTO_IDENTIDAD_EDIT;
	public static String GstrTXT_DIRECCION_EDIT = "";
	public static String GstrTXT_EMAIL_EDIT = "";
	public static String GstrCMB_TIPO_ABONO_SOLES_EDIT = "";
	public static String GstrCMB_TIPO_CUENTA_SOLES_EDIT = "";
	public static String GstrTXT_MONTO_LIMITE_SOLES_EDIT = "";
	public static String GstrTXT_NUMERO_CUENTA_SOLES_EDIT = "";
	public static String GstrCMB_TIPO_ABONO_DOLAR_EDIT = "";
	public static String GstrCMB_TIPO_CUENTA_DOLARES_EDIT = "";
	public static String GstrTXT_MONTO_LIMITE_DOLAR_EDIT = "";
	public static String GstrTXT_NUMERO_CUENTA_DOLARES_EDIT = "";
	public static String GstrBTN_MODIFICAR;
	public static String GstrBTN_SI_POP_UP_MODIFICAR = "";
	public static String GstrBTN_NO_POP_UP_MODIFICAR = "";
	///------2

	public static String GstrCMB_TIPO_ABONO;
	public static String GstrCMB_TIPO_CUENTA;
	public static String GstrCMB_MONEDA;
	public static String GstrCMB_NUMERO_CUENTA;
	public static String GstrTXT_NUMERO_CUENTA;
	public static String GstrCHK_INGRESAR_NUEVA_CUENTA;
	public static String GstrCMB_DOCUMENTO_PAGO;
	public static String GstrTXT_DOCUMENTO_PAGO;
	public static String GstrTXT_FECHA_VENCIMIENTO;
	public static String GstrCMB_MONEDA_MONTO_OPERACION;
	public static String GstrTXT_MONEDA_MONTO_OPERACION;
	public static String GstrCMB_MONEDA_MONTO_INTANGIBLE;
	public static String GstrTXT_MONEDA_MONTO_INTANGIBLE;
	public static String GstrCHK_PAGO_AFECTO_REENCION;
	public static String GstrLNK_VER_PROVEEDOR;
	public static String GstrRDB_NOMBRE;
	public static String GstrRDB_NUMERO_DOCUMENTO;
	public static String GstrCMB_DOCUMENTO;
	public static String GstrTXT_BUSCAR;
	public static String GstrBTN_BUSCAR;
	public static String GstrRDB_SELECCIONAR_PROVEEDOR;
	public static String GstrBTN_ACEPTAR;
	public static String GstrBTN_EDITAR;
	public static String GstrBTN_ELIMINAR;
	
	public boolean Afiliados(ResultSet Rst_Funcionalidad, int intOpcion){
		boolean bandera = true; 
		try {
			
			GstrID_CASO = Rst_Funcionalidad.getObject("ID_CASO") != null ? Rst_Funcionalidad.getString("ID_CASO") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_CODIGO_BENEFICIARIO = Rst_Funcionalidad.getObject("TXT_CODIGO_BENEFICIARIO") != null ? Rst_Funcionalidad.getString("TXT_CODIGO_BENEFICIARIO") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_TIPO_PERSONA = Rst_Funcionalidad.getObject("CMB_TIPO_PERSONA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_PERSONA") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_NOMBRE_RAZON_SOCIAL = Rst_Funcionalidad.getObject("TXT_NOMBRE_RAZON_SOCIAL") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_RAZON_SOCIAL") : Mdl_Variables.Gstr_Ignore;
			GstrCMB_DOCUMENTO_IDENTIDAD = Rst_Funcionalidad.getObject("CMB_DOCUMENTO_IDENTIDAD") != null ? Rst_Funcionalidad.getString("CMB_DOCUMENTO_IDENTIDAD") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_DOCUMENTO_IDENTIDAD = Rst_Funcionalidad.getObject("TXT_DOCUMENTO_IDENTIDAD") != null ? Rst_Funcionalidad.getString("TXT_DOCUMENTO_IDENTIDAD") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_GUARDAR = Rst_Funcionalidad.getObject("BTN_GUARDAR") != null ? Rst_Funcionalidad.getString("BTN_GUARDAR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AGREGAR_NUEVO_PROVEEDOR = Rst_Funcionalidad.getObject("BTN_AGREGAR_NUEVO_PROVEEDOR") != null ? Rst_Funcionalidad.getString("BTN_AGREGAR_NUEVO_PROVEEDOR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_CONTINUARNEW = Rst_Funcionalidad.getObject("BTN_CONTINUARNEW") != null ? Rst_Funcionalidad.getString("BTN_CONTINUARNEW") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_AGREGAR_NUEVO_PROVEEDOR_FINAL= Rst_Funcionalidad.getObject("BTN_AGREGAR_NUEVO_PROVEEDOR_FINAL") != null ? Rst_Funcionalidad.getString("BTN_AGREGAR_NUEVO_PROVEEDOR_FINAL") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_COLUMNA_ERROR = Rst_Funcionalidad.getObject("TXT_COLUMNA_ERROR") != null ? Rst_Funcionalidad.getString("TXT_COLUMNA_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrTXT_MENSAJE_ERROR = Rst_Funcionalidad.getObject("TXT_MENSAJE_ERROR") != null ? Rst_Funcionalidad.getString("TXT_MENSAJE_ERROR") : Mdl_Variables.Gstr_Ignore;
			GstrBTN_BUSCAR= Rst_Funcionalidad.getObject("BTN_BUSCAR") != null ? Rst_Funcionalidad.getString("BTN_BUSCAR") : Mdl_Variables.Gstr_Ignore;
			  
			 switch (intOpcion) {
			 
			  case 1: //AFILIACION 
				  GstrTXT_DIRECCION = Rst_Funcionalidad.getObject("TXT_DIRECCION") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_EMAIL = Rst_Funcionalidad.getObject("TXT_EMAIL") != null ? Rst_Funcionalidad.getString("TXT_EMAIL") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_TIPO_ABONO_SOLES = Rst_Funcionalidad.getObject("CMB_TIPO_ABONO_SOLES") != null ? Rst_Funcionalidad.getString("CMB_TIPO_ABONO_SOLES") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_MONTO_LIMITE_SOLES = Rst_Funcionalidad.getObject("TXT_MONTO_LIMITE_SOLES") != null ? Rst_Funcionalidad.getString("TXT_MONTO_LIMITE_SOLES") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_TIPO_CUENTA_SOLES = Rst_Funcionalidad.getObject("CMB_TIPO_CUENTA_SOLES") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CUENTA_SOLES") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_NUMERO_CUENTA_SOLES = Rst_Funcionalidad.getObject("TXT_NUMERO_CUENTA_SOLES") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CUENTA_SOLES") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_TIPO_ABONO_DOLARES = Rst_Funcionalidad.getObject("CMB_TIPO_ABONO_DOLARES") != null ? Rst_Funcionalidad.getString("CMB_TIPO_ABONO_DOLARES") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_MONTO_LIMITE_DOLARES = Rst_Funcionalidad.getObject("TXT_MONTO_LIMITE_DOLARES") != null ? Rst_Funcionalidad.getString("TXT_MONTO_LIMITE_DOLARES") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_TIPO_CUENTA_DOLARES = Rst_Funcionalidad.getObject("CMB_TIPO_CUENTA_DOLARES") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CUENTA_DOLARES") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_NUMERO_CUENTA_DOLARES = Rst_Funcionalidad.getObject("TXT_NUMERO_CUENTA_DOLARES") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CUENTA_DOLARES") : Mdl_Variables.Gstr_Ignore;			
				  GstrCMB_BUSQUEDAPOR= Rst_Funcionalidad.getObject("CMB_BUSQUEDAPOR") != null ? Rst_Funcionalidad.getString("CMB_BUSQUEDAPOR") : Mdl_Variables.Gstr_Ignore;			
				  GstrBTN_BUCARAFILIADO= Rst_Funcionalidad.getObject("BTN_BUCARAFILIADO") != null ? Rst_Funcionalidad.getString("BTN_BUCARAFILIADO") : Mdl_Variables.Gstr_Ignore;			
				  GstrBTN_EDITAR= Rst_Funcionalidad.getObject("BTN_EDITAR") != null ? Rst_Funcionalidad.getString("BTN_EDITAR") : Mdl_Variables.Gstr_Ignore;			
				  GstrBTN_ELIMINAR= Rst_Funcionalidad.getObject("BTN_ELIMINAR") != null ? Rst_Funcionalidad.getString("BTN_ELIMINAR") : Mdl_Variables.Gstr_Ignore;			
				  GstrBTN_SI_POP_UP_ELIMINAR= Rst_Funcionalidad.getObject("BTN_SI_POP_UP_ELIMINAR") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP_ELIMINAR") : Mdl_Variables.Gstr_Ignore;			
				  GstrBTN_NO_POP_UP_ELIMINAR= Rst_Funcionalidad.getObject("BTN_NO_POP_UP_ELIMINAR") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP_ELIMINAR") : Mdl_Variables.Gstr_Ignore;			
				  
				  	GstrCMB_TIPO_PERSONA_EDIT = Rst_Funcionalidad.getObject("CMB_TIPO_PERSONA_EDIT") != null ? Rst_Funcionalidad.getString("CMB_TIPO_PERSONA_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NOMBRE_RAZON_SOCIAL_EDIT = Rst_Funcionalidad.getObject("TXT_NOMBRE_RAZON_SOCIAL_EDIT") != null ? Rst_Funcionalidad.getString("TXT_NOMBRE_RAZON_SOCIAL_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_DOCUMENTO_IDENTIDAD_EDIT = Rst_Funcionalidad.getObject("CMB_DOCUMENTO_IDENTIDAD_EDIT") != null ? Rst_Funcionalidad.getString("CMB_DOCUMENTO_IDENTIDAD_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_DOCUMENTO_IDENTIDAD_EDIT = Rst_Funcionalidad.getObject("TXT_DOCUMENTO_IDENTIDAD_EDIT") != null ? Rst_Funcionalidad.getString("TXT_DOCUMENTO_IDENTIDAD_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_DIRECCION_EDIT = Rst_Funcionalidad.getObject("TXT_DIRECCION_EDIT") != null ? Rst_Funcionalidad.getString("TXT_DIRECCION_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_EMAIL_EDIT = Rst_Funcionalidad.getObject("TXT_EMAIL_EDIT") != null ? Rst_Funcionalidad.getString("TXT_EMAIL_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_ABONO_SOLES_EDIT = Rst_Funcionalidad.getObject("CMB_TIPO_ABONO_SOLES_EDIT") != null ? Rst_Funcionalidad.getString("CMB_TIPO_ABONO_SOLES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_CUENTA_SOLES_EDIT = Rst_Funcionalidad.getObject("CMB_TIPO_CUENTA_SOLES_EDIT") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CUENTA_SOLES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MONTO_LIMITE_SOLES_EDIT = Rst_Funcionalidad.getObject("TXT_MONTO_LIMITE_SOLES_EDIT") != null ? Rst_Funcionalidad.getString("TXT_MONTO_LIMITE_SOLES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NUMERO_CUENTA_SOLES_EDIT = Rst_Funcionalidad.getObject("TXT_NUMERO_CUENTA_SOLES_EDIT") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CUENTA_SOLES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_ABONO_DOLAR_EDIT = Rst_Funcionalidad.getObject("CMB_TIPO_ABONO_DOLARES_EDIT") != null ? Rst_Funcionalidad.getString("CMB_TIPO_ABONO_DOLARES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrCMB_TIPO_CUENTA_DOLARES_EDIT = Rst_Funcionalidad.getObject("CMB_TIPO_CUENTA_DOLARES_EDIT") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CUENTA_DOLARES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_MONTO_LIMITE_DOLAR_EDIT = Rst_Funcionalidad.getObject("TXT_MONTO_LIMITE_DOLARES_EDIT") != null ? Rst_Funcionalidad.getString("TXT_MONTO_LIMITE_DOLARES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrTXT_NUMERO_CUENTA_DOLARES_EDIT = Rst_Funcionalidad.getObject("TXT_NUMERO_CUENTA_DOLARES_EDIT") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CUENTA_DOLARES_EDIT") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_MODIFICAR = Rst_Funcionalidad.getObject("BTN_MODIFICAR") != null ? Rst_Funcionalidad.getString("BTN_MODIFICAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_SI_POP_UP_MODIFICAR = Rst_Funcionalidad.getObject("BTN_SI_POP_UP_MODIFICAR") != null ? Rst_Funcionalidad.getString("BTN_SI_POP_UP_MODIFICAR") : Mdl_Variables.Gstr_Ignore;
					GstrBTN_NO_POP_UP_MODIFICAR = Rst_Funcionalidad.getObject("BTN_NO_POP_UP_MODIFICAR") != null ? Rst_Funcionalidad.getString("BTN_NO_POP_UP_MODIFICAR") : Mdl_Variables.Gstr_Ignore;
				
				  break;
			  
			  case 2: //PAGOS
				  GstrCMB_TIPO_ABONO= Rst_Funcionalidad.getObject("CMB_TIPO_ABONO") != null ? Rst_Funcionalidad.getString("CMB_TIPO_ABONO") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_TIPO_CUENTA= Rst_Funcionalidad.getObject("CMB_TIPO_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_TIPO_CUENTA") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_MONEDA= Rst_Funcionalidad.getObject("CMB_MONEDA") != null ? Rst_Funcionalidad.getString("CMB_MONEDA") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_NUMERO_CUENTA= Rst_Funcionalidad.getObject("CMB_NUMERO_CUENTA") != null ? Rst_Funcionalidad.getString("CMB_NUMERO_CUENTA") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_NUMERO_CUENTA= Rst_Funcionalidad.getObject("TXT_NUMERO_CUENTA") != null ? Rst_Funcionalidad.getString("TXT_NUMERO_CUENTA") : Mdl_Variables.Gstr_Ignore;
				   GstrCHK_INGRESAR_NUEVA_CUENTA= Rst_Funcionalidad.getObject("CHK_INGRESA_NUEVA_CUENTA") != null ? Rst_Funcionalidad.getString("CHK_INGRESA_NUEVA_CUENTA") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_DOCUMENTO_PAGO= Rst_Funcionalidad.getObject("CMB_DOCUMENTO_PAGO") != null ? Rst_Funcionalidad.getString("CMB_DOCUMENTO_PAGO") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_DOCUMENTO_PAGO= Rst_Funcionalidad.getObject("TXT_DOCUMENTO_PAGO") != null ? Rst_Funcionalidad.getString("TXT_DOCUMENTO_PAGO") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_FECHA_VENCIMIENTO= Rst_Funcionalidad.getObject("TXT_FECHA_VENCIMIENTO") != null ? Rst_Funcionalidad.getString("TXT_FECHA_VENCIMIENTO") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_MONEDA_MONTO_OPERACION= Rst_Funcionalidad.getObject("CMB_MONEDA_MONTO_OPERACION") != null ? Rst_Funcionalidad.getString("CMB_MONEDA_MONTO_OPERACION") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_MONEDA_MONTO_OPERACION= Rst_Funcionalidad.getObject("TXT_MONEDA_MONTO_OPERACION") != null ? Rst_Funcionalidad.getString("TXT_MONEDA_MONTO_OPERACION") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_MONEDA_MONTO_INTANGIBLE= Rst_Funcionalidad.getObject("CMB_MONEDA_MONTO_INTANGIBLE") != null ? Rst_Funcionalidad.getString("CMB_MONEDA_MONTO_INTANGIBLE") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_MONEDA_MONTO_INTANGIBLE= Rst_Funcionalidad.getObject("TXT_MONEDA_MONTO_INTANGIBLE") != null ? Rst_Funcionalidad.getString("TXT_MONEDA_MONTO_INTANGIBLE") : Mdl_Variables.Gstr_Ignore;
				  GstrCHK_PAGO_AFECTO_REENCION= Rst_Funcionalidad.getObject("CHK_PAGO_EFECTO_RETENCION") != null ? Rst_Funcionalidad.getString("CHK_PAGO_EFECTO_RETENCION") : Mdl_Variables.Gstr_Ignore;
				  
				  
				  GstrLNK_VER_PROVEEDOR= Rst_Funcionalidad.getObject("LNK_VER_PROVEEDOR") != null ? Rst_Funcionalidad.getString("LNK_VER_PROVEEDOR") : Mdl_Variables.Gstr_Ignore;
				  GstrRDB_NOMBRE= Rst_Funcionalidad.getObject("RDB_NOMBRE") != null ? Rst_Funcionalidad.getString("RDB_NOMBRE") : Mdl_Variables.Gstr_Ignore;
				  GstrRDB_NUMERO_DOCUMENTO= Rst_Funcionalidad.getObject("RDB_NUMERO_DOCUMENTO") != null ? Rst_Funcionalidad.getString("RDB_NUMERO_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				  GstrCMB_DOCUMENTO= Rst_Funcionalidad.getObject("CMB_DOCUMENTO") != null ? Rst_Funcionalidad.getString("CMB_DOCUMENTO") : Mdl_Variables.Gstr_Ignore;
				  GstrTXT_BUSCAR= Rst_Funcionalidad.getObject("TXT_BUSCAR") != null ? Rst_Funcionalidad.getString("TXT_BUSCAR") : Mdl_Variables.Gstr_Ignore;
				  GstrRDB_SELECCIONAR_PROVEEDOR= Rst_Funcionalidad.getObject("RDB_SELECCIONAR_PROVEEDOR") != null ? Rst_Funcionalidad.getString("RDB_SELECCIONAR_PROVEEDOR") : Mdl_Variables.Gstr_Ignore;
				  GstrBTN_ACEPTAR= Rst_Funcionalidad.getObject("BTN_ACEPTAR") != null ? Rst_Funcionalidad.getString("BTN_ACEPTAR") : Mdl_Variables.Gstr_Ignore;
				  
					
					
					
					
				  break;
			 }			
		} catch (Exception e) {
			bandera = false; 
			e.printStackTrace();
			System.out.println("Error:"  + e.getMessage());
			
		}
		return bandera;
	}	
}
