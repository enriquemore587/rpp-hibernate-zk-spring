package org.CopiasCertificadas.view.model;

public class Tramites {
	private String nombre;
	private String categoria;
	private String imagen;
	
	public Tramites(String categoria) {
		this.categoria = categoria;
		this.nombre = null;
		this.imagen = null;
	}
	
	public Tramites(String nombre, String imagen) {
		this.nombre = nombre;
		this.categoria = null;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
