package com.fullstack3.usercontrol.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity 
@Table(name = "usuarios")
public class Usuario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @SequenceGenerator(
        name = "cod_usuario_gen",
        sequenceName = "seq_cod_usuario",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_usuario_gen")
    @Column(name = "cod_usuario", nullable = false, unique = true)
    private Integer cod_usuario;

    @Column(name = "nombre_usuario", nullable = false, length = 100)
    private String nombre_usuario;

    @Column(name = "correo_usuario", nullable = false, length = 100)
    private String correoUsuario;

    @Column(name = "password_usuario", nullable = false, length = 100)
    private String password_usuario;

    @Column(name = "rol_usuario", nullable = false, length = 100)
    private String rol_usuario;

    @Column(name = "flag_activo", nullable = false)
    private Boolean flag_activo;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_modificacion", nullable = true)
    private LocalDateTime fecha_modificacion;

    @PrePersist
    public void prePersist() {
        LocalDateTime ahora = LocalDateTime.now();
        this.fecha_creacion = ahora;
        this.fecha_modificacion = ahora;
        if (this.flag_activo == null) {
            this.flag_activo = true;
        }
        if (this.rol_usuario == null || this.rol_usuario.isBlank()) {
            this.rol_usuario = "USUARIO";
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.fecha_modificacion = LocalDateTime.now();
    }

    public Usuario() {
    }

    public Usuario(Long idUsuario, Integer cod_usuario, String nombre_usuario, String correoUsuario,
                   String password_usuario, String rol_usuario, Boolean flag_activo,
                   LocalDateTime fecha_creacion, LocalDateTime fecha_modificacion) {
        this.idUsuario = idUsuario;
        this.cod_usuario = cod_usuario;
        this.nombre_usuario = nombre_usuario;
        this.correoUsuario = correoUsuario;
        this.password_usuario = password_usuario;
        this.rol_usuario = rol_usuario;
        this.flag_activo = flag_activo;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(Integer cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public String getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    public Boolean getFlag_activo() {
        return flag_activo;
    }

    public void setFlag_activo(Boolean flag_activo) {
        this.flag_activo = flag_activo;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}