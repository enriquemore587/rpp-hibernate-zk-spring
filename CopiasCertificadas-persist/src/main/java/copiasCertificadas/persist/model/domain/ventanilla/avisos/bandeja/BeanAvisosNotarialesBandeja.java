package copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja;

import java.io.Serializable;
import java.util.Date;

public class BeanAvisosNotarialesBandeja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7018685455467060780L;
	
	private Long id;
	
	private String folio;
	
	private Date fecha;
	
	private String tipoAviso;
	
	private String estatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoAviso() {
		return tipoAviso;
	}

	public void setTipoAviso(String tipoAviso) {
		this.tipoAviso = tipoAviso;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BeanAvisosNotarialesBandeja(Long id, String folio, Date fecha, String tipoAviso, String estatus) {
		super();
		this.id = id;
		this.folio = folio;
		this.fecha = fecha;
		this.tipoAviso = tipoAviso;
		this.estatus = estatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((folio == null) ? 0 : folio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipoAviso == null) ? 0 : tipoAviso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanAvisosNotarialesBandeja other = (BeanAvisosNotarialesBandeja) obj;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (folio == null) {
			if (other.folio != null)
				return false;
		} else if (!folio.equals(other.folio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoAviso == null) {
			if (other.tipoAviso != null)
				return false;
		} else if (!tipoAviso.equals(other.tipoAviso))
			return false;
		return true;
	}

}
