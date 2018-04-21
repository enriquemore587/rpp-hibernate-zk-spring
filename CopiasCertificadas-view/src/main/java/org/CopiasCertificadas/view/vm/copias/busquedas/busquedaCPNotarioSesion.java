package org.CopiasCertificadas.view.vm.copias.busquedas;


import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import copiasCertificadas.persist.model.domain.ventanilla.CP_NotarioSesion;

public class busquedaCPNotarioSesion implements RowRenderer<CP_NotarioSesion>{

	public void render(Row row, CP_NotarioSesion data, int index) throws Exception {
		row.appendChild(new Label(data.getFolio()));
		row.appendChild(new Label(data.getModalidad()));
		row.appendChild(new Label(data.getEstatus()));
		row.appendChild(new Label(data.getFechaSolicitud().toString()));		
	}

}
