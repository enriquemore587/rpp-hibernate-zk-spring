package copiasCertificadas.persist.model.domain.ventanilla;

import java.io.Serializable;
import java.util.Date;

public class BeanCopiasCertificadas implements Serializable{
	
	
	
	private String folio;

	private String status;
	
	private String statusGestion;
	
	private String modalidad;

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusGestion() {
		return statusGestion;
	}

	public void setStatusGestion(String statusGestion) {
		this.statusGestion = statusGestion;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((folio == null) ? 0 : folio.hashCode());
		result = prime * result + ((modalidad == null) ? 0 : modalidad.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statusGestion == null) ? 0 : statusGestion.hashCode());
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
		BeanCopiasCertificadas other = (BeanCopiasCertificadas) obj;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusGestion == null) {
			if (other.statusGestion != null)
				return false;
		} else if (!statusGestion.equals(other.statusGestion))
			return false;
		return true;
	}

	public BeanCopiasCertificadas(String folio, String status, String statusGestion, String modalidad) {
		super();
		this.folio = folio;
		this.status = status;
		this.statusGestion = statusGestion;
		this.modalidad = modalidad;
	}

		
}