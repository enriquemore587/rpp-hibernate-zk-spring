package org.CopiasCertificadas.view.model;

import java.io.Serializable;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class LoadGridConverter implements Converter, Serializable {
	

	private static final long serialVersionUID = 1836303657679305811L;
	
	Component comp;

	public Object coerceToBean(Object val, Component comp, BindContext ctx) {
		if (comp == null)
			comp = comp;
	  	return val;
	}

	public Object coerceToUi(Object val, Component comp, BindContext ctx) {
		if (comp == null)
			comp = comp;
	 	return val;
	}

	public Component getComp() {
		return comp;
	}
	

}
