package org.CopiasCertificadas.view.vm.bandejas.protocoloRevision;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.OrigenTramite;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosBandejaProtocolo;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosNotarialesBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

public class RowRendererBandejaAvisosProtocoloCompletados implements RowRenderer<BeanAvisosBandejaProtocolo> {

	public void render(Row row, final BeanAvisosBandejaProtocolo data, int arg2) throws Exception {
		row.appendChild(new Label(data.getId().toString()));
		row.appendChild(new Label(data.getNumNotario().toString()));
		row.appendChild(new Label(data.getFolio()));
		row.appendChild(new Label(data.getFecha().toString()));
		row.appendChild(new Label(data.getTipoAviso()));
		row.appendChild(new Label(data.getEstatus()));
		
		
			
		Button ver = new Button();
		
			ver.setLabel("ACCIONES");
			
			ver.addEventListener(Events.ON_CLICK, new EventListener() {

				public void onEvent(Event event) throws Exception {
					/*Executions.createComponents("/avisosNotariales/avisosNotariales.zul", null, null);
					Map<String, Object> map = new HashMap();
					
					map.put("id", data.getId());
					map.put("editar", false);
					BindUtils.postGlobalCommand(null, null, "descGeneral", map);*/
					
					
					
				}
			});
			
			row.appendChild(ver);
		
	}



}
