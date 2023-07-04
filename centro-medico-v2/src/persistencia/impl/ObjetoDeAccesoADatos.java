package persistencia.impl;

import modelo.IPaciente;
import modelo.impl.Enfermera;
import modelo.impl.Medico;
import modelo.impl.Paramedico;
import persistencia.IObjetoDeAcessoADatos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjetoDeAccesoADatos implements IObjetoDeAcessoADatos {

    private final List<Medico> medicos = new ArrayList<>();
    private final List<IPaciente> pacientes = new ArrayList<>();
    private final List<Enfermera> enfermeras = new ArrayList<>();
    private final List<Paramedico> paramedicos = new ArrayList<>();


    @Override
    public boolean guardarMedico(Medico m){
        boolean respuesta = false;

        if(!this.medicos.contains(m)){
            this.medicos.add(m);
            respuesta = true;
        }

        return respuesta;

//        Implementación básica usando ciclos.
//        for (Medico medicoActual : this.medicos){
//            if(medicoActual.equals(m)){
//                return false;
//            }
//        }
//
//        this.medicos.add(m);
//
//        return true;
    }

    @Override
    public boolean guardarPaciente(IPaciente p) {
        if (!this.pacientes.contains(p)){
            this.pacientes.add(p);
            return true;
        }
        return false;
    }

    @Override
    public boolean guardarEnfermera(Enfermera e) {
        if (!this.enfermeras.contains(e)){
            this.enfermeras.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean guardarParamedico(Paramedico pm) {
        if (!this.paramedicos.contains(pm)){
            this.paramedicos.add(pm);
            return true;
        }
        return false;
    }

    @Override
    public Collection<IPaciente> consultarPacientes() {
        return new ArrayList<>(this.pacientes);
    }

    @Override
    public Collection<Medico> consultarMedicos() {
        return new ArrayList<>(this.medicos);
    }

    @Override
    public Collection<Enfermera> consultarEnfermeras() {
        return new ArrayList<>(this.enfermeras);
    }

    @Override
    public Collection<Paramedico> consultarParamedicos() {
        return new ArrayList<>(this.paramedicos);
    }
}
