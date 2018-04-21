package org.CopiasCertificadas.view.model;

import java.io.Serializable;

import org.zkoss.zul.DefaultTreeNode;



public class TramiteNotaTreeNode extends DefaultTreeNode<Tramites> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9166806694877759238L;
	
	private boolean open = false;
	
	public TramiteNotaTreeNode(Tramites data, DefaultTreeNode<Tramites>[] children) {
		super(data, children);
	}

	public TramiteNotaTreeNode(Tramites data, DefaultTreeNode<Tramites>[] children, boolean open) {
		super(data,children);
		setOpen(open);
	}
	
	public TramiteNotaTreeNode(Tramites data) {
		super(data);
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
}
