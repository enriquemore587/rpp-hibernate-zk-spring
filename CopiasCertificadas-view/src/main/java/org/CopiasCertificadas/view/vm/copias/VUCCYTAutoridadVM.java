package org.CopiasCertificadas.view.vm.copias;

import java.io.Serializable;
import java.util.Date;

import org.zkoss.bind.annotation.Init;

public class VUCCYTAutoridadVM implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1490894239062378178L;
	
	
	private String usuario = "ENRIQUE2104";
	private String folioTramite = "VUCCYT - "+(new Date()).getTime();
	
	@Init
	public void init() {

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
