package avisosNotariales.persist.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.Areas;
import copiasCertificadas.persist.model.domain.enums.ModalidadesAvisos;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.TipoSolicitante;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.AvisosNotariales;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

public class TestAvisos {
	
	TramiteDAO tramiteDAO;
	
	Integer numNotario = 21;
	
	Tramite tramite;
	
	AvisosNotariales avisosNotariales;
	
	Bitacora bitacora;
	List<Bitacora> listaBitacora;
	
	Pagos pagos;
	List<Pagos> listaPagos;
	
	SeguimientoTramite seguimientoTramite;
	List<SeguimientoTramite> listaSeguimientos;
	
	
	private void load() {
		tramiteDAO = new TramiteDAOImpl();
		
		tramite = new Tramite();
		avisosNotariales = new AvisosNotariales();
		bitacora = new Bitacora();
		listaBitacora = new ArrayList<Bitacora>();
		pagos = new Pagos();
		listaPagos = new ArrayList<Pagos>();
		seguimientoTramite = new SeguimientoTramite();
		listaSeguimientos = new ArrayList<SeguimientoTramite>();
	}


	private void avisoElectronico() {
		this.load();
		avisosNotariales = new AvisosNotariales();
			avisosNotariales.setPreDescripcionAviso("Ejemplo de la descripcion por el notario");
			avisosNotariales.setModalidad(ModalidadesAvisos._AVISO_PERSONAL.getTipo().toString());
			
			avisosNotariales.setTramite(tramite);
		
		tramite.setAvisosNotariales(avisosNotariales);
		System.out.println(
				tramite.
				getAvisosNotariales().
				getPreDescripcionAviso());
		tramite.setFecha_recepcion(new Date());
		
		tramite.setFolio("Aviso Notarial - " + (new Date().getTime()));
		
		tramite.setId_fedatario(21);
			
		
			bitacora.setArea_origen(OrigenTramite._ELECTRONICO.getDescripcion());
			bitacora.setArea_turnado(Areas._AREA_PROTOCOLO.getDescripcion());
			bitacora.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ENTRA A: " + Areas._AREA_PROTOCOLO.getDescripcion());
			bitacora.setStatus(Status._ENTREGADO.getTipo());
			bitacora.setTramite(tramite);
			bitacora.setUsuario(OrigenTramite._ELECTRONICO.getDescripcion()+ "POR EL NUMERO DE NOTARIO: "+ numNotario);
		listaBitacora.add(bitacora);
		tramite.setListaBitacora(listaBitacora);
		
		
			pagos.setFecha_pago(new Date());
			pagos.setImporte(0.0);
			pagos.setLinea_captura("linea_captura test");
			pagos.setTramite(tramite);
		listaPagos.add(pagos);
		tramite.setListaPagos(listaPagos);
		
			seguimientoTramite.setDescripcion(OrigenTramite._ELECTRONICO.getDescripcion());
			seguimientoTramite.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ENTRA A: " + Areas._AREA_PROTOCOLO.getDescripcion());
			seguimientoTramite.setStatus(Status._ENTREGADO.getTipo());
			seguimientoTramite.setStatus_gestion(Status._ENTREGADO.getTipo());
			seguimientoTramite.setStatusDesc_gestion(Status._ENTREGADO.getDescripcion());
			seguimientoTramite.setTramite(tramite);
			listaSeguimientos.add(seguimientoTramite);
		tramite.setListaSeguimientos(listaSeguimientos);
		
		tramite.setTipoSolicitante(TipoSolicitante._NOTARIO.getDescripcion());
		
		tramite = tramiteDAO.saveUpdate(tramite);
		if (tramite!=null) {
			System.out.println("tramite agregado");
		}
	}
	public static void main(String[] args) {
		(new TestAvisos()).avisoElectronico();
	}
}
