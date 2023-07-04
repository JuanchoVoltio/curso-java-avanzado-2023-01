package modelo.impl;

import modelo.IPaciente;
import modelo.Persona;

import java.util.Objects;

public class Paciente extends Persona implements IPaciente {
    public Paciente(String dni, String nombre, String telefono) {
        super(dni, nombre, telefono);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
