package org.CopiasCertificadas.view.model;

public class TramiteNotasList {

	
	public final static String Category = "Category";
	public final static String Contact = "Contact";
	
	private TramiteNotaTreeNode root;
	public TramiteNotasList() {
		
		root = new TramiteNotaTreeNode(null,
				new TramiteNotaTreeNode[] {
						new TramiteNotaTreeNode(
								new Tramites("VENTANILLA"),
									new TramiteNotaTreeNode[] {
											new TramiteNotaTreeNode(new Tramites("CP :: CIUDADANO || APODERADO || ALBACEA", "/images/person.png")),
											new TramiteNotaTreeNode(new Tramites("CP :: NOTARIOS", "person.png")),
											new TramiteNotaTreeNode(new Tramites("CP :: NOTARIO SESION", "/images/person.png")),
											new TramiteNotaTreeNode(
													new Tramites("BUSQUEDAS"),
														new TramiteNotaTreeNode[] {
																new TramiteNotaTreeNode(new Tramites("BUSQUEDAS :: COPIAS", "/images/person.png"))
														}
													)
									}
								),
						new TramiteNotaTreeNode(
								new Tramites("AVISOS NOTARIALES"),
									new TramiteNotaTreeNode[] {
											new TramiteNotaTreeNode(new Tramites("AVISOS NOTARIALES", "Contact.png")),
											new TramiteNotaTreeNode(
													new Tramites("BUSQUEDAS"),
														new TramiteNotaTreeNode[] {
																new TramiteNotaTreeNode(new Tramites("BUSQUEDAS :: AVISOS", "Contact.png"))
														}
													)
									}
								),
						new TramiteNotaTreeNode(
								new Tramites("PANELES"),
									new TramiteNotaTreeNode[] {
											new TramiteNotaTreeNode(new Tramites("BANDEJA DE AVISOS", "Contact.png")),
											new TramiteNotaTreeNode(new Tramites("BANDEJA DE COPIAS CERTIFICADAS", "Contact.png")),
											new TramiteNotaTreeNode(new Tramites("BANDEJA PROTOCOLO : : AVISOS", "Contact.png"))
											
									}
								)
				},
				true
			);
		
	}
	public TramiteNotaTreeNode getRoot() {
		return root;
	}
}
