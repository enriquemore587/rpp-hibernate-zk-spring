package copiasCertificadas.persist.model.domain.ventanilla.notas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="nota_revocados", catalog="ventanilladgjyel")
public class NotRevocados implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4703421417980859017L;

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
	
	@Column(name="tipo_persona")
	private String tipo_persona;

	@ManyToOne
	@JoinColumn(name="nota_id")	
	private NotaComplementaria nota_complementaria;// se realiza la relacion con tramite 

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public NotaComplementaria getNota_complementaria() {
		return nota_complementaria;
	}

	public void setNota_complementaria(NotaComplementaria nota_complementaria) {
		this.nota_complementaria = nota_complementaria;
	}

	public Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}

	public String getTipo_persona() {
		return tipo_persona;
	}

	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}
	
	
	
	
}
