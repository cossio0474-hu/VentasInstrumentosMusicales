/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventainstrumentosmusicales.model;

import java.util.ArrayList;

/**
 *
 * @author UNIBAGUE
 */
public class AccesorioCuerda {

    public enum tipo {
    CUERDAPULSADA, CUERDAFROTADA
    }
    
    private int id;
    private String nombre;
    private tipo tipo; 
    private double precio;
    private String marca;
    private   ArrayList<InstrumentoCuerda> istrumentos;
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public tipo getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public AccesorioCuerda(int id, String nombre, tipo tipo, double precio, String marca) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
}
