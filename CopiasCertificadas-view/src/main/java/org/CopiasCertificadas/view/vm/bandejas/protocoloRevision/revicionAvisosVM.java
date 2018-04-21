package org.CopiasCertificadas.view.vm.bandejas.protocoloRevision;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.Areas;
import copiasCertificadas.persist.model.domain.enums.Operaciones;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.StatusGestion;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosBandejaProtocolo;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

public class revicionAvisosVM implements Serializable {

	
	private TramiteDAO tramiteDAO;
	
	private Tramite tramite;
	
	private List<BeanAvisosBandejaProtocolo> lista;
	
	private List<BeanAvisosBandejaProtocolo> lista2;
	
	
	//Components
	@Wire
	Textbox folio1;
	
	@Wire
	Textbox folio2;
	
	@Init
	public void init() {
		tramiteDAO = new TramiteDAOImpl();
		lista = new ArrayList<BeanAvisosBandejaProtocolo>();
		updateTable();
	}
	
	@Command
	@NotifyChange("lista")
	public void findByFolio1() {
		Messagebox.show(folio1.getText());
		lista = tramiteDAO.getAvisoPresentadoByFolioTramite(folio1.getText());
	}
	
	@Command
	@NotifyChange("lista")
	public void findByFolio2() {
		lista = tramiteDAO.getAvisoCompletadodoByFolioTramite(folio1.getText());
	}
	
	@NotifyChange("lista")
	@Command
	public void updateTable() {
		lista = tramiteDAO.getAllAvisosXCompletar();
	}
	
	@NotifyChange("lista2")
	@Command
	public void updateTable2() {
		lista2 = tramiteDAO.getAllAvisosCompletados();
	}
	
	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	public List<BeanAvisosBandejaProtocolo> getLista() {
		return lista;
	}

	public void setLista(List<BeanAvisosBandejaProtocolo> lista) {
		this.lista = lista;
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}
	
	public List<BeanAvisosBandejaProtocolo> getLista2() {
		return lista2;
	}

	public void setLista2(List<BeanAvisosBandejaProtocolo> lista2) {
		this.lista2 = lista2;
	}

	@GlobalCommand
	@NotifyChange("lista")
	public void completarAviso(@BindingParam("id") Long id) {
		
		Tramite tramite = tramiteDAO.getTramiteById(id);
		
		Bitacora bitacora = new Bitacora();
				bitacora.setArea_origen(Areas._AREA_PROTOCOLO.getDescripcion());
				bitacora.setArea_turnado(Areas._AREA_PROTOCOLO.getDescripcion());
				bitacora.setObservaciones(Operaciones._GUARDO_INFORMACION.getTipo());
				bitacora.setStatus(Status._COMPLETADO.getTipo());
				bitacora.setTramite(tramite);
				bitacora.setUsuario(OrigenTramite._ELECTRONICO.getDescripcion()+ " -  POR EL NUMERO DE NOTARIO: "+ tramite.getId_fedatario());
			tramite.getListaBitacora().add(bitacora);
			
		SeguimientoTramite seguimientoTramite = new SeguimientoTramite();
				seguimientoTramite.setDescripcion(Operaciones._GUARDO_INFORMACION.getTipo());
				seguimientoTramite.setObservaciones(Operaciones._GUARDO_INFORMACION.getDescripcion());
				seguimientoTramite.setStatus(Status._COMPLETADO.getTipo());
				seguimientoTramite.setStatus_gestion(StatusGestion._AVISO_COMPLETADO.getTipo());
				seguimientoTramite.setStatusDesc_gestion(StatusGestion._AVISO_COMPLETADO.getDescripcion());
				seguimientoTramite.setTramite(tramite);
		tramite.getListaSeguimientos().add(seguimientoTramite);
		
		
		if (tramite.getAvisosNotariales().getDescripcionAviso()== null) {
			Messagebox.show("NO PUEDE COMPLETAR EL AVISO, PRIMERO DEBE AGREGAR UNA DESCRIPCION", "AVISO", 1, null);
		}else if (tramiteDAO.update(tramite)){
			Messagebox.show("AVISO COMPLETADO");
			updateTable();
		}
	}
}
