package persistencia;

import modelo.impl.Enfermera;
import modelo.impl.Medico;
import modelo.impl.Paciente;

import java.util.List;

public interface IObjetoDeAcessoADatos { //Data Access Object

    /**
     *
     * @param m El {@link Medico} que se quiere guardar
     * @return true si guardó el médico, false si el médico ya estaba registrado, en cuyo caso m no será guardado.
     */
    boolean guardarMedico(Medico m);

    /**
     *
     * @param p El {@link Paciente} que se quiere guardar
     * @return true si se guardó el médico, false si el médico ya estaba registrado, en cuyo caso, p no será guardado.
     */
    boolean guardarPaciente(Paciente p);

    /**
     *
     * @param e La {@link Enfermera} que se quiere guardar
     * @return true si se guardó el médico, false si el médico ya estaba registrado, en cuyo caso, p no será guardado.
     */
    boolean guardarEnfermera(Enfermera e);


    /**
     *
     * @return una @{@link List} inmodificable de objetos @{@link Medico}.
     */
    List<Medico> consultarMedicos();

    List<Paciente> consultarPacientes();

    List<Enfermera> consultarEnfermeras();

    //TODO: Completar los otros métodos.
}
