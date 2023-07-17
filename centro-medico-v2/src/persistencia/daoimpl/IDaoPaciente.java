package persistencia.daoimpl;

import modelo.impl.Paciente;
import persistencia.DAO;

import java.util.List;

public interface IDaoPaciente extends DAO<Paciente, String> {

    List<Paciente> consultarPorNombre(String nombre);
}
