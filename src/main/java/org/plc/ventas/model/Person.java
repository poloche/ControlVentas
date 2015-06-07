/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.plc.ventas.model;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

/**
 *
 * @author poloche
 */
@Entity
public class Person {
    @PrimaryKey
    private int id;
    private String nombre;
    private int deuda;

    public Person() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDeuda(int i) {
        this.deuda = i;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public int getDeuda() {
        return deuda;
    }
    

}
