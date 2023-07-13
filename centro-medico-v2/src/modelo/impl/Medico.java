package modelo.impl;

import modelo.ProfesionalDeLaSalud;

import java.util.Objects;

public class Medico extends ProfesionalDeLaSalud {

    public static final String ESPECIALIDAD_GENERALISTA = "GN";
    public static final String ESPECIALIDAD_PEDIATRIA = "P";

    private String especialidad;

    public Medico(String dni, String nombre, String telefono, Integer id, String especialidad) {
        super(dni, nombre, telefono, id);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico)) return false;
        if (!super.equals(o)) return false;
        Medico medico = (Medico) o;
        return Objects.equals(getEspecialidad(), medico.getEspecialidad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEspecialidad());
    }
}
