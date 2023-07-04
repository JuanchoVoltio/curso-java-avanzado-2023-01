package persistencia;

import modelo.IPaciente;
import modelo.impl.Enfermera;
import modelo.impl.Medico;
import modelo.impl.Paramedico;

import java.util.Collection;

public interface IObjetoDeAcessoADatos { //Data Access Object

    /**
     *
     * @param m El médico que se quiere guardar
     * @return true si guardó el médico, false si el médico ya estaba registrado,
     *         en cuyo caso {@code m} no será guardado.
     */
    boolean guardarMedico(Medico m);

    /**
     *
     * @param p El paciente que se quiere guardar
     * @return true si guardó el paciente, false si el paciente ya estaba registrado,
     *         en cuyo caso {@code p} no será guardado.
     */
    boolean guardarPaciente(IPaciente p);

    /**
     *
     * @param e La enfermera que se quiere guardar
     * @return true si guardó la enfermera, false si la enferemera ya estaba registrada,
     *         en cuyo caso {@code p} no será guardado.
     */
    boolean guardarEnfermera(Enfermera e);

    /**
     *
     * @param pm El paramédico que se quiere guardar
     * @return true si guardó el paramédico, false si ya estaba registrada,
     *         en cuyo caso {@code p} no será guardado.
     */
    boolean guardarParamedico(Paramedico pm);

    /**
     * Obtiene los pacientes registrados en el sistema.
     * @return todos los pacientes
     */
    Collection<IPaciente> consultarPacientes();

    /**
     * Obtiene los médicos registrados en el sistema.
     * @return todos los médicos
     */
    Collection<Medico> consultarMedicos();

    /**
     * Obtiene las enfermeras registradas en el sistema.
     * @return todas las enfermeras
     */
    Collection<Enfermera> consultarEnfermeras();

    /**
     * Obtiene los paramedicos registrados en el sistema.
     * @return todos los paramedicos
     */
    Collection<Paramedico> consultarParamedicos();

}
