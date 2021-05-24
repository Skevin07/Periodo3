package com.laboratorio2p3.entidades;

import java.util.ArrayList;

public class Proveedor {
	private int Id;
    private String Nombre;
    private String Contacto;
    private String Direccion;
    private String Telefono;
    private String Correo;
    private String Nit;
    private String Nrc;
    private ArrayList<Marca> Marcas;
    
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getContacto() {
		return Contacto;
	}
	public void setContacto(String contacto) {
		Contacto = contacto;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getNit() {
		return Nit;
	}
	public void setNit(String nit) {
		Nit = nit;
	}
	public String getNrc() {
		return Nrc;
	}
	public void setNrc(String nrc) {
		Nrc = nrc;
	}
	public ArrayList<Marca> getMarcas() {
		return Marcas;
	}
	public void setMarcas(ArrayList<Marca> marcas) {
		Marcas = marcas;
	}
}
