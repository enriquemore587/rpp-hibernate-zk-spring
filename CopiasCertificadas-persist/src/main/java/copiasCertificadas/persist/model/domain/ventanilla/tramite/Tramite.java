package copiasCertificadas.persist.model.domain.ventanilla.tramite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import copiasCertificadas.persist.model.domain.ventanilla.avisos.AvisosNotariales;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.copias.CopiaCertificada;
import copiasCertificadas.persist.model.domain.ventanilla.instrumento.Instrumento;
import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;



@Entity
@Table(name="tramite", catalog="ventanilladgjyel")
public class Tramite implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 780411245256513764L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="folio")
	private String folio;
	
	@Lob
	private byte[] acuse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creado", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date creado = new Date(); 
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_recepcion")
	private Date fecha_recepcion;
	
	@Column
	private String tipoSolicitante;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="tramite",orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Bitacora> listaBitacora;//ok
	/*
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_nota_complementaria")
	private NotaComplementaria nota_complementaria;//ok*/
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "copias_id")
	private CopiaCertificada copiaCertificada;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "avisos_id")
	private AvisosNotariales avisosNotariales;
	
	@Column(name="id_fedatario")
	private Integer id_fedatario;//ok
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="tramite",orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Pagos> listaPagos;//ok
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="tramite",orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Instrumento> listaInstrumento;//ok
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="tramite",orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<SeguimientoTramite>listaSeguimientos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public Date getFecha_recepcion() {
		return fecha_recepcion;
	}

	public void setFecha_recepcion(Date fecha_recepcion) {
		this.fecha_recepcion = fecha_recepcion;
	}

	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	public List<Bitacora> getListaBitacora() {
		return listaBitacora;
	}

	public void setListaBitacora(List<Bitacora> listaBitacora) {
		this.listaBitacora = listaBitacora;
	}

	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}

	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}

	public AvisosNotariales getAvisosNotariales() {
		return avisosNotariales;
	}

	public void setAvisosNotariales(AvisosNotariales avisosNotariales) {
		this.avisosNotariales = avisosNotariales;
	}

	public Integer getId_fedatario() {
		return id_fedatario;
	}

	public void setId_fedatario(Integer id_fedatario) {
		this.id_fedatario = id_fedatario;
	}

	public List<Pagos> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pagos> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public List<Instrumento> getListaInstrumento() {
		return listaInstrumento;
	}

	public void setListaInstrumento(List<Instrumento> listaInstrumento) {
		this.listaInstrumento = listaInstrumento;
	}

	public List<SeguimientoTramite> getListaSeguimientos() {
		return listaSeguimientos;
	}

	public void setListaSeguimientos(List<SeguimientoTramite> listaSeguimientos) {
		this.listaSeguimientos = listaSeguimientos;
	}

	public byte[] getAcuse() {
		return acuse;
	}

	public void setAcuse(byte[] acuse) {
		this.acuse = acuse;
	}

	
	
	
	

}