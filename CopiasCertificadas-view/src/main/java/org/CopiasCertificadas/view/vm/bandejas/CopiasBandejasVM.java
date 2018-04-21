package org.CopiasCertificadas.view.vm.bandejas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.Areas;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.StatusGestion;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosNotarialesBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.copias.bandeja.BeanCopiasBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

public class CopiasBandejasVM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5491159249322003228L;

	private List<BeanCopiasBandeja> lista;
	private TramiteDAO tramiteDAO;
	@Init
	public void init() {
		// TODO Auto-generated method stub
		lista = new ArrayList<BeanCopiasBandeja>();
		tramiteDAO = new TramiteDAOImpl();
		updateBandejaCopias();
	}
	
	
	
	@GlobalCommand
	@NotifyChange("lista")
	public void updateBandejaCopias() {
		lista.clear();
		lista = tramiteDAO.getAllCopiasBandeja(21);
	}
	
	@GlobalCommand
	@NotifyChange("lista")
	public void deleteCopia(@BindingParam("id") Long id) {
		tramiteDAO.delate(tramiteDAO.getTramiteById(id));
		updateBandejaCopias();
	}
	@GlobalCommand
	@NotifyChange("lista")
	public void presentarCopia(@BindingParam("id") Long id) {
		
		Tramite tramite = tramiteDAO.getTramiteById(id);
		tramite.setCreado(new Date());
		Bitacora bitacora = new Bitacora();
				bitacora.setArea_origen(OrigenTramite._ELECTRONICO.getDescripcion());
				bitacora.setArea_turnado(Areas._AREA_PROTOCOLO.getDescripcion());
				bitacora.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ENTRA A: " + Areas._AREA_PROTOCOLO.getDescripcion());
				bitacora.setStatus(Status._PRESENTADO.getTipo());
				bitacora.setTramite(tramite);
				bitacora.setUsuario(OrigenTramite._ELECTRONICO.getDescripcion()+ " -  POR EL NUMERO DE NOTARIO: "+ tramite.getId_fedatario());
			tramite.getListaBitacora().add(bitacora);

		SeguimientoTramite seguimientoTramite = new SeguimientoTramite();
				seguimientoTramite.setDescripcion(OrigenTramite._ELECTRONICO.getDescripcion());
				seguimientoTramite.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + " - - - -  >>> " + Areas._AREA_ADMINISTRACION_DE_ACERVOS.getDescripcion());
				seguimientoTramite.setStatus(Status._PRESENTADO.getTipo());
				seguimientoTramite.setStatus_gestion(Areas._AREA_ADMINISTRACION_DE_ACERVOS.getTipo());
				seguimientoTramite.setStatusDesc_gestion(StatusGestion._POR_ASIGNAR_A_BUSCADOR.getDescripcion());
				seguimientoTramite.setTramite(tramite);
		tramite.getListaSeguimientos().add(seguimientoTramite);
		tramiteDAO.update(tramite);
		
		updateBandejaCopias();
	}
	
	@Command
	public void newCopia() {
		Executions.createComponents("/copias/VUCCYTNotarioSesion.zul", null, null);
	}

	
	public List<BeanCopiasBandeja> getLista() {
		return lista;
	}

	public void setLista(List<BeanCopiasBandeja> lista) {
		this.lista = lista;
	}

	public TramiteDAO getTramiteDAO() {
		return tramiteDAO;
	}

	public void setTramiteDAO(TramiteDAO tramiteDAO) {
		this.tramiteDAO = tramiteDAO;
	}
	
	
	
}
