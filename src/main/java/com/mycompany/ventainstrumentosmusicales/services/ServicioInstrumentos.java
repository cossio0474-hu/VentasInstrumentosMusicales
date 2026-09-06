/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventainstrumentosmusicales.services;

import com.mycompany.ventainstrumentosmusicales.model.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cossi
 */
public class ServicioInstrumentos implements IServicioInstrumentos {

    private Map<Integer, Instrumento> instrumentos = new HashMap();
    private Map<Integer, AccesorioCuerda> accesorios = new HashMap<>();

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
    public Map<Integer, Instrumento> getInstrumento() {
        return Map.copyOf(instrumentos);
    }

    @Override
    public void addInstrumento(Instrumento instrumento) {
        instrumentos.put(instrumento.getId(), instrumento);
        ServicioObserver.cambio();
    }

    @Override
    public void deleteInstrumento(int id) throws Exception {
        if (instrumentos.values() != null) {
            instrumentos.remove(id);
        } else {
            throw new Exception("No se ha encontrado ningun instrumento para eliminar");
        }
        ServicioObserver.cambio();
    }

    @Override
    public void actualizarInstrumento(int id, Instrumento instrumento) throws Exception {
        if (instrumentos.values() != null) {
            instrumentos.remove(id);
            instrumentos.put(id, instrumento);
        } else {
            throw new Exception("No se ha encontrado ningun instrumento para Actualizar");
        }
        ServicioObserver.cambio();
    }

    @Override
    public Instrumento buscarInstrumento(int id) throws Exception {
        Instrumento ins = null;

        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento != null && instrumento.getId() == id) {
                ins = instrumento;
            }

        }
        return ins;
    }

    public double calculatVentas() {
        double sum = 0;
        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento != null) {
                sum += instrumento.calcularPrecio();
            }

        }
        return sum;
    }

    public void addAccesorioCuerda(AccesorioCuerda accesorio) throws Exception {
        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento != null && instrumento.getId() == accesorio.getIdInstrumento()) {
                if (instrumento instanceof InstrumentoCuerda) {
                    InstrumentoCuerda ins = (InstrumentoCuerda) instrumento;
                    ins.addAccesorio(accesorio);
                    instrumentos.remove(accesorio.getIdInstrumento());
                    instrumentos.put(accesorio.getIdInstrumento(), ins);
                    accesorios.put(accesorio.getId(), accesorio);
                } else {
                    throw new Exception("No se ha encontrado el instrumento de cuerda");
                }
            }

        }
    }

    public void delAccesorioCuerda(int idAccesorio) throws Exception {
        if (accesorios.values() != null) {
            AccesorioCuerda accesorio = accesorios.get(idAccesorio);

            for (Instrumento instrumento : instrumentos.values()) {
                if (instrumento != null && instrumento.getId() == accesorio.getIdInstrumento()) {
                    if (instrumento instanceof InstrumentoCuerda) {
                        InstrumentoCuerda ins = (InstrumentoCuerda) instrumento;
                        ins.delAccesorio(accesorio);
                        instrumentos.remove(accesorio.getIdInstrumento());
                        instrumentos.put(accesorio.getIdInstrumento(), ins);
                        accesorios.remove(idAccesorio);
                    } else {
                        throw new Exception("No se ha encontrado el instrumento de cuerda");
                    }
                }

            }

        }

    }
    
    public AccesorioCuerda buscarAccesorioCuerda(int idAccesorio)
    {
        AccesorioCuerda acc = null;

        for (AccesorioCuerda accesorio : accesorios.values()) {
            if (accesorio != null && accesorio.getId() == idAccesorio) {
                acc = accesorio;
            }

        }
        return acc;
    }
    
    public void actualizarAccesorio(int idAccesorio, AccesorioCuerda accesorio) throws Exception
    {
        if (accesorios.values() != null) {
            
            AccesorioCuerda acc = accesorios.get(idAccesorio);
            
            for (Instrumento instrumento : instrumentos.values()) {
                if (instrumento != null && instrumento.getId() == acc.getIdInstrumento()) {
                    if (instrumento instanceof InstrumentoCuerda) {
                        InstrumentoCuerda ins = (InstrumentoCuerda) instrumento;
                        ins.delAccesorio(acc);
                        ins.addAccesorio(accesorio);
                        instrumentos.remove(acc.getIdInstrumento());
                        instrumentos.put(acc.getIdInstrumento(), ins);
                        accesorios.remove(idAccesorio);
                        accesorios.put(idAccesorio, accesorio);
                    } else {
                        throw new Exception("No se ha encontrado el instrumento de cuerda");
                    }
                }

            }
           
        }
    }
    
    public Map<Integer, AccesorioCuerda> getAccesorios()
    {
         return Map.copyOf(accesorios);
    }
}
