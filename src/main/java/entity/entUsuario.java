package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Usuario", schema = "FactoriaProyectos", catalog = "")
public class entUsuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AUTO_ID")
    private int autoId;
    @Basic
    @Column(name = "ID_CENTRO")
    private int idCentro;
    @Basic
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic
    @Column(name = "Contraseña")
    private String contraseña;
    @Basic
    @Column(name = "Rol")
    private String rol;
    @Basic
    @Column(name = "Puntuacion")
    private Double puntuacion;
    @Basic
    @Column(name = "Familia_Profesional")
    private int familiaProfesional;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Telefono")
    private Integer telefono;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "Escritor", nullable = false)
    private entComentarios comentariosByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false)
    private entGustos gustosByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_Usuario", nullable = false)
    private entParticipantes participantesByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false)
    private entProyectosFav proyectosFavByIdUsuario;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getFamiliaProfesional() {
        return familiaProfesional;
    }

    public void setFamiliaProfesional(int familiaProfesional) {
        this.familiaProfesional = familiaProfesional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entUsuario that = (entUsuario) o;
        return autoId == that.autoId && idCentro == that.idCentro && idUsuario == that.idUsuario && familiaProfesional == that.familiaProfesional && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(contraseña, that.contraseña) && Objects.equals(rol, that.rol) && Objects.equals(puntuacion, that.puntuacion) && Objects.equals(email, that.email) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoId, idCentro, idUsuario, nombre, apellidos, contraseña, rol, puntuacion, familiaProfesional, email, telefono);
    }

    public entComentarios getComentariosByIdUsuario() {
        return comentariosByIdUsuario;
    }

    public void setComentariosByIdUsuario(entComentarios comentariosByIdUsuario) {
        this.comentariosByIdUsuario = comentariosByIdUsuario;
    }

    public entGustos getGustosByIdUsuario() {
        return gustosByIdUsuario;
    }

    public void setGustosByIdUsuario(entGustos gustosByIdUsuario) {
        this.gustosByIdUsuario = gustosByIdUsuario;
    }

    public entParticipantes getParticipantesByIdUsuario() {
        return participantesByIdUsuario;
    }

    public void setParticipantesByIdUsuario(entParticipantes participantesByIdUsuario) {
        this.participantesByIdUsuario = participantesByIdUsuario;
    }

    public entProyectosFav getProyectosFavByIdUsuario() {
        return proyectosFavByIdUsuario;
    }

    public void setProyectosFavByIdUsuario(entProyectosFav proyectosFavByIdUsuario) {
        this.proyectosFavByIdUsuario = proyectosFavByIdUsuario;
    }
}
