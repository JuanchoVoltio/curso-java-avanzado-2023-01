package persistencia;

import modelo.impl.Medico;
import modelo.impl.Paciente;

public interface IObjetoDeAcessoADatos { //Data Access Object

    /**
     *
     * @param m El médico que se quiere guardar
     * @return true si guardó el médico, false si el médico ya estaba registrado, en cuyo caso m no será guardado.
     */
    boolean guardarMedico(Medico m);

    /**
     *
     * @param p El paciente que se quiere guardar
     * @return true si se guardó el médico, false si el médico ya estaba registrado, en cuyo caso, p no será guardado.
     */
    boolean guardarPaciente(Paciente p);

    //TODO: Completar los otros métodos.
}
