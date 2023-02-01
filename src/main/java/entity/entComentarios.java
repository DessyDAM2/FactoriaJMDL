package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Comentarios", schema = "FactoriaProyectos")
public class entComentarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "Escritor")
    private int escritor;
    @Basic
    @Column(name = "Proyecto_ID")
    private int proyectoId;
    @Basic
    @Column(name = "Contenido")
    private String contenido;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getEscritor() {
        return escritor;
    }

    public void setEscritor(int escritor) {
        this.escritor = escritor;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entComentarios that = (entComentarios) o;
        return autoId == that.autoId && escritor == that.escritor && proyectoId == that.proyectoId && Objects.equals(contenido, that.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, escritor, proyectoId, contenido);
    }
}
