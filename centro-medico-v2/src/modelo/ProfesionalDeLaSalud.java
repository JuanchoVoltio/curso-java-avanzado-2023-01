package modelo;

import modelo.IProfesionalDeLaSalud;
import modelo.Persona;

import java.util.Objects;

public abstract class ProfesionalDeLaSalud extends Persona implements IProfesionalDeLaSalud {

    private Integer id;

    public ProfesionalDeLaSalud(String dni, String nombre, String telefono, Integer id) {
        super(dni, nombre, telefono);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfesionalDeLaSalud)) return false;
        if (!super.equals(o)) return false;
        ProfesionalDeLaSalud that = (ProfesionalDeLaSalud) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }


}
