package com.fullstack3.usercontrol.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity 
@Table(name="usuarios_borrados")
public class UsuarioBorrado {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column (name = "cod_usuario", nullable = false, length = 10)
    private String cod_usuario;

    @Column (name ="nombre_usuario", nullable = false, length = 100)
    private String nombre_usuario;

    @Column (name ="correo_usuario", nullable = false, length = 100)
    private String correo_usuario;

    @Column (name ="password_usuario", nullable = false, length = 100)
    private String password_usuario;

    @Column (name ="flag_activo", nullable = false)
    private Boolean flag_activo;

    @Column (name ="fecha_borrado", nullable = false)
    private LocalDateTime fecha_borrado;

    public UsuarioBorrado(Long id_usuario, String cod_usuario, String nombre_usuario, String correo_usuario, String password_usuario, Boolean flag_activo, LocalDateTime fecha_borrado) {
        this.id_usuario = id_usuario;
        this.cod_usuario = cod_usuario;
        this.nombre_usuario = nombre_usuario;
        this.correo_usuario = correo_usuario;
        this.password_usuario = password_usuario;
        this.flag_activo = flag_activo;
        this.fecha_borrado = fecha_borrado;
    }

    public UsuarioBorrado() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
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

    public LocalDateTime getFecha_borrado() {
        return fecha_borrado;
    }

    public void setFecha_borrado(LocalDateTime fecha_borrado) {
        this.fecha_borrado = fecha_borrado;
    }

    




}