package copiasCertificadas.persist.model.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum Areas {
	
	_POR_ASIGNAR_AREA(1,"POR ASIGNAR AREA","AUN NO SE HA PRESENTADO EL TRAMITE, POR LO TANTO NO HAY AREA A DONDE ASIGNARSE"),
	_PLATAFORMA_NOTARIAL_USER(1,"PLATAFORMA NOTARIAL","USUARIO DE PLATAFORMA NOTARIAL CDMX"),
	_VENTANILLA_FISICA(1,"VENTANILLA FISICA","VENTANILLA FISICA DGJYEL"),
	_AREA_ADMINISTRACION_DE_ACERVOS(2,"AREA ADMINISTRACION DE ACERVOS","AREA DE ADMINISTRACION Y ASIGNACION DE BUSQUEDAS DE LIBRO"),//luis sauceda
	_AREA_ACERVO_A(3,"AREA ACERVO_A","AREA DE ACERVO FISICA A"),	//buscadores
	_AREA_ACERVO_B(3,"AREA ACERVO_B","AREA DE ACERVO FISICA B"),	//buscadores
	_AREA_ACERVO_CONVIVENCIA(3,"AREA ACERVO CONVIVENCIA","AREA ACERVO DE SOCIEDADES DE CONVIVENCIA"),	//buscadores

	_AREA_PROTOCOLO(3,"AREA PROTOCOLO","AREA DE PROTOCOLO"),
	_AREA_REPROGRAFIA(3,"AREA REPROGRAFIA","AREA DE REPROGRAFIA O COPIAS"),
	_AREA_DEVOLUCION_BASURA(3,"DEVOLUCION DE LIBRO (BASURA)","AREA DE REINCOPORACION DE LIBROS AL ACERVO"),
	_AREA_CERTIFICACION(3,"AREA CERTIFICACION","AREA DE CERTIFICACION"),
	_AREA_SUBDIRECCION_AGN(3,"AREA SUBDIRECCION AGN","SUBDIRECCION DE FIRMA Y VALIDACION"),
	_VENTANILLA_WEB(4,"VENTANILLA WEB AGN","VENTANILLA FISICA AGN");
	
	
	private final int id;
	private String tipo;
	private final String descripcion;
	
	
	private Areas(final int id,final String tipo,final String descripcion){
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
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public static List<String> obtenerTodos(){
		List<String> l=new ArrayList<String>();
		for(Areas c:values()){
			l.add(c.descripcion);
		}
		return l;
		
	}
	
	public static int obtenerIdentificador(String val) {
		int valor=0;
		for(Areas c:values()){
			if (c.descripcion.equals(val)) {
				valor=c.id;					
				}
		}		
		return valor;	
	}
	
	public static void main(String[] args) {
		System.out.println(Areas._PLATAFORMA_NOTARIAL_USER.getDescripcion()); 
	}

}
