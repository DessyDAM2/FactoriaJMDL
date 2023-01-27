package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CentrosDeProyecto", schema = "FactoriaProyectos", catalog = "")
public class entCentrosDeProyecto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "PROYECTO_ID")
    private int proyectoId;
    @Basic
    @Column(name = "ID_CENTRO")
    private int idCentro;

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

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entCentrosDeProyecto that = (entCentrosDeProyecto) o;
        return autoId == that.autoId && proyectoId == that.proyectoId && idCentro == that.idCentro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, proyectoId, idCentro);
    }
}
