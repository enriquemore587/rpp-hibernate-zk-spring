package copiasCertificadas.persist.model.domain.ventanilla.notas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="interesado",catalog="ventanilladgjyel")
public class Interesado implements Serializable,Cloneable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String paterno;
	
	@Column
	private String materno;
	
	@Column
	private String domicilio;
	
	@Column
	private String documentoQAcreditaRepresentacion;
	
	@Column
	private String documentoQAcreditaInteres;
	
	@Column
	private Integer numeroNotario;
	
	@Column
	private Integer idNotario;//obtener de sesion
	
	@Column
	private String entidad;//combo
	
	private String personaAutorizada;
	
	@OneToOne(mappedBy="interesado",fetch=FetchType.EAGER)
	private NotaComplementaria notaComplementaria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDocumentoQAcreditaRepresentacion() {
		return documentoQAcreditaRepresentacion;
	}

	public void setDocumentoQAcreditaRepresentacion(String documentoQAcreditaRepresentacion) {
		this.documentoQAcreditaRepresentacion = documentoQAcreditaRepresentacion;
	}

	public String getDocumentoQAcreditaInteres() {
		return documentoQAcreditaInteres;
	}

	public void setDocumentoQAcreditaInteres(String documentoQAcreditaInteres) {
		this.documentoQAcreditaInteres = documentoQAcreditaInteres;
	}

	public Integer getNumeroNotario() {
		return numeroNotario;
	}

	public void setNumeroNotario(Integer numeroNotario) {
		this.numeroNotario = numeroNotario;
	}

	public Integer getIdNotario() {
		return idNotario;
	}

	public void setIdNotario(Integer idNotario) {
		this.idNotario = idNotario;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getPersonaAutorizada() {
		return personaAutorizada;
	}

	public void setPersonaAutorizada(String personaAutorizada) {
		this.personaAutorizada = personaAutorizada;
	}

	public NotaComplementaria getNotaComplementaria() {
		return notaComplementaria;
	}

	public void setNotaComplementaria(NotaComplementaria notaComplementaria) {
		this.notaComplementaria = notaComplementaria;
	}
	
	public Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}


}
