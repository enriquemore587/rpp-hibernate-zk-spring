package org.CopiasCertificadas.view.vm.avisos;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import copiasCertificadas.persist.model.domain.ventanilla.BeanAvisosNotariales;

public class LoadGridAvisos implements RowRenderer<BeanAvisosNotariales>{

	public void render(Row row, BeanAvisosNotariales data, int index) throws Exception {
		row.appendChild(new Label(data.getFolio()));
		row.appendChild(new Label(data.getModalidad()));
		row.appendChild(new Label(data.getDescripcion()));
		row.appendChild(new Label(data.getEstatus()));
	}

}
