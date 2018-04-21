package org.CopiasCertificadas.view.vm.lock;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;

public class MyViewModelLOComposer  extends SelectorComposer<Component>{

	
	@Wire
	Button btnSave;
		
	@Listen("onClick=#btnSave")
	public void onBusyGuardaAviso() {
		Clients.showBusy("Se Esta procesando su aviso..  Espere..");
		Events.echoEvent("onLongOp", btnSave, null);
	}
	
	@Listen("onLongOp=#btnSave")
	public void onClearGuardaAviso() {
		Clients.clearBusy();
	}
	
	@Wire
	Button btnNewCopiaPersona;
		
	@Listen("onClick=#btnNewCopiaPersona")
	public void onBusyNewCopiaPersona() {
		Clients.showBusy("Se Esta procesando su copia . .  Espere..");
		Events.echoEvent("onLongOp", btnNewCopiaPersona, null);
	}
	
	@Listen("onLongOp=#btnNewCopiaPersona")
	public void onClearNewCopiaPersona() {
		Clients.clearBusy();
	}
	
	@Wire
	Button btnSaveCopiaSesion;
		
	@Listen("onClick=#btnSaveCopiaSesion")
	public void onBusySaveCopiaSesion() {
		Clients.showBusy("Se Esta procesando su copia . .  Espere..");
		Events.echoEvent("onLongOp", btnSaveCopiaSesion, null);
	}
	
	@Listen("onLongOp=#btnSaveCopiaSesion")
	public void onClearSaveCopiaSesion() {
		Clients.clearBusy();
	}

	@Wire
	Button btnSaveCopiaV_N;
		
	@Listen("onClick=#btnSaveCopiaV_N")
	public void onBusySaveCopiaV_N() {
		Clients.showBusy("Se Esta guardando el tramite . .  Espere por favor..");
		Events.echoEvent("onLongOp", btnSaveCopiaV_N, null);
	}

	@Listen("onLongOp=#btnSaveCopiaV_N")
	public void onClearSaveCopiaV_N() {
		Clients.clearBusy();
	}
	
}
