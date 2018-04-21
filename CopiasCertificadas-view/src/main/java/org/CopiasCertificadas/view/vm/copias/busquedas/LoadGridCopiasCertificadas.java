package org.CopiasCertificadas.view.vm.copias.busquedas;

import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import copiasCertificadas.persist.model.domain.ventanilla.BeanCopiasCertificadas;

public class LoadGridCopiasCertificadas implements RowRenderer<BeanCopiasCertificadas>{

	public void render(Row row, BeanCopiasCertificadas data, int index) throws Exception {
		row.appendChild(new Label(data.getFolio()));
		row.appendChild(new Label(data.getStatus()));
		row.appendChild(new Label(data.getStatusGestion()));
		row.appendChild(new Label(data.getModalidad()));
	}
}
