package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum ModalidadesAvisos {

	_AVISO_PERSONAL(1, "AVISO : : PERSONALES", "CUALQUIER AVISO REFERENTE A ACTIVIDADES PERSONALES DEL NOTARIO"),
	_AVISO_PROTOCOLO(2, "AVISO : : PROTOCOLO", "AVISOS EXCLUSIVOS PARA TEMAS REFERENTES A PROTOCOLO"),
	_AVISO_PROTOCOLO_APERTURA_CIERRE(3, "AVISO : : APERTURA Y CIERRE", "AVISOS EXCLUSIVOS PARA APERTURAS Y CIERRES"),
	_AVISO_PATENTE(4, "AVISO : : PATENTES", "AVISOS EXCLUSIVOS PARA TEMAS REFERENTES A PATENTE");
	
	private final int id;
	private final String tipo;
	private final String descripcion;
	
	private ModalidadesAvisos(final int id,final String tipo,final String descripcion){
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static List<String> obtenerTodos(){
		List<String> l=new ArrayList<String>();
		for(ModalidadesAvisos c:values()){
			l.add(c.tipo);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(ModalidadesAvisos c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
}
