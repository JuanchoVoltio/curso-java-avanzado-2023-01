import logica.IGeneradorDeReportes;
import logica.impl.GeneradorDeReportes;
import modelo.impl.Medico;
import persistencia.IObjetoDeAcessoADatos;
import persistencia.impl.ObjetoDeAccesoADatos;

public class Main {
    public static void main(String[] args) {
        probarBaseDeDatos();
    }

    public static void probarBaseDeDatos(){
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
}