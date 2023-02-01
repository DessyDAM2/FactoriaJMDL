package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Gustos", schema = "FactoriaProyectos")
public class entGustos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @Basic
    @Column(name = "Gusto")
    private String gusto;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getGusto() {
        return gusto;
    }

    public void setGusto(String gusto) {
        this.gusto = gusto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entGustos entGustos = (entGustos) o;
        return autoId == entGustos.autoId && idUsuario == entGustos.idUsuario && Objects.equals(gusto, entGustos.gusto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, idUsuario, gusto);
    }
}
