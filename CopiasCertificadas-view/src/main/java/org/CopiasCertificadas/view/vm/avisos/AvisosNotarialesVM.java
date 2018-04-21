package org.CopiasCertificadas.view.vm.avisos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.CopiasCertificadas.view.validate.ValidationMessagePublish;
import org.CopiasCertificadas.view.validate.showWindow;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.ModalidadesAvisos;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.TipoSolicitante;
import copiasCertificadas.persist.model.domain.ventanilla.BeanAvisosNotariales;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.AvisosNotariales;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;
import copiasCertificadas.reports.dao.AcuseDAO;
import copiasCertificadas.reports.dao.AcuseDAOImpl;
import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatch;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

public class AvisosNotarialesVM implements Serializable{

	private static final long serialVersionUID = -2827165223941035936L;

	private List<String> listModalidadAvisos = ModalidadesAvisos.obtenerTodos();
	private List<String> listModalidadAvisos2 = ModalidadesAvisos.obtenerTodos();


	TramiteDAO tramiteDAO;

	Integer numNotario = 21;

	Tramite tramite;

	AvisosNotariales avisosNotariales;

	Bitacora bitacora;
	List<Bitacora> listaBitacora;

	Pagos pagos;
	List<Pagos> listaPagos;

	SeguimientoTramite seguimientoTramite;
	List<SeguimientoTramite> listaSeguimientos;
	List<BeanAvisosNotariales> mainList;

	@Wire
	Textbox txtFolio;

	@Wire
	Combobox cmbModalidad;
	
	@Wire
	Button btnSave;
	
	@Wire
	Button btnAgregar;
	
	@Wire
	Div descGeneral;
	
	@Wire
	Button btnLoadFile;
	
	@Wire
	Textbox txtDesc1;
	
	@Wire
	Groupbox gPagos;
	
	
	private boolean fileuploaded = false;
	AMedia fileContent;

	
	@NotifyChange("mainList")
	private void load() {
		tramiteDAO = new TramiteDAOImpl();
		
		tramite = new Tramite();
		
		avisosNotariales = new AvisosNotariales();
			avisosNotariales.setTramite(tramite);
			tramite.setAvisosNotariales(avisosNotariales);
			
		bitacora = new Bitacora();
		
		listaBitacora = new ArrayList<Bitacora>();
			tramite.setListaBitacora(listaBitacora);
			
		pagos = new Pagos();

		listaPagos = new ArrayList<Pagos>();
			tramite.setListaPagos(listaPagos);
			
		seguimientoTramite = new SeguimientoTramite();
		
		listaSeguimientos = new ArrayList<SeguimientoTramite>();
			tramite.setListaSeguimientos(listaSeguimientos);
		
		
		
		
		
		tramite.setFecha_recepcion(new Date());
		
		tramite.setFolio("Aviso Notarial - " + (new Date().getTime()));
		
		tramite.setId_fedatario(21);
		
		tramite.setTipoSolicitante(TipoSolicitante._NOTARIO.getDescripcion());
		
		mainList = tramiteDAO.getAllAvisosByNumNotario(21);
		
		
		
	}
	
	@Init
	public void init() {
		load();
	}
	
	@Command
	public void showAddPago() {
		Executions.createComponents("/avisosNotariales/addPago.zul", null, null);
	}
	
	
	
	@GlobalCommand
	@NotifyChange({"tramite", "fileuploaded"})
	public void editarAviso(@BindingParam("id") Long id) {
		this.tramite = tramiteDAO.getTramiteById(id);
		if (this.tramite.getAvisosNotariales().getOficio() != null)
			this.fileuploaded = true;
	}
	
	@GlobalCommand
	@NotifyChange({"tramite", "fileuploaded"})
	public void verAviso(@BindingParam("id") Long id) {
		this.tramite = tramiteDAO.getTramiteById(id);
		if (this.tramite.getAvisosNotariales().getOficio() != null)
			this.fileuploaded = true;
		btnSave.setVisible(false);
		btnAgregar.setVisible(false);
		btnLoadFile.setVisible(false);

	}
	
	@GlobalCommand
	@NotifyChange({"tramite", "fileuploaded"})
	public void descGeneral(@BindingParam("id") Long id, @BindingParam("editar") boolean editar) {
		this.tramite = tramiteDAO.getTramiteById(id);
		if (this.tramite.getAvisosNotariales().getOficio() != null)
			this.fileuploaded = true;
		
		btnAgregar.setVisible(false);
		
		descGeneral.setVisible(true);
		
		btnLoadFile.setVisible(false);
		
		cmbModalidad.setDisabled(true);
		
		txtDesc1.setDisabled(true);
		
		gPagos.setVisible(false);
		
		if (!editar) {
			btnSave.setVisible(false);
		}

	}
	
