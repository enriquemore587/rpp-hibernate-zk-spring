package org.CopiasCertificadas.view.vm.copias.pagos;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;

public class RRPagosVentanillaPF implements RowRenderer<Pagos>{

	public void render(Row row,final Pagos data, int index) throws Exception {
		
		row.appendChild(new Label(data.getLinea_captura()));
		row.appendChild(new Label(String.valueOf(data.getImporte())));
		row.appendChild(new Label(data.getFecha_pago().toString()));
		
		
		Button editar=new Button();
		
		editar.setLabel("EDITAR");
		
		editar.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event evt) throws Exception {	
				
				Executions.createComponents("/copias/pagos/addPagoVentanillaPF.zul", null, null);
							
				Map map = new HashMap();
				
				map.put("pago", data);

				BindUtils.postGlobalCommand(null, null, "updatePagoVentanillaPF", map);
				
				
			}
		});
		
		
		row.appendChild(editar);
		
		Button eliminar = new Button();
		
		eliminar.setLabel("ELIMINAR");
		eliminar.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event evt) throws Exception {
				
				
				Map map = new HashMap();
				
				map.put("pago", data);
				
				BindUtils.postGlobalCommand(null, null, "deletePagoVentanillaPF", map);
			}
		});
		
		row.appendChild(eliminar);
	}
	
	
}
