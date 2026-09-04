/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventainstrumentosmusicales.services;

import com.mycompany.ventainstrumentosmusicales.gui.ICambiable;
import java.util.ArrayList;

/**
 *
 * @author cossi
 */
public class ServicioObserver {

    private static ArrayList<ICambiable> guisNombre
            = new ArrayList();

    public static void addGUIInstrumento(ICambiable gui) {
        guisNombre.add(gui);
    }

    public static void cambio() {
        for (ICambiable gui : guisNombre) {
            gui.cambio();
        }
    }

    public static void delGUIInstrumento(ICambiable gui) {
        guisNombre.remove(gui);
    }
}
