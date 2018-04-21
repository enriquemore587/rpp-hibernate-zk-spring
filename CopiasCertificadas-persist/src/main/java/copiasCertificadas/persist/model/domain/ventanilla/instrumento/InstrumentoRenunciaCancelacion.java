package copiasCertificadas.persist.model.domain.ventanilla.instrumento;

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

import copiasCertificadas.persist.model.domain.ventanilla.notas.NotaComplementaria;

@Entity
@Table(name="instrumentoRenunciaCancelacion", catalog="ventanilladgjyel")
public class InstrumentoRenunciaCancelacion implements Serializable,Cloneable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column
	private Integer numero_instrumento;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "fecha_instrumento")
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
	
	@Column
	private String sup_asoc;
	
	
	@Column
	private String numero_sup_asoc;
	
	@ManyToOne
	@JoinColumn(name="nota_id")	
	private NotaComplementaria nota_complementaria;
	
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

	public NotaComplementaria getNota_complementaria() {
		return nota_complementaria;
	}

	public void setNota_complementaria(NotaComplementaria nota_complementaria) {
		this.nota_complementaria = nota_complementaria;
	}

	public String getSup_asoc() {
		return sup_asoc;
	}

	public void setSup_asoc(String sup_asoc) {
		this.sup_asoc = sup_asoc;
	}

	public String getNumero_sup_asoc() {
		return numero_sup_asoc;
	}

	public void setNumero_sup_asoc(String numero_sup_asoc) {
		this.numero_sup_asoc = numero_sup_asoc;
	}

	
	public Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}

	
	
	

}
