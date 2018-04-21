package copiasCertificadas.persist.model.domain.ventanilla.notas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nota_revocadores", catalog="ventanilladgjyel")
public class NotRevocadores implements Serializable,Cloneable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="a_paterno")
	private String a_paterno;
	
	@Column(name="a_materno")
	private String a_materno;

	public String getTipo_persona() {
		return tipo_persona;
	}

	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}

	public NotaComplementaria getNota_complementaria() {
		return nota_complementaria;
	}

	public void setNota_complementaria(NotaComplementaria nota_complementaria) {
		this.nota_complementaria = nota_complementaria;
	}

	@Column(name="tipo_persona")
	private String tipo_persona;
	
	@ManyToOne
	@JoinColumn(name="nota_id")	
	private NotaComplementaria nota_complementaria;

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

	public String getA_paterno() {
		return a_paterno;
	}

	public void setA_paterno(String a_paterno) {
		this.a_paterno = a_paterno;
	}

	public String getA_materno() {
		return a_materno;
	}

	public void setA_materno(String a_materno) {
		this.a_materno = a_materno;
	}
	
	public Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}
}
