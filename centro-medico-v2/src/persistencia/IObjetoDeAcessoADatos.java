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

    boolean guardarPaciente(Paciente p);

    //TODO: Completar los otros métodos.
}
