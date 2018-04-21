package org.CopiasCertificadas.view.vm;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tabbox;


public class SolicitudDeNotaVM implements Serializable{
	/*
	public static final Logger LOG =Logger.getLogger(SolicitudDeNotaVM.class.getName());
	
	private NotaComplementaria notaComplentaria;
	private Tramite tramite;
	private List<String>tiposDeNota=TiposDeNota.obtenerTodos();
	private String tipoDeNota;
	
	private List<String>supAsociado=CaracterNotario.obtenerTodos();
	private String supAsoc;
	
	@Wire("#tabs")
	Tabbox tabs;
	
	
	@Init
	public void init() {
		
	}

	 @AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
	       Selectors.wireComponents(view, this, false);
	       	       
	}

	@Command
	public void setValueTipoDeNota() {
		LOG.log(Level.INFO, "Selecciono "+getTipoDeNota());
		if(getTipoDeNota()!=null){
			if(getTipoDeNota().equals("REVOCACION")||getTipoDeNota().equals("RENUNCIA")){
				tabs.setVisible(true);
			}
			
			if(getTipoDeNota().equals("DATOS DE INSCRIPCION")||getTipoDeNota().equals("CANCELACION")||getTipoDeNota().equals("NULIDAD")){
				tabs.setVisible(false);
			}			
		}
				
	}
		
	@Command
	public void setValueSupAsoc() {
		LOG.log(Level.INFO, "Selecciono "+getSupAsoc());
	}
	
	public Tramite getTramite() {
		return tramite;
	}
	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}
	public NotaComplementaria getNotaComplentaria() {
		return notaComplentaria;
	}
	public void setNotaComplentaria(NotaComplementaria notaComplentaria) {
		this.notaComplentaria = notaComplentaria;
	}
	public List<String> getTiposDeNota() {
		return tiposDeNota;
	}
	public void setTiposDeNota(List<String> tiposDeNota) {
		this.tiposDeNota = tiposDeNota;
	}
	public String getTipoDeNota() {
		return tipoDeNota;
	}
	public void setTipoDeNota(String tipoDeNota) {
		this.tipoDeNota = tipoDeNota;
	}
	public List<String> getSupAsociado() {
		return supAsociado;
	}
	public void setSupAsociado(List<String> supAsociado) {
		this.supAsociado = supAsociado;
	}
	public String getSupAsoc() {
		return supAsoc;
	}
	public void setSupAsoc(String supAsoc) {
		this.supAsoc = supAsoc;
	}
*/	
}
