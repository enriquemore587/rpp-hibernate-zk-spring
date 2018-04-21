package org.CopiasCertificadas.view.pdf;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;

public class PdfViewVM {

	AMedia fileContent;
	
	@Init
	public void ini(@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("sDocumentos") byte[] docs) throws IOException{
		
		ByteArrayInputStream is = new ByteArrayInputStream(docs);
		
		fileContent = new AMedia("documentos", "pdf", "application/pdf", is);

	}

	public AMedia getFileContent() {
		return fileContent;
	}

	public void setFileContent(AMedia fileContent) {
		this.fileContent = fileContent;
	}
	
	
}
