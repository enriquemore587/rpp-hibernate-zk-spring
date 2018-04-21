package copiasCertificadas.persist.model.domain.ventanilla.copias;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

@Entity
@Table(catalog="ventanilladgjyel")
public class CopiaCertificada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -494792673173695729L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="domicilio_id")
	private Domicilio domicilio;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="personaFisica_id")
	private PersonaFisica personaFisica;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="personaMoral_id")
	private PersonaMoral personaMoral;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="notario_id")
	private Notario notario;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="representante_legal")
	private Representante_legal representante_legal;
	
	@OneToOne(mappedBy="copiaCertificada", cascade=CascadeType.ALL)
	private Tramite tramite;
	
	@Column
	public String modalidad;
	
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public PersonaFisica getPersonaFisica() {
		return personaFisica;
	}

	public void setPersonaFisica(PersonaFisica personaFisica) {
		this.personaFisica = personaFisica;
	}

	public PersonaMoral getPersonaMoral() {
		return personaMoral;
	}

	public void setPersonaMoral(PersonaMoral personaMoral) {
		this.personaMoral = personaMoral;
	}

	public Representante_legal getRepresentante_legal() {
		return representante_legal;
	}

	public void setRepresentante_legal(Representante_legal representante_legal) {
		this.representante_legal = representante_legal;
	}

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Notario getNotario() {
		return notario;
	}

	public void setNotario(Notario notario) {
		this.notario = notario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
