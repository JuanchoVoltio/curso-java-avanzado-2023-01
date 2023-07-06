import logica.IGeneradorDeReportes;
import logica.impl.GeneradorDeReportes;
import modelo.impl.Medico;
import modelo.impl.Paciente;
import persistencia.IObjetoDeAcessoADatos;
import persistencia.impl.ObjetoDeAccesoADatos;
import presentacion.IPublicadorDeReportes;
import presentacion.impl.PublicadorDeReportesEnPantalla;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        probarBaseDeDatosConMedicos();
        probarPublicarEnPantallaReporteMediasDeEdadDePacienteAgrupadoPorGrupoSanguineo();
    }

    public static void probarBaseDeDatosConMedicos(){
        //En esta prueba esperamos que no se puedan guardar registros duplicados.
        IObjetoDeAcessoADatos baseDeDatos = new ObjetoDeAccesoADatos();
        IGeneradorDeReportes generadorDeReportes = new GeneradorDeReportes(baseDeDatos);
        Medico m = new Medico("123", "Medico 1", "321", Medico.ESPECIALIDAD_GENERALISTA);
        Medico m2 = new Medico("124", "Medico 2", "322", Medico.ESPECIALIDAD_GENERALISTA);
        Medico m3 = new Medico("125", "Medico 3", "323", Medico.ESPECIALIDAD_PEDIATRIA);

        baseDeDatos.guardarMedico(m);
        baseDeDatos.guardarMedico(m2);
        baseDeDatos.guardarMedico(m3);

        System.out.println(generadorDeReportes.generarReporteDeMedicos());

        System.out.println(generadorDeReportes.generarReporteDeMedicosPorEspecialidad(Medico.ESPECIALIDAD_GENERALISTA));
    }

    public static void probarBaseDeDatosConEnfermeras(){
        //En esta prueba esperamos que no se puedan guardar registros duplicados.
        IObjetoDeAcessoADatos baseDeDatos = new ObjetoDeAccesoADatos();

    }

    public static void probarPublicarEnPantallaReporteMediasDeEdadDePacienteAgrupadoPorGrupoSanguineo() {
        IObjetoDeAcessoADatos baseDeDatos = new ObjetoDeAccesoADatos();
        IGeneradorDeReportes generadorDeReportes = new GeneradorDeReportes(baseDeDatos);
        IPublicadorDeReportes publicadorDeReportes = new PublicadorDeReportesEnPantalla();

        baseDeDatos.guardarPaciente(new Paciente("123", "Paciente 1", "555-789-123",
                LocalDate.of(1983, 8, 18),
                "A+"));
        baseDeDatos.guardarPaciente(new Paciente("456", "Paciente 2", "555-789-789",
                LocalDate.of(1982, 2, 15),
                "A-"));
        baseDeDatos.guardarPaciente(new Paciente("789", "Paciente 3", "555-789-555",
                LocalDate.of(1992, 4, 11),
                "A+"));
        baseDeDatos.guardarPaciente(new Paciente("987", "Paciente 4", "555-789-423",
                LocalDate.of(1972, 11, 11),
                "A+"));
        baseDeDatos.guardarPaciente(new Paciente("654", "Paciente 5", "555-789-012",
                LocalDate.of(2002, 12, 9),
                "A-"));
        baseDeDatos.guardarPaciente(new Paciente("321", "Paciente 6", "555-789-123",
                LocalDate.of(1985, 5, 13),
                "B+"));
        baseDeDatos.guardarPaciente(new Paciente("753", "Paciente 7", "555-789-057",
                LocalDate.of(1948, 3, 2),
                "B+"));
        baseDeDatos.guardarPaciente(new Paciente("951", "Paciente 8", "555-789-570",
                LocalDate.of(1960, 6, 30),
                "AB-"));

        System.out.printf("Hay %d pacientes en el sistema.%n", baseDeDatos.consultarPacientes().stream().count());
        baseDeDatos.consultarPacientes().forEach(System.out::println);

        final String reporte = generadorDeReportes.generarReporteMediasDeEdadDePacienteAgrupadoPorGrupoSanguineo();
        publicadorDeReportes.publicarReporte(reporte);
    }
}
