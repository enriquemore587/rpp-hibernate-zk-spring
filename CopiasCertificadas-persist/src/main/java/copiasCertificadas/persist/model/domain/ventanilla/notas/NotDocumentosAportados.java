package copiasCertificadas.persist.model.domain.ventanilla.notas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nota_documentosaportados", catalog="ventanilladgjyel")
public class NotDocumentosAportados implements Serializable,Cloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@Lob
	private byte[] documentoPDF;

	@Column
	private String documentoDESC;

	@ManyToOne
	@JoinColumn(name="nota_id")	
	private NotaComplementaria nota_complementaria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getDocumentoPDF() {
		return documentoPDF;
	}

	public void setDocumentoPDF(byte[] documentoPDF) {
		this.documentoPDF = documentoPDF;
	}

	public String getDocumentoDESC() {
		return documentoDESC;
	}

	public void setDocumentoDESC(String documentoDESC) {
		this.documentoDESC = documentoDESC;
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
