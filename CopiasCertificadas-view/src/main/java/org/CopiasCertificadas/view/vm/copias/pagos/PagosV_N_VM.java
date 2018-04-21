package org.CopiasCertificadas.view.vm.copias.pagos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.CopiasCertificadas.view.validate.ValidationMessagePublish;
import org.CopiasCertificadas.view.validate.showWindow;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Messagebox;

import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;

public class PagosV_N_VM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7238766899769285092L;
	
	private Pagos pagos;
	private boolean editar;
	
	@Init
	@NotifyChange("pagos")
	public void init() {
		pagos = new Pagos();
		editar = false;
	}
	
	public boolean validar() {
		
		List<ValidationMessagePublish> lv = new ArrayList<ValidationMessagePublish>();
		
		if (pagos.getLinea_captura() == null)
			lv.add(new ValidationMessagePublish("CAMPO LINEA DE CAPTURA ES OBLIGATORIO"));
		if (pagos.getImporte() == null)
			lv.add(new ValidationMessagePublish("CAMPO IMPORTE ES OBLIGATORIO"));
		if (pagos.getFecha_pago() == null)
			lv.add(new ValidationMessagePublish("CAMPO FECHA DE PAGO ES OBLIGATORIO"));	
		if (lv.size() > 0) {
			showWindow.ShowValidation(lv);
			return false;
		}else
			return true;
		
	}
	@Command
	public void sendPago(@ContextParam(ContextType.VIEW) Component view) {
		if (validar()) {

			Map map = new HashMap();
			
			map.put("pago", this.pagos);
			
			map.put("editar", editar);
			
			BindUtils.postGlobalCommand(null, null, "addPagoV_N", map);
			
			view.detach();
		}
	}
	
	@GlobalCommand
	@NotifyChange("pagos")
	public void updatePagoV_N(@BindingParam("pago") Pagos pagos) {
		this.pagos = pagos;
		this.editar = true;
	}
	
	public Pagos getPagos() {
		return pagos;
	}

	public void setPagos(Pagos pagos) {
		this.pagos = pagos;
	}
	
}
