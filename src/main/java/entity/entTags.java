package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Tags", schema = "FactoriaProyectos")
public class entTags {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "PROYECTO_ID")
    private int proyectoId;
    @Basic
    @Column(name = "Tag")
    private String tag;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entTags entTags = (entTags) o;
        return autoId == entTags.autoId && proyectoId == entTags.proyectoId && Objects.equals(tag, entTags.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, proyectoId, tag);
    }
}
