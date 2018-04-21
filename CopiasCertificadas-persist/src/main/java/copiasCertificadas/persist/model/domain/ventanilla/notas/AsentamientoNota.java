package copiasCertificadas.persist.model.domain.ventanilla.notas;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="asentamientoNota" , catalog="ventanilladgjyel")
public class AsentamientoNota implements Serializable,Cloneable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column
	private Integer numero_instrumento;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date fecha_instrumento;
	
	@Column
	private String nombre_notario;
	
	@Column
	private String paterno_notario;
	
	@Column
	private String materno_notario;
	
	@Column
	private Integer numero_notario;
	
	@Column
	private String protocolo_actua;
	

	@OneToOne(mappedBy="asentamientoNota",fetch=FetchType.EAGER)
	private NotaComplementaria notaComplementaria;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getNumero_instrumento() {
		return numero_instrumento;
	}

	public void setNumero_instrumento(Integer numero_instrumento) {
		this.numero_instrumento = numero_instrumento;
	}

	public Date getFecha_instrumento() {
		return fecha_instrumento;
	}

	public void setFecha_instrumento(Date fecha_instrumento) {
		this.fecha_instrumento = fecha_instrumento;
	}

	public String getNombre_notario() {
		return nombre_notario;
	}

	public void setNombre_notario(String nombre_notario) {
		this.nombre_notario = nombre_notario;
	}

	public String getPaterno_notario() {
		return paterno_notario;
	}

	public void setPaterno_notario(String paterno_notario) {
		this.paterno_notario = paterno_notario;
	}

	public String getMaterno_notario() {
		return materno_notario;
	}

	public void setMaterno_notario(String materno_notario) {
		this.materno_notario = materno_notario;
	}

	public Integer getNumero_notario() {
		return numero_notario;
	}

	public void setNumero_notario(Integer numero_notario) {
		this.numero_notario = numero_notario;
	}

	public String getProtocolo_actua() {
		return protocolo_actua;
	}

	public void setProtocolo_actua(String protocolo_actua) {
		this.protocolo_actua = protocolo_actua;
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
