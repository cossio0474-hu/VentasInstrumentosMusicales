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
public class InstrumentoViento extends Instrumento{
    
    private int numeroLlaves;
    private String tipoBoquilla;
    
    public InstrumentoViento(int id, String nombre, LocalDate fechaVenta, double precio, int numeroLlaves, String tipoBoquilla) throws Exception
    {
        super(id, nombre, fechaVenta, precio);
        this.numeroLlaves = numeroLlaves;
        this.tipoBoquilla = tipoBoquilla;
    }
    
    public int getNumeroLlaves()
    {
        return numeroLlaves;
    }
    
    public void setNumeroLlaves(int numeroLlaves)
    {
        this.numeroLlaves = numeroLlaves;
    }
    
    public String getTipoBoquilla()
    {
        return tipoBoquilla;
    }
    
    public void setTipoBoquilla(String tipoBoquilla)
    {
        this.tipoBoquilla = tipoBoquilla;
    }
    
    
}
