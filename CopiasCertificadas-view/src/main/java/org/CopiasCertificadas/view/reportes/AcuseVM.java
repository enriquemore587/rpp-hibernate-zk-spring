package org.CopiasCertificadas.view.reportes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;

public class AcuseVM implements Serializable {

	AMedia fileContent;
	
	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view,
			@ExecutionArgParam("acusePDF") byte[] docs) throws IOException{
		
		ByteArrayInputStream is = new ByteArrayInputStream(docs);
		
		fileContent = new AMedia("documentos", "pdf", "application/pdf", is);

	}
	@Command
	public void cerrar(@ContextParam(ContextType.VIEW) final Component view) {
		
		Messagebox.show("Asegurese de haber impreso el Comprobante de Ingreso", "desea cerrar el comprobante?",
				Messagebox.YES | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			public void onEvent(Event event) throws Exception {
				  if (event.getName().equals("onYes")) {
					  view.detach();
						Executions.createComponents("/avisosNotariales/avisosNotariales.zul", null, null);
			        } else if (event.getName().equals("onICancel")) {
			            Messagebox.show("Favor de descargar el PDF", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			        } 
			}
		});
		
	}

	public AMedia getFileContent() {
		return fileContent;
	}

	public void setFileContent(AMedia fileContent) {
		this.fileContent = fileContent;
	}
}
