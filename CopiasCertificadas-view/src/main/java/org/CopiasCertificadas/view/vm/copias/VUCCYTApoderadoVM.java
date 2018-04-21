package org.CopiasCertificadas.view.vm.copias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.CopiasCertificadas.view.enums.Identificaciones;
import org.CopiasCertificadas.view.validate.ValidationMessagePublish;
import org.CopiasCertificadas.view.validate.showWindow;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.Areas;
import copiasCertificadas.persist.model.domain.enums.ModalidadCopias;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.StatusGestion;
import copiasCertificadas.persist.model.domain.enums.TipoSolicitante;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.copias.CopiaCertificada;
import copiasCertificadas.persist.model.domain.ventanilla.copias.Domicilio;
import copiasCertificadas.persist.model.domain.ventanilla.copias.PersonaFisica;
import copiasCertificadas.persist.model.domain.ventanilla.copias.Representante_legal;
import copiasCertificadas.persist.model.domain.ventanilla.instrumento.Instrumento;
import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;
import copiasCertificadas.reports.dao.AcuseDAO;
import copiasCertificadas.reports.dao.AcuseDAOImpl;


public class VUCCYTApoderadoVM implements Serializable{
	public static final Logger LOG = Logger.getLogger(VUCCYTApoderadoVM.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 8737586165952789783L;
	private String usuario = "ENRIQUE2104";
	private String folioTramite = "VUCCYT - "+(new Date()).getTime();
	private Tramite tramite;	
	private CopiaCertificada copiaCertificada;
	private PersonaFisica personaFisica;
	private Domicilio domicilio;
	private Representante_legal representante_legal;
	private List<Instrumento> listaInstrumento;
	private Instrumento instrumento;
	private List<Pagos> listaPagos;
	private Pagos pagos;
	private List<Bitacora> listaBitacora;
	private Bitacora bitacora;
	private List<SeguimientoTramite> listaSeguimientos;
	private SeguimientoTramite seguimientoTramite;
	
	private List<String> identificaciones = Identificaciones.getAllIdentificaciones();
	private List<String> modalidades = ModalidadCopias.getAllModalidades();
	
	@Init
	public void init() {
		initComponents();

	}
	@Wire
	Div divRepresentante;
	
	@Wire
	Div div1;
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}
	public void initComponents() {
		
		tramite = new Tramite();		
		copiaCertificada = new CopiaCertificada();
		personaFisica = new PersonaFisica();
		domicilio = new Domicilio();
		representante_legal = new Representante_legal();
		listaInstrumento = new ArrayList<Instrumento>();
		instrumento = new Instrumento();
		listaPagos = new ArrayList<Pagos>();
		pagos = new Pagos();
		
		
		tramite.setListaPagos(listaPagos);
		

			
	}
	@Command
	public void comenzar(@BindingParam("cmb") Combobox cmb) {
		div1.setVisible(true);
		
		if (cmb.getSelectedItem().getLabel().toString().equals("CIUDADANO")) {
			divRepresentante.setVisible(false);
		}else{
			divRepresentante.setVisible(true);
		}
	}
	public boolean IsValidInput() {
		
		List<ValidationMessagePublish> liIsValidInputs = new ArrayList<ValidationMessagePublish>();
		
		if(copiaCertificada.getPersonaFisica().getNombre()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE NOMBRE DE PERSONA FISICA ES OBLIGATORRO"));
		if(copiaCertificada.getPersonaFisica().getPaterno()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE APELLIDO PATERNO DE PERSONA FISICA ES OBLIGATORRO"));
		if(copiaCertificada.getPersonaFisica().getMaterno()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE APELLIDO MATERNO DE PERSONA FISICA ES OBLIGATORRO"));
		if(copiaCertificada.getPersonaFisica().getTipoIdentificacion()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE LA IDENTIFICACION DE PERSONA FISICA ES OBLIGATORRO"));
		if(copiaCertificada.getPersonaFisica().getFolioIdentificacion()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE FOLIO DE IDENTIFICACION DE PERSONA FISICA ES OBLIGATORRO"));
		
		
		if(copiaCertificada.getDomicilio().getCalle()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO CALLE ES OBLIGATORRO"));
		if(copiaCertificada.getDomicilio().getNum_ext()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE NUMERO EXTERIOR ES OBLIGATORRO"));
		if(copiaCertificada.getDomicilio().getNum_int()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE NUMERO INTERIOR ES OBLIGATORRO"));
		if(copiaCertificada.getDomicilio().getColonia()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DE COLONIA ES OBLIGATORRO"));
		if(copiaCertificada.getDomicilio().getDelegacion()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO DELEGACION ES OBLIGATORRO"));
		if(copiaCertificada.getDomicilio().getCodigo_postal()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO CODIGO POSTAL ES OBLIGATORRO"));
		if(copiaCertificada.getDomicilio().getEmail()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO E - MAIL ES OBLIGATORRO"));
		if(copiaCertificada.getDomicilio().getTelefono()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO TELEFONO ES OBLIGATORRO"));
		
		
		if (divRepresentante.isVisible()) {
			if(copiaCertificada.getRepresentante_legal().getNombre()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO NOMBRE PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getPaterno()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO APELLIDO PATERNO PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getMaterno()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO APELLIDO MATERNO PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getIdentificacion_oficial()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO IDENTIFICACION OFICIAL PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getFolioIdentificacion()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO FOLIO DE IDENTIFICACION PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getNum_escritura_poliza_exp()==0)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO NUMERO DE ESCRITURA, POLIZA O EXPEDIENTE PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getFechaEscrituraPolizaExp()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO FECHA DE ESCRITURA, POLIZA O EXPEDIENTE PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getNombre_notario_corredor_juez()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO NOMBRE NOTARIO, CORREDOR O JUEZ PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getEntidad_federativa()== null)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO ENTIDAD FEDERATIVA PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			if(copiaCertificada.getRepresentante_legal().getNom_notaria_correduria_juzgado()==0)
				liIsValidInputs.add(new ValidationMessagePublish("CAMPO NUMERO DE NOTARIA CORREDURIA O JUZGADO PARA REPRESENTANTE LEGAL ES OBLIGATORRO"));
			
		}
		
		if(copiaCertificada.getModalidad() == null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO MODALIDAD ES OBLIGATORRO"));
		if(instrumento.getNum_notaria() == 0)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO NUMERO DE NOTARIA ES OBLIGATORRO"));
		if(instrumento.getNombre_notario() == null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO NOMBRE DE NOTARIO -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getPaterno_notario()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO APELLIDO PATERNO DE NOTARIO -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getMaterno_notario()== null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO APELLIDO MATERNO DE NOTARIO -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getNum_notario() == 0)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO NUMERO DE NOTARIO -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getFecha_otorgamiento() == null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO FECHA DE OTORGAMIENTO -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getNum_instrumento()== 0)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO NUMERO DE INSTRUMENTO -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getVolumen() == null)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO VOLUMEN -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getNum_suplente() == 0)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO NUMERO DE SUPLENTE -DATOS DE TRAMITE- ES OBLIGATORRO"));
		if(instrumento.getNum_asociado() == 0)
			liIsValidInputs.add(new ValidationMessagePublish("CAMPO NUMERO DE ASOCIADO -DATOS DE TRAMITE- ES OBLIGATORRO"));
		
		
		if (liIsValidInputs.size()>0) {
			showWindow.ShowValidation(liIsValidInputs);
			return false;
		}else{
			return true;
		}
	}
		
	@Command
	@NotifyChange("tramite")
	public void send() {
			
			copiaCertificada.setPersonaFisica(personaFisica);
			copiaCertificada.setDomicilio(domicilio);
			copiaCertificada.setRepresentante_legal(representante_legal);		
			copiaCertificada.setTramite(tramite);
		tramite.setCopiaCertificada(copiaCertificada);
		
				instrumento.setTramite(tramite);
			listaInstrumento.add(instrumento);
		tramite.setListaInstrumento(listaInstrumento);
		
		if (divRepresentante.isVisible()) {
			tramite.setTipoSolicitante(TipoSolicitante._AUTORIDAD.getDescripcion());
		}else{
			tramite.setTipoSolicitante(TipoSolicitante._PARTICULAR.getDescripcion());
			tramite.getCopiaCertificada().setRepresentante_legal(null);
		}
		
		TramiteDAO tramiteDAO = new TramiteDAOImpl();
		
		if (IsValidInput()) {
			Bitacora bitacora = new Bitacora();
			
			bitacora.setArea_origen(Areas._VENTANILLA_FISICA.getTipo());
			bitacora.setArea_turnado(Areas._AREA_ADMINISTRACION_DE_ACERVOS.getTipo());
			bitacora.setObservaciones("INGRESO: "+ OrigenTramite._FISICO.getDescripcion());
			bitacora.setStatus(Status._PRESENTADO.getTipo());
			bitacora.setTramite(tramite);
			bitacora.setUsuario("USUARIO EN VENTANILLA");

		this.tramite.setListaBitacora(new ArrayList<Bitacora>());
		this.tramite.getListaBitacora().add(bitacora);

		SeguimientoTramite seguimientoTramite = new SeguimientoTramite();

			seguimientoTramite.setDescripcion("INGRESO: "+ OrigenTramite._FISICO.getDescripcion());
			seguimientoTramite.setObservaciones("INGRESO: "+ OrigenTramite._FISICO.getDescripcion() + "ESTADO ACTUAL: " + Status._PRESENTADO.getTipo());
			seguimientoTramite.setStatus(Status._PRESENTADO.getTipo());
			seguimientoTramite.setStatus_gestion(StatusGestion._POR_ASIGNAR_A_BUSCADOR.getTipo());
			seguimientoTramite.setStatusDesc_gestion(StatusGestion._POR_ASIGNAR_A_BUSCADOR.getDescripcion());
			seguimientoTramite.setTramite(tramite);
			
		this.tramite.setListaSeguimientos(new ArrayList<SeguimientoTramite>());
		this.tramite.getListaSeguimientos().add(seguimientoTramite);
		this.tramite.setFolio("VUCCYT - FISICO - "+(new Date()).toString());
		this.tramite.setFecha_recepcion(new Date())	;


		this.tramite =tramiteDAO.saveUpdate(tramite); 
			if (this.tramite!=null) {
				AcuseDAO acuseDAO = new AcuseDAOImpl();
				byte[] reporte = null;
				
				if (divRepresentante.isVisible()) {
					reporte = acuseDAO.acuseReporteCC_Representante(this.tramite.getId());
				}else{
					reporte = acuseDAO.acuseReporteCC_PI(this.tramite.getId());
				}
				this.tramite.setAcuse(reporte);
				tramiteDAO.update(this.tramite);
				if(reporte!=null){
					Map map  = new HashMap();
					map.put("acusePDF", reporte);
					Executions.createComponents("/reportes/acuse.zul", null, map);
				}
				Messagebox.show("T R A M I T E :: G U A R D A D O");
				this.tramite = new Tramite();
			}
		}
		this.initComponents();
	}

	@Command
	public void showAddPago() {
		Executions.createComponents("/copias/pagos/addPagoVentanillaPF.zul", null, null);
	}

	@GlobalCommand
	@NotifyChange("tramite")
	public void addPagoVentanillaPF(@BindingParam("pago") Pagos pagos, @BindingParam("editar") boolean editar) {
		if (editar) {
			this.tramite.getListaPagos().remove(pagos);
		}
		pagos.setTramite(tramite);
		this.tramite.getListaPagos().add(pagos);
	}

	@GlobalCommand
	@NotifyChange("tramite")
	public void deletePagoVentanillaPF(@BindingParam("pago") Pagos pagos) {

		this.tramite.getListaPagos().remove(pagos);

	}
	
	public List<String> getIdentificaciones() {
		return identificaciones;
	}
	public void setIdentificaciones(List<String> identificaciones) {
		this.identificaciones = identificaciones;
	}
	
	public List<String> getModalidades() {
		return modalidades;
	}
	public void setModalidades(List<String> modalidades) {
		this.modalidades = modalidades;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFolioTramite() {
		return folioTramite;
	}
	public void setFolioTramite(String folioTramite) {
		this.folioTramite = folioTramite;
	}
	public Tramite getTramite() {
		return tramite;
	}
	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}
	public CopiaCertificada getCopiaCertificada() {
		return copiaCertificada;
	}
	public void setCopiaCertificada(CopiaCertificada copiaCertificada) {
		this.copiaCertificada = copiaCertificada;
	}
	public PersonaFisica getPersonaFisica() {
		return personaFisica;
	}
	public void setPersonaFisica(PersonaFisica personaFisica) {
		this.personaFisica = personaFisica;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public Representante_legal getRepresentante_legal() {
		return representante_legal;
	}
	public void setRepresentante_legal(Representante_legal representante_legal) {
		this.representante_legal = representante_legal;
	}
	public List<Instrumento> getListaInstrumento() {
		return listaInstrumento;
	}
	public void setListaInstrumento(List<Instrumento> listaInstrumento) {
		this.listaInstrumento = listaInstrumento;
	}
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	public List<Pagos> getListaPagos() {
		return listaPagos;
	}
	public void setListaPagos(List<Pagos> listaPagos) {
		this.listaPagos = listaPagos;
	}
	public Pagos getPagos() {
		return pagos;
	}
	public void setPagos(Pagos pagos) {
		this.pagos = pagos;
	}
	public List<Bitacora> getListaBitacora() {
		return listaBitacora;
	}
	public void setListaBitacora(List<Bitacora> listaBitacora) {
		this.listaBitacora = listaBitacora;
	}
	public Bitacora getBitacora() {
		return bitacora;
	}
	public void setBitacora(Bitacora bitacora) {
		this.bitacora = bitacora;
	}
	public List<SeguimientoTramite> getListaSeguimientos() {
		return listaSeguimientos;
	}
	public void setListaSeguimientos(List<SeguimientoTramite> listaSeguimientos) {
		this.listaSeguimientos = listaSeguimientos;
	}
	public SeguimientoTramite getSeguimientoTramite() {
		return seguimientoTramite;
	}
	public void setSeguimientoTramite(SeguimientoTramite seguimientoTramite) {
		this.seguimientoTramite = seguimientoTramite;
	}
	
	
	
}
