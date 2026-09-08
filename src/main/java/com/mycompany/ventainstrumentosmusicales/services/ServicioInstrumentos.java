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

    /**
     * Suma las ventas de los instrumentos de cuerda. El cálculo es
     * polimórfico: se apoya en calcularPrecio(), que InstrumentoCuerda
     * sobrescribe con su propia fórmula (precio * 1.1).
     */
    public double calcularVentasInstrumentoCuerda() {
        double sum = 0;
        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento instanceof InstrumentoCuerda) {
                sum += instrumento.calcularPrecio();
            }
        }
        return sum;
    }

    /**
     * Suma las ventas de los instrumentos de viento. El cálculo es
     * polimórfico: se apoya en calcularPrecio(), que InstrumentoViento
     * sobrescribe con su propia fórmula (precio * 1.2).
     */
    public double calcularVentasInstrumentoViento() {
        double sum = 0;
        for (Instrumento instrumento : instrumentos.values()) {
            if (instrumento instanceof InstrumentoViento) {
                sum += instrumento.calcularPrecio();
            }
        }
        return sum;
    }

    /**
     * Suma el precio de todos los accesorios de cuerda registrados,
     * independientemente del instrumento al que estén asignados.
     */
    public double calcularVentasAccesoriosCuerda() {
        double sum = 0;
        for (AccesorioCuerda accesorio : accesorios.values()) {
            if (accesorio != null) {
                sum += accesorio.getPrecio();
            }
        }
        return sum;
    }

    /**
     * Venta total: instrumentos de cuerda + instrumentos de viento +
     * accesorios de cuerda.
     */
    public double calcularVentasTotales() {
        return calcularVentasInstrumentoCuerda()
                + calcularVentasInstrumentoViento()
                + calcularVentasAccesoriosCuerda();
    }

    public void addAccesorioCuerda(AccesorioCuerda accesorio) throws Exception {
        if (accesorios.containsKey(accesorio.getId())) {
            throw new Exception("Ya existe un accesorio registrado con el ID " + accesorio.getId());
        }

        Instrumento instrumento = buscarInstrumento(accesorio.getIdInstrumento());
        if (instrumento == null) {
            throw new Exception("No existe ningún instrumento con el ID " + accesorio.getIdInstrumento());
        }
        if (!(instrumento instanceof InstrumentoCuerda)) {
            throw new Exception("El instrumento con ID " + accesorio.getIdInstrumento() + " no es un instrumento de cuerda");
        }

        InstrumentoCuerda ins = (InstrumentoCuerda) instrumento;
        ins.addAccesorio(accesorio);
        accesorios.put(accesorio.getId(), accesorio);
        ServicioObserver.cambio();
    }

    public void delAccesorioCuerda(int idAccesorio) throws Exception {
        AccesorioCuerda accesorio = accesorios.get(idAccesorio);
        if (accesorio == null) {
            throw new Exception("No existe ningún accesorio con el ID " + idAccesorio);
        }

        Instrumento instrumento = buscarInstrumento(accesorio.getIdInstrumento());
        if (instrumento instanceof InstrumentoCuerda) {
            ((InstrumentoCuerda) instrumento).delAccesorio(accesorio);
        }

        accesorios.remove(idAccesorio);
        ServicioObserver.cambio();
    }

    public AccesorioCuerda buscarAccesorioCuerda(int idAccesorio) {
        return accesorios.get(idAccesorio);
    }

    public void actualizarAccesorio(int idAccesorio, AccesorioCuerda accesorioNuevo) throws Exception {
        AccesorioCuerda accesorioActual = accesorios.get(idAccesorio);
        if (accesorioActual == null) {
            throw new Exception("No existe ningún accesorio con el ID " + idAccesorio);
        }

        Instrumento instrumentoNuevo = buscarInstrumento(accesorioNuevo.getIdInstrumento());
        if (instrumentoNuevo == null) {
            throw new Exception("No existe ningún instrumento con el ID " + accesorioNuevo.getIdInstrumento());
        }
        if (!(instrumentoNuevo instanceof InstrumentoCuerda)) {
            throw new Exception("El instrumento con ID " + accesorioNuevo.getIdInstrumento() + " no es un instrumento de cuerda");
        }

        // Si el nuevo ID de accesorio ya existe y es distinto del actual, no permitir duplicados
        if (accesorioNuevo.getId() != idAccesorio && accesorios.containsKey(accesorioNuevo.getId())) {
            throw new Exception("Ya existe un accesorio registrado con el ID " + accesorioNuevo.getId());
        }

        // Se retira el accesorio actual de su instrumento de cuerda original
        Instrumento instrumentoActual = buscarInstrumento(accesorioActual.getIdInstrumento());
        if (instrumentoActual instanceof InstrumentoCuerda) {
            ((InstrumentoCuerda) instrumentoActual).delAccesorio(accesorioActual);
        }

        // Se agrega el accesorio actualizado a su instrumento de cuerda (puede ser el mismo u otro)
        ((InstrumentoCuerda) instrumentoNuevo).addAccesorio(accesorioNuevo);

        accesorios.remove(idAccesorio);
        accesorios.put(accesorioNuevo.getId(), accesorioNuevo);
        ServicioObserver.cambio();
    }

    public Map<Integer, AccesorioCuerda> getAccesorios() {
        return Map.copyOf(accesorios);
    }
}
