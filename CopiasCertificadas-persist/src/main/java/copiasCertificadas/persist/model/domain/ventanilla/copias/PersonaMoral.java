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
@Table(catalog="ventanilladgjyel")
public class PersonaMoral implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -264370821672445772L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column
	private String denominacion;
	
	@Column
	private String tipoDocumento;
	
	@Column
	private String numeroFolioActaPoliza;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date fechaotorgamiento;
	
	@Column
	private String nombreNotarioCorredor;
	
	@Column
	private Integer numNotariaCorreduria;
	
	@Column
	private String entidad;

	@OneToOne(mappedBy="personaMoral", cascade = CascadeType.ALL)
	private CopiaCertificada copiaCertificada;

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroFolioActaPoliza() {
		return numeroFolioActaPoliza;
	}

	public void setNumeroFolioActaPoliza(String numeroFolioActaPoliza) {
		this.numeroFolioActaPoliza = numeroFolioActaPoliza;
	}

	public Date getFechaotorgamiento() {
		return fechaotorgamiento;
	}

	public void setFechaotorgamiento(Date fechaotorgamiento) {
		this.fechaotorgamiento = fechaotorgamiento;
	}

	public String getNombreNotarioCorredor() {
		return nombreNotarioCorredor;
	}

	public void setNombreNotarioCorredor(String nombreNotarioCorredor) {
		this.nombreNotarioCorredor = nombreNotarioCorredor;
	}

	public Integer getNumNotariaCorreduria() {
		return numNotariaCorreduria;
	}

	public void setNumNotariaCorreduria(Integer numNotariaCorreduria) {
		this.numNotariaCorreduria = numNotariaCorreduria;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}

	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}
	
	
}