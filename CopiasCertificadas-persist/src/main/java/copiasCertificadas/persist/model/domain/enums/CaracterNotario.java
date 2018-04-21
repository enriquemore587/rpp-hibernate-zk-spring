package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum CaracterNotario {

	_TITULAR(1,"NO APLICA"),
	_SUPLENTE(2,"SUPLENTE"),
	_ASOCIADO(3,"ASOCIADO");
	
	private final Integer id;
	private final String descripcion;
	
	private CaracterNotario(final Integer id,final String descripcion){
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
		for(CaracterNotario c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(CaracterNotario c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(CaracterNotario._ASOCIADO.getDescripcion()); 
	}
}
