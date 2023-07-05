package modelo.impl;

import modelo.IPaciente;
import modelo.Persona;

public class Paciente extends Persona implements IPaciente {

    private String grupoSanguineo;

    public Paciente(String dni, String nombre, String telefono, String grupoSanguineo) {
        super(dni, nombre, telefono);
        setGrupoSanguineo(grupoSanguineo);
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = !grupoSanguineo.isBlank() ? grupoSanguineo : "N/A";
    }
}
