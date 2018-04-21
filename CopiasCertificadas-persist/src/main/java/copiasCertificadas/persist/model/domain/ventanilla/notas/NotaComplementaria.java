package copiasCertificadas.persist.model.domain.ventanilla.notas;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import copiasCertificadas.persist.model.domain.ventanilla.instrumento.InstrumentoRenunciaCancelacion;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;


@Entity
@Table(name="notas_complementaria", catalog="ventanilladgjyel")
public class NotaComplementaria implements Serializable,Cloneable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;


	@OneToOne(mappedBy="nota_complementaria",fetch=FetchType.EAGER)
	private Tramite tramite;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_interesado")
	private Interesado interesado;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_asentamientoNota")
	private AsentamientoNota asentamientoNota;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_nota_correccion")
	private NotaCorreccion notaCorreccion;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_constancia")
	private Constancia constancia;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_folio_Inscripcion")
	private Folio_Inscripcion folio_Inscripcion;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_folio_transcripcion")
	private Transcripcion transcripcion;

	
	@Column
	private String tipoNota;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="nota_complementaria", orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<NotRevocados> listaRevocados;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="nota_complementaria",orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<NotRevocadores> listaRevocadores;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="nota_complementaria",orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<NotDocumentosAportados> documentosList;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="nota_complementaria",orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Partes_en_Juicio> listaPartes_en_Juicio;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="nota_complementaria", orphanRemoval=true)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<InstrumentoRenunciaCancelacion> listaInstrumentoRenunciaCancelacion;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	public Interesado getInteresado() {
		return interesado;
	}

	public void setInteresado(Interesado interesado) {
		this.interesado = interesado;
	}

	public AsentamientoNota getAsentamientoNota() {
		return asentamientoNota;
	}

	public void setAsentamientoNota(AsentamientoNota asentamientoNota) {
		this.asentamientoNota = asentamientoNota;
	}

	public NotaCorreccion getNotaCorreccion() {
		return notaCorreccion;
	}

	public void setNotaCorreccion(NotaCorreccion notaCorreccion) {
		this.notaCorreccion = notaCorreccion;
	}



	public Folio_Inscripcion getFolio_Inscripcion() {
		return folio_Inscripcion;
	}

	public void setFolio_Inscripcion(Folio_Inscripcion folio_Inscripcion) {
		this.folio_Inscripcion = folio_Inscripcion;
	}

	public Transcripcion getTranscripcion() {
		return transcripcion;
	}

	public void setTranscripcion(Transcripcion transcripcion) {
		this.transcripcion = transcripcion;
	}


	public List<NotRevocados> getListaRevocados() {
		return listaRevocados;
	}

	public void setListaRevocados(List<NotRevocados> listaRevocados) {
		this.listaRevocados = listaRevocados;
	}

	public List<NotRevocadores> getListaRevocadores() {
		return listaRevocadores;
	}

	public void setListaRevocadores(List<NotRevocadores> listaRevocadores) {
		this.listaRevocadores = listaRevocadores;
	}

	public List<NotDocumentosAportados> getDocumentosList() {
		return documentosList;
	}

	public void setDocumentosList(List<NotDocumentosAportados> documentosList) {
		this.documentosList = documentosList;
	}

	public List<Partes_en_Juicio> getListaPartes_en_Juicio() {
		return listaPartes_en_Juicio;
	}

	public void setListaPartes_en_Juicio(List<Partes_en_Juicio> listaPartes_en_Juicio) {
		this.listaPartes_en_Juicio = listaPartes_en_Juicio;
	}

	public List<InstrumentoRenunciaCancelacion> getListaInstrumentoRenunciaCancelacion() {
		return listaInstrumentoRenunciaCancelacion;
	}

	public void setListaInstrumentoRenunciaCancelacion(
			List<InstrumentoRenunciaCancelacion> listaInstrumentoRenunciaCancelacion) {
		this.listaInstrumentoRenunciaCancelacion = listaInstrumentoRenunciaCancelacion;
	}
	
	public Constancia getConstancia() {
		return constancia;
	}

	public void setConstancia(Constancia constancia) {
		this.constancia = constancia;
	}

	
}
