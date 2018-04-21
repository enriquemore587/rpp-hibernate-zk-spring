package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum TipoDocumento {
	_OFICIO(1,"OFICIO"),
	_ESCRITURA(2,"ESCRITURA"),
	_LINEA_DE_CAPTURA(3,"LINEA_DE_CAMPTURA"),
	_OTRO_TIPO_DE_DOCUMENTO(4,"CANCELACION");
	
	private final int id;
	private final String descripcion;
	
	private TipoDocumento(final int id,final String descripcion){
		this.id=id;
		this.descripcion=descripcion;		
	}
	

	
	public int getId() {
		return id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public static List<String> obtenerTodos(){
		List<String> l=new ArrayList<String>();
		for(TipoDocumento c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(TipoDocumento c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(TipoDocumento._ESCRITURA.getDescripcion()); 
	}
	
}
