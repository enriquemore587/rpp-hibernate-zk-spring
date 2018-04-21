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
@Table(name="notaCorreccion", catalog="ventanilladgjyel")
public class NotaCorreccion implements Serializable,Cloneable{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
	
	@Column
	private Integer numero_nota;
	
	@Column
	private String motivo;
	
	
	@OneToOne(mappedBy="notaCorreccion",fetch=FetchType.EAGER)
	private NotaComplementaria notaComplementaria;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Integer getNumero_nota() {
		return numero_nota;
	}


	public void setNumero_nota(Integer numero_nota) {
		this.numero_nota = numero_nota;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public NotaComplementaria getNotaComplementaria() {
		return notaComplementaria;
	}


	public void setNotaComplementaria(NotaComplementaria notaComplementaria) {
		this.notaComplementaria = notaComplementaria;
	}
	
	

}
