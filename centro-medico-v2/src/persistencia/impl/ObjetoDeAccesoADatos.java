package persistencia.impl;

import modelo.IPaciente;
import modelo.impl.Enfermera;
import modelo.impl.Medico;
import modelo.impl.Paciente;
import modelo.impl.Paramedico;
import persistencia.IObjetoDeAcessoADatos;

import java.util.ArrayList;
import java.util.List;

public class ObjetoDeAccesoADatos implements IObjetoDeAcessoADatos {

    private List<Medico> medicos = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Enfermera> enfermeras = new ArrayList<>();
    private final List<Paramedico> paramedicos = new ArrayList<>();


    @Override
    public boolean guardarMedico(Medico m){
        boolean respuesta = false;

        if(!this.medicos.contains(m)){
            this.medicos.add(m);
            respuesta = true;
        }

        System.err.println(respuesta);

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
    public boolean guardarPaciente(Paciente p) {
        if (!this.pacientes.contains(p)){
            this.pacientes.add(p);
            return true;
        }

        System.err.println("El paciente " + p + " está duplicado.");
        return false;
    }

    @Override
    public boolean guardarEnfermera(Enfermera e) {
        //TODO: Implementar usando Set en vez de List
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
