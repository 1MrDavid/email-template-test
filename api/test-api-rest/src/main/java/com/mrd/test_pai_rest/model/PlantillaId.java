package com.mrd.test_pai_rest.model;

import java.io.Serializable;
import java.util.Objects;

public class PlantillaId implements Serializable {
    private String tipo;
    private String codigo;
    private int linea;

    // Constructor vacío (obligatorio)
    public PlantillaId() {}

    // Constructor con campos
    public PlantillaId(String tipo, String codigo, int linea) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.linea = linea;
    }

    // Getters, setters, equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantillaId that = (PlantillaId) o;
        return linea == that.linea &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, codigo, linea);
    }
}
