package model;

import java.util.Date;

public class Usuario {

    private String nombreUsuario;
    private String email;
    private String password;
    private String nombre;
    private Domicilio domicilio;
    private int DNI;
    private Date fechaNacimiento;
    private roles rol;

    public Usuario(String nombreUsuario, String email, String password, String nombre, Domicilio domicilio, int DNI, Date fechaNacimiento, roles rol){
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
    }

    public String getNombreUsuario() { return nombreUsuario; }

    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public Domicilio getDomicilio() { return domicilio; }

    public void setDomicilio(Domicilio domicilio) { this.domicilio = domicilio; }

    public int getDNI() { return DNI; }

    public void setDNI(int DNI) { this.DNI = DNI; }

    public Date getFechaNacimiento() { return fechaNacimiento; }

    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public roles getRol() { return rol; }

    public void setRol(roles rol) { this.rol = rol; }

}
