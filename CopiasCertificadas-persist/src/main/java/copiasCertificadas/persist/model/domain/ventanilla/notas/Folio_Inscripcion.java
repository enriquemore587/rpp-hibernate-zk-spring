package copiasCertificadas.persist.model.domain.ventanilla.notas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="folioInscripcion", catalog="ventanilladgjyel")
public class Folio_Inscripcion implements Serializable,Cloneable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column
	private String folio;
	
	@Column
	private String bis;
	
	@Column
	private String auxiliar;
	
	@Column
	private String estado;
	
	@OneToOne(mappedBy="folio_Inscripcion",fetch=FetchType.EAGER)
	private NotaComplementaria notaComplementaria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getBis() {
		return bis;
	}

	public void setBis(String bis) {
		this.bis = bis;
	}

	public String getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(String auxiliar) {
		this.auxiliar = auxiliar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
