package org.vmdevel.ejercicio.exception;

public class ErrorMessage {

    private String mensaje;

    public ErrorMessage() {}

    public ErrorMessage(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
