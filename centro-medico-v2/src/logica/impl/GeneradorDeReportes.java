package logica.impl;

import logica.IGeneradorDeReportes;
import modelo.impl.Medico;
import persistencia.IObjetoDeAcessoADatos;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GeneradorDeReportes implements IGeneradorDeReportes {

    private final IObjetoDeAcessoADatos baseDeDatos;

    public GeneradorDeReportes(IObjetoDeAcessoADatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    @Override
    public String generarReporteDeMedicos() {
        List<Medico> medicos = baseDeDatos.consultarMedicos();

        return this.aplicarPlantillaDeReporteDeMedicos(medicos);
    }

//    @Override
//    public String generarReporteDeMedicosPorEspecialidad(String especialidad) {
//        //Implementando este método usando programación imperativa
//        List<Medico> medicos = baseDeDatos.consultarMedicos();
//        List<Medico> medicosFiltrados = new ArrayList<>();
//
//        for (Medico m : medicos){
//            if (Objects.equals(m.getEspecialidad(), especialidad)){
//                medicosFiltrados.add(m);
//            }
//        }
//
//       return this.aplicarPlantillaDeReporteDeMedicos(medicosFiltrados);
//    }

    @Override
    public String generarReporteDeMedicosPorEspecialidad(final String especialidad) {
        // Implementando este método usando programación funcional
        List<Medico> medicos = baseDeDatos.consultarMedicos();
        List<Medico> medicosFiltrados = medicos
                .stream()
                .filter((Medico m) -> Objects.equals(m.getEspecialidad(), especialidad))
                .collect(Collectors.toList());

        return this.aplicarPlantillaDeReporteDeMedicos(medicosFiltrados);
    }

    @Override
    public String generarReporteDePacientes() {
        //TODO: implementar este método usando streams y programación funcional
        return null;
    }

    @Override
    public String generarReporteDePacientesPorGrupoSanguineo(final String grupoSanguineo) {
        //TODO: implementar este método usando streams y programación funcional
        return null;
    }

    private String aplicarPlantillaDeReporteDeMedicos(final List<Medico> datos){
        StringBuilder reporte = new StringBuilder("-- LISTADO DE MÉDICOS --\n")
                .append("------------------\n")
                .append("|   Nombre   | Especialidad |\n");

        for (Medico m : datos) {
            reporte.append("| ")
                    .append(m.getNombre()).append(" | ")
                    .append(m.getEspecialidad()).append(" |\n");
        }

        reporte.append("---------------------------------\n");

        return reporte.toString();
    }
}
