package com.ipartek.model;

public class Producto {
	private int id;
	private String nombre;
	private int idUsuario;
	public Producto(int id, String nombre, int idUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idUsuario = idUsuario;
	}
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.idUsuario = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", idUsuario=" + idUsuario + "]";
	}

}
