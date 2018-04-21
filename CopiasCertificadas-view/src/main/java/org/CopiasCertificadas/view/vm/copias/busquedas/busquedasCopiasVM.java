package org.CopiasCertificadas.view.vm.copias.busquedas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.CopiasCertificadas.view.validate.ValidationMessagePublish;
import org.CopiasCertificadas.view.validate.showWindow;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.ModalidadCopias;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.ventanilla.BeanCopiasCertificadas;
import copiasCertificadas.persist.model.domain.ventanilla.CP_NotarioSesion;
import copiasCertificadas.persist.model.domain.ventanilla.CopiasCertificadasNotario;

public class busquedasCopiasVM implements Serializable {
	
	public static final Logger LOG = Logger.getLogger(busquedasCopiasVM.class.getName());
	
	List<BeanCopiasCertificadas> listaTramites = new ArrayList<BeanCopiasCertificadas>();
	private List<String> modalidades = ModalidadCopias.getAllModalidades();
	private String folio;
	private String lblNumNotario;
	TramiteDAO tramiteDAO;

	@Wire("#txtNomNotario")
	Textbox txtNomNotario;

	@Wire("#txtAPNotario")
	Textbox txtAPNotario;

	@Wire("#txtAMNotario")
	Textbox txtAMNotario;
	private List<String> listaStatus = Status.obtenerTodosTipo();
	private String valorcmb, valorcmb2;
	
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

	public List<String> getListaStatus() {
		return listaStatus;
	}

	public void setListaStatus(List<String> listaStatus) {
		this.listaStatus = listaStatus;
	}

	@Init
	public void init() {
		tramiteDAO = new TramiteDAOImpl();
		load();
	}

	@NotifyChange("listaTramites")
	@Command	
	public void findByModalidad() {
		LOG.log(Level.INFO, "Cargando Lista de tramites CON MODALIDAD DE  " + valorcmb);
		listaTramites.clear();
		listaTramites = tramiteDAO.getallCPByModalidad(valorcmb);
	}
	
	@NotifyChange("listaTramites")
	@Command	
	public void findByStatus() {
		LOG.log(Level.INFO, "Cargando Lista de tramites CON status de " + valorcmb2);
		listaTramites.clear();
		listaTramites = tramiteDAO.getallCPByStatus(valorcmb2);
	}
	

	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
    }
	
	private boolean validarCampos() {
		List<ValidationMessagePublish> listValid = new ArrayList<ValidationMessagePublish>();
		if (txtNomNotario.getText().equals(""))
			listValid.add(new ValidationMessagePublish("EL CAMPO NOMBRE DE REPRESENTANTE ES OBLIGATORIO"));
		if (txtAPNotario.getText().equals(""))
			listValid.add(new ValidationMessagePublish("EL CAMPO DE APELLIDO PATERNO DE REPRESENTANTE ES OBLIGATORIO"));
		if (txtAMNotario.getText().equals(""))
			listValid.add(new ValidationMessagePublish("EL CAMPO DE APELLIDO MATERNO DE REPRESENTANTE ES OBLIGATORIO"));
		if (listValid.size() > 0) {
			showWindow.ShowValidation(listValid);
			return false;
		}
		return true;
		
	}
	
	@Command
	@NotifyChange("listaTramites")
	public void findByFolio() {
		LOG.log(Level.INFO, "cargando");		
		
		listaTramites.clear();
		
		listaTramites = tramiteDAO.listaTramitesCPByFolio(folio);
	}
	
	
	@Command
	@NotifyChange(value="listaTramites")
	public void load() {
		LOG.log(Level.INFO, "cargando");		
				
		listaTramites.clear();
		
		listaTramites = tramiteDAO.listaTramitesCP();
	}

	public List<BeanCopiasCertificadas> getListaTramites() {
		return listaTramites;
	}

	public void setListaTramites(List<BeanCopiasCertificadas> listaTramites) {
		this.listaTramites = listaTramites;
	}

	public List<String> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<String> modalidades) {
		this.modalidades = modalidades;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}


	
}
