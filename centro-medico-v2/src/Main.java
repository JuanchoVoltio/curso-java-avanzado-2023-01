import logica.IGeneradorDeReportes;
import logica.impl.GeneradorDeReportes;
import modelo.impl.Enfermera;
import modelo.impl.Medico;
import modelo.impl.Paciente;
import persistencia.DAO;
import persistencia.IObjetoDeAcessoADatos;
import persistencia.daoimpl.DaoH2Paciente;
import persistencia.impl.ObjetoDeAccesoADatos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        probarBaseDeDatosConMedicos();
    }

    public static void probarBaseDeDatosConMedicos(){
        //En esta prueba esperamos que no se puedan guardar registros duplicados.
        IObjetoDeAcessoADatos baseDeDatos = new ObjetoDeAccesoADatos();
        IGeneradorDeReportes generadorDeReportes = new GeneradorDeReportes(baseDeDatos);
        Medico m = new Medico("123", "Medico 1", "321", 1, Medico.ESPECIALIDAD_GENERALISTA);
        Medico m2 = new Medico("124", "Medico 2", "322", 2, Medico.ESPECIALIDAD_GENERALISTA);
        Medico m3 = new Medico("125", "Medico 3", "323", 3, Medico.ESPECIALIDAD_PEDIATRIA);

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


    public static void probarDao(){
        DAO<Paciente, String> dao = new DaoH2Paciente();

        dao.consultarTodos().forEach(p -> System.out.println(p));

        Paciente p = dao.consultarPorId("123A");
    }
}