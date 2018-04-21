package org.CopiasCertificadas.view.vm.copias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.CopiasCertificadas.view.enums.Identificaciones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;

import copiasCertificadas.persist.model.domain.enums.ModalidadCopias;



public class VUCCYTPersonaFisicaVM implements Serializable{
	public static final Logger LOG = Logger.getLogger(VUCCYTPersonaFisicaVM.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = -9068369115257700135L;
	
	@Init
	public void init() {
		// TODO Auto-generated method stub

	}
	
	private String usuario = "ENRIQUE2104";
	private String folioTramite = "VUCCYT - "+(new Date()).getTime();
	private List<String> identificaciones = Identificaciones.getAllIdentificaciones();
	
	
	
	public List<String> getIdentificaciones() {
		return identificaciones;
	}
	public void setIdentificaciones(List<String> identificaciones) {
		this.identificaciones = identificaciones;
	}	
	private List<String> modalidades = ModalidadCopias.getAllModalidades();
	
	public List<String> getModalidades() {
		return modalidades;
	}
	public void setModalidades(List<String> modalidades) {
		this.modalidades = modalidades;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFolioTramite() {
		return folioTramite;
	}
	public void setFolioTramite(String folioTramite) {
		this.folioTramite = folioTramite;
	}
	
	
	
		
}
