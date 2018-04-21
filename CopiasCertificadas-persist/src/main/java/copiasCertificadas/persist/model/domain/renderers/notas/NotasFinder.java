package copiasCertificadas.persist.model.domain.renderers.notas;

import java.util.Date;

public class NotasFinder {
	
	private Long id;	
	private String identificadorTramite;	
	private String tipoNota;	
	private Date fechaRecepcion;		
	private String estatus;
	
	public NotasFinder() {	
		
	}

	public NotasFinder(Long id, String identificadorTramite, String tipoNota, Date fechaRecepcion, String estatus) {
		super();
		this.id = id;
		this.identificadorTramite = identificadorTramite;
		this.tipoNota = tipoNota;
		this.fechaRecepcion = fechaRecepcion;
		this.estatus = estatus;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the identificadorTramite
	 */
	public String getIdentificadorTramite() {
		return identificadorTramite;
	}

	/**
	 * @param identificadorTramite the identificadorTramite to set
	 */
	public void setIdentificadorTramite(String identificadorTramite) {
		this.identificadorTramite = identificadorTramite;
	}

	/**
	 * @return the tipoNota
	 */
	public String getTipoNota() {
		return tipoNota;
	}

	/**
	 * @param tipoNota the tipoNota to set
	 */
	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	/**
	 * @return the fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
	
	
	

}
