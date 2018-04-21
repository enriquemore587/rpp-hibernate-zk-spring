package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum StatusGestion {
	
	_POR_ASIGNAR_A_BUSCADOR(1,"POR ASIGNAR A BUSCADOR","El area de Acervo esta por asignar Libro a los buscadores "),
	_ASIGNADO_A_BUSCADOR(2,"ASIGNADO A BUSCADOR","Fue Asignada la busqueda de Libro a un buscador"),
	_PROTOCOLO_ENCONTRADO(3,"PROTOCOLO ENCONTRADO"," Fue localizado el libro por los buscadores"),
	_PROTOCOLO_NO_ENCONTRADO(4,"PROTOCOLO ENCONTRADO"," El libro no fue localizado, debido a falta de elementos "),
	_ASIGNADO_AL_AREA_DE_PROTOCOLO(5,"ASIGNADO AL AREA DE PROTOCOLO","El libro es Asignado al area de protocolo para proceso de calificacion"),	
	
	_NOTA_ASENTADA(6,"NOTA ASENTADA","Area de protocolo califica el Tr�mite y asienta la nota (APLICADA)"),
	_NOTA_RECHAZADA(7,"NOTA RECHAZADA","Area de protocolo califica el Tr�mite, y elabora oficio de rechazo (RECHAZADA)"),
	
	
	
	_ASIGNADO_AL_AREA_FIRMA(8,"ASIGNADO AL AREA DE FIRMA","El Subdirector de ARCHIVO GENERAL DE NOTARIAS valida y firma Tr�mite"),	
	_LISTO_PARA_ENTREGA(9,"LISTO PARA ENTREGA","El Tr�mite se encuentra en ventanilla para solicitante final"),
	_TRAMITE_FINALIZADO(10,"TRAMITE FINALIZADO"," Concluye el Tr�mite"),
	
	//_SESION_NOTARIO_CP
	
	_CP_SESION_NOTARIO(11, "TRAMITE EN PERFIL DE NOTARIO POR SESION DE NOTARIO","EL TRAMITE ESTA GUARDADO EN LA SESION DEL NOTARIO"),
	_AVISO_INGRESO_PROTOCOLO(12,"AVISO INGRESO A PROTOCOLO","AVISO NOTARIAL INGRESA A BANDEJA DE ENTRADA DE PROTOCOLO"),
	_AVISO_COMPLETADO(13, "AVISO COMPLETADO EN PROTOCOLO", "AVISO CON DESCRIPCION GENERAL POR PARTE DE PROTOCOLO");
	private final int id;
	private final String tipo;
	private final String descripcion;
	
	private StatusGestion(final Integer id,String tipo,final String descripcion){
		this.id=id;
		this.tipo=tipo;
		this.descripcion=descripcion;		
	}
	

	
	public int getId() {
		return id;
	}
	public String getDescripcion() {
		return descripcion;
	}	
	
	public String getTipo() {
		return tipo;
	}



	public static List<String> obtenerTodos(){
		List<String> l=new ArrayList<String>();
		for(StatusGestion c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(StatusGestion c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(StatusGestion._ASIGNADO_A_BUSCADOR.getDescripcion()); 
	}
	
	
}
