package org.CopiasCertificadas.view.vm;

import java.io.Serializable;
import java.util.Iterator;

import org.CopiasCertificadas.view.model.AdvancedTreeModel;
import org.CopiasCertificadas.view.model.LoadGridConverter;
import org.CopiasCertificadas.view.model.TramiteNotaTreeNode;
import org.CopiasCertificadas.view.model.TramiteNotasList;
import org.CopiasCertificadas.view.model.Tramites;
import org.CopiasCertificadas.view.model.enums.Panels;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;



public class MenuNotasVM implements Serializable{

	
	@Wire("#contentDiv")
	Div contentDiv;
	
	Treeitem selectedItem;
	Treeitem itemOne;
	LoadGridConverter loadGridConverter;
	
	
	@Init
	public void init() {
		// TODO Auto-generated method stub

	}

	public Treeitem getSelectedItem() {
		System.out.println("seleccione: " + selectedItem);
		return selectedItem;
	}

	//@NotifyChange("nameOfSelectedItem")
	public void setSelectedItem(Treeitem selectedItem) {
		Executions.createComponents("AltaTramite.zul", null, null);
		
		//enum
		
		
		this.selectedItem = selectedItem;
	}
	
	public String getNameOfSelectedItem() {
		if (selectedItem != null) {
			return ((Treecell)selectedItem.getTreerow().getFirstChild()).getLabel();
		}
		return "null";
	}
	
	@NotifyChange("selectedItem")
	public void setNameOfSelectedItem(String value) {
		Tree t = (Tree)((LoadGridConverter)getLoadGridConverter()).getComp();
		Iterator<Treeitem> it =  t.getItems().iterator();
		while(it.hasNext()) {
			Treeitem ti = it.next();
			if (((Treecell)ti.getTreerow().getFirstChild()).getLabel().equals(value)) {
				selectedItem = ti;
				break;
			}
		}
	}
	

	public LoadGridConverter getLoadGridConverter() {
		if (loadGridConverter == null)
			loadGridConverter = new LoadGridConverter();
		return loadGridConverter;
	}
	
	
	@Wire
	private Tree tree;
	private AdvancedTreeModel contactTreeModel;
	

	

	
	 	@AfterCompose
	    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
	        Selectors.wireComponents(view, this, false);
	        contactTreeModel = new AdvancedTreeModel(new TramiteNotasList().getRoot());
			tree.setItemRenderer(new TramiteTreeRenderer());
			tree.setModel(contactTreeModel);
	    }
	
	

	/**
	 * The structure of tree
	 * 
	 * <pre>
	 * &lt;treeitem>
	 *   &lt;treerow>
	 *     &lt;treecell>...&lt;/treecell>
	 *   &lt;/treerow>
	 *   &lt;treechildren>
	 *     &lt;treeitem>...&lt;/treeitem>
	 *   &lt;/treechildren>
	 * &lt;/treeitem>
	 * </pre>
	 */
	private final class TramiteTreeRenderer implements TreeitemRenderer<TramiteNotaTreeNode> {
		public void render(final Treeitem treeItem, TramiteNotaTreeNode treeNode, int index) throws Exception {
			TramiteNotaTreeNode ctn = treeNode;
			Tramites contact = (Tramites) ctn.getData();
			Treerow dataRow = new Treerow();
			dataRow.setParent(treeItem);
			treeItem.setValue(ctn);
			treeItem.setOpen(ctn.isOpen());

			if (!isCategory(contact)) { // Contact Row
				Hlayout hl = new Hlayout();
				hl.appendChild(new Image("/widgets/tree/dynamic_tree/img/" + contact.getImagen()));
				hl.appendChild(new Label(contact.getNombre()));
				hl.setSclass("h-inline-block");
				Treecell treeCell = new Treecell();
				
				treeCell.appendChild(hl);
				dataRow.setDraggable("true");
				dataRow.appendChild(treeCell);
				dataRow.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
					public void onEvent(Event event) throws Exception {
						
						TramiteNotaTreeNode clickedNodeValue = (TramiteNotaTreeNode) ((Treeitem) event.getTarget().getParent()).getValue();
						contentDiv.getChildren().clear();
						System.out.println("seleccione--"+clickedNodeValue.getData().getNombre()+" "+contentDiv.getId());
						String nom = clickedNodeValue.getData().getNombre();
						Executions.createComponents(Panels.getURLComponent(nom),contentDiv,null);
					}
				});
			} else { // Category Row
				dataRow.appendChild(new Treecell(contact.getCategoria()));
			}
			// Both category row and contact row can be item dropped
			dataRow.setDroppable("true");
			dataRow.addEventListener(Events.ON_DROP, new EventListener<Event>() {
				@SuppressWarnings("unchecked")
				public void onEvent(Event event) throws Exception {
					// The dragged target is a TreeRow belongs to an
					// Treechildren of TreeItem.
					Treeitem draggedItem = (Treeitem) ((DropEvent) event).getDragged().getParent();
					TramiteNotaTreeNode draggedValue = (TramiteNotaTreeNode) draggedItem.getValue();
					Treeitem parentItem = treeItem.getParentItem();
					contactTreeModel.remove(draggedValue);
					if (isCategory((Tramites) ((TramiteNotaTreeNode) treeItem.getValue()).getData())) {
						contactTreeModel.add((TramiteNotaTreeNode) treeItem.getValue(),
								new DefaultTreeNode[] { draggedValue });
					} else {
						int index = parentItem.getTreechildren().getChildren().indexOf(treeItem);
						if(parentItem.getValue() instanceof TramiteNotaTreeNode) {
							contactTreeModel.insert((TramiteNotaTreeNode)parentItem.getValue(), index, index,
									new DefaultTreeNode[] { draggedValue });
						}
					}
				}
			});
		}

		private boolean isCategory(Tramites contact) {
			return contact.getNombre() == null;
		}
	}

	
	
}
