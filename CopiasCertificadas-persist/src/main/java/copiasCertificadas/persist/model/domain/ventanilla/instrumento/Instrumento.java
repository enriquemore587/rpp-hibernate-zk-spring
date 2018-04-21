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

import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;


@Entity
@Table(name="instrumento", catalog="ventanilladgjyel")
public class Instrumento implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529717894883767676L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
	
	@Column(name="num_instrumento")
	private int num_instrumento;
	
	@Column(name="nombre_notario")
	private String nombre_notario;
	
	@Column(name="paterno_notario")
	private String paterno_notario;
	
	@Column(name="materno_notario")
	private String materno_notario;
	
	@Column(name="num_notario")
	private int num_notario;
	
	@Column(name="num_notaria")
	private int num_notaria;
	
	@Column(name="num_suplente")
	private int num_suplente;
	
	@Column(name="num_asociado")
	private int num_asociado;
	
	@Column(name="nota_solicitada")
	private String nota_solicitada;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "fecha_otorgamiento")
	private Date fecha_otorgamiento;
	
	@Column(name="otorgantes")
	private String otorgantes;
	
	@Column(name="autoguridico_celebrado")
	private String autoguridico_celebrado;
	
	@ManyToOne
	@JoinColumn(name="tramite_id")
	private Tramite tramite;
	
	private String volumen;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getNum_instrumento() {
		return num_instrumento;
	}



	public void setNum_instrumento(int num_instrumento) {
		this.num_instrumento = num_instrumento;
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



	public int getNum_notario() {
		return num_notario;
	}



	public void setNum_notario(int num_notario) {
		this.num_notario = num_notario;
	}



	public int getNum_notaria() {
		return num_notaria;
	}



	public void setNum_notaria(int num_notaria) {
		this.num_notaria = num_notaria;
	}



	public int getNum_suplente() {
		return num_suplente;
	}



	public void setNum_suplente(int num_suplente) {
		this.num_suplente = num_suplente;
	}



	public int getNum_asociado() {
		return num_asociado;
	}



	public void setNum_asociado(int num_asociado) {
		this.num_asociado = num_asociado;
	}



	public String getNota_solicitada() {
		return nota_solicitada;
	}



	public void setNota_solicitada(String nota_solicitada) {
		this.nota_solicitada = nota_solicitada;
	}



	public Date getFecha_otorgamiento() {
		return fecha_otorgamiento;
	}



	public void setFecha_otorgamiento(Date fecha_otorgamiento) {
		this.fecha_otorgamiento = fecha_otorgamiento;
	}



	public String getOtorgantes() {
		return otorgantes;
	}



	public void setOtorgantes(String otorgantes) {
		this.otorgantes = otorgantes;
	}



	public String getAutoguridico_celebrado() {
		return autoguridico_celebrado;
	}



	public void setAutoguridico_celebrado(String autoguridico_celebrado) {
		this.autoguridico_celebrado = autoguridico_celebrado;
	}

	public Tramite getTramite() {
		return tramite;
	}
	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}
	
	public Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}
	
}
