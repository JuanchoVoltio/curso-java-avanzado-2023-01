package logica;

public interface IGeneradorDeReportes {

    /**
     *
     * @return El reporte a ser mostrado en forma de cadena de caracteres.
     */
    String generarReporteDeMedicos();

    /**
     * Genera un reporte con los datos de los médicos acorde a la @especialidad entregada
     * @param especialidad Describe el código de la especialidad que será usado como criterio de filtrado.
     * @return El reporte a ser mostrado en forma de cadena de caracteres.
     */
    String generarReporteDeMedicosPorEspecialidad(String especialidad);

    /**
     *
     * @return El reporte a ser mostrado en forma de cadena de caracteres.
     */
    String generarReporteDePacientes();


    String generarReporteDePacientesPorGrupoSanguineo();
}