	@GlobalCommand
	@NotifyChange("tramite")
	public void pagoEmpty(@BindingParam("pago") Pagos pagos) {
		this.pagos = pagos;
		
		this.pagos.setTramite(tramite);
		
		tramite.getListaPagos().add(this.pagos);
	}
	
	@GlobalCommand
	@NotifyChange("tramite")
	public void deletepago(@BindingParam("pago") Pagos pagos) {
		this.pagos = pagos;
		tramite.getListaPagos().remove(pagos);
	}
	
	@GlobalCommand
	public void updatePago(@BindingParam("pago") Pagos pagos) {
		
		showAddPago();
		
		Map map = new HashMap();
		
		map.put("pago", pagos);
		
		BindUtils.postGlobalCommand(null, null, "updatePagos", map);
		
		tramite.getListaPagos().remove(pagos);
	}
	
	@Command
	@NotifyChange("mainList")
	public void findByFolio() {
		mainList = tramiteDAO.getAllAvisosByFolioTramite(txtFolio.getText(), 21);
	}
	
	@Command
	@NotifyChange("mainList")
	public void findByModalidad() {
		mainList = tramiteDAO.getAllAvisosByModalidad(cmbModalidad.getValue(), 21);
	}
	
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}
	private boolean validaciones() {
		List<ValidationMessagePublish> lv = new ArrayList<ValidationMessagePublish>();
		
		if (tramite.getAvisosNotariales().getModalidad() == null)
			lv.add(new ValidationMessagePublish("CAMPO MODALIDAD ES OBLIGATORIO"));
		if (tramite.getAvisosNotariales().getPreDescripcionAviso() == null)
			lv.add(new ValidationMessagePublish("CAMPO DESCRIPCION ES OBLIGATORIO"));
		if (tramite.getAvisosNotariales().getOficio()== null)
			lv.add(new ValidationMessagePublish("CAMPO OFICIO ES OBLIGATORIO"));
		if (tramite.getListaPagos().size() == 0)
			lv.add(new ValidationMessagePublish("EL PAGO ES OBLIGATORIO"));
		if (lv.size() > 0) {
			showWindow.ShowValidation(lv);
			return false;
		}else{
			return true;
		}
	}
	
	@Command
	@NotifyChange("tramite")
	public void saveAviso(@BindingParam("cmp")  Window x) {
		
		if (tramite.getListaBitacora().size() == 0 && tramite.getListaSeguimientos().size() == 0) {
			
				bitacora.setArea_origen(OrigenTramite._ELECTRONICO.getDescripcion());
				bitacora.setArea_turnado(null);
				bitacora.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ESTADO ACTUAL: " + Status._PORPRESENTAR.getTipo());
				bitacora.setStatus(Status._PORPRESENTAR.getTipo());
				bitacora.setTramite(tramite);
				bitacora.setUsuario(OrigenTramite._ELECTRONICO.getDescripcion()+ "POR EL NUMERO DE NOTARIO: "+ numNotario);
			tramite.getListaBitacora().add(bitacora);
			
				seguimientoTramite.setDescripcion(OrigenTramite._ELECTRONICO.getDescripcion());
				seguimientoTramite.setObservaciones("INGRESADO POR: "+ OrigenTramite._ELECTRONICO.getDescripcion() + "ESTADO ACTUAL: " + Status._PORPRESENTAR.getTipo());
				seguimientoTramite.setStatus(Status._PORPRESENTAR.getTipo());
				seguimientoTramite.setStatus_gestion(Status._PORPRESENTAR.getTipo());
				seguimientoTramite.setStatusDesc_gestion(Status._PORPRESENTAR.getDescripcion());
				seguimientoTramite.setTramite(tramite);
			tramite.getListaSeguimientos().add(seguimientoTramite);
		}
		if (validaciones()) {
//			AcuseDAO acuseDAO = new AcuseDAOImpl();
//			byte[] reporte = null;
//			reporte = acuseDAO.acuseReporte(data.getId());
//			if(reporte!=null){
//				Map map  = new HashMap();
//				map.put("acusePDF", reporte);
//				Executions.createComponents("/reportes/acuse.zul", null, map);
//			}
			this.tramite =tramiteDAO.saveUpdate(tramite); 
			if (this.tramite!=null) {
				System.out.println("tramite agregado");
				Messagebox.show("TRAMITE GUARDADO id: "+this.tramite.getId());
				this.tramite = new Tramite();
				BindUtils.postGlobalCommand(null, null, "updateBandeja", null);
				x.detach();
			}
		}
		
		
	}
	
	
	
	@Command
	@NotifyChange("fileuploaded")
	public void unUploadDocumento(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException{
		
		UploadEvent upEvent = null;
		
	    Object objUploadEvent = ctx.getTriggerEvent();
	    
	    if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
	    	
		   	 upEvent = (UploadEvent) objUploadEvent;
		   	 
		}
	    
	    if (upEvent != null) {
	    	
		    Media media = upEvent.getMedia();
		    
		    MagicMatch match;
		    
		    String mimeType="";
		    
		    try {
		    	
				match = Magic.getMagicMatch(media.getByteData());
				
				mimeType = match.getMimeType();
				
				System.out.println("Tipo de Archivo: " + mimeType);
				
				if(mimeType.contentEquals("application/pdf")){
					
					tramite.getAvisosNotariales().setOficio(media.getByteData());
					
					
					fileuploaded = true;
					
					Messagebox.show("Archivo cargado correctamente", "Information", Messagebox.OK, Messagebox.INFORMATION);
					
				}else{
					
					 Messagebox.show("el Archivo no tiene formato pdf", "Information", Messagebox.OK, Messagebox.INFORMATION);
					 
				}
			} catch (MagicParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MagicMatchNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MagicException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
	 @SuppressWarnings("unchecked")
     @Command
     @NotifyChange("fileContent")
     public void showPDF() throws IOException {
		 
        if(tramite.getAvisosNotariales().getOficio()!=null){
        	
                     @SuppressWarnings("rawtypes")
                     Map map=new HashMap();
                     
                     ByteArrayOutputStream baos = new ByteArrayOutputStream(tramite.getAvisosNotariales().getOficio().length);
                     
                     baos.write(tramite.getAvisosNotariales().getOficio(), 0, tramite.getAvisosNotariales().getOficio().length);
                     
                     tramite.getAvisosNotariales().setOficio(baos.toByteArray());
                     
                     map.put("sDocumentos", tramite.getAvisosNotariales().getOficio());
                     
                     Executions.createComponents("/pdf/pdfView.zul", null, map);
                     
             }else{
                     Messagebox.show("No Hay Documento Cargado !!", "Advertencia !!", Messagebox.OK, Messagebox.INFORMATION);
             }

	 }
	 
	 
	public TramiteDAO getTramiteDAO() {
		return tramiteDAO;
	}

	public void setTramiteDAO(TramiteDAO tramiteDAO) {
		this.tramiteDAO = tramiteDAO;
	}

	public Integer getNumNotario() {
		return numNotario;
	}

	public void setNumNotario(Integer numNotario) {
		this.numNotario = numNotario;
	}

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	public AvisosNotariales getAvisosNotariales() {
		return avisosNotariales;
	}

	public void setAvisosNotariales(AvisosNotariales avisosNotariales) {
		this.avisosNotariales = avisosNotariales;
	}

	public Bitacora getBitacora() {
		return bitacora;
	}

	public void setBitacora(Bitacora bitacora) {
		this.bitacora = bitacora;
	}

	public List<Bitacora> getListaBitacora() {
		return listaBitacora;
	}

	public void setListaBitacora(List<Bitacora> listaBitacora) {
		this.listaBitacora = listaBitacora;
	}

	public Pagos getPagos() {
		return pagos;
	}

	public void setPagos(Pagos pagos) {
		this.pagos = pagos;
	}

	public List<Pagos> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pagos> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public SeguimientoTramite getSeguimientoTramite() {
		return seguimientoTramite;
	}

	public void setSeguimientoTramite(SeguimientoTramite seguimientoTramite) {
		this.seguimientoTramite = seguimientoTramite;
	}

	public List<SeguimientoTramite> getListaSeguimientos() {
		return listaSeguimientos;
	}

	public void setListaSeguimientos(List<SeguimientoTramite> listaSeguimientos) {
		this.listaSeguimientos = listaSeguimientos;
	}

	public List<String> getListModalidadAvisos() {
		return listModalidadAvisos;
	}

	public void setListModalidadAvisos(List<String> listModalidadAvisos) {
		this.listModalidadAvisos = listModalidadAvisos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getListModalidadAvisos2() {
		return listModalidadAvisos2;
	}

	public void setListModalidadAvisos2(List<String> listModalidadAvisos2) {
		this.listModalidadAvisos2 = listModalidadAvisos2;
	}

	public List<BeanAvisosNotariales> getMainList() {
		return mainList;
	}

	public void setMainList(List<BeanAvisosNotariales> mainList) {
		this.mainList = mainList;
	}

	public boolean isFileuploaded() {
		return fileuploaded;
	}

	public void setFileuploaded(boolean fileuploaded) {
		this.fileuploaded = fileuploaded;
	}

	public AMedia getFileContent() {
		return fileContent;
	}

	public void setFileContent(AMedia fileContent) {
		this.fileContent = fileContent;
	}
	
		
}
