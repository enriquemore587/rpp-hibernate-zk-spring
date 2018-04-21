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
@Table(name="partesJuicio", catalog="ventanilladgjyel")
public class Partes_en_Juicio implements Serializable,Cloneable{


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column
	private String actor;
	
	@Column
	private String demandado;
	
	@ManyToOne
	@JoinColumn(name="nota_id")	
	private NotaComplementaria nota_complementaria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDemandado() {
		return demandado;
	}

	public void setDemandado(String demandado) {
		this.demandado = demandado;
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
	
	
}
