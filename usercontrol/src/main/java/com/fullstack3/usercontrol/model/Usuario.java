package com.fullstack3.usercontrol.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity 
@Table(name="usuarios")
public class Usuario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_usuario_seq")
    @SequenceGenerator(name = "cod_usuario_seq", sequenceName = "seq_cod_usuario", allocationSize = 1)
    @Column(name = "cod_usuario", nullable = false, unique = true)
    private Integer cod_usuario;

    @Column(name ="nombre_usuario", nullable = false, length = 100)
    private String nombre_usuario;

    @Column(name ="correo_usuario", nullable = false, length = 100)
    private String correo_usuario;

    @Column(name ="password_usuario", nullable = false, length = 100)
    private String password_usuario;

    @Column(name ="flag_activo", nullable = false)
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
    }

    @PreUpdate
    public void preUpdate() {
        this.fecha_modificacion = LocalDateTime.now();
    }

    public Usuario(Long id_usuario, Integer cod_usuario, String nombre_usuario, String correo_usuario, String password_usuario, Boolean flag_activo, LocalDateTime fecha_creacion, LocalDateTime fecha_modificacion) {
        this.id_usuario = id_usuario;
        this.cod_usuario = cod_usuario;
        this.nombre_usuario = nombre_usuario;
        this.correo_usuario = correo_usuario;
        this.password_usuario = password_usuario;
        this.flag_activo = flag_activo;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
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