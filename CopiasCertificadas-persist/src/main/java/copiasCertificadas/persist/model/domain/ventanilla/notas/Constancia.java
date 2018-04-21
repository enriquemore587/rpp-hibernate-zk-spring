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
@Table(name="constancia", catalog="ventanilladgjyel")
public class Constancia implements Serializable,Cloneable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String autoridad;
	
	@Column
	private String nombre_de_Documento;
	
	@Column
	private Integer numero_documento;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date fecha_documento;
	
	@OneToOne(mappedBy="constancia",fetch=FetchType.EAGER)
	private NotaComplementaria notaComplementaria;
	/*@OneToOne(mappedBy="constancia",fetch=FetchType.EAGER)
	private NotaComplementaria notaComplementaria;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutoridad() {
		return autoridad;
	}

	public void setAutoridad(String autoridad) {
		this.autoridad = autoridad;
	}

	public String getNombre_de_Documento() {
		return nombre_de_Documento;
	}

	public void setNombre_de_Documento(String nombre_de_Documento) {
		this.nombre_de_Documento = nombre_de_Documento;
	}

	public Integer getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Integer numero_documento) {
		this.numero_documento = numero_documento;
	}

	public Date getFecha_documento() {
		return fecha_documento;
	}

	public void setFecha_documento(Date fecha_documento) {
		this.fecha_documento = fecha_documento;
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
