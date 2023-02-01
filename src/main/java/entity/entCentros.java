package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Centros", schema = "FactoriaProyectos")
public class entCentros {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "ID_CENTRO")
    private int idCentro;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Web")
    private String web;
    @Basic
    @Column(name = "Contacto")
    private String contacto;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO", referencedColumnName = "ID_CENTRO", nullable = false)
    private entCentrosDeProyecto centrosDeProyectoByIdCentro;
    @ManyToOne
    @JoinColumn(name = "ID_CENTRO", referencedColumnName = "ID_CENTRO", nullable = false)
    private entUsuario usuarioByIdCentro;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entCentros that = (entCentros) o;
        return autoId == that.autoId && idCentro == that.idCentro && Objects.equals(nombre, that.nombre) && Objects.equals(web, that.web) && Objects.equals(contacto, that.contacto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, idCentro, nombre, web, contacto);
    }

    public entCentrosDeProyecto getCentrosDeProyectoByIdCentro() {
        return centrosDeProyectoByIdCentro;
    }

    public void setCentrosDeProyectoByIdCentro(entCentrosDeProyecto centrosDeProyectoByIdCentro) {
        this.centrosDeProyectoByIdCentro = centrosDeProyectoByIdCentro;
    }

    public entUsuario getUsuarioByIdCentro() {
        return usuarioByIdCentro;
    }

    public void setUsuarioByIdCentro(entUsuario usuarioByIdCentro) {
        this.usuarioByIdCentro = usuarioByIdCentro;
    }
}
