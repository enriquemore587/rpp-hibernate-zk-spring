package copiasCertificadas.persist.model.domain.ventanilla.avisos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;


@Entity
@Table(catalog="ventanilladgjyel")
public class AvisosNotariales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5449219845997963008L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "modalidad")
	private String modalidad;
	
	@Column(name= "preDescripcionAviso")
	private String preDescripcionAviso;
	
	@Column
	private String descripcionAviso;
	
	@Lob
	private byte[] oficio;
	
	@OneToOne(mappedBy="avisosNotariales", cascade=CascadeType.ALL)
	private Tramite tramite;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getPreDescripcionAviso() {
		return preDescripcionAviso;
	}

	public void setPreDescripcionAviso(String preDescripcionAviso) {
		this.preDescripcionAviso = preDescripcionAviso;
	}

	public String getDescripcionAviso() {
		return descripcionAviso;
	}

	public void setDescripcionAviso(String descripcionAviso) {
		this.descripcionAviso = descripcionAviso;
	}

	public byte[] getOficio() {
		return oficio;
	}

	public void setOficio(byte[] oficio) {
		this.oficio = oficio;
	}

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}
	
	
}
