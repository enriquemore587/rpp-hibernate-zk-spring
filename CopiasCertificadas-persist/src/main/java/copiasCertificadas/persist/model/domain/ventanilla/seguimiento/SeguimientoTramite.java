package copiasCertificadas.persist.model.domain.ventanilla.seguimiento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

@Entity
@Table(name="tramite_seguimiento",catalog="ventanilladgjyel")
public class SeguimientoTramite implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	
	@Column
	private String status;
	
	@Column
	private String descripcion;
	
	@Column
	private String status_gestion;
	
	@Column
	private String statusDesc_gestion;
	
	@Column(name = "observaciones", columnDefinition = "MEDIUMTEXT")
	private String observaciones;
	
	@Column(name="creado",columnDefinition="TIMESTAMP")
	private Date creado = new Date();
	
	@ManyToOne
	@JoinColumn(name="tramite_id")
	private Tramite tramite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStatus_gestion() {
		return status_gestion;
	}

	public void setStatus_gestion(String status_gestion) {
		this.status_gestion = status_gestion;
	}

	public String getStatusDesc_gestion() {
		return statusDesc_gestion;
	}

	public void setStatusDesc_gestion(String statusDesc_gestion) {
		this.statusDesc_gestion = statusDesc_gestion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	
}
