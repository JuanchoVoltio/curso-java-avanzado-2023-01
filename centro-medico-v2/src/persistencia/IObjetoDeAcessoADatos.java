package persistencia;

import modelo.impl.Medico;

public interface IObjetoDeAcessoADatos { //Data Access Object

    /**
     *
     * @param m El médico que se quiere guardar
     * @return true si guardó el médico, false si el médico ya estaba registrado, en cuyo caso m no será guardado.
     */
    boolean guardarMedico(Medico m);
    //TODO: Completar los otros métodos.
}
