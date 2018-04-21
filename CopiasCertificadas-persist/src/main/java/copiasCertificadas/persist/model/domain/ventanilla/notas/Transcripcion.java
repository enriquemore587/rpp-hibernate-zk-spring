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
@Table(name="transcripcion", catalog="ventanilladgjyel")
public class Transcripcion  implements Serializable,Cloneable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
	
	@Column
	private String dice;
	
	@Column
	private String debe_decir;
	
	
	@OneToOne(mappedBy="transcripcion",fetch=FetchType.EAGER)
	private NotaComplementaria notaComplementaria;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDice() {
		return dice;
	}


	public void setDice(String dice) {
		this.dice = dice;
	}


	public String getDebe_decir() {
		return debe_decir;
	}


	public void setDebe_decir(String debe_decir) {
		this.debe_decir = debe_decir;
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
