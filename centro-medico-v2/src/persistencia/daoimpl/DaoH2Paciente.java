package persistencia.daoimpl;

import modelo.impl.Paciente;
import org.apache.log4j.Logger;
import persistencia.DAO;

import java.sql.*;
import java.util.List;

public class DaoH2Paciente implements IDaoPaciente {

    public static Logger logger = Logger.getLogger(DaoH2Paciente.class);

    @Override
    public List<Paciente> consultarTodos() {
        //[1] cargar el controlador
        try {
            Class.forName("org.h2.Driver");
        }
        catch(ClassNotFoundException ex) {
            logger.error("Error: no se pudo cargar el controlador! " + ex.getMessage());
            System.exit(1);
        }
        //[2] crear la conexión a la base de datos
        //[3] crear un objeto statement a partir de la conexión
        try (Connection conn = DriverManager.getConnection(Constantes.URL, Constantes.USERNAME, Constantes.PSWD);
             Statement stmt = conn.createStatement()){
            //[4] ejecutar la consulta y procesar el ResultSet
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }


        return null;
    }

    @Override
    public Paciente consultarPorId(String s) {
        //[1] cargar el controlador
        //[2] crear la conexión a la base de datos
        //[3] crear un objeto statement a partir de la conexión
        //[4] ejecutar la consulta y procesar el ResultSet
        return null;
    }

    @Override
    public int crear(Paciente o) {
        //[1] cargar el controlador
        //[2] crear la conexión a la base de datos
        //[3] crear un objeto statement a partir de la conexión
        //[4] ejecutar un update con la sentencia insert.
        return 0;
    }

    @Override
    public int actualizar(Paciente o) {
        //[1] cargar el controlador
        //[2] crear la conexión a la base de datos
        //[3] crear un objeto statement a partir de la conexión
        //[4]  ejecutar un update con la sentencia update.
        return 0;
    }

    @Override
    public int eliminar(String s) {
        //[1] cargar el controlador
        //[2] crear la conexión a la base de datos
        //[3] crear un objeto statement a partir de la conexión
        //[4]  ejecutar un update con la sentencia delete.
        return 0;
    }

    @Override
    public List<Paciente> consultarPorNombre(String nombre) {
        return null;
    }
}
