package modelo;

import modelo.IProfesionalDeLaSalud;
import modelo.Persona;

public abstract class ProfesionalDeLaSalud extends Persona implements IProfesionalDeLaSalud {
    public ProfesionalDeLaSalud(String dni, String nombre, String telefono) {
        super(dni, nombre, telefono);
    }
}
