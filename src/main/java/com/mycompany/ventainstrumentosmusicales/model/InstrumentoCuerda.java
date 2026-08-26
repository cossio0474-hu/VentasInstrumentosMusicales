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
public class InstrumentoCuerda extends Instrumento{
    
    private int numeroCuerdas;
    private int numeroTrastes;
    private AccesorioCuerda accesorio;
    
    public InstrumentoCuerda(int id, String nombre, LocalDate fechaVenta, double precio, int numeroCuerdas, int numeroTrastes)throws Exception
    {
        super(id, nombre, fechaVenta, precio);
        setNumeroCuerdas(numeroCuerdas);
        this.numeroTrastes = numeroTrastes;
    }
    
    public int getNumeroCuerdas()
    {
        return numeroCuerdas;
    }
    
    public void setNumeroCuerdas(int numeroCuerdas) throws Exception
    {
        if(numeroCuerdas > 0)
        {
            this.numeroCuerdas = numeroCuerdas;
        }
        else
        {
            throw new Exception("Numero de cuerdas menor o igual a 0");
        }
    }
    
    public int getNumeroTrastes()
    {
        return numeroTrastes;
    }
    
    public void setNumeroTrastes(int numeroTrastes)
    {
        this.numeroTrastes = numeroTrastes;
    }
    
    public double calcularPrecio()
    {
        return getPrecio() * 1.1;
                
    }
}
