package modelo.impl;

import modelo.ProfesionalDeLaSalud;

public class Medico extends ProfesionalDeLaSalud {

    public static final String ESPECIALIDAD_GENERALISTA = "GN";
    public static final String ESPECIALIDAD_PEDIATRIA = "P";

    private String especialidad;

    public Medico(String dni, String nombre, String telefono, String especialidad) {
        super(dni, nombre, telefono);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
