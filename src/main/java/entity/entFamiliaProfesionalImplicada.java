package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "FamiliaProfesionalImplicada", schema = "FactoriaProyectos")
public class entFamiliaProfesionalImplicada {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "Proyecto_ID")
    private int proyectoId;
    @Basic
    @Column(name = "FAMILIA_PROFESIONAL_ID")
    private int familiaProfesionalId;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public int getFamiliaProfesionalId() {
        return familiaProfesionalId;
    }

    public void setFamiliaProfesionalId(int familiaProfesionalId) {
        this.familiaProfesionalId = familiaProfesionalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entFamiliaProfesionalImplicada that = (entFamiliaProfesionalImplicada) o;
        return autoId == that.autoId && proyectoId == that.proyectoId && familiaProfesionalId == that.familiaProfesionalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, proyectoId, familiaProfesionalId);
    }
}
