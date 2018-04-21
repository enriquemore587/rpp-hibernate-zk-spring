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
@Table(name="notario",catalog="ventanilladgjyel")
public class Notario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2518722916012625386L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column
	private String nombre;

	@Column
	private String paterno;

	@Column
	private String materno;
	
	
	@Column(name="num_notario")
	private int numNotario;
	
	@Column(name="entidad_localidad")
	private String entidadLocalidad;

	
	@Column(name="num_notaria")
	private int numNotaria;
	
	@OneToOne(mappedBy="notario", cascade = CascadeType.ALL)
	private CopiaCertificada copiaCertificada;

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

	public int getNumNotario() {
		return numNotario;
	}

	public void setNumNotario(int numNotario) {
		this.numNotario = numNotario;
	}

	public String getEntidadLocalidad() {
		return entidadLocalidad;
	}

	public void setEntidadLocalidad(String entidadLocalidad) {
		this.entidadLocalidad = entidadLocalidad;
	}

	public int getNumNotaria() {
		return numNotaria;
	}

	public void setNumNotaria(int numNotaria) {
		this.numNotaria = numNotaria;
	}

	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}

	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
