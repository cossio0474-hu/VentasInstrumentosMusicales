/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Model.Instrumento;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cossi
 */
public class ServicioInstrumentos {
    private static Map<Integer, Instrumento> instrumentos = new HashMap();
    
    public static void addInstrumento(Instrumento instrumento){
        instrumentos.put(instrumento.getId(), instrumento);
    }
     
    public static void deleteInstrumento(int id) throws Exception
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
    
    public static void actualizarInstrumento(int id, Instrumento instrumento) throws Exception
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
    
    public static Instrumento buscarInstrumento(int id) throws Exception
    {
        Instrumento ins = null;
        
        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento != null && instrumento.getId() == id) {
                ins = instrumento;
            }
            
        }
        return ins;
    }
}
