import modelo.impl.Enfermera;
import modelo.impl.Medico;
import modelo.impl.Paciente;
import modelo.impl.Paramedico;
import persistencia.IObjetoDeAcessoADatos;
import persistencia.impl.ObjetoDeAccesoADatos;

public class Main {
    public static void main(String[] args) {
        probarBaseDeDatos();
    }

    public static void probarBaseDeDatos(){
        //En esta prueba esperamos que no se puedan guardar registros duplicados.
        IObjetoDeAcessoADatos baseDeDatos = new ObjetoDeAccesoADatos();
        Medico m = new Medico("123", "Bla", "321", Medico.ESPECIALIDAD_GENERALISTA);
        Medico m2 = new Medico("123", "Bla", "321", Medico.ESPECIALIDAD_GENERALISTA);

        System.out.println(baseDeDatos.guardarMedico(m));
        System.out.println(baseDeDatos.guardarMedico(m2));

        Paciente paciente1 = new Paciente("123", "Paciente", "555-555-555");
        Paciente paciente2 = new Paciente("123", "Paciente", "555-555-555");

        System.out.println(baseDeDatos.guardarPaciente(paciente1));
        System.out.println(baseDeDatos.guardarPaciente(paciente2));

        Enfermera enfermera1 = new Enfermera("456", "Enfermera", "655-555-555");
        Enfermera enfermera2 = new Enfermera("456", "Enfermera", "655-555-555");

        System.out.println(baseDeDatos.guardarEnfermera(enfermera1));
        System.out.println(baseDeDatos.guardarEnfermera(enfermera2));

        Paramedico paramedico1 = new Paramedico("789", "Paramédico", "555-655-555");
        Paramedico paramedico2 = new Paramedico("789", "Paramédico", "555-655-555");

        System.out.println(baseDeDatos.guardarParamedico(paramedico1));
        System.out.println(baseDeDatos.guardarParamedico(paramedico2));
    }
}