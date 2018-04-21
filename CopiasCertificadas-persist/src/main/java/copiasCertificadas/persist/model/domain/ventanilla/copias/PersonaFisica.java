package copiasCertificadas.persist.model.domain.ventanilla.copias;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona_Fisica", catalog="ventanilladgjyel")
public class PersonaFisica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3944117259439489811L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column
	private String nombre;

	@Column
	private String paterno;

	@Column
	private String materno;
	
	@Column
	private String tipoIdentificacion;
	
	@Column
	private String folioIdentificacion;
	
	@OneToOne(mappedBy="personaFisica", cascade = CascadeType.ALL)
	private CopiaCertificada copiaCertificada;

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

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getFolioIdentificacion() {
		return folioIdentificacion;
	}

	public void setFolioIdentificacion(String folioIdentificacion) {
		this.folioIdentificacion = folioIdentificacion;
	}

	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}

	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}
}
