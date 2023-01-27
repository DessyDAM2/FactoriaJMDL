package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ProyectosFav", schema = "FactoriaProyectos", catalog = "")
public class entProyectosFav {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "PROYECTO_ID")
    private int proyectoId;
    @Basic
    @Column(name = "ID_USUARIO")
    private int idUsuario;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entProyectosFav that = (entProyectosFav) o;
        return autoId == that.autoId && proyectoId == that.proyectoId && idUsuario == that.idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, proyectoId, idUsuario);
    }
}
