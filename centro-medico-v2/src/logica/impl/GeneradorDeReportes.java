package logica.impl;

import logica.IGeneradorDeReportes;
import modelo.impl.Medico;
import modelo.impl.Paciente;
import persistencia.IObjetoDeAcessoADatos;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
//            if (m.getEspecialidad().equals(especialidad)){
//                medicosFiltrados.add(m);
//            }
//        }
//
//       return this.aplicarPlantillaDeReporteDeMedicos(medicosFiltrados);
//    }

    @Override
    public String generarReporteDeMedicosPorEspecialidad(String especialidad) {
        //Implementando este método usando programación funcional
        List<Medico> medicos = baseDeDatos.consultarMedicos();
        List<Medico> medicosFiltrados = medicos.stream().filter((Medico m) -> m.getEspecialidad().equals(especialidad)).collect(Collectors.toList());

        return this.aplicarPlantillaDeReporteDeMedicos(medicosFiltrados);
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

    @Override
    public String generarReporteMediasDeEdadDePacienteAgrupadoPorGrupoSanguineo() {
        final LocalDate now = LocalDate.now();
        Map<String, Double> datos = baseDeDatos.consultarPacientes()
                .stream()
                .collect(Collectors.groupingBy(
                        // Agrupamos por grupo sanguíneo
                        Paciente::getGrupoSanguineo,
                        // En un TreeMap para ordenar las claves por su orden natural
                        () -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER),
                        // ejecutando la función de grupo AVG sobre el atributo edad
                        Collectors.averagingDouble(p -> p.getEdad(now))));
        StringBuilder reporte = new StringBuilder(
                "-- LISTADO DE EDADES PROMEDIO DE PACIENTES PARA CADA GRUPO SANGUÍNEO --\n")
                .append("-----------------------------------------------------------------------\n")
                .append("| Grupo sanguíneo |  Media de edad  |\n");

        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            reporte.append(String.format("| %15s | %15.2f |%n", entry.getKey(), entry.getValue()));
        }

        reporte.append("-----------------------------------------------------------------------\n");

        return reporte.toString();
    }

    private String aplicarPlantillaDeReporteDeMedicos(List<Medico> datos){
        StringBuilder reporte = new StringBuilder("-- LISTADO DE MÉDICOS --\n------------------\n|   Nombre   | Especialidad |\n");

        for(Medico m : datos){
            reporte.append("| " + m.getNombre() + "  | " + m.getEspecialidad() + " |\n");
        }

        reporte.append("---------------------------------\n");

        return reporte.toString();
    }
}
