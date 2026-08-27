/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventainstrumentosmusicales.model;

import java.time.LocalDate;

/**
 *
 * @author cossi
 */
public abstract class Instrumento {

    private int id;
    private String nombre;
    private double precio;
    private LocalDate fechaVenta;

    public Instrumento(int id, String nombre) throws Exception {
        this.id = id;
        setNombre(nombre);
    }
    
    

    public Instrumento(int id, String nombre, LocalDate fechaVenta, double precio) throws Exception {
        this.id = id;
        this.fechaVenta = fechaVenta;
        setNombre(nombre);
        setPrecio(precio);

    }

    public void setPrecio(double precio) throws Exception {
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new Exception("Precio menor o igual a 0");
        }
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

    public void setNombre(String nombre) throws Exception {
       
        if(nombre.isEmpty())
        {
            throw new Exception ("No se puede crear un instrumento sin un nombre");                 
        }
        else
        {
            this.nombre = nombre;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecion(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public double calcularPrecio()
    {
        return precio;
    }
}
