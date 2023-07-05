import modelo.impl.Medico;
import modelo.impl.Paciente;
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
    }
}