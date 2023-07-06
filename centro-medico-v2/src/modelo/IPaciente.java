package modelo;

import java.time.LocalDate;

public interface IPaciente {
    long getEdad();

    long getEdad(final LocalDate nowReference);

    LocalDate getFechaNacimiento();

    String getGrupoSanguineo();
}
