package com.mrd.test_pai_rest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plantillas")
@IdClass(PlantillaId.class)  // Indica la clase que define la clave compuesta
public class Plantilla {

    @Id
    @Column(name = "tipo", length = 2)
    private String tipo;

    @Id
    @Column(name = "codigo", length = 4)
    private String codigo;

    @Column(name = "LINEA", nullable = false)
    private int linea;

    @Column(name = "descripcion", nullable = false, length = 80)
    private String descripcion;

    // Getters y Setters (necesarios para Spring)
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getLinea() { return linea; }
    public void setLinea(int linea) { this.linea = linea; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
