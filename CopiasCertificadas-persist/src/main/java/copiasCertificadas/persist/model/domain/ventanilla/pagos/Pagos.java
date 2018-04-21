package copiasCertificadas.persist.model.domain.ventanilla.pagos;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

@Entity
@Table(name="pagos", catalog="ventanilladgjyel")
public class Pagos implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7095168848459069922L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
    
	@Column(name="linea_captura")
	private String linea_captura;
    
	@Column(name="importe")
	private Double importe;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fecha_pago;
	
	@ManyToOne
	@JoinColumn(name="tramite_id")
	private Tramite tramite;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLinea_captura() {
		return linea_captura;
	}
	public void setLinea_captura(String linea_captura) {
		this.linea_captura = linea_captura;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Tramite getTramite() {
		return tramite;
	}
	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	
	public Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}
	
}
