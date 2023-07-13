package persistencia;

import java.util.List;

public interface DAO<E, ID> {

    List<E> consultarTodos();
    E consultarPorId(ID id);

    int crear(E o);

    int actualizar(E o);

    int eliminar(ID id);
}
