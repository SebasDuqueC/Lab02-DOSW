package edu.dosw.lab.comportamiento.Reto6;

public abstract class Tecnico {
    protected Tecnico siguiente;
    protected String nivel;
    protected String prioridadMaxima;
    protected String nombre;

    public Tecnico(String nombre, String nivel, String prioridadMaxima) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.prioridadMaxima = prioridadMaxima;
    }

    public void setSiguiente(Tecnico siguiente) {
        this.siguiente = siguiente;
    }

    public String procesar(Ticket ticket) {
        if (puedeResolver(ticket)) {
            return "Técnico " + nombre + " resolvió el problema.";
        } else if (siguiente != null) {
            String resultado = siguiente.procesar(ticket);
            if (resultado.contains("resolvió")) {
                return "Técnico " + nombre + " no pudo resolver. " + resultado;
            } else {
                return resultado;
            }
        } else {
            return "Ningún técnico disponible. Ticket pendiente de escalamiento.";
        }
    }

    protected boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel().equalsIgnoreCase(nivel) && prioridadValida(ticket.getPrioridad());
    }

    private boolean prioridadValida(String prioridad) {
        if (prioridadMaxima.equalsIgnoreCase("alta")) return true;
        if (prioridadMaxima.equalsIgnoreCase("media") && !prioridad.equalsIgnoreCase("alta")) return true;
        if (prioridadMaxima.equalsIgnoreCase("baja") && prioridad.equalsIgnoreCase("baja")) return true;
        return false;
    }
}
