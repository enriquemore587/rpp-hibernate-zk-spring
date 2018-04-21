package copiasCertificadas.persist.model.domain.ventanilla;

import java.util.Date;

public class CP_NotarioSesion {
	private String folio;
	private String modalidad;
	private String estatus;
	private Date fechaSolicitud;
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((fechaSolicitud == null) ? 0 : fechaSolicitud.hashCode());
		result = prime * result + ((folio == null) ? 0 : folio.hashCode());
		result = prime * result + ((modalidad == null) ? 0 : modalidad.hashCode());
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
		CP_NotarioSesion other = (CP_NotarioSesion) obj;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (fechaSolicitud == null) {
			if (other.fechaSolicitud != null)
				return false;
		} else if (!fechaSolicitud.equals(other.fechaSolicitud))
			return false;
		if (folio == null) {
			if (other.folio != null)
				return false;
		} else if (!folio.equals(other.folio))
			return false;
		if (modalidad == null) {
			if (other.modalidad != null)
				return false;
		} else if (!modalidad.equals(other.modalidad))
			return false;
		return true;
	}
	public CP_NotarioSesion(String folio, String modalidad, String estatus, Date fechaSolicitud) {
		super();
		this.folio = folio;
		this.modalidad = modalidad;
		this.estatus = estatus;
		this.fechaSolicitud = fechaSolicitud;
	}
	
	
	
}
