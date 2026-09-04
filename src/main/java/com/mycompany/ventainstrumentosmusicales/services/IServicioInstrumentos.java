/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ventainstrumentosmusicales.services;

import com.mycompany.ventainstrumentosmusicales.model.Instrumento;
import java.util.Map;

/**
 *
 * @author cossi
 */
public interface IServicioInstrumentos {
    
    public void addInstrumento(Instrumento instrumento);
    public Map<Integer, Instrumento> getInstrumento();
    public void deleteInstrumento(int id)throws Exception;
    public void actualizarInstrumento(int id, Instrumento instrumento)throws Exception;
    public Instrumento buscarInstrumento(int id)throws Exception;
    
}
