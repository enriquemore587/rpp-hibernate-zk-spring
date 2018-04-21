package org.CopiasCertificadas.view.vm.bandejas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.Areas;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.StatusGestion;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosNotarialesBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;
import copiasCertificadas.reports.dao.AcuseDAO;
import copiasCertificadas.reports.dao.AcuseDAOImpl;

public class AvisosBandejasVM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5491159249322003228L;

	private List<BeanAvisosNotarialesBandeja> lista;
	private TramiteDAO tramiteDAO;
	@Init
	public void init() {
		// TODO Auto-generated method stub
		tramiteDAO = new TramiteDAOImpl();
		updateBandeja();
	}
	
	@GlobalCommand
	@NotifyChange("lista")
	public void updateBandeja() {
		lista = new ArrayList<BeanAvisosNotarialesBandeja>();
		lista = tramiteDAO.getAllAvisosBandeja(21);
	}
	
	@GlobalCommand
	@NotifyChange("lista")
	public void deleteAviso(@BindingParam("id") Long id) {
		tramiteDAO.delate(tramiteDAO.getTramiteById(id));
		updateBandeja();
	}
	@GlobalCommand
	@NotifyChange("lista")
	public void presentarAviso(@BindingParam("id") Long id) {
		
		final Tramite tramite = tramiteDAO.getTramiteById(id);
		tramite.setListaBitacora(new ArrayList<Bitacora>());
		tramite.getListaBitacora().add(new Bitacora());
		
		tramite.getListaBitacora().get(0).setArea_origen(OrigenTramite._ELECTRONICO.getDescripcion());
		tramite.getListaBitacora().get(0).setArea_turnado(Areas._AREA_PROTOCOLO.getDescripcion());
		tramite.getListaBitacora().get(0).setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ENTRA A: " + Areas._AREA_PROTOCOLO.getDescripcion());
		tramite.getListaBitacora().get(0).setStatus(Status._PRESENTADO.getTipo());
		tramite.getListaBitacora().get(0).setTramite(tramite);
		tramite.getListaBitacora().get(0).setUsuario(OrigenTramite._ELECTRONICO.getDescripcion()+ " -  POR EL NUMERO DE NOTARIO: "+ tramite.getId_fedatario());
		
		tramite.setListaSeguimientos(new ArrayList<SeguimientoTramite>());
		tramite.getListaSeguimientos().add(new SeguimientoTramite());
		
		
		tramite.getListaSeguimientos().get(0).setDescripcion(OrigenTramite._ELECTRONICO.getDescripcion());
		tramite.getListaSeguimientos().get(0).setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ENTRA A: " + Areas._AREA_PROTOCOLO.getDescripcion());
		tramite.getListaSeguimientos().get(0).setStatus(Status._PRESENTADO.getTipo());
		tramite.getListaSeguimientos().get(0).setStatus_gestion(StatusGestion._AVISO_INGRESO_PROTOCOLO.getTipo());
		tramite.getListaSeguimientos().get(0).setStatusDesc_gestion(StatusGestion._AVISO_INGRESO_PROTOCOLO.getDescripcion());
		tramite.getListaSeguimientos().get(0).setTramite(tramite);
		
		AcuseDAO acuseDAO = new AcuseDAOImpl();
		
		byte[] reporte = null;
		reporte = acuseDAO.acuseReporteAvisos(tramite.getId());
		if(reporte!=null){
			tramite.setAcuse(reporte);
		}
		
		if (tramiteDAO.update(tramite)) {
			Messagebox.show("¿DESEA IMPRIMIR SU ACUSE EN ESTE MOMENTO?", "TRAMITE :: GUARDADO",
					Messagebox.YES | Messagebox.IGNORE, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
				public void onEvent(Event event) throws Exception {
					  if (event.getName().equals(Messagebox.ON_YES)) {
						  Map map  = new HashMap();
						  map.put("acusePDF", tramite.getAcuse());
						  Executions.createComponents("/reportes/acuse.zul", null, map);
				        }
					  else if (event.getName().equals(Messagebox.ON_NO)) {
				            Messagebox.show("Favor de descargar el PDF", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
				        } 
				}
			});
			updateBandeja();
		}
	}
	
	@Command
	public void newAviso() {
		Executions.createComponents("/avisosNotariales/avisosNotariales.zul", null, null);
	}
	
	public List<BeanAvisosNotarialesBandeja> getLista() {
		return lista;
	}
	public void setLista(List<BeanAvisosNotarialesBandeja> lista) {
		this.lista = lista;
	}
	
}
