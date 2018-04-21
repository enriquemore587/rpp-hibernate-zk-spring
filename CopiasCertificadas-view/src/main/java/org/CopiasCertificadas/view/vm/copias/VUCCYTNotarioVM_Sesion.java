package org.CopiasCertificadas.view.vm.copias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.CopiasCertificadas.view.validate.ValidationMessagePublish;
import org.CopiasCertificadas.view.validate.showWindow;
import org.jfree.util.Log;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.Areas;
import copiasCertificadas.persist.model.domain.enums.ModalidadCopias;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.StatusGestion;
import copiasCertificadas.persist.model.domain.enums.TipoSolicitante;
import copiasCertificadas.persist.model.domain.ventanilla.CP_NotarioSesion;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.copias.CopiaCertificada;
import copiasCertificadas.persist.model.domain.ventanilla.instrumento.Instrumento;
import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;
import copiasCertificadas.reports.dao.AcuseDAO;
import copiasCertificadas.reports.dao.AcuseDAOImpl;


public class VUCCYTNotarioVM_Sesion implements Serializable{

	public static final Logger LOG=Logger.getLogger(VUCCYTNotarioVM_Sesion.class.getName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5363863962795613859L;
	
	
	private Tramite tramite;
	private CopiaCertificada copiaCertificada;
	private Instrumento instrumento;
	List<Instrumento> listaInstrumento;
	
	private SeguimientoTramite seguimientoTramite;
	List<SeguimientoTramite> listaSeguimientos;
	
	private List<Pagos> listaPagos;
	
	private List<Bitacora> listaBitacora;
	private Bitacora bitacora;
	
	
	private TramiteDAO tramiteDAO; 
	private List<CP_NotarioSesion> listCP = new ArrayList<CP_NotarioSesion>();
	private List<String> modalidades = ModalidadCopias.getAllModalidades();
	private List<String> modalidades2 = ModalidadCopias.getAllModalidades();
	private List<String> listaStatus = Status.obtenerTodosTipo();
	
	private String valorcmb, valorcmb2;
	
	@Wire
	Label lblname;
	
	@Wire
	Label lblNumNotario;
	
	@Wire
	Button btnSave;
	
	@Wire
	Window myW;
	
	@Init
	public void init() {
		initComponents();
	}
	
	private void initComponents() {
		tramite = new Tramite();
		
		copiaCertificada = new CopiaCertificada();
		copiaCertificada.setTramite(tramite);
		tramite.setCopiaCertificada(copiaCertificada);
		
		
		instrumento = new Instrumento();
		
		listaInstrumento = new ArrayList<Instrumento>();
		
		
		seguimientoTramite = new SeguimientoTramite();
		listaSeguimientos = new ArrayList<SeguimientoTramite>();
		tramite.setListaSeguimientos(listaSeguimientos);
		
		listaPagos = new ArrayList<Pagos>();
		tramite.setListaPagos(listaPagos);
		
		listaBitacora = new ArrayList<Bitacora>();
		bitacora = new Bitacora();
		tramite.setListaBitacora(listaBitacora);

		tramite.setId_fedatario(21);
		
		
		tramiteDAO = new TramiteDAOImpl();
		
	}
	
	@GlobalCommand
	@NotifyChange({"tramite", "instrumento"})
	public void editarCopia(@BindingParam("id") Long id) {
		
		this.tramite = tramiteDAO.getTramiteById(id);
		this.instrumento = this.tramite.getListaInstrumento().get(0);
	}
	
	@GlobalCommand
	@NotifyChange({"tramite", "instrumento"})
	public void verCopia(@BindingParam("id") Long id) {
		this.tramite = tramiteDAO.getTramiteById(id);
		this.instrumento = this.tramite.getListaInstrumento().get(0);
		btnSave.setDisabled(true);
	}
	
	
	@Command
	public void showAddPago() {
		Executions.createComponents("/copias/pagos/addPagoSesionNotario.zul", null, null);
	}
	
	@GlobalCommand
	@NotifyChange("tramite")
	public void pagoEmptyCopiasSesion(@BindingParam("pago") Pagos pagos) {
		pagos.setTramite(tramite);
		tramite.getListaPagos().add(pagos);
	}
	
	@GlobalCommand
	@NotifyChange("tramite")
	public void deletePagoCopiasSesion(@BindingParam("pago") Pagos pagos) {
		
		tramite.getListaPagos().remove(pagos);
	}
	
	@GlobalCommand
	public void updatePagoCopiasSesion(@BindingParam("pago") Pagos pagos) {
		
		showAddPago();
		
		Map map = new HashMap();
		
		map.put("pago", pagos);
		
		BindUtils.postGlobalCommand(null, null, "updatePagos", map);
		
		tramite.getListaPagos().remove(pagos);
	}
	
	public List<String> getModalidades2() {
		return modalidades2;
	}

	public void setModalidades2(List<String> modalidades2) {
		this.modalidades2 = modalidades2;
	}

	public List<String> getListaStatus() {
		return listaStatus;
	}

	public void setListaStatus(List<String> listaStatus) {
		this.listaStatus = listaStatus;
	}

	public List<String> getModalidades() {
		return modalidades;
	}
	public void setModalidades(List<String> modalidades) {
		this.modalidades = modalidades;
	}
	
	public Tramite getTramite() {
		return tramite;
	}
	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}
	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}
	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	public SeguimientoTramite getSeguimientoTramite() {
		return seguimientoTramite;
	}
	public void setSeguimientoTramite(SeguimientoTramite seguimientoTramite) {
		this.seguimientoTramite = seguimientoTramite;
	}
	public Bitacora getBitacora() {
		return bitacora;
	}
	public void setBitacora(Bitacora bitacora) {
		this.bitacora = bitacora;
	}
	
	
	
	
	
	private boolean isValidInput() {
		List<ValidationMessagePublish> lisV = new ArrayList<ValidationMessagePublish>();
		if (tramite.getCopiaCertificada().getModalidad() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO MODALIDAD ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getNum_notaria() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIA ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getNombre_notario() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO NOMBRE DE NOTARIO DEL INSTRUMENTO ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getPaterno_notario() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO APELLIDO PATERNO DE NOTARIO DEL INSTRUMENTO ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getMaterno_notario() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO APELLIDO MATERNO DE NOTARIO DEL INSTRUMENTO ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getNum_notario() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getFecha_otorgamiento() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO FECHA DE OTORGAMIENTO DE INSTRUMENTO ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getNum_instrumento() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE INSTRUMENTO ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getVolumen() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO VOLUMEN DE INSTRUMENTO ES OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getNum_suplente()== 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE SUPLENTE OBLIGATORIO"));
		if (tramite.getListaInstrumento().get(0).getNum_asociado() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE ASOCIADO ES OBLIGATORIO"));
		if (tramite.getListaPagos().size() <= 0)
			lisV.add(new ValidationMessagePublish("LOS CAMPOS PARA PAGOS SON OBLIGATORIOS"));
		
		if (lisV.size() > 0) {
			showWindow.ShowValidation(lisV);
			return false;
		}else{
			return true;
		}
	}
	
	@Command
	public void nuevaCopia() {
		listaInstrumento = new ArrayList<Instrumento>();
		instrumento.setTramite(tramite);
		listaInstrumento.add(instrumento);
		tramite.setListaInstrumento(listaInstrumento);
		
		tramite.setCreado(new Date());
		
		tramite.setFecha_recepcion(null);
		
		tramite.setFolio("VUCCYT - SESION - "+(new Date()).toString());
		
		tramite.setTipoSolicitante(TipoSolicitante._NOTARIO.getDescripcion());
		if (tramite.getListaBitacora().size() == 0 && tramite.getListaSeguimientos().size() == 0) {
				bitacora.setArea_origen(OrigenTramite._ELECTRONICO.getDescripcion());
				bitacora.setArea_turnado(null);
				bitacora.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ESTADO ACTUAL: " + Status._PORPRESENTAR.getTipo());
				bitacora.setStatus(Status._PORPRESENTAR.getTipo());
				bitacora.setTramite(tramite);
				bitacora.setUsuario(OrigenTramite._ELECTRONICO.getDescripcion()+ "POR EL NUMERO DE NOTARIO: "+ tramite.getId_fedatario());
			tramite.getListaBitacora().add(bitacora);
			
				seguimientoTramite.setDescripcion(OrigenTramite._ELECTRONICO.getDescripcion());
				seguimientoTramite.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ESTADO ACTUAL: " + Status._PORPRESENTAR.getTipo());
				seguimientoTramite.setStatus(Status._PORPRESENTAR.getTipo());
				seguimientoTramite.setStatus_gestion(Status._PORPRESENTAR.getTipo());
				seguimientoTramite.setStatusDesc_gestion(StatusGestion._CP_SESION_NOTARIO.getTipo());
				seguimientoTramite.setTramite(tramite);
			tramite.getListaSeguimientos().add(seguimientoTramite);
		}
			
		
		
		if (isValidInput()) {
			AcuseDAO acuseDAO = new AcuseDAOImpl();
			
			this.tramite = tramiteDAO.saveUpdate(tramite);
			if (this.tramite!=null) {
				byte[] reporte = acuseDAO.acuseReporteCC_sesion(tramite.getId());
				if (reporte!=null) {
					this.tramite.setAcuse(reporte);
					tramiteDAO.update(this.tramite);
					Messagebox.show("T R A M I T E - \"G U A R D A D O\"");
					Map map = new HashMap();
					map.put("acusePDF", reporte);
					Executions.createComponents("/reportes/acuse.zul", null, map);
					BindUtils.postGlobalCommand(null, null, "updateBandejaCopias", null);
					myW.detach();
				}	
			}
		}
		
	}
	
	@NotifyChange("listCP")
	@Command	
	public void findByModalidad() {
		LOG.log(Level.INFO, "Cargando Lista de tramites CON MODALIDAD DE  " + valorcmb);
		listCP.clear();
		listCP = tramiteDAO.getallCPByModalidad(tramite.getId_fedatario(),valorcmb);
	}
	
	@NotifyChange("listCP")
	@Command	
	public void findByStatus() {
		LOG.log(Level.INFO, "Cargando Lista de tramites CON status de " + valorcmb2);
		listCP.clear();
		listCP = tramiteDAO.getallCPByStatusNumNotario(tramite.getId_fedatario(),valorcmb2);
	}
	
	@NotifyChange("listCP")
	@Command
	public void loadGrid() {
		LOG.log(Level.INFO, "Cargando Lista de tramites COMPLETA");
		listCP.clear();
		listCP = tramiteDAO.getallCPByNumNotario(21);
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	public List<CP_NotarioSesion> getListCP() {
		return listCP;
	}

	public void setListCP(List<CP_NotarioSesion> listCP) {
		this.listCP = listCP;
	}

	public String getValorcmb() {
		return valorcmb;
	}

	public void setValorcmb(String valorcmb) {
		this.valorcmb = valorcmb;
	}

	public String getValorcmb2() {
		return valorcmb2;
	}

	public void setValorcmb2(String valorcmb2) {
		this.valorcmb2 = valorcmb2;
	}

	public List<Pagos> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pagos> listaPagos) {
		this.listaPagos = listaPagos;
	}
	
	
}
