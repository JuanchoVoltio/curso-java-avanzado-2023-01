import logica.IGeneradorDeReportes;
import logica.impl.GeneradorDeReportes;
import modelo.impl.Medico;
import modelo.impl.Paciente;
import persistencia.IObjetoDeAcessoADatos;
import persistencia.impl.ObjetoDeAccesoADatos;

public class Main {
    public static void main(String[] args) {
        probarBaseDeDatosConMedicos();
        probarReportesDePacientes();
    }

    public static void probarBaseDeDatosConMedicos(){
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

    public static void probarReportesDePacientes(){
        IObjetoDeAcessoADatos baseDeDatos = new ObjetoDeAccesoADatos();
        IGeneradorDeReportes generadorDeReportes = new GeneradorDeReportes(baseDeDatos);

        Paciente p1 = new Paciente("123", "Paciente 1", "321", "A+");
        Paciente p2 = new Paciente("124", "Paciente 2", "322", "A+");
        Paciente p3 = new Paciente("125", "Paciente 3", "323", "A-");

        baseDeDatos.guardarPaciente(p1);
        baseDeDatos.guardarPaciente(p2);
        baseDeDatos.guardarPaciente(p3);

        System.out.println(generadorDeReportes.generarReporteDePacientes());

        System.out.println(generadorDeReportes.generarReporteDePacientesPorGrupoSanguineo("A+"));
    }
}
