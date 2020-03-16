package com.navent.dto;

public class AltaPedidoDto {
	
	private Integer id; 
	
	private String nombre;
	
	private int monto;
	
	private int descuento;

	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the monto
	 */
	public int getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(int monto) {
		this.monto = monto;
	}

	/**
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

}
