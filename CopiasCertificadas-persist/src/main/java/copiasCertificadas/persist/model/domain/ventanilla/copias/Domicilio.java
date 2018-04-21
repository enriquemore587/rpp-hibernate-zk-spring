package copiasCertificadas.persist.model.domain.ventanilla.copias;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="domicilio",catalog="ventanilladgjyel")
public class Domicilio implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 2235816906609054549L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="colonia")
	private String colonia;
	
	@Column(name="num_ext")
	private String num_ext;
	
	@Column(name="num_int")
	private String num_int;
	
	@Column(name="delegacion")
	private String delegacion;
	
	@Column(name="codigo_postal")
	private String codigo_postal;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(mappedBy="domicilio", cascade = CascadeType.ALL)
	private CopiaCertificada copiaCertificada;

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getNum_ext() {
		return num_ext;
	}

	public void setNum_ext(String num_ext) {
		this.num_ext = num_ext;
	}

	public String getNum_int() {
		return num_int;
	}

	public void setNum_int(String num_int) {
		this.num_int = num_int;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}

	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}
}
