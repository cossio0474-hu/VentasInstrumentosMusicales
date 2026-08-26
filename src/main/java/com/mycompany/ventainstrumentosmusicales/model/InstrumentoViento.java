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
public class InstrumentoViento extends Instrumento implements CalcularRegistroLlaves{
    
    private int numeroLlaves;
    private String tipoBoquilla;
    
    public InstrumentoViento(int id, String nombre, LocalDate fechaVenta, double precio, int numeroLlaves, String tipoBoquilla) throws Exception
    {
        super(id, nombre, fechaVenta, precio);
        setNumeroLlaves(numeroLlaves);
        this.tipoBoquilla = tipoBoquilla;
    }
    
    public int getNumeroLlaves()
    {
        return numeroLlaves;
    }
    
    public void setNumeroLlaves(int numeroLlaves) throws Exception
    {
         if (numeroLlaves >= 0) {
            this.numeroLlaves = numeroLlaves;
        } else {
            throw new Exception("numero de llaves menor o igual a 0");
        }
    }
    
    public String getTipoBoquilla()
    {
        return tipoBoquilla;
    }
    
    public void setTipoBoquilla(String tipoBoquilla)
    {
        this.tipoBoquilla = tipoBoquilla;
    }
    
    public int calcularRegistro(int numeroLLaves)
    {
        int registro; 
        if(numeroLLaves <= 5)
        {
            registro = 1;
        }
        else if (numeroLLaves <= 10)
        {
            registro = 2;
        }
        else
        {
            registro = 3;
        }
        return registro;
    }
    
    public double calcularPrecio()
    {
        return getPrecio() * 1.2;
                
    }

   
}
