package DTO;

import model.roles;

public class UsuarioRolDTO {

    private String nombreUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private String nombreApellidoUsuario;
    private String calleDomicilioUsuario;
    private String numeroDomicilioUsuario;
    private String dniUsuario;
    private String añoNacimientoUsuario;
    private String mesNacimientoUsuario;

    private String diaNacimientoUsuario;
    private String rolUsusario;

    public UsuarioRolDTO(String nombreUsuario, String emailUsuario, String passwordUsuario, String nombreApellidoUsuario, String calleDomicilioUsuario, String numeroDomicilioUsuario, String dniUsuario, String añoNacimientoUsuario, String mesNacimientoUsuario, String diaNacimientoUsuario, String rolUsusario) {
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.nombreApellidoUsuario = nombreApellidoUsuario;
        this.calleDomicilioUsuario = calleDomicilioUsuario;
        this.numeroDomicilioUsuario = numeroDomicilioUsuario;
        this.dniUsuario = dniUsuario;
        this.añoNacimientoUsuario = añoNacimientoUsuario;
        this.mesNacimientoUsuario = mesNacimientoUsuario;
        this.diaNacimientoUsuario = diaNacimientoUsuario;
        this.rolUsusario = rolUsusario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getNombreApellidoUsuario() {
        return nombreApellidoUsuario;
    }

    public void setNombreApellidoUsuario(String nombreApellidoUsuario) {
        this.nombreApellidoUsuario = nombreApellidoUsuario;
    }

    public String getCalleDomicilioUsuario() {
        return calleDomicilioUsuario;
    }

    public void setCalleDomicilioUsuario(String calleDomicilioUsuario) {
        this.calleDomicilioUsuario = calleDomicilioUsuario;
    }

    public String getNumeroDomicilioUsuario() {
        return numeroDomicilioUsuario;
    }

    public void setNumeroDomicilioUsuario(String numeroDomicilioUsuario) {
        this.numeroDomicilioUsuario = numeroDomicilioUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getAñoNacimientoUsuario() {
        return añoNacimientoUsuario;
    }

    public void setAñoNacimientoUsuario(String añoNacimientoUsuario) {
        this.añoNacimientoUsuario = añoNacimientoUsuario;
    }

    public String getMesNacimientoUsuario() {
        return mesNacimientoUsuario;
    }

    public void setMesNacimientoUsuario(String mesNacimientoUsuario) {
        this.mesNacimientoUsuario = mesNacimientoUsuario;
    }

    public String getDiaNacimientoUsuario() {
        return diaNacimientoUsuario;
    }

    public void setDiaNacimientoUsuario(String diaNacimientoUsuario) {
        this.diaNacimientoUsuario = diaNacimientoUsuario;
    }

    public String getRolUsusario() {
        return rolUsusario;
    }

    public void setRolUsusario(String rolUsusario) {
        this.rolUsusario = rolUsusario;
    }


}
