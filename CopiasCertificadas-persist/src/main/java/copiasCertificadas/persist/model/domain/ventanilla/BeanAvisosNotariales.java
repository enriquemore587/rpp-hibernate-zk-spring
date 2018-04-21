package copiasCertificadas.persist.model.domain.ventanilla;

import java.io.Serializable;

public class BeanAvisosNotariales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7895763541398214458L;
	
	private String folio;
	
	private String modalidad;
	
	private String descripcion;
	
	private String estatus;

	public BeanAvisosNotariales(String folio, String modalidad, String descripcion, String estatus) {
		super();
		this.folio = folio;
		this.modalidad = modalidad;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
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
		BeanAvisosNotariales other = (BeanAvisosNotariales) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	

}
