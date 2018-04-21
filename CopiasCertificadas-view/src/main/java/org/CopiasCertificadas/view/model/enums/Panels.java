package org.CopiasCertificadas.view.model.enums;

public enum Panels {
	
	REVOCACION(1,"REVOCACION","/secure/dgjyel/tramites/notas/revocacion/revocacionList.zul"),
	RENUNCIA(2,"RENUNCIA","/secure/dgjyel/tramites/notas/renuncia/renunciaList.zul"),
	INSCRIPCION(3,"INSCRIPCION","/secure/dgjyel/tramites/notas/inscripcion/inscripcionList.zul"),
	NULIDAD(4,"NULIDAD","/secure/dgjyel/tramites/notas/nulidad/nulidadList.zul"),
	CORRECCION(5,"CORRECCION","/secure/dgjyel/tramites/notas/correccion/correccionDeNotasList.zul"),
	ERROR_DE_TRANSCRIPCION(6,"ERROR DE TRANSCRIPCION EN EL TESTIMONIO","/secure/dgjyel/tramites/notas/transcripcion/transcripcionList.zul"),
	CONSTANCIAS_AL_APENDICE(7,"AGREGAR CONSTANCIAS AL APENDICE","/secure/dgjyel/tramites/notas/constancias/constanciasAlApendiceList.zul"),
	ENTREGA_DE_PRIMER_TESTIMONIO(8,"ENTREGA DE PRIMER TESTIMONIO","/secure/dgjyel/tramites/notas/entrega/entregaDePrimerTestimonioList.zul"),
	CP_APODERADO(9,"CP :: CIUDADANO || APODERADO || ALBACEA","/copias/VUCCYTPersonasFisicas.zul"),
	CP_NOTARIO(10,"CP :: NOTARIOS","/copias/VUCCYT-VENTANILLA-Notario.zul"),
	AVISOS_NOTARIALES(11,"AVISOS NOTARIALES","/avisosNotariales/avisosNotariales.zul"),
	BUSQUEDAS_AVISOS(12,"BUSQUEDAS :: AVISOS","/avisosNotariales/busquedas/busquedasAvisos.zul"),
	BUSQUEDAS_COPIAS(13,"BUSQUEDAS :: COPIAS","/copias/busquedas/busquedasCopias.zul"),
	CP_NOTARIO_SESION(14,"CP :: NOTARIO SESION","/copias/VUCCYTNotarioSesion.zul"),
	BANDEJA_NOTARIO_AVISOS(15, "BANDEJA DE AVISOS", "/bandejas/avisos/avisos.zul"),
	BANDEJA_NOTARIO_COPIAS(16, "BANDEJA DE COPIAS CERTIFICADAS", "/bandejas/copias/copias.zul"),
	BANDEJA_PROTOCOLO_AVISOS(17, "BANDEJA PROTOCOLO : : AVISOS", "/bandejas/avisosProtocolo/revicionAvisos.zul")
	;
	
	private final int id;
	private final String name;
	private final String url;
	
	private Panels(int id,String name, String url) {
		this.id = id;
		this.name=name;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}
	
	
	public String getName() {
		return name;
	}

	public static String getURLComponent(String nameForm) {
		String url="";
		for (Panels p : values()) {
			if(p.name.equals(nameForm)) {
				url=p.getUrl();
			}
		}
		return url;
	}	
}
