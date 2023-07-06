package persistencia.impl;

import modelo.impl.Enfermera;
import modelo.impl.Medico;
import modelo.impl.Paciente;
import modelo.impl.Paramedico;
import persistencia.IObjetoDeAcessoADatos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjetoDeAccesoADatos implements IObjetoDeAcessoADatos {

    private final List<Medico> medicos = new ArrayList<>();
    private final List<Paciente> pacientes = new ArrayList<>();
    private final Set<Enfermera> enfermeras = new HashSet<>();
    private final List<Paramedico> paramedicos = new ArrayList<>();


    @Override
    public boolean guardarMedico(final Medico m) {
        boolean respuesta = false;

        if (!this.medicos.contains(m)) {
            this.medicos.add(m);
            respuesta = true;
        }

        return respuesta;

//        Implementación básica usando ciclos.
//        for (Medico medicoActual : this.medicos) {
//            if (medicoActual.equals(m)) {
//                return false;
//            }
//        }
//
//        this.medicos.add(m);
//
//        return true;
    }

    @Override
    public boolean guardarPaciente(final Paciente p) {
        if (!this.pacientes.contains(p)) {
            this.pacientes.add(p);
            return true;
        }
        return false;
    }

    @Override
    public boolean guardarEnfermera(final Enfermera e) {
        //TODO: Implementar usando Set en vez de List
        if (!this.enfermeras.contains(e)) {
            this.enfermeras.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean guardarParamedico(final Paramedico pm) {
        if (!this.paramedicos.contains(pm)) {
            this.paramedicos.add(pm);
            return true;
        }
        return false;
    }

    @Override
    public List<Medico> consultarMedicos() {
        return List.copyOf(this.medicos);
    }

    @Override
    public List<Paciente> consultarPacientes() {
        return List.copyOf(this.pacientes);
    }

    @Override
    public List<Enfermera> consultarEnfermeras() {
        return List.copyOf(this.enfermeras);
    }

    @Override
    public List<Paramedico> consultarParamedicos() {
        return List.copyOf(this.paramedicos);
    }
}
