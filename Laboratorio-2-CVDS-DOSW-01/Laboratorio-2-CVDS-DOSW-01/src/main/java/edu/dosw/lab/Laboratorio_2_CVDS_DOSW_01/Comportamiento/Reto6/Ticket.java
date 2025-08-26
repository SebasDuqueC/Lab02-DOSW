package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.Reto6;

public class Ticket {
    private final int id;
    private final String nivel;
    private final String prioridad;
    private final String descripcion;

    public Ticket(int id, String nivel, String prioridad, String descripcion) {
        this.id = id;
        this.nivel = nivel;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    public int getId() { return id; }
    public String getNivel() { return nivel; }
    public String getPrioridad() { return prioridad; }
    public String getDescripcion() { return descripcion; }
}
