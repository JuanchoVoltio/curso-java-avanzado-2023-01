package logica.impl;

import logica.IGeneradorDeReportes;
import persistencia.IObjetoDeAcessoADatos;

public class GeneradorDeReportes implements IGeneradorDeReportes {

    private final IObjetoDeAcessoADatos baseDeDatos;

    public GeneradorDeReportes(IObjetoDeAcessoADatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    @Override
    public String generarReporteDeMedicos() {
        return null;
    }

    @Override
    public String generarReporteDeMedicosPorEspecialidad(String especialidad) {
        //TODO: implementar este método usando programación imperativa
        return null;
    }

    @Override
    public String generarReporteDePacientes() {
        return null;
    }

    @Override
    public String generarReporteDePacientesPorGrupoSanguineo() {
        //TODO: implementar este método usando streams y programación funcional
        return null;
    }
}
