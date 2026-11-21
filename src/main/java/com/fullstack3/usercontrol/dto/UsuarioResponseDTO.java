package com.fullstack3.usercontrol.dto;

import java.time.LocalDateTime;

public class UsuarioResponseDTO {

    private Long idUsuario;
    private Integer codUsuario;
    private String nombreUsuario;
    private String correoUsuario;
    private String rolUsuario;
    private Boolean flagActivo;
    private LocalDateTime fechaCreacion;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long idUsuario, Integer codUsuario, String nombreUsuario,
                              String correoUsuario, String rolUsuario, Boolean flagActivo,
                              LocalDateTime fechaCreacion) {
        this.idUsuario = idUsuario;
        this.codUsuario = codUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.rolUsuario = rolUsuario;
        this.flagActivo = flagActivo;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Boolean getFlagActivo() {
        return flagActivo;
    }

    public void setFlagActivo(Boolean flagActivo) {
        this.flagActivo = flagActivo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}