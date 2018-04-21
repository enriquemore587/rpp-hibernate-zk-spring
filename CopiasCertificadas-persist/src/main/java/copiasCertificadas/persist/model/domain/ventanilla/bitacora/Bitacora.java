package copiasCertificadas.persist.model.domain.ventanilla.bitacora;

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
@Table(name="bitacora",catalog="ventanilladgjyel")
public class Bitacora implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1214549832753983652L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="creado",columnDefinition="TIMESTAMP")
	private Date creado = new Date();
	
	@Column(name="status")
	private String status;
	
	@Column(name="observaciones", columnDefinition="TEXT")
	private String observaciones;
	
	@Column(name="area_origen")
	private String area_origen;
	
	@Column(name="area_turnado")
	private String area_turnado;
	
	@Column(name="usuario")
	private String usuario;
	
	@ManyToOne
	@JoinColumn(name="tramite_id")
	private Tramite tramite;// se realiza la relacion con tramite 

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getArea_origen() {
		return area_origen;
	}

	public void setArea_origen(String area_origen) {
		this.area_origen = area_origen;
	}

	public String getArea_turnado() {
		return area_turnado;
	}

	public void setArea_turnado(String area_turnado) {
		this.area_turnado = area_turnado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}
}
