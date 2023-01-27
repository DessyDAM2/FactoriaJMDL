package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "FamiliaProfesional", schema = "FactoriaProyectos", catalog = "")
public class entFamiliaProfesional {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "FAMILIA_PROFESIONAL_ID")
    private int familiaProfesionalId;
    @Basic
    @Column(name = "Nombre_Familia")
    private String nombreFamilia;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getFamiliaProfesionalId() {
        return familiaProfesionalId;
    }

    public void setFamiliaProfesionalId(int familiaProfesionalId) {
        this.familiaProfesionalId = familiaProfesionalId;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entFamiliaProfesional that = (entFamiliaProfesional) o;
        return autoId == that.autoId && familiaProfesionalId == that.familiaProfesionalId && Objects.equals(nombreFamilia, that.nombreFamilia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, familiaProfesionalId, nombreFamilia);
    }
}
