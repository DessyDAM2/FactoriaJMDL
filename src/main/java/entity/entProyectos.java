package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Proyectos", schema = "FactoriaProyectos")
public class entProyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "PROYECTO_ID")
    private int proyectoId;
    @Basic
    @Column(name = "Titulo")
    private String titulo;
    @Basic
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic
    @Column(name = "Coordinador")
    private String coordinador;
    @Basic
    @Column(name = "Estado")
    private String estado;
    @Basic
    @Column(name = "Visibilidad")
    private String visibilidad;
    @Basic
    @Column(name = "Visitas")
    private Integer visitas;
    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID", referencedColumnName = "PROYECTO_ID", nullable = false)
    private entCentrosDeProyecto centrosDeProyectoByProyectoId;
    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID", referencedColumnName = "Proyecto_ID", nullable = false)
    private entComentarios comentariosByProyectoId;
    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID", referencedColumnName = "Proyecto_ID", nullable = false)
    private entFamiliaProfesionalImplicada familiaProfesionalImplicadaByProyectoId;
    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID", referencedColumnName = "Proyecto_ID", nullable = false)
    private entParticipantes participantesByProyectoId;
    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID", referencedColumnName = "PROYECTO_ID", nullable = false)
    private entProyectosFav proyectosFavByProyectoId;
    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID", referencedColumnName = "PROYECTO_ID", nullable = false)
    private entTags tagsByProyectoId;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entProyectos that = (entProyectos) o;
        return autoId == that.autoId && proyectoId == that.proyectoId && Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion) && Objects.equals(coordinador, that.coordinador) && Objects.equals(estado, that.estado) && Objects.equals(visibilidad, that.visibilidad) && Objects.equals(visitas, that.visitas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, proyectoId, titulo, descripcion, coordinador, estado, visibilidad, visitas);
    }

    public entCentrosDeProyecto getCentrosDeProyectoByProyectoId() {
        return centrosDeProyectoByProyectoId;
    }

    public void setCentrosDeProyectoByProyectoId(entCentrosDeProyecto centrosDeProyectoByProyectoId) {
        this.centrosDeProyectoByProyectoId = centrosDeProyectoByProyectoId;
    }

    public entComentarios getComentariosByProyectoId() {
        return comentariosByProyectoId;
    }

    public void setComentariosByProyectoId(entComentarios comentariosByProyectoId) {
        this.comentariosByProyectoId = comentariosByProyectoId;
    }

    public entFamiliaProfesionalImplicada getFamiliaProfesionalImplicadaByProyectoId() {
        return familiaProfesionalImplicadaByProyectoId;
    }

    public void setFamiliaProfesionalImplicadaByProyectoId(entFamiliaProfesionalImplicada familiaProfesionalImplicadaByProyectoId) {
        this.familiaProfesionalImplicadaByProyectoId = familiaProfesionalImplicadaByProyectoId;
    }

    public entParticipantes getParticipantesByProyectoId() {
        return participantesByProyectoId;
    }

    public void setParticipantesByProyectoId(entParticipantes participantesByProyectoId) {
        this.participantesByProyectoId = participantesByProyectoId;
    }

    public entProyectosFav getProyectosFavByProyectoId() {
        return proyectosFavByProyectoId;
    }

    public void setProyectosFavByProyectoId(entProyectosFav proyectosFavByProyectoId) {
        this.proyectosFavByProyectoId = proyectosFavByProyectoId;
    }

    public entTags getTagsByProyectoId() {
        return tagsByProyectoId;
    }

    public void setTagsByProyectoId(entTags tagsByProyectoId) {
        this.tagsByProyectoId = tagsByProyectoId;
    }
}
