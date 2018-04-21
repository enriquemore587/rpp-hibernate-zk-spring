package copiasCertificadas.persist.model.domain.ventanilla.copias;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="reprecentante_legal",catalog="ventanilladgjyel")
public class Representante_legal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2350969997814736314L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="paterno")
	private String paterno;
	
	@Column(name="materno")
	private String materno;
	
	@Column(name="identificacion_oficial")
	private String identificacion_oficial;
	
	@Column
	private String folioIdentificacion;
	 
	@Column(name="num_escrrtura_poliza_exp")
	private int num_escritura_poliza_exp;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_escritura_poliza_exp")
	private Date fechaEscrituraPolizaExp;
	
	@Column(name="nombre_notario_corredor_juez")
	private String nombre_notario_corredor_juez;
	
	@Column(name="entidad_federativa")
	private String entidad_federativa;
	
	@Column(name="nom_notario_correduria_juzgado")
	private int nom_notaria_correduria_juzgado;
	
	@OneToOne(mappedBy="representante_legal", cascade= CascadeType.ALL)
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

	public String getIdentificacion_oficial() {
		return identificacion_oficial;
	}

	public void setIdentificacion_oficial(String identificacion_oficial) {
		this.identificacion_oficial = identificacion_oficial;
	}

	public String getFolioIdentificacion() {
		return folioIdentificacion;
	}

	public void setFolioIdentificacion(String folioIdentificacion) {
		this.folioIdentificacion = folioIdentificacion;
	}

	public int getNum_escritura_poliza_exp() {
		return num_escritura_poliza_exp;
	}

	public void setNum_escritura_poliza_exp(int num_escritura_poliza_exp) {
		this.num_escritura_poliza_exp = num_escritura_poliza_exp;
	}

	public Date getFechaEscrituraPolizaExp() {
		return fechaEscrituraPolizaExp;
	}

	public void setFechaEscrituraPolizaExp(Date fechaEscrituraPolizaExp) {
		this.fechaEscrituraPolizaExp = fechaEscrituraPolizaExp;
	}

	public String getNombre_notario_corredor_juez() {
		return nombre_notario_corredor_juez;
	}

	public void setNombre_notario_corredor_juez(String nombre_notario_corredor_juez) {
		this.nombre_notario_corredor_juez = nombre_notario_corredor_juez;
	}

	public String getEntidad_federativa() {
		return entidad_federativa;
	}

	public void setEntidad_federativa(String entidad_federativa) {
		this.entidad_federativa = entidad_federativa;
	}

	public int getNom_notaria_correduria_juzgado() {
		return nom_notaria_correduria_juzgado;
	}

	public void setNom_notaria_correduria_juzgado(int nom_notaria_correduria_juzgado) {
		this.nom_notaria_correduria_juzgado = nom_notaria_correduria_juzgado;
	}

	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}

	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}
	
}