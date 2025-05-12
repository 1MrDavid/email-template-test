package com.mrd.test_pai_rest.model;

import java.util.List;

public class EmailMessage {
    private String tipo;
    private String codigo;
    private List<LineaMensaje> lineas;  // Lista de objetos LineaMensaje

    // Getters y Setters (métodos estándar)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<LineaMensaje> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaMensaje> lineas) {
        this.lineas = lineas;
    }

    // Clase interna para cada línea y mensaje
    public static class LineaMensaje {
        private int linea;
        private String mensaje;

        // Getters y Setters
        public int getLinea() {
            return linea;
        }

        public void setLinea(int linea) {
            this.linea = linea;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}