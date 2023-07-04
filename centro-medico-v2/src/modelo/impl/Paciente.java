package modelo.impl;

import modelo.IPaciente;
import modelo.Persona;

public class Paciente extends Persona implements IPaciente {
    public Paciente(String dni, String nombre, String telefono) {
        super(dni, nombre, telefono);
    }
}
