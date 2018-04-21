package org.CopiasCertificadas.view.vm.copias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.CopiasCertificadas.view.validate.ValidationMessagePublish;
import org.CopiasCertificadas.view.validate.showWindow;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;

import bsh.This;
import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.Areas;
import copiasCertificadas.persist.model.domain.enums.ModalidadCopias;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.StatusGestion;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.copias.CopiaCertificada;
import copiasCertificadas.persist.model.domain.ventanilla.copias.Domicilio;
import copiasCertificadas.persist.model.domain.ventanilla.copias.Notario;
import copiasCertificadas.persist.model.domain.ventanilla.instrumento.Instrumento;
import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

public class VUCCYTNotarioVM implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363863962795613859L;
	
	private Tramite tramite;
	private List<Pagos> listaPagos;
	private Instrumento instrumento;
	private List<Instrumento> listainstrumento;
	private List<String> origen;
	
	private TramiteDAO tramiteDAO;
	
	
	@Init
	public void init() {
		origen = new ArrayList<String>();
		origen.add("CIUDAD DE MÉXICO");
		origen.add("OTROS ESTADOS");
		initVariables();
	}
	
	private void initVariables() {
		// TODO Auto-generated method stub
		tramite = new Tramite();
		tramite.setCopiaCertificada(new CopiaCertificada());
		tramite.getCopiaCertificada().setNotario(new Notario());
		tramite.getCopiaCertificada().setDomicilio(new Domicilio());
		listaPagos = new ArrayList<Pagos>();
		tramite.setListaPagos(listaPagos);
		instrumento = new Instrumento();
		listainstrumento = new ArrayList<Instrumento>();
		tramite.setListaInstrumento(listainstrumento);
		
		tramiteDAO = new TramiteDAOImpl();
	}
	
	@Command
	public void selectNotario(@BindingParam("btn") Menuitem btn, 
			@BindingParam("div1") Div div1, 
			@BindingParam("div2") Div div2, @BindingParam("d") Div d) {
		d.setVisible(true);
		
		
		if (btn.getId().equals("btn1")) {
			div1.setVisible(true);
			div2.setVisible(false);
		}else{
			div1.setVisible(false);
			div2.setVisible(true);
		}
	}
	
	private boolean validaciones(boolean local) {
		List<ValidationMessagePublish> lisV = new ArrayList<ValidationMessagePublish>();
		if (local) {
			
			if (this.
					tramite.
					getId_fedatario()
					== null)
				lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
			
		}else {
			
			if (this.tramite.getCopiaCertificada().getNotario().getNumNotario() == 0)
				lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
			if (this.tramite.getCopiaCertificada().getNotario().getNumNotaria() == 0)
				lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
			if (this.tramite.getCopiaCertificada().getNotario().getNombre() == null)
				lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
			if (this.tramite.getCopiaCertificada().getNotario().getPaterno() == null)
				lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
			if (this.tramite.getCopiaCertificada().getNotario().getMaterno() == null)
				lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
			if (this.tramite.getCopiaCertificada().getNotario().getEntidadLocalidad() == null)
				lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
		}
		
		if (this.tramite.getCopiaCertificada().getModalidad() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO MODALIDAD ES OBLIGATORIO"));
		
		if (this.tramite.getListaInstrumento().get(0).getNum_notaria() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIA ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getNombre_notario() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO NOMBRE DE NOTARIO DEL INSTRUMENTO ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getPaterno_notario() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO APELLIDO PATERNO DE NOTARIO DEL INSTRUMENTO ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getMaterno_notario() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO APELLIDO MATERNO DE NOTARIO DEL INSTRUMENTO ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getNum_notario() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE NOTARIO ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getFecha_otorgamiento() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO FECHA DE OTORGAMIENTO DE INSTRUMENTO ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getNum_instrumento() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE INSTRUMENTO ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getVolumen() == null)
			lisV.add(new ValidationMessagePublish("EL CAMPO VOLUMEN DE INSTRUMENTO ES OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getNum_suplente()== 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE SUPLENTE OBLIGATORIO"));
		if (this.tramite.getListaInstrumento().get(0).getNum_asociado() == 0)
			lisV.add(new ValidationMessagePublish("EL CAMPO NUMERO DE ASOCIADO ES OBLIGATORIO"));
		
		if (this.tramite.getListaPagos().size() <= 0)
			lisV.add(new ValidationMessagePublish("LOS CAMPOS PARA PAGOS SON OBLIGATORIOS"));
		
		
		if (lisV.size() > 0) {
			showWindow.ShowValidation(lisV);
			return false;
		}else{
			return true;
		}
	}
	
	@Command
	public void saveTramite(@BindingParam("div1") Div div) {
		this.instrumento.setTramite(tramite);
		this.listainstrumento.add(this.instrumento);
		this.tramite.setListaInstrumento(this.listainstrumento);
	Bitacora bitacora = new Bitacora();
	
		bitacora.setArea_origen(Areas._VENTANILLA_FISICA.getTipo());
		bitacora.setArea_turnado(Areas._AREA_ADMINISTRACION_DE_ACERVOS.getTipo());
		bitacora.setObservaciones("INGRESO: "+ OrigenTramite._FISICO.getDescripcion());
		bitacora.setStatus(Status._PRESENTADO.getTipo());
		bitacora.setTramite(tramite);
		bitacora.setUsuario("USUARIO EN VENTANILLA");
	
	this.tramite.setListaBitacora(new ArrayList<Bitacora>());
	this.tramite.getListaBitacora().add(bitacora);
	
	SeguimientoTramite seguimientoTramite = new SeguimientoTramite();
	
		seguimientoTramite.setDescripcion("INGRESO: "+ OrigenTramite._FISICO.getDescripcion());
		seguimientoTramite.setObservaciones("INGRESO: "+ OrigenTramite._FISICO.getDescripcion() + "ESTADO ACTUAL: " + Status._PRESENTADO.getTipo());
		seguimientoTramite.setStatus(Status._PRESENTADO.getTipo());
		seguimientoTramite.setStatus_gestion(StatusGestion._POR_ASIGNAR_A_BUSCADOR.getTipo());
		seguimientoTramite.setStatusDesc_gestion(StatusGestion._POR_ASIGNAR_A_BUSCADOR.getDescripcion());
		seguimientoTramite.setTramite(tramite);
		
	this.tramite.setListaSeguimientos(new ArrayList<SeguimientoTramite>());
	this.tramite.getListaSeguimientos().add(seguimientoTramite);
	this.tramite.setCreado(new Date());
	
		if (div.isVisible()) {
			this.tramite.getCopiaCertificada().setNotario(null);
			this.tramite.setFolio("VUCCyT - VENTANILLA NOTARIO CDMX");
			if (this.validaciones(true)) {
				if (tramiteDAO.saveUpdate(this.tramite)!=null) {
					Messagebox.show("T R A M I T E - G U A R D A D O");
				}
			}
		}else{
			tramite.setId_fedatario(null);
			if (this.validaciones(false)) {
				this.tramite.setFolio("VUCCyT - VENTANILLA NOTARIO ESTADOS");
				if (tramiteDAO.saveUpdate(this.tramite)!=null) {
					Messagebox.show("T R A M I T E - G U A R D A D O");
				}
			}
		}
		this.initVariables();
	}
	
	
	@Command
	public void showAddPago() {
		Executions.createComponents("/copias/pagos/addPagoVentanillaNotarios.zul", null, null);
	}
	
	@GlobalCommand
	@NotifyChange("tramite")
	public void addPagoV_N(@BindingParam("pago") Pagos pago, @BindingParam("editar") boolean editar) {
		if (editar) {
			
		}else{
			pago.setTramite(tramite);
			this.tramite.getListaPagos().add(pago);
		}
	}
	
	@GlobalCommand
	@NotifyChange("tramite")
	public void deletePagoVentanilla_N(@BindingParam("pago") Pagos pago) {
		this.tramite.getListaPagos().remove(pago);
		
	}
	
	public List<String> getOrigen() {
		return origen;
	}
	public void setOrigen(List<String> origen) {
		this.origen = origen;
	}

	private List<String> modalidades = ModalidadCopias.getAllModalidades();
	
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

	public List<Pagos> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pagos> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
}
