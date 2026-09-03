/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventainstrumentosmusicales.services;

import com.mycompany.ventainstrumentosmusicales.model.Instrumento;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cossi
 */
public class ServicioInstrumentos implements IServicioInstrumento{
    
    private  Map<Integer, Instrumento> instrumentos = new HashMap();
    
    
    // Única instancia de la clase
    private static ServicioInstrumentos instancia;

    // Constructor privado
    private ServicioInstrumentos() {
    }

    // Método para obtener la única instancia
    public static ServicioInstrumentos getInstancia() {
        if (instancia == null) {
            instancia = new ServicioInstrumentos();
        }

        return instancia;
    }
    
    @Override
    public  Map<Integer, Instrumento> getInstrumento(){
        return Map.copyOf(instrumentos);
    }
    @Override
    public void addInstrumento(Instrumento instrumento){
        instrumentos.put(instrumento.getId(), instrumento);
    }
    
    @Override
    public void deleteInstrumento(int id) throws Exception
    {
        if(instrumentos.values() != null)
        {
            instrumentos.remove(id);
        }
        else
        {
            throw new Exception("No se ha encontrado ningun instrumento para eliminar");
        }
    }
    
    @Override
    public void actualizarInstrumento(int id, Instrumento instrumento) throws Exception
    {
        if(instrumentos.values() != null)
        {
            instrumentos.remove(id);
            instrumentos.put(id, instrumento);
        }
        else
        {
            throw new Exception("No se ha encontrado ningun instrumento para Actualizar");
        }
    }
    
    @Override
    public Instrumento buscarInstrumento(int id) throws Exception
    {
        Instrumento ins = null;
        
        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento != null && instrumento.getId() == id) {
                ins = instrumento;
            }
            
        }
        return ins;
    }
    
    public double calculatVentas()
    {
        double sum = 0;
        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento != null) {
                sum += instrumento.calcularPrecio();
            }
            
        }
        return sum;
    }
}
