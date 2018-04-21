package org.CopiasCertificadas.view.vm.bandejas;

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

import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosNotarialesBandeja;
import copiasCertificadas.reports.dao.AcuseDAO;
import copiasCertificadas.reports.dao.AcuseDAOImpl;

public class RowRendererBandejaAvisos implements RowRenderer<BeanAvisosNotarialesBandeja> {

	public void render(Row row, final BeanAvisosNotarialesBandeja data, int index) throws Exception {
		row.appendChild(new Label(data.getId().toString()));
		row.appendChild(new Label(data.getFolio()));
		row.appendChild(new Label(data.getFecha().toString()));
		row.appendChild(new Label(data.getTipoAviso()));
		row.appendChild(new Label(data.getEstatus()));
		
		Button editar = new Button();
		
		
		
			editar.setLabel("EDITAR");
			editar.addEventListener(Events.ON_CLICK, new EventListener() {

				public void onEvent(Event event) throws Exception {

					Executions.createComponents("/avisosNotariales/avisosNotariales.zul", null, null);
					
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", data.getId());
					
					BindUtils.postGlobalCommand(null, null, "editarAviso", map);
				}
			});
			
		Button eliminar = new Button();
			eliminar.setLabel("ELIMINAR");
			
			eliminar.addEventListener(Events.ON_CLICK, new EventListener() {

				public void onEvent(Event event) throws Exception {
					
					Map<String, Object> map = new HashMap();
					map.put("id", data.getId());					
					
					BindUtils.postGlobalCommand(null, null, "deleteAviso", map);
					
				}
			});
			
			
		Button ver = new Button();
			ver.setLabel("VER");
			
			ver.addEventListener(Events.ON_CLICK, new EventListener() {

				public void onEvent(Event event) throws Exception {
					AcuseDAO acuseDAO = new AcuseDAOImpl();
					byte[] reporte = null;
					reporte = acuseDAO.acuseReporteAvisos(data.getId());
					if(reporte!=null){
						Map map  = new HashMap();
						map.put("acusePDF", reporte);
						Executions.createComponents("/reportes/acuse.zul", null, map);
					}
				}
			});
			
			
		Button presentar = new Button();
			presentar.setLabel("PRESENTAR");
			presentar.setWidth("100%");
			
			presentar.setClass("presentar");
			
			presentar.addEventListener(Events.ON_CLICK, new EventListener() {

				public void onEvent(Event event) throws Exception {
					
					Map<String, Object> map = new HashMap();
					map.put("id", data.getId());					
					
					BindUtils.postGlobalCommand(null, null, "presentarAviso", map);
					
				}
			});
			if (data.getEstatus().equals("POR PRESENTAR")) {
				ver.setDisabled(true);
			}
			if (data.getEstatus().equals("PRESENTADO") || data.getEstatus().equals("COMPLETADO")) {
				editar.setDisabled(true);
				presentar.setDisabled(true);
				eliminar.setDisabled(true);
			}
			
			
			row.appendChild(ver);
			row.appendChild(editar);
			row.appendChild(eliminar);
			row.appendChild(presentar);
			
	}

}
